package g.a.y0.e.b;

import g.a.y0.e.b.y1;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableCombineLatest.java */
/* loaded from: classes2.dex */
public final class u<T, R> extends g.a.l<R> {

    /* renamed from: b, reason: collision with root package name */
    @g.a.t0.g
    final i.d.b<? extends T>[] f14642b;

    /* renamed from: c, reason: collision with root package name */
    @g.a.t0.g
    final Iterable<? extends i.d.b<? extends T>> f14643c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.o<? super Object[], ? extends R> f14644d;

    /* renamed from: e, reason: collision with root package name */
    final int f14645e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f14646f;

    /* compiled from: FlowableCombineLatest.java */
    static final class a<T, R> extends g.a.y0.i.c<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        final i.d.c<? super R> actual;
        volatile boolean cancelled;
        final g.a.x0.o<? super Object[], ? extends R> combiner;
        int completedSources;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final g.a.y0.f.c<Object> queue;
        final AtomicLong requested;
        final b<T>[] subscribers;

        a(i.d.c<? super R> cVar, g.a.x0.o<? super Object[], ? extends R> oVar, int i2, int i3, boolean z) {
            this.actual = cVar;
            this.combiner = oVar;
            b<T>[] bVarArr = new b[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                bVarArr[i4] = new b<>(this, i4, i3);
            }
            this.subscribers = bVarArr;
            this.latest = new Object[i2];
            this.queue = new g.a.y0.f.c<>(i3);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
            this.delayErrors = z;
        }

        @Override // i.d.d
        public void cancel() {
            this.cancelled = true;
            cancelAll();
        }

        void cancelAll() {
            for (b<T> bVar : this.subscribers) {
                bVar.cancel();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, i.d.c<?> cVar, g.a.y0.f.c<?> cVar2) {
            if (this.cancelled) {
                cancelAll();
                cVar2.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.delayErrors) {
                if (!z2) {
                    return false;
                }
                cancelAll();
                Throwable thA = g.a.y0.j.k.a(this.error);
                if (thA == null || thA == g.a.y0.j.k.f16046a) {
                    cVar.onComplete();
                } else {
                    cVar.onError(thA);
                }
                return true;
            }
            Throwable thA2 = g.a.y0.j.k.a(this.error);
            if (thA2 != null && thA2 != g.a.y0.j.k.f16046a) {
                cancelAll();
                cVar2.clear();
                cVar.onError(thA2);
                return true;
            }
            if (!z2) {
                return false;
            }
            cancelAll();
            cVar.onComplete();
            return true;
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainOutput();
            } else {
                drainAsync();
            }
        }

        void drainAsync() {
            i.d.c<? super R> cVar = this.actual;
            g.a.y0.f.c<?> cVar2 = this.queue;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    boolean z = this.done;
                    Object objPoll = cVar2.poll();
                    boolean z2 = objPoll == null;
                    if (checkTerminated(z, z2, cVar, cVar2)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    try {
                        cVar.onNext((Object) g.a.y0.b.b.a(this.combiner.apply((Object[]) cVar2.poll()), "The combiner returned a null value"));
                        ((b) objPoll).requestOne();
                        j3++;
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        cancelAll();
                        g.a.y0.j.k.a(this.error, th);
                        cVar.onError(g.a.y0.j.k.a(this.error));
                        return;
                    }
                }
                if (j3 == j2 && checkTerminated(this.done, cVar2.isEmpty(), cVar, cVar2)) {
                    return;
                }
                if (j3 != 0 && j2 != h.q2.t.m0.f16408b) {
                    this.requested.addAndGet(-j3);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        void drainOutput() {
            i.d.c<? super R> cVar = this.actual;
            g.a.y0.f.c<Object> cVar2 = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    cVar2.clear();
                    cVar.onError(th);
                    return;
                }
                boolean z = this.done;
                boolean zIsEmpty = cVar2.isEmpty();
                if (!zIsEmpty) {
                    cVar.onNext(null);
                }
                if (z && zIsEmpty) {
                    cVar.onComplete();
                    return;
                } else {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            cVar2.clear();
        }

        void innerComplete(int i2) {
            int i3;
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr[i2] != null && (i3 = this.completedSources + 1) != objArr.length) {
                    this.completedSources = i3;
                } else {
                    this.done = true;
                    drain();
                }
            }
        }

        void innerError(int i2, Throwable th) {
            if (!g.a.y0.j.k.a(this.error, th)) {
                g.a.c1.a.b(th);
            } else {
                if (this.delayErrors) {
                    innerComplete(i2);
                    return;
                }
                cancelAll();
                this.done = true;
                drain();
            }
        }

