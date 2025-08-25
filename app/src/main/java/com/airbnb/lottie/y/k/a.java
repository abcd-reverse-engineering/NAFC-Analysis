package com.airbnb.lottie.y.k;

import android.graphics.PointF;

/* compiled from: CircleShape.java */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private final String f3855a;

    /* renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.m<PointF, PointF> f3856b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.f f3857c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f3858d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f3859e;

    public a(String str, com.airbnb.lottie.y.j.m<PointF, PointF> mVar, com.airbnb.lottie.y.j.f fVar, boolean z, boolean z2) {
        this.f3855a = str;
        this.f3856b = mVar;
        this.f3857c = fVar;
        this.f3858d = z;
        this.f3859e = z2;
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new com.airbnb.lottie.w.b.f(jVar, aVar, this);
    }

    public com.airbnb.lottie.y.j.m<PointF, PointF> b() {
        return this.f3856b;
    }

    public com.airbnb.lottie.y.j.f c() {
        return this.f3857c;
    }

    public boolean d() {
        return this.f3859e;
    }

    public boolean e() {
        return this.f3858d;
    }

    public String a() {
        return this.f3855a;
    }
}
