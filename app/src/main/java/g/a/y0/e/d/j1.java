package g.a.y0.e.d;

/* compiled from: ObservableHide.java */
/* loaded from: classes2.dex */
public final class j1<T> extends g.a.y0.e.d.a<T, T> {

    /* compiled from: ObservableHide.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15228a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f15229b;

        a(g.a.i0<? super T> i0Var) {
            this.f15228a = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15229b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15229b.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15228a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15228a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15228a.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15229b, cVar)) {
                this.f15229b = cVar;
                this.f15228a.onSubscribe(this);
            }
        }
    }

    public j1(g.a.g0<T> g0Var) {
        super(g0Var);
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var));
    }
}
