package g.a.y0.e.c;

import java.util.concurrent.Callable;

/* compiled from: MaybeFromAction.java */
/* loaded from: classes2.dex */
public final class h0<T> extends g.a.s<T> implements Callable<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.x0.a f14813a;

    public h0(g.a.x0.a aVar) {
        this.f14813a = aVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        g.a.u0.c cVarB = g.a.u0.d.b();
        vVar.onSubscribe(cVarB);
        if (cVarB.isDisposed()) {
            return;
        }
        try {
            this.f14813a.run();
            if (cVarB.isDisposed()) {
                return;
            }
            vVar.onComplete();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            if (cVarB.isDisposed()) {
                g.a.c1.a.b(th);
            } else {
                vVar.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        this.f14813a.run();
        return null;
    }
}
