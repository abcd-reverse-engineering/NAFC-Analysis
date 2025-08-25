package g.a.y0.e.a;

/* compiled from: CompletableDoOnEvent.java */
/* loaded from: classes2.dex */
public final class l extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14070a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.g<? super Throwable> f14071b;

    /* compiled from: CompletableDoOnEvent.java */
    final class a implements g.a.f {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.f f14072a;

        a(g.a.f fVar) {
            this.f14072a = fVar;
        }

        @Override // g.a.f
        public void onComplete() {
            try {
                l.this.f14071b.accept(null);
                this.f14072a.onComplete();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14072a.onError(th);
            }
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            try {
                l.this.f14071b.accept(th);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                th = new g.a.v0.a(th, th2);
            }
            this.f14072a.onError(th);
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            this.f14072a.onSubscribe(cVar);
        }
    }

    public l(g.a.i iVar, g.a.x0.g<? super Throwable> gVar) {
        this.f14070a = iVar;
        this.f14071b = gVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14070a.a(new a(fVar));
    }
}
