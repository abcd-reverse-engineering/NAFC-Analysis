package g.a.y0.e.d;

/* compiled from: ObservableDoAfterNext.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class k0<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.g<? super T> f15236b;

    /* compiled from: ObservableDoAfterNext.java */
    static final class a<T> extends g.a.y0.d.a<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.g<? super T> f15237f;

        a(g.a.i0<? super T> i0Var, g.a.x0.g<? super T> gVar) {
            super(i0Var);
            this.f15237f = gVar;
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f13940a.onNext(t);
            if (this.f13944e == 0) {
                try {
                    this.f15237f.accept(t);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.f13942c.poll();
            if (tPoll != null) {
                this.f15237f.accept(tPoll);
            }
            return tPoll;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public k0(g.a.g0<T> g0Var, g.a.x0.g<? super T> gVar) {
        super(g0Var);
        this.f15236b = gVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15236b));
    }
}
