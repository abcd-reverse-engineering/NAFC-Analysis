package g.a.y0.e.d;

/* compiled from: ObservableDetach.java */
/* loaded from: classes2.dex */
public final class h0<T> extends g.a.y0.e.d.a<T, T> {

    /* compiled from: ObservableDetach.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        g.a.i0<? super T> f15176a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f15177b;

        a(g.a.i0<? super T> i0Var) {
            this.f15176a = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.u0.c cVar = this.f15177b;
            this.f15177b = g.a.y0.j.h.INSTANCE;
            this.f15176a = g.a.y0.j.h.asObserver();
            cVar.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15177b.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            g.a.i0<? super T> i0Var = this.f15176a;
            this.f15177b = g.a.y0.j.h.INSTANCE;
            this.f15176a = g.a.y0.j.h.asObserver();
            i0Var.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            g.a.i0<? super T> i0Var = this.f15176a;
            this.f15177b = g.a.y0.j.h.INSTANCE;
            this.f15176a = g.a.y0.j.h.asObserver();
            i0Var.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15176a.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15177b, cVar)) {
                this.f15177b = cVar;
                this.f15176a.onSubscribe(this);
            }
        }
    }

    public h0(g.a.g0<T> g0Var) {
        super(g0Var);
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var));
    }
}
