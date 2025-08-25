package g.a.y0.g;

import g.a.j0;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: NewThreadWorker.java */
/* loaded from: classes2.dex */
public class i extends j0.c implements g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f15961a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f15962b;

    public i(ThreadFactory threadFactory) {
        this.f15961a = o.a(threadFactory);
    }

    @Override // g.a.j0.c
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable) {
        return a(runnable, 0L, null);
    }

    public g.a.u0.c b(Runnable runnable, long j2, TimeUnit timeUnit) {
        m mVar = new m(g.a.c1.a.a(runnable));
        try {
            mVar.setFuture(j2 <= 0 ? this.f15961a.submit(mVar) : this.f15961a.schedule(mVar, j2, timeUnit));
            return mVar;
        } catch (RejectedExecutionException e2) {
            g.a.c1.a.b(e2);
            return g.a.y0.a.e.INSTANCE;
        }
    }

    @Override // g.a.u0.c
    public void dispose() {
        if (this.f15962b) {
            return;
        }
        this.f15962b = true;
        this.f15961a.shutdownNow();
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return this.f15962b;
    }

    @Override // g.a.j0.c
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, @g.a.t0.f TimeUnit timeUnit) {
        return this.f15962b ? g.a.y0.a.e.INSTANCE : a(runnable, j2, timeUnit, (g.a.y0.a.c) null);
    }

    @g.a.t0.f
    public n a(Runnable runnable, long j2, @g.a.t0.f TimeUnit timeUnit, @g.a.t0.g g.a.y0.a.c cVar) {
        Future<?> futureSchedule;
        n nVar = new n(g.a.c1.a.a(runnable), cVar);
        if (cVar != null && !cVar.b(nVar)) {
            return nVar;
        }
        try {
            if (j2 <= 0) {
                futureSchedule = this.f15961a.submit((Callable) nVar);
            } else {
                futureSchedule = this.f15961a.schedule((Callable) nVar, j2, timeUnit);
            }
            nVar.setFuture(futureSchedule);
        } catch (RejectedExecutionException e2) {
            if (cVar != null) {
                cVar.a(nVar);
            }
            g.a.c1.a.b(e2);
        }
        return nVar;
    }

    public g.a.u0.c b(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future<?> futureSchedule;
        Runnable runnableA = g.a.c1.a.a(runnable);
        if (j3 <= 0) {
            f fVar = new f(runnableA, this.f15961a);
            try {
                if (j2 <= 0) {
                    futureSchedule = this.f15961a.submit(fVar);
                } else {
                    futureSchedule = this.f15961a.schedule(fVar, j2, timeUnit);
                }
                fVar.a(futureSchedule);
                return fVar;
            } catch (RejectedExecutionException e2) {
                g.a.c1.a.b(e2);
                return g.a.y0.a.e.INSTANCE;
            }
        }
        l lVar = new l(runnableA);
        try {
            lVar.setFuture(this.f15961a.scheduleAtFixedRate(lVar, j2, j3, timeUnit));
            return lVar;
        } catch (RejectedExecutionException e3) {
            g.a.c1.a.b(e3);
            return g.a.y0.a.e.INSTANCE;
        }
    }

    public void a() {
        if (this.f15962b) {
            return;
        }
        this.f15962b = true;
        this.f15961a.shutdown();
    }
}
