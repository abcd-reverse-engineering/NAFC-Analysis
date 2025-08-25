package g.a.y0.d;

import g.a.i0;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BlockingObserver.java */
/* loaded from: classes2.dex */
public final class i<T> extends AtomicReference<g.a.u0.c> implements i0<T>, g.a.u0.c {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public i(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // g.a.u0.c
    public void dispose() {
        if (g.a.y0.a.d.dispose(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return get() == g.a.y0.a.d.DISPOSED;
    }

    @Override // g.a.i0
    public void onComplete() {
        this.queue.offer(g.a.y0.j.q.complete());
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        this.queue.offer(g.a.y0.j.q.error(th));
    }

    @Override // g.a.i0
    public void onNext(T t) {
        this.queue.offer(g.a.y0.j.q.next(t));
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        g.a.y0.a.d.setOnce(this, cVar);
    }
}
