package g.a.y0.e.d;

/* compiled from: ObservableOnErrorReturn.java */
/* loaded from: classes2.dex */
public final class a2<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super Throwable, ? extends T> f14942b;

    /* compiled from: ObservableOnErrorReturn.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f14943a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super Throwable, ? extends T> f14944b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14945c;

        a(g.a.i0<? super T> i0Var, g.a.x0.o<? super Throwable, ? extends T> oVar) {
            this.f14943a = i0Var;
            this.f14944b = oVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14945c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14945c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f14943a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            try {
                T tApply = this.f14944b.apply(th);
                if (tApply != null) {
                    this.f14943a.onNext(tApply);
                    this.f14943a.onComplete();
                } else {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f14943a.onError(nullPointerException);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.f14943a.onError(new g.a.v0.a(th, th2));
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f14943a.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14945c, cVar)) {
                this.f14945c = cVar;
                this.f14943a.onSubscribe(this);
            }
        }
    }

    public a2(g.a.g0<T> g0Var, g.a.x0.o<? super Throwable, ? extends T> oVar) {
        super(g0Var);
        this.f14942b = oVar;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f14942b));
    }
}
