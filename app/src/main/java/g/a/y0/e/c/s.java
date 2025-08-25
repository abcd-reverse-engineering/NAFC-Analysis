package g.a.y0.e.c;

/* compiled from: MaybeDoOnEvent.java */
/* loaded from: classes2.dex */
public final class s<T> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.b<? super T, ? super Throwable> f14891b;

    /* compiled from: MaybeDoOnEvent.java */
    static final class a<T> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14892a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.b<? super T, ? super Throwable> f14893b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14894c;

        a(g.a.v<? super T> vVar, g.a.x0.b<? super T, ? super Throwable> bVar) {
            this.f14892a = vVar;
            this.f14893b = bVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14894c.dispose();
            this.f14894c = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14894c.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14894c = g.a.y0.a.d.DISPOSED;
            try {
                this.f14893b.a(null, null);
                this.f14892a.onComplete();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14892a.onError(th);
            }
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14894c = g.a.y0.a.d.DISPOSED;
            try {
                this.f14893b.a(null, th);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                th = new g.a.v0.a(th, th2);
            }
            this.f14892a.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14894c, cVar)) {
                this.f14894c = cVar;
                this.f14892a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.f14894c = g.a.y0.a.d.DISPOSED;
            try {
                this.f14893b.a(t, null);
                this.f14892a.onSuccess(t);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14892a.onError(th);
            }
        }
    }

    public s(g.a.y<T> yVar, g.a.x0.b<? super T, ? super Throwable> bVar) {
        super(yVar);
        this.f14891b = bVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar, this.f14891b));
    }
}
