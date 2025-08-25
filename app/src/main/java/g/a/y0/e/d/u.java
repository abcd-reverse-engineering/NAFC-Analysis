package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableCombineLatest.java */
/* loaded from: classes2.dex */
public final class u<T, R> extends g.a.b0<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<? extends T>[] f15496a;

    /* renamed from: b, reason: collision with root package name */
    final Iterable<? extends g.a.g0<? extends T>> f15497b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super Object[], ? extends R> f15498c;

    /* renamed from: d, reason: collision with root package name */
    final int f15499d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f15500e;

    /* compiled from: ObservableCombineLatest.java */
    static final class a<T, R> extends AtomicReference<g.a.u0.c> implements g.a.i0<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final b<T, R> parent;

        a(b<T, R> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.i0
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.parent.innerNext(this.index, t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }
    }

    /* compiled from: ObservableCombineLatest.java */
    static final class b<T, R> extends AtomicInteger implements g.a.u0.c {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final g.a.i0<? super R> actual;
        volatile boolean cancelled;
        final g.a.x0.o<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final g.a.y0.j.c errors = new g.a.y0.j.c();
        Object[] latest;
        final a<T, R>[] observers;
        final g.a.y0.f.c<Object[]> queue;

        b(g.a.i0<? super R> i0Var, g.a.x0.o<? super Object[], ? extends R> oVar, int i2, int i3, boolean z) {
            this.actual = i0Var;
            this.combiner = oVar;
            this.delayError = z;
            this.latest = new Object[i2];
            a<T, R>[] aVarArr = new a[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                aVarArr[i4] = new a<>(this, i4);
            }
            this.observers = aVarArr;
            this.queue = new g.a.y0.f.c<>(i3);
        }

        void cancelSources() {
            for (a<T, R> aVar : this.observers) {
                aVar.dispose();
            }
        }

        void clear(g.a.y0.f.c<?> cVar) {
            synchronized (this) {
                this.latest = null;
            }
            cVar.clear();
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear(this.queue);
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            g.a.y0.f.c<Object[]> cVar = this.queue;
            g.a.i0<? super R> i0Var = this.actual;
            boolean z = this.delayError;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (!z && this.errors.get() != null) {
                    cancelSources();
                    clear(cVar);
                    i0Var.onError(this.errors.terminate());
                    return;
                }
                boolean z2 = this.done;
                Object[] objArrPoll = cVar.poll();
                boolean z3 = objArrPoll == null;
                if (z2 && z3) {
                    clear(cVar);
                    Throwable thTerminate = this.errors.terminate();
                    if (thTerminate == null) {
                        i0Var.onComplete();
                        return;
                    } else {
                        i0Var.onError(thTerminate);
                        return;
                    }
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        i0Var.onNext((Object) g.a.y0.b.b.a(this.combiner.apply(objArrPoll), "The combiner returned a null value"));
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        this.errors.addThrowable(th);
                        cancelSources();
                        clear(cVar);
                        i0Var.onError(this.errors.terminate());
                        return;
                    }
                }
            }
            clear(cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0019 A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0007, B:12:0x0011, B:15:0x001b, B:14:0x0019), top: B:23:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void innerComplete(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.latest     // Catch: java.lang.Throwable -> L25
                if (r0 != 0) goto L7
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                return
            L7:
                r4 = r0[r4]     // Catch: java.lang.Throwable -> L25
                r1 = 1
                if (r4 != 0) goto Le
                r4 = 1
                goto Lf
            Le:
                r4 = 0
            Lf:
                if (r4 != 0) goto L19
                int r2 = r3.complete     // Catch: java.lang.Throwable -> L25
                int r2 = r2 + r1
                r3.complete = r2     // Catch: java.lang.Throwable -> L25
                int r0 = r0.length     // Catch: java.lang.Throwable -> L25
                if (r2 != r0) goto L1b
            L19:
                r3.done = r1     // Catch: java.lang.Throwable -> L25
            L1b:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                if (r4 == 0) goto L21
                r3.cancelSources()
            L21:
                r3.drain()
                return
            L25:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.d.u.b.innerComplete(int):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0025 A[Catch: all -> 0x0029, TryCatch #0 {, blocks: (B:7:0x000e, B:9:0x0012, B:11:0x0014, B:16:0x001d, B:19:0x0027, B:18:0x0025), top: B:30:0x000e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void innerError(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                g.a.y0.j.c r0 = r2.errors
                boolean r0 = r0.addThrowable(r4)
                if (r0 == 0) goto L36
                boolean r4 = r2.delayError
                r0 = 1
                if (r4 == 0) goto L2c
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.latest     // Catch: java.lang.Throwable -> L29
                if (r4 != 0) goto L14
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
                return
            L14:
                r3 = r4[r3]     // Catch: java.lang.Throwable -> L29
                if (r3 != 0) goto L1a
                r3 = 1
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 != 0) goto L25
                int r1 = r2.complete     // Catch: java.lang.Throwable -> L29
                int r1 = r1 + r0
                r2.complete = r1     // Catch: java.lang.Throwable -> L29
                int r4 = r4.length     // Catch: java.lang.Throwable -> L29
                if (r1 != r4) goto L27
            L25:
                r2.done = r0     // Catch: java.lang.Throwable -> L29
            L27:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
                goto L2d
            L29:
                r3 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
                throw r3
            L2c:
                r3 = 1
            L2d:
                if (r3 == 0) goto L32
                r2.cancelSources()
            L32:
                r2.drain()
                goto L39
            L36:
                g.a.c1.a.b(r4)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.d.u.b.innerError(int, java.lang.Throwable):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        void innerNext(int i2, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i2];
                int i3 = this.active;
                if (obj == null) {
                    i3++;
                    this.active = i3;
                }
                objArr[i2] = t;
                if (i3 == objArr.length) {
                    this.queue.offer(objArr.clone());
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    drain();
                }
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(g.a.g0<? extends T>[] g0VarArr) {
            a<T, R>[] aVarArr = this.observers;
            int length = aVarArr.length;
            this.actual.onSubscribe(this);
            for (int i2 = 0; i2 < length && !this.done && !this.cancelled; i2++) {
                g0VarArr[i2].subscribe(aVarArr[i2]);
            }
        }
    }

    public u(g.a.g0<? extends T>[] g0VarArr, Iterable<? extends g.a.g0<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar, int i2, boolean z) {
        this.f15496a = g0VarArr;
        this.f15497b = iterable;
        this.f15498c = oVar;
        this.f15499d = i2;
        this.f15500e = z;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super R> i0Var) {
        int length;
        g.a.g0<? extends T>[] g0VarArr = this.f15496a;
        if (g0VarArr == null) {
            g0VarArr = new g.a.b0[8];
            length = 0;
            for (g.a.g0<? extends T> g0Var : this.f15497b) {
                if (length == g0VarArr.length) {
                    g.a.g0<? extends T>[] g0VarArr2 = new g.a.g0[(length >> 2) + length];
                    System.arraycopy(g0VarArr, 0, g0VarArr2, 0, length);
                    g0VarArr = g0VarArr2;
                }
                g0VarArr[length] = g0Var;
                length++;
            }
        } else {
            length = g0VarArr.length;
        }
        int i2 = length;
        if (i2 == 0) {
            g.a.y0.a.e.complete(i0Var);
        } else {
            new b(i0Var, this.f15498c, i2, this.f15499d, this.f15500e).subscribe(g0VarArr);
        }
    }
}
