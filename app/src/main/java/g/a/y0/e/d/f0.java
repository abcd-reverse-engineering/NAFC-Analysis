package g.a.y0.e.d;

/* compiled from: ObservableDelaySubscriptionOther.java */
/* loaded from: classes2.dex */
public final class f0<T, U> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<? extends T> f15104a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.g0<U> f15105b;

    /* compiled from: ObservableDelaySubscriptionOther.java */
    final class a implements g.a.i0<U> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.y0.a.k f15106a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.i0<? super T> f15107b;

        /* renamed from: c, reason: collision with root package name */
        boolean f15108c;

        /* compiled from: ObservableDelaySubscriptionOther.java */
        /* renamed from: g.a.y0.e.d.f0$a$a, reason: collision with other inner class name */
        final class C0212a implements g.a.i0<T> {
            C0212a() {
            }

            @Override // g.a.i0
            public void onComplete() {
                a.this.f15107b.onComplete();
            }

            @Override // g.a.i0
            public void onError(Throwable th) {
                a.this.f15107b.onError(th);
            }

            @Override // g.a.i0
            public void onNext(T t) {
                a.this.f15107b.onNext(t);
            }

            @Override // g.a.i0
            public void onSubscribe(g.a.u0.c cVar) {
                a.this.f15106a.update(cVar);
            }
        }

        a(g.a.y0.a.k kVar, g.a.i0<? super T> i0Var) {
            this.f15106a = kVar;
            this.f15107b = i0Var;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15108c) {
                return;
            }
            this.f15108c = true;
            f0.this.f15104a.subscribe(new C0212a());
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15108c) {
                g.a.c1.a.b(th);
            } else {
                this.f15108c = true;
                this.f15107b.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(U u) {
            onComplete();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15106a.update(cVar);
        }
    }

    public f0(g.a.g0<? extends T> g0Var, g.a.g0<U> g0Var2) {
        this.f15104a = g0Var;
        this.f15105b = g0Var2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        g.a.y0.a.k kVar = new g.a.y0.a.k();
        i0Var.onSubscribe(kVar);
        this.f15105b.subscribe(new a(kVar, i0Var));
    }
}
