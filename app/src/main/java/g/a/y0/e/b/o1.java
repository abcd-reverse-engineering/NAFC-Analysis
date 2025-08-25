package g.a.y0.e.b;

/* compiled from: FlowableIgnoreElementsCompletable.java */
/* loaded from: classes2.dex */
public final class o1<T> extends g.a.c implements g.a.y0.c.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14448a;

    /* compiled from: FlowableIgnoreElementsCompletable.java */
    static final class a<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f f14449a;

        /* renamed from: b, reason: collision with root package name */
        i.d.d f14450b;

        a(g.a.f fVar) {
            this.f14449a = fVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14450b.cancel();
            this.f14450b = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14450b == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14450b = g.a.y0.i.j.CANCELLED;
            this.f14449a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14450b = g.a.y0.i.j.CANCELLED;
            this.f14449a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14450b, dVar)) {
                this.f14450b = dVar;
                this.f14449a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public o1(g.a.l<T> lVar) {
        this.f14448a = lVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14448a.a((g.a.q) new a(fVar));
    }

    @Override // g.a.y0.c.b
    public g.a.l<T> b() {
        return g.a.c1.a.a(new n1(this.f14448a));
    }
}
