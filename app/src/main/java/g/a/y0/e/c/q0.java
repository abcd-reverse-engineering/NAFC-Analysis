package g.a.y0.e.c;

/* compiled from: MaybeIsEmpty.java */
/* loaded from: classes2.dex */
public final class q0<T> extends g.a.y0.e.c.a<T, Boolean> {

    /* compiled from: MaybeIsEmpty.java */
    static final class a<T> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super Boolean> f14876a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f14877b;

        a(g.a.v<? super Boolean> vVar) {
            this.f14876a = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14877b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14877b.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14876a.onSuccess(true);
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14876a.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14877b, cVar)) {
                this.f14877b = cVar;
                this.f14876a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.f14876a.onSuccess(false);
        }
    }

    public q0(g.a.y<T> yVar) {
        super(yVar);
    }

    @Override // g.a.s
    protected void b(g.a.v<? super Boolean> vVar) {
        this.f14742a.a(new a(vVar));
    }
}
