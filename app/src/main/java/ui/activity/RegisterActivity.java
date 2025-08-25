package ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.PermissionsListener;
import java.net.SocketException;
import java.util.List;
import network.account.APIresult;
import network.account.AccountInfo;
import network.account.RegisterBody;
import network.http.LoginHttp;
import network.http.RegionConfigHttp;
import network.http.StatisticsHttp;
import ui.Hicore;
import ui.callview.RegisterlView;
import ui.presenter.RegisterPresenter;
import ui.view.CodeCutTimeTextView;
import util.y1;

/* loaded from: classes2.dex */
public class RegisterActivity extends BaseActivity implements TextWatcher, RegisterlView {
    private boolean isChecked;

    @BindView(R.id.account)
    EditText mAccount;

    @BindView(R.id.clause)
    TextView mClause;

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.iv_clear)
    ImageView mIvClean;

    @BindView(R.id.iv_clear_account)
    ImageView mIvClearAccount;

    @BindView(R.id.ll_to_login)
    LinearLayout mLlToLogin;
    RegisterPresenter mPresenter;

    @BindView(R.id.pwd_eye)
    ImageView mPwdEye;

    @BindView(R.id.cb_select)
    CheckBox mTCbSelect;

    @BindView(R.id.tv_region)
    TextView mTvRegion;

    @BindView(R.id.tv_resend)
    CodeCutTimeTextView mTvResend;

    @BindView(R.id.user_pwd)
    EditText mUserPwd;

    @BindView(R.id.user_verification)
    EditText mUserVerification;
    private boolean pwdIsVisible = true;

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) throws SocketException {
            RegisterActivity.this.registerSubmit();
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() throws SocketException {
            RegisterActivity.this.registerSubmit();
        }
    }

    class b implements IOneClickListener {
        b() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            RegisterActivity.this.showDlg();
        }
    }

    class c implements IClickListener {
        c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            if (Hicore.getApp().isDouble()) {
                return;
            }
            y1.a((Context) RegisterActivity.this.mActivity, (Class<?>) MainActivity.class);
            RegisterActivity.this.mActivity.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (Hicore.getApp().isDouble()) {
                return;
            }
            Intent intent = new Intent(RegisterActivity.this.mActivity, (Class<?>) MinePersonalActivity.class);
            intent.putExtra(util.k1.f20846d, 1);
            RegisterActivity.this.startActivity(intent);
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f20916j}, new a());
    }

    private void enableConfirm() {
        String strTrim = this.mAccount.getText().toString().trim();
        String strTrim2 = this.mUserVerification.getText().toString().trim();
        String strTrim3 = this.mUserPwd.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim) || TextUtils.isEmpty(strTrim2) || TextUtils.isEmpty(strTrim3)) {
            this.mIvClean.setVisibility(4);
            this.mConfirm.setEnabled(false);
        } else {
            this.mIvClean.setVisibility(0);
            this.mConfirm.setEnabled(true);
        }
    }

    private void initCluse() {
        CharSequence charSequenceA = y1.a(this, "注册即同意", "和", "", "《服务协议》", "《隐私政策》");
        this.mClause.setMovementMethod(LinkMovementMethod.getInstance());
        this.mClause.setText(charSequenceA);
    }

    private void initListener() {
        this.mPwdEye.setOnClickListener(new View.OnClickListener() { // from class: ui.activity.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19484a.a(view);
            }
        });
        this.mTCbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.v0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f19481a.a(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerSubmit() throws SocketException {
        String string = this.mAccount.getText().toString();
        String strTrim = this.mUserPwd.getText().toString().trim();
        String strTrim2 = this.mUserVerification.getText().toString().trim();
        String nodeRegionId = RegionConfigHttp.getNodeRegionId();
        if (strTrim.length() < 6 || strTrim.length() > 16 || util.d1.a(strTrim)) {
            util.w1.a(this.mActivity.getString(R.string.login_pwd));
            return;
        }
        if (TextUtils.isEmpty(nodeRegionId)) {
            util.w1.a("请选择地区");
            return;
        }
        String strI = util.v1.i();
        String strO = util.v1.o();
        String strL = util.v1.l();
        String strA = util.l1.a();
        RegisterBody registerBody = new RegisterBody();
        registerBody.setPhoneNum(string);
        registerBody.setSmsVerifyCode(strTrim2);
        registerBody.setPassword(strTrim);
        registerBody.setAppVersion(strO);
        registerBody.setOs(0);
        registerBody.setOsVersion(strI);
        registerBody.setImei(strL);
        registerBody.setRequestIP(strA);
        registerBody.setRegion(nodeRegionId);
        this.mPresenter.principalHttp(registerBody);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDlg() {
        util.b1.a(this.mActivity, "注册成功", "感谢您的注册，完善您的个人信息将获得反诈部门更多关注", "忽略", "继续完善", -1, -1, true, (IClickListener) new c());
    }

    public /* synthetic */ void a(View view) {
        if (this.pwdIsVisible) {
            this.mPwdEye.setImageResource(R.mipmap.eye_sel);
            this.mUserPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            this.mPwdEye.setImageResource(R.mipmap.eye_nor);
            this.mUserPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        this.pwdIsVisible = !this.pwdIsVisible;
        if (!this.mUserPwd.isFocused()) {
            this.mUserPwd.setFocusable(true);
            this.mUserPwd.setFocusableInTouchMode(true);
            this.mUserPwd.requestFocus();
            this.mUserPwd.requestFocusFromTouch();
        }
        EditText editText = this.mUserPwd;
        editText.setSelection(editText.getText().toString().length());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        enableConfirm();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(e.d.f13586d);
        this.mPresenter = new RegisterPresenter(this, this);
        String stringExtra = getIntent().getStringExtra(LoginActivity.EXTRA_LOGIN_VERIFICATION);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.mUserVerification.setText(stringExtra);
        }
        this.mAccount.addTextChangedListener(this);
        this.mUserVerification.addTextChangedListener(this);
        this.mUserPwd.addTextChangedListener(this);
        this.mTvResend.a(true);
        initCluse();
        initListener();
        util.d1.b(this.mUserPwd);
    }

    @Override // ui.callview.RegisterlView
    public void onOauthSuccRequest(APIresult<AccountInfo> aPIresult) {
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mTvRegion.setText(RegionConfigHttp.getNodeRegionName());
    }

    @Override // ui.callview.RegisterlView
    public void onSuccRequest(APIresult<AccountInfo> aPIresult) throws Resources.NotFoundException {
        int code = aPIresult.getCode();
        String msg = aPIresult.getMsg();
        if (code != 0) {
            if (code != 1) {
                util.w1.e(msg);
                return;
            }
            util.w1.e(msg);
            finish();
            org.greenrobot.eventbus.c.f().d(new util.c2.a(util.c2.a.v0));
            return;
        }
        if (aPIresult.getData() == null) {
            util.w1.e(msg);
            return;
        }
        LoginHttp.getInstance().loginSubmit(this.mActivity, this.mAccount.getText().toString(), this.mUserPwd.getText().toString().trim(), this.mUserVerification.getText().toString().trim(), 0, new b());
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @OnClick({R.id.iv_clear_account, R.id.tv_resend, R.id.ll_to_login, R.id.iv_clear, R.id.confirm})
    public void onViewClicked(View view) {
        hideSoftInput();
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.confirm /* 2131296476 */:
                if (!this.isChecked) {
                    util.w1.a("请先勾选同意协议政策后再注册");
                    break;
                } else {
                    checkPermission();
                    break;
                }
            case R.id.iv_clear /* 2131296772 */:
                this.mUserPwd.setText("");
                break;
            case R.id.iv_clear_account /* 2131296773 */:
                this.mAccount.setText("");
                break;
            case R.id.ll_to_login /* 2131296993 */:
                org.greenrobot.eventbus.c.f().d(new util.c2.a(util.c2.a.v0, null));
                finish();
                break;
            case R.id.tv_resend /* 2131297692 */:
                final String string = this.mAccount.getText().toString();
                if (!TextUtils.isEmpty(string) && string.length() == 11) {
                    if (!y1.a(util.p1.s, true)) {
                        this.mPresenter.verificationSubmit(1, string, this.mTvResend);
                        break;
                    } else {
                        toYanzheng(new IOneClickListener() { // from class: ui.activity.u0
                            @Override // interfaces.IOneClickListener
                            public final void clickOKBtn() {
                                this.f19477a.a(string);
                            }
                        });
                        break;
                    }
                } else {
                    util.w1.a("请输入正确手机号~");
                    break;
                }
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_register;
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.isChecked = z;
    }

    public /* synthetic */ void a(String str) {
        this.mPresenter.verificationSubmit(1, str, this.mTvResend);
    }
}
