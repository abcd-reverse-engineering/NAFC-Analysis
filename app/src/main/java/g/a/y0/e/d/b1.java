package g.a.y0.e.d;

import java.util.concurrent.Callable;

/* compiled from: ObservableFromCallable.java */
/* loaded from: classes2.dex */
public final class b1<T> extends g.a.b0<T> implements Callable<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends T> f14973a;

    public b1(Callable<? extends T> callable) {
        this.f14973a = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) g.a.y0.b.b.a((Object) this.f14973a.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        g.a.y0.d.l lVar = new g.a.y0.d.l(i0Var);
        i0Var.onSubscribe(lVar);
        if (lVar.isDisposed()) {
            return;
        }
        try {
            lVar.complete(g.a.y0.b.b.a((Object) this.f14973a.call(), "Callable returned null"));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            if (lVar.isDisposed()) {
                g.a.c1.a.b(th);
            } else {
                i0Var.onError(th);
            }
        }
    }
}
