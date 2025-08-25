package g.a.y0.e.a;

/* compiled from: CompletableDisposeOn.java */
/* loaded from: classes2.dex */
public final class j extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14045a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f14046b;

    /* compiled from: CompletableDisposeOn.java */
    static final class a implements g.a.f, g.a.u0.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f f14047a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.j0 f14048b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14049c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f14050d;

        a(g.a.f fVar, g.a.j0 j0Var) {
            this.f14047a = fVar;
            this.f14048b = j0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14050d = true;
            this.f14048b.a(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14050d;
        }

        @Override // g.a.f
        public void onComplete() {
            if (this.f14050d) {
                return;
            }
            this.f14047a.onComplete();
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            if (this.f14050d) {
                g.a.c1.a.b(th);
            } else {
                this.f14047a.onError(th);
            }
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14049c, cVar)) {
                this.f14049c = cVar;
                this.f14047a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14049c.dispose();
            this.f14049c = g.a.y0.a.d.DISPOSED;
        }
    }

    public j(g.a.i iVar, g.a.j0 j0Var) {
        this.f14045a = iVar;
        this.f14046b = j0Var;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14045a.a(new a(fVar, this.f14046b));
    }
}
