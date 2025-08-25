package g.a.y0.e.d;

/* compiled from: ObservableDoOnEach.java */
/* loaded from: classes2.dex */
public final class m0<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.g<? super T> f15267b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.g<? super Throwable> f15268c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.a f15269d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.x0.a f15270e;

    /* compiled from: ObservableDoOnEach.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15271a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.g<? super T> f15272b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.x0.g<? super Throwable> f15273c;

        /* renamed from: d, reason: collision with root package name */
        final g.a.x0.a f15274d;

        /* renamed from: e, reason: collision with root package name */
        final g.a.x0.a f15275e;

        /* renamed from: f, reason: collision with root package name */
        g.a.u0.c f15276f;

        /* renamed from: g, reason: collision with root package name */
        boolean f15277g;

        a(g.a.i0<? super T> i0Var, g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar, g.a.x0.a aVar2) {
            this.f15271a = i0Var;
            this.f15272b = gVar;
            this.f15273c = gVar2;
            this.f15274d = aVar;
            this.f15275e = aVar2;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15276f.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15276f.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15277g) {
                return;
            }
            try {
                this.f15274d.run();
                this.f15277g = true;
                this.f15271a.onComplete();
                try {
                    this.f15275e.run();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.c1.a.b(th);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                onError(th2);
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15277g) {
                g.a.c1.a.b(th);
                return;
            }
            this.f15277g = true;
            try {
                this.f15273c.accept(th);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                th = new g.a.v0.a(th, th2);
            }
            this.f15271a.onError(th);
            try {
                this.f15275e.run();
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                g.a.c1.a.b(th3);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15277g) {
                return;
            }
            try {
                this.f15272b.accept(t);
                this.f15271a.onNext(t);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15276f.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15276f, cVar)) {
                this.f15276f = cVar;
                this.f15271a.onSubscribe(this);
            }
        }
    }

    public m0(g.a.g0<T> g0Var, g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar, g.a.x0.a aVar2) {
        super(g0Var);
        this.f15267b = gVar;
        this.f15268c = gVar2;
        this.f15269d = aVar;
        this.f15270e = aVar2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15267b, this.f15268c, this.f15269d, this.f15270e));
    }
}
