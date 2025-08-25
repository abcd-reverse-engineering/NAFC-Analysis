package com.airbnb.lottie.y.k;

import com.airbnb.lottie.w.b.t;

/* compiled from: ShapeTrimPath.java */
/* loaded from: classes.dex */
public class q implements b {

    /* renamed from: a, reason: collision with root package name */
    private final String f3946a;

    /* renamed from: b, reason: collision with root package name */
    private final a f3947b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.b f3948c;

    /* renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.b f3949d;

    /* renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.b f3950e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f3951f;

    /* compiled from: ShapeTrimPath.java */
    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a forId(int i2) {
            if (i2 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i2 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i2);
        }
    }

    public q(String str, a aVar, com.airbnb.lottie.y.j.b bVar, com.airbnb.lottie.y.j.b bVar2, com.airbnb.lottie.y.j.b bVar3, boolean z) {
        this.f3946a = str;
        this.f3947b = aVar;
        this.f3948c = bVar;
        this.f3949d = bVar2;
        this.f3950e = bVar3;
        this.f3951f = z;
    }

    public com.airbnb.lottie.y.j.b a() {
        return this.f3949d;
    }

    public String b() {
        return this.f3946a;
    }

    public com.airbnb.lottie.y.j.b c() {
        return this.f3950e;
    }

    public com.airbnb.lottie.y.j.b d() {
        return this.f3948c;
    }

    public a e() {
        return this.f3947b;
    }

    public boolean f() {
        return this.f3951f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f3948c + ", end: " + this.f3949d + ", offset: " + this.f3950e + "}";
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new t(aVar, this);
    }
}
