package g.a.y0.e.c;

/* compiled from: MaybeIgnoreElementCompletable.java */
/* loaded from: classes2.dex */
public final class p0<T> extends g.a.c implements g.a.y0.c.c<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<T> f14868a;

    /* compiled from: MaybeIgnoreElementCompletable.java */
    static final class a<T> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f f14869a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f14870b;

        a(g.a.f fVar) {
            this.f14869a = fVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14870b.dispose();
            this.f14870b = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14870b.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14870b = g.a.y0.a.d.DISPOSED;
            this.f14869a.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14870b = g.a.y0.a.d.DISPOSED;
            this.f14869a.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14870b, cVar)) {
                this.f14870b = cVar;
                this.f14869a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.f14870b = g.a.y0.a.d.DISPOSED;
            this.f14869a.onComplete();
        }
    }

    public p0(g.a.y<T> yVar) {
        this.f14868a = yVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14868a.a(new a(fVar));
    }

    @Override // g.a.y0.c.c
    public g.a.s<T> c() {
        return g.a.c1.a.a(new o0(this.f14868a));
    }
}
