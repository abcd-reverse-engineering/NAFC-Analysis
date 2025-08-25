package ui.activity;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import bean.module.LocalModuelConfig;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.IEditAfterListener;
import interfaces.IOneClickListener;
import interfaces.IResultCallback;
import java.util.Map;
import manager.AccountManager;
import network.account.APIresult;
import network.account.AccountInfo;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.LoginCallView;
import ui.presenter.LoginPresenter;
import util.y1;

/* loaded from: classes2.dex */
public class LoginActivity extends BaseActivity implements IEditAfterListener, LoginCallView {
    public static final String EXTRA_LOGIN_ACCOUNT = "extra_login_account";
    public static final String EXTRA_LOGIN_VERIFICATION = "extra_login_verification";
    public static final int LOGIN_TYPE_OAUTH = 2;
    public static final int LOGIN_TYPE_PWD = 0;
    public static final int LOGIN_TYPE_VERIFICATION = 1;
    private boolean isChecked;
    LoginPresenter loginPresenter;

    @BindView(R.id.account)
    EditText mAccount;

    @BindView(R.id.account_label)
    TextView mAccountLabel;

    @BindView(R.id.clause)
    TextView mClause;

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.forget_pwd)
    TextView mForgetPwd;

    @BindView(R.id.iv_clear)
    ImageView mIvClean;

    @BindView(R.id.line_v)
    View mLineV;

    @BindView(R.id.login_change)
    TextView mLoginChange;

    @BindView(R.id.login_label)
    TextView mLoginLabel;

    @BindView(R.id.pwd_eye)
    ImageView mPwdEye;

    @BindView(R.id.pwd_group)
    Group mPwdGroup;

    @BindView(R.id.cb_select)
    CheckBox mTCbSelect;

    @BindView(R.id.user_pwd)
    EditText mUserPwd;
    private boolean pwdIsVisible = true;
    UMAuthListener authListener = new a();

    class a implements UMAuthListener {
        a() {
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(SHARE_MEDIA share_media, int i2) {
            LoginActivity.this.hideProgressDialog();
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(SHARE_MEDIA share_media, int i2, Map<String, String> map) {
            String str;
            int i3;
            LoginActivity.this.hideProgressDialog();
            if (share_media == SHARE_MEDIA.QQ) {
                i3 = AccountManager.LOGIN_QQ;
                str = map.get("openid");
                map.get("unionid");
            } else if (share_media == SHARE_MEDIA.WEIXIN) {
                i3 = AccountManager.LOGIN_WX;
                str = map.get("openid");
                map.get("unionid");
            } else if (share_media == SHARE_MEDIA.SINA) {
                i3 = AccountManager.LOGIN_SINA;
                str = map.get("uid");
            } else {
                str = "";
                i3 = 0;
            }
            map.get("iconurl");
            map.get(CommonNetImpl.NAME);
            LoginActivity.this.loginPresenter.oauthLogin(i3, str);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(SHARE_MEDIA share_media, int i2, Throwable th) {
            LoginActivity.this.hideProgressDialog();
            if (th.getMessage().contains("没有安装应用")) {
                util.w1.a("没有安装应用");
            }
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(SHARE_MEDIA share_media) {
            LoginActivity.this.showProgressDialog("登录中...");
        }
    }

    private void buttonStatus() {
        String strTrim = this.mAccount.getText().toString().trim();
        if (strTrim.length() > 0) {
            this.mIvClean.setVisibility(0);
        } else {
            this.mIvClean.setVisibility(4);
        }
        String strTrim2 = this.mUserPwd.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim) || strTrim.length() != 11 || TextUtils.isEmpty(strTrim2) || strTrim2.length() < 6) {
            this.mConfirm.setEnabled(false);
        } else {
            this.mConfirm.setEnabled(true);
        }
    }

    private void doAuthLogin(SHARE_MEDIA share_media) {
        if (y1.a(this.mActivity, share_media)) {
            UMShareAPI.get(this.mActivity).getPlatformInfo(this.mActivity, share_media, this.authListener);
            return;
        }
        if (share_media == SHARE_MEDIA.WEIXIN) {
            util.w1.a("您未安装微信客户端");
        } else if (share_media == SHARE_MEDIA.QQ) {
            util.w1.a("您未安装QQ客户端");
        } else if (share_media == SHARE_MEDIA.SINA) {
            util.w1.a("您未安装新浪客户端");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doLogin, reason: merged with bridge method [inline-methods] */
    public void b() {
        showProgressDialog("登录中...");
        this.loginPresenter.loginSubmit(this.mAccount.getText().toString().trim(), 0, this.mUserPwd.getText().toString().trim(), "");
    }

    private void initCluse(boolean z) {
        CharSequence charSequenceA = y1.a(this, z ? "新用户登录即完成注册，且表示您已同意\n" : "登录即同意", "和", "", "《服务协议》", "《隐私政策》");
        this.mClause.setMovementMethod(LinkMovementMethod.getInstance());
        this.mClause.setText(charSequenceA);
    }

    private void initListener() {
        this.mPwdEye.setOnClickListener(new View.OnClickListener() { // from class: ui.activity.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19419a.a(view);
            }
        });
        this.mTCbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.h0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f19430a.a(compoundButton, z);
            }
        });
        util.d1.a(this.mAccount, this);
        util.d1.a(this.mUserPwd, this);
        initCluse(true);
        initCluse(false);
        buttonStatus();
    }

    private void judgeRegisterRegion(final AccountInfo accountInfo, int i2) {
        if (!TextUtils.isEmpty(accountInfo.getRegisterRegionName()) && !TextUtils.isEmpty(accountInfo.getRegisterRegionCode())) {
            LocalModuelConfig.getInstance().getConfigMude(accountInfo.getRegisterRegionCode(), new IResultCallback() { // from class: ui.activity.d0
                @Override // interfaces.IResultCallback
                public final void onIRSuccess(RegionMudelBean regionMudelBean) {
                    this.f19414a.a(accountInfo, regionMudelBean);
                }
            });
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) AddressActivity.class);
        intent.putExtra(util.k1.X0, i2);
        intent.putExtra(util.k1.f20845c, accountInfo);
        startActivity(intent);
    }

    private void tip() {
        util.w1.a("请先勾选同意协议政策后再登录");
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

    @Override // interfaces.IEditAfterListener
    public void editLength(int i2) {
        buttonStatus();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(e.d.f13585c);
        this.loginPresenter = new LoginPresenter(this.mActivity, this);
        initListener();
        org.greenrobot.eventbus.c.f().e(this);
        getPushData();
        receiver.e.a(this.mActivity);
        util.d1.b(this.mUserPwd);
        String visiblePhone = AccountManager.getVisiblePhone();
        if (TextUtils.isEmpty(visiblePhone)) {
            return;
        }
        this.mAccount.setText(visiblePhone);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        UMShareAPI.get(this).onActivityResult(i2, i3, intent);
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.c2.a aVar) {
        if (aVar == null || aVar.a() != 155) {
            return;
        }
        ((ActivityManager) getSystemService("activity")).moveTaskToFront(getTaskId(), 1);
    }

    @Override // ui.callview.LoginCallView
    public void onLoginSuccRequest(APIresult<AccountInfo> aPIresult) {
        hideProgressDialog();
        if (aPIresult.getCode() != 0) {
            util.w1.a(aPIresult.getMsg());
            return;
        }
        AccountInfo data = aPIresult.getData();
        data.setLoginType(AccountManager.LOGIN_NORMAL);
        data.setVisiblePhone(this.mAccount.getText().toString().trim());
        judgeRegisterRegion(data, 1);
        receiver.e.a(data.getTags());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        StatisticsHttp.getInstance().pageOpenHttp(e.d.f13585c);
    }

    @Override // ui.callview.LoginCallView
    public void onOathfail() {
        hideProgressDialog();
    }

    @Override // ui.callview.LoginCallView
    public void onOauthLoginSuccRequest(APIresult<AccountInfo> aPIresult, int i2, String str) {
        hideProgressDialog();
        int code = aPIresult.getCode();
        if (code == 0) {
            AccountInfo data = aPIresult.getData();
            data.setLoginType(i2);
            data.setVisiblePhone("");
            judgeRegisterRegion(data, 5);
            receiver.e.a(data.getTags());
            return;
        }
        if (code != 7) {
            util.w1.a(aPIresult.getMsg());
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) OauthRegisterActivity.class);
        intent.putExtra(util.k1.M, i2);
        intent.putExtra("open_id", str);
        startActivity(intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    protected void onStop() {
        super.onStop();
        hideProgressDialog();
        new Thread(new Runnable() { // from class: ui.activity.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f19427a.a();
            }
        }).start();
    }

    @OnClick({R.id.confirm, R.id.iv_clear, R.id.login_change, R.id.forget_pwd, R.id.iv_wx_login, R.id.iv_qq_login, R.id.iv_sina_login})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        hideSoftInput();
        switch (view.getId()) {
            case R.id.confirm /* 2131296476 */:
                if (!this.isChecked) {
                    tip();
                    break;
                } else if (!y1.a(util.p1.q, true)) {
                    b();
                    break;
                } else {
                    toYanzheng(new IOneClickListener() { // from class: ui.activity.f0
                        @Override // interfaces.IOneClickListener
                        public final void clickOKBtn() {
                            this.f19422a.b();
                        }
                    });
                    break;
                }
            case R.id.forget_pwd /* 2131296661 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) ForgetPdwOneActivity.class);
                if (this.mAccount.length() > 0) {
                    intent.putExtra(util.k1.e0, this.mAccount.getText().toString());
                }
                startActivity(intent);
                break;
            case R.id.iv_clear /* 2131296772 */:
                this.mAccount.setText("");
                buttonStatus();
                break;
            case R.id.iv_qq_login /* 2131296819 */:
                if (!this.isChecked) {
                    tip();
                    break;
                } else {
                    doAuthLogin(SHARE_MEDIA.QQ);
                    break;
                }
            case R.id.iv_sina_login /* 2131296832 */:
                if (!this.isChecked) {
                    tip();
                    break;
                } else {
                    doAuthLogin(SHARE_MEDIA.SINA);
                    break;
                }
            case R.id.iv_wx_login /* 2131296868 */:
                if (!this.isChecked) {
                    tip();
                    break;
                } else {
                    doAuthLogin(SHARE_MEDIA.WEIXIN);
                    break;
                }
            case R.id.login_change /* 2131297008 */:
                startActivity(AddressActivity.class);
                break;
        }
    }

    @Override // ui.callview.LoginCallView
    public void onfail() {
        hideProgressDialog();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_login;
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.isChecked = z;
    }

    public /* synthetic */ void a() {
        if (util.w0.a(this.mActivity)) {
            return;
        }
        Looper.prepare();
        util.w1.a("APP已进入后台，请确认操作环境是否安全~");
        Looper.loop();
    }

    public /* synthetic */ void a(AccountInfo accountInfo, RegionMudelBean regionMudelBean) {
        if (regionMudelBean != null) {
            AccountManager.saveAccount(accountInfo);
            y1.a((Context) this.mActivity, (Class<?>) MainActivity.class);
            finish();
            return;
        }
        util.w1.a("暂无地区配置数据");
    }
}
