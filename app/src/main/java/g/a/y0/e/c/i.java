package g.a.y0.e.c;

/* compiled from: MaybeCount.java */
/* loaded from: classes2.dex */
public final class i<T> extends g.a.k0<Long> implements g.a.y0.c.f<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<T> f14816a;

    /* compiled from: MaybeCount.java */
    static final class a implements g.a.v<Object>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super Long> f14817a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f14818b;

        a(g.a.n0<? super Long> n0Var) {
            this.f14817a = n0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14818b.dispose();
            this.f14818b = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14818b.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14818b = g.a.y0.a.d.DISPOSED;
            this.f14817a.onSuccess(0L);
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14818b = g.a.y0.a.d.DISPOSED;
            this.f14817a.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14818b, cVar)) {
                this.f14818b = cVar;
                this.f14817a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(Object obj) {
            this.f14818b = g.a.y0.a.d.DISPOSED;
            this.f14817a.onSuccess(1L);
        }
    }

    public i(g.a.y<T> yVar) {
        this.f14816a = yVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super Long> n0Var) {
        this.f14816a.a(new a(n0Var));
    }

    @Override // g.a.y0.c.f
    public g.a.y<T> source() {
        return this.f14816a;
    }
}
