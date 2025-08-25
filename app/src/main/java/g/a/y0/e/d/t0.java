package g.a.y0.e.d;

/* compiled from: ObservableFilter.java */
/* loaded from: classes2.dex */
public final class t0<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super T> f15484b;

    /* compiled from: ObservableFilter.java */
    static final class a<T> extends g.a.y0.d.a<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.r<? super T> f15485f;

        a(g.a.i0<? super T> i0Var, g.a.x0.r<? super T> rVar) {
            super(i0Var);
            this.f15485f = rVar;
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f13944e != 0) {
                this.f13940a.onNext(null);
                return;
            }
            try {
                if (this.f15485f.test(t)) {
                    this.f13940a.onNext(t);
                }
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            T tPoll;
            do {
                tPoll = this.f13942c.poll();
                if (tPoll == null) {
                    break;
                }
            } while (!this.f15485f.test(tPoll));
            return tPoll;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public t0(g.a.g0<T> g0Var, g.a.x0.r<? super T> rVar) {
        super(g0Var);
        this.f15484b = rVar;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15484b));
    }
}
