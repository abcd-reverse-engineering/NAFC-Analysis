package network;

import android.content.Context;
import android.text.TextUtils;
import com.hicorenational.antifraud.R;
import g.a.i0;
import interfaces.IOneClickListener;
import java.lang.reflect.Type;
import l.h;
import manager.AccountManager;
import manager.LoginManager;
import network.account.APIresult;
import ui.Hicore;
import ui.activity.PoliceLoginActivity;
import ui.c;
import ui.presenter.JNIHandStamp;
import util.b1;
import util.n1;

/* loaded from: classes2.dex */
public abstract class MiddleSubscriber<T extends APIresult> implements i0<T> {
    private static final String TAG = "MiddleSubscriber";
    private Context mContext = Hicore.getApp();

    private APIException accept(Throwable th) {
        if (com.hicorenational.antifraud.a.n.booleanValue()) {
            if (th instanceof h) {
                h hVar = (h) th;
                if (hVar.code() == 401) {
                    LoginManager.getInstance().exit("授权已过期,请重新登录");
                    return APIException.getApiExcept(401, "");
                }
                if (hVar.code() == 402) {
                    return APIException.getApiExcept(hVar.code(), "请求已提交，请勿重复提交。");
                }
            }
            return APIException.getApiExcept(-102, th.getMessage());
        }
        try {
            if (th instanceof APIException) {
                return (APIException) th;
            }
            if (!(th instanceof h)) {
                return APIException.getApiExcept(-102, this.mContext.getResources().getString(R.string.err_timeout));
            }
            if (((h) th).code() != 401) {
                return ((h) th).code() == 402 ? APIException.getApiExcept(((h) th).code(), "请求已提交，请勿重复提交。") : ((h) th).code() == 480 ? APIException.getApiExcept(((h) th).code(), this.mContext.getResources().getString(R.string.err_timeout)) : APIException.getApiExcept(((h) th).code(), this.mContext.getResources().getString(R.string.err_timeout));
            }
            LoginManager.getInstance().exit("授权已过期,请重新登录");
            return APIException.getApiExcept(401, "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return APIException.getApiExcept(-102, this.mContext.getResources().getString(R.string.err_timeout));
        }
    }

    protected boolean dealPoliceExit(APIException aPIException) {
        int code = aPIException.getCode();
        if (code == -3) {
            b1.b(c.i().c(), aPIException.getMessage(), "确定", new IOneClickListener() { // from class: network.MiddleSubscriber.4
                @Override // interfaces.IOneClickListener
                public void clickOKBtn() {
                    String strB = d.b.b();
                    if (TextUtils.equals(AccountManager.getAccountPhone(), strB) || (TextUtils.isEmpty(strB) && (c.i().c() instanceof PoliceLoginActivity))) {
                        LoginManager.getInstance().exitToLogin();
                    } else {
                        LoginManager.getInstance().exitToPoliceLogin();
                    }
                }
            });
            return true;
        }
        if (code == -2) {
            b1.b(c.i().c(), aPIException.getMessage(), "确定", new IOneClickListener() { // from class: network.MiddleSubscriber.3
                @Override // interfaces.IOneClickListener
                public void clickOKBtn() {
                    LoginManager.getInstance().exitToPoliceLogin();
                }
            });
            return true;
        }
        if (code != 401) {
            n1.b("onErrorMiddle switch dealPoliceExit");
            return false;
        }
        b1.b(c.i().c(), aPIException.getMessage(), "确定", new IOneClickListener() { // from class: network.MiddleSubscriber.2
            @Override // interfaces.IOneClickListener
            public void clickOKBtn() {
                LoginManager.getInstance().exitToLogin();
            }
        });
        return true;
    }

    protected Type getType() {
        return new com.google.gson.d0.a<String>() { // from class: network.MiddleSubscriber.1
        }.getType();
    }

    @Override // g.a.i0
    public final void onComplete() {
        try {
            b1.a();
            onCompleteMiddle();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void onCompleteMiddle() {
    }

    @Override // g.a.i0
    public final void onError(Throwable th) {
        b1.a();
        try {
            onErrorMiddle(accept(th));
            n1.a(TAG, "onError: " + th.getMessage());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void onErrorMiddle(APIException aPIException) {
    }

    protected void onNextMiddle(T t) {
    }

    protected void onStartMiddle(g.a.u0.c cVar) {
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        onStartMiddle(cVar);
    }

    @Override // g.a.i0
    public final void onNext(T t) {
        b1.a();
        try {
            int code = t.getCode();
            if (code == 999) {
                t.setMsg(Hicore.getApp().getResources().getString(R.string.err_system));
            } else if (code == -102) {
                t = (T) JNIHandStamp.getInstance().analyzeParam(t, getType());
            }
            onNextMiddle(t);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
