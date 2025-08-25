package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import network.account.RegisterBody;
import ui.callview.LoginCallView;
import ui.model.ModelPresent;
import util.d1;
import util.w1;

/* loaded from: classes2.dex */
public class LoginPresenter extends ModelPresent<LoginCallView> {
    HashMap<String, String> map;
    private String openId;
    private int platId;

    class a extends MiddleSubscriber<APIresult<AccountInfo>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
            ((LoginCallView) LoginPresenter.this.mvpView).onfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            ((LoginCallView) LoginPresenter.this.mvpView).onLoginSuccRequest(aPIresult);
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
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
            ((LoginCallView) LoginPresenter.this.mvpView).onOathfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            LoginPresenter loginPresenter = LoginPresenter.this;
            ((LoginCallView) loginPresenter.mvpView).onOauthLoginSuccRequest(aPIresult, loginPresenter.platId, LoginPresenter.this.openId);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(g.a.u0.c cVar) {
            super.onStartMiddle(cVar);
        }
    }

    public LoginPresenter(Activity activity, LoginCallView loginCallView) {
        super(activity, loginCallView);
    }

    private void loginHttp(HashMap<String, String> map) {
        requestPhoneCode(d.a.f13517c + e.b.f13575m, map, new a());
    }

    private void oauthLoginHttp(HashMap<String, String> map) {
        requestPhoneCode(d.a.f13517c + e.b.f13575m, map, new b());
    }

    public void loginSubmit(String str, int i2, String str2, String str3) {
        RegisterBody registerBody = new RegisterBody();
        if (str.length() != 11) {
            w1.a("手机号码格式不正确，请重新输入");
            ((LoginCallView) this.mvpView).onfail();
            return;
        }
        registerBody.setPhoneNum(str);
        registerBody.setLoginType(i2);
        if (i2 != 0) {
            if (i2 == 1) {
                if (TextUtils.isEmpty(str3)) {
                    w1.a("请输入验证码");
                    ((LoginCallView) this.mvpView).onfail();
                    return;
                }
                registerBody.setSmsVerifyCode(str3);
            }
        } else {
            if (str2.length() < 6 || str2.length() > 16 || d1.a(str2)) {
                w1.a(this.mActivity.getString(R.string.login_pwd));
                ((LoginCallView) this.mvpView).onfail();
                return;
            }
            registerBody.setPassword(str2);
        }
        this.map = JNIHandStamp.getInstance().pamramToMap(registerBody);
        loginHttp(this.map);
    }

    public void oauthLogin(int i2, String str) {
        this.map = new HashMap<>();
        this.map.put("loginType", "2");
        this.map.put("unionLoginType", i2 + "");
        this.map.put("openId", str);
        this.platId = i2;
        this.openId = str;
        oauthLoginHttp(this.map);
    }
}
