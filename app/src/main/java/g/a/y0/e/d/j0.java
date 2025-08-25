package g.a.y0.e.d;

/* compiled from: ObservableDistinctUntilChanged.java */
/* loaded from: classes2.dex */
public final class j0<T, K> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, K> f15222b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.d<? super K, ? super K> f15223c;

    /* compiled from: ObservableDistinctUntilChanged.java */
    static final class a<T, K> extends g.a.y0.d.a<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.o<? super T, K> f15224f;

        /* renamed from: g, reason: collision with root package name */
        final g.a.x0.d<? super K, ? super K> f15225g;

        /* renamed from: h, reason: collision with root package name */
        K f15226h;

        /* renamed from: i, reason: collision with root package name */
        boolean f15227i;

        a(g.a.i0<? super T> i0Var, g.a.x0.o<? super T, K> oVar, g.a.x0.d<? super K, ? super K> dVar) {
            super(i0Var);
            this.f15224f = oVar;
            this.f15225g = dVar;
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f13943d) {
                return;
            }
            if (this.f13944e != 0) {
                this.f13940a.onNext(t);
                return;
            }
            try {
                K kApply = this.f15224f.apply(t);
                if (this.f15227i) {
                    boolean zA = this.f15225g.a(this.f15226h, kApply);
                    this.f15226h = kApply;
                    if (zA) {
                        return;
                    }
                } else {
                    this.f15227i = true;
                    this.f15226h = kApply;
                }
                this.f13940a.onNext(t);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            while (true) {
                T tPoll = this.f13942c.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f15224f.apply(tPoll);
                if (!this.f15227i) {
                    this.f15227i = true;
                    this.f15226h = kApply;
                    return tPoll;
                }
                if (!this.f15225g.a(this.f15226h, kApply)) {
                    this.f15226h = kApply;
                    return tPoll;
                }
                this.f15226h = kApply;
            }
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public j0(g.a.g0<T> g0Var, g.a.x0.o<? super T, K> oVar, g.a.x0.d<? super K, ? super K> dVar) {
        super(g0Var);
        this.f15222b = oVar;
        this.f15223c = dVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15222b, this.f15223c));
    }
}
