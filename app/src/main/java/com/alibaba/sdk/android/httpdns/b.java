package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f4001a = null;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f4a = true;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f4002b = true;

    static void a(Context context) {
        if (context != null) {
            f4001a = context.getSharedPreferences("httpdns_config_enable", 0);
            SharedPreferences sharedPreferences = f4001a;
            if (sharedPreferences != null) {
                f4a = sharedPreferences.getBoolean("key_enable", true);
            }
        }
    }

    public static void a(boolean z) {
        f4a = z;
        SharedPreferences sharedPreferences = f4001a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("key_enable", z);
            editorEdit.apply();
        }
    }

    public static boolean a() {
        return f4a && f4002b;
    }

    public static void b(boolean z) {
        f4002b = z;
    }
}
