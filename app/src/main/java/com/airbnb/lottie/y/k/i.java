package com.airbnb.lottie.y.k;

import android.graphics.PointF;

/* compiled from: PolystarShape.java */
/* loaded from: classes.dex */
public class i implements b {

    /* renamed from: a, reason: collision with root package name */
    private final String f3895a;

    /* renamed from: b, reason: collision with root package name */
    private final a f3896b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.b f3897c;

    /* renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.m<PointF, PointF> f3898d;

    /* renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.b f3899e;

    /* renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.b f3900f;

    /* renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.b f3901g;

    /* renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.b f3902h;

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.b f3903i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f3904j;

    /* compiled from: PolystarShape.java */
    public enum a {
        STAR(1),
        POLYGON(2);

        private final int value;

        a(int i2) {
            this.value = i2;
        }

        public static a forValue(int i2) {
            for (a aVar : values()) {
                if (aVar.value == i2) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public i(String str, a aVar, com.airbnb.lottie.y.j.b bVar, com.airbnb.lottie.y.j.m<PointF, PointF> mVar, com.airbnb.lottie.y.j.b bVar2, com.airbnb.lottie.y.j.b bVar3, com.airbnb.lottie.y.j.b bVar4, com.airbnb.lottie.y.j.b bVar5, com.airbnb.lottie.y.j.b bVar6, boolean z) {
        this.f3895a = str;
        this.f3896b = aVar;
        this.f3897c = bVar;
        this.f3898d = mVar;
        this.f3899e = bVar2;
        this.f3900f = bVar3;
        this.f3901g = bVar4;
        this.f3902h = bVar5;
        this.f3903i = bVar6;
        this.f3904j = z;
    }

    public com.airbnb.lottie.y.j.b a() {
        return this.f3900f;
    }

    public com.airbnb.lottie.y.j.b b() {
        return this.f3902h;
    }

    public String c() {
        return this.f3895a;
    }

    public com.airbnb.lottie.y.j.b d() {
        return this.f3901g;
    }

    public com.airbnb.lottie.y.j.b e() {
        return this.f3903i;
    }

    public com.airbnb.lottie.y.j.b f() {
        return this.f3897c;
    }

    public com.airbnb.lottie.y.j.m<PointF, PointF> g() {
        return this.f3898d;
    }

    public com.airbnb.lottie.y.j.b h() {
        return this.f3899e;
    }

    public a i() {
        return this.f3896b;
    }

    public boolean j() {
        return this.f3904j;
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new com.airbnb.lottie.w.b.o(jVar, aVar, this);
    }
}
