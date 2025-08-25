package com.heytap.mcssdk.k;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5899a = "mcssdk---";

    /* renamed from: b, reason: collision with root package name */
    private static String f5900b = "MCS";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f5901c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f5902d = false;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f5903e = true;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f5904f = true;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f5905g = true;

    /* renamed from: h, reason: collision with root package name */
    private static String f5906h = "-->";

    /* renamed from: i, reason: collision with root package name */
    private static boolean f5907i = true;

    public static String a() {
        return f5900b;
    }

    public static void a(Exception exc) {
        if (!f5905g || exc == null) {
            return;
        }
        exc.getMessage();
    }

    public static void a(String str) {
        if (f5901c && f5907i) {
            String str2 = f5900b + f5906h + str;
        }
    }

    public static void a(String str, String str2) {
        if (f5901c && f5907i) {
            String str3 = f5900b + f5906h + str2;
        }
    }

    public static void a(String str, Throwable th) {
        if (f5905g) {
            th.toString();
        }
    }

    public static void a(boolean z) {
        f5901c = z;
    }

    public static void b(String str) {
        if (f5903e && f5907i) {
            String str2 = f5900b + f5906h + str;
        }
    }

    public static void b(String str, String str2) {
        if (f5903e && f5907i) {
            String str3 = f5900b + f5906h + str2;
        }
    }

    public static void b(boolean z) {
        f5903e = z;
    }

    public static boolean b() {
        return f5901c;
    }

    public static void c(String str) {
        if (f5902d && f5907i) {
            String str2 = f5900b + f5906h + str;
        }
    }

    public static void c(String str, String str2) {
        if (f5902d && f5907i) {
            String str3 = f5900b + f5906h + str2;
        }
    }

    public static void c(boolean z) {
        f5902d = z;
    }

    public static boolean c() {
        return f5903e;
    }

    public static void d(String str) {
        if (f5904f && f5907i) {
            String str2 = f5900b + f5906h + str;
        }
    }

    public static void d(String str, String str2) {
        if (f5904f && f5907i) {
            String str3 = f5900b + f5906h + str2;
        }
    }

    public static void d(boolean z) {
        f5904f = z;
    }

    public static boolean d() {
        return f5902d;
    }

    public static void e(String str) {
        if (f5905g && f5907i) {
            String str2 = f5900b + f5906h + str;
        }
    }

    public static void e(String str, String str2) {
        if (f5905g && f5907i) {
            String str3 = f5900b + f5906h + str2;
        }
    }

    public static void e(boolean z) {
        f5905g = z;
    }

    public static boolean e() {
        return f5904f;
    }

    public static void f(String str) {
        f5900b = str;
    }

    public static void f(boolean z) {
        f5907i = z;
        boolean z2 = f5907i;
        f5901c = z2;
        f5903e = z2;
        f5902d = z2;
        f5904f = z2;
        f5905g = z2;
    }

    public static boolean f() {
        return f5905g;
    }

    public static void g(String str) {
        f5906h = str;
    }

    public static boolean g() {
        return f5907i;
    }

    public static String h() {
        return f5906h;
    }
}
