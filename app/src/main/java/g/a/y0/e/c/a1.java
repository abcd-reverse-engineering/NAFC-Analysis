package g.a.y0.e.c;

/* compiled from: MaybeOnErrorReturn.java */
/* loaded from: classes2.dex */
public final class a1<T> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super Throwable, ? extends T> f14745b;

    /* compiled from: MaybeOnErrorReturn.java */
    static final class a<T> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14746a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super Throwable, ? extends T> f14747b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14748c;

        a(g.a.v<? super T> vVar, g.a.x0.o<? super Throwable, ? extends T> oVar) {
            this.f14746a = vVar;
            this.f14747b = oVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14748c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14748c.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14746a.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            try {
                this.f14746a.onSuccess(g.a.y0.b.b.a((Object) this.f14747b.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.f14746a.onError(new g.a.v0.a(th, th2));
            }
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14748c, cVar)) {
                this.f14748c = cVar;
                this.f14746a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.f14746a.onSuccess(t);
        }
    }

    public a1(g.a.y<T> yVar, g.a.x0.o<? super Throwable, ? extends T> oVar) {
        super(yVar);
        this.f14745b = oVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar, this.f14745b));
    }
}
