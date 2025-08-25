package ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bean.QABean;
import bean.QATypeBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.tools.AnimUtils;
import java.util.List;
import ui.callview.FeedbackHelpCallView;
import ui.presenter.FeedbackHelpPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class FeedbackHelpActivity extends BaseActivity implements FeedbackHelpCallView {
    public static final String EXTRA_ANSWER = "extra_answer";
    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_QUESTION = "extra_question";

    @BindView(R.id.ll_qa_content)
    LinearLayout mLlQaContent;
    private FeedbackHelpPresenter mPresenter;
    private List<QATypeBean> mQAList = null;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QABean f18151a;

        a(QABean qABean) {
            this.f18151a = qABean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedbackHelpActivity.this.intentDetail(this.f18151a);
        }
    }

    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QABean f18153a;

        b(QABean qABean) {
            this.f18153a = qABean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedbackHelpActivity.this.intentDetail(this.f18153a);
        }
    }

    class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QABean f18155a;

        c(QABean qABean) {
            this.f18155a = qABean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedbackHelpActivity.this.intentDetail(this.f18155a);
        }
    }

    class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinearLayout f18157a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f18158b;

        d(LinearLayout linearLayout, ImageView imageView) {
            this.f18157a = linearLayout;
            this.f18158b = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f18157a.getVisibility() == 8) {
                this.f18157a.setVisibility(0);
                AnimUtils.rotateArrowUpOrDown(this.f18158b, false);
            } else {
                this.f18157a.setVisibility(8);
                AnimUtils.rotateArrowUpOrDown(this.f18158b, true);
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FeedbackHelpActivity.this.initQAView();
        }
    }

    private void addView(QATypeBean qATypeBean, boolean z) throws Exception {
        ViewGroup viewGroup = null;
        View viewInflate = View.inflate(this, R.layout.item_qa, null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_type);
        TextView textView = (TextView) viewInflate.findViewById(R.id.type_name);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_type_arrow);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_content_1);
        View viewFindViewById = viewInflate.findViewById(R.id.inc_content_2);
        int i2 = R.id.tv_content;
        TextView textView3 = (TextView) viewFindViewById.findViewById(R.id.tv_content);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.tv_content_more);
        View viewFindViewById2 = viewInflate.findViewById(R.id.botton_line);
        if (qATypeBean.getQaList() != null && qATypeBean.getQaList().size() > 0) {
            int i3 = 0;
            while (i3 < qATypeBean.getQaList().size()) {
                QABean qABean = qATypeBean.getQaList().get(i3);
                if (i3 == 0) {
                    textView2.setText(qABean.getQuestion());
                    textView2.setOnClickListener(new a(qABean));
                } else if (i3 == 1) {
                    String question = qABean.getQuestion();
                    if (TextUtils.isEmpty(question)) {
                        viewFindViewById.setVisibility(8);
                    } else {
                        textView3.setText(question);
                        textView3.setOnClickListener(new b(qABean));
                    }
                } else {
                    View viewInflate2 = View.inflate(this, R.layout.layout_qa, viewGroup);
                    TextView textView4 = (TextView) viewInflate2.findViewById(i2);
                    textView4.setText(qABean.getQuestion());
                    textView4.setOnClickListener(new c(qABean));
                    linearLayout2.addView(viewInflate2);
                }
                i3++;
                viewGroup = null;
                i2 = R.id.tv_content;
            }
        }
        textView.setText(qATypeBean.getText());
        linearLayout.setOnClickListener(new d(linearLayout2, imageView));
        if (z) {
            viewFindViewById2.setVisibility(4);
        }
        linearLayout2.setVisibility(0);
        this.mLlQaContent.addView(viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initQAView() {
        try {
            if (this.mQAList != null && this.mQAList.size() > 0) {
                int i2 = 0;
                while (i2 < this.mQAList.size()) {
                    int i3 = i2 + 1;
                    addView(this.mQAList.get(i2), i3 == this.mQAList.size());
                    i2 = i3;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentDetail(QABean qABean) {
        if (isDouble()) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) FeedbackDetailActivity.class);
        intent.putExtra(EXTRA_ID, qABean.getId());
        intent.putExtra(EXTRA_QUESTION, qABean.getQuestion());
        intent.putExtra(EXTRA_ANSWER, qABean.getAnswer());
        startActivity(intent);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("反馈与帮助");
        this.mPresenter = new FeedbackHelpPresenter(this.mActivity, this);
        this.mPresenter.getQAList();
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // ui.callview.FeedbackHelpCallView
    public void onSuccessRequest(List<QATypeBean> list) {
        this.mQAList = list;
        this.mLlQaContent.post(new e());
    }

    @OnClick({R.id.iv_back, R.id.tv_feedback})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            finish();
        } else {
            if (id != R.id.tv_feedback) {
                return;
            }
            startActivity(new Intent(this, (Class<?>) FeedbackActivity.class));
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_feedback_help;
    }
}
