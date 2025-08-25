package g.a.y0.h;

import h.q2.t.m0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ForEachWhileSubscriber.java */
/* loaded from: classes2.dex */
public final class h<T> extends AtomicReference<i.d.d> implements g.a.q<T>, g.a.u0.c {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final g.a.x0.a onComplete;
    final g.a.x0.g<? super Throwable> onError;
    final g.a.x0.r<? super T> onNext;

    public h(g.a.x0.r<? super T> rVar, g.a.x0.g<? super Throwable> gVar, g.a.x0.a aVar) {
        this.onNext = rVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    @Override // g.a.u0.c
    public void dispose() {
        g.a.y0.i.j.cancel(this);
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return g.a.y0.i.j.isCancelled(get());
    }

    @Override // i.d.c
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

    @Override // i.d.c
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

    @Override // i.d.c
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

    @Override // g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (g.a.y0.i.j.setOnce(this, dVar)) {
            dVar.request(m0.f16408b);
        }
    }
}
