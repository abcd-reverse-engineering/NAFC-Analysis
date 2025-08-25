package ui.presenter;

import android.app.Activity;
import h.q2.t.i0;
import ui.callview.AboutUsView;
import ui.model.ModelPresent;

/* compiled from: AboutUsPresenter.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lui/presenter/AboutUsPresenter;", "Lui/model/ModelPresent;", "Lui/callview/AboutUsView;", "activity", "Landroid/app/Activity;", "view", "(Landroid/app/Activity;Lui/callview/AboutUsView;)V", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class AboutUsPresenter extends ModelPresent<AboutUsView> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AboutUsPresenter(@i.c.a.d Activity activity, @i.c.a.d AboutUsView aboutUsView) {
        super(activity, aboutUsView);
        i0.f(activity, "activity");
        i0.f(aboutUsView, "view");
    }
}
