package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;

/* compiled from: UMInternalUtils.java */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10823a = at.b().b(at.r);

    /* renamed from: b, reason: collision with root package name */
    private static final String f10824b = "um_common_strength";

    /* renamed from: c, reason: collision with root package name */
    private static final String f10825c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f10823a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f10825c, null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f10823a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f10825c, str).commit();
    }
}
