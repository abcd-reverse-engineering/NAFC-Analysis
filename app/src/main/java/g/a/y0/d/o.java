package g.a.y0.d;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: EmptyCompletableObserver.java */
/* loaded from: classes2.dex */
public final class o extends AtomicReference<g.a.u0.c> implements g.a.f, g.a.u0.c, g.a.a1.g {
    private static final long serialVersionUID = -7545121636549663526L;

    @Override // g.a.u0.c
    public void dispose() {
        g.a.y0.a.d.dispose(this);
    }

    @Override // g.a.a1.g
    public boolean hasCustomOnError() {
        return false;
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return get() == g.a.y0.a.d.DISPOSED;
    }

    @Override // g.a.f
    public void onComplete() {
        lazySet(g.a.y0.a.d.DISPOSED);
    }

    @Override // g.a.f
    public void onError(Throwable th) {
        lazySet(g.a.y0.a.d.DISPOSED);
        g.a.c1.a.b(new g.a.v0.d(th));
    }

    @Override // g.a.f
    public void onSubscribe(g.a.u0.c cVar) {
        g.a.y0.a.d.setOnce(this, cVar);
    }
}
