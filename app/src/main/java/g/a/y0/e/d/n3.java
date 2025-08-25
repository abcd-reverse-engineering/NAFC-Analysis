package g.a.y0.e.d;

/* compiled from: ObservableTakeUntilPredicate.java */
/* loaded from: classes2.dex */
public final class n3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super T> f15345b;

    /* compiled from: ObservableTakeUntilPredicate.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15346a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f15347b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15348c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15349d;

        a(g.a.i0<? super T> i0Var, g.a.x0.r<? super T> rVar) {
            this.f15346a = i0Var;
            this.f15347b = rVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15348c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15348c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15349d) {
                return;
            }
            this.f15349d = true;
            this.f15346a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15349d) {
                g.a.c1.a.b(th);
            } else {
                this.f15349d = true;
                this.f15346a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15349d) {
                return;
            }
            this.f15346a.onNext(t);
            try {
                if (this.f15347b.test(t)) {
                    this.f15349d = true;
                    this.f15348c.dispose();
                    this.f15346a.onComplete();
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15348c.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15348c, cVar)) {
                this.f15348c = cVar;
                this.f15346a.onSubscribe(this);
            }
        }
    }

    public n3(g.a.g0<T> g0Var, g.a.x0.r<? super T> rVar) {
        super(g0Var);
        this.f15345b = rVar;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15345b));
    }
}
