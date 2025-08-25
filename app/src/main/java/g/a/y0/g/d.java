package g.a.y0.g;

import g.a.j0;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ExecutorScheduler.java */
/* loaded from: classes2.dex */
public final class d extends j0 {

    /* renamed from: c, reason: collision with root package name */
    static final j0 f15914c = g.a.e1.a.e();

    /* renamed from: b, reason: collision with root package name */
    @g.a.t0.f
    final Executor f15915b;

    /* compiled from: ExecutorScheduler.java */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final b f15916a;

        a(b bVar) {
            this.f15916a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.f15916a;
            bVar.direct.replace(d.this.a(bVar));
        }
    }

    /* compiled from: ExecutorScheduler.java */
    static final class b extends AtomicReference<Runnable> implements Runnable, g.a.u0.c {
        private static final long serialVersionUID = -4101336210206799084L;
        final g.a.y0.a.k direct;
        final g.a.y0.a.k timed;

        b(Runnable runnable) {
            super(runnable);
            this.timed = new g.a.y0.a.k();
            this.direct = new g.a.y0.a.k();
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                } finally {
                    lazySet(null);
                    this.timed.lazySet(g.a.y0.a.d.DISPOSED);
                    this.direct.lazySet(g.a.y0.a.d.DISPOSED);
                }
            }
        }
    }

    public d(@g.a.t0.f Executor executor) {
        this.f15915b = executor;
    }

    @Override // g.a.j0
    @g.a.t0.f
    public j0.c a() {
        return new c(this.f15915b);
    }

    @Override // g.a.j0
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable) {
        Runnable runnableA = g.a.c1.a.a(runnable);
        try {
            if (this.f15915b instanceof ExecutorService) {
                m mVar = new m(runnableA);
                mVar.setFuture(((ExecutorService) this.f15915b).submit(mVar));
                return mVar;
            }
            c.a aVar = new c.a(runnableA);
            this.f15915b.execute(aVar);
            return aVar;
        } catch (RejectedExecutionException e2) {
            g.a.c1.a.b(e2);
            return g.a.y0.a.e.INSTANCE;
        }
    }

    /* compiled from: ExecutorScheduler.java */
    public static final class c extends j0.c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Executor f15918a;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f15920c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicInteger f15921d = new AtomicInteger();

        /* renamed from: e, reason: collision with root package name */
        final g.a.u0.b f15922e = new g.a.u0.b();

        /* renamed from: b, reason: collision with root package name */
        final g.a.y0.f.a<Runnable> f15919b = new g.a.y0.f.a<>();

        /* compiled from: ExecutorScheduler.java */
        static final class a extends AtomicBoolean implements Runnable, g.a.u0.c {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            a(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // g.a.u0.c
            public void dispose() {
                lazySet(true);
            }

            @Override // g.a.u0.c
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.actual.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        /* compiled from: ExecutorScheduler.java */
        final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final g.a.y0.a.k f15923a;

            /* renamed from: b, reason: collision with root package name */
            private final Runnable f15924b;

            b(g.a.y0.a.k kVar, Runnable runnable) {
                this.f15923a = kVar;
                this.f15924b = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f15923a.replace(c.this.a(this.f15924b));
            }
        }

        public c(Executor executor) {
            this.f15918a = executor;
        }

        @Override // g.a.j0.c
        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable) {
            if (this.f15920c) {
                return g.a.y0.a.e.INSTANCE;
            }
            a aVar = new a(g.a.c1.a.a(runnable));
            this.f15919b.offer(aVar);
            if (this.f15921d.getAndIncrement() == 0) {
                try {
                    this.f15918a.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f15920c = true;
                    this.f15919b.clear();
                    g.a.c1.a.b(e2);
                    return g.a.y0.a.e.INSTANCE;
                }
            }
            return aVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.f15920c) {
                return;
            }
            this.f15920c = true;
            this.f15922e.dispose();
            if (this.f15921d.getAndIncrement() == 0) {
                this.f15919b.clear();
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15920c;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.a.y0.f.a<Runnable> aVar = this.f15919b;
            int iAddAndGet = 1;
            while (!this.f15920c) {
                do {
                    Runnable runnablePoll = aVar.poll();
                    if (runnablePoll != null) {
                        runnablePoll.run();
                    } else if (this.f15920c) {
                        aVar.clear();
                        return;
                    } else {
                        iAddAndGet = this.f15921d.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                } while (!this.f15920c);
                aVar.clear();
                return;
            }
            aVar.clear();
        }

        @Override // g.a.j0.c
        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, @g.a.t0.f TimeUnit timeUnit) {
            if (j2 <= 0) {
                return a(runnable);
            }
            if (this.f15920c) {
                return g.a.y0.a.e.INSTANCE;
            }
            g.a.y0.a.k kVar = new g.a.y0.a.k();
            g.a.y0.a.k kVar2 = new g.a.y0.a.k(kVar);
            n nVar = new n(new b(kVar2, g.a.c1.a.a(runnable)), this.f15922e);
            this.f15922e.b(nVar);
            Executor executor = this.f15918a;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    nVar.setFuture(((ScheduledExecutorService) executor).schedule((Callable) nVar, j2, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.f15920c = true;
                    g.a.c1.a.b(e2);
                    return g.a.y0.a.e.INSTANCE;
                }
            } else {
                nVar.setFuture(new g.a.y0.g.c(d.f15914c.a(nVar, j2, timeUnit)));
            }
            kVar.replace(nVar);
            return kVar2;
        }
    }

    @Override // g.a.j0
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, TimeUnit timeUnit) {
        Runnable runnableA = g.a.c1.a.a(runnable);
        if (this.f15915b instanceof ScheduledExecutorService) {
            try {
                m mVar = new m(runnableA);
                mVar.setFuture(((ScheduledExecutorService) this.f15915b).schedule(mVar, j2, timeUnit));
                return mVar;
            } catch (RejectedExecutionException e2) {
                g.a.c1.a.b(e2);
                return g.a.y0.a.e.INSTANCE;
            }
        }
        b bVar = new b(runnableA);
        bVar.timed.replace(f15914c.a(new a(bVar), j2, timeUnit));
        return bVar;
    }

    @Override // g.a.j0
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        if (this.f15915b instanceof ScheduledExecutorService) {
            try {
                l lVar = new l(g.a.c1.a.a(runnable));
                lVar.setFuture(((ScheduledExecutorService) this.f15915b).scheduleAtFixedRate(lVar, j2, j3, timeUnit));
                return lVar;
            } catch (RejectedExecutionException e2) {
                g.a.c1.a.b(e2);
                return g.a.y0.a.e.INSTANCE;
            }
        }
        return super.a(runnable, j2, j3, timeUnit);
    }
}
