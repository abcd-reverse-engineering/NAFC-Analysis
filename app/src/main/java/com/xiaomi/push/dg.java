package com.xiaomi.push;

/* loaded from: classes2.dex */
public class dg {

    /* renamed from: a, reason: collision with root package name */
    private static volatile dg f12641a;

    /* renamed from: a, reason: collision with other field name */
    private df f326a;

    public static dg a() {
        if (f12641a == null) {
            synchronized (dg.class) {
                if (f12641a == null) {
                    f12641a = new dg();
                }
            }
        }
        return f12641a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public df m269a() {
        return this.f326a;
    }

    public void a(df dfVar) {
        this.f326a = dfVar;
    }
}
