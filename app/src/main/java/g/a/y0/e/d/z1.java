package g.a.y0.e.d;

/* compiled from: ObservableOnErrorNext.java */
/* loaded from: classes2.dex */
public final class z1<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super Throwable, ? extends g.a.g0<? extends T>> f15605b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f15606c;

    /* compiled from: ObservableOnErrorNext.java */
    static final class a<T> implements g.a.i0<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15607a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super Throwable, ? extends g.a.g0<? extends T>> f15608b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f15609c;

        /* renamed from: d, reason: collision with root package name */
        final g.a.y0.a.k f15610d = new g.a.y0.a.k();

        /* renamed from: e, reason: collision with root package name */
        boolean f15611e;

        /* renamed from: f, reason: collision with root package name */
        boolean f15612f;

        a(g.a.i0<? super T> i0Var, g.a.x0.o<? super Throwable, ? extends g.a.g0<? extends T>> oVar, boolean z) {
            this.f15607a = i0Var;
            this.f15608b = oVar;
            this.f15609c = z;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15612f) {
                return;
            }
            this.f15612f = true;
            this.f15611e = true;
            this.f15607a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15611e) {
                if (this.f15612f) {
                    g.a.c1.a.b(th);
                    return;
                } else {
                    this.f15607a.onError(th);
                    return;
                }
            }
            this.f15611e = true;
            if (this.f15609c && !(th instanceof Exception)) {
                this.f15607a.onError(th);
                return;
            }
            try {
                g.a.g0<? extends T> g0VarApply = this.f15608b.apply(th);
                if (g0VarApply != null) {
                    g0VarApply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th);
                this.f15607a.onError(nullPointerException);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.f15607a.onError(new g.a.v0.a(th, th2));
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15612f) {
                return;
            }
            this.f15607a.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15610d.replace(cVar);
        }
    }

    public z1(g.a.g0<T> g0Var, g.a.x0.o<? super Throwable, ? extends g.a.g0<? extends T>> oVar, boolean z) {
        super(g0Var);
        this.f15605b = oVar;
        this.f15606c = z;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        a aVar = new a(i0Var, this.f15605b, this.f15606c);
        i0Var.onSubscribe(aVar.f15610d);
        this.f14934a.subscribe(aVar);
    }
}
