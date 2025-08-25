package g.a.y0.h;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: StrictSubscriber.java */
/* loaded from: classes2.dex */
public class t<T> extends AtomicInteger implements g.a.q<T>, i.d.d {
    private static final long serialVersionUID = -4945028590049415624L;
    final i.d.c<? super T> actual;
    volatile boolean done;
    final g.a.y0.j.c error = new g.a.y0.j.c();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<i.d.d> s = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();

    public t(i.d.c<? super T> cVar) {
        this.actual = cVar;
    }

    @Override // i.d.d
    public void cancel() {
        if (this.done) {
            return;
        }
        g.a.y0.i.j.cancel(this.s);
    }

    @Override // i.d.c
    public void onComplete() {
        this.done = true;
        g.a.y0.j.l.a(this.actual, this, this.error);
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        this.done = true;
        g.a.y0.j.l.a((i.d.c<?>) this.actual, th, (AtomicInteger) this, this.error);
    }

    @Override // i.d.c
    public void onNext(T t) {
        g.a.y0.j.l.a(this.actual, t, this, this.error);
    }

    @Override // g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (this.once.compareAndSet(false, true)) {
            this.actual.onSubscribe(this);
            g.a.y0.i.j.deferredSetOnce(this.s, this.requested, dVar);
        } else {
            dVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // i.d.d
    public void request(long j2) {
        if (j2 > 0) {
            g.a.y0.i.j.deferredRequest(this.s, this.requested, j2);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j2));
    }
}
