package g.a.y0.e.d;

/* compiled from: ObservableSkipWhile.java */
/* loaded from: classes2.dex */
public final class e3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super T> f15089b;

    /* compiled from: ObservableSkipWhile.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15090a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f15091b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15092c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15093d;

        a(g.a.i0<? super T> i0Var, g.a.x0.r<? super T> rVar) {
            this.f15090a = i0Var;
            this.f15091b = rVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15092c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15092c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15090a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15090a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15093d) {
                this.f15090a.onNext(t);
                return;
            }
            try {
                if (this.f15091b.test(t)) {
                    return;
                }
                this.f15093d = true;
                this.f15090a.onNext(t);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15092c.dispose();
                this.f15090a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15092c, cVar)) {
                this.f15092c = cVar;
                this.f15090a.onSubscribe(this);
            }
        }
    }

    public e3(g.a.g0<T> g0Var, g.a.x0.r<? super T> rVar) {
        super(g0Var);
        this.f15089b = rVar;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15089b));
    }
}
