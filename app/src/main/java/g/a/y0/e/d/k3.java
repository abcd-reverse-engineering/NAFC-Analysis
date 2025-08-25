package g.a.y0.e.d;

/* compiled from: ObservableTakeLastOne.java */
/* loaded from: classes2.dex */
public final class k3<T> extends g.a.y0.e.d.a<T, T> {

    /* compiled from: ObservableTakeLastOne.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15241a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f15242b;

        /* renamed from: c, reason: collision with root package name */
        T f15243c;

        a(g.a.i0<? super T> i0Var) {
            this.f15241a = i0Var;
        }

        void a() {
            T t = this.f15243c;
            if (t != null) {
                this.f15243c = null;
                this.f15241a.onNext(t);
            }
            this.f15241a.onComplete();
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15243c = null;
            this.f15242b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15242b.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            a();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15243c = null;
            this.f15241a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15243c = t;
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15242b, cVar)) {
                this.f15242b = cVar;
                this.f15241a.onSubscribe(this);
            }
        }
    }

    public k3(g.a.g0<T> g0Var) {
        super(g0Var);
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var));
    }
}
