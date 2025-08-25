package ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CheckFraudBean;
import bean.ReportPersonBean;
import bean.ReportZPEleBean;
import bean.SocialAccBean;
import bean.SocialTypeBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;
import manager.BaseDialog;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.TradFraudView;
import ui.presenter.TradFraudPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class TradFraudActivity extends BaseActivity implements TradFraudView {
    private static final String FINATYPE = "其他类型";
    private BaseDialog dlg;
    private ReportZPEleBean info;

    @BindView(R.id.et_case_describe)
    EditText mEtCaseDescribe;

    @BindView(R.id.et_tag_other)
    EditText mEtTagOther;
    private TagFlowLayout mFlowLayout;
    private TradFraudPresenter mPresenter;

    @BindView(R.id.region)
    TextView mRegion;

    @BindView(R.id.rl_other_acc)
    View mRlOtherAcc;

    @BindView(R.id.tv_account_name)
    TextView mTvAccName;

    @BindView(R.id.trad_fraud_num)
    TextView mTvAccNum;

    @BindView(R.id.tv_dupery_type)
    TextView mTvDuperyType;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private int selectIndex;
    private SocialTypeBean tagBean;
    private com.zhy.view.flowlayout.b mTagAdapter = null;
    private List<SocialTypeBean> socialTypeBeans = new ArrayList();
    private SocialTypeBean otherType = new SocialTypeBean(FINATYPE);
    public CheckFraudBean mCheckFraudBean = null;
    private int mDefraudCode = -1;

    class a extends com.zhy.view.flowlayout.b<SocialTypeBean> {
        a(List list) {
            super(list);
        }

        @Override // com.zhy.view.flowlayout.b
        public View a(FlowLayout flowLayout, int i2, SocialTypeBean socialTypeBean) {
            TextView textView = (TextView) LayoutInflater.from(TradFraudActivity.this.mActivity).inflate(R.layout.tag_flow_trad, (ViewGroup) TradFraudActivity.this.mFlowLayout, false);
            textView.setText(((SocialTypeBean) TradFraudActivity.this.socialTypeBeans.get(i2)).getText());
            textView.setTextColor(TradFraudActivity.this.getResources().getColorStateList(R.color.text_choose_one));
            return textView;
        }
    }

    private void disDlog() {
        BaseDialog baseDialog = this.dlg;
        if (baseDialog == null || !baseDialog.isShowing()) {
            return;
        }
        this.dlg.dismiss();
    }

    private void getIntentData() {
        this.mCheckFraudBean = (CheckFraudBean) getIntent().getSerializableExtra(util.k1.m0);
        CheckFraudBean checkFraudBean = this.mCheckFraudBean;
        if (checkFraudBean != null) {
            this.mTvAccNum.setText(checkFraudBean.getContent());
        }
    }

    private void showTagData() {
        this.mTagAdapter.c();
        if (this.socialTypeBeans.size() <= 0 || this.tagBean == null) {
            return;
        }
        this.tagBean = this.socialTypeBeans.get(this.selectIndex);
        this.mTagAdapter.a(this.selectIndex);
        this.mTvAccName.setText(this.tagBean.getText());
    }

    private void submitReport() {
        String str = getmRegionId();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String string = this.mRegion.getText().toString();
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        String string2 = this.mTvDuperyType.getText().toString();
        if (TextUtils.isEmpty(string2)) {
            string2 = "";
        }
        String string3 = this.mEtCaseDescribe.getText().toString();
        String str2 = TextUtils.isEmpty(string3) ? "" : string3;
        ReportPersonBean reportPersonBean = new ReportPersonBean();
        reportPersonBean.setReportDic(str);
        reportPersonBean.setReportAdd(string);
        reportPersonBean.setDupery(string2);
        reportPersonBean.setDefraudType(this.mDefraudCode);
        reportPersonBean.setCaseDis(str2);
        String string4 = this.mRlOtherAcc.isShown() ? this.mEtTagOther.getText().toString() : this.tagBean.getText();
        SocialAccBean socialAccBean = new SocialAccBean();
        socialAccBean.setAccountName(string4);
        socialAccBean.setAccountNum(this.mTvAccNum.getText().toString());
        this.mPresenter.oneKeyReportTrad(socialAccBean, reportPersonBean);
    }

    public /* synthetic */ void a(View view) {
        this.dlg.dismiss();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("添加诈骗交易账户");
        this.mPresenter = new TradFraudPresenter(this.mActivity, this);
        SwipBackLayout.a(this.mActivity).a();
        getIntentData();
        this.mPresenter.getSocialTags();
    }

    protected void initTagAdapter() {
        this.mTagAdapter = new a(this.socialTypeBeans);
        this.mFlowLayout.setAdapter(this.mTagAdapter);
        this.mFlowLayout.setOnTagClickListener(new TagFlowLayout.c() { // from class: ui.activity.h1
            @Override // com.zhy.view.flowlayout.TagFlowLayout.c
            public final boolean a(View view, int i2, FlowLayout flowLayout) {
                return this.f19431a.a(view, i2, flowLayout);
            }
        });
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @Override // ui.callview.TradFraudView
    public void onErrorRequest() {
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.c2.a aVar) {
        if (aVar == null || aVar.a() != 3) {
            return;
        }
        this.info = (ReportZPEleBean) aVar.b();
        ReportZPEleBean reportZPEleBean = this.info;
        if (reportZPEleBean != null) {
            this.mTvDuperyType.setText(reportZPEleBean.getName());
            this.mDefraudCode = this.info.getCode();
        }
    }

    @Override // ui.callview.TradFraudView
    public void onSuccessRequest(List<SocialTypeBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.socialTypeBeans.clear();
        list.add(this.otherType);
        this.socialTypeBeans.addAll(list);
    }

    @OnClick({R.id.iv_back, R.id.tv_account_name, R.id.tv_dupery_type, R.id.region, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296395 */:
                if (!TextUtils.isEmpty(this.mTvAccName.getText().toString())) {
                    if (!this.mRlOtherAcc.isShown() || !TextUtils.isEmpty(this.mEtTagOther.getText().toString())) {
                        if (!TextUtils.isEmpty(this.mTvDuperyType.getText().toString())) {
                            submitReport();
                            break;
                        } else {
                            util.w1.a("请选择诈骗类型");
                            break;
                        }
                    } else {
                        util.w1.a("请输入其他账户类型");
                        break;
                    }
                } else {
                    util.w1.a("请选择账户类型");
                    break;
                }
                break;
            case R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case R.id.region /* 2131297159 */:
                regionShow(this.mRegion, this.mActivity);
                break;
            case R.id.tv_account_name /* 2131297399 */:
                showTagDlag();
                break;
            case R.id.tv_dupery_type /* 2131297542 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) TagFlowLaoutActivity.class);
                ReportZPEleBean reportZPEleBean = this.info;
                if (reportZPEleBean != null) {
                    intent.putExtra(util.k1.O, reportZPEleBean);
                }
                startActivity(intent);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_trad_fraud;
    }

    public void showTagDlag() {
        this.dlg = new BaseDialog(this.mActivity, R.style.base_dialog_style);
        this.dlg.setContentView(R.layout.layout_trad_type);
        this.dlg.setGravityLayout(0);
        this.dlg.setWidthDialog(-2.0d);
        this.dlg.setHeightDialogdp(-2.0f);
        this.dlg.setCancelable(false);
        this.dlg.setCanceledOnTouchOutside(false);
        this.dlg.initOnCreate();
        this.dlg.show();
        ImageView imageView = (ImageView) this.dlg.findViewById(R.id.cancle);
        this.mFlowLayout = (TagFlowLayout) this.dlg.findViewById(R.id.flow_layout);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ui.activity.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19434a.a(view);
            }
        });
        initTagAdapter();
        showTagData();
    }

    public /* synthetic */ boolean a(View view, int i2, FlowLayout flowLayout) {
        if (TextUtils.equals(FINATYPE, this.socialTypeBeans.get(i2).getText())) {
            this.mRlOtherAcc.setVisibility(0);
        } else {
            this.mRlOtherAcc.setVisibility(8);
        }
        this.selectIndex = i2;
        this.tagBean = this.socialTypeBeans.get(i2);
        this.mTvAccName.setText(this.tagBean.getText());
        disDlog();
        return true;
    }
}
