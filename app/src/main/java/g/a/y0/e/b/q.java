package g.a.y0.e.b;

import g.a.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableBufferTimed.java */
/* loaded from: classes2.dex */
public final class q<T, U extends Collection<? super T>> extends g.a.y0.e.b.a<T, U> {

    /* renamed from: c, reason: collision with root package name */
    final long f14515c;

    /* renamed from: d, reason: collision with root package name */
    final long f14516d;

    /* renamed from: e, reason: collision with root package name */
    final TimeUnit f14517e;

    /* renamed from: f, reason: collision with root package name */
    final g.a.j0 f14518f;

    /* renamed from: g, reason: collision with root package name */
    final Callable<U> f14519g;

    /* renamed from: h, reason: collision with root package name */
    final int f14520h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f14521i;

    /* compiled from: FlowableBufferTimed.java */
    static final class a<T, U extends Collection<? super T>> extends g.a.y0.h.m<T, U, U> implements i.d.d, Runnable, g.a.u0.c {
        final Callable<U> m0;
        final long n0;
        final TimeUnit o0;
        final int p0;
        final boolean q0;
        final j0.c r0;
        U s0;
        g.a.u0.c t0;
        i.d.d u0;
        long v0;
        long w0;

        a(i.d.c<? super U> cVar, Callable<U> callable, long j2, TimeUnit timeUnit, int i2, boolean z, j0.c cVar2) {
            super(cVar, new g.a.y0.f.a());
            this.m0 = callable;
            this.n0 = j2;
            this.o0 = timeUnit;
            this.p0 = i2;
            this.q0 = z;
            this.r0 = cVar2;
        }

        @Override // g.a.y0.h.m, g.a.y0.j.u
        public /* bridge */ /* synthetic */ boolean a(i.d.c cVar, Object obj) {
            return a((i.d.c<? super i.d.c>) cVar, (i.d.c) obj);
        }

        @Override // i.d.d
        public void cancel() {
            if (this.j0) {
                return;
            }
            this.j0 = true;
            dispose();
        }

        @Override // g.a.u0.c
        public void dispose() {
            synchronized (this) {
                this.s0 = null;
            }
            this.u0.cancel();
            this.r0.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.r0.isDisposed();
        }

