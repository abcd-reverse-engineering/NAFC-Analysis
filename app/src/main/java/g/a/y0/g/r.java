package g.a.y0.g;

import g.a.j0;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TrampolineScheduler.java */
/* loaded from: classes2.dex */
public final class r extends j0 {

    /* renamed from: b, reason: collision with root package name */
    private static final r f15991b = new r();

    /* compiled from: TrampolineScheduler.java */
    static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f15992a;

        /* renamed from: b, reason: collision with root package name */
        private final c f15993b;

        /* renamed from: c, reason: collision with root package name */
        private final long f15994c;

        a(Runnable runnable, c cVar, long j2) {
            this.f15992a = runnable;
            this.f15993b = cVar;
            this.f15994c = j2;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            if (this.f15993b.f16002d) {
                return;
            }
            long jA = this.f15993b.a(TimeUnit.MILLISECONDS);
            long j2 = this.f15994c;
            if (j2 > jA) {
                long j3 = j2 - jA;
                if (j3 > 0) {
                    try {
                        Thread.sleep(j3);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        g.a.c1.a.b(e2);
                        return;
                    }
                }
            }
            if (this.f15993b.f16002d) {
                return;
            }
            this.f15992a.run();
        }
    }

    /* compiled from: TrampolineScheduler.java */
    static final class b implements Comparable<b> {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f15995a;

        /* renamed from: b, reason: collision with root package name */
        final long f15996b;

        /* renamed from: c, reason: collision with root package name */
        final int f15997c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f15998d;

        b(Runnable runnable, Long l2, int i2) {
            this.f15995a = runnable;
            this.f15996b = l2.longValue();
            this.f15997c = i2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iA = g.a.y0.b.b.a(this.f15996b, bVar.f15996b);
            return iA == 0 ? g.a.y0.b.b.a(this.f15997c, bVar.f15997c) : iA;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    static final class c extends j0.c implements g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final PriorityBlockingQueue<b> f15999a = new PriorityBlockingQueue<>();

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f16000b = new AtomicInteger();

        /* renamed from: c, reason: collision with root package name */
        final AtomicInteger f16001c = new AtomicInteger();

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f16002d;

        /* compiled from: TrampolineScheduler.java */
        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final b f16003a;

            a(b bVar) {
                this.f16003a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = this.f16003a;
                bVar.f15998d = true;
                c.this.f15999a.remove(bVar);
            }
        }

        c() {
        }

        @Override // g.a.j0.c
        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f16002d = true;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f16002d;
        }

        @Override // g.a.j0.c
        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, @g.a.t0.f TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j2);
            return a(new a(runnable, this, jA), jA);
        }

        g.a.u0.c a(Runnable runnable, long j2) {
            if (this.f16002d) {
                return g.a.y0.a.e.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j2), this.f16001c.incrementAndGet());
            this.f15999a.add(bVar);
            if (this.f16000b.getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f16002d) {
                    b bVarPoll = this.f15999a.poll();
                    if (bVarPoll == null) {
                        iAddAndGet = this.f16000b.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return g.a.y0.a.e.INSTANCE;
                        }
                    } else if (!bVarPoll.f15998d) {
                        bVarPoll.f15995a.run();
                    }
                }
                this.f15999a.clear();
                return g.a.y0.a.e.INSTANCE;
            }
            return g.a.u0.d.a(new a(bVar));
        }
    }

    r() {
    }

    public static r e() {
        return f15991b;
    }

    @Override // g.a.j0
    @g.a.t0.f
    public j0.c a() {
        return new c();
    }

    @Override // g.a.j0
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable) {
        runnable.run();
        return g.a.y0.a.e.INSTANCE;
    }

    @Override // g.a.j0
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, TimeUnit timeUnit) throws InterruptedException {
        try {
            timeUnit.sleep(j2);
            runnable.run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            g.a.c1.a.b(e2);
        }
        return g.a.y0.a.e.INSTANCE;
    }
}
