package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7666a = "aegis";

    /* renamed from: b, reason: collision with root package name */
    private static SharedPreferences f7667b;

    public static long a(String str, long j2, Context context) {
        return b(context).getLong(str, j2);
    }

    public static synchronized SharedPreferences b(Context context) {
        if (f7667b == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                f7667b = context.createDeviceProtectedStorageContext().getSharedPreferences(f7666a, 0);
            } else {
                f7667b = context.getApplicationContext().getSharedPreferences(f7666a, 0);
            }
        }
        return f7667b;
    }

    public static int a(String str, int i2, Context context) {
        return b(context).getInt(str, i2);
    }

    public static String a(String str, String str2, Context context) {
        return b(context).getString(str, str2);
    }

    public static void a(String str, Context context) {
        b(context).edit().remove(str).apply();
    }

    public static void a(Context context) {
        b(context).edit().clear().apply();
    }

    public static void b(String str, long j2, Context context) {
        b(context).edit().putLong(str, j2).apply();
    }

    public static void b(String str, int i2, Context context) {
        b(context).edit().putInt(str, i2).apply();
    }

    public static void b(String str, String str2, Context context) {
        b(context).edit().putString(str, str2).apply();
    }
}
