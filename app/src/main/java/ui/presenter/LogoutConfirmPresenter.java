package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import h.q2.t.i0;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.LogoutConfirmView;
import ui.model.ModelPresent;
import util.b1;
import util.w1;

/* compiled from: LogoutConfirmPresenter.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001c\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\rH\u0002¨\u0006\u000e"}, d2 = {"Lui/presenter/LogoutConfirmPresenter;", "Lui/model/ModelPresent;", "Lui/callview/LogoutConfirmView;", "activity", "Landroid/app/Activity;", "view", "(Landroid/app/Activity;Lui/callview/LogoutConfirmView;)V", "loginOff", "", "reason", "", "loginOffHttp", "map", "Ljava/util/HashMap;", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class LogoutConfirmPresenter extends ModelPresent<LogoutConfirmView> {

    /* compiled from: LogoutConfirmPresenter.kt */
    public static final class a extends MiddleSubscriber<APIresult<?>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@i.c.a.d APIException aPIException) throws Resources.NotFoundException {
            i0.f(aPIException, "e");
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@i.c.a.d APIresult<?> aPIresult) throws Resources.NotFoundException {
            i0.f(aPIresult, "resultInfo");
            if (aPIresult.getCode() == 0) {
                ((LogoutConfirmView) LogoutConfirmPresenter.this.mvpView).onSuccessRequest();
                return;
            }
            APIException apiExcept = APIException.getApiExcept(aPIresult.getMsg());
            i0.a((Object) apiExcept, "APIException.getApiExcept(resultInfo.msg)");
            onErrorMiddle(apiExcept);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogoutConfirmPresenter(@i.c.a.d Activity activity, @i.c.a.d LogoutConfirmView logoutConfirmView) {
        super(activity, logoutConfirmView);
        i0.f(activity, "activity");
        i0.f(logoutConfirmView, "view");
    }

    private final void loginOffHttp(HashMap<String, String> map) {
        loginOffHttp(d.a.a("", 1, e.b.I), map, new a());
    }

    public final void loginOff(@i.c.a.d String str) {
        i0.f(str, "reason");
        HashMap<String, String> map = new HashMap<>();
        map.put("reason", str);
        b1.a("加载中...", true, this.mActivity);
        loginOffHttp(map);
    }
}
