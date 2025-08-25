package com.airbnb.lottie.y.k;

/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public class o implements b {

    /* renamed from: a, reason: collision with root package name */
    private final String f3928a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3929b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.h f3930c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f3931d;

    public o(String str, int i2, com.airbnb.lottie.y.j.h hVar, boolean z) {
        this.f3928a = str;
        this.f3929b = i2;
        this.f3930c = hVar;
        this.f3931d = z;
    }

    public String a() {
        return this.f3928a;
    }

    public com.airbnb.lottie.y.j.h b() {
        return this.f3930c;
    }

    public boolean c() {
        return this.f3931d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f3928a + ", index=" + this.f3929b + '}';
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new com.airbnb.lottie.w.b.r(jVar, aVar, this);
    }
}
