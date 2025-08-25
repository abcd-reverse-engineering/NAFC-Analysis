package g.a.y0.e.d;

/* compiled from: ObservableFromPublisher.java */
/* loaded from: classes2.dex */
public final class e1<T> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.d.b<? extends T> f15084a;

    /* compiled from: ObservableFromPublisher.java */
    static final class a<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15085a;

        /* renamed from: b, reason: collision with root package name */
        i.d.d f15086b;

        a(g.a.i0<? super T> i0Var) {
            this.f15085a = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15086b.cancel();
            this.f15086b = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15086b == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            this.f15085a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f15085a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.f15085a.onNext(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f15086b, dVar)) {
                this.f15086b = dVar;
                this.f15085a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public e1(i.d.b<? extends T> bVar) {
        this.f15084a = bVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f15084a.subscribe(new a(i0Var));
    }
}
