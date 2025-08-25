package g.a.y0.e.c;

/* compiled from: MaybeDoAfterSuccess.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class q<T> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.g<? super T> f14872b;

    /* compiled from: MaybeDoAfterSuccess.java */
    static final class a<T> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14873a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.g<? super T> f14874b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14875c;

        a(g.a.v<? super T> vVar, g.a.x0.g<? super T> gVar) {
            this.f14873a = vVar;
            this.f14874b = gVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14875c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14875c.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14873a.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14873a.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14875c, cVar)) {
                this.f14875c = cVar;
                this.f14873a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.f14873a.onSuccess(t);
            try {
                this.f14874b.accept(t);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
        }
    }

    public q(g.a.y<T> yVar, g.a.x0.g<? super T> gVar) {
        super(yVar);
        this.f14872b = gVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar, this.f14872b));
    }
}
