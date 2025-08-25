package g.a.y0.e.c;

/* compiled from: MaybeFromSingle.java */
/* loaded from: classes2.dex */
public final class m0<T> extends g.a.s<T> implements g.a.y0.c.i<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f14845a;

    /* compiled from: MaybeFromSingle.java */
    static final class a<T> implements g.a.n0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14846a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f14847b;

        a(g.a.v<? super T> vVar) {
            this.f14846a = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14847b.dispose();
            this.f14847b = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14847b.isDisposed();
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f14847b = g.a.y0.a.d.DISPOSED;
            this.f14846a.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14847b, cVar)) {
                this.f14847b = cVar;
                this.f14846a.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.f14847b = g.a.y0.a.d.DISPOSED;
            this.f14846a.onSuccess(t);
        }
    }

    public m0(g.a.q0<T> q0Var) {
        this.f14845a = q0Var;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14845a.a(new a(vVar));
    }

    @Override // g.a.y0.c.i
    public g.a.q0<T> source() {
        return this.f14845a;
    }
}
