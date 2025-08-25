package g.a.y0.e.c;

/* compiled from: MaybeToFlowable.java */
/* loaded from: classes2.dex */
public final class k1<T> extends g.a.l<T> implements g.a.y0.c.f<T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.y<T> f14833b;

    /* compiled from: MaybeToFlowable.java */
    static final class a<T> extends g.a.y0.i.f<T> implements g.a.v<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f14834d;

        a(i.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // g.a.y0.i.f, i.d.d
        public void cancel() {
            super.cancel();
            this.f14834d.dispose();
        }

        @Override // g.a.v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14834d, cVar)) {
                this.f14834d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public k1(g.a.y<T> yVar) {
        this.f14833b = yVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14833b.a(new a(cVar));
    }

    @Override // g.a.y0.c.f
    public g.a.y<T> source() {
        return this.f14833b;
    }
}
