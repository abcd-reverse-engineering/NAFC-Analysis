package g.a.y0.e.d;

/* compiled from: ObservableSwitchIfEmpty.java */
/* loaded from: classes2.dex */
public final class g3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.g0<? extends T> f15158b;

    /* compiled from: ObservableSwitchIfEmpty.java */
    static final class a<T> implements g.a.i0<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15159a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.g0<? extends T> f15160b;

        /* renamed from: d, reason: collision with root package name */
        boolean f15162d = true;

        /* renamed from: c, reason: collision with root package name */
        final g.a.y0.a.k f15161c = new g.a.y0.a.k();

        a(g.a.i0<? super T> i0Var, g.a.g0<? extends T> g0Var) {
            this.f15159a = i0Var;
            this.f15160b = g0Var;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (!this.f15162d) {
                this.f15159a.onComplete();
            } else {
                this.f15162d = false;
                this.f15160b.subscribe(this);
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15159a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15162d) {
                this.f15162d = false;
            }
            this.f15159a.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15161c.update(cVar);
        }
    }

    public g3(g.a.g0<T> g0Var, g.a.g0<? extends T> g0Var2) {
        super(g0Var);
        this.f15158b = g0Var2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        a aVar = new a(i0Var, this.f15158b);
        i0Var.onSubscribe(aVar.f15161c);
        this.f14934a.subscribe(aVar);
    }
}
