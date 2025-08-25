package g.a.d1;

import g.a.l;
import g.a.y0.i.j;
import h.q2.t.m0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: UnicastProcessor.java */
/* loaded from: classes2.dex */
public final class g<T> extends c<T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.y0.f.c<T> f13717b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<Runnable> f13718c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f13719d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f13720e;

    /* renamed from: f, reason: collision with root package name */
    Throwable f13721f;

    /* renamed from: g, reason: collision with root package name */
    final AtomicReference<i.d.c<? super T>> f13722g;

    /* renamed from: h, reason: collision with root package name */
    volatile boolean f13723h;

    /* renamed from: i, reason: collision with root package name */
    final AtomicBoolean f13724i;

    /* renamed from: j, reason: collision with root package name */
    final g.a.y0.i.c<T> f13725j;

    /* renamed from: k, reason: collision with root package name */
    final AtomicLong f13726k;

    /* renamed from: l, reason: collision with root package name */
    boolean f13727l;

    /* compiled from: UnicastProcessor.java */
    final class a extends g.a.y0.i.c<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        a() {
        }

        @Override // i.d.d
        public void cancel() {
            if (g.this.f13723h) {
                return;
            }
            g gVar = g.this;
            gVar.f13723h = true;
            gVar.Y();
            g gVar2 = g.this;
            if (gVar2.f13727l || gVar2.f13725j.getAndIncrement() != 0) {
                return;
            }
            g.this.f13717b.clear();
            g.this.f13722g.lazySet(null);
        }

        @Override // g.a.y0.c.o
        public void clear() {
            g.this.f13717b.clear();
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return g.this.f13717b.isEmpty();
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() {
            return g.this.f13717b.poll();
        }

        @Override // i.d.d
        public void request(long j2) {
            if (j.validate(j2)) {
                g.a.y0.j.d.a(g.this.f13726k, j2);
                g.this.Z();
            }
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            g.this.f13727l = true;
            return 2;
        }
    }

    g(int i2) {
        this(i2, null, true);
    }

    @g.a.t0.d
    public static <T> g<T> a(int i2, Runnable runnable) {
        g.a.y0.b.b.a(runnable, "onTerminate");
        return new g<>(i2, runnable);
    }

    @g.a.t0.d
    public static <T> g<T> a0() {
        return new g<>(l.Q());
    }

    @g.a.t0.e
    @g.a.t0.d
    public static <T> g<T> b(boolean z) {
        return new g<>(l.Q(), null, z);
    }

    @g.a.t0.d
    public static <T> g<T> m(int i2) {
        return new g<>(i2);
    }

    @Override // g.a.d1.c
    public Throwable T() {
        if (this.f13720e) {
            return this.f13721f;
        }
        return null;
    }

    @Override // g.a.d1.c
    public boolean U() {
        return this.f13720e && this.f13721f == null;
    }

    @Override // g.a.d1.c
    public boolean V() {
        return this.f13722g.get() != null;
    }

    @Override // g.a.d1.c
    public boolean W() {
        return this.f13720e && this.f13721f != null;
    }

    void Y() {
        Runnable runnable = this.f13718c.get();
        if (runnable == null || !this.f13718c.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    void Z() {
        if (this.f13725j.getAndIncrement() != 0) {
            return;
        }
        int iAddAndGet = 1;
        i.d.c<? super T> cVar = this.f13722g.get();
        while (cVar == null) {
            iAddAndGet = this.f13725j.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                cVar = this.f13722g.get();
            }
        }
        if (this.f13727l) {
            f((i.d.c) cVar);
        } else {
            g((i.d.c) cVar);
        }
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        if (this.f13724i.get() || !this.f13724i.compareAndSet(false, true)) {
            g.a.y0.i.g.error(new IllegalStateException("This processor allows only a single Subscriber"), cVar);
            return;
        }
        cVar.onSubscribe(this.f13725j);
        this.f13722g.set(cVar);
        if (this.f13723h) {
            this.f13722g.lazySet(null);
        } else {
            Z();
        }
    }

    void f(i.d.c<? super T> cVar) {
        g.a.y0.f.c<T> cVar2 = this.f13717b;
        int iAddAndGet = 1;
        boolean z = !this.f13719d;
        while (!this.f13723h) {
            boolean z2 = this.f13720e;
            if (z && z2 && this.f13721f != null) {
                cVar2.clear();
                this.f13722g.lazySet(null);
                cVar.onError(this.f13721f);
                return;
            }
            cVar.onNext(null);
            if (z2) {
                this.f13722g.lazySet(null);
                Throwable th = this.f13721f;
                if (th != null) {
                    cVar.onError(th);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
            iAddAndGet = this.f13725j.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        cVar2.clear();
        this.f13722g.lazySet(null);
    }

    void g(i.d.c<? super T> cVar) {
        long j2;
        g.a.y0.f.c<T> cVar2 = this.f13717b;
        boolean z = !this.f13719d;
        int iAddAndGet = 1;
        do {
            long j3 = this.f13726k.get();
            long j4 = 0;
            while (true) {
                if (j3 == j4) {
                    j2 = j4;
                    break;
                }
                boolean z2 = this.f13720e;
                T tPoll = cVar2.poll();
                boolean z3 = tPoll == null;
                j2 = j4;
                if (a(z, z2, z3, cVar, cVar2)) {
                    return;
                }
                if (z3) {
                    break;
                }
                cVar.onNext(tPoll);
                j4 = 1 + j2;
            }
            if (j3 == j4 && a(z, this.f13720e, cVar2.isEmpty(), cVar, cVar2)) {
                return;
            }
            if (j2 != 0 && j3 != m0.f16408b) {
                this.f13726k.addAndGet(-j2);
            }
            iAddAndGet = this.f13725j.addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // i.d.c
    public void onComplete() {
        if (this.f13720e || this.f13723h) {
            return;
        }
        this.f13720e = true;
        Y();
        Z();
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        if (this.f13720e || this.f13723h) {
            g.a.c1.a.b(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.f13721f = th;
        this.f13720e = true;
        Y();
        Z();
    }

    @Override // i.d.c
    public void onNext(T t) {
        if (this.f13720e || this.f13723h) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.f13717b.offer(t);
            Z();
        }
    }

    @Override // i.d.c, g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (this.f13720e || this.f13723h) {
            dVar.cancel();
        } else {
            dVar.request(m0.f16408b);
        }
    }

    g(int i2, Runnable runnable) {
        this(i2, runnable, true);
    }

    g(int i2, Runnable runnable, boolean z) {
        this.f13717b = new g.a.y0.f.c<>(g.a.y0.b.b.a(i2, "capacityHint"));
        this.f13718c = new AtomicReference<>(runnable);
        this.f13719d = z;
        this.f13722g = new AtomicReference<>();
        this.f13724i = new AtomicBoolean();
        this.f13725j = new a();
        this.f13726k = new AtomicLong();
    }

    @g.a.t0.e
    @g.a.t0.d
    public static <T> g<T> a(int i2, Runnable runnable, boolean z) {
        g.a.y0.b.b.a(runnable, "onTerminate");
        return new g<>(i2, runnable, z);
    }

    boolean a(boolean z, boolean z2, boolean z3, i.d.c<? super T> cVar, g.a.y0.f.c<T> cVar2) {
        if (this.f13723h) {
            cVar2.clear();
            this.f13722g.lazySet(null);
            return true;
        }
        if (!z2) {
            return false;
        }
        if (z && this.f13721f != null) {
            cVar2.clear();
            this.f13722g.lazySet(null);
            cVar.onError(this.f13721f);
            return true;
        }
        if (!z3) {
            return false;
        }
        Throwable th = this.f13721f;
        this.f13722g.lazySet(null);
        if (th != null) {
            cVar.onError(th);
        } else {
            cVar.onComplete();
        }
        return true;
    }
}
