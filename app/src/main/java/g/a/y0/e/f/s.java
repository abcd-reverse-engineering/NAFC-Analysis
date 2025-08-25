package g.a.y0.e.f;

/* compiled from: SingleDoOnSuccess.java */
/* loaded from: classes2.dex */
public final class s<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15842a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.g<? super T> f15843b;

    /* compiled from: SingleDoOnSuccess.java */
    final class a implements g.a.n0<T> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.n0<? super T> f15844a;

        a(g.a.n0<? super T> n0Var) {
            this.f15844a = n0Var;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f15844a.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15844a.onSubscribe(cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            try {
                s.this.f15843b.accept(t);
                this.f15844a.onSuccess(t);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15844a.onError(th);
            }
        }
    }

    public s(g.a.q0<T> q0Var, g.a.x0.g<? super T> gVar) {
        this.f15842a = q0Var;
        this.f15843b = gVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15842a.a(new a(n0Var));
    }
}
