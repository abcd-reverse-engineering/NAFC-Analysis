package g.a.y0.e.c;

/* compiled from: MaybeDetach.java */
/* loaded from: classes2.dex */
public final class p<T> extends g.a.y0.e.c.a<T, T> {

    /* compiled from: MaybeDetach.java */
    static final class a<T> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        g.a.v<? super T> f14866a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f14867b;

        a(g.a.v<? super T> vVar) {
            this.f14866a = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14866a = null;
            this.f14867b.dispose();
            this.f14867b = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14867b.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14867b = g.a.y0.a.d.DISPOSED;
            g.a.v<? super T> vVar = this.f14866a;
            if (vVar != null) {
                this.f14866a = null;
                vVar.onComplete();
            }
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14867b = g.a.y0.a.d.DISPOSED;
            g.a.v<? super T> vVar = this.f14866a;
            if (vVar != null) {
                this.f14866a = null;
                vVar.onError(th);
            }
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14867b, cVar)) {
                this.f14867b = cVar;
                this.f14866a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.f14867b = g.a.y0.a.d.DISPOSED;
            g.a.v<? super T> vVar = this.f14866a;
            if (vVar != null) {
                this.f14866a = null;
                vVar.onSuccess(t);
            }
        }
    }

    public p(g.a.y<T> yVar) {
        super(yVar);
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar));
    }
}
