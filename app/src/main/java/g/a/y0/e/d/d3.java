package g.a.y0.e.d;

/* compiled from: ObservableSkipUntil.java */
/* loaded from: classes2.dex */
public final class d3<T, U> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.g0<U> f15044b;

    /* compiled from: ObservableSkipUntil.java */
    final class a implements g.a.i0<U> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.y0.a.a f15045a;

        /* renamed from: b, reason: collision with root package name */
        private final b<T> f15046b;

        /* renamed from: c, reason: collision with root package name */
        private final g.a.a1.m<T> f15047c;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15048d;

        a(g.a.y0.a.a aVar, b<T> bVar, g.a.a1.m<T> mVar) {
            this.f15045a = aVar;
            this.f15046b = bVar;
            this.f15047c = mVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15046b.f15053d = true;
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15045a.dispose();
            this.f15047c.onError(th);
        }

        @Override // g.a.i0
        public void onNext(U u) {
            this.f15048d.dispose();
            this.f15046b.f15053d = true;
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15048d, cVar)) {
                this.f15048d = cVar;
                this.f15045a.setResource(1, cVar);
            }
        }
    }

    /* compiled from: ObservableSkipUntil.java */
    static final class b<T> implements g.a.i0<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15050a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.y0.a.a f15051b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15052c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f15053d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15054e;

        b(g.a.i0<? super T> i0Var, g.a.y0.a.a aVar) {
            this.f15050a = i0Var;
            this.f15051b = aVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15051b.dispose();
            this.f15050a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15051b.dispose();
            this.f15050a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15054e) {
                this.f15050a.onNext(t);
            } else if (this.f15053d) {
                this.f15054e = true;
                this.f15050a.onNext(t);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15052c, cVar)) {
                this.f15052c = cVar;
                this.f15051b.setResource(0, cVar);
            }
        }
    }

    public d3(g.a.g0<T> g0Var, g.a.g0<U> g0Var2) {
        super(g0Var);
        this.f15044b = g0Var2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        g.a.a1.m mVar = new g.a.a1.m(i0Var);
        g.a.y0.a.a aVar = new g.a.y0.a.a(2);
        mVar.onSubscribe(aVar);
        b bVar = new b(mVar, aVar);
        this.f15044b.subscribe(new a(aVar, bVar, mVar));
        this.f14934a.subscribe(bVar);
    }
}
