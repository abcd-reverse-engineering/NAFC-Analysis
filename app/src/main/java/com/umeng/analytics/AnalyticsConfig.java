package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.j;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_START_TIME = "startTime";

    /* renamed from: a, reason: collision with root package name */
    static double[] f9962a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f9963b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f9964c = null;

    /* renamed from: d, reason: collision with root package name */
    private static String f9965d = null;

    /* renamed from: e, reason: collision with root package name */
    private static int f9966e = 0;
    public static boolean enable = true;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;
    public static final String RTD_SP_FILE = at.b().b(at.A);

    /* renamed from: f, reason: collision with root package name */
    private static Object f9967f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static boolean f9968g = false;

    /* renamed from: h, reason: collision with root package name */
    private static String f9969h = "";

    static void a(String str) {
        f9964c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            if (cls != null) {
                return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return f9962a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f9967f) {
            str = f9969h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f9965d)) {
            f9965d = com.umeng.common.b.a(context).c();
        }
        return f9965d;
    }

    public static int getVerticalType(Context context) {
        if (f9966e == 0) {
            f9966e = com.umeng.common.b.a(context).d();
        }
        return f9966e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z;
        synchronized (f9967f) {
            z = f9968g;
        }
        return z;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f9967f) {
            f9968g = false;
            f9969h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f9967f) {
            f9968g = true;
            if (map != null && map.containsKey(DEBUG_KEY)) {
                f9969h = map.get(DEBUG_KEY);
            }
        }
    }

    static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.A, 0, "\\|");
        } else {
            f9965d = str;
            com.umeng.common.b.a(context).a(f9965d);
        }
    }

    static void a(Context context, int i2) {
        f9966e = i2;
        com.umeng.common.b.a(context).a(f9966e);
    }
}
