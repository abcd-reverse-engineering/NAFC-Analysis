package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import b.a.a.e.d;
import bean.AccountListBean;
import bean.CaseDivisonBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.xiaomi.mipush.sdk.Constants;
import interfaces.IClickListener;
import java.util.Calendar;
import ui.Hicore;
import util.y1;

/* loaded from: classes2.dex */
public class PayStopAddActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    private String f18438a;

    /* renamed from: b, reason: collision with root package name */
    private AccountListBean f18439b;

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.et_suspect_account)
    EditText mEtSuspectAccount;

    @BindView(R.id.et_suspect_account_name)
    EditText mEtSuspectAccountName;

    @BindView(R.id.et_transfer_money)
    EditText mEtTransMoy;

    @BindView(R.id.tv_suspect_type)
    TextView mTvSuspectType;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.tv_time)
    TextView mTvTransTime;

    class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            PayStopAddActivity.this.finish();
        }
    }

    class b implements d.m {
        b() {
        }

        @Override // b.a.a.e.d.m
        public void a(String str, String str2, String str3, String str4, String str5) {
            PayStopAddActivity.this.mTvTransTime.setText(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + c.c.a.b.a.a.f3100g + str4 + Constants.COLON_SEPARATOR + str5 + ":00");
        }
    }

    private String a(String str) {
        if (!str.contains(".")) {
            return str + ".00";
        }
        int length = str.length() - str.lastIndexOf(".");
        if (length >= 3) {
            return str;
        }
        if (length >= 2) {
            return str + "0";
        }
        return str + "00";
    }

    private void showTimePiker() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        b.a.a.e.d dVar = new b.a.a.e.d(this, 0, 3);
        dVar.g(2018, 2055);
        dVar.a(i2, i3, i4, i5, i6);
        dVar.setOnDateTimePickListener(new b());
        dVar.m();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("添加止付账户");
        this.f18439b = (AccountListBean) getIntent().getSerializableExtra(util.k1.f20845c);
        y1.a(this.mEtTransMoy);
        AccountListBean accountListBean = this.f18439b;
        if (accountListBean != null) {
            this.f18438a = accountListBean.getSuspectAccountType();
            this.mTvSuspectType.setText(this.f18439b.getSuspectAccountTypeText());
            this.mEtSuspectAccountName.setText(this.f18439b.getSuspectName());
            this.mEtSuspectAccount.setText(this.f18439b.getSuspectAccount());
            this.mTvTransTime.setText(this.f18439b.getPaymentTime());
            this.mEtTransMoy.setText(this.f18439b.getTransferAmount());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        CaseDivisonBean caseDivisonBean;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 1001 || intent == null || (caseDivisonBean = (CaseDivisonBean) intent.getSerializableExtra(util.k1.j1)) == null) {
            return;
        }
        this.mTvSuspectType.setText(caseDivisonBean.getName());
        this.f18438a = caseDivisonBean.getId();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        a();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @OnClick({R.id.iv_back, R.id.tv_suspect_type, R.id.tv_time, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296395 */:
                String strTrim = this.mTvSuspectType.getText().toString().trim();
                String strTrim2 = this.mEtSuspectAccountName.getText().toString().trim();
                String strTrim3 = this.mEtSuspectAccount.getText().toString().trim();
                String strTrim4 = this.mTvTransTime.getText().toString().trim();
                String strTrim5 = this.mEtTransMoy.getText().toString().trim();
                if (!TextUtils.isEmpty(this.f18438a) && !TextUtils.isEmpty(strTrim) && !TextUtils.isEmpty(strTrim2) && !TextUtils.isEmpty(strTrim3) && !TextUtils.isEmpty(strTrim4) && !TextUtils.isEmpty(strTrim5)) {
                    if (this.f18439b == null) {
                        this.f18439b = new AccountListBean();
                        this.f18439b.setPosition(-1);
                    }
                    this.f18439b.setEdit(true);
                    this.f18439b.setSuspectAccountType(this.f18438a);
                    this.f18439b.setSuspectAccountTypeText(strTrim);
                    this.f18439b.setSuspectName(strTrim2);
                    this.f18439b.setSuspectAccount(strTrim3);
                    this.f18439b.setPaymentTime(strTrim4);
                    this.f18439b.setTransferAmount(a(strTrim5));
                    org.greenrobot.eventbus.c.f().d(new util.c2.a(300, this.f18439b));
                    finish();
                    break;
                } else {
                    util.w1.a("请填写嫌疑人账户信息");
                    break;
                }
                break;
            case R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case R.id.tv_suspect_type /* 2131297741 */:
                startActivityForResult(new Intent(this, (Class<?>) PaymentTypeActivity.class), 1001);
                break;
            case R.id.tv_time /* 2131297752 */:
                showTimePiker();
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_paystop_add;
    }

    private void a() {
        util.b1.a((Activity) this, "放弃本次编辑?", "", "取消", "确定", R.color._2D4AEB, -1, true, (IClickListener) new a());
    }
}
