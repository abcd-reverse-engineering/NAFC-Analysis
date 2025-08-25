package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import network.account.RegisterBody;
import network.http.RegionConfigHttp;
import ui.activity.MainActivity;
import ui.callview.RegisterlView;
import ui.model.ModelPresent;
import ui.view.CodeCutTimeTextView;
import util.b1;
import util.v1;
import util.w1;
import util.y1;

/* loaded from: classes2.dex */
public class RegisterPresenter extends ModelPresent<RegisterlView> {
    private CodeCutTimeTextView mCodeTimer;

    class a extends MiddleSubscriber<APIresult<Integer>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Integer.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
            RegisterPresenter.this.mCodeTimer.setEnabled(true);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Integer> aPIresult) throws Resources.NotFoundException {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            w1.a("验证码已发送，请查收");
            if (RegisterPresenter.this.mCodeTimer != null) {
                RegisterPresenter.this.mCodeTimer.a(RegisterPresenter.this.mActivity, aPIresult.getData().intValue());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(g.a.u0.c cVar) {
            b1.a("请稍等", true, RegisterPresenter.this.mActivity);
            RegisterPresenter.this.mCodeTimer.setEnabled(false);
        }
    }

    class b extends MiddleSubscriber<APIresult<AccountInfo>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            ((RegisterlView) RegisterPresenter.this.mvpView).onSuccRequest(aPIresult);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(g.a.u0.c cVar) {
        }
    }

    class c extends MiddleSubscriber<APIresult<AccountInfo>> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            ((RegisterlView) RegisterPresenter.this.mvpView).onOauthSuccRequest(aPIresult);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(g.a.u0.c cVar) {
            b1.a("请稍等", true, RegisterPresenter.this.mActivity);
        }
    }

    class d extends MiddleSubscriber<APIresult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountInfo f20025a;

        d(AccountInfo accountInfo) {
            this.f20025a = accountInfo;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return APIresult.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult.getCode() == 0) {
                RegisterPresenter.this.oauthLoginHttp(this.f20025a.getLoginType(), this.f20025a.getOpenId());
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(g.a.u0.c cVar) {
            b1.a("请稍等", true, RegisterPresenter.this.mActivity);
        }
    }

    class e extends MiddleSubscriber<APIresult<AccountInfo>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f20027a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f20028b;

        e(int i2, String str) {
            this.f20027a = i2;
            this.f20028b = str;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            RegisterPresenter.this.onOauthLoginSuccRequest(aPIresult, this.f20027a, this.f20028b);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(g.a.u0.c cVar) {
            super.onStartMiddle(cVar);
        }
    }

    public RegisterPresenter(Activity activity, RegisterlView registerlView) {
        super(activity, registerlView);
    }

    private void oauthBindAccountHttp(HashMap<String, String> map) {
        requestPhoneCode(d.a.f13517c + e.b.q, map, new c());
    }

    private void registerHttp(HashMap<String, String> map) {
        registerHttp(map, d.a.a("", 1, e.b.E), new b());
    }

    private void verificationHttp(int i2, HashMap<String, String> map) {
        String strA;
        if (i2 == 5) {
            strA = d.a.f13517c + e.b.C;
        } else {
            strA = d.a.a("", 2, e.b.C);
        }
        requestPhoneCodeTime(strA, map, new a());
    }

    public void oauthBindAccount(String str, String str2, String str3, int i2, String str4) {
        HashMap<String, String> map = new HashMap<>();
        map.put("phoneNum", str);
        map.put("smsVerifyCode", str2);
        map.put("region", str3);
        map.put("unionLoginType", i2 + "");
        map.put("openId", str4 + "");
        oauthBindAccountHttp(map);
    }

    public void oauthLoginHttp(int i2, String str) {
        HashMap map = new HashMap();
        map.put("loginType", "2");
        map.put("unionLoginType", i2 + "");
        map.put("openId", str);
        requestPhoneCode(d.a.f13517c + e.b.f13575m, map, new e(i2, str));
    }

    public void onOauthLoginSuccRequest(APIresult<AccountInfo> aPIresult, int i2, String str) {
        if (aPIresult.getCode() != 0) {
            w1.a(aPIresult.getMsg());
            return;
        }
        AccountInfo data = aPIresult.getData();
        data.setLoginType(i2);
        data.setOpenId(str);
        data.setVisiblePhone("");
        AccountManager.saveAccount(data);
        y1.a((Context) this.mActivity, (Class<?>) MainActivity.class);
        receiver.e.a(data.getTags());
    }

    public void principalHttp(RegisterBody registerBody) {
        b1.a("请稍等...", true, this.mActivity);
        registerHttp(JNIHandStamp.getInstance().pamramToMap(registerBody));
    }

    public void silentlyreg(AccountInfo accountInfo) {
        HashMap map = new HashMap();
        map.put("mobileNumber", accountInfo.getPhoneNum());
        map.put("region", RegionConfigHttp.getNodeRegionId());
        map.put("openId", accountInfo.getOpenId());
        map.put("loginType", accountInfo.getLoginType() + "");
        map.put("AppVersion", v1.o());
        map.put("IMEI", v1.l());
        map.put("OS", "0");
        map.put("OSVersion", v1.i());
        silentlyreg(d.a.a("", 1, e.b.r), map, new d(accountInfo));
    }

    public void verificationSubmit(int i2, String str, CodeCutTimeTextView codeCutTimeTextView) {
        this.mCodeTimer = codeCutTimeTextView;
        if (str.length() != 11) {
            w1.a("手机号码格式不正确，请重新输入");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("mobilenumber", str);
        map.put("codetype", i2 + "");
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        verificationHttp(i2, map);
    }
}
