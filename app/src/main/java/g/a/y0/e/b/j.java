package g.a.y0.e.b;

/* compiled from: FlowableAnySingle.java */
/* loaded from: classes2.dex */
public final class j<T> extends g.a.k0<Boolean> implements g.a.y0.c.b<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14291a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super T> f14292b;

    /* compiled from: FlowableAnySingle.java */
    static final class a<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super Boolean> f14293a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f14294b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f14295c;

        /* renamed from: d, reason: collision with root package name */
        boolean f14296d;

        a(g.a.n0<? super Boolean> n0Var, g.a.x0.r<? super T> rVar) {
            this.f14293a = n0Var;
            this.f14294b = rVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14295c.cancel();
            this.f14295c = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14295c == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14296d) {
                return;
            }
            this.f14296d = true;
            this.f14295c = g.a.y0.i.j.CANCELLED;
            this.f14293a.onSuccess(false);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14296d) {
                g.a.c1.a.b(th);
                return;
            }
            this.f14296d = true;
            this.f14295c = g.a.y0.i.j.CANCELLED;
            this.f14293a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14296d) {
                return;
            }
            try {
                if (this.f14294b.test(t)) {
                    this.f14296d = true;
                    this.f14295c.cancel();
                    this.f14295c = g.a.y0.i.j.CANCELLED;
                    this.f14293a.onSuccess(true);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14295c.cancel();
                this.f14295c = g.a.y0.i.j.CANCELLED;
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14295c, dVar)) {
                this.f14295c = dVar;
                this.f14293a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public j(g.a.l<T> lVar, g.a.x0.r<? super T> rVar) {
        this.f14291a = lVar;
        this.f14292b = rVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super Boolean> n0Var) {
        this.f14291a.a((g.a.q) new a(n0Var, this.f14292b));
    }

    @Override // g.a.y0.c.b
    public g.a.l<Boolean> b() {
        return g.a.c1.a.a(new i(this.f14291a, this.f14292b));
    }
}
