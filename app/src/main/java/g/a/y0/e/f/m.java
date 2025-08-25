package g.a.y0.e.f;

/* compiled from: SingleDoAfterTerminate.java */
/* loaded from: classes2.dex */
public final class m<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15801a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.a f15802b;

    /* compiled from: SingleDoAfterTerminate.java */
    static final class a<T> implements g.a.n0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super T> f15803a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.a f15804b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15805c;

        a(g.a.n0<? super T> n0Var, g.a.x0.a aVar) {
            this.f15803a = n0Var;
            this.f15804b = aVar;
        }

        private void a() {
            try {
                this.f15804b.run();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15805c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15805c.isDisposed();
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f15803a.onError(th);
            a();
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15805c, cVar)) {
                this.f15805c = cVar;
                this.f15803a.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.f15803a.onSuccess(t);
            a();
        }
    }

    public m(g.a.q0<T> q0Var, g.a.x0.a aVar) {
        this.f15801a = q0Var;
        this.f15802b = aVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15801a.a(new a(n0Var, this.f15802b));
    }
}
