package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObserverResourceWrapper.java */
/* loaded from: classes2.dex */
public final class h4<T> extends AtomicReference<g.a.u0.c> implements g.a.i0<T>, g.a.u0.c {
    private static final long serialVersionUID = -8612022020200669122L;
    final g.a.i0<? super T> actual;
    final AtomicReference<g.a.u0.c> subscription = new AtomicReference<>();

    public h4(g.a.i0<? super T> i0Var) {
        this.actual = i0Var;
    }

    @Override // g.a.u0.c
    public void dispose() {
        g.a.y0.a.d.dispose(this.subscription);
        g.a.y0.a.d.dispose(this);
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return this.subscription.get() == g.a.y0.a.d.DISPOSED;
    }

    @Override // g.a.i0
    public void onComplete() {
        dispose();
        this.actual.onComplete();
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        dispose();
        this.actual.onError(th);
    }

    @Override // g.a.i0
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        if (g.a.y0.a.d.setOnce(this.subscription, cVar)) {
            this.actual.onSubscribe(this);
        }
    }

    public void setResource(g.a.u0.c cVar) {
        g.a.y0.a.d.set(this, cVar);
    }
}
