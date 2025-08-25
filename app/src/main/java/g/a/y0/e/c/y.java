package g.a.y0.e.c;

/* compiled from: MaybeFilterSingle.java */
/* loaded from: classes2.dex */
public final class y<T> extends g.a.s<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f14917a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super T> f14918b;

    /* compiled from: MaybeFilterSingle.java */
    static final class a<T> implements g.a.n0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14919a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f14920b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14921c;

        a(g.a.v<? super T> vVar, g.a.x0.r<? super T> rVar) {
            this.f14919a = vVar;
            this.f14920b = rVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.u0.c cVar = this.f14921c;
            this.f14921c = g.a.y0.a.d.DISPOSED;
            cVar.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14921c.isDisposed();
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f14919a.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14921c, cVar)) {
                this.f14921c = cVar;
                this.f14919a.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            try {
                if (this.f14920b.test(t)) {
                    this.f14919a.onSuccess(t);
                } else {
                    this.f14919a.onComplete();
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14919a.onError(th);
            }
        }
    }

    public y(g.a.q0<T> q0Var, g.a.x0.r<? super T> rVar) {
        this.f14917a = q0Var;
        this.f14918b = rVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14917a.a(new a(vVar, this.f14918b));
    }
}
