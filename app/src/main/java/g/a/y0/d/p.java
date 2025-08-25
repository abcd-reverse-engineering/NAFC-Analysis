package g.a.y0.d;

import g.a.i0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ForEachWhileObserver.java */
/* loaded from: classes2.dex */
public final class p<T> extends AtomicReference<g.a.u0.c> implements i0<T>, g.a.u0.c {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final g.a.x0.a onComplete;
    final g.a.x0.g<? super Throwable> onError;
    final g.a.x0.r<? super T> onNext;

    public p(g.a.x0.r<? super T> rVar, g.a.x0.g<? super Throwable> gVar, g.a.x0.a aVar) {
        this.onNext = rVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    @Override // g.a.u0.c
    public void dispose() {
        g.a.y0.a.d.dispose(this);
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return g.a.y0.a.d.isDisposed(get());
    }

    @Override // g.a.i0
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
        }
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        if (this.done) {
            g.a.c1.a.b(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            g.a.v0.b.b(th2);
            g.a.c1.a.b(new g.a.v0.a(th, th2));
        }
    }

    @Override // g.a.i0
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.test(t)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            dispose();
            onError(th);
        }
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        g.a.y0.a.d.setOnce(this, cVar);
    }
}
