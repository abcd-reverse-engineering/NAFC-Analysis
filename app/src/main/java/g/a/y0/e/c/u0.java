package g.a.y0.e.c;

/* compiled from: MaybeMap.java */
/* loaded from: classes2.dex */
public final class u0<T, R> extends g.a.y0.e.c.a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends R> f14904b;

    /* compiled from: MaybeMap.java */
    static final class a<T, R> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super R> f14905a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends R> f14906b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14907c;

        a(g.a.v<? super R> vVar, g.a.x0.o<? super T, ? extends R> oVar) {
            this.f14905a = vVar;
            this.f14906b = oVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.u0.c cVar = this.f14907c;
            this.f14907c = g.a.y0.a.d.DISPOSED;
            cVar.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14907c.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14905a.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14905a.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14907c, cVar)) {
                this.f14907c = cVar;
                this.f14905a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            try {
                this.f14905a.onSuccess(g.a.y0.b.b.a(this.f14906b.apply(t), "The mapper returned a null item"));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14905a.onError(th);
            }
        }
    }

    public u0(g.a.y<T> yVar, g.a.x0.o<? super T, ? extends R> oVar) {
        super(yVar);
        this.f14904b = oVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super R> vVar) {
        this.f14742a.a(new a(vVar, this.f14904b));
    }
}
