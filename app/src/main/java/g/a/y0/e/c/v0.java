package g.a.y0.e.c;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: MaybeMergeArray.java */
/* loaded from: classes2.dex */
public final class v0<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.y<? extends T>[] f14909b;

    /* compiled from: MaybeMergeArray.java */
    static final class a<T> extends ConcurrentLinkedQueue<T> implements d<T> {
        private static final long serialVersionUID = -4025173261791142821L;
        int consumerIndex;
        final AtomicInteger producerIndex = new AtomicInteger();

        a() {
        }

        @Override // g.a.y0.e.c.v0.d
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // g.a.y0.e.c.v0.d
        public void drop() {
            poll();
        }

        @Override // g.a.y0.c.o
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, g.a.y0.e.c.v0.d, g.a.y0.c.o
        @g.a.t0.g
        public T poll() {
            T t = (T) super.poll();
            if (t != null) {
                this.consumerIndex++;
            }
            return t;
        }

        @Override // g.a.y0.e.c.v0.d
        public int producerIndex() {
            return this.producerIndex.get();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, g.a.y0.c.o
        public boolean offer(T t) {
            this.producerIndex.getAndIncrement();
            return super.offer(t);
        }
    }

    /* compiled from: MaybeMergeArray.java */
    static final class b<T> extends g.a.y0.i.c<T> implements g.a.v<T> {
        private static final long serialVersionUID = -660395290758764731L;
        final i.d.c<? super T> actual;
        volatile boolean cancelled;
        long consumed;
        boolean outputFused;
        final d<Object> queue;
        final int sourceCount;
        final g.a.u0.b set = new g.a.u0.b();
        final AtomicLong requested = new AtomicLong();
        final g.a.y0.j.c error = new g.a.y0.j.c();

        b(i.d.c<? super T> cVar, int i2, d<Object> dVar) {
            this.actual = cVar;
            this.sourceCount = i2;
            this.queue = dVar;
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.set.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
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
                drainFused();
            } else {
                drainNormal();
            }
        }

        void drainFused() {
            i.d.c<? super T> cVar = this.actual;
            d<Object> dVar = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    dVar.clear();
                    cVar.onError(th);
                    return;
                }
                boolean z = dVar.producerIndex() == this.sourceCount;
                if (!dVar.isEmpty()) {
                    cVar.onNext(null);
                }
                if (z) {
                    cVar.onComplete();
                    return;
                } else {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            dVar.clear();
        }

        void drainNormal() {
            i.d.c<? super T> cVar = this.actual;
            d<Object> dVar = this.queue;
            long j2 = this.consumed;
            int iAddAndGet = 1;
            do {
                long j3 = this.requested.get();
                while (j2 != j3) {
                    if (this.cancelled) {
                        dVar.clear();
                        return;
                    }
                    if (this.error.get() != null) {
                        dVar.clear();
                        cVar.onError(this.error.terminate());
                        return;
                    } else {
                        if (dVar.consumerIndex() == this.sourceCount) {
                            cVar.onComplete();
                            return;
                        }
                        Object objPoll = dVar.poll();
                        if (objPoll == null) {
                            break;
                        } else if (objPoll != g.a.y0.j.q.COMPLETE) {
                            cVar.onNext(objPoll);
                            j2++;
                        }
                    }
                }
                if (j2 == j3) {
                    if (this.error.get() != null) {
                        dVar.clear();
                        cVar.onError(this.error.terminate());
                        return;
                    } else {
                        while (dVar.peek() == g.a.y0.j.q.COMPLETE) {
                            dVar.drop();
                        }
                        if (dVar.consumerIndex() == this.sourceCount) {
                            cVar.onComplete();
                            return;
                        }
                    }
                }
                this.consumed = j2;
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        boolean isCancelled() {
            return this.cancelled;
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // g.a.v
        public void onComplete() {
            this.queue.offer(g.a.y0.j.q.COMPLETE);
            drain();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            if (!this.error.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            this.set.dispose();
            this.queue.offer(g.a.y0.j.q.COMPLETE);
            drain();
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            this.set.b(cVar);
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            T t;
            do {
                t = (T) this.queue.poll();
            } while (t == g.a.y0.j.q.COMPLETE);
            return t;
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
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    /* compiled from: MaybeMergeArray.java */
    interface d<T> extends g.a.y0.c.o<T> {
        int consumerIndex();

        void drop();

        T peek();

        @Override // java.util.Queue, g.a.y0.e.c.v0.d, g.a.y0.c.o
        @g.a.t0.g
        T poll();

        int producerIndex();
    }

    public v0(g.a.y<? extends T>[] yVarArr) {
        this.f14909b = yVarArr;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        g.a.y[] yVarArr = this.f14909b;
        int length = yVarArr.length;
        b bVar = new b(cVar, length, length <= g.a.l.Q() ? new c(length) : new a());
        cVar.onSubscribe(bVar);
        g.a.y0.j.c cVar2 = bVar.error;
        for (g.a.y yVar : yVarArr) {
            if (bVar.isCancelled() || cVar2.get() != null) {
                return;
            }
            yVar.a(bVar);
        }
    }

    /* compiled from: MaybeMergeArray.java */
    static final class c<T> extends AtomicReferenceArray<T> implements d<T> {
        private static final long serialVersionUID = -7969063454040569579L;
        int consumerIndex;
        final AtomicInteger producerIndex;

        c(int i2) {
            super(i2);
            this.producerIndex = new AtomicInteger();
        }

        @Override // g.a.y0.c.o
        public void clear() {
            while (poll() != null && !isEmpty()) {
            }
        }

        @Override // g.a.y0.e.c.v0.d
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // g.a.y0.e.c.v0.d
        public void drop() {
            int i2 = this.consumerIndex;
            lazySet(i2, null);
            this.consumerIndex = i2 + 1;
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.consumerIndex == producerIndex();
        }

        @Override // g.a.y0.c.o
        public boolean offer(T t) {
            g.a.y0.b.b.a((Object) t, "value is null");
            int andIncrement = this.producerIndex.getAndIncrement();
            if (andIncrement >= length()) {
                return false;
            }
            lazySet(andIncrement, t);
            return true;
        }

        @Override // g.a.y0.e.c.v0.d
        public T peek() {
            int i2 = this.consumerIndex;
            if (i2 == length()) {
                return null;
            }
            return get(i2);
        }

        @Override // g.a.y0.e.c.v0.d, java.util.Queue, g.a.y0.c.o
        @g.a.t0.g
        public T poll() {
            int i2 = this.consumerIndex;
            if (i2 == length()) {
                return null;
            }
            AtomicInteger atomicInteger = this.producerIndex;
            do {
                T t = get(i2);
                if (t != null) {
                    this.consumerIndex = i2 + 1;
                    lazySet(i2, null);
                    return t;
                }
            } while (atomicInteger.get() != i2);
            return null;
        }

        @Override // g.a.y0.e.c.v0.d
        public int producerIndex() {
            return this.producerIndex.get();
        }

        @Override // g.a.y0.c.o
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }
    }
}
