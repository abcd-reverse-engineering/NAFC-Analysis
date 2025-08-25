package g.a.y0.e.c;

/* compiled from: MaybeContains.java */
/* loaded from: classes2.dex */
public final class h<T> extends g.a.k0<Boolean> implements g.a.y0.c.f<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<T> f14808a;

    /* renamed from: b, reason: collision with root package name */
    final Object f14809b;

    /* compiled from: MaybeContains.java */
    static final class a implements g.a.v<Object>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super Boolean> f14810a;

        /* renamed from: b, reason: collision with root package name */
        final Object f14811b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14812c;

        a(g.a.n0<? super Boolean> n0Var, Object obj) {
            this.f14810a = n0Var;
            this.f14811b = obj;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14812c.dispose();
            this.f14812c = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14812c.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14812c = g.a.y0.a.d.DISPOSED;
            this.f14810a.onSuccess(false);
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14812c = g.a.y0.a.d.DISPOSED;
            this.f14810a.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14812c, cVar)) {
                this.f14812c = cVar;
                this.f14810a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(Object obj) {
            this.f14812c = g.a.y0.a.d.DISPOSED;
            this.f14810a.onSuccess(Boolean.valueOf(g.a.y0.b.b.a(obj, this.f14811b)));
        }
    }

    public h(g.a.y<T> yVar, Object obj) {
        this.f14808a = yVar;
        this.f14809b = obj;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super Boolean> n0Var) {
        this.f14808a.a(new a(n0Var, this.f14809b));
    }

    @Override // g.a.y0.c.f
    public g.a.y<T> source() {
        return this.f14808a;
    }
}
