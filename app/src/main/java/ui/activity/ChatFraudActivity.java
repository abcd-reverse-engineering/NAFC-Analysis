package ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import bean.CheckFraudBean;
import bean.ReportPersonBean;
import bean.ReportZPEleBean;
import bean.SocialAccBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.tencent.connect.common.Constants;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.ChatFraudView;
import ui.presenter.ChatFraudPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class ChatFraudActivity extends BaseActivity implements ChatFraudView {
    private static final String FINATYPE = "其他类型";
    private ReportZPEleBean info;

    @BindView(R.id.et_case_describe)
    EditText mEtCaseDescribe;
    private ChatFraudPresenter mPresenter;

    @BindView(R.id.rb_qq)
    RadioButton mRbQQ;

    @BindView(R.id.rb_wx)
    RadioButton mRbWx;

    @BindView(R.id.region)
    TextView mRegion;

    @BindView(R.id.rg_chat)
    RadioGroup mRgChat;

    @BindView(R.id.trad_fraud_num)
    TextView mTvAccNum;

    @BindView(R.id.tv_dupery_type)
    TextView mTvDuperyType;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private String accType = "微信";
    public CheckFraudBean mCheckFraudBean = null;
    private int mDefraudCode = -1;

    class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i2) {
            if (i2 == R.id.rb_wx) {
                ChatFraudActivity.this.accType = "微信";
            } else {
                ChatFraudActivity.this.accType = Constants.SOURCE_QQ;
            }
        }
    }

    private void getIntentData() {
        this.mCheckFraudBean = (CheckFraudBean) getIntent().getSerializableExtra(util.k1.m0);
        CheckFraudBean checkFraudBean = this.mCheckFraudBean;
        if (checkFraudBean != null) {
            this.mTvAccNum.setText(checkFraudBean.getContent());
            int type = this.mCheckFraudBean.getType();
            if (type == 2) {
                this.accType = "微信";
                this.mRbWx.setChecked(true);
            } else if (type == 3) {
                this.accType = Constants.SOURCE_QQ;
                this.mRbQQ.setChecked(true);
            } else if (type == 5) {
                this.accType = "微信";
                this.mRbWx.setChecked(true);
            }
        }
        this.mRgChat.setOnCheckedChangeListener(new a());
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
        SocialAccBean socialAccBean = new SocialAccBean();
        socialAccBean.setAccountName(this.accType);
        socialAccBean.setAccountNum(this.mTvAccNum.getText().toString());
        this.mPresenter.oneKeyReportTrad(socialAccBean, reportPersonBean);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("一键举报社交账号");
        this.mPresenter = new ChatFraudPresenter(this.mActivity, this);
        SwipBackLayout.a(this.mActivity).a();
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
        this.info = (ReportZPEleBean) aVar.b();
        ReportZPEleBean reportZPEleBean = this.info;
        if (reportZPEleBean != null) {
            this.mTvDuperyType.setText(reportZPEleBean.getName());
            this.mDefraudCode = this.info.getCode();
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
        return R.layout.activity_chat_fraud;
    }
}
