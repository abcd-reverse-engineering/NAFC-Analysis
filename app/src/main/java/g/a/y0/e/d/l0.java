package g.a.y0.e.d;

/* compiled from: ObservableDoFinally.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class l0<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.a f15244b;

    /* compiled from: ObservableDoFinally.java */
    static final class a<T> extends g.a.y0.d.b<T> implements g.a.i0<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final g.a.i0<? super T> actual;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15245d;
        final g.a.x0.a onFinally;
        g.a.y0.c.j<T> qd;
        boolean syncFused;

        a(g.a.i0<? super T> i0Var, g.a.x0.a aVar) {
            this.actual = i0Var;
            this.onFinally = aVar;
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.qd.clear();
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15245d.dispose();
            runFinally();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15245d.isDisposed();
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.qd.isEmpty();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15245d, cVar)) {
                this.f15245d = cVar;
                if (cVar instanceof g.a.y0.c.j) {
                    this.qd = (g.a.y0.c.j) cVar;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.qd.poll();
            if (tPoll == null && this.syncFused) {
                runFinally();
            }
            return tPoll;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            g.a.y0.c.j<T> jVar = this.qd;
            if (jVar == null || (i2 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = jVar.requestFusion(i2);
            if (iRequestFusion != 0) {
                this.syncFused = iRequestFusion == 1;
            }
            return iRequestFusion;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.c1.a.b(th);
                }
            }
        }
    }

    public l0(g.a.g0<T> g0Var, g.a.x0.a aVar) {
        super(g0Var);
        this.f15244b = aVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15244b));
    }
}
