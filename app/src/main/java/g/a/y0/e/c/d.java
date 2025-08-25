package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeCallbackObserver.java */
/* loaded from: classes2.dex */
public final class d<T> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c, g.a.a1.g {
    private static final long serialVersionUID = -6076952298809384986L;
    final g.a.x0.a onComplete;
    final g.a.x0.g<? super Throwable> onError;
    final g.a.x0.g<? super T> onSuccess;

    public d(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar) {
        this.onSuccess = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
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
        return g.a.y0.a.d.isDisposed(get());
    }

    @Override // g.a.v
    public void onComplete() {
        lazySet(g.a.y0.a.d.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
        }
    }

    @Override // g.a.v
    public void onError(Throwable th) {
        lazySet(g.a.y0.a.d.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            g.a.v0.b.b(th2);
            g.a.c1.a.b(new g.a.v0.a(th, th2));
        }
    }

    @Override // g.a.v
    public void onSubscribe(g.a.u0.c cVar) {
        g.a.y0.a.d.setOnce(this, cVar);
    }

    @Override // g.a.v, g.a.n0
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
