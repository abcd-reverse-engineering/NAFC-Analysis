package g.a.y0.e.b;

import g.a.j0;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: FlowableWindowTimed.java */
/* loaded from: classes2.dex */
public final class p4<T> extends g.a.y0.e.b.a<T, g.a.l<T>> {

    /* renamed from: c, reason: collision with root package name */
    final long f14502c;

    /* renamed from: d, reason: collision with root package name */
    final long f14503d;

    /* renamed from: e, reason: collision with root package name */
    final TimeUnit f14504e;

    /* renamed from: f, reason: collision with root package name */
    final g.a.j0 f14505f;

    /* renamed from: g, reason: collision with root package name */
    final long f14506g;

    /* renamed from: h, reason: collision with root package name */
    final int f14507h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f14508i;

    /* compiled from: FlowableWindowTimed.java */
    static final class a<T> extends g.a.y0.h.m<T, Object, g.a.l<T>> implements i.d.d {
        final long m0;
        final TimeUnit n0;
        final g.a.j0 o0;
        final int p0;
        final boolean q0;
        final long r0;
        final j0.c s0;
        long t0;
        long u0;
        i.d.d v0;
        g.a.d1.g<T> w0;
        volatile boolean x0;
        final g.a.y0.a.k y0;

        /* compiled from: FlowableWindowTimed.java */
        /* renamed from: g.a.y0.e.b.p4$a$a, reason: collision with other inner class name */
        static final class RunnableC0194a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final long f14509a;

            /* renamed from: b, reason: collision with root package name */
            final a<?> f14510b;

            RunnableC0194a(long j2, a<?> aVar) {
                this.f14509a = j2;
                this.f14510b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.f14510b;
                if (((g.a.y0.h.m) aVar).j0) {
                    aVar.x0 = true;
                    aVar.dispose();
                } else {
                    ((g.a.y0.h.m) aVar).i0.offer(this);
                }
                if (aVar.b()) {
                    aVar.f();
                }
            }
        }

        a(i.d.c<? super g.a.l<T>> cVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var, int i2, long j3, boolean z) {
            super(cVar, new g.a.y0.f.a());
            this.y0 = new g.a.y0.a.k();
            this.m0 = j2;
            this.n0 = timeUnit;
            this.o0 = j0Var;
            this.p0 = i2;
            this.r0 = j3;
            this.q0 = z;
            if (z) {
                this.s0 = j0Var.a();
            } else {
                this.s0 = null;
            }
        }

        @Override // i.d.d
        public void cancel() {
            this.j0 = true;
        }

