package g.a.y0.e.d;

/* compiled from: ObservableMaterialize.java */
/* loaded from: classes2.dex */
public final class w1<T> extends g.a.y0.e.d.a<T, g.a.a0<T>> {

    /* compiled from: ObservableMaterialize.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super g.a.a0<T>> f15554a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f15555b;

        a(g.a.i0<? super g.a.a0<T>> i0Var) {
            this.f15554a = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15555b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15555b.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15554a.onNext(g.a.a0.f());
            this.f15554a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15554a.onNext(g.a.a0.a(th));
            this.f15554a.onComplete();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15554a.onNext(g.a.a0.a(t));
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15555b, cVar)) {
                this.f15555b = cVar;
                this.f15554a.onSubscribe(this);
            }
        }
    }

    public w1(g.a.g0<T> g0Var) {
        super(g0Var);
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super g.a.a0<T>> i0Var) {
        this.f14934a.subscribe(new a(i0Var));
    }
}
