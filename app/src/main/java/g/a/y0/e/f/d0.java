package g.a.y0.e.f;

/* compiled from: SingleHide.java */
/* loaded from: classes2.dex */
public final class d0<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<? extends T> f15747a;

    /* compiled from: SingleHide.java */
    static final class a<T> implements g.a.n0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super T> f15748a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f15749b;

        a(g.a.n0<? super T> n0Var) {
            this.f15748a = n0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15749b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15749b.isDisposed();
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f15748a.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15749b, cVar)) {
                this.f15749b = cVar;
                this.f15748a.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.f15748a.onSuccess(t);
        }
    }

    public d0(g.a.q0<? extends T> q0Var) {
        this.f15747a = q0Var;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15747a.a(new a(n0Var));
    }
}
