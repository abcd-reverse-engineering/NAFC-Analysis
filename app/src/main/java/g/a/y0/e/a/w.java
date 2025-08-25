package g.a.y0.e.a;

/* compiled from: CompletableHide.java */
/* loaded from: classes2.dex */
public final class w extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14101a;

    /* compiled from: CompletableHide.java */
    static final class a implements g.a.f, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f f14102a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f14103b;

        a(g.a.f fVar) {
            this.f14102a = fVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14103b.dispose();
            this.f14103b = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14103b.isDisposed();
        }

        @Override // g.a.f
        public void onComplete() {
            this.f14102a.onComplete();
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            this.f14102a.onError(th);
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14103b, cVar)) {
                this.f14103b = cVar;
                this.f14102a.onSubscribe(this);
            }
        }
    }

    public w(g.a.i iVar) {
        this.f14101a = iVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14101a.a(new a(fVar));
    }
}
