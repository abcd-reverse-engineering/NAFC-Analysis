package g.a.y0.e.a;

/* compiled from: CompletableOnErrorComplete.java */
/* loaded from: classes2.dex */
public final class f0 extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14008a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super Throwable> f14009b;

    /* compiled from: CompletableOnErrorComplete.java */
    final class a implements g.a.f {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.f f14010a;

        a(g.a.f fVar) {
            this.f14010a = fVar;
        }

        @Override // g.a.f
        public void onComplete() {
            this.f14010a.onComplete();
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            try {
                if (f0.this.f14009b.test(th)) {
                    this.f14010a.onComplete();
                } else {
                    this.f14010a.onError(th);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.f14010a.onError(new g.a.v0.a(th, th2));
            }
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            this.f14010a.onSubscribe(cVar);
        }
    }

    public f0(g.a.i iVar, g.a.x0.r<? super Throwable> rVar) {
        this.f14008a = iVar;
        this.f14009b = rVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14008a.a(new a(fVar));
    }
}
