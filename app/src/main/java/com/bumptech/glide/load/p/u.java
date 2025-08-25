package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.n.a;

/* compiled from: LockedResource.java */
/* loaded from: classes.dex */
final class u<Z> implements v<Z>, a.f {

    /* renamed from: e, reason: collision with root package name */
    private static final Pools.Pool<u<?>> f4650e = com.bumptech.glide.util.n.a.b(20, new a());

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.util.n.c f4651a = com.bumptech.glide.util.n.c.b();

    /* renamed from: b, reason: collision with root package name */
    private v<Z> f4652b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4653c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4654d;

    /* compiled from: LockedResource.java */
    class a implements a.d<u<?>> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.n.a.d
        public u<?> create() {
            return new u<>();
        }
    }

    u() {
    }

    private void a(v<Z> vVar) {
        this.f4654d = false;
        this.f4653c = true;
        this.f4652b = vVar;
    }

    @NonNull
    static <Z> u<Z> b(v<Z> vVar) {
        u<Z> uVar = (u) com.bumptech.glide.util.j.a(f4650e.acquire());
        uVar.a(vVar);
        return uVar;
    }

    private void e() {
        this.f4652b = null;
        f4650e.release(this);
    }

    @Override // com.bumptech.glide.util.n.a.f
    @NonNull
    public com.bumptech.glide.util.n.c c() {
        return this.f4651a;
    }

    synchronized void d() {
        this.f4651a.a();
        if (!this.f4653c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f4653c = false;
        if (this.f4654d) {
            recycle();
        }
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Z get() {
        return this.f4652b.get();
    }

    @Override // com.bumptech.glide.load.p.v
    public synchronized void recycle() {
        this.f4651a.a();
        this.f4654d = true;
        if (!this.f4653c) {
            this.f4652b.recycle();
            e();
        }
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<Z> b() {
        return this.f4652b.b();
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return this.f4652b.a();
    }
}
