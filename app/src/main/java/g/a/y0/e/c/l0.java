package g.a.y0.e.c;

import java.util.concurrent.Callable;

/* compiled from: MaybeFromRunnable.java */
/* loaded from: classes2.dex */
public final class l0<T> extends g.a.s<T> implements Callable<T> {

    /* renamed from: a, reason: collision with root package name */
    final Runnable f14838a;

    public l0(Runnable runnable) {
        this.f14838a = runnable;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        g.a.u0.c cVarB = g.a.u0.d.b();
        vVar.onSubscribe(cVarB);
        if (cVarB.isDisposed()) {
            return;
        }
        try {
            this.f14838a.run();
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
        this.f14838a.run();
        return null;
    }
}
