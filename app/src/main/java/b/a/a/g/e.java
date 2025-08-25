package b.a.a.g;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

/* compiled from: ScreenUtils.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f2318a = false;

    /* renamed from: b, reason: collision with root package name */
    private static DisplayMetrics f2319b;

    public static float a(Context context) {
        return c(context).density;
    }

    public static int b(Context context) {
        return c(context).densityDpi;
    }

    public static DisplayMetrics c(Context context) {
        DisplayMetrics displayMetrics = f2319b;
        if (displayMetrics != null) {
            return displayMetrics;
        }
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
        d.e("screen width=" + displayMetrics2.widthPixels + "px, screen height=" + displayMetrics2.heightPixels + "px, densityDpi=" + displayMetrics2.densityDpi + ", density=" + displayMetrics2.density);
        return displayMetrics2;
    }

    public static int d(Context context) {
        return c(context).heightPixels;
    }

    public static int e(Context context) {
        return c(context).widthPixels;
    }

    public static boolean a() {
        return f2318a;
    }

    public static void b(Activity activity) {
        Window window = activity.getWindow();
        if (f2318a) {
            window.clearFlags(1024);
            f2318a = false;
        } else {
            window.setFlags(1024, 1024);
            f2318a = true;
        }
    }

    public static void a(Activity activity) {
        activity.getWindow().setFlags(128, 128);
    }
}
