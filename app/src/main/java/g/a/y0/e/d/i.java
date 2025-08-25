package g.a.y0.e.d;

/* compiled from: ObservableAny.java */
/* loaded from: classes2.dex */
public final class i<T> extends g.a.y0.e.d.a<T, Boolean> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super T> f15189b;

    /* compiled from: ObservableAny.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super Boolean> f15190a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f15191b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15192c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15193d;

        a(g.a.i0<? super Boolean> i0Var, g.a.x0.r<? super T> rVar) {
            this.f15190a = i0Var;
            this.f15191b = rVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15192c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15192c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15193d) {
                return;
            }
            this.f15193d = true;
            this.f15190a.onNext(false);
            this.f15190a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15193d) {
                g.a.c1.a.b(th);
            } else {
                this.f15193d = true;
                this.f15190a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15193d) {
                return;
            }
            try {
                if (this.f15191b.test(t)) {
                    this.f15193d = true;
                    this.f15192c.dispose();
                    this.f15190a.onNext(true);
                    this.f15190a.onComplete();
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15192c.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15192c, cVar)) {
                this.f15192c = cVar;
                this.f15190a.onSubscribe(this);
            }
        }
    }

    public i(g.a.g0<T> g0Var, g.a.x0.r<? super T> rVar) {
        super(g0Var);
        this.f15189b = rVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super Boolean> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15189b));
    }
}
