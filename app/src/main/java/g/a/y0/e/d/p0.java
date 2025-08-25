package g.a.y0.e.d;

/* compiled from: ObservableElementAtMaybe.java */
/* loaded from: classes2.dex */
public final class p0<T> extends g.a.s<T> implements g.a.y0.c.d<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15380a;

    /* renamed from: b, reason: collision with root package name */
    final long f15381b;

    /* compiled from: ObservableElementAtMaybe.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f15382a;

        /* renamed from: b, reason: collision with root package name */
        final long f15383b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15384c;

        /* renamed from: d, reason: collision with root package name */
        long f15385d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15386e;

        a(g.a.v<? super T> vVar, long j2) {
            this.f15382a = vVar;
            this.f15383b = j2;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15384c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15384c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15386e) {
                return;
            }
            this.f15386e = true;
            this.f15382a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15386e) {
                g.a.c1.a.b(th);
            } else {
                this.f15386e = true;
                this.f15382a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15386e) {
                return;
            }
            long j2 = this.f15385d;
            if (j2 != this.f15383b) {
                this.f15385d = j2 + 1;
                return;
            }
            this.f15386e = true;
            this.f15384c.dispose();
            this.f15382a.onSuccess(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15384c, cVar)) {
                this.f15384c = cVar;
                this.f15382a.onSubscribe(this);
            }
        }
    }

    public p0(g.a.g0<T> g0Var, long j2) {
        this.f15380a = g0Var;
        this.f15381b = j2;
    }

    @Override // g.a.y0.c.d
    public g.a.b0<T> a() {
        return g.a.c1.a.a(new o0(this.f15380a, this.f15381b, null, false));
    }

    @Override // g.a.s
    public void b(g.a.v<? super T> vVar) {
        this.f15380a.subscribe(new a(vVar, this.f15381b));
    }
}
