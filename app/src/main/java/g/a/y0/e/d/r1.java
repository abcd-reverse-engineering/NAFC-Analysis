package g.a.y0.e.d;

/* compiled from: ObservableLastMaybe.java */
/* loaded from: classes2.dex */
public final class r1<T> extends g.a.s<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15438a;

    /* compiled from: ObservableLastMaybe.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f15439a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f15440b;

        /* renamed from: c, reason: collision with root package name */
        T f15441c;

        a(g.a.v<? super T> vVar) {
            this.f15439a = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15440b.dispose();
            this.f15440b = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15440b == g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15440b = g.a.y0.a.d.DISPOSED;
            T t = this.f15441c;
            if (t == null) {
                this.f15439a.onComplete();
            } else {
                this.f15441c = null;
                this.f15439a.onSuccess(t);
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15440b = g.a.y0.a.d.DISPOSED;
            this.f15441c = null;
            this.f15439a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15441c = t;
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15440b, cVar)) {
                this.f15440b = cVar;
                this.f15439a.onSubscribe(this);
            }
        }
    }

    public r1(g.a.g0<T> g0Var) {
        this.f15438a = g0Var;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f15438a.subscribe(new a(vVar));
    }
}
