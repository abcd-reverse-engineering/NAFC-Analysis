package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlatMapMaybe.java */
/* loaded from: classes2.dex */
public final class z0<T, R> extends g.a.y0.e.b.a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.y<? extends R>> f14733c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f14734d;

    /* renamed from: e, reason: collision with root package name */
    final int f14735e;

    /* compiled from: FlowableFlatMapMaybe.java */
    static final class a<T, R> extends AtomicInteger implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = 8600231336733376951L;
        final i.d.c<? super R> actual;
        volatile boolean cancelled;
        final boolean delayErrors;
        final g.a.x0.o<? super T, ? extends g.a.y<? extends R>> mapper;
        final int maxConcurrency;
        i.d.d s;
        final AtomicLong requested = new AtomicLong();
        final g.a.u0.b set = new g.a.u0.b();
        final g.a.y0.j.c errors = new g.a.y0.j.c();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<g.a.y0.f.c<R>> queue = new AtomicReference<>();

        /* compiled from: FlowableFlatMapMaybe.java */
        /* renamed from: g.a.y0.e.b.z0$a$a, reason: collision with other inner class name */
        final class C0198a extends AtomicReference<g.a.u0.c> implements g.a.v<R>, g.a.u0.c {
            private static final long serialVersionUID = -502562646270949838L;

            C0198a() {
            }

            @Override // g.a.u0.c
            public void dispose() {
                g.a.y0.a.d.dispose(this);
            }

            @Override // g.a.u0.c
            public boolean isDisposed() {
                return g.a.y0.a.d.isDisposed(get());
            }

            @Override // g.a.v
            public void onComplete() {
                a.this.innerComplete(this);
            }

            @Override // g.a.v
            public void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            @Override // g.a.v
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.setOnce(this, cVar);
            }

            @Override // g.a.v, g.a.n0
            public void onSuccess(R r) {
                a.this.innerSuccess(this, r);
            }
        }

        a(i.d.c<? super R> cVar, g.a.x0.o<? super T, ? extends g.a.y<? extends R>> oVar, boolean z, int i2) {
            this.actual = cVar;
            this.mapper = oVar;
            this.delayErrors = z;
            this.maxConcurrency = i2;
        }

        @Override // i.d.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            this.set.dispose();
        }

        void clear() {
            g.a.y0.f.c<R> cVar = this.queue.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
        
            if (r10 != r6) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
        
            if (r17.cancelled == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
        
            clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
        
            if (r17.delayErrors != false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x008d, code lost:
        
            if (r17.errors.get() == null) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x008f, code lost:
        
            r2 = r17.errors.terminate();
            clear();
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
        
            if (r2.get() != 0) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
        
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
        
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a5, code lost:
        
            r7 = r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00ab, code lost:
        
            if (r7 == null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b1, code lost:
        
            if (r7.isEmpty() == false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b3, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
        
            if (r6 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b6, code lost:
        
            if (r12 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:
        
            r2 = r17.errors.terminate();
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00be, code lost:
        
            if (r2 == null) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00c0, code lost:
        
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c4, code lost:
        
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00ca, code lost:
        
            if (r10 == 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00cc, code lost:
        
            g.a.y0.j.d.c(r17.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00d6, code lost:
        
            if (r17.maxConcurrency == Integer.MAX_VALUE) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00d8, code lost:
        
            r17.s.request(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
        
            r5 = addAndGet(-r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                Method dump skipped, instructions count: 229
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.z0.a.drainLoop():void");
        }

        g.a.y0.f.c<R> getOrCreateQueue() {
            g.a.y0.f.c<R> cVar;
            do {
                g.a.y0.f.c<R> cVar2 = this.queue.get();
                if (cVar2 != null) {
                    return cVar2;
                }
                cVar = new g.a.y0.f.c<>(g.a.l.Q());
            } while (!this.queue.compareAndSet(null, cVar));
            return cVar;
        }

        void innerComplete(a<T, R>.C0198a c0198a) {
            this.set.c(c0198a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.active.decrementAndGet() == 0;
                    g.a.y0.f.c<R> cVar = this.queue.get();
                    if (z && (cVar == null || cVar.isEmpty())) {
                        Throwable thTerminate = this.errors.terminate();
                        if (thTerminate != null) {
                            this.actual.onError(thTerminate);
                            return;
                        } else {
                            this.actual.onComplete();
                            return;
                        }
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.s.request(1L);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                    return;
                }
            }
            this.active.decrementAndGet();
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
            drain();
        }

        void innerError(a<T, R>.C0198a c0198a, Throwable th) {
            this.set.c(c0198a);
            if (!this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.s.cancel();
                this.set.dispose();
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
            this.active.decrementAndGet();
            drain();
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x007b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void innerSuccess(g.a.y0.e.b.z0.a<T, R>.C0198a r6, R r7) {
            /*
                r5 = this;
                g.a.u0.b r0 = r5.set
                r0.c(r6)
                int r6 = r5.get()
                if (r6 != 0) goto L7b
                r6 = 1
                r0 = 0
                boolean r1 = r5.compareAndSet(r0, r6)
                if (r1 == 0) goto L7b
                java.util.concurrent.atomic.AtomicInteger r1 = r5.active
                int r1 = r1.decrementAndGet()
                if (r1 != 0) goto L1c
                goto L1d
            L1c:
                r6 = 0
            L1d:
                java.util.concurrent.atomic.AtomicLong r0 = r5.requested
                long r0 = r0.get()
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L68
                i.d.c<? super R> r0 = r5.actual
                r0.onNext(r7)
                java.util.concurrent.atomic.AtomicReference<g.a.y0.f.c<R>> r7 = r5.queue
                java.lang.Object r7 = r7.get()
                g.a.y0.f.c r7 = (g.a.y0.f.c) r7
                if (r6 == 0) goto L54
                if (r7 == 0) goto L40
                boolean r6 = r7.isEmpty()
                if (r6 == 0) goto L54
            L40:
                g.a.y0.j.c r6 = r5.errors
                java.lang.Throwable r6 = r6.terminate()
                if (r6 == 0) goto L4e
                i.d.c<? super R> r7 = r5.actual
                r7.onError(r6)
                goto L53
            L4e:
                i.d.c<? super R> r6 = r5.actual
                r6.onComplete()
            L53:
                return
            L54:
                java.util.concurrent.atomic.AtomicLong r6 = r5.requested
                r0 = 1
                g.a.y0.j.d.c(r6, r0)
                int r6 = r5.maxConcurrency
                r7 = 2147483647(0x7fffffff, float:NaN)
                if (r6 == r7) goto L71
                i.d.d r6 = r5.s
                r6.request(r0)
                goto L71
            L68:
                g.a.y0.f.c r6 = r5.getOrCreateQueue()
                monitor-enter(r6)
                r6.offer(r7)     // Catch: java.lang.Throwable -> L78
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L78
            L71:
                int r6 = r5.decrementAndGet()
                if (r6 != 0) goto L90
                return
            L78:
                r7 = move-exception
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L78
                throw r7
            L7b:
                g.a.y0.f.c r6 = r5.getOrCreateQueue()
                monitor-enter(r6)
                r6.offer(r7)     // Catch: java.lang.Throwable -> L94
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L94
                java.util.concurrent.atomic.AtomicInteger r6 = r5.active
                r6.decrementAndGet()
                int r6 = r5.getAndIncrement()
                if (r6 == 0) goto L90
                return
            L90:
                r5.drainLoop()
                return
            L94:
                r7 = move-exception
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L94
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.z0.a.innerSuccess(g.a.y0.e.b.z0$a$a, java.lang.Object):void");
        }

        @Override // i.d.c
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (!this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.set.dispose();
            }
            drain();
        }

        @Override // i.d.c
        public void onNext(T t) {
            try {
                g.a.y yVar = (g.a.y) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                C0198a c0198a = new C0198a();
                if (this.cancelled || !this.set.b(c0198a)) {
                    return;
                }
                yVar.a(c0198a);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    dVar.request(h.q2.t.m0.f16408b);
                } else {
                    dVar.request(i2);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    public z0(g.a.l<T> lVar, g.a.x0.o<? super T, ? extends g.a.y<? extends R>> oVar, boolean z, int i2) {
        super(lVar);
        this.f14733c = oVar;
        this.f14734d = z;
        this.f14735e = i2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super R> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14733c, this.f14734d, this.f14735e));
    }
}
