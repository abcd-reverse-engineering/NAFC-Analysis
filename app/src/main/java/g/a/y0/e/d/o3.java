package g.a.y0.e.d;

/* compiled from: ObservableTakeWhile.java */
/* loaded from: classes2.dex */
public final class o3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super T> f15372b;

    /* compiled from: ObservableTakeWhile.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15373a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f15374b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15375c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15376d;

        a(g.a.i0<? super T> i0Var, g.a.x0.r<? super T> rVar) {
            this.f15373a = i0Var;
            this.f15374b = rVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15375c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15375c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15376d) {
                return;
            }
            this.f15376d = true;
            this.f15373a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15376d) {
                g.a.c1.a.b(th);
            } else {
                this.f15376d = true;
                this.f15373a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15376d) {
                return;
            }
            try {
                if (this.f15374b.test(t)) {
                    this.f15373a.onNext(t);
                    return;
                }
                this.f15376d = true;
                this.f15375c.dispose();
                this.f15373a.onComplete();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15375c.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15375c, cVar)) {
                this.f15375c = cVar;
                this.f15373a.onSubscribe(this);
            }
        }
    }

    public o3(g.a.g0<T> g0Var, g.a.x0.r<? super T> rVar) {
        super(g0Var);
        this.f15372b = rVar;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15372b));
    }
}
