package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: InternalConfig.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f9999a = new String[2];

    public static void a(Context context, String str, String str2) {
        String[] strArr = f9999a;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            com.umeng.common.b.a(context).a(str, str2);
        }
    }

    public static void b(Context context) {
        String[] strArr = f9999a;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            com.umeng.common.b.a(context).b();
        }
    }

    public static String[] a(Context context) {
        String[] strArrA;
        if (!TextUtils.isEmpty(f9999a[0]) && !TextUtils.isEmpty(f9999a[1])) {
            return f9999a;
        }
        if (context == null || (strArrA = com.umeng.common.b.a(context).a()) == null) {
            return null;
        }
        String[] strArr = f9999a;
        strArr[0] = strArrA[0];
        strArr[1] = strArrA[1];
        return strArr;
    }
}
