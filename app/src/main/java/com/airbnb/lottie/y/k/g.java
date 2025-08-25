package com.airbnb.lottie.y.k;

/* compiled from: Mask.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final a f3886a;

    /* renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.h f3887b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.d f3888c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f3889d;

    /* compiled from: Mask.java */
    public enum a {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public g(a aVar, com.airbnb.lottie.y.j.h hVar, com.airbnb.lottie.y.j.d dVar, boolean z) {
        this.f3886a = aVar;
        this.f3887b = hVar;
        this.f3888c = dVar;
        this.f3889d = z;
    }

    public a a() {
        return this.f3886a;
    }

    public com.airbnb.lottie.y.j.h b() {
        return this.f3887b;
    }

    public com.airbnb.lottie.y.j.d c() {
        return this.f3888c;
    }

    public boolean d() {
        return this.f3889d;
    }
}
