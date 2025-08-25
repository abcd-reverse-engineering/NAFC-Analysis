package g.a.y0.e.d;

import g.a.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableBufferTimed.java */
/* loaded from: classes2.dex */
public final class q<T, U extends Collection<? super T>> extends g.a.y0.e.d.a<T, U> {

    /* renamed from: b, reason: collision with root package name */
    final long f15396b;

    /* renamed from: c, reason: collision with root package name */
    final long f15397c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f15398d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.j0 f15399e;

    /* renamed from: f, reason: collision with root package name */
    final Callable<U> f15400f;

    /* renamed from: g, reason: collision with root package name */
    final int f15401g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f15402h;

    /* compiled from: ObservableBufferTimed.java */
    static final class a<T, U extends Collection<? super T>> extends g.a.y0.d.w<T, U, U> implements Runnable, g.a.u0.c {
        final Callable<U> K;
        final long L;
        final TimeUnit M;
        final int N;
        final boolean O;
        final j0.c b0;
        U c0;
        g.a.u0.c d0;
        g.a.u0.c e0;
        long f0;
        long g0;

        a(g.a.i0<? super U> i0Var, Callable<U> callable, long j2, TimeUnit timeUnit, int i2, boolean z, j0.c cVar) {
            super(i0Var, new g.a.y0.f.a());
            this.K = callable;
            this.L = j2;
            this.M = timeUnit;
            this.N = i2;
            this.O = z;
            this.b0 = cVar;
        }

        @Override // g.a.y0.d.w, g.a.y0.j.r
        public /* bridge */ /* synthetic */ void a(g.a.i0 i0Var, Object obj) {
            a((g.a.i0<? super g.a.i0>) i0Var, (g.a.i0) obj);
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.H) {
                return;
            }
            this.H = true;
            this.e0.dispose();
            this.b0.dispose();
            synchronized (this) {
                this.c0 = null;
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // g.a.i0
        public void onComplete() {
            U u;
            this.b0.dispose();
            synchronized (this) {
                u = this.c0;
                this.c0 = null;
            }
            this.G.offer(u);
            this.I = true;
            if (b()) {
                g.a.y0.j.v.a((g.a.y0.c.n) this.G, (g.a.i0) this.F, false, (g.a.u0.c) this, (g.a.y0.j.r) this);
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            synchronized (this) {
                this.c0 = null;
            }
            this.F.onError(th);
            this.b0.dispose();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            synchronized (this) {
                U u = this.c0;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.N) {
                    return;
                }
                this.c0 = null;
                this.f0++;
                if (this.O) {
                    this.d0.dispose();
                }
                b(u, false, this);
                try {
                    U u2 = (U) g.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                    synchronized (this) {
                        this.c0 = u2;
                        this.g0++;
                    }
                    if (this.O) {
                        j0.c cVar = this.b0;
                        long j2 = this.L;
                        this.d0 = cVar.a(this, j2, j2, this.M);
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.F.onError(th);
                    dispose();
                }
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.e0, cVar)) {
                this.e0 = cVar;
                try {
                    this.c0 = (U) g.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                    this.F.onSubscribe(this);
                    j0.c cVar2 = this.b0;
                    long j2 = this.L;
                    this.d0 = cVar2.a(this, j2, j2, this.M);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    cVar.dispose();
                    g.a.y0.a.e.error(th, this.F);
                    this.b0.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) g.a.y0.b.b.a(this.K.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u2 = this.c0;
                    if (u2 != null && this.f0 == this.g0) {
                        this.c0 = u;
                        b(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                dispose();
                this.F.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(g.a.i0<? super U> i0Var, U u) {
            i0Var.onNext(u);
        }
    }

    /* compiled from: ObservableBufferTimed.java */
    static final class b<T, U extends Collection<? super T>> extends g.a.y0.d.w<T, U, U> implements Runnable, g.a.u0.c {
        final Callable<U> K;
        final long L;
        final TimeUnit M;
        final g.a.j0 N;
        g.a.u0.c O;
        U b0;
        final AtomicReference<g.a.u0.c> c0;

        b(g.a.i0<? super U> i0Var, Callable<U> callable, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            super(i0Var, new g.a.y0.f.a());
            this.c0 = new AtomicReference<>();
            this.K = callable;
            this.L = j2;
            this.M = timeUnit;
            this.N = j0Var;
        }

        @Override // g.a.y0.d.w, g.a.y0.j.r
        public /* bridge */ /* synthetic */ void a(g.a.i0 i0Var, Object obj) {
            a((g.a.i0<? super g.a.i0>) i0Var, (g.a.i0) obj);
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this.c0);
            this.O.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.c0.get() == g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.i0
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.b0;
                this.b0 = null;
            }
            if (u != null) {
                this.G.offer(u);
                this.I = true;
                if (b()) {
                    g.a.y0.j.v.a((g.a.y0.c.n) this.G, (g.a.i0) this.F, false, (g.a.u0.c) this, (g.a.y0.j.r) this);
                }
            }
            g.a.y0.a.d.dispose(this.c0);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            synchronized (this) {
                this.b0 = null;
            }
            this.F.onError(th);
            g.a.y0.a.d.dispose(this.c0);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            synchronized (this) {
                U u = this.b0;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.O, cVar)) {
                this.O = cVar;
                try {
                    this.b0 = (U) g.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                    this.F.onSubscribe(this);
                    if (this.H) {
                        return;
                    }
                    g.a.j0 j0Var = this.N;
                    long j2 = this.L;
                    g.a.u0.c cVarA = j0Var.a(this, j2, j2, this.M);
                    if (this.c0.compareAndSet(null, cVarA)) {
                        return;
                    }
                    cVarA.dispose();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    dispose();
                    g.a.y0.a.e.error(th, this.F);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U u2 = (U) g.a.y0.b.b.a(this.K.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u = this.b0;
                    if (u != null) {
                        this.b0 = u2;
                    }
                }
                if (u == null) {
                    g.a.y0.a.d.dispose(this.c0);
                } else {
                    a(u, false, this);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.F.onError(th);
                dispose();
            }
        }

        public void a(g.a.i0<? super U> i0Var, U u) {
            this.F.onNext(u);
        }
    }

    /* compiled from: ObservableBufferTimed.java */
    static final class c<T, U extends Collection<? super T>> extends g.a.y0.d.w<T, U, U> implements Runnable, g.a.u0.c {
        final Callable<U> K;
        final long L;
        final long M;
        final TimeUnit N;
        final j0.c O;
        final List<U> b0;
        g.a.u0.c c0;

        /* compiled from: ObservableBufferTimed.java */
        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final U f15403a;

            a(U u) {
                this.f15403a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.b0.remove(this.f15403a);
                }
                c cVar = c.this;
                cVar.b(this.f15403a, false, cVar.O);
            }
        }

        /* compiled from: ObservableBufferTimed.java */
        final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final U f15405a;

            b(U u) {
                this.f15405a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.b0.remove(this.f15405a);
                }
                c cVar = c.this;
                cVar.b(this.f15405a, false, cVar.O);
            }
        }

        c(g.a.i0<? super U> i0Var, Callable<U> callable, long j2, long j3, TimeUnit timeUnit, j0.c cVar) {
            super(i0Var, new g.a.y0.f.a());
            this.K = callable;
            this.L = j2;
            this.M = j3;
            this.N = timeUnit;
            this.O = cVar;
            this.b0 = new LinkedList();
        }

        @Override // g.a.y0.d.w, g.a.y0.j.r
        public /* bridge */ /* synthetic */ void a(g.a.i0 i0Var, Object obj) {
            a((g.a.i0<? super g.a.i0>) i0Var, (g.a.i0) obj);
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.H) {
                return;
            }
            this.H = true;
            f();
            this.c0.dispose();
            this.O.dispose();
        }

