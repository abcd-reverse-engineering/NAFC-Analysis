package g.a.y0.d;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CallbackCompletableObserver.java */
/* loaded from: classes2.dex */
public final class j extends AtomicReference<g.a.u0.c> implements g.a.f, g.a.u0.c, g.a.x0.g<Throwable>, g.a.a1.g {
    private static final long serialVersionUID = -4361286194466301354L;
    final g.a.x0.a onComplete;
    final g.a.x0.g<? super Throwable> onError;

    public j(g.a.x0.a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    @Override // g.a.u0.c
    public void dispose() {
        g.a.y0.a.d.dispose(this);
    }

    @Override // g.a.a1.g
    public boolean hasCustomOnError() {
        return this.onError != this;
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return get() == g.a.y0.a.d.DISPOSED;
    }

    @Override // g.a.f
    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
        }
        lazySet(g.a.y0.a.d.DISPOSED);
    }

    @Override // g.a.f
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            g.a.v0.b.b(th2);
            g.a.c1.a.b(th2);
        }
        lazySet(g.a.y0.a.d.DISPOSED);
    }

    @Override // g.a.f
    public void onSubscribe(g.a.u0.c cVar) {
        g.a.y0.a.d.setOnce(this, cVar);
    }

    @Override // g.a.x0.g
    public void accept(Throwable th) {
        g.a.c1.a.b(new g.a.v0.d(th));
    }

    public j(g.a.x0.g<? super Throwable> gVar, g.a.x0.a aVar) {
        this.onError = gVar;
        this.onComplete = aVar;
    }
}
