package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMapMaybe.java */
/* loaded from: classes2.dex */
public final class x0<T, R> extends g.a.y0.e.d.a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.y<? extends R>> f15572b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f15573c;

    /* compiled from: ObservableFlatMapMaybe.java */
    static final class a<T, R> extends AtomicInteger implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = 8600231336733376951L;
        final g.a.i0<? super R> actual;
        volatile boolean cancelled;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15574d;
        final boolean delayErrors;
        final g.a.x0.o<? super T, ? extends g.a.y<? extends R>> mapper;
        final g.a.u0.b set = new g.a.u0.b();
        final g.a.y0.j.c errors = new g.a.y0.j.c();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<g.a.y0.f.c<R>> queue = new AtomicReference<>();

        /* compiled from: ObservableFlatMapMaybe.java */
        /* renamed from: g.a.y0.e.d.x0$a$a, reason: collision with other inner class name */
        final class C0220a extends AtomicReference<g.a.u0.c> implements g.a.v<R>, g.a.u0.c {
            private static final long serialVersionUID = -502562646270949838L;

            C0220a() {
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

        a(g.a.i0<? super R> i0Var, g.a.x0.o<? super T, ? extends g.a.y<? extends R>> oVar, boolean z) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.delayErrors = z;
        }

        void clear() {
            g.a.y0.f.c<R> cVar = this.queue.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.cancelled = true;
            this.f15574d.dispose();
            this.set.dispose();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            g.a.i0<? super R> i0Var = this.actual;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<g.a.y0.f.c<R>> atomicReference = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (!this.delayErrors && this.errors.get() != null) {
                    Throwable thTerminate = this.errors.terminate();
                    clear();
                    i0Var.onError(thTerminate);
                    return;
                }
                boolean z = atomicInteger.get() == 0;
                g.a.y0.f.c<R> cVar = atomicReference.get();
                a.a.a aVarPoll = cVar != null ? cVar.poll() : null;
                boolean z2 = aVarPoll == null;
                if (z && z2) {
                    Throwable thTerminate2 = this.errors.terminate();
                    if (thTerminate2 != null) {
                        i0Var.onError(thTerminate2);
                        return;
                    } else {
                        i0Var.onComplete();
                        return;
                    }
                }
                if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    i0Var.onNext(aVarPoll);
                }
            }
            clear();
        }

        g.a.y0.f.c<R> getOrCreateQueue() {
            g.a.y0.f.c<R> cVar;
            do {
                g.a.y0.f.c<R> cVar2 = this.queue.get();
                if (cVar2 != null) {
                    return cVar2;
                }
                cVar = new g.a.y0.f.c<>(g.a.b0.L());
            } while (!this.queue.compareAndSet(null, cVar));
            return cVar;
        }

        void innerComplete(a<T, R>.C0220a c0220a) {
            this.set.c(c0220a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.active.decrementAndGet() == 0;
                    g.a.y0.f.c<R> cVar = this.queue.get();
                    if (!z || (cVar != null && !cVar.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        drainLoop();
                        return;
                    } else {
                        Throwable thTerminate = this.errors.terminate();
                        if (thTerminate != null) {
                            this.actual.onError(thTerminate);
                            return;
                        } else {
                            this.actual.onComplete();
                            return;
                        }
                    }
                }
            }
            this.active.decrementAndGet();
            drain();
        }

        void innerError(a<T, R>.C0220a c0220a, Throwable th) {
            this.set.c(c0220a);
            if (!this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.f15574d.dispose();
                this.set.dispose();
            }
            this.active.decrementAndGet();
            drain();
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void innerSuccess(g.a.y0.e.d.x0.a<T, R>.C0220a r3, R r4) {
            /*
                r2 = this;
                g.a.u0.b r0 = r2.set
                r0.c(r3)
                int r3 = r2.get()
                if (r3 != 0) goto L4f
                r3 = 1
                r0 = 0
                boolean r1 = r2.compareAndSet(r0, r3)
                if (r1 == 0) goto L4f
                g.a.i0<? super R> r1 = r2.actual
                r1.onNext(r4)
                java.util.concurrent.atomic.AtomicInteger r4 = r2.active
                int r4 = r4.decrementAndGet()
                if (r4 != 0) goto L21
                goto L22
            L21:
                r3 = 0
            L22:
                java.util.concurrent.atomic.AtomicReference<g.a.y0.f.c<R>> r4 = r2.queue
                java.lang.Object r4 = r4.get()
                g.a.y0.f.c r4 = (g.a.y0.f.c) r4
                if (r3 == 0) goto L48
                if (r4 == 0) goto L34
                boolean r3 = r4.isEmpty()
                if (r3 == 0) goto L48
            L34:
                g.a.y0.j.c r3 = r2.errors
                java.lang.Throwable r3 = r3.terminate()
                if (r3 == 0) goto L42
                g.a.i0<? super R> r4 = r2.actual
                r4.onError(r3)
                goto L47
            L42:
                g.a.i0<? super R> r3 = r2.actual
                r3.onComplete()
            L47:
                return
            L48:
                int r3 = r2.decrementAndGet()
                if (r3 != 0) goto L64
                return
            L4f:
                g.a.y0.f.c r3 = r2.getOrCreateQueue()
                monitor-enter(r3)
                r3.offer(r4)     // Catch: java.lang.Throwable -> L68
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L68
                java.util.concurrent.atomic.AtomicInteger r3 = r2.active
                r3.decrementAndGet()
                int r3 = r2.getAndIncrement()
                if (r3 == 0) goto L64
                return
            L64:
                r2.drainLoop()
                return
            L68:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L68
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.d.x0.a.innerSuccess(g.a.y0.e.d.x0$a$a, java.lang.Object):void");
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // g.a.i0
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

        @Override // g.a.i0
        public void onNext(T t) {
            try {
                g.a.y yVar = (g.a.y) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                C0220a c0220a = new C0220a();
                if (this.cancelled || !this.set.b(c0220a)) {
                    return;
                }
                yVar.a(c0220a);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15574d.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15574d, cVar)) {
                this.f15574d = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public x0(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends g.a.y<? extends R>> oVar, boolean z) {
        super(g0Var);
        this.f15572b = oVar;
        this.f15573c = z;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super R> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15572b, this.f15573c));
    }
}
