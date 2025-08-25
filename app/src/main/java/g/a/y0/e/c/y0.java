package g.a.y0.e.c;

/* compiled from: MaybeOnErrorComplete.java */
/* loaded from: classes2.dex */
public final class y0<T> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super Throwable> f14922b;

    /* compiled from: MaybeOnErrorComplete.java */
    static final class a<T> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14923a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super Throwable> f14924b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14925c;

        a(g.a.v<? super T> vVar, g.a.x0.r<? super Throwable> rVar) {
            this.f14923a = vVar;
            this.f14924b = rVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14925c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14925c.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14923a.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            try {
                if (this.f14924b.test(th)) {
                    this.f14923a.onComplete();
                } else {
                    this.f14923a.onError(th);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.f14923a.onError(new g.a.v0.a(th, th2));
            }
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14925c, cVar)) {
                this.f14925c = cVar;
                this.f14923a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.f14923a.onSuccess(t);
        }
    }

    public y0(g.a.y<T> yVar, g.a.x0.r<? super Throwable> rVar) {
        super(yVar);
        this.f14922b = rVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar, this.f14922b));
    }
}
