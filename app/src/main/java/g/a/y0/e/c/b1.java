package g.a.y0.e.c;

/* compiled from: MaybePeek.java */
/* loaded from: classes2.dex */
public final class b1<T> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.g<? super g.a.u0.c> f14754b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.g<? super T> f14755c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.g<? super Throwable> f14756d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.x0.a f14757e;

    /* renamed from: f, reason: collision with root package name */
    final g.a.x0.a f14758f;

    /* renamed from: g, reason: collision with root package name */
    final g.a.x0.a f14759g;

    public b1(g.a.y<T> yVar, g.a.x0.g<? super g.a.u0.c> gVar, g.a.x0.g<? super T> gVar2, g.a.x0.g<? super Throwable> gVar3, g.a.x0.a aVar, g.a.x0.a aVar2, g.a.x0.a aVar3) {
        super(yVar);
        this.f14754b = gVar;
        this.f14755c = gVar2;
        this.f14756d = gVar3;
        this.f14757e = aVar;
        this.f14758f = aVar2;
        this.f14759g = aVar3;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar, this));
    }

    /* compiled from: MaybePeek.java */
    static final class a<T> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14760a;

        /* renamed from: b, reason: collision with root package name */
        final b1<T> f14761b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14762c;

        a(g.a.v<? super T> vVar, b1<T> b1Var) {
            this.f14760a = vVar;
            this.f14761b = b1Var;
        }

        void a(Throwable th) {
            try {
                this.f14761b.f14756d.accept(th);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                th = new g.a.v0.a(th, th2);
            }
            this.f14762c = g.a.y0.a.d.DISPOSED;
            this.f14760a.onError(th);
            a();
        }

        @Override // g.a.u0.c
        public void dispose() {
            try {
                this.f14761b.f14759g.run();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
            this.f14762c.dispose();
            this.f14762c = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14762c.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            if (this.f14762c == g.a.y0.a.d.DISPOSED) {
                return;
            }
            try {
                this.f14761b.f14757e.run();
                this.f14762c = g.a.y0.a.d.DISPOSED;
                this.f14760a.onComplete();
                a();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                a(th);
            }
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            if (this.f14762c == g.a.y0.a.d.DISPOSED) {
                g.a.c1.a.b(th);
            } else {
                a(th);
            }
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14762c, cVar)) {
                try {
                    this.f14761b.f14754b.accept(cVar);
                    this.f14762c = cVar;
                    this.f14760a.onSubscribe(this);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    cVar.dispose();
                    this.f14762c = g.a.y0.a.d.DISPOSED;
                    g.a.y0.a.e.error(th, this.f14760a);
                }
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            if (this.f14762c == g.a.y0.a.d.DISPOSED) {
                return;
            }
            try {
                this.f14761b.f14755c.accept(t);
                this.f14762c = g.a.y0.a.d.DISPOSED;
                this.f14760a.onSuccess(t);
                a();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                a(th);
            }
        }

        void a() {
            try {
                this.f14761b.f14758f.run();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
        }
    }
}
