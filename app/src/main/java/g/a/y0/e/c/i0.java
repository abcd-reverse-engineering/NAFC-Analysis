package g.a.y0.e.c;

import java.util.concurrent.Callable;

/* compiled from: MaybeFromCallable.java */
/* loaded from: classes2.dex */
public final class i0<T> extends g.a.s<T> implements Callable<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends T> f14819a;

    public i0(Callable<? extends T> callable) {
        this.f14819a = callable;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        g.a.u0.c cVarB = g.a.u0.d.b();
        vVar.onSubscribe(cVarB);
        if (cVarB.isDisposed()) {
            return;
        }
        try {
            T tCall = this.f14819a.call();
            if (cVarB.isDisposed()) {
                return;
            }
            if (tCall == null) {
                vVar.onComplete();
            } else {
                vVar.onSuccess(tCall);
            }
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
        return this.f14819a.call();
    }
}
