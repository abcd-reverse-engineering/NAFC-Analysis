package g.a.y0.e.c;

/* compiled from: MaybeFromCompletable.java */
/* loaded from: classes2.dex */
public final class j0<T> extends g.a.s<T> implements g.a.y0.c.e {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14823a;

    /* compiled from: MaybeFromCompletable.java */
    static final class a<T> implements g.a.f, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14824a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f14825b;

        a(g.a.v<? super T> vVar) {
            this.f14824a = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14825b.dispose();
            this.f14825b = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14825b.isDisposed();
        }

        @Override // g.a.f
        public void onComplete() {
            this.f14825b = g.a.y0.a.d.DISPOSED;
            this.f14824a.onComplete();
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            this.f14825b = g.a.y0.a.d.DISPOSED;
            this.f14824a.onError(th);
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14825b, cVar)) {
                this.f14825b = cVar;
                this.f14824a.onSubscribe(this);
            }
        }
    }

    public j0(g.a.i iVar) {
        this.f14823a = iVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14823a.a(new a(vVar));
    }

    @Override // g.a.y0.c.e
    public g.a.i source() {
        return this.f14823a;
    }
}
