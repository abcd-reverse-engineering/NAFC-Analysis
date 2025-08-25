package g.a.y0.g;

import g.a.j0;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleScheduler.java */
/* loaded from: classes2.dex */
public final class q extends j0 {

    /* renamed from: d, reason: collision with root package name */
    private static final String f15982d = "rx2.single-priority";

    /* renamed from: e, reason: collision with root package name */
    private static final String f15983e = "RxSingleScheduler";

    /* renamed from: f, reason: collision with root package name */
    static final k f15984f;

    /* renamed from: g, reason: collision with root package name */
    static final ScheduledExecutorService f15985g = Executors.newScheduledThreadPool(0);

    /* renamed from: b, reason: collision with root package name */
    final ThreadFactory f15986b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f15987c;

    /* compiled from: SingleScheduler.java */
    static final class a extends j0.c {

        /* renamed from: a, reason: collision with root package name */
        final ScheduledExecutorService f15988a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.u0.b f15989b = new g.a.u0.b();

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f15990c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f15988a = scheduledExecutorService;
        }

        @Override // g.a.j0.c
        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, @g.a.t0.f TimeUnit timeUnit) {
            if (this.f15990c) {
                return g.a.y0.a.e.INSTANCE;
            }
            n nVar = new n(g.a.c1.a.a(runnable), this.f15989b);
            this.f15989b.b(nVar);
            try {
                nVar.setFuture(j2 <= 0 ? this.f15988a.submit((Callable) nVar) : this.f15988a.schedule((Callable) nVar, j2, timeUnit));
                return nVar;
            } catch (RejectedExecutionException e2) {
                dispose();
                g.a.c1.a.b(e2);
                return g.a.y0.a.e.INSTANCE;
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.f15990c) {
                return;
            }
            this.f15990c = true;
            this.f15989b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15990c;
        }
    }

    static {
        f15985g.shutdown();
        f15984f = new k(f15983e, Math.max(1, Math.min(10, Integer.getInteger(f15982d, 5).intValue())), true);
    }

    public q() {
        this(f15984f);
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return o.a(threadFactory);
    }

    @Override // g.a.j0
    public void b() {
        ScheduledExecutorService andSet;
        ScheduledExecutorService scheduledExecutorService = this.f15987c.get();
        ScheduledExecutorService scheduledExecutorService2 = f15985g;
        if (scheduledExecutorService == scheduledExecutorService2 || (andSet = this.f15987c.getAndSet(scheduledExecutorService2)) == f15985g) {
            return;
        }
        andSet.shutdownNow();
    }

    @Override // g.a.j0
    public void c() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorServiceA = null;
        do {
            scheduledExecutorService = this.f15987c.get();
            if (scheduledExecutorService != f15985g) {
                if (scheduledExecutorServiceA != null) {
                    scheduledExecutorServiceA.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorServiceA == null) {
                scheduledExecutorServiceA = a(this.f15986b);
            }
        } while (!this.f15987c.compareAndSet(scheduledExecutorService, scheduledExecutorServiceA));
    }

    public q(ThreadFactory threadFactory) {
        this.f15987c = new AtomicReference<>();
        this.f15986b = threadFactory;
        this.f15987c.lazySet(a(threadFactory));
    }

    @Override // g.a.j0
    @g.a.t0.f
    public j0.c a() {
        return new a(this.f15987c.get());
    }

    @Override // g.a.j0
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, TimeUnit timeUnit) {
        Future<?> futureSchedule;
        m mVar = new m(g.a.c1.a.a(runnable));
        try {
            if (j2 <= 0) {
                futureSchedule = this.f15987c.get().submit(mVar);
            } else {
                futureSchedule = this.f15987c.get().schedule(mVar, j2, timeUnit);
            }
            mVar.setFuture(futureSchedule);
            return mVar;
        } catch (RejectedExecutionException e2) {
            g.a.c1.a.b(e2);
            return g.a.y0.a.e.INSTANCE;
        }
    }

    @Override // g.a.j0
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future<?> futureSchedule;
        Runnable runnableA = g.a.c1.a.a(runnable);
        if (j3 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f15987c.get();
            f fVar = new f(runnableA, scheduledExecutorService);
            try {
                if (j2 <= 0) {
                    futureSchedule = scheduledExecutorService.submit(fVar);
                } else {
                    futureSchedule = scheduledExecutorService.schedule(fVar, j2, timeUnit);
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
            lVar.setFuture(this.f15987c.get().scheduleAtFixedRate(lVar, j2, j3, timeUnit));
            return lVar;
        } catch (RejectedExecutionException e3) {
            g.a.c1.a.b(e3);
            return g.a.y0.a.e.INSTANCE;
        }
    }
}
