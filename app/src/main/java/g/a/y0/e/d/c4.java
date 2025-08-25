package g.a.y0.e.d;

import g.a.j0;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWindowTimed.java */
/* loaded from: classes2.dex */
public final class c4<T> extends g.a.y0.e.d.a<T, g.a.b0<T>> {

    /* renamed from: b, reason: collision with root package name */
    final long f15016b;

    /* renamed from: c, reason: collision with root package name */
    final long f15017c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f15018d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.j0 f15019e;

    /* renamed from: f, reason: collision with root package name */
    final long f15020f;

    /* renamed from: g, reason: collision with root package name */
    final int f15021g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f15022h;

    /* compiled from: ObservableWindowTimed.java */
    static final class a<T> extends g.a.y0.d.w<T, Object, g.a.b0<T>> implements g.a.u0.c {
        final long K;
        final TimeUnit L;
        final g.a.j0 M;
        final int N;
        final boolean O;
        final long b0;
        final j0.c c0;
        long d0;
        long e0;
        g.a.u0.c f0;
        g.a.f1.j<T> g0;
        volatile boolean h0;
        final AtomicReference<g.a.u0.c> i0;

        /* compiled from: ObservableWindowTimed.java */
        /* renamed from: g.a.y0.e.d.c4$a$a, reason: collision with other inner class name */
        static final class RunnableC0209a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final long f15023a;

            /* renamed from: b, reason: collision with root package name */
            final a<?> f15024b;

            RunnableC0209a(long j2, a<?> aVar) {
                this.f15023a = j2;
                this.f15024b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.f15024b;
                if (((g.a.y0.d.w) aVar).H) {
                    aVar.h0 = true;
                    aVar.f();
                } else {
                    ((g.a.y0.d.w) aVar).G.offer(this);
                }
                if (aVar.b()) {
                    aVar.g();
                }
            }
        }