        void f() {
            synchronized (this) {
                this.b0.clear();
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // g.a.i0
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.b0);
                this.b0.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.G.offer((Collection) it.next());
            }
            this.I = true;
            if (b()) {
                g.a.y0.j.v.a((g.a.y0.c.n) this.G, (g.a.i0) this.F, false, (g.a.u0.c) this.O, (g.a.y0.j.r) this);
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.I = true;
            f();
            this.F.onError(th);
            this.O.dispose();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.b0.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.c0, cVar)) {
                this.c0 = cVar;
                try {
                    Collection collection = (Collection) g.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                    this.b0.add(collection);
                    this.F.onSubscribe(this);
                    j0.c cVar2 = this.O;
                    long j2 = this.M;
                    cVar2.a(this, j2, j2, this.N);
                    this.O.a(new b(collection), this.L, this.N);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    cVar.dispose();
                    g.a.y0.a.e.error(th, this.F);
                    this.O.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.H) {
                return;
            }
            try {
                Collection collection = (Collection) g.a.y0.b.b.a(this.K.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    if (this.H) {
                        return;
                    }
                    this.b0.add(collection);
                    this.O.a(new a(collection), this.L, this.N);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.F.onError(th);
                dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(g.a.i0<? super U> i0Var, U u) {
            i0Var.onNext(u);
        }
    }

    public q(g.a.g0<T> g0Var, long j2, long j3, TimeUnit timeUnit, g.a.j0 j0Var, Callable<U> callable, int i2, boolean z) {
        super(g0Var);
        this.f15396b = j2;
        this.f15397c = j3;
        this.f15398d = timeUnit;
        this.f15399e = j0Var;
        this.f15400f = callable;
        this.f15401g = i2;
        this.f15402h = z;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super U> i0Var) {
        if (this.f15396b == this.f15397c && this.f15401g == Integer.MAX_VALUE) {
            this.f14934a.subscribe(new b(new g.a.a1.m(i0Var), this.f15400f, this.f15396b, this.f15398d, this.f15399e));
            return;
        }
        j0.c cVarA = this.f15399e.a();
        if (this.f15396b == this.f15397c) {
            this.f14934a.subscribe(new a(new g.a.a1.m(i0Var), this.f15400f, this.f15396b, this.f15398d, this.f15401g, this.f15402h, cVarA));
        } else {
            this.f14934a.subscribe(new c(new g.a.a1.m(i0Var), this.f15400f, this.f15396b, this.f15397c, this.f15398d, cVarA));
        }
    }
}
