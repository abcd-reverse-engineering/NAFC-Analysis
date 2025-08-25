package g.a.y0.e.d;

/* compiled from: ObservableReduceMaybe.java */
/* loaded from: classes2.dex */
public final class f2<T> extends g.a.s<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15112a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.c<T, T, T> f15113b;

    /* compiled from: ObservableReduceMaybe.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f15114a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.c<T, T, T> f15115b;

        /* renamed from: c, reason: collision with root package name */
        boolean f15116c;

        /* renamed from: d, reason: collision with root package name */
        T f15117d;

        /* renamed from: e, reason: collision with root package name */
        g.a.u0.c f15118e;

        a(g.a.v<? super T> vVar, g.a.x0.c<T, T, T> cVar) {
            this.f15114a = vVar;
            this.f15115b = cVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15118e.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15118e.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15116c) {
                return;
            }
            this.f15116c = true;
            T t = this.f15117d;
            this.f15117d = null;
            if (t != null) {
                this.f15114a.onSuccess(t);
            } else {
                this.f15114a.onComplete();
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15116c) {
                g.a.c1.a.b(th);
                return;
            }
            this.f15116c = true;
            this.f15117d = null;
            this.f15114a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15116c) {
                return;
            }
            T t2 = this.f15117d;
            if (t2 == null) {
                this.f15117d = t;
                return;
            }
            try {
                this.f15117d = (T) g.a.y0.b.b.a((Object) this.f15115b.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15118e.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15118e, cVar)) {
                this.f15118e = cVar;
                this.f15114a.onSubscribe(this);
            }
        }
    }

    public f2(g.a.g0<T> g0Var, g.a.x0.c<T, T, T> cVar) {
        this.f15112a = g0Var;
        this.f15113b = cVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f15112a.subscribe(new a(vVar, this.f15113b));
    }
}
