package g.a.y0.h;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BlockingSubscriber.java */
/* loaded from: classes2.dex */
public final class f<T> extends AtomicReference<i.d.d> implements g.a.q<T>, i.d.d {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public f(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // i.d.d
    public void cancel() {
        if (g.a.y0.i.j.cancel(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        return get() == g.a.y0.i.j.CANCELLED;
    }

    @Override // i.d.c
    public void onComplete() {
        this.queue.offer(g.a.y0.j.q.complete());
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        this.queue.offer(g.a.y0.j.q.error(th));
    }

    @Override // i.d.c
    public void onNext(T t) {
        this.queue.offer(g.a.y0.j.q.next(t));
    }

    @Override // g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (g.a.y0.i.j.setOnce(this, dVar)) {
            this.queue.offer(g.a.y0.j.q.subscription(this));
        }
    }

    @Override // i.d.d
    public void request(long j2) {
        get().request(j2);
    }
}
