package com.airbnb.lottie.y.k;

import android.graphics.PointF;

/* compiled from: RectangleShape.java */
/* loaded from: classes.dex */
public class j implements b {

    /* renamed from: a, reason: collision with root package name */
    private final String f3906a;

    /* renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.m<PointF, PointF> f3907b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.m<PointF, PointF> f3908c;

    /* renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.b f3909d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f3910e;

    public j(String str, com.airbnb.lottie.y.j.m<PointF, PointF> mVar, com.airbnb.lottie.y.j.m<PointF, PointF> mVar2, com.airbnb.lottie.y.j.b bVar, boolean z) {
        this.f3906a = str;
        this.f3907b = mVar;
        this.f3908c = mVar2;
        this.f3909d = bVar;
        this.f3910e = z;
    }

    public com.airbnb.lottie.y.j.b a() {
        return this.f3909d;
    }

    public String b() {
        return this.f3906a;
    }

    public com.airbnb.lottie.y.j.m<PointF, PointF> c() {
        return this.f3907b;
    }

    public com.airbnb.lottie.y.j.m<PointF, PointF> d() {
        return this.f3908c;
    }

    public boolean e() {
        return this.f3910e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f3907b + ", size=" + this.f3908c + '}';
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new com.airbnb.lottie.w.b.p(jVar, aVar, this);
    }
}
