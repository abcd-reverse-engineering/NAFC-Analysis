package g.a;

import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler.java */
/* loaded from: classes2.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    static final long f13834a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: Scheduler.java */
    static final class a implements Runnable, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f13835a;

        /* renamed from: b, reason: collision with root package name */
        final c f13836b;

        /* renamed from: c, reason: collision with root package name */
        Thread f13837c;

        a(Runnable runnable, c cVar) {
            this.f13835a = runnable;
            this.f13836b = cVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.f13837c == Thread.currentThread()) {
                c cVar = this.f13836b;
                if (cVar instanceof g.a.y0.g.i) {
                    ((g.a.y0.g.i) cVar).a();
                    return;
                }
            }
            this.f13836b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f13836b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13837c = Thread.currentThread();
            try {
                this.f13835a.run();
            } finally {
                dispose();
                this.f13837c = null;
            }
        }
    }

    /* compiled from: Scheduler.java */
    static class b implements Runnable, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f13838a;

        /* renamed from: b, reason: collision with root package name */
        @g.a.t0.f
        final c f13839b;

        /* renamed from: c, reason: collision with root package name */
        @g.a.t0.f
        volatile boolean f13840c;

        b(@g.a.t0.f Runnable runnable, @g.a.t0.f c cVar) {
            this.f13838a = runnable;
            this.f13839b = cVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f13840c = true;
            this.f13839b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f13840c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13840c) {
                return;
            }
            try {
                this.f13838a.run();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f13839b.dispose();
                throw g.a.y0.j.k.c(th);
            }
        }
    }

    /* compiled from: Scheduler.java */
    public static abstract class c implements g.a.u0.c {

        /* compiled from: Scheduler.java */
        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            @g.a.t0.f
            final Runnable f13841a;

            /* renamed from: b, reason: collision with root package name */
            @g.a.t0.f
            final g.a.y0.a.k f13842b;

            /* renamed from: c, reason: collision with root package name */
            final long f13843c;

            /* renamed from: d, reason: collision with root package name */
            long f13844d;

            /* renamed from: e, reason: collision with root package name */
            long f13845e;

            /* renamed from: f, reason: collision with root package name */
            long f13846f;

            a(long j2, @g.a.t0.f Runnable runnable, long j3, @g.a.t0.f g.a.y0.a.k kVar, long j4) {
                this.f13841a = runnable;
                this.f13842b = kVar;
                this.f13843c = j4;
                this.f13845e = j3;
                this.f13846f = j2;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r11 = this;
                    java.lang.Runnable r0 = r11.f13841a
                    r0.run()
                    g.a.y0.a.k r0 = r11.f13842b
                    boolean r0 = r0.isDisposed()
                    if (r0 != 0) goto L55
                    g.a.j0$c r0 = g.a.j0.c.this
                    java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
                    long r0 = r0.a(r1)
                    long r2 = g.a.j0.f13834a
                    long r4 = r0 + r2
                    long r6 = r11.f13845e
                    r8 = 1
                    int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r10 < 0) goto L35
                    long r4 = r11.f13843c
                    long r6 = r6 + r4
                    long r6 = r6 + r2
                    int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                    if (r2 < 0) goto L2a
                    goto L35
                L2a:
                    long r2 = r11.f13846f
                    long r6 = r11.f13844d
                    long r6 = r6 + r8
                    r11.f13844d = r6
                    long r6 = r6 * r4
                    long r2 = r2 + r6
                    goto L45
                L35:
                    long r2 = r11.f13843c
                    long r4 = r0 + r2
                    long r6 = r11.f13844d
                    long r6 = r6 + r8
                    r11.f13844d = r6
                    long r2 = r2 * r6
                    long r2 = r4 - r2
                    r11.f13846f = r2
                    r2 = r4
                L45:
                    r11.f13845e = r0
                    long r2 = r2 - r0
                    g.a.y0.a.k r0 = r11.f13842b
                    g.a.j0$c r1 = g.a.j0.c.this
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS
                    g.a.u0.c r1 = r1.a(r11, r2, r4)
                    r0.replace(r1)
                L55:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: g.a.j0.c.a.run():void");
            }
        }

        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable) {
            return a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        @g.a.t0.f
        public abstract g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, @g.a.t0.f TimeUnit timeUnit);

        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, long j3, @g.a.t0.f TimeUnit timeUnit) {
            g.a.y0.a.k kVar = new g.a.y0.a.k();
            g.a.y0.a.k kVar2 = new g.a.y0.a.k(kVar);
            Runnable runnableA = g.a.c1.a.a(runnable);
            long nanos = timeUnit.toNanos(j3);
            long jA = a(TimeUnit.NANOSECONDS);
            g.a.u0.c cVarA = a(new a(jA + timeUnit.toNanos(j2), runnableA, jA, kVar2, nanos), j2, timeUnit);
            if (cVarA == g.a.y0.a.e.INSTANCE) {
                return cVarA;
            }
            kVar.replace(cVarA);
            return kVar2;
        }

        public long a(@g.a.t0.f TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public static long d() {
        return f13834a;
    }

    public long a(@g.a.t0.f TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @g.a.t0.f
    public abstract c a();

    public void b() {
    }

    public void c() {
    }

    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable) {
        return a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, @g.a.t0.f TimeUnit timeUnit) {
        c cVarA = a();
        a aVar = new a(g.a.c1.a.a(runnable), cVarA);
        cVarA.a(aVar, j2, timeUnit);
        return aVar;
    }

    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, long j3, @g.a.t0.f TimeUnit timeUnit) {
        c cVarA = a();
        b bVar = new b(g.a.c1.a.a(runnable), cVarA);
        g.a.u0.c cVarA2 = cVarA.a(bVar, j2, j3, timeUnit);
        return cVarA2 == g.a.y0.a.e.INSTANCE ? cVarA2 : bVar;
    }

    @g.a.t0.f
    public <S extends j0 & g.a.u0.c> S a(@g.a.t0.f g.a.x0.o<l<l<g.a.c>>, g.a.c> oVar) {
        return new g.a.y0.g.p(oVar, this);
    }
}
