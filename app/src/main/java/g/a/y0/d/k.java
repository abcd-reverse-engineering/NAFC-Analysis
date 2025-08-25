package g.a.y0.d;

import g.a.n0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ConsumerSingleObserver.java */
/* loaded from: classes2.dex */
public final class k<T> extends AtomicReference<g.a.u0.c> implements n0<T>, g.a.u0.c, g.a.a1.g {
    private static final long serialVersionUID = -7012088219455310787L;
    final g.a.x0.g<? super Throwable> onError;
    final g.a.x0.g<? super T> onSuccess;

    public k(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2) {
        this.onSuccess = gVar;
        this.onError = gVar2;
    }

    @Override // g.a.u0.c
    public void dispose() {
        g.a.y0.a.d.dispose(this);
    }

    @Override // g.a.a1.g
    public boolean hasCustomOnError() {
        return this.onError != g.a.y0.b.a.f13902f;
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return get() == g.a.y0.a.d.DISPOSED;
    }

    @Override // g.a.n0
    public void onError(Throwable th) {
        lazySet(g.a.y0.a.d.DISPOSED);
        try {
            this.onError.accept(th);
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
        lazySet(g.a.y0.a.d.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
        }
    }
}
