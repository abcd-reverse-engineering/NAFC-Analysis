package g.a.y0.e.d;

/* compiled from: ObservableIgnoreElementsCompletable.java */
/* loaded from: classes2.dex */
public final class l1<T> extends g.a.c implements g.a.y0.c.d<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15246a;

    /* compiled from: ObservableIgnoreElementsCompletable.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f f15247a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f15248b;

        a(g.a.f fVar) {
            this.f15247a = fVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15248b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15248b.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15247a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15247a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15248b = cVar;
            this.f15247a.onSubscribe(this);
        }
    }

    public l1(g.a.g0<T> g0Var) {
        this.f15246a = g0Var;
    }

    @Override // g.a.y0.c.d
    public g.a.b0<T> a() {
        return g.a.c1.a.a(new k1(this.f15246a));
    }

    @Override // g.a.c
    public void b(g.a.f fVar) {
        this.f15246a.subscribe(new a(fVar));
    }
}
