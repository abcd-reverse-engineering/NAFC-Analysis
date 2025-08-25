package com.xiaomi.push;

/* loaded from: classes2.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static int f13486a;

    /* renamed from: a, reason: collision with other field name */
    public static final String f1107a;

    /* renamed from: a, reason: collision with other field name */
    public static boolean f1108a;

    static {
        f1107a = aa.f12412a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f1108a = false;
        f13486a = 1;
        if (f1107a.equalsIgnoreCase("SANDBOX")) {
            f13486a = 2;
        } else if (f1107a.equalsIgnoreCase("ONEBOX")) {
            f13486a = 3;
        } else {
            f13486a = 1;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m766a() {
        return f13486a == 2;
    }

    public static boolean b() {
        return f13486a == 3;
    }

    public static int a() {
        return f13486a;
    }

    public static void a(int i2) {
        f13486a = i2;
    }
}
