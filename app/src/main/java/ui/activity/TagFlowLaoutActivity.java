package ui.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bean.ReportZPBean;
import bean.ReportZPEleBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.xiaomi.mipush.sdk.Constants;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;
import ui.callview.TagFlowLayoutCallView;
import ui.presenter.TagFlowLayoutPresenter;
import ui.view.MyScrollView;

/* loaded from: classes2.dex */
public class TagFlowLaoutActivity extends BaseActivity implements TagFlowLayoutCallView {
    public static final int CASE_PAGE = 2;
    public static final int DK_PAGE = 1;
    private int childPost = 0;
    protected List<ReportZPBean> mFlowString = new ArrayList();

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.ll_network_no)
    View mLlNetworkNo;

    @BindView(R.id.ll_praent)
    LinearLayout mLlPraent;
    TagFlowLayoutPresenter mPresenter;
    private com.zhy.view.flowlayout.b mTagAdapter;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.myScrollView)
    MyScrollView myScrollView;
    private int pageType;
    private ReportZPEleBean tagBean;

    class a extends com.zhy.view.flowlayout.b<ReportZPEleBean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TagFlowLayout f19095d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, TagFlowLayout tagFlowLayout) {
            super(list);
            this.f19095d = tagFlowLayout;
        }

        @Override // com.zhy.view.flowlayout.b
        public View a(FlowLayout flowLayout, int i2, ReportZPEleBean reportZPEleBean) {
            TextView textView = (TextView) LayoutInflater.from(TagFlowLaoutActivity.this.mActivity).inflate(R.layout.tag_flow_item, (ViewGroup) this.f19095d, false);
            textView.setText(reportZPEleBean.getName());
            textView.setTextColor(TagFlowLaoutActivity.this.getResources().getColorStateList(R.color.text_choose_one));
            if (TagFlowLaoutActivity.this.tagBean != null) {
                if (TagFlowLaoutActivity.this.pageType == 2) {
                    if (TagFlowLaoutActivity.this.tagBean.getId() == reportZPEleBean.getId()) {
                        TagFlowLaoutActivity.this.childPost = i2;
                        TagFlowLaoutActivity.this.mTagAdapter = this;
                    }
                } else if (TagFlowLaoutActivity.this.tagBean.getCode() == reportZPEleBean.getCode()) {
                    TagFlowLaoutActivity.this.childPost = i2;
                    TagFlowLaoutActivity.this.mTagAdapter = this;
                }
            }
            return textView;
        }
    }

    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TagFlowLayout f19097a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f19098b;

        b(TagFlowLayout tagFlowLayout, ImageView imageView) {
            this.f19097a = tagFlowLayout;
            this.f19098b = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f19097a.getTag() == null || !((Boolean) this.f19097a.getTag()).booleanValue()) {
                this.f19097a.setVisibility(0);
                this.f19097a.setTag(true);
                this.f19098b.setImageResource(R.drawable.iv_tag_ar_up);
            } else {
                this.f19097a.setVisibility(8);
                this.f19097a.setTag(false);
                this.f19098b.setImageResource(R.drawable.iv_tag_ar_down);
            }
        }
    }

    private void getIntentData() {
        try {
            this.tagBean = (ReportZPEleBean) getIntent().getSerializableExtra(util.k1.O);
            this.pageType = getIntent().getIntExtra(util.k1.f20846d, 0);
        } catch (Exception unused) {
        }
    }

    private boolean networkStateDeal() {
        if (util.q1.f()) {
            this.mLlNetworkNo.setVisibility(8);
            this.myScrollView.setVisibility(0);
            return true;
        }
        this.mLlNetworkNo.setVisibility(0);
        this.myScrollView.setVisibility(8);
        return false;
    }

    public /* synthetic */ boolean a(com.zhy.view.flowlayout.b bVar, ReportZPBean reportZPBean, View view, int i2, FlowLayout flowLayout) {
        bVar.a(i2);
        ReportZPEleBean reportZPEleBean = reportZPBean.getChildren().get(i2);
        if (this.pageType == 2) {
            reportZPEleBean.setName(reportZPBean.getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + reportZPEleBean.getName());
        }
        org.greenrobot.eventbus.c.f().d(new util.c2.a(3, reportZPEleBean));
        finish();
        return true;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("诈骗类型");
        this.mPresenter = new TagFlowLayoutPresenter(this, this);
        getIntentData();
        this.mPresenter.getReportMarkData(this.pageType);
    }

    protected void initTagAdapter(final ReportZPBean reportZPBean, int i2) {
        View viewInflate = LayoutInflater.from(this.mActivity).inflate(R.layout.layout_tag_flow, (ViewGroup) null, false);
        this.mLlPraent.addView(viewInflate);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_div_bg);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tag_title);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_arrow);
        TagFlowLayout tagFlowLayout = (TagFlowLayout) viewInflate.findViewById(R.id.flow_layout);
        textView2.setText(reportZPBean.getName());
        if (i2 % 4 == 0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        if (reportZPBean.getChildren() == null || reportZPBean.getChildren().size() == 0) {
            ArrayList arrayList = new ArrayList();
            ReportZPEleBean reportZPEleBean = new ReportZPEleBean();
            reportZPEleBean.setId(reportZPBean.getId());
            reportZPEleBean.setCode(reportZPBean.getCode());
            reportZPEleBean.setName(reportZPBean.getName());
            reportZPEleBean.setClusterID(reportZPBean.getClusterID());
            reportZPEleBean.setParentClusterID(reportZPBean.getParentClusterID());
            reportZPEleBean.setIsShow(reportZPBean.getIsShow());
            reportZPEleBean.setSort(reportZPBean.getSort());
            reportZPEleBean.setTopClass(reportZPBean.getTopClass());
            arrayList.add(reportZPEleBean);
            reportZPBean.setChildren(arrayList);
        }
        final a aVar = new a(reportZPBean.getChildren(), tagFlowLayout);
        tagFlowLayout.setAdapter(aVar);
        tagFlowLayout.setOnTagClickListener(new TagFlowLayout.c() { // from class: ui.activity.f1
            @Override // com.zhy.view.flowlayout.TagFlowLayout.c
            public final boolean a(View view, int i3, FlowLayout flowLayout) {
                return this.f19423a.a(aVar, reportZPBean, view, i3, flowLayout);
            }
        });
        List<ReportZPEleBean> children = reportZPBean.getChildren();
        if (this.pageType == 2) {
            for (int i3 = 0; i3 < children.size(); i3++) {
                ReportZPEleBean reportZPEleBean2 = this.tagBean;
                if (reportZPEleBean2 != null && reportZPEleBean2.getId() == children.get(i3).getId()) {
                    tagFlowLayout.setVisibility(0);
                    tagFlowLayout.setTag(true);
                    imageView.setImageResource(R.drawable.iv_tag_ar_up);
                }
            }
        } else {
            for (int i4 = 0; i4 < children.size(); i4++) {
                ReportZPEleBean reportZPEleBean3 = this.tagBean;
                if (reportZPEleBean3 != null && reportZPEleBean3.getCode() == children.get(i4).getCode()) {
                    tagFlowLayout.setVisibility(0);
                    tagFlowLayout.setTag(true);
                    imageView.setImageResource(R.drawable.iv_tag_ar_up);
                }
            }
        }
        imageView.setOnClickListener(new b(tagFlowLayout, imageView));
        aVar.c();
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        networkStateDeal();
    }

    @Override // ui.callview.TagFlowLayoutCallView
    public void onSuccessRequest(List<ReportZPBean> list) {
        com.zhy.view.flowlayout.b bVar;
        this.mLlNetworkNo.setVisibility(8);
        this.myScrollView.setVisibility(0);
        this.mFlowString.clear();
        this.mFlowString.addAll(list);
        for (int i2 = 0; i2 < this.mFlowString.size(); i2++) {
            initTagAdapter(this.mFlowString.get(i2), i2);
        }
        if (this.tagBean == null || (bVar = this.mTagAdapter) == null) {
            return;
        }
        bVar.a(this.childPost);
    }

    @OnClick({R.id.iv_back, R.id.ll_network_no})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            finish();
        } else {
            if (id != R.id.ll_network_no) {
                return;
            }
            this.mPresenter.getReportMarkData(this.pageType);
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_tagflow;
    }
}
