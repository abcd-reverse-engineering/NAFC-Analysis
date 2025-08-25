package g.a.y0.d;

import g.a.n0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BiConsumerSingleObserver.java */
/* loaded from: classes2.dex */
public final class d<T> extends AtomicReference<g.a.u0.c> implements n0<T>, g.a.u0.c {
    private static final long serialVersionUID = 4943102778943297569L;
    final g.a.x0.b<? super T, ? super Throwable> onCallback;

    public d(g.a.x0.b<? super T, ? super Throwable> bVar) {
        this.onCallback = bVar;
    }

    @Override // g.a.u0.c
    public void dispose() {
        g.a.y0.a.d.dispose(this);
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return get() == g.a.y0.a.d.DISPOSED;
    }

    @Override // g.a.n0
    public void onError(Throwable th) {
        try {
            lazySet(g.a.y0.a.d.DISPOSED);
            this.onCallback.a(null, th);
        } catch (Throwable th2) {
            g.a.v0.b.b(th2);
            g.a.c1.a.b(new g.a.v0.a(th, th2));
        }
    }

    @Override // g.a.n0
    public void onSubscribe(g.a.u0.c cVar) {
        g.a.y0.a.d.setOnce(this, cVar);
    }

    @Override // g.a.n0
    public void onSuccess(T t) {
        try {
            lazySet(g.a.y0.a.d.DISPOSED);
            this.onCallback.a(t, null);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
        }
    }
}
