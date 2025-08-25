package g.a.y0.g;

import g.a.j0;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: IoScheduler.java */
/* loaded from: classes2.dex */
public final class g extends j0 {

    /* renamed from: d, reason: collision with root package name */
    private static final String f15935d = "RxCachedThreadScheduler";

    /* renamed from: e, reason: collision with root package name */
    static final k f15936e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f15937f = "RxCachedWorkerPoolEvictor";

    /* renamed from: g, reason: collision with root package name */
    static final k f15938g;

    /* renamed from: h, reason: collision with root package name */
    private static final long f15939h = 60;

    /* renamed from: i, reason: collision with root package name */
    private static final TimeUnit f15940i = TimeUnit.SECONDS;

    /* renamed from: j, reason: collision with root package name */
    static final c f15941j = new c(new k("RxCachedThreadSchedulerShutdown"));

    /* renamed from: k, reason: collision with root package name */
    private static final String f15942k = "rx2.io-priority";

    /* renamed from: l, reason: collision with root package name */
    static final a f15943l;

    /* renamed from: b, reason: collision with root package name */
    final ThreadFactory f15944b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<a> f15945c;

    /* compiled from: IoScheduler.java */
    static final class b extends j0.c {

        /* renamed from: b, reason: collision with root package name */
        private final a f15953b;

        /* renamed from: c, reason: collision with root package name */
        private final c f15954c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicBoolean f15955d = new AtomicBoolean();

        /* renamed from: a, reason: collision with root package name */
        private final g.a.u0.b f15952a = new g.a.u0.b();

        b(a aVar) {
            this.f15953b = aVar;
            this.f15954c = aVar.b();
        }

        @Override // g.a.j0.c
        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, @g.a.t0.f TimeUnit timeUnit) {
            return this.f15952a.isDisposed() ? g.a.y0.a.e.INSTANCE : this.f15954c.a(runnable, j2, timeUnit, this.f15952a);
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.f15955d.compareAndSet(false, true)) {
                this.f15952a.dispose();
                this.f15953b.a(this.f15954c);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15955d.get();
        }
    }

    /* compiled from: IoScheduler.java */
    static final class c extends i {

        /* renamed from: c, reason: collision with root package name */
        private long f15956c;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f15956c = 0L;
        }

        public void a(long j2) {
            this.f15956c = j2;
        }

        public long b() {
            return this.f15956c;
        }
    }

    static {
        f15941j.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger(f15942k, 5).intValue()));
        f15936e = new k(f15935d, iMax);
        f15938g = new k(f15937f, iMax);
        f15943l = new a(0L, null, f15936e);
        f15943l.d();
    }

    public g() {
        this(f15936e);
    }

    @Override // g.a.j0
    @g.a.t0.f
    public j0.c a() {
        return new b(this.f15945c.get());
    }

    @Override // g.a.j0
    public void b() {
        a aVar;
        a aVar2;
        do {
            aVar = this.f15945c.get();
            aVar2 = f15943l;
            if (aVar == aVar2) {
                return;
            }
        } while (!this.f15945c.compareAndSet(aVar, aVar2));
        aVar.d();
    }

    @Override // g.a.j0
    public void c() {
        a aVar = new a(f15939h, f15940i, this.f15944b);
        if (this.f15945c.compareAndSet(f15943l, aVar)) {
            return;
        }
        aVar.d();
    }

    public int e() {
        return this.f15945c.get().f15948c.b();
    }

    /* compiled from: IoScheduler.java */
    static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final long f15946a;

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f15947b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.u0.b f15948c;

        /* renamed from: d, reason: collision with root package name */
        private final ScheduledExecutorService f15949d;

        /* renamed from: e, reason: collision with root package name */
        private final Future<?> f15950e;

        /* renamed from: f, reason: collision with root package name */
        private final ThreadFactory f15951f;

        a(long j2, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            this.f15946a = timeUnit != null ? timeUnit.toNanos(j2) : 0L;
            this.f15947b = new ConcurrentLinkedQueue<>();
            this.f15948c = new g.a.u0.b();
            this.f15951f = threadFactory;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, g.f15938g);
                long j3 = this.f15946a;
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(this, j3, j3, TimeUnit.NANOSECONDS);
            } else {
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.f15949d = scheduledExecutorServiceNewScheduledThreadPool;
            this.f15950e = scheduledFutureScheduleWithFixedDelay;
        }

        void a(c cVar) {
            cVar.a(c() + this.f15946a);
            this.f15947b.offer(cVar);
        }

        c b() {
            if (this.f15948c.isDisposed()) {
                return g.f15941j;
            }
            while (!this.f15947b.isEmpty()) {
                c cVarPoll = this.f15947b.poll();
                if (cVarPoll != null) {
                    return cVarPoll;
                }
            }
            c cVar = new c(this.f15951f);
            this.f15948c.b(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d() {
            this.f15948c.dispose();
            Future<?> future = this.f15950e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f15949d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        void a() {
            if (this.f15947b.isEmpty()) {
                return;
            }
            long jC = c();
            Iterator<c> it = this.f15947b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.b() > jC) {
                    return;
                }
                if (this.f15947b.remove(next)) {
                    this.f15948c.a(next);
                }
            }
        }
    }

    public g(ThreadFactory threadFactory) {
        this.f15944b = threadFactory;
        this.f15945c = new AtomicReference<>(f15943l);
        c();
    }
}