        a(g.a.i0<? super g.a.b0<T>> i0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var, int i2, long j3, boolean z) {
            super(i0Var, new g.a.y0.f.a());
            this.i0 = new AtomicReference<>();
            this.K = j2;
            this.L = timeUnit;
            this.M = j0Var;
            this.N = i2;
            this.b0 = j3;
            this.O = z;
            if (z) {
                this.c0 = j0Var.a();
            } else {
                this.c0 = null;
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.H = true;
        }

        void f() {
            g.a.y0.a.d.dispose(this.i0);
            j0.c cVar = this.c0;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [g.a.i0, g.a.i0<? super V>] */
        /* JADX WARN: Type inference failed for: r4v8, types: [g.a.f1.j] */
        void g() {
            g.a.y0.f.a aVar = (g.a.y0.f.a) this.G;
            ?? r1 = this.F;
            g.a.f1.j jVar = this.g0;
            int iA = 1;
            while (!this.h0) {
                boolean z = this.I;
                Object objPoll = aVar.poll();
                boolean z2 = objPoll == null;
                boolean z3 = objPoll instanceof RunnableC0209a;
                if (z && (z2 || z3)) {
                    this.g0 = null;
                    aVar.clear();
                    f();
                    Throwable th = this.J;
                    if (th != null) {
                        jVar.onError(th);
                        return;
                    } else {
                        jVar.onComplete();
                        return;
                    }
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (z3) {
                    RunnableC0209a runnableC0209a = (RunnableC0209a) objPoll;
                    if (this.O || this.e0 == runnableC0209a.f15023a) {
                        jVar.onComplete();
                        this.d0 = 0L;
                        jVar = (g.a.f1.j<T>) g.a.f1.j.i(this.N);
                        this.g0 = jVar;
                        r1.onNext(jVar);
                    }
                } else {
                    jVar.onNext(g.a.y0.j.q.getValue(objPoll));
                    long j2 = this.d0 + 1;
                    if (j2 >= this.b0) {
                        this.e0++;
                        this.d0 = 0L;
                        jVar.onComplete();
                        jVar = (g.a.f1.j<T>) g.a.f1.j.i(this.N);
                        this.g0 = jVar;
                        this.F.onNext(jVar);
                        if (this.O) {
                            g.a.u0.c cVar = this.i0.get();
                            cVar.dispose();
                            j0.c cVar2 = this.c0;
                            RunnableC0209a runnableC0209a2 = new RunnableC0209a(this.e0, this);
                            long j3 = this.K;
                            g.a.u0.c cVarA = cVar2.a(runnableC0209a2, j3, j3, this.L);
                            if (!this.i0.compareAndSet(cVar, cVarA)) {
                                cVarA.dispose();
                            }
                        }
                    } else {
                        this.d0 = j2;
                    }
                }
            }
            this.f0.dispose();
            aVar.clear();
            f();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.I = true;
            if (b()) {
                g();
            }
            this.F.onComplete();
            f();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.J = th;
            this.I = true;
            if (b()) {
                g();
            }
            this.F.onError(th);
            f();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.h0) {
                return;
            }
            if (e()) {
                g.a.f1.j<T> jVar = this.g0;
                jVar.onNext(t);
                long j2 = this.d0 + 1;
                if (j2 >= this.b0) {
                    this.e0++;
                    this.d0 = 0L;
                    jVar.onComplete();
                    g.a.f1.j<T> jVarI = g.a.f1.j.i(this.N);
                    this.g0 = jVarI;
                    this.F.onNext(jVarI);
                    if (this.O) {
                        this.i0.get().dispose();
                        j0.c cVar = this.c0;
                        RunnableC0209a runnableC0209a = new RunnableC0209a(this.e0, this);
                        long j3 = this.K;
                        g.a.y0.a.d.replace(this.i0, cVar.a(runnableC0209a, j3, j3, this.L));
                    }
                } else {
                    this.d0 = j2;
                }
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.G.offer(g.a.y0.j.q.next(t));
                if (!b()) {
                    return;
                }
            }
            g();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.u0.c cVarA;
            if (g.a.y0.a.d.validate(this.f0, cVar)) {
                this.f0 = cVar;
                g.a.i0<? super V> i0Var = this.F;
                i0Var.onSubscribe(this);
                if (this.H) {
                    return;
                }
                g.a.f1.j<T> jVarI = g.a.f1.j.i(this.N);
                this.g0 = jVarI;
                i0Var.onNext(jVarI);
                RunnableC0209a runnableC0209a = new RunnableC0209a(this.e0, this);
                if (this.O) {
                    j0.c cVar2 = this.c0;
                    long j2 = this.K;
                    cVarA = cVar2.a(runnableC0209a, j2, j2, this.L);
                } else {
                    g.a.j0 j0Var = this.M;
                    long j3 = this.K;
                    cVarA = j0Var.a(runnableC0209a, j3, j3, this.L);
                }
                g.a.y0.a.d.replace(this.i0, cVarA);
            }
        }
    }

    /* compiled from: ObservableWindowTimed.java */
    static final class b<T> extends g.a.y0.d.w<T, Object, g.a.b0<T>> implements g.a.i0<T>, g.a.u0.c, Runnable {
        static final Object e0 = new Object();
        final long K;
        final TimeUnit L;
        final g.a.j0 M;
        final int N;
        g.a.u0.c O;
        g.a.f1.j<T> b0;
        final AtomicReference<g.a.u0.c> c0;
        volatile boolean d0;

        b(g.a.i0<? super g.a.b0<T>> i0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var, int i2) {
            super(i0Var, new g.a.y0.f.a());
            this.c0 = new AtomicReference<>();
            this.K = j2;
            this.L = timeUnit;
            this.M = j0Var;
            this.N = i2;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.H = true;
        }

        void f() {
            g.a.y0.a.d.dispose(this.c0);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r7.b0 = null;
            r0.clear();
            f();
            r0 = r7.J;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [g.a.f1.j<T>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void g() {
            /*
                r7 = this;
                g.a.y0.c.n<U> r0 = r7.G
                g.a.y0.f.a r0 = (g.a.y0.f.a) r0
                g.a.i0<? super V> r1 = r7.F
                g.a.f1.j<T> r2 = r7.b0
                r3 = 1
            L9:
                boolean r4 = r7.d0
                boolean r5 = r7.I
                java.lang.Object r6 = r0.poll()
                if (r5 == 0) goto L2e
                if (r6 == 0) goto L19
                java.lang.Object r5 = g.a.y0.e.d.c4.b.e0
                if (r6 != r5) goto L2e
            L19:
                r1 = 0
                r7.b0 = r1
                r0.clear()
                r7.f()
                java.lang.Throwable r0 = r7.J
                if (r0 == 0) goto L2a
                r2.onError(r0)
                goto L2d
            L2a:
                r2.onComplete()
            L2d:
                return
            L2e:
                if (r6 != 0) goto L38
                int r3 = -r3
                int r3 = r7.a(r3)
                if (r3 != 0) goto L9
                return
            L38:
                java.lang.Object r5 = g.a.y0.e.d.c4.b.e0
                if (r6 != r5) goto L53
                r2.onComplete()
                if (r4 != 0) goto L4d
                int r2 = r7.N
                g.a.f1.j r2 = g.a.f1.j.i(r2)
                r7.b0 = r2
                r1.onNext(r2)
                goto L9
            L4d:
                g.a.u0.c r4 = r7.O
                r4.dispose()
                goto L9
            L53:
                java.lang.Object r4 = g.a.y0.j.q.getValue(r6)
                r2.onNext(r4)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.d.c4.b.g():void");
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.I = true;
            if (b()) {
                g();
            }
            f();
            this.F.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.J = th;
            this.I = true;
            if (b()) {
                g();
            }
            f();
            this.F.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.d0) {
                return;
            }
            if (e()) {
                this.b0.onNext(t);
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.G.offer(g.a.y0.j.q.next(t));
                if (!b()) {
                    return;
                }
            }
            g();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.O, cVar)) {
                this.O = cVar;
                this.b0 = g.a.f1.j.i(this.N);
                g.a.i0<? super V> i0Var = this.F;
                i0Var.onSubscribe(this);
                i0Var.onNext(this.b0);
                if (this.H) {
                    return;
                }
                g.a.j0 j0Var = this.M;
                long j2 = this.K;
                g.a.y0.a.d.replace(this.c0, j0Var.a(this, j2, j2, this.L));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.H) {
                this.d0 = true;
                f();
            }
            this.G.offer(e0);
            if (b()) {
                g();
            }
        }
    }

    /* compiled from: ObservableWindowTimed.java */
    static final class c<T> extends g.a.y0.d.w<T, Object, g.a.b0<T>> implements g.a.u0.c, Runnable {
        final long K;
        final long L;
        final TimeUnit M;
        final j0.c N;
        final int O;
        final List<g.a.f1.j<T>> b0;
        g.a.u0.c c0;
        volatile boolean d0;

        /* compiled from: ObservableWindowTimed.java */
        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final g.a.f1.j<T> f15025a;

            a(g.a.f1.j<T> jVar) {
                this.f15025a = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(this.f15025a);
            }
        }

        /* compiled from: ObservableWindowTimed.java */
        static final class b<T> {

            /* renamed from: a, reason: collision with root package name */
            final g.a.f1.j<T> f15027a;

            /* renamed from: b, reason: collision with root package name */
            final boolean f15028b;

            b(g.a.f1.j<T> jVar, boolean z) {
                this.f15027a = jVar;
                this.f15028b = z;
            }
        }

        c(g.a.i0<? super g.a.b0<T>> i0Var, long j2, long j3, TimeUnit timeUnit, j0.c cVar, int i2) {
            super(i0Var, new g.a.y0.f.a());
            this.K = j2;
            this.L = j3;
            this.M = timeUnit;
            this.N = cVar;
            this.O = i2;
            this.b0 = new LinkedList();
        }

        void a(g.a.f1.j<T> jVar) {
            this.G.offer(new b(jVar, false));
            if (b()) {
                g();
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.H = true;
        }

        void f() {
            this.N.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g() {
            g.a.y0.f.a aVar = (g.a.y0.f.a) this.G;
            g.a.i0<? super V> i0Var = this.F;
            List<g.a.f1.j<T>> list = this.b0;
            int iA = 1;
            while (!this.d0) {
                boolean z = this.I;
                Object objPoll = aVar.poll();
                boolean z2 = objPoll == null;
                boolean z3 = objPoll instanceof b;
                if (z && (z2 || z3)) {
                    aVar.clear();
                    Throwable th = this.J;
                    if (th != null) {
                        Iterator<g.a.f1.j<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<g.a.f1.j<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    f();
                    list.clear();
                    return;
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (z3) {
                    b bVar = (b) objPoll;
                    if (!bVar.f15028b) {
                        list.remove(bVar.f15027a);
                        bVar.f15027a.onComplete();
                        if (list.isEmpty() && this.H) {
                            this.d0 = true;
                        }
                    } else if (!this.H) {
                        g.a.f1.j<T> jVarI = g.a.f1.j.i(this.O);
                        list.add(jVarI);
                        i0Var.onNext(jVarI);
                        this.N.a(new a(jVarI), this.K, this.M);
                    }
                } else {
                    Iterator<g.a.f1.j<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(objPoll);
                    }
                }
            }
            this.c0.dispose();
            f();
            aVar.clear();
            list.clear();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.I = true;
            if (b()) {
                g();
            }
            this.F.onComplete();
            f();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.J = th;
            this.I = true;
            if (b()) {
                g();
            }
            this.F.onError(th);
            f();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (e()) {
                Iterator<g.a.f1.j<T>> it = this.b0.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.G.offer(t);
                if (!b()) {
                    return;
                }
            }
            g();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.c0, cVar)) {
                this.c0 = cVar;
                this.F.onSubscribe(this);
                if (this.H) {
                    return;
                }
                g.a.f1.j<T> jVarI = g.a.f1.j.i(this.O);
                this.b0.add(jVarI);
                this.F.onNext(jVarI);
                this.N.a(new a(jVarI), this.K, this.M);
                j0.c cVar2 = this.N;
                long j2 = this.L;
                cVar2.a(this, j2, j2, this.M);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = new b(g.a.f1.j.i(this.O), true);
            if (!this.H) {
                this.G.offer(bVar);
            }
            if (b()) {
                g();
            }
        }
    }

    public c4(g.a.g0<T> g0Var, long j2, long j3, TimeUnit timeUnit, g.a.j0 j0Var, long j4, int i2, boolean z) {
        super(g0Var);
        this.f15016b = j2;
        this.f15017c = j3;
        this.f15018d = timeUnit;
        this.f15019e = j0Var;
        this.f15020f = j4;
        this.f15021g = i2;
        this.f15022h = z;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super g.a.b0<T>> i0Var) {
        g.a.a1.m mVar = new g.a.a1.m(i0Var);
        long j2 = this.f15016b;
        long j3 = this.f15017c;
        if (j2 != j3) {
            this.f14934a.subscribe(new c(mVar, j2, j3, this.f15018d, this.f15019e.a(), this.f15021g));
            return;
        }
        long j4 = this.f15020f;
        if (j4 == h.q2.t.m0.f16408b) {
            this.f14934a.subscribe(new b(mVar, j2, this.f15018d, this.f15019e, this.f15021g));
        } else {
            this.f14934a.subscribe(new a(mVar, j2, this.f15018d, this.f15019e, this.f15021g, j4, this.f15022h));
        }
    }
}
