package ui.activity;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bean.SocialAccBean;
import bean.SocialTypeBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;
import ui.callview.SocialTagsCallView;
import ui.presenter.SocialAccEditPresenter;

/* loaded from: classes2.dex */
public class SocialAccountEditActivity extends BaseActivity implements SocialTagsCallView {
    private static final String FINATYPE = "其他类型";

    /* renamed from: bean, reason: collision with root package name */
    private SocialAccBean f19065bean;

    @BindView(R.id.et_account)
    TextView mEtAccount;

    @BindView(R.id.et_account_other)
    TextView mEtAccountOther;

    @BindView(R.id.et_tag_other)
    TextView mEtTagOther;

    @BindView(R.id.flow_layout)
    TagFlowLayout mFlowLayout;

    @BindView(R.id.ll_acc_nomar)
    View mLlAccNorm;

    @BindView(R.id.ll_acc_other)
    View mLlAccOther;
    private SocialAccEditPresenter mPresenter;

    @BindView(R.id.tv_acc_name)
    TextView mTvAccName;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private int pos;
    private int selectIndex;
    private com.zhy.view.flowlayout.b mTagAdapter = null;
    private List<SocialTypeBean> socialTypeBeans = new ArrayList();
    private SocialTypeBean otherType = new SocialTypeBean(FINATYPE);

    class a extends com.zhy.view.flowlayout.b<SocialTypeBean> {
        a(List list) {
            super(list);
        }

        @Override // com.zhy.view.flowlayout.b
        public View a(FlowLayout flowLayout, int i2, SocialTypeBean socialTypeBean) {
            TextView textView = (TextView) LayoutInflater.from(SocialAccountEditActivity.this.mActivity).inflate(R.layout.tag_flow, (ViewGroup) SocialAccountEditActivity.this.mFlowLayout, false);
            textView.setText(((SocialTypeBean) SocialAccountEditActivity.this.socialTypeBeans.get(i2)).getText());
            textView.setTextColor(SocialAccountEditActivity.this.getResources().getColorStateList(R.color.text_choose_one));
            return textView;
        }
    }

    private int contains(List<SocialTypeBean> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (TextUtils.equals(list.get(i2).getText(), str)) {
                return i2;
            }
        }
        return -10;
    }

    private void getIntentData() {
        this.pos = getIntent().getIntExtra(util.k1.v, 0);
        this.f19065bean = (SocialAccBean) getIntent().getSerializableExtra(util.k1.w);
    }

    public /* synthetic */ boolean a(View view, int i2, FlowLayout flowLayout) {
        if (TextUtils.equals(FINATYPE, this.socialTypeBeans.get(i2).getText())) {
            this.mLlAccOther.setVisibility(0);
            this.mLlAccNorm.setVisibility(8);
        } else {
            this.mLlAccOther.setVisibility(8);
            this.mLlAccNorm.setVisibility(0);
        }
        this.selectIndex = i2;
        this.mTvAccName.setText(this.socialTypeBeans.get(i2).getText() + "账号");
        return true;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("添加诈骗社交账号");
        this.mPresenter = new SocialAccEditPresenter(this.mActivity, this);
        getIntentData();
        initTagAdapter();
        this.mPresenter.getSocialTags();
    }

    protected void initTagAdapter() {
        this.mTagAdapter = new a(this.socialTypeBeans);
        this.mFlowLayout.setAdapter(this.mTagAdapter);
        this.mFlowLayout.setOnTagClickListener(new TagFlowLayout.c() { // from class: ui.activity.e1
            @Override // com.zhy.view.flowlayout.TagFlowLayout.c
            public final boolean a(View view, int i2, FlowLayout flowLayout) {
                return this.f19420a.a(view, i2, flowLayout);
            }
        });
    }

    @Override // ui.callview.SocialTagsCallView
    public void onErrorRequest() {
    }

    @Override // ui.callview.SocialTagsCallView
    public void onSuccessRequest(List<SocialTypeBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.socialTypeBeans.clear();
        list.add(this.otherType);
        this.socialTypeBeans.addAll(list);
        this.mTagAdapter.c();
        SocialAccBean socialAccBean = this.f19065bean;
        if (socialAccBean == null) {
            this.selectIndex = 0;
            this.mTagAdapter.a(0);
            this.mTvAccName.setText(list.get(0).getText() + "账号");
            return;
        }
        int iContains = contains(list, socialAccBean.getAccountName());
        if (iContains >= 0) {
            this.selectIndex = iContains;
            this.mTvAccName.setText(this.f19065bean.getAccountName());
            this.mEtAccount.setText(this.f19065bean.getAccountNum());
            this.mTagAdapter.a(this.selectIndex);
            return;
        }
        this.selectIndex = list.size() - 1;
        this.mLlAccOther.setVisibility(0);
        this.mLlAccNorm.setVisibility(8);
        this.mEtTagOther.setText(this.f19065bean.getAccountName());
        this.mEtAccountOther.setText(this.f19065bean.getAccountNum());
        this.mTagAdapter.a(this.selectIndex);
    }

    @OnClick({R.id.iv_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        String text;
        String string;
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_commit) {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
            return;
        }
        if (this.socialTypeBeans.size() > 0) {
            if (TextUtils.equals(FINATYPE, this.socialTypeBeans.get(this.selectIndex).getText())) {
                text = this.mEtTagOther.getText().toString();
                if (TextUtils.isEmpty(text)) {
                    util.w1.a("社交类型不能为空");
                    return;
                }
                string = this.mEtAccountOther.getText().toString();
                if (TextUtils.isEmpty(string)) {
                    util.w1.a("社交账号不能为空");
                    return;
                }
            } else {
                text = this.socialTypeBeans.get(this.selectIndex).getText();
                string = this.mEtAccount.getText().toString();
                if (TextUtils.isEmpty(string)) {
                    util.w1.a("社交账号不能为空");
                    return;
                }
            }
            SocialAccBean socialAccBean = new SocialAccBean();
            socialAccBean.setAccountName(text);
            socialAccBean.setAccountNum(string);
            if (this.f19065bean != null) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(15, socialAccBean, Integer.valueOf(this.pos)));
            } else {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(14, socialAccBean));
            }
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_social_acc_edit;
    }
}
