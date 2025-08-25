package g.a.y0.e.d;

/* compiled from: ObservableScan.java */
/* loaded from: classes2.dex */
public final class t2<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.c<T, T, T> f15487b;

    /* compiled from: ObservableScan.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15488a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.c<T, T, T> f15489b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15490c;

        /* renamed from: d, reason: collision with root package name */
        T f15491d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15492e;

        a(g.a.i0<? super T> i0Var, g.a.x0.c<T, T, T> cVar) {
            this.f15488a = i0Var;
            this.f15489b = cVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15490c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15490c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15492e) {
                return;
            }
            this.f15492e = true;
            this.f15488a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15492e) {
                g.a.c1.a.b(th);
            } else {
                this.f15492e = true;
                this.f15488a.onError(th);
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15492e) {
                return;
            }
            g.a.i0<? super T> i0Var = this.f15488a;
            T t2 = this.f15491d;
            if (t2 == null) {
                this.f15491d = t;
                i0Var.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) g.a.y0.b.b.a((Object) this.f15489b.apply(t2, t), "The value returned by the accumulator is null");
                this.f15491d = r4;
                i0Var.onNext(r4);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15490c.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15490c, cVar)) {
                this.f15490c = cVar;
                this.f15488a.onSubscribe(this);
            }
        }
    }

    public t2(g.a.g0<T> g0Var, g.a.x0.c<T, T, T> cVar) {
        super(g0Var);
        this.f15487b = cVar;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15487b));
    }
}
