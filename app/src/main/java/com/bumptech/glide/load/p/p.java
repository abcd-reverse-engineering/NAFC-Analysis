package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;

/* compiled from: EngineResource.java */
/* loaded from: classes.dex */
class p<Z> implements v<Z> {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4632a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4633b;

    /* renamed from: c, reason: collision with root package name */
    private final v<Z> f4634c;

    /* renamed from: d, reason: collision with root package name */
    private final a f4635d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.g f4636e;

    /* renamed from: f, reason: collision with root package name */
    private int f4637f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4638g;

    /* compiled from: EngineResource.java */
    interface a {
        void a(com.bumptech.glide.load.g gVar, p<?> pVar);
    }

    p(v<Z> vVar, boolean z, boolean z2, com.bumptech.glide.load.g gVar, a aVar) {
        this.f4634c = (v) com.bumptech.glide.util.j.a(vVar);
        this.f4632a = z;
        this.f4633b = z2;
        this.f4636e = gVar;
        this.f4635d = (a) com.bumptech.glide.util.j.a(aVar);
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return this.f4634c.a();
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<Z> b() {
        return this.f4634c.b();
    }

    synchronized void c() {
        if (this.f4638g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f4637f++;
    }

    v<Z> d() {
        return this.f4634c;
    }

    boolean e() {
        return this.f4632a;
    }

    void f() {
        boolean z;
        synchronized (this) {
            if (this.f4637f <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = this.f4637f - 1;
            this.f4637f = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.f4635d.a(this.f4636e, this);
        }
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Z get() {
        return this.f4634c.get();
    }

    @Override // com.bumptech.glide.load.p.v
    public synchronized void recycle() {
        if (this.f4637f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f4638g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f4638g = true;
        if (this.f4633b) {
            this.f4634c.recycle();
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f4632a + ", listener=" + this.f4635d + ", key=" + this.f4636e + ", acquired=" + this.f4637f + ", isRecycled=" + this.f4638g + ", resource=" + this.f4634c + '}';
    }
}
