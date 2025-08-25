package g.a.y0.d;

import g.a.i0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LambdaObserver.java */
/* loaded from: classes2.dex */
public final class v<T> extends AtomicReference<g.a.u0.c> implements i0<T>, g.a.u0.c, g.a.a1.g {
    private static final long serialVersionUID = -7251123623727029452L;
    final g.a.x0.a onComplete;
    final g.a.x0.g<? super Throwable> onError;
    final g.a.x0.g<? super T> onNext;
    final g.a.x0.g<? super g.a.u0.c> onSubscribe;

    public v(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar, g.a.x0.g<? super g.a.u0.c> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
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

    @Override // g.a.i0
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(g.a.y0.a.d.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
        }
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        lazySet(g.a.y0.a.d.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            g.a.v0.b.b(th2);
            g.a.c1.a.b(new g.a.v0.a(th, th2));
        }
    }

    @Override // g.a.i0
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        if (g.a.y0.a.d.setOnce(this, cVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cVar.dispose();
                onError(th);
            }
        }
    }
}
