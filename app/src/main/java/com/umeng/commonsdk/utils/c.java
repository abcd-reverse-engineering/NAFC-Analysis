package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

/* compiled from: SLModeUtil.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final String f11087b = "lastReqTime";

    /* renamed from: c, reason: collision with root package name */
    private static final int f11088c = 48;

    /* renamed from: d, reason: collision with root package name */
    private static final int f11089d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static final int f11090e = 720;

    /* renamed from: f, reason: collision with root package name */
    private static final String f11091f = "iss";

    /* renamed from: g, reason: collision with root package name */
    private static final String f11092g = "sinr";

    /* renamed from: h, reason: collision with root package name */
    private static final String f11093h = "clean";

    /* renamed from: i, reason: collision with root package name */
    private static boolean f11094i;

    /* renamed from: j, reason: collision with root package name */
    private static int f11095j;

    /* renamed from: a, reason: collision with root package name */
    private static final String f11086a = at.b().b(at.z);

    /* renamed from: k, reason: collision with root package name */
    private static Object f11096k = new Object();

    static {
        f11094i = false;
        f11095j = 720;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(appContext, f11091f, "");
            if (TextUtils.isEmpty(strImprintProperty) || !"1".equals(strImprintProperty)) {
                return;
            }
            synchronized (f11096k) {
                f11094i = true;
            }
            String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, f11092g, "");
            if (TextUtils.isEmpty(strImprintProperty)) {
                f11095j = 48;
                return;
            }
            try {
                f11095j = a(Integer.parseInt(strImprintProperty2));
            } catch (Throwable unused) {
                f11095j = 48;
            }
        }
    }

    private static int a(int i2) {
        if (i2 > 720) {
            return 720;
        }
        if (i2 < 1) {
            return 1;
        }
        return i2;
    }

    public static boolean a() {
        boolean z;
        synchronized (f11096k) {
            z = f11094i;
        }
        return z;
    }

    public static long b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f11086a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(f11087b, 0L);
        }
        return 0L;
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f11086a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f11093h, true).commit();
        }
    }

    public static void d(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f11086a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f11093h, false).commit();
        }
    }

    public static boolean e(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f11086a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(f11093h, false);
        }
        return false;
    }

    public static int a(Context context) {
        int i2;
        synchronized (f11096k) {
            i2 = f11095j;
        }
        return i2;
    }

    public static boolean a(long j2, long j3, int i2) {
        Date date = new Date(j3);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        calendar.add(10, i2);
        return date.after(calendar.getTime());
    }

    public static void a(Context context, long j2) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f11086a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(f11087b, j2).commit();
        }
    }
}
