package ui.statusbarcompat;

import android.app.Activity;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import anet.channel.strategy.dispatch.DispatchConstants;
import org.android.agoo.xiaomi.MiPushRegistar;
import ui.Hicore;
import util.n1;

/* compiled from: NotchUtils.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f20256a = "NotchUtils";

    /* renamed from: b, reason: collision with root package name */
    public static final int f20257b = 32;

    /* renamed from: c, reason: collision with root package name */
    public static final int f20258c = 8;

    public static int a(Activity activity) {
        if (!b(activity)) {
            return 0;
        }
        a();
        return 0;
    }

    public static boolean b(Activity activity) {
        return a("ro.miui.notch") == 1 || d() || e() || f() || c(activity) != null;
    }

    public static int c() {
        int identifier = Hicore.getApp().getResources().getIdentifier("notch_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return Hicore.getApp().getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean d() throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = Hicore.getApp().getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Exception unused) {
            n1.b("", "hasNotchAtHuawei Exception");
            return false;
        }
    }

    public static boolean e() {
        return Hicore.getApp().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean f() throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = Hicore.getApp().getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Exception unused) {
            n1.b("", "hasNotchAtVivo Exception");
            return false;
        }
    }

    public static boolean g() {
        return "huawei".toLowerCase().equals(Build.MANUFACTURER.toLowerCase());
    }

    public static boolean h() {
        return "oppo".toLowerCase().equals(Build.MANUFACTURER.toLowerCase());
    }

    public static boolean i() {
        return "vivo".toLowerCase().equals(Build.MANUFACTURER.toLowerCase());
    }

    public static boolean j() {
        return MiPushRegistar.XIAOMI.toLowerCase().equals(Build.MANUFACTURER.toLowerCase());
    }

    private static int a() {
        if (j()) {
            return c();
        }
        if (g()) {
            return b()[0];
        }
        if (h()) {
            return 80;
        }
        if (i()) {
            return a(27.0f);
        }
        return 0;
    }

    public static int[] b() {
        int[] iArr = {0, 0};
        try {
            Class<?> clsLoadClass = Hicore.getApp().getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return (int[]) clsLoadClass.getMethod("getNotchSize", new Class[0]).invoke(clsLoadClass, new Object[0]);
        } catch (Exception unused) {
            n1.b(f20256a, "getNotchSize Exception");
            return iArr;
        }
    }

    public static DisplayCutout c(Activity activity) {
        WindowInsets rootWindowInsets;
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null || Build.VERSION.SDK_INT < 28 || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }

    public static int a(float f2) {
        return (int) ((f2 * Hicore.getApp().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(String str) throws ClassNotFoundException {
        if (!j()) {
            return 0;
        }
        try {
            Class<?> clsLoadClass = Hicore.getApp().getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, new String(str), new Integer(0))).intValue();
        } catch (Exception unused) {
            n1.b(f20256a, "getInt InvocationTargetException");
            return 0;
        }
    }
}
