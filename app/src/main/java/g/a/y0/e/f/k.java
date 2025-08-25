package g.a.y0.e.f;

/* compiled from: SingleDetach.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class k<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15786a;

    /* compiled from: SingleDetach.java */
    static final class a<T> implements g.a.n0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        g.a.n0<? super T> f15787a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f15788b;

        a(g.a.n0<? super T> n0Var) {
            this.f15787a = n0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15787a = null;
            this.f15788b.dispose();
            this.f15788b = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15788b.isDisposed();
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f15788b = g.a.y0.a.d.DISPOSED;
            g.a.n0<? super T> n0Var = this.f15787a;
            if (n0Var != null) {
                this.f15787a = null;
                n0Var.onError(th);
            }
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15788b, cVar)) {
                this.f15788b = cVar;
                this.f15787a.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.f15788b = g.a.y0.a.d.DISPOSED;
            g.a.n0<? super T> n0Var = this.f15787a;
            if (n0Var != null) {
                this.f15787a = null;
                n0Var.onSuccess(t);
            }
        }
    }

    public k(g.a.q0<T> q0Var) {
        this.f15786a = q0Var;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15786a.a(new a(n0Var));
    }
}
