package g.a.y0.h;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SubscriberResourceWrapper.java */
/* loaded from: classes2.dex */
public final class u<T> extends AtomicReference<g.a.u0.c> implements g.a.q<T>, g.a.u0.c, i.d.d {
    private static final long serialVersionUID = -8612022020200669122L;
    final i.d.c<? super T> actual;
    final AtomicReference<i.d.d> subscription = new AtomicReference<>();

    public u(i.d.c<? super T> cVar) {
        this.actual = cVar;
    }

    @Override // i.d.d
    public void cancel() {
        dispose();
    }

    @Override // g.a.u0.c
    public void dispose() {
        g.a.y0.i.j.cancel(this.subscription);
        g.a.y0.a.d.dispose(this);
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return this.subscription.get() == g.a.y0.i.j.CANCELLED;
    }

    @Override // i.d.c
    public void onComplete() {
        g.a.y0.a.d.dispose(this);
        this.actual.onComplete();
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        g.a.y0.a.d.dispose(this);
        this.actual.onError(th);
    }

    @Override // i.d.c
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (g.a.y0.i.j.setOnce(this.subscription, dVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // i.d.d
    public void request(long j2) {
        if (g.a.y0.i.j.validate(j2)) {
            this.subscription.get().request(j2);
        }
    }

    public void setResource(g.a.u0.c cVar) {
        g.a.y0.a.d.set(this, cVar);
    }
}
