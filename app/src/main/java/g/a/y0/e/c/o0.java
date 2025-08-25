package g.a.y0.e.c;

/* compiled from: MaybeIgnoreElement.java */
/* loaded from: classes2.dex */
public final class o0<T> extends g.a.y0.e.c.a<T, T> {

    /* compiled from: MaybeIgnoreElement.java */
    static final class a<T> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14864a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f14865b;

        a(g.a.v<? super T> vVar) {
            this.f14864a = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14865b.dispose();
            this.f14865b = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14865b.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14865b = g.a.y0.a.d.DISPOSED;
            this.f14864a.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14865b = g.a.y0.a.d.DISPOSED;
            this.f14864a.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14865b, cVar)) {
                this.f14865b = cVar;
                this.f14864a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.f14865b = g.a.y0.a.d.DISPOSED;
            this.f14864a.onComplete();
        }
    }

    public o0(g.a.y<T> yVar) {
        super(yVar);
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar));
    }
}
