package g.a.y0.e.d;

/* compiled from: ObservableReduceSeedSingle.java */
/* loaded from: classes2.dex */
public final class g2<T, R> extends g.a.k0<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15151a;

    /* renamed from: b, reason: collision with root package name */
    final R f15152b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<R, ? super T, R> f15153c;

    /* compiled from: ObservableReduceSeedSingle.java */
    static final class a<T, R> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super R> f15154a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.c<R, ? super T, R> f15155b;

        /* renamed from: c, reason: collision with root package name */
        R f15156c;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15157d;

        a(g.a.n0<? super R> n0Var, g.a.x0.c<R, ? super T, R> cVar, R r) {
            this.f15154a = n0Var;
            this.f15156c = r;
            this.f15155b = cVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15157d.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15157d.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            R r = this.f15156c;
            this.f15156c = null;
            if (r != null) {
                this.f15154a.onSuccess(r);
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            R r = this.f15156c;
            this.f15156c = null;
            if (r != null) {
                this.f15154a.onError(th);
            } else {
                g.a.c1.a.b(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            R r = this.f15156c;
            if (r != null) {
                try {
                    this.f15156c = (R) g.a.y0.b.b.a(this.f15155b.apply(r, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.f15157d.dispose();
                    onError(th);
                }
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15157d, cVar)) {
                this.f15157d = cVar;
                this.f15154a.onSubscribe(this);
            }
        }
    }

    public g2(g.a.g0<T> g0Var, R r, g.a.x0.c<R, ? super T, R> cVar) {
        this.f15151a = g0Var;
        this.f15152b = r;
        this.f15153c = cVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super R> n0Var) {
        this.f15151a.subscribe(new a(n0Var, this.f15153c, this.f15152b));
    }
}
