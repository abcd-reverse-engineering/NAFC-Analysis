package g.a.y0.e.c;

/* compiled from: MaybeToObservable.java */
/* loaded from: classes2.dex */
public final class l1<T> extends g.a.b0<T> implements g.a.y0.c.f<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<T> f14839a;

    /* compiled from: MaybeToObservable.java */
    static final class a<T> extends g.a.y0.d.l<T> implements g.a.v<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f14840d;

        a(g.a.i0<? super T> i0Var) {
            super(i0Var);
        }

        @Override // g.a.y0.d.l, g.a.u0.c
        public void dispose() {
            super.dispose();
            this.f14840d.dispose();
        }

        @Override // g.a.v
        public void onComplete() {
            complete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            error(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14840d, cVar)) {
                this.f14840d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public l1(g.a.y<T> yVar) {
        this.f14839a = yVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f14839a.a(new a(i0Var));
    }

    @Override // g.a.y0.c.f
    public g.a.y<T> source() {
        return this.f14839a;
    }
}
