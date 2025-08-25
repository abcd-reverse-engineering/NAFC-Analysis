package network.http;

import android.app.Activity;
import android.text.TextUtils;
import d.a;
import e.b;
import interfaces.IOneClickListener;
import java.lang.reflect.Type;
import manager.AccountManager;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import network.account.RegisterBody;
import ui.basemvp.BaseView;
import ui.c;
import ui.model.ModelPresent;
import util.b1;
import util.d1;
import util.n1;

/* loaded from: classes2.dex */
public class LoginHttp extends ModelPresent {
    private static final String TAG = LoginHttp.class.getSimpleName();
    private static LoginHttp loginHttp;
    private IOneClickListener clickListener;
    private Activity mContext;

    private LoginHttp() {
        super((Activity) null, (BaseView) null);
    }

    public static LoginHttp getInstance() {
        if (loginHttp == null) {
            loginHttp = new LoginHttp();
        }
        return loginHttp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentLogin() {
        LoginManager.getInstance().exitToLogin();
    }

    private void loginHttp(final RegisterBody registerBody) {
        loginHttp(a.f13517c + b.f13575m, registerBody, new MiddleSubscriber<APIresult<AccountInfo>>() { // from class: network.http.LoginHttp.1
            @Override // network.MiddleSubscriber
            protected Type getType() {
                return AccountInfo.class;
            }

            @Override // network.MiddleSubscriber
            protected void onCompleteMiddle() {
                n1.a(LoginHttp.TAG, "-->onComplete");
                b1.a();
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) {
                n1.a(LoginHttp.TAG, "-->onError");
                b1.a();
                LoginHttp.this.intentLogin();
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
                n1.a(LoginHttp.TAG, "-->onNext");
                if (aPIresult.getCode() != 0) {
                    LoginHttp.this.intentLogin();
                    return;
                }
                AccountInfo data = aPIresult.getData();
                data.setLoginType(AccountManager.LOGIN_NORMAL);
                AccountManager.saveAccount(data, registerBody.getPhoneNum());
                c.i().e();
                LoginHttp.this.clickListener.clickOKBtn();
            }

            @Override // network.MiddleSubscriber
            protected void onStartMiddle(g.a.u0.c cVar) {
                n1.a(LoginHttp.TAG, "-->onSubscribe");
                b1.a("请稍后...", false, LoginHttp.this.mContext);
            }
        });
    }

    public void loginSubmit(Activity activity, String str, String str2, String str3, int i2, IOneClickListener iOneClickListener) {
        this.mContext = activity;
        if (TextUtils.isEmpty(str)) {
            intentLogin();
            return;
        }
        if (i2 == -1) {
            intentLogin();
            return;
        }
        RegisterBody registerBody = new RegisterBody();
        registerBody.setPhoneNum(str);
        registerBody.setLoginType(i2);
        if (i2 != 0) {
            if (i2 != 1) {
                intentLogin();
            } else {
                if (TextUtils.isEmpty(str3)) {
                    intentLogin();
                    return;
                }
                registerBody.setSmsVerifyCode(str3);
            }
        } else {
            if (TextUtils.isEmpty(str2) || str2.length() < 6 || str2.length() > 16 || d1.a(str2)) {
                intentLogin();
                return;
            }
            registerBody.setPassword(str2);
        }
        n1.b("RegisterBody-->", registerBody.toString());
        this.clickListener = iOneClickListener;
        loginHttp(registerBody);
    }
}
