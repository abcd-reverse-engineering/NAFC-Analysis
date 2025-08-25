package g.a.y0.e.b;

/* compiled from: FlowableAllSingle.java */
/* loaded from: classes2.dex */
public final class g<T> extends g.a.k0<Boolean> implements g.a.y0.c.b<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14229a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super T> f14230b;

    /* compiled from: FlowableAllSingle.java */
    static final class a<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super Boolean> f14231a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f14232b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f14233c;

        /* renamed from: d, reason: collision with root package name */
        boolean f14234d;

        a(g.a.n0<? super Boolean> n0Var, g.a.x0.r<? super T> rVar) {
            this.f14231a = n0Var;
            this.f14232b = rVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14233c.cancel();
            this.f14233c = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14233c == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14234d) {
                return;
            }
            this.f14234d = true;
            this.f14233c = g.a.y0.i.j.CANCELLED;
            this.f14231a.onSuccess(true);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14234d) {
                g.a.c1.a.b(th);
                return;
            }
            this.f14234d = true;
            this.f14233c = g.a.y0.i.j.CANCELLED;
            this.f14231a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14234d) {
                return;
            }
            try {
                if (this.f14232b.test(t)) {
                    return;
                }
                this.f14234d = true;
                this.f14233c.cancel();
                this.f14233c = g.a.y0.i.j.CANCELLED;
                this.f14231a.onSuccess(false);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14233c.cancel();
                this.f14233c = g.a.y0.i.j.CANCELLED;
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14233c, dVar)) {
                this.f14233c = dVar;
                this.f14231a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public g(g.a.l<T> lVar, g.a.x0.r<? super T> rVar) {
        this.f14229a = lVar;
        this.f14230b = rVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super Boolean> n0Var) {
        this.f14229a.a((g.a.q) new a(n0Var, this.f14230b));
    }

    @Override // g.a.y0.c.b
    public g.a.l<Boolean> b() {
        return g.a.c1.a.a(new f(this.f14229a, this.f14230b));
    }
}
