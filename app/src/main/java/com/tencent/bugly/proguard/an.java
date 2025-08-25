package com.tencent.bugly.proguard;

import java.util.Locale;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class an {

    /* renamed from: a, reason: collision with root package name */
    public static String f9252a = "CrashReportInfo";

    /* renamed from: b, reason: collision with root package name */
    public static String f9253b = "CrashReport";

    /* renamed from: c, reason: collision with root package name */
    public static boolean f9254c = false;

    private static boolean a(int i2, String str, Object... objArr) {
        if (!f9254c) {
            return false;
        }
        f(str, objArr);
        return i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5;
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    private static String f(String str, Object... objArr) {
        return str == null ? c.c.a.b.a.a.f3101h : (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr);
    }

    public static boolean b(Class cls, String str, Object... objArr) {
        return a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean c(Class cls, String str, Object... objArr) {
        return a(3, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    private static boolean a(int i2, Throwable th) {
        if (f9254c) {
            return a(i2, aq.a(th), new Object[0]);
        }
        return false;
    }

    public static boolean b(Throwable th) {
        return a(3, th);
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(Throwable th) {
        return a(2, th);
    }
}
