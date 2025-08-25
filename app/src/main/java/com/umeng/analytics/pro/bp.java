package com.umeng.analytics.pro;

/* compiled from: TApplicationException.java */
/* loaded from: classes2.dex */
public class bp extends bw {

    /* renamed from: a, reason: collision with root package name */
    public static final int f10182a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f10183b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f10184c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f10185d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f10186e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static final int f10187f = 5;

    /* renamed from: g, reason: collision with root package name */
    public static final int f10188g = 6;

    /* renamed from: h, reason: collision with root package name */
    public static final int f10189h = 7;

    /* renamed from: j, reason: collision with root package name */
    private static final cu f10190j = new cu("TApplicationException");

    /* renamed from: k, reason: collision with root package name */
    private static final ck f10191k = new ck("message", (byte) 11, 1);

    /* renamed from: l, reason: collision with root package name */
    private static final ck f10192l = new ck("type", (byte) 8, 2);

    /* renamed from: m, reason: collision with root package name */
    private static final long f10193m = 1;

    /* renamed from: i, reason: collision with root package name */
    protected int f10194i;

    public bp() {
        this.f10194i = 0;
    }

    public int a() {
        return this.f10194i;
    }

    public void b(cp cpVar) throws bw {
        cpVar.a(f10190j);
        if (getMessage() != null) {
            cpVar.a(f10191k);
            cpVar.a(getMessage());
            cpVar.c();
        }
        cpVar.a(f10192l);
        cpVar.a(this.f10194i);
        cpVar.c();
        cpVar.d();
        cpVar.b();
    }

    public static bp a(cp cpVar) throws bw {
        cpVar.j();
        String strZ = null;
        int iW = 0;
        while (true) {
            ck ckVarL = cpVar.l();
            byte b2 = ckVarL.f10264b;
            if (b2 == 0) {
                cpVar.k();
                return new bp(iW, strZ);
            }
            short s = ckVarL.f10265c;
            if (s != 1) {
                if (s != 2) {
                    cs.a(cpVar, b2);
                } else if (b2 == 8) {
                    iW = cpVar.w();
                } else {
                    cs.a(cpVar, b2);
                }
            } else if (b2 == 11) {
                strZ = cpVar.z();
            } else {
                cs.a(cpVar, b2);
            }
            cpVar.m();
        }
    }

    public bp(int i2) {
        this.f10194i = 0;
        this.f10194i = i2;
    }

    public bp(int i2, String str) {
        super(str);
        this.f10194i = 0;
        this.f10194i = i2;
    }

    public bp(String str) {
        super(str);
        this.f10194i = 0;
    }
}
