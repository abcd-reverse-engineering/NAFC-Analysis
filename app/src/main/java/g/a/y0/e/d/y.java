package g.a.y0.e.d;

/* compiled from: ObservableCount.java */
/* loaded from: classes2.dex */
public final class y<T> extends g.a.y0.e.d.a<T, Long> {

    /* compiled from: ObservableCount.java */
    static final class a implements g.a.i0<Object>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super Long> f15580a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f15581b;

        /* renamed from: c, reason: collision with root package name */
        long f15582c;

        a(g.a.i0<? super Long> i0Var) {
            this.f15580a = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15581b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15581b.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15580a.onNext(Long.valueOf(this.f15582c));
            this.f15580a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15580a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(Object obj) {
            this.f15582c++;
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15581b, cVar)) {
                this.f15581b = cVar;
                this.f15580a.onSubscribe(this);
            }
        }
    }

    public y(g.a.g0<T> g0Var) {
        super(g0Var);
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super Long> i0Var) {
        this.f14934a.subscribe(new a(i0Var));
    }
}
