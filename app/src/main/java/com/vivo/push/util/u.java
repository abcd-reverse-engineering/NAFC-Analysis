package com.vivo.push.util;

import android.content.Context;

/* compiled from: LogUtil.java */
/* loaded from: classes2.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final t f12299a = new s();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f12300b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f12301c;

    static {
        c();
    }

    public static boolean a() {
        return f12300b;
    }

    public static boolean b() {
        return f12300b && f12301c;
    }

    private static void c() {
        f12300b = ag.b("persist.sys.log.ctrl", "no").equals("yes");
    }

    public static int d(String str, String str2) {
        return f12299a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f12299a.e(str, str2);
    }

    public static void a(boolean z) {
        c();
        f12301c = z;
    }

    public static int c(String str, String str2) {
        return f12299a.c(str, str2);
    }

    public static int b(String str, String str2) {
        return f12299a.b(str, str2);
    }

    public static void c(Context context, String str) {
        f12299a.c(context, str);
    }

    public static int a(String str, String str2) {
        return f12299a.a(str, str2);
    }

    public static int b(String str, String str2, Throwable th) {
        return f12299a.b(str, str2, th);
    }

    public static int a(String str, Throwable th) {
        return f12299a.a(str, th);
    }

    public static void b(Context context, String str) {
        f12299a.b(context, str);
    }

    public static int a(String str, String str2, Throwable th) {
        return f12299a.a(str, str2, th);
    }

    public static void b(String str) {
        if (f12300b) {
            f12299a.c("VIVO.PUSH.PROFILE.SYNC", str);
        }
    }

    public static String a(Throwable th) {
        return f12299a.a(th);
    }

    public static void a(Context context, String str) {
        f12299a.a(context, str);
    }

    public static void a(String str) {
        if (f12300b) {
            f12299a.c("VIVO.PUSH.MSG_NODE", str);
        }
    }

    public static void a(int i2, String str) {
        a("RunTimeException", "code: " + i2 + ", exceptionMsg: " + str);
    }
}
