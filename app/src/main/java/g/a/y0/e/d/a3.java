package g.a.y0.e.d;

/* compiled from: ObservableSkip.java */
/* loaded from: classes2.dex */
public final class a3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final long f14946b;

    /* compiled from: ObservableSkip.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f14947a;

        /* renamed from: b, reason: collision with root package name */
        long f14948b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14949c;

        a(g.a.i0<? super T> i0Var, long j2) {
            this.f14947a = i0Var;
            this.f14948b = j2;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14949c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14949c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f14947a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f14947a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            long j2 = this.f14948b;
            if (j2 != 0) {
                this.f14948b = j2 - 1;
            } else {
                this.f14947a.onNext(t);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f14949c = cVar;
            this.f14947a.onSubscribe(this);
        }
    }

    public a3(g.a.g0<T> g0Var, long j2) {
        super(g0Var);
        this.f14946b = j2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f14946b));
    }
}
