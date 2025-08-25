package g.a.y0.g;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: ScheduledRunnable.java */
/* loaded from: classes2.dex */
public final class n extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, g.a.u0.c {
    static final int FUTURE_INDEX = 1;
    static final int PARENT_INDEX = 0;
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;
    static final Object PARENT_DISPOSED = new Object();
    static final Object SYNC_DISPOSED = new Object();
    static final Object ASYNC_DISPOSED = new Object();
    static final Object DONE = new Object();

    public n(Runnable runnable, g.a.y0.a.c cVar) {
        super(3);
        this.actual = runnable;
        lazySet(0, cVar);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // g.a.u0.c
    public void dispose() {
        Object obj;
        Object obj2;
        while (true) {
            Object obj3 = get(1);
            if (obj3 == DONE || obj3 == SYNC_DISPOSED || obj3 == ASYNC_DISPOSED) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (compareAndSet(1, obj3, z ? ASYNC_DISPOSED : SYNC_DISPOSED)) {
                if (obj3 != null) {
                    ((Future) obj3).cancel(z);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == DONE || obj == (obj2 = PARENT_DISPOSED) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((g.a.y0.a.c) obj).c(this);
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        Object obj = get(0);
        return obj == PARENT_DISPOSED || obj == DONE;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean zCompareAndSet;
        Object obj4;
        Object obj5;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        } finally {
            try {
                lazySet(2, null);
                obj4 = get(0);
                if (obj4 != PARENT_DISPOSED) {
                    ((g.a.y0.a.c) obj4).c(this);
                }
                do {
                    obj5 = get(1);
                    if (obj5 != SYNC_DISPOSED) {
                        return;
                    } else {
                        return;
                    }
                } while (!compareAndSet(1, obj5, DONE));
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!zCompareAndSet);
            }
        }
        lazySet(2, null);
        obj4 = get(0);
        if (obj4 != PARENT_DISPOSED && compareAndSet(0, obj4, DONE) && obj4 != null) {
            ((g.a.y0.a.c) obj4).c(this);
        }
        do {
            obj5 = get(1);
            if (obj5 != SYNC_DISPOSED || obj5 == ASYNC_DISPOSED) {
                return;
            }
        } while (!compareAndSet(1, obj5, DONE));
    }

    public void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == DONE) {
                return;
            }
            if (obj == SYNC_DISPOSED) {
                future.cancel(false);
                return;
            } else if (obj == ASYNC_DISPOSED) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }
}
