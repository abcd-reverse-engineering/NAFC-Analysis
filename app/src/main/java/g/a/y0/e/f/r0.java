package g.a.y0.e.f;

/* compiled from: SingleToObservable.java */
/* loaded from: classes2.dex */
public final class r0<T> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<? extends T> f15839a;

    /* compiled from: SingleToObservable.java */
    static final class a<T> implements g.a.n0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15840a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f15841b;

        a(g.a.i0<? super T> i0Var) {
            this.f15840a = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15841b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15841b.isDisposed();
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f15840a.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15841b, cVar)) {
                this.f15841b = cVar;
                this.f15840a.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.f15840a.onNext(t);
            this.f15840a.onComplete();
        }
    }

    public r0(g.a.q0<? extends T> q0Var) {
        this.f15839a = q0Var;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f15839a.a(new a(i0Var));
    }
}
