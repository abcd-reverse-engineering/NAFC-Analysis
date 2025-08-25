package g.a.y0.e.d;

/* compiled from: ObservableCountSingle.java */
/* loaded from: classes2.dex */
public final class z<T> extends g.a.k0<Long> implements g.a.y0.c.d<Long> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15597a;

    /* compiled from: ObservableCountSingle.java */
    static final class a implements g.a.i0<Object>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super Long> f15598a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f15599b;

        /* renamed from: c, reason: collision with root package name */
        long f15600c;

        a(g.a.n0<? super Long> n0Var) {
            this.f15598a = n0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15599b.dispose();
            this.f15599b = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15599b.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15599b = g.a.y0.a.d.DISPOSED;
            this.f15598a.onSuccess(Long.valueOf(this.f15600c));
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15599b = g.a.y0.a.d.DISPOSED;
            this.f15598a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(Object obj) {
            this.f15600c++;
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15599b, cVar)) {
                this.f15599b = cVar;
                this.f15598a.onSubscribe(this);
            }
        }
    }

    public z(g.a.g0<T> g0Var) {
        this.f15597a = g0Var;
    }

    @Override // g.a.y0.c.d
    public g.a.b0<Long> a() {
        return g.a.c1.a.a(new y(this.f15597a));
    }

    @Override // g.a.k0
    public void b(g.a.n0<? super Long> n0Var) {
        this.f15597a.subscribe(new a(n0Var));
    }
}
