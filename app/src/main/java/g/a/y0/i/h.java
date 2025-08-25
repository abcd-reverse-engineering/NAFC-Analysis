package g.a.y0.i;

import g.a.y0.c.l;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ScalarSubscription.java */
/* loaded from: classes2.dex */
public final class h<T> extends AtomicInteger implements l<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final i.d.c<? super T> subscriber;
    final T value;

    public h(i.d.c<? super T> cVar, T t) {
        this.subscriber = cVar;
        this.value = t;
    }

    @Override // i.d.d
    public void cancel() {
        lazySet(2);
    }

    @Override // g.a.y0.c.o
    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        return get() == 2;
    }

    @Override // g.a.y0.c.o
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // g.a.y0.c.o
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // g.a.y0.c.o
    @g.a.t0.g
    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    @Override // i.d.d
    public void request(long j2) {
        if (j.validate(j2) && compareAndSet(0, 1)) {
            i.d.c<? super T> cVar = this.subscriber;
            cVar.onNext(this.value);
            if (get() != 2) {
                cVar.onComplete();
            }
        }
    }

    @Override // g.a.y0.c.k
    public int requestFusion(int i2) {
        return i2 & 1;
    }

    @Override // g.a.y0.c.o
    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