        @Override // i.d.c
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.s0;
                this.s0 = null;
            }
            this.i0.offer(u);
            this.k0 = true;
            if (b()) {
                g.a.y0.j.v.a((g.a.y0.c.n) this.i0, (i.d.c) this.h0, false, (g.a.u0.c) this, (g.a.y0.j.u) this);
            }
            this.r0.dispose();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            synchronized (this) {
                this.s0 = null;
            }
            this.h0.onError(th);
            this.r0.dispose();
        }

        @Override // i.d.c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.s0;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.p0) {
                    return;
                }
                this.s0 = null;
                this.v0++;
                if (this.q0) {
                    this.t0.dispose();
                }
                b(u, false, this);
                try {
                    U u2 = (U) g.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                    synchronized (this) {
                        this.s0 = u2;
                        this.w0++;
                    }
                    if (this.q0) {
                        j0.c cVar = this.r0;
                        long j2 = this.n0;
                        this.t0 = cVar.a(this, j2, j2, this.o0);
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    cancel();
                    this.h0.onError(th);
                }
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.u0, dVar)) {
                this.u0 = dVar;
                try {
                    this.s0 = (U) g.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                    this.h0.onSubscribe(this);
                    j0.c cVar = this.r0;
                    long j2 = this.n0;
                    this.t0 = cVar.a(this, j2, j2, this.o0);
                    dVar.request(h.q2.t.m0.f16408b);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.r0.dispose();
                    dVar.cancel();
                    g.a.y0.i.g.error(th, this.h0);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            b(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) g.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.s0;
                    if (u2 != null && this.v0 == this.w0) {
                        this.s0 = u;
                        b(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cancel();
                this.h0.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean a(i.d.c<? super U> cVar, U u) {
            cVar.onNext(u);
            return true;
        }
    }

    /* compiled from: FlowableBufferTimed.java */
    static final class b<T, U extends Collection<? super T>> extends g.a.y0.h.m<T, U, U> implements i.d.d, Runnable, g.a.u0.c {
        final Callable<U> m0;
        final long n0;
        final TimeUnit o0;
        final g.a.j0 p0;
        i.d.d q0;
        U r0;
        final AtomicReference<g.a.u0.c> s0;

        b(i.d.c<? super U> cVar, Callable<U> callable, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            super(cVar, new g.a.y0.f.a());
            this.s0 = new AtomicReference<>();
            this.m0 = callable;
            this.n0 = j2;
            this.o0 = timeUnit;
            this.p0 = j0Var;
        }

        @Override // g.a.y0.h.m, g.a.y0.j.u
        public /* bridge */ /* synthetic */ boolean a(i.d.c cVar, Object obj) {
            return a((i.d.c<? super i.d.c>) cVar, (i.d.c) obj);
        }

        @Override // i.d.d
        public void cancel() {
            this.q0.cancel();
            g.a.y0.a.d.dispose(this.s0);
        }

        @Override // g.a.u0.c
        public void dispose() {
            cancel();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.s0.get() == g.a.y0.a.d.DISPOSED;
        }

        @Override // i.d.c
        public void onComplete() {
            g.a.y0.a.d.dispose(this.s0);
            synchronized (this) {
                U u = this.r0;
                if (u == null) {
                    return;
                }
                this.r0 = null;
                this.i0.offer(u);
                this.k0 = true;
                if (b()) {
                    g.a.y0.j.v.a((g.a.y0.c.n) this.i0, (i.d.c) this.h0, false, (g.a.u0.c) this, (g.a.y0.j.u) this);
                }
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            g.a.y0.a.d.dispose(this.s0);
            synchronized (this) {
                this.r0 = null;
            }
            this.h0.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.r0;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.q0, dVar)) {
                this.q0 = dVar;
                try {
                    this.r0 = (U) g.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                    this.h0.onSubscribe(this);
                    if (this.j0) {
                        return;
                    }
                    dVar.request(h.q2.t.m0.f16408b);
                    g.a.j0 j0Var = this.p0;
                    long j2 = this.n0;
                    g.a.u0.c cVarA = j0Var.a(this, j2, j2, this.o0);
                    if (this.s0.compareAndSet(null, cVarA)) {
                        return;
                    }
                    cVarA.dispose();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    cancel();
                    g.a.y0.i.g.error(th, this.h0);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            b(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U u2 = (U) g.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                synchronized (this) {
                    u = this.r0;
                    if (u != null) {
                        this.r0 = u2;
                    }
                }
                if (u == null) {
                    g.a.y0.a.d.dispose(this.s0);
                } else {
                    a(u, false, this);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cancel();
                this.h0.onError(th);
            }
        }

        public boolean a(i.d.c<? super U> cVar, U u) {
            this.h0.onNext(u);
            return true;
        }
    }

    /* compiled from: FlowableBufferTimed.java */
    static final class c<T, U extends Collection<? super T>> extends g.a.y0.h.m<T, U, U> implements i.d.d, Runnable {
        final Callable<U> m0;
        final long n0;
        final long o0;
        final TimeUnit p0;
        final j0.c q0;
        final List<U> r0;
        i.d.d s0;

        /* compiled from: FlowableBufferTimed.java */
        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final U f14522a;

            a(U u) {
                this.f14522a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.r0.remove(this.f14522a);
                }
                c cVar = c.this;
                cVar.b(this.f14522a, false, cVar.q0);
            }
        }

        c(i.d.c<? super U> cVar, Callable<U> callable, long j2, long j3, TimeUnit timeUnit, j0.c cVar2) {
            super(cVar, new g.a.y0.f.a());
            this.m0 = callable;
            this.n0 = j2;
            this.o0 = j3;
            this.p0 = timeUnit;
            this.q0 = cVar2;
            this.r0 = new LinkedList();
        }

        @Override // g.a.y0.h.m, g.a.y0.j.u
        public /* bridge */ /* synthetic */ boolean a(i.d.c cVar, Object obj) {
            return a((i.d.c<? super i.d.c>) cVar, (i.d.c) obj);
        }

        @Override // i.d.d
        public void cancel() {
            f();
            this.s0.cancel();
            this.q0.dispose();
        }

        void f() {
            synchronized (this) {
                this.r0.clear();
            }
        }

        @Override // i.d.c
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.r0);
                this.r0.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.i0.offer((Collection) it.next());
            }
            this.k0 = true;
            if (b()) {
                g.a.y0.j.v.a((g.a.y0.c.n) this.i0, (i.d.c) this.h0, false, (g.a.u0.c) this.q0, (g.a.y0.j.u) this);
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.k0 = true;
            this.q0.dispose();
            f();
            this.h0.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.r0.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s0, dVar)) {
                this.s0 = dVar;
                try {
                    Collection collection = (Collection) g.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                    this.r0.add(collection);
                    this.h0.onSubscribe(this);
                    dVar.request(h.q2.t.m0.f16408b);
                    j0.c cVar = this.q0;
                    long j2 = this.o0;
                    cVar.a(this, j2, j2, this.p0);
                    this.q0.a(new a(collection), this.n0, this.p0);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.q0.dispose();
                    dVar.cancel();
                    g.a.y0.i.g.error(th, this.h0);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            b(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.j0) {
                return;
            }
            try {
                Collection collection = (Collection) g.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                synchronized (this) {
                    if (this.j0) {
                        return;
                    }
                    this.r0.add(collection);
                    this.q0.a(new a(collection), this.n0, this.p0);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cancel();
                this.h0.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean a(i.d.c<? super U> cVar, U u) {
            cVar.onNext(u);
            return true;
        }
    }

    public q(g.a.l<T> lVar, long j2, long j3, TimeUnit timeUnit, g.a.j0 j0Var, Callable<U> callable, int i2, boolean z) {
        super(lVar);
        this.f14515c = j2;
        this.f14516d = j3;
        this.f14517e = timeUnit;
        this.f14518f = j0Var;
        this.f14519g = callable;
        this.f14520h = i2;
        this.f14521i = z;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super U> cVar) {
        if (this.f14515c == this.f14516d && this.f14520h == Integer.MAX_VALUE) {
            this.f14110b.a((g.a.q) new b(new g.a.g1.e(cVar), this.f14519g, this.f14515c, this.f14517e, this.f14518f));
            return;
        }
        j0.c cVarA = this.f14518f.a();
        if (this.f14515c == this.f14516d) {
            this.f14110b.a((g.a.q) new a(new g.a.g1.e(cVar), this.f14519g, this.f14515c, this.f14517e, this.f14520h, this.f14521i, cVarA));
        } else {
            this.f14110b.a((g.a.q) new c(new g.a.g1.e(cVar), this.f14519g, this.f14515c, this.f14516d, this.f14517e, cVarA));
        }
    }
}
