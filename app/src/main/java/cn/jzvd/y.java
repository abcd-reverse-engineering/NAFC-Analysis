package cn.jzvd;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: JZUtils.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3256a = "JZVD";

    /* renamed from: b, reason: collision with root package name */
    public static int f3257b;

    public static String a(long j2) {
        if (j2 <= 0 || j2 >= 86400000) {
            return "00:00";
        }
        long j3 = j2 / 1000;
        int i2 = (int) (j3 % 60);
        int i3 = (int) ((j3 / 60) % 60);
        int i4 = (int) (j3 / 3600);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return i4 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2)).toString();
    }

    public static Window b(Context context) {
        return a(context) != null ? a(context).getWindow() : f(context).getWindow();
    }

    @SuppressLint({"RestrictedApi"})
    public static void c(Context context) {
        if (Jzvd.q0) {
            b(context).setFlags(1024, 1024);
        }
    }

    @SuppressLint({"NewApi"})
    public static void d(Context context) {
        int i2 = Build.VERSION.SDK_INT >= 19 ? 5638 : 1542;
        f3257b = b(context).getDecorView().getSystemUiVisibility();
        b(context).getDecorView().setSystemUiVisibility(i2);
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static Activity f(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return f(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @SuppressLint({"RestrictedApi"})
    public static void g(Context context) {
        if (Jzvd.q0) {
            b(context).clearFlags(1024);
        }
    }

    @SuppressLint({"NewApi"})
    public static void h(Context context) {
        b(context).getDecorView().setSystemUiVisibility(f3257b);
    }

    public static long b(Context context, Object obj) {
        if (!Jzvd.t0) {
            return 0L;
        }
        return context.getSharedPreferences("JZVD_PROGRESS", 0).getLong("newVersion:" + obj.toString(), 0L);
    }

    public static AppCompatActivity a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            return a(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void a(Context context, int i2) {
        if (a(context) != null) {
            a(context).setRequestedOrientation(i2);
        } else {
            f(context).setRequestedOrientation(i2);
        }
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(Context context, Object obj, long j2) {
        if (Jzvd.t0) {
            String str = "saveProgress: " + j2;
            if (j2 < com.heytap.mcssdk.constant.a.r) {
                j2 = 0;
            }
            context.getSharedPreferences("JZVD_PROGRESS", 0).edit().putLong("newVersion:" + obj.toString(), j2).apply();
        }
    }

    public static void a(Context context, Object obj) {
        if (obj == null) {
            context.getSharedPreferences("JZVD_PROGRESS", 0).edit().clear().apply();
            return;
        }
        context.getSharedPreferences("JZVD_PROGRESS", 0).edit().putLong("newVersion:" + obj.toString(), 0L).apply();
    }
}
