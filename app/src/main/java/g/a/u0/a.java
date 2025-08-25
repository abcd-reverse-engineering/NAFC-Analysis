package g.a.u0;

import g.a.y0.j.k;

/* compiled from: ActionDisposable.java */
/* loaded from: classes2.dex */
final class a extends f<g.a.x0.a> {
    private static final long serialVersionUID = -8219729196779211169L;

    a(g.a.x0.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.a.u0.f
    public void onDisposed(@g.a.t0.f g.a.x0.a aVar) {
        try {
            aVar.run();
        } catch (Throwable th) {
            throw k.c(th);
        }
    }
}
