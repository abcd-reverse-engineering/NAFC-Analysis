package g.a.y0.e.d;

/* compiled from: ObservableSingleMaybe.java */
/* loaded from: classes2.dex */
public final class y2<T> extends g.a.s<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15589a;

    /* compiled from: ObservableSingleMaybe.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f15590a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f15591b;

        /* renamed from: c, reason: collision with root package name */
        T f15592c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15593d;

        a(g.a.v<? super T> vVar) {
            this.f15590a = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15591b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15591b.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15593d) {
                return;
            }
            this.f15593d = true;
            T t = this.f15592c;
            this.f15592c = null;
            if (t == null) {
                this.f15590a.onComplete();
            } else {
                this.f15590a.onSuccess(t);
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15593d) {
                g.a.c1.a.b(th);
            } else {
                this.f15593d = true;
                this.f15590a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15593d) {
                return;
            }
            if (this.f15592c == null) {
                this.f15592c = t;
                return;
            }
            this.f15593d = true;
            this.f15591b.dispose();
            this.f15590a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15591b, cVar)) {
                this.f15591b = cVar;
                this.f15590a.onSubscribe(this);
            }
        }
    }

    public y2(g.a.g0<T> g0Var) {
        this.f15589a = g0Var;
    }

    @Override // g.a.s
    public void b(g.a.v<? super T> vVar) {
        this.f15589a.subscribe(new a(vVar));
    }
}
