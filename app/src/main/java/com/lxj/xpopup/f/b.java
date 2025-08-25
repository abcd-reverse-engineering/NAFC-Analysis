package com.lxj.xpopup.f;

import android.R;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.lxj.xpopup.core.BasePopupView;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: KeyboardUtils.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f8059a;

    /* renamed from: b, reason: collision with root package name */
    private static ViewTreeObserver.OnGlobalLayoutListener f8060b;

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<View, InterfaceC0115b> f8061c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static int f8062d = 0;

    /* compiled from: KeyboardUtils.java */
    static class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f8063a;

        a(Activity activity) {
            this.f8063a = activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int iB = b.b(this.f8063a);
            if (b.f8059a != iB) {
                Iterator it = b.f8061c.values().iterator();
                while (it.hasNext()) {
                    ((InterfaceC0115b) it.next()).a(iB);
                }
                b.f8059a = iB;
            }
        }
    }

    /* compiled from: KeyboardUtils.java */
    /* renamed from: com.lxj.xpopup.f.b$b, reason: collision with other inner class name */
    public interface InterfaceC0115b {
        void a(int i2);
    }

    private b() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            return f8059a;
        }
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int iAbs = Math.abs(decorView.getBottom() - rect.bottom);
        if (iAbs > b()) {
            return iAbs - f8062d;
        }
        f8062d = iAbs;
        return 0;
    }

    public static void a(Activity activity, BasePopupView basePopupView, InterfaceC0115b interfaceC0115b) {
        if ((activity.getWindow().getAttributes().flags & 512) != 0) {
            activity.getWindow().clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content);
        f8059a = b(activity);
        f8061c.put(basePopupView, interfaceC0115b);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new a(activity));
    }

    private static int b() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void a(View view, BasePopupView basePopupView) {
        view.findViewById(R.id.content).getViewTreeObserver().removeGlobalOnLayoutListener(f8060b);
        f8060b = null;
        f8061c.remove(basePopupView);
    }

    public static void b(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 2);
    }

    public static void a(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
