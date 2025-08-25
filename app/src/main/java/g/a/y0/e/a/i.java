package g.a.y0.e.a;

/* compiled from: CompletableDetach.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class i extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14040a;

    /* compiled from: CompletableDetach.java */
    static final class a implements g.a.f, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        g.a.f f14041a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f14042b;

        a(g.a.f fVar) {
            this.f14041a = fVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14041a = null;
            this.f14042b.dispose();
            this.f14042b = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14042b.isDisposed();
        }

        @Override // g.a.f
        public void onComplete() {
            this.f14042b = g.a.y0.a.d.DISPOSED;
            g.a.f fVar = this.f14041a;
            if (fVar != null) {
                this.f14041a = null;
                fVar.onComplete();
            }
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            this.f14042b = g.a.y0.a.d.DISPOSED;
            g.a.f fVar = this.f14041a;
            if (fVar != null) {
                this.f14041a = null;
                fVar.onError(th);
            }
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14042b, cVar)) {
                this.f14042b = cVar;
                this.f14041a.onSubscribe(this);
            }
        }
    }

    public i(g.a.i iVar) {
        this.f14040a = iVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14040a.a(new a(fVar));
    }
}
