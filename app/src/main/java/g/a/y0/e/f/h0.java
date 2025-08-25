package g.a.y0.e.f;

/* compiled from: SingleMap.java */
/* loaded from: classes2.dex */
public final class h0<T, R> extends g.a.k0<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<? extends T> f15775a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends R> f15776b;

    /* compiled from: SingleMap.java */
    static final class a<T, R> implements g.a.n0<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super R> f15777a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends R> f15778b;

        a(g.a.n0<? super R> n0Var, g.a.x0.o<? super T, ? extends R> oVar) {
            this.f15777a = n0Var;
            this.f15778b = oVar;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f15777a.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15777a.onSubscribe(cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            try {
                this.f15777a.onSuccess(g.a.y0.b.b.a(this.f15778b.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                onError(th);
            }
        }
    }

    public h0(g.a.q0<? extends T> q0Var, g.a.x0.o<? super T, ? extends R> oVar) {
        this.f15775a = q0Var;
        this.f15776b = oVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super R> n0Var) {
        this.f15775a.a(new a(n0Var, this.f15776b));
    }
}
