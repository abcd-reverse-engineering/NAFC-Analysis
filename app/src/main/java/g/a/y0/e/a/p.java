package g.a.y0.e.a;

/* compiled from: CompletableFromAction.java */
/* loaded from: classes2.dex */
public final class p extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.x0.a f14090a;

    public p(g.a.x0.a aVar) {
        this.f14090a = aVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        g.a.u0.c cVarB = g.a.u0.d.b();
        fVar.onSubscribe(cVarB);
        try {
            this.f14090a.run();
            if (cVarB.isDisposed()) {
                return;
            }
            fVar.onComplete();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            if (cVarB.isDisposed()) {
                return;
            }
            fVar.onError(th);
        }
    }
}
