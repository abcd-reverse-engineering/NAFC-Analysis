package g.a.y0.g;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: InstantPeriodicTask.java */
/* loaded from: classes2.dex */
final class f implements Callable<Void>, g.a.u0.c {

    /* renamed from: f, reason: collision with root package name */
    static final FutureTask<Void> f15929f = new FutureTask<>(g.a.y0.b.a.f13898b, null);

    /* renamed from: a, reason: collision with root package name */
    final Runnable f15930a;

    /* renamed from: d, reason: collision with root package name */
    final ExecutorService f15933d;

    /* renamed from: e, reason: collision with root package name */
    Thread f15934e;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<Future<?>> f15932c = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<Future<?>> f15931b = new AtomicReference<>();

    f(Runnable runnable, ExecutorService executorService) {
        this.f15930a = runnable;
        this.f15933d = executorService;
    }

    void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f15932c.get();
            if (future2 == f15929f) {
                future.cancel(this.f15934e != Thread.currentThread());
            }
        } while (!this.f15932c.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f15931b.get();
            if (future2 == f15929f) {
                future.cancel(this.f15934e != Thread.currentThread());
            }
        } while (!this.f15931b.compareAndSet(future2, future));
    }

    @Override // g.a.u0.c
    public void dispose() {
        Future<?> andSet = this.f15932c.getAndSet(f15929f);
        if (andSet != null && andSet != f15929f) {
            andSet.cancel(this.f15934e != Thread.currentThread());
        }
        Future<?> andSet2 = this.f15931b.getAndSet(f15929f);
        if (andSet2 == null || andSet2 == f15929f) {
            return;
        }
        andSet2.cancel(this.f15934e != Thread.currentThread());
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return this.f15932c.get() == f15929f;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.f15934e = Thread.currentThread();
            try {
                this.f15930a.run();
                b(this.f15933d.submit(this));
            } catch (Throwable th) {
                g.a.c1.a.b(th);
            }
            return null;
        } finally {
            this.f15934e = null;
        }
    }
}
