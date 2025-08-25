package anet.channel.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class a extends ThreadPoolExecutor {
    public a(int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i2, i3, j2, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C0016a(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0016a(callable);
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.thread.a$a, reason: collision with other inner class name */
    class C0016a<V> extends FutureTask<V> implements Comparable<C0016a<V>> {

        /* renamed from: b, reason: collision with root package name */
        private Object f2042b;

        public C0016a(Callable<V> callable) {
            super(callable);
            this.f2042b = callable;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(C0016a<V> c0016a) {
            if (this == c0016a) {
                return 0;
            }
            if (c0016a == null) {
                return -1;
            }
            Object obj = this.f2042b;
            if (obj != null && c0016a.f2042b != null && obj.getClass().equals(c0016a.f2042b.getClass())) {
                Object obj2 = this.f2042b;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(c0016a.f2042b);
                }
            }
            return 0;
        }

        public C0016a(Runnable runnable, V v) {
            super(runnable, v);
            this.f2042b = runnable;
        }
    }
}