        void innerValue(int i2, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.latest;
                int i3 = this.nonEmptySources;
                if (objArr[i2] == null) {
                    i3++;
                    this.nonEmptySources = i3;
                }
                objArr[i2] = t;
                if (objArr.length == i3) {
                    this.queue.offer(this.subscribers[i2], objArr.clone());
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                this.subscribers[i2].requestOne();
            } else {
                drain();
            }
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public R poll() throws Exception {
            Object objPoll = this.queue.poll();
            if (objPoll == null) {
                return null;
            }
            R r = (R) g.a.y0.b.b.a(this.combiner.apply((Object[]) this.queue.poll()), "The combiner returned a null value");
            ((b) objPoll).requestOne();
            return r;
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 4) != 0) {
                return 0;
            }
            int i3 = i2 & 2;
            this.outputFused = i3 != 0;
            return i3;
        }

        void subscribe(i.d.b<? extends T>[] bVarArr, int i2) {
            b<T>[] bVarArr2 = this.subscribers;
            for (int i3 = 0; i3 < i2 && !this.done && !this.cancelled; i3++) {
                bVarArr[i3].subscribe(bVarArr2[i3]);
            }
        }
    }

    /* compiled from: FlowableCombineLatest.java */
    static final class b<T> extends AtomicReference<i.d.d> implements g.a.q<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        final int index;
        final int limit;
        final a<T, ?> parent;
        final int prefetch;
        int produced;

        b(a<T, ?> aVar, int i2, int i3) {
            this.parent = aVar;
            this.index = i2;
            this.prefetch = i3;
            this.limit = i3 - (i3 >> 2);
        }

        public void cancel() {
            g.a.y0.i.j.cancel(this);
        }

        @Override // i.d.c
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.parent.innerValue(this.index, t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(this.prefetch);
            }
        }

        public void requestOne() {
            int i2 = this.produced + 1;
            if (i2 != this.limit) {
                this.produced = i2;
            } else {
                this.produced = 0;
                get().request(i2);
            }
        }
    }

    /* compiled from: FlowableCombineLatest.java */
    final class c implements g.a.x0.o<T, R> {
        c() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // g.a.x0.o
        public R apply(T t) throws Exception {
            return u.this.f14644d.apply(new Object[]{t});
        }
    }

    public u(@g.a.t0.f i.d.b<? extends T>[] bVarArr, @g.a.t0.f g.a.x0.o<? super Object[], ? extends R> oVar, int i2, boolean z) {
        this.f14642b = bVarArr;
        this.f14643c = null;
        this.f14644d = oVar;
        this.f14645e = i2;
        this.f14646f = z;
    }

    @Override // g.a.l
    public void d(i.d.c<? super R> cVar) {
        int length;
        i.d.b<? extends T>[] bVarArr = this.f14642b;
        if (bVarArr == null) {
            bVarArr = new i.d.b[8];
            try {
                Iterator it = (Iterator) g.a.y0.b.b.a(this.f14643c.iterator(), "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            i.d.b<? extends T> bVar = (i.d.b) g.a.y0.b.b.a(it.next(), "The publisher returned by the iterator is null");
                            if (length == bVarArr.length) {
                                i.d.b<? extends T>[] bVarArr2 = new i.d.b[(length >> 2) + length];
                                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                                bVarArr = bVarArr2;
                            }
                            bVarArr[length] = bVar;
                            length++;
                        } catch (Throwable th) {
                            g.a.v0.b.b(th);
                            g.a.y0.i.g.error(th, cVar);
                            return;
                        }
                    } catch (Throwable th2) {
                        g.a.v0.b.b(th2);
                        g.a.y0.i.g.error(th2, cVar);
                        return;
                    }
                }
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                g.a.y0.i.g.error(th3, cVar);
                return;
            }
        } else {
            length = bVarArr.length;
        }
        if (length == 0) {
            g.a.y0.i.g.complete(cVar);
            return;
        }
        if (length == 1) {
            bVarArr[0].subscribe(new y1.b(cVar, new c()));
            return;
        }
        a aVar = new a(cVar, this.f14644d, length, this.f14645e, this.f14646f);
        cVar.onSubscribe(aVar);
        aVar.subscribe(bVarArr, length);
    }

    public u(@g.a.t0.f Iterable<? extends i.d.b<? extends T>> iterable, @g.a.t0.f g.a.x0.o<? super Object[], ? extends R> oVar, int i2, boolean z) {
        this.f14642b = null;
        this.f14643c = iterable;
        this.f14644d = oVar;
        this.f14645e = i2;
        this.f14646f = z;
    }
}
