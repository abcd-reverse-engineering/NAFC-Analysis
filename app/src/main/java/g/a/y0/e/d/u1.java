package g.a.y0.e.d;

/* compiled from: ObservableMap.java */
/* loaded from: classes2.dex */
public final class u1<T, U> extends g.a.y0.e.d.a<T, U> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends U> f15505b;

    /* compiled from: ObservableMap.java */
    static final class a<T, U> extends g.a.y0.d.a<T, U> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends U> f15506f;

        a(g.a.i0<? super U> i0Var, g.a.x0.o<? super T, ? extends U> oVar) {
            super(i0Var);
            this.f15506f = oVar;
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f13943d) {
                return;
            }
            if (this.f13944e != 0) {
                this.f13940a.onNext(null);
                return;
            }
            try {
                this.f13940a.onNext(g.a.y0.b.b.a(this.f15506f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public U poll() throws Exception {
            T tPoll = this.f13942c.poll();
            if (tPoll != null) {
                return (U) g.a.y0.b.b.a(this.f15506f.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public u1(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends U> oVar) {
        super(g0Var);
        this.f15505b = oVar;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super U> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15505b));
    }
}
