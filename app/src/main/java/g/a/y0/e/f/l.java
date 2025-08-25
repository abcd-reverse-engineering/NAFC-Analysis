package g.a.y0.e.f;

/* compiled from: SingleDoAfterSuccess.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class l<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15794a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.g<? super T> f15795b;

    /* compiled from: SingleDoAfterSuccess.java */
    static final class a<T> implements g.a.n0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super T> f15796a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.g<? super T> f15797b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15798c;

        a(g.a.n0<? super T> n0Var, g.a.x0.g<? super T> gVar) {
            this.f15796a = n0Var;
            this.f15797b = gVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15798c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15798c.isDisposed();
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f15796a.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15798c, cVar)) {
                this.f15798c = cVar;
                this.f15796a.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.f15796a.onSuccess(t);
            try {
                this.f15797b.accept(t);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
        }
    }

    public l(g.a.q0<T> q0Var, g.a.x0.g<? super T> gVar) {
        this.f15794a = q0Var;
        this.f15795b = gVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15794a.a(new a(n0Var, this.f15795b));
    }
}
