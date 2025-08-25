package g.a.y0.e.f;

/* compiled from: SingleDoOnError.java */
/* loaded from: classes2.dex */
public final class p<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15821a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.g<? super Throwable> f15822b;

    /* compiled from: SingleDoOnError.java */
    final class a implements g.a.n0<T> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.n0<? super T> f15823a;

        a(g.a.n0<? super T> n0Var) {
            this.f15823a = n0Var;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            try {
                p.this.f15822b.accept(th);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                th = new g.a.v0.a(th, th2);
            }
            this.f15823a.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15823a.onSubscribe(cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.f15823a.onSuccess(t);
        }
    }

    public p(g.a.q0<T> q0Var, g.a.x0.g<? super Throwable> gVar) {
        this.f15821a = q0Var;
        this.f15822b = gVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15821a.a(new a(n0Var));
    }
}
