package com.umeng.ccg;

import java.util.HashMap;
import java.util.Map;

/* compiled from: CcgSwitch.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f10604a = true;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f10605b = true;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f10606c = true;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f10607d = true;

    /* renamed from: e, reason: collision with root package name */
    private static Object f10608e;

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, Boolean> f10609f;

    static {
        if (f10609f == null) {
            f10609f = new HashMap();
            f10608e = new Object();
        }
    }

    public static boolean a() {
        boolean z;
        synchronized (f10608e) {
            z = f10604a;
        }
        return z;
    }

    public static boolean b() {
        boolean z;
        synchronized (f10608e) {
            z = f10605b;
        }
        return z;
    }

    public static boolean c() {
        boolean z;
        synchronized (f10608e) {
            z = f10606c;
        }
        return z;
    }

    public static boolean d() {
        boolean z;
        synchronized (f10608e) {
            z = f10607d;
        }
        return z;
    }

    public static void a(boolean z) {
        synchronized (f10608e) {
            f10607d = z;
            f10609f.put(a.f10595e, Boolean.valueOf(z));
        }
    }

    public static boolean a(String str) {
        boolean zBooleanValue;
        synchronized (f10608e) {
            zBooleanValue = f10609f.containsKey(str) ? f10609f.get(str).booleanValue() : true;
        }
        return zBooleanValue;
    }
}