        public void dispose() {
            g.a.y0.a.d.dispose(this.y0);
            j0.c cVar = this.s0;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void f() {
            /*
                Method dump skipped, instructions count: 295
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.p4.a.f():void");
        }

        @Override // i.d.c
        public void onComplete() {
            this.k0 = true;
            if (b()) {
                f();
            }
            this.h0.onComplete();
            dispose();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.l0 = th;
            this.k0 = true;
            if (b()) {
                f();
            }
            this.h0.onError(th);
            dispose();
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.x0) {
                return;
            }
            if (e()) {
                g.a.d1.g<T> gVar = this.w0;
                gVar.onNext(t);
                long j2 = this.t0 + 1;
                if (j2 >= this.r0) {
                    this.u0++;
                    this.t0 = 0L;
                    gVar.onComplete();
                    long jRequested = requested();
                    if (jRequested == 0) {
                        this.w0 = null;
                        this.v0.cancel();
                        this.h0.onError(new g.a.v0.c("Could not deliver window due to lack of requests"));
                        dispose();
                        return;
                    }
                    g.a.d1.g<T> gVarM = g.a.d1.g.m(this.p0);
                    this.w0 = gVarM;
                    this.h0.onNext(gVarM);
                    if (jRequested != h.q2.t.m0.f16408b) {
                        a(1L);
                    }
                    if (this.q0) {
                        g.a.u0.c cVar = this.y0.get();
                        cVar.dispose();
                        j0.c cVar2 = this.s0;
                        RunnableC0194a runnableC0194a = new RunnableC0194a(this.u0, this);
                        long j3 = this.m0;
                        g.a.u0.c cVarA = cVar2.a(runnableC0194a, j3, j3, this.n0);
                        if (!this.y0.compareAndSet(cVar, cVarA)) {
                            cVarA.dispose();
                        }
                    }
                } else {
                    this.t0 = j2;
                }
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.i0.offer(g.a.y0.j.q.next(t));
                if (!b()) {
                    return;
                }
            }
            f();
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            g.a.u0.c cVarA;
            if (g.a.y0.i.j.validate(this.v0, dVar)) {
                this.v0 = dVar;
                i.d.c<? super V> cVar = this.h0;
                cVar.onSubscribe(this);
                if (this.j0) {
                    return;
                }
                g.a.d1.g<T> gVarM = g.a.d1.g.m(this.p0);
                this.w0 = gVarM;
                long jRequested = requested();
                if (jRequested == 0) {
                    this.j0 = true;
                    dVar.cancel();
                    cVar.onError(new g.a.v0.c("Could not deliver initial window due to lack of requests."));
                    return;
                }
                cVar.onNext(gVarM);
                if (jRequested != h.q2.t.m0.f16408b) {
                    a(1L);
                }
                RunnableC0194a runnableC0194a = new RunnableC0194a(this.u0, this);
                if (this.q0) {
                    j0.c cVar2 = this.s0;
                    long j2 = this.m0;
                    cVarA = cVar2.a(runnableC0194a, j2, j2, this.n0);
                } else {
                    g.a.j0 j0Var = this.o0;
                    long j3 = this.m0;
                    cVarA = j0Var.a(runnableC0194a, j3, j3, this.n0);
                }
                if (this.y0.replace(cVarA)) {
                    dVar.request(h.q2.t.m0.f16408b);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            b(j2);
        }
    }

    /* compiled from: FlowableWindowTimed.java */
    static final class b<T> extends g.a.y0.h.m<T, Object, g.a.l<T>> implements g.a.q<T>, i.d.d, Runnable {
        static final Object u0 = new Object();
        final long m0;
        final TimeUnit n0;
        final g.a.j0 o0;
        final int p0;
        i.d.d q0;
        g.a.d1.g<T> r0;
        final g.a.y0.a.k s0;
        volatile boolean t0;

        b(i.d.c<? super g.a.l<T>> cVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var, int i2) {
            super(cVar, new g.a.y0.f.a());
            this.s0 = new g.a.y0.a.k();
            this.m0 = j2;
            this.n0 = timeUnit;
            this.o0 = j0Var;
            this.p0 = i2;
        }

        @Override // i.d.d
        public void cancel() {
            this.j0 = true;
        }

        public void dispose() {
            g.a.y0.a.d.dispose(this.s0);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        
            r10.r0 = null;
            r0.clear();
            dispose();
            r0 = r10.l0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [g.a.d1.g<T>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void f() {
            /*
                r10 = this;
                g.a.y0.c.n<U> r0 = r10.i0
                i.d.c<? super V> r1 = r10.h0
                g.a.d1.g<T> r2 = r10.r0
                r3 = 1
            L7:
                boolean r4 = r10.t0
                boolean r5 = r10.k0
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r5 == 0) goto L2c
                if (r6 == 0) goto L18
                java.lang.Object r5 = g.a.y0.e.b.p4.b.u0
                if (r6 != r5) goto L2c
            L18:
                r10.r0 = r7
                r0.clear()
                r10.dispose()
                java.lang.Throwable r0 = r10.l0
                if (r0 == 0) goto L28
                r2.onError(r0)
                goto L2b
            L28:
                r2.onComplete()
            L2b:
                return
            L2c:
                if (r6 != 0) goto L36
                int r3 = -r3
                int r3 = r10.a(r3)
                if (r3 != 0) goto L7
                return
            L36:
                java.lang.Object r5 = g.a.y0.e.b.p4.b.u0
                if (r6 != r5) goto L83
                r2.onComplete()
                if (r4 != 0) goto L7d
                int r2 = r10.p0
                g.a.d1.g r2 = g.a.d1.g.m(r2)
                r10.r0 = r2
                long r4 = r10.requested()
                r8 = 0
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 == 0) goto L63
                r1.onNext(r2)
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 == 0) goto L7
                r4 = 1
                r10.a(r4)
                goto L7
            L63:
                r10.r0 = r7
                g.a.y0.c.n<U> r0 = r10.i0
                r0.clear()
                i.d.d r0 = r10.q0
                r0.cancel()
                r10.dispose()
                g.a.v0.c r0 = new g.a.v0.c
                java.lang.String r2 = "Could not deliver first window due to lack of requests."
                r0.<init>(r2)
                r1.onError(r0)
                return
            L7d:
                i.d.d r4 = r10.q0
                r4.cancel()
                goto L7
            L83:
                java.lang.Object r4 = g.a.y0.j.q.getValue(r6)
                r2.onNext(r4)
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.p4.b.f():void");
        }

        @Override // i.d.c
        public void onComplete() {
            this.k0 = true;
            if (b()) {
                f();
            }
            this.h0.onComplete();
            dispose();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.l0 = th;
            this.k0 = true;
            if (b()) {
                f();
            }
            this.h0.onError(th);
            dispose();
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.t0) {
                return;
            }
            if (e()) {
                this.r0.onNext(t);
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.i0.offer(g.a.y0.j.q.next(t));
                if (!b()) {
                    return;
                }
            }
            f();
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.q0, dVar)) {
                this.q0 = dVar;
                this.r0 = g.a.d1.g.m(this.p0);
                i.d.c<? super V> cVar = this.h0;
                cVar.onSubscribe(this);
                long jRequested = requested();
                if (jRequested == 0) {
                    this.j0 = true;
                    dVar.cancel();
                    cVar.onError(new g.a.v0.c("Could not deliver first window due to lack of requests."));
                    return;
                }
                cVar.onNext(this.r0);
                if (jRequested != h.q2.t.m0.f16408b) {
                    a(1L);
                }
                if (this.j0) {
                    return;
                }
                g.a.y0.a.k kVar = this.s0;
                g.a.j0 j0Var = this.o0;
                long j2 = this.m0;
                if (kVar.replace(j0Var.a(this, j2, j2, this.n0))) {
                    dVar.request(h.q2.t.m0.f16408b);
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
                this.t0 = true;
                dispose();
            }
            this.i0.offer(u0);
            if (b()) {
                f();
            }
        }
    }

    /* compiled from: FlowableWindowTimed.java */
    static final class c<T> extends g.a.y0.h.m<T, Object, g.a.l<T>> implements i.d.d, Runnable {
        final long m0;
        final long n0;
        final TimeUnit o0;
        final j0.c p0;
        final int q0;
        final List<g.a.d1.g<T>> r0;
        i.d.d s0;
        volatile boolean t0;

        /* compiled from: FlowableWindowTimed.java */
        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final g.a.d1.g<T> f14511a;

            a(g.a.d1.g<T> gVar) {
                this.f14511a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(this.f14511a);
            }
        }

        /* compiled from: FlowableWindowTimed.java */
        static final class b<T> {

            /* renamed from: a, reason: collision with root package name */
            final g.a.d1.g<T> f14513a;

            /* renamed from: b, reason: collision with root package name */
            final boolean f14514b;

            b(g.a.d1.g<T> gVar, boolean z) {
                this.f14513a = gVar;
                this.f14514b = z;
            }
        }

        c(i.d.c<? super g.a.l<T>> cVar, long j2, long j3, TimeUnit timeUnit, j0.c cVar2, int i2) {
            super(cVar, new g.a.y0.f.a());
            this.m0 = j2;
            this.n0 = j3;
            this.o0 = timeUnit;
            this.p0 = cVar2;
            this.q0 = i2;
            this.r0 = new LinkedList();
        }

        void a(g.a.d1.g<T> gVar) {
            this.i0.offer(new b(gVar, false));
            if (b()) {
                f();
            }
        }

        @Override // i.d.d
        public void cancel() {
            this.j0 = true;
        }

        public void dispose() {
            this.p0.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void f() {
            g.a.y0.c.o oVar = this.i0;
            i.d.c<? super V> cVar = this.h0;
            List<g.a.d1.g<T>> list = this.r0;
            int iA = 1;
            while (!this.t0) {
                boolean z = this.k0;
                Object objPoll = oVar.poll();
                boolean z2 = objPoll == null;
                boolean z3 = objPoll instanceof b;
                if (z && (z2 || z3)) {
                    oVar.clear();
                    Throwable th = this.l0;
                    if (th != null) {
                        Iterator<g.a.d1.g<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<g.a.d1.g<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    dispose();
                    return;
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (z3) {
                    b bVar = (b) objPoll;
                    if (!bVar.f14514b) {
                        list.remove(bVar.f14513a);
                        bVar.f14513a.onComplete();
                        if (list.isEmpty() && this.j0) {
                            this.t0 = true;
                        }
                    } else if (!this.j0) {
                        long jRequested = requested();
                        if (jRequested != 0) {
                            g.a.d1.g<T> gVarM = g.a.d1.g.m(this.q0);
                            list.add(gVarM);
                            cVar.onNext(gVarM);
                            if (jRequested != h.q2.t.m0.f16408b) {
                                a(1L);
                            }
                            this.p0.a(new a(gVarM), this.m0, this.o0);
                        } else {
                            cVar.onError(new g.a.v0.c("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<g.a.d1.g<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(objPoll);
                    }
                }
            }
            this.s0.cancel();
            dispose();
            oVar.clear();
            list.clear();
        }

        @Override // i.d.c
        public void onComplete() {
            this.k0 = true;
            if (b()) {
                f();
            }
            this.h0.onComplete();
            dispose();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.l0 = th;
            this.k0 = true;
            if (b()) {
                f();
            }
            this.h0.onError(th);
            dispose();
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (e()) {
                Iterator<g.a.d1.g<T>> it = this.r0.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.i0.offer(t);
                if (!b()) {
                    return;
                }
            }
            f();
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s0, dVar)) {
                this.s0 = dVar;
                this.h0.onSubscribe(this);
                if (this.j0) {
                    return;
                }
                long jRequested = requested();
                if (jRequested == 0) {
                    dVar.cancel();
                    this.h0.onError(new g.a.v0.c("Could not emit the first window due to lack of requests"));
                    return;
                }
                g.a.d1.g<T> gVarM = g.a.d1.g.m(this.q0);
                this.r0.add(gVarM);
                this.h0.onNext(gVarM);
                if (jRequested != h.q2.t.m0.f16408b) {
                    a(1L);
                }
                this.p0.a(new a(gVarM), this.m0, this.o0);
                j0.c cVar = this.p0;
                long j2 = this.n0;
                cVar.a(this, j2, j2, this.o0);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            b(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = new b(g.a.d1.g.m(this.q0), true);
            if (!this.j0) {
                this.i0.offer(bVar);
            }
            if (b()) {
                f();
            }
        }
    }

    public p4(g.a.l<T> lVar, long j2, long j3, TimeUnit timeUnit, g.a.j0 j0Var, long j4, int i2, boolean z) {
        super(lVar);
        this.f14502c = j2;
        this.f14503d = j3;
        this.f14504e = timeUnit;
        this.f14505f = j0Var;
        this.f14506g = j4;
        this.f14507h = i2;
        this.f14508i = z;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super g.a.l<T>> cVar) {
        g.a.g1.e eVar = new g.a.g1.e(cVar);
        long j2 = this.f14502c;
        long j3 = this.f14503d;
        if (j2 != j3) {
            this.f14110b.a((g.a.q) new c(eVar, j2, j3, this.f14504e, this.f14505f.a(), this.f14507h));
            return;
        }
        long j4 = this.f14506g;
        if (j4 == h.q2.t.m0.f16408b) {
            this.f14110b.a((g.a.q) new b(eVar, j2, this.f14504e, this.f14505f, this.f14507h));
        } else {
            this.f14110b.a((g.a.q) new a(eVar, j2, this.f14504e, this.f14505f, this.f14507h, j4, this.f14508i));
        }
    }
}
