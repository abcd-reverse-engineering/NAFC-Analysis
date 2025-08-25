package g.a.y0.e.a;

/* compiled from: CompletableFromRunnable.java */
/* loaded from: classes2.dex */
public final class t extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final Runnable f14097a;

    public t(Runnable runnable) {
        this.f14097a = runnable;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        g.a.u0.c cVarB = g.a.u0.d.b();
        fVar.onSubscribe(cVarB);
        try {
            this.f14097a.run();
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
