package g.a.y0.e.e;

import g.a.q;
import h.q2.t.m0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ParallelJoin.java */
/* loaded from: classes2.dex */
public final class i<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.b1.b<? extends T> f15674b;

    /* renamed from: c, reason: collision with root package name */
    final int f15675c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f15676d;

    /* compiled from: ParallelJoin.java */
    static final class a<T> extends AtomicReference<i.d.d> implements q<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final c<T> parent;
        final int prefetch;
        long produced;
        volatile g.a.y0.c.n<T> queue;

        a(c<T> cVar, int i2) {
            this.parent = cVar;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        public boolean cancel() {
            return g.a.y0.i.j.cancel(this);
        }

        g.a.y0.c.n<T> getQueue() {
            g.a.y0.c.n<T> nVar = this.queue;
            if (nVar != null) {
                return nVar;
            }
            g.a.y0.f.b bVar = new g.a.y0.f.b(this.prefetch);
            this.queue = bVar;
            return bVar;
        }

        @Override // i.d.c
        public void onComplete() {
            this.parent.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.parent.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.parent.onNext(this, t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(this.prefetch);
            }
        }

        public void request(long j2) {
            long j3 = this.produced + j2;
            if (j3 < this.limit) {
                this.produced = j3;
            } else {
                this.produced = 0L;
                get().request(j3);
            }
        }

        public void requestOne() {
            long j2 = this.produced + 1;
            if (j2 != this.limit) {
                this.produced = j2;
            } else {
                this.produced = 0L;
                get().request(j2);
            }
        }
    }

    /* compiled from: ParallelJoin.java */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        b(i.d.c<? super T> cVar, int i2, int i3) {
            super(cVar, i2, i3);
        }

        @Override // g.a.y0.e.e.i.c
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
        
            if (r13 == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
        
            if (r11 == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
        
            if (r11 == false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
        
            r10 = r14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                Method dump skipped, instructions count: 216
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.e.i.b.drainLoop():void");
        }

        @Override // g.a.y0.e.e.i.c
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // g.a.y0.e.e.i.c
        public void onError(Throwable th) {
            if (this.errors.compareAndSet(null, th)) {
                cancelAll();
                drain();
            } else if (th != this.errors.get()) {
                g.a.c1.a.b(th);
            }
        }

        @Override // g.a.y0.e.e.i.c
        public void onNext(a<T> aVar, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != m0.f16408b) {
                        this.requested.decrementAndGet();
                    }
                    aVar.request(1L);
                } else if (!aVar.getQueue().offer(t)) {
                    cancelAll();
                    g.a.v0.c cVar = new g.a.v0.c("Queue full?!");
                    if (this.errors.compareAndSet(null, cVar)) {
                        this.actual.onError(cVar);
                        return;
                    } else {
                        g.a.c1.a.b(cVar);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!aVar.getQueue().offer(t)) {
                cancelAll();
                onError(new g.a.v0.c("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }
    }

    /* compiled from: ParallelJoin.java */
    static abstract class c<T> extends AtomicInteger implements i.d.d {
        private static final long serialVersionUID = 3100232009247827843L;
        final i.d.c<? super T> actual;
        volatile boolean cancelled;
        final a<T>[] subscribers;
        final g.a.y0.j.c errors = new g.a.y0.j.c();
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger done = new AtomicInteger();

        c(i.d.c<? super T> cVar, int i2, int i3) {
            this.actual = cVar;
            a<T>[] aVarArr = new a[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                aVarArr[i4] = new a<>(this, i3);
            }
            this.subscribers = aVarArr;
            this.done.lazySet(i2);
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                cleanup();
            }
        }

        void cancelAll() {
            int i2 = 0;
            while (true) {
                a<T>[] aVarArr = this.subscribers;
                if (i2 >= aVarArr.length) {
                    return;
                }
                aVarArr[i2].cancel();
                i2++;
            }
        }

        void cleanup() {
            int i2 = 0;
            while (true) {
                a<T>[] aVarArr = this.subscribers;
                if (i2 >= aVarArr.length) {
                    return;
                }
                aVarArr[i2].queue = null;
                i2++;
            }
        }

        abstract void drain();

        abstract void onComplete();

        abstract void onError(Throwable th);

        abstract void onNext(a<T> aVar, T t);

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    /* compiled from: ParallelJoin.java */
    static final class d<T> extends c<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        d(i.d.c<? super T> cVar, int i2, int i3) {
            super(cVar, i2, i3);
        }

        @Override // g.a.y0.e.e.i.c
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        
            if (r13 == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
        
            if (r11 == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
        
            if (r17.errors.get() == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005b, code lost:
        
            r3.onError(r17.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0065, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
        
            if (r11 == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x006b, code lost:
        
            r10 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                Method dump skipped, instructions count: 221
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.e.i.d.drainLoop():void");
        }

        @Override // g.a.y0.e.e.i.c
        void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // g.a.y0.e.e.i.c
        void onError(Throwable th) {
            this.errors.addThrowable(th);
            this.done.decrementAndGet();
            drain();
        }

        @Override // g.a.y0.e.e.i.c
        void onNext(a<T> aVar, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != m0.f16408b) {
                        this.requested.decrementAndGet();
                    }
                    aVar.request(1L);
                } else if (!aVar.getQueue().offer(t)) {
                    aVar.cancel();
                    this.errors.addThrowable(new g.a.v0.c("Queue full?!"));
                    this.done.decrementAndGet();
                    drainLoop();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                if (!aVar.getQueue().offer(t) && aVar.cancel()) {
                    this.errors.addThrowable(new g.a.v0.c("Queue full?!"));
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }
    }

    public i(g.a.b1.b<? extends T> bVar, int i2, boolean z) {
        this.f15674b = bVar;
        this.f15675c = i2;
        this.f15676d = z;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        c dVar = this.f15676d ? new d(cVar, this.f15674b.a(), this.f15675c) : new b(cVar, this.f15674b.a(), this.f15675c);
        cVar.onSubscribe(dVar);
        this.f15674b.a(dVar.subscribers);
    }
}
