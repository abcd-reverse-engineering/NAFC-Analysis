package g.a.y0.g;

import g.a.j0;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ComputationScheduler.java */
/* loaded from: classes2.dex */
public final class b extends j0 {

    /* renamed from: d, reason: collision with root package name */
    static final C0230b f15896d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f15897e = "RxComputationThreadPool";

    /* renamed from: f, reason: collision with root package name */
    static final k f15898f;

    /* renamed from: g, reason: collision with root package name */
    static final String f15899g = "rx2.computation-threads";

    /* renamed from: h, reason: collision with root package name */
    static final int f15900h = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger(f15899g, 0).intValue());

    /* renamed from: i, reason: collision with root package name */
    static final c f15901i = new c(new k("RxComputationShutdown"));

    /* renamed from: j, reason: collision with root package name */
    private static final String f15902j = "rx2.computation-priority";

    /* renamed from: b, reason: collision with root package name */
    final ThreadFactory f15903b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<C0230b> f15904c;

    /* compiled from: ComputationScheduler.java */
    /* renamed from: g.a.y0.g.b$b, reason: collision with other inner class name */
    static final class C0230b {

        /* renamed from: a, reason: collision with root package name */
        final int f15910a;

        /* renamed from: b, reason: collision with root package name */
        final c[] f15911b;

        /* renamed from: c, reason: collision with root package name */
        long f15912c;

        C0230b(int i2, ThreadFactory threadFactory) {
            this.f15910a = i2;
            this.f15911b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f15911b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.f15910a;
            if (i2 == 0) {
                return b.f15901i;
            }
            c[] cVarArr = this.f15911b;
            long j2 = this.f15912c;
            this.f15912c = 1 + j2;
            return cVarArr[(int) (j2 % i2)];
        }

        public void b() {
            for (c cVar : this.f15911b) {
                cVar.dispose();
            }
        }
    }

    /* compiled from: ComputationScheduler.java */
    static final class c extends i {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        f15901i.dispose();
        f15898f = new k(f15897e, Math.max(1, Math.min(10, Integer.getInteger(f15902j, 5).intValue())), true);
        f15896d = new C0230b(0, f15898f);
        f15896d.b();
    }

    public b() {
        this(f15898f);
    }

    static int a(int i2, int i3) {
        return (i3 <= 0 || i3 > i2) ? i2 : i3;
    }

    @Override // g.a.j0
    @g.a.t0.f
    public j0.c a() {
        return new a(this.f15904c.get().a());
    }

    @Override // g.a.j0
    public void b() {
        C0230b c0230b;
        C0230b c0230b2;
        do {
            c0230b = this.f15904c.get();
            c0230b2 = f15896d;
            if (c0230b == c0230b2) {
                return;
            }
        } while (!this.f15904c.compareAndSet(c0230b, c0230b2));
        c0230b.b();
    }

    @Override // g.a.j0
    public void c() {
        C0230b c0230b = new C0230b(f15900h, this.f15903b);
        if (this.f15904c.compareAndSet(f15896d, c0230b)) {
            return;
        }
        c0230b.b();
    }

    public b(ThreadFactory threadFactory) {
        this.f15903b = threadFactory;
        this.f15904c = new AtomicReference<>(f15896d);
        c();
    }

    @Override // g.a.j0
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, TimeUnit timeUnit) {
        return this.f15904c.get().a().b(runnable, j2, timeUnit);
    }

    /* compiled from: ComputationScheduler.java */
    static final class a extends j0.c {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.y0.a.i f15905a = new g.a.y0.a.i();

        /* renamed from: b, reason: collision with root package name */
        private final g.a.u0.b f15906b = new g.a.u0.b();

        /* renamed from: c, reason: collision with root package name */
        private final g.a.y0.a.i f15907c = new g.a.y0.a.i();

        /* renamed from: d, reason: collision with root package name */
        private final c f15908d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f15909e;

        a(c cVar) {
            this.f15908d = cVar;
            this.f15907c.b(this.f15905a);
            this.f15907c.b(this.f15906b);
        }

        @Override // g.a.j0.c
        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable) {
            return this.f15909e ? g.a.y0.a.e.INSTANCE : this.f15908d.a(runnable, 0L, TimeUnit.MILLISECONDS, this.f15905a);
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.f15909e) {
                return;
            }
            this.f15909e = true;
            this.f15907c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15909e;
        }

        @Override // g.a.j0.c
        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, @g.a.t0.f TimeUnit timeUnit) {
            if (this.f15909e) {
                return g.a.y0.a.e.INSTANCE;
            }
            return this.f15908d.a(runnable, j2, timeUnit, this.f15906b);
        }
    }

    @Override // g.a.j0
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return this.f15904c.get().a().b(runnable, j2, j3, timeUnit);
    }
}
