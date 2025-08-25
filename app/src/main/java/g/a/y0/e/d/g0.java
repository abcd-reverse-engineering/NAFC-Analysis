package g.a.y0.e.d;

/* compiled from: ObservableDematerialize.java */
/* loaded from: classes2.dex */
public final class g0<T> extends g.a.y0.e.d.a<g.a.a0<T>, T> {

    /* compiled from: ObservableDematerialize.java */
    static final class a<T> implements g.a.i0<g.a.a0<T>>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15138a;

        /* renamed from: b, reason: collision with root package name */
        boolean f15139b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15140c;

        a(g.a.i0<? super T> i0Var) {
            this.f15138a = i0Var;
        }

        @Override // g.a.i0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(g.a.a0<T> a0Var) {
            if (this.f15139b) {
                if (a0Var.d()) {
                    g.a.c1.a.b(a0Var.a());
                }
            } else if (a0Var.d()) {
                this.f15140c.dispose();
                onError(a0Var.a());
            } else if (!a0Var.c()) {
                this.f15138a.onNext(a0Var.b());
            } else {
                this.f15140c.dispose();
                onComplete();
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15140c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15140c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15139b) {
                return;
            }
            this.f15139b = true;
            this.f15138a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15139b) {
                g.a.c1.a.b(th);
            } else {
                this.f15139b = true;
                this.f15138a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15140c, cVar)) {
                this.f15140c = cVar;
                this.f15138a.onSubscribe(this);
            }
        }
    }

    public g0(g.a.g0<g.a.a0<T>> g0Var) {
        super(g0Var);
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var));
    }
}
