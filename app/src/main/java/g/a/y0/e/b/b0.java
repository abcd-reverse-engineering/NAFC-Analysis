package g.a.y0.e.b;

/* compiled from: FlowableCountSingle.java */
/* loaded from: classes2.dex */
public final class b0<T> extends g.a.k0<Long> implements g.a.y0.c.b<Long> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14126a;

    /* compiled from: FlowableCountSingle.java */
    static final class a implements g.a.q<Object>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super Long> f14127a;

        /* renamed from: b, reason: collision with root package name */
        i.d.d f14128b;

        /* renamed from: c, reason: collision with root package name */
        long f14129c;

        a(g.a.n0<? super Long> n0Var) {
            this.f14127a = n0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14128b.cancel();
            this.f14128b = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14128b == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14128b = g.a.y0.i.j.CANCELLED;
            this.f14127a.onSuccess(Long.valueOf(this.f14129c));
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14128b = g.a.y0.i.j.CANCELLED;
            this.f14127a.onError(th);
        }

        @Override // i.d.c
        public void onNext(Object obj) {
            this.f14129c++;
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14128b, dVar)) {
                this.f14128b = dVar;
                this.f14127a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public b0(g.a.l<T> lVar) {
        this.f14126a = lVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super Long> n0Var) {
        this.f14126a.a((g.a.q) new a(n0Var));
    }

    @Override // g.a.y0.c.b
    public g.a.l<Long> b() {
        return g.a.c1.a.a(new a0(this.f14126a));
    }
}
