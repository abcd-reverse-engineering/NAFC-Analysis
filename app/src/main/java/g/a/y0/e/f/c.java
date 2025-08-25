package g.a.y0.e.f;

/* compiled from: SingleContains.java */
/* loaded from: classes2.dex */
public final class c<T> extends g.a.k0<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15740a;

    /* renamed from: b, reason: collision with root package name */
    final Object f15741b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.d<Object, Object> f15742c;

    /* compiled from: SingleContains.java */
    final class a implements g.a.n0<T> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.n0<? super Boolean> f15743a;

        a(g.a.n0<? super Boolean> n0Var) {
            this.f15743a = n0Var;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f15743a.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15743a.onSubscribe(cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            try {
                this.f15743a.onSuccess(Boolean.valueOf(c.this.f15742c.a(t, c.this.f15741b)));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15743a.onError(th);
            }
        }
    }

    public c(g.a.q0<T> q0Var, Object obj, g.a.x0.d<Object, Object> dVar) {
        this.f15740a = q0Var;
        this.f15741b = obj;
        this.f15742c = dVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super Boolean> n0Var) {
        this.f15740a.a(new a(n0Var));
    }
}
