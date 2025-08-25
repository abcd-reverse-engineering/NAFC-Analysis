package g.a.y0.e.d;

import g.a.j0;

/* compiled from: ObservableObserveOn.java */
/* loaded from: classes2.dex */
public final class y1<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f15586b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f15587c;

    /* renamed from: d, reason: collision with root package name */
    final int f15588d;

    /* compiled from: ObservableObserveOn.java */
    static final class a<T> extends g.a.y0.d.b<T> implements g.a.i0<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final g.a.i0<? super T> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        boolean outputFused;
        g.a.y0.c.o<T> queue;
        g.a.u0.c s;
        int sourceMode;
        final j0.c worker;

        a(g.a.i0<? super T> i0Var, j0.c cVar, boolean z, int i2) {
            this.actual = i0Var;
            this.worker = cVar;
            this.delayError = z;
            this.bufferSize = i2;
        }

        boolean checkTerminated(boolean z, boolean z2, g.a.i0<? super T> i0Var) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                if (th != null) {
                    i0Var.onError(th);
                } else {
                    i0Var.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            if (th != null) {
                this.queue.clear();
                i0Var.onError(th);
                this.worker.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            i0Var.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.queue.clear();
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drainFused() {
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                Throwable th = this.error;
                if (!this.delayError && z && th != null) {
                    this.actual.onError(th);
                    this.worker.dispose();
                    return;
                }
                this.actual.onNext(null);
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.actual.onError(th2);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        
            if (r3 != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainNormal() {
            /*
                r7 = this;
                g.a.y0.c.o<T> r0 = r7.queue
                g.a.i0<? super T> r1 = r7.actual
                r2 = 1
                r3 = 1
            L6:
                boolean r4 = r7.done
                boolean r5 = r0.isEmpty()
                boolean r4 = r7.checkTerminated(r4, r5, r1)
                if (r4 == 0) goto L13
                return
            L13:
                boolean r4 = r7.done
                java.lang.Object r5 = r0.poll()     // Catch: java.lang.Throwable -> L33
                if (r5 != 0) goto L1d
                r6 = 1
                goto L1e
            L1d:
                r6 = 0
            L1e:
                boolean r4 = r7.checkTerminated(r4, r6, r1)
                if (r4 == 0) goto L25
                return
            L25:
                if (r6 == 0) goto L2f
                int r3 = -r3
                int r3 = r7.addAndGet(r3)
                if (r3 != 0) goto L6
                return
            L2f:
                r1.onNext(r5)
                goto L13
            L33:
                r2 = move-exception
                g.a.v0.b.b(r2)
                g.a.u0.c r3 = r7.s
                r3.dispose()
                r0.clear()
                r1.onError(r2)
                g.a.j0$c r0 = r7.worker
                r0.dispose()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.d.y1.a.drainNormal():void");
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            schedule();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                if (cVar instanceof g.a.y0.c.j) {
                    g.a.y0.c.j jVar = (g.a.y0.c.j) cVar;
                    int iRequestFusion = jVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = jVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        schedule();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = jVar;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new g.a.y0.f.c(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.a(this);
            }
        }
    }

    public y1(g.a.g0<T> g0Var, g.a.j0 j0Var, boolean z, int i2) {
        super(g0Var);
        this.f15586b = j0Var;
        this.f15587c = z;
        this.f15588d = i2;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        g.a.j0 j0Var = this.f15586b;
        if (j0Var instanceof g.a.y0.g.r) {
            this.f14934a.subscribe(i0Var);
        } else {
            this.f14934a.subscribe(new a(i0Var, j0Var.a(), this.f15587c, this.f15588d));
        }
    }
}
