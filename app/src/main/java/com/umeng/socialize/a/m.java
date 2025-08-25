package com.umeng.socialize.a;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: UPLog.java */
/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f11578a = false;

    public static void a(boolean z) {
        f11578a = z;
    }

    public static void b(String str, Object... objArr) {
        if (a()) {
            a(4, str, a(objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (a()) {
            a(5, str, a(objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        if (a()) {
            a(6, str, a(objArr));
        }
    }

    public static boolean a() {
        return f11578a;
    }

    public static void a(String str, Object... objArr) {
        if (a()) {
            a(3, str, a(objArr));
        }
    }

    private static void b(int i2, String str, String str2) {
        if (i2 == 3) {
            a(str);
            return;
        }
        if (i2 == 4) {
            a(str);
        } else if (i2 == 5) {
            a(str);
        } else {
            if (i2 != 6) {
                return;
            }
            a(str);
        }
    }

    private static void a(int i2, String str, String str2) {
        if (str2 == null) {
            return;
        }
        while (str2.length() > 3072) {
            b(i2, str, str2.substring(0, 3072));
            str2 = str2.substring(3072);
        }
        if (str2.length() > 0) {
            b(i2, str, str2);
        }
    }

    public static String a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "AZX";
        }
        return "AZX." + str;
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        if (objArr.length == 1) {
            return String.valueOf(objArr[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }
}
