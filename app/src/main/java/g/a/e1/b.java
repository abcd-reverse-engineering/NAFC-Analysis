package g.a.e1;

import g.a.j0;
import g.a.t0.f;
import g.a.u0.d;
import g.a.y0.a.e;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: TestScheduler.java */
/* loaded from: classes2.dex */
public final class b extends j0 {

    /* renamed from: b, reason: collision with root package name */
    final Queue<C0174b> f13737b = new PriorityBlockingQueue(11);

    /* renamed from: c, reason: collision with root package name */
    long f13738c;

    /* renamed from: d, reason: collision with root package name */
    volatile long f13739d;

    /* compiled from: TestScheduler.java */
    /* renamed from: g.a.e1.b$b, reason: collision with other inner class name */
    static final class C0174b implements Comparable<C0174b> {

        /* renamed from: a, reason: collision with root package name */
        final long f13744a;

        /* renamed from: b, reason: collision with root package name */
        final Runnable f13745b;

        /* renamed from: c, reason: collision with root package name */
        final a f13746c;

        /* renamed from: d, reason: collision with root package name */
        final long f13747d;

        C0174b(a aVar, long j2, Runnable runnable, long j3) {
            this.f13744a = j2;
            this.f13745b = runnable;
            this.f13746c = aVar;
            this.f13747d = j3;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(C0174b c0174b) {
            long j2 = this.f13744a;
            long j3 = c0174b.f13744a;
            return j2 == j3 ? g.a.y0.b.b.a(this.f13747d, c0174b.f13747d) : g.a.y0.b.b.a(j2, j3);
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.f13744a), this.f13745b.toString());
        }
    }

    @Override // g.a.j0
    public long a(@f TimeUnit timeUnit) {
        return timeUnit.convert(this.f13739d, TimeUnit.NANOSECONDS);
    }

    public void b(long j2, TimeUnit timeUnit) {
        a(timeUnit.toNanos(j2));
    }

    public void e() {
        a(this.f13739d);
    }

    public void a(long j2, TimeUnit timeUnit) {
        b(this.f13739d + timeUnit.toNanos(j2), TimeUnit.NANOSECONDS);
    }

    private void a(long j2) {
        while (true) {
            C0174b c0174bPeek = this.f13737b.peek();
            if (c0174bPeek == null) {
                break;
            }
            long j3 = c0174bPeek.f13744a;
            if (j3 > j2) {
                break;
            }
            if (j3 == 0) {
                j3 = this.f13739d;
            }
            this.f13739d = j3;
            this.f13737b.remove(c0174bPeek);
            if (!c0174bPeek.f13746c.f13740a) {
                c0174bPeek.f13745b.run();
            }
        }
        this.f13739d = j2;
    }

    /* compiled from: TestScheduler.java */
    final class a extends j0.c {

        /* renamed from: a, reason: collision with root package name */
        volatile boolean f13740a;

        /* compiled from: TestScheduler.java */
        /* renamed from: g.a.e1.b$a$a, reason: collision with other inner class name */
        final class RunnableC0173a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final C0174b f13742a;

            RunnableC0173a(C0174b c0174b) {
                this.f13742a = c0174b;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f13737b.remove(this.f13742a);
            }
        }

        a() {
        }

        @Override // g.a.j0.c
        @f
        public g.a.u0.c a(@f Runnable runnable, long j2, @f TimeUnit timeUnit) {
            if (this.f13740a) {
                return e.INSTANCE;
            }
            long nanos = b.this.f13739d + timeUnit.toNanos(j2);
            b bVar = b.this;
            long j3 = bVar.f13738c;
            bVar.f13738c = 1 + j3;
            C0174b c0174b = new C0174b(this, nanos, runnable, j3);
            b.this.f13737b.add(c0174b);
            return d.a(new RunnableC0173a(c0174b));
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f13740a = true;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f13740a;
        }

        @Override // g.a.j0.c
        @f
        public g.a.u0.c a(@f Runnable runnable) {
            if (this.f13740a) {
                return e.INSTANCE;
            }
            b bVar = b.this;
            long j2 = bVar.f13738c;
            bVar.f13738c = 1 + j2;
            C0174b c0174b = new C0174b(this, 0L, runnable, j2);
            b.this.f13737b.add(c0174b);
            return d.a(new RunnableC0173a(c0174b));
        }

        @Override // g.a.j0.c
        public long a(@f TimeUnit timeUnit) {
            return b.this.a(timeUnit);
        }
    }

    @Override // g.a.j0
    @f
    public j0.c a() {
        return new a();
    }
}
