package g.a.y0.e.d;

/* compiled from: ObservableIgnoreElements.java */
/* loaded from: classes2.dex */
public final class k1<T> extends g.a.y0.e.d.a<T, T> {

    /* compiled from: ObservableIgnoreElements.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15238a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f15239b;

        a(g.a.i0<? super T> i0Var) {
            this.f15238a = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15239b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15239b.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15238a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15238a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15239b = cVar;
            this.f15238a.onSubscribe(this);
        }
    }

    public k1(g.a.g0<T> g0Var) {
        super(g0Var);
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var));
    }
}
