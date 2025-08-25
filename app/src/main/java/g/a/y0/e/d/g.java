package g.a.y0.e.d;

/* compiled from: ObservableAllSingle.java */
/* loaded from: classes2.dex */
public final class g<T> extends g.a.k0<Boolean> implements g.a.y0.c.d<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15132a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super T> f15133b;

    /* compiled from: ObservableAllSingle.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super Boolean> f15134a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f15135b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15136c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15137d;

        a(g.a.n0<? super Boolean> n0Var, g.a.x0.r<? super T> rVar) {
            this.f15134a = n0Var;
            this.f15135b = rVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15136c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15136c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15137d) {
                return;
            }
            this.f15137d = true;
            this.f15134a.onSuccess(true);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15137d) {
                g.a.c1.a.b(th);
            } else {
                this.f15137d = true;
                this.f15134a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15137d) {
                return;
            }
            try {
                if (this.f15135b.test(t)) {
                    return;
                }
                this.f15137d = true;
                this.f15136c.dispose();
                this.f15134a.onSuccess(false);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15136c.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15136c, cVar)) {
                this.f15136c = cVar;
                this.f15134a.onSubscribe(this);
            }
        }
    }

    public g(g.a.g0<T> g0Var, g.a.x0.r<? super T> rVar) {
        this.f15132a = g0Var;
        this.f15133b = rVar;
    }

    @Override // g.a.y0.c.d
    public g.a.b0<Boolean> a() {
        return g.a.c1.a.a(new f(this.f15132a, this.f15133b));
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super Boolean> n0Var) {
        this.f15132a.subscribe(new a(n0Var, this.f15133b));
    }
}
