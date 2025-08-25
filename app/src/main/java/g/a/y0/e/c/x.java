package g.a.y0.e.c;

/* compiled from: MaybeFilter.java */
/* loaded from: classes2.dex */
public final class x<T> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super T> f14912b;

    /* compiled from: MaybeFilter.java */
    static final class a<T> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14913a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f14914b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14915c;

        a(g.a.v<? super T> vVar, g.a.x0.r<? super T> rVar) {
            this.f14913a = vVar;
            this.f14914b = rVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.u0.c cVar = this.f14915c;
            this.f14915c = g.a.y0.a.d.DISPOSED;
            cVar.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14915c.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14913a.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14913a.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14915c, cVar)) {
                this.f14915c = cVar;
                this.f14913a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            try {
                if (this.f14914b.test(t)) {
                    this.f14913a.onSuccess(t);
                } else {
                    this.f14913a.onComplete();
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14913a.onError(th);
            }
        }
    }

    public x(g.a.y<T> yVar, g.a.x0.r<? super T> rVar) {
        super(yVar);
        this.f14912b = rVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar, this.f14912b));
    }
}
