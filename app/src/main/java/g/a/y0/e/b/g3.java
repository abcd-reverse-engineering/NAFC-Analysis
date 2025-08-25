package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSequenceEqual.java */
/* loaded from: classes2.dex */
public final class g3<T> extends g.a.l<Boolean> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<? extends T> f14252b;

    /* renamed from: c, reason: collision with root package name */
    final i.d.b<? extends T> f14253c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.d<? super T, ? super T> f14254d;

    /* renamed from: e, reason: collision with root package name */
    final int f14255e;

    /* compiled from: FlowableSequenceEqual.java */
    static final class a<T> extends g.a.y0.i.f<Boolean> implements b {
        private static final long serialVersionUID = -6178010334400373240L;
        final g.a.x0.d<? super T, ? super T> comparer;
        final g.a.y0.j.c error;
        final c<T> first;
        final c<T> second;
        T v1;
        T v2;
        final AtomicInteger wip;

        a(i.d.c<? super Boolean> cVar, int i2, g.a.x0.d<? super T, ? super T> dVar) {
            super(cVar);
            this.comparer = dVar;
            this.wip = new AtomicInteger();
            this.first = new c<>(this, i2);
            this.second = new c<>(this, i2);
            this.error = new g.a.y0.j.c();
        }

        @Override // g.a.y0.i.f, i.d.d
        public void cancel() {
            super.cancel();
            this.first.cancel();
            this.second.cancel();
            if (this.wip.getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // g.a.y0.e.b.g3.b
        public void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                g.a.y0.c.o<T> oVar = this.first.queue;
                g.a.y0.c.o<T> oVar2 = this.second.queue;
                if (oVar != null && oVar2 != null) {
                    while (!isCancelled()) {
                        if (this.error.get() != null) {
                            cancelAndClear();
                            this.actual.onError(this.error.terminate());
                            return;
                        }
                        boolean z = this.first.done;
                        T tPoll = this.v1;
                        if (tPoll == null) {
                            try {
                                tPoll = oVar.poll();
                                this.v1 = tPoll;
                            } catch (Throwable th) {
                                g.a.v0.b.b(th);
                                cancelAndClear();
                                this.error.addThrowable(th);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                        boolean z2 = tPoll == null;
                        boolean z3 = this.second.done;
                        T tPoll2 = this.v2;
                        if (tPoll2 == null) {
                            try {
                                tPoll2 = oVar2.poll();
                                this.v2 = tPoll2;
                            } catch (Throwable th2) {
                                g.a.v0.b.b(th2);
                                cancelAndClear();
                                this.error.addThrowable(th2);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                        boolean z4 = tPoll2 == null;
                        if (z && z3 && z2 && z4) {
                            complete(true);
                            return;
                        }
                        if (z && z3 && z2 != z4) {
                            cancelAndClear();
                            complete(false);
                            return;
                        }
                        if (!z2 && !z4) {
                            try {
                                if (!this.comparer.a(tPoll, tPoll2)) {
                                    cancelAndClear();
                                    complete(false);
                                    return;
                                } else {
                                    this.v1 = null;
                                    this.v2 = null;
                                    this.first.request();
                                    this.second.request();
                                }
                            } catch (Throwable th3) {
                                g.a.v0.b.b(th3);
                                cancelAndClear();
                                this.error.addThrowable(th3);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                }
                if (isCancelled()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (this.error.get() != null) {
                    cancelAndClear();
                    this.actual.onError(this.error.terminate());
                    return;
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // g.a.y0.e.b.g3.b
        public void innerError(Throwable th) {
            if (this.error.addThrowable(th)) {
                drain();
            } else {
                g.a.c1.a.b(th);
            }
        }

        void subscribe(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2) {
            bVar.subscribe(this.first);
            bVar2.subscribe(this.second);
        }
    }

    /* compiled from: FlowableSequenceEqual.java */
    interface b {
        void drain();

        void innerError(Throwable th);
    }

    /* compiled from: FlowableSequenceEqual.java */
    static final class c<T> extends AtomicReference<i.d.d> implements g.a.q<T> {
        private static final long serialVersionUID = 4804128302091633067L;
        volatile boolean done;
        final int limit;
        final b parent;
        final int prefetch;
        long produced;
        volatile g.a.y0.c.o<T> queue;
        int sourceMode;

        c(b bVar, int i2) {
            this.parent = bVar;
            this.limit = i2 - (i2 >> 2);
            this.prefetch = i2;
        }

        public void cancel() {
            g.a.y0.i.j.cancel(this);
        }

        void clear() {
            g.a.y0.c.o<T> oVar = this.queue;
            if (oVar != null) {
                oVar.clear();
            }
        }

        @Override // i.d.c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                this.parent.drain();
            } else {
                onError(new g.a.v0.c());
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                if (dVar instanceof g.a.y0.c.l) {
                    g.a.y0.c.l lVar = (g.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new g.a.y0.f.b(this.prefetch);
                dVar.request(this.prefetch);
            }
        }

        public void request() {
            if (this.sourceMode != 1) {
                long j2 = this.produced + 1;
                if (j2 < this.limit) {
                    this.produced = j2;
                } else {
                    this.produced = 0L;
                    get().request(j2);
                }
            }
        }
    }

    public g3(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2, g.a.x0.d<? super T, ? super T> dVar, int i2) {
        this.f14252b = bVar;
        this.f14253c = bVar2;
        this.f14254d = dVar;
        this.f14255e = i2;
    }

    @Override // g.a.l
    public void d(i.d.c<? super Boolean> cVar) {
        a aVar = new a(cVar, this.f14255e, this.f14254d);
        cVar.onSubscribe(aVar);
        aVar.subscribe(this.f14252b, this.f14253c);
    }
}
