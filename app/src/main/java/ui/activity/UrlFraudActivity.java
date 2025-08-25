package ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import bean.CheckFraudBean;
import bean.ReportPersonBean;
import bean.ReportZPEleBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import org.greenrobot.eventbus.ThreadMode;
import ui.presenter.UrlFraudPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class UrlFraudActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    private UrlFraudPresenter f19147a;

    /* renamed from: c, reason: collision with root package name */
    private ReportZPEleBean f19149c;

    @BindView(R.id.et_case_describe)
    EditText mEtCaseDescribe;

    @BindView(R.id.fraud_num)
    TextView mFraudNum;

    @BindView(R.id.region)
    TextView mRegion;

    @BindView(R.id.tv_dupery_type)
    TextView mTvDuperyType;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: b, reason: collision with root package name */
    public CheckFraudBean f19148b = null;

    /* renamed from: d, reason: collision with root package name */
    private int f19150d = -1;

    private void getIntentData() {
        this.f19148b = (CheckFraudBean) getIntent().getSerializableExtra(util.k1.m0);
        CheckFraudBean checkFraudBean = this.f19148b;
        if (checkFraudBean != null) {
            this.mFraudNum.setText(checkFraudBean.getContent());
        }
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
        reportPersonBean.setDefraudType(this.f19150d);
        reportPersonBean.setCaseDis(str2);
        this.f19147a.oneKeyReportUrl(this.mFraudNum.getText().toString(), reportPersonBean);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("一键举报IP/网址");
        SwipBackLayout.a(this.mActivity).a();
        this.f19147a = new UrlFraudPresenter(this.mActivity);
        getIntentData();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.c2.a aVar) {
        if (aVar == null || aVar.a() != 3) {
            return;
        }
        this.f19149c = (ReportZPEleBean) aVar.b();
        ReportZPEleBean reportZPEleBean = this.f19149c;
        if (reportZPEleBean != null) {
            this.mTvDuperyType.setText(reportZPEleBean.getName());
            this.f19150d = this.f19149c.getCode();
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_dupery_type, R.id.region, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296395 */:
                if (!TextUtils.isEmpty(this.mTvDuperyType.getText().toString())) {
                    submitReport();
                    break;
                } else {
                    util.w1.a("请选择诈骗类型");
                    break;
                }
            case R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case R.id.region /* 2131297159 */:
                regionShow(this.mRegion, this.mActivity);
                break;
            case R.id.tv_dupery_type /* 2131297542 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) TagFlowLaoutActivity.class);
                ReportZPEleBean reportZPEleBean = this.f19149c;
                if (reportZPEleBean != null) {
                    intent.putExtra(util.k1.O, reportZPEleBean);
                }
                startActivity(intent);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_url_fraud;
    }
}
