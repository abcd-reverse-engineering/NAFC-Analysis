package g.a.y0.e.d;

/* compiled from: ObservableAnySingle.java */
/* loaded from: classes2.dex */
public final class j<T> extends g.a.k0<Boolean> implements g.a.y0.c.d<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15216a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super T> f15217b;

    /* compiled from: ObservableAnySingle.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super Boolean> f15218a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f15219b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15220c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15221d;

        a(g.a.n0<? super Boolean> n0Var, g.a.x0.r<? super T> rVar) {
            this.f15218a = n0Var;
            this.f15219b = rVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15220c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15220c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15221d) {
                return;
            }
            this.f15221d = true;
            this.f15218a.onSuccess(false);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15221d) {
                g.a.c1.a.b(th);
            } else {
                this.f15221d = true;
                this.f15218a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15221d) {
                return;
            }
            try {
                if (this.f15219b.test(t)) {
                    this.f15221d = true;
                    this.f15220c.dispose();
                    this.f15218a.onSuccess(true);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15220c.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15220c, cVar)) {
                this.f15220c = cVar;
                this.f15218a.onSubscribe(this);
            }
        }
    }

    public j(g.a.g0<T> g0Var, g.a.x0.r<? super T> rVar) {
        this.f15216a = g0Var;
        this.f15217b = rVar;
    }

    @Override // g.a.y0.c.d
    public g.a.b0<Boolean> a() {
        return g.a.c1.a.a(new i(this.f15216a, this.f15217b));
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super Boolean> n0Var) {
        this.f15216a.subscribe(new a(n0Var, this.f15217b));
    }
}
