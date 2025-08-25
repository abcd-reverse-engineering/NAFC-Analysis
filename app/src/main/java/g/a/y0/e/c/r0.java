package g.a.y0.e.c;

/* compiled from: MaybeIsEmptySingle.java */
/* loaded from: classes2.dex */
public final class r0<T> extends g.a.k0<Boolean> implements g.a.y0.c.f<T>, g.a.y0.c.c<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<T> f14885a;

    /* compiled from: MaybeIsEmptySingle.java */
    static final class a<T> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super Boolean> f14886a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f14887b;

        a(g.a.n0<? super Boolean> n0Var) {
            this.f14886a = n0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14887b.dispose();
            this.f14887b = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14887b.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14887b = g.a.y0.a.d.DISPOSED;
            this.f14886a.onSuccess(true);
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14887b = g.a.y0.a.d.DISPOSED;
            this.f14886a.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14887b, cVar)) {
                this.f14887b = cVar;
                this.f14886a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.f14887b = g.a.y0.a.d.DISPOSED;
            this.f14886a.onSuccess(false);
        }
    }

    public r0(g.a.y<T> yVar) {
        this.f14885a = yVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super Boolean> n0Var) {
        this.f14885a.a(new a(n0Var));
    }

    @Override // g.a.y0.c.c
    public g.a.s<Boolean> c() {
        return g.a.c1.a.a(new q0(this.f14885a));
    }

    @Override // g.a.y0.c.f
    public g.a.y<T> source() {
        return this.f14885a;
    }
}
