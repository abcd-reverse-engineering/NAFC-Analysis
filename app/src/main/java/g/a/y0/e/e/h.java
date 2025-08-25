package g.a.y0.e.e;

import g.a.q;
import h.q2.t.m0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: ParallelFromPublisher.java */
/* loaded from: classes2.dex */
public final class h<T> extends g.a.b1.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.d.b<? extends T> f15668a;

    /* renamed from: b, reason: collision with root package name */
    final int f15669b;

    /* renamed from: c, reason: collision with root package name */
    final int f15670c;

    /* compiled from: ParallelFromPublisher.java */
    static final class a<T> extends AtomicInteger implements q<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        volatile boolean cancelled;
        volatile boolean done;
        final long[] emissions;
        Throwable error;
        int index;
        final int limit;
        final int prefetch;
        int produced;
        g.a.y0.c.o<T> queue;
        final AtomicLongArray requests;
        i.d.d s;
        int sourceMode;
        final AtomicInteger subscriberCount = new AtomicInteger();
        final i.d.c<? super T>[] subscribers;

        /* compiled from: ParallelFromPublisher.java */
        /* renamed from: g.a.y0.e.e.h$a$a, reason: collision with other inner class name */
        final class C0224a implements i.d.d {

            /* renamed from: a, reason: collision with root package name */
            final int f15671a;

            /* renamed from: b, reason: collision with root package name */
            final int f15672b;

            C0224a(int i2, int i3) {
                this.f15671a = i2;
                this.f15672b = i3;
            }

            @Override // i.d.d
            public void cancel() {
                if (a.this.requests.compareAndSet(this.f15671a + this.f15672b, 0L, 1L)) {
                    a aVar = a.this;
                    int i2 = this.f15672b;
                    aVar.cancel(i2 + i2);
                }
            }

            @Override // i.d.d
            public void request(long j2) {
                long j3;
                if (g.a.y0.i.j.validate(j2)) {
                    AtomicLongArray atomicLongArray = a.this.requests;
                    do {
                        j3 = atomicLongArray.get(this.f15671a);
                        if (j3 == m0.f16408b) {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.f15671a, j3, g.a.y0.j.d.a(j3, j2)));
                    if (a.this.subscriberCount.get() == this.f15672b) {
                        a.this.drain();
                    }
                }
            }
        }

        a(i.d.c<? super T>[] cVarArr, int i2) {
            this.subscribers = cVarArr;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
            int length = cVarArr.length;
            int i3 = length + length;
            this.requests = new AtomicLongArray(i3 + 1);
            this.requests.lazySet(i3, length);
            this.emissions = new long[length];
        }

        void cancel(int i2) {
            if (this.requests.decrementAndGet(i2) == 0) {
                this.cancelled = true;
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.sourceMode == 1) {
                drainSync();
            } else {
                drainAsync();
            }
        }

        void drainAsync() {
            Throwable th;
            g.a.y0.c.o<T> oVar = this.queue;
            i.d.c<? super T>[] cVarArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i2 = this.index;
            int i3 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                int i4 = 0;
                int i5 = i3;
                int i6 = 0;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        oVar.clear();
                        int length2 = cVarArr.length;
                        while (i4 < length2) {
                            cVarArr[i4].onError(th);
                            i4++;
                        }
                        return;
                    }
                    boolean zIsEmpty = oVar.isEmpty();
                    if (z && zIsEmpty) {
                        int length3 = cVarArr.length;
                        while (i4 < length3) {
                            cVarArr[i4].onComplete();
                            i4++;
                        }
                        return;
                    }
                    if (!zIsEmpty) {
                        long j2 = atomicLongArray.get(i2);
                        long j3 = jArr[i2];
                        if (j2 == j3 || atomicLongArray.get(length + i2) != 0) {
                            i6++;
                        } else {
                            try {
                                T tPoll = oVar.poll();
                                if (tPoll != null) {
                                    cVarArr[i2].onNext(tPoll);
                                    jArr[i2] = j3 + 1;
                                    int i7 = i5 + 1;
                                    if (i7 == this.limit) {
                                        this.s.request(i7);
                                        i7 = 0;
                                    }
                                    i5 = i7;
                                    i6 = 0;
                                }
                            } catch (Throwable th2) {
                                g.a.v0.b.b(th2);
                                this.s.cancel();
                                int length4 = cVarArr.length;
                                while (i4 < length4) {
                                    cVarArr[i4].onError(th2);
                                    i4++;
                                }
                                return;
                            }
                        }
                        i2++;
                        if (i2 == length) {
                            i2 = 0;
                        }
                        if (i6 == length) {
                        }
                    }
                    i3 = i5;
                    int i8 = get();
                    if (i8 == iAddAndGet) {
                        this.index = i2;
                        this.produced = i3;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i8;
                    }
                }
                oVar.clear();
                return;
            }
        }

        void drainSync() {
            g.a.y0.c.o<T> oVar = this.queue;
            i.d.c<? super T>[] cVarArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i2 = this.index;
            int iAddAndGet = 1;
            while (true) {
                int i3 = 0;
                int i4 = 0;
                while (!this.cancelled) {
                    if (oVar.isEmpty()) {
                        int length2 = cVarArr.length;
                        while (i3 < length2) {
                            cVarArr[i3].onComplete();
                            i3++;
                        }
                        return;
                    }
                    long j2 = atomicLongArray.get(i2);
                    long j3 = jArr[i2];
                    if (j2 == j3 || atomicLongArray.get(length + i2) != 0) {
                        i4++;
                    } else {
                        try {
                            T tPoll = oVar.poll();
                            if (tPoll == null) {
                                int length3 = cVarArr.length;
                                while (i3 < length3) {
                                    cVarArr[i3].onComplete();
                                    i3++;
                                }
                                return;
                            }
                            cVarArr[i2].onNext(tPoll);
                            jArr[i2] = j3 + 1;
                            i4 = 0;
                        } catch (Throwable th) {
                            g.a.v0.b.b(th);
                            this.s.cancel();
                            int length4 = cVarArr.length;
                            while (i3 < length4) {
                                cVarArr[i3].onError(th);
                                i3++;
                            }
                            return;
                        }
                    }
                    i2++;
                    if (i2 == length) {
                        i2 = 0;
                    }
                    if (i4 == length) {
                        int i5 = get();
                        if (i5 == iAddAndGet) {
                            this.index = i2;
                            iAddAndGet = addAndGet(-iAddAndGet);
                            if (iAddAndGet == 0) {
                                return;
                            }
                        } else {
                            iAddAndGet = i5;
                        }
                    }
                }
                oVar.clear();
                return;
            }
        }

        @Override // i.d.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                drain();
            } else {
                this.s.cancel();
                onError(new g.a.v0.c("Queue is full?"));
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof g.a.y0.c.l) {
                    g.a.y0.c.l lVar = (g.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        setupSubscribers();
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        setupSubscribers();
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new g.a.y0.f.b(this.prefetch);
                setupSubscribers();
                dVar.request(this.prefetch);
            }
        }

        void setupSubscribers() {
            i.d.c<? super T>[] cVarArr = this.subscribers;
            int length = cVarArr.length;
            int i2 = 0;
            while (i2 < length && !this.cancelled) {
                int i3 = i2 + 1;
                this.subscriberCount.lazySet(i3);
                cVarArr[i2].onSubscribe(new C0224a(i2, length));
                i2 = i3;
            }
        }
    }

    public h(i.d.b<? extends T> bVar, int i2, int i3) {
        this.f15668a = bVar;
        this.f15669b = i2;
        this.f15670c = i3;
    }

    @Override // g.a.b1.b
    public int a() {
        return this.f15669b;
    }

    @Override // g.a.b1.b
    public void a(i.d.c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            this.f15668a.subscribe(new a(cVarArr, this.f15670c));
        }
    }
}
