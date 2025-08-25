package g.a.y0.e.b;

import g.a.y0.e.b.f4;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableTimeout.java */
/* loaded from: classes2.dex */
public final class e4<T, U, V> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final i.d.b<U> f14207c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends i.d.b<V>> f14208d;

    /* renamed from: e, reason: collision with root package name */
    final i.d.b<? extends T> f14209e;

    /* compiled from: FlowableTimeout.java */
    static final class a extends AtomicReference<i.d.d> implements g.a.q<Object>, g.a.u0.c {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final c parent;

        a(long j2, c cVar) {
            this.idx = j2;
            this.parent = cVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.i.j.cancel(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.i.j.isCancelled(get());
        }

        @Override // i.d.c
        public void onComplete() {
            Object obj = get();
            g.a.y0.i.j jVar = g.a.y0.i.j.CANCELLED;
            if (obj != jVar) {
                lazySet(jVar);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            Object obj = get();
            g.a.y0.i.j jVar = g.a.y0.i.j.CANCELLED;
            if (obj == jVar) {
                g.a.c1.a.b(th);
            } else {
                lazySet(jVar);
                this.parent.onTimeoutError(this.idx, th);
            }
        }

        @Override // i.d.c
        public void onNext(Object obj) {
            i.d.d dVar = (i.d.d) get();
            if (dVar != g.a.y0.i.j.CANCELLED) {
                dVar.cancel();
                lazySet(g.a.y0.i.j.CANCELLED);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    /* compiled from: FlowableTimeout.java */
    static final class b<T> extends g.a.y0.i.i implements g.a.q<T>, c {
        private static final long serialVersionUID = 3764492702657003550L;
        final i.d.c<? super T> actual;
        long consumed;
        i.d.b<? extends T> fallback;
        final g.a.x0.o<? super T, ? extends i.d.b<?>> itemTimeoutIndicator;
        final g.a.y0.a.k task = new g.a.y0.a.k();
        final AtomicReference<i.d.d> upstream = new AtomicReference<>();
        final AtomicLong index = new AtomicLong();

        b(i.d.c<? super T> cVar, g.a.x0.o<? super T, ? extends i.d.b<?>> oVar, i.d.b<? extends T> bVar) {
            this.actual = cVar;
            this.itemTimeoutIndicator = oVar;
            this.fallback = bVar;
        }

        @Override // g.a.y0.i.i, i.d.d
        public void cancel() {
            super.cancel();
            this.task.dispose();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.index.getAndSet(h.q2.t.m0.f16408b) != h.q2.t.m0.f16408b) {
                this.task.dispose();
                this.actual.onComplete();
                this.task.dispose();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.index.getAndSet(h.q2.t.m0.f16408b) == h.q2.t.m0.f16408b) {
                g.a.c1.a.b(th);
                return;
            }
            this.task.dispose();
            this.actual.onError(th);
            this.task.dispose();
        }

        @Override // i.d.c
        public void onNext(T t) {
            long j2 = this.index.get();
            if (j2 != h.q2.t.m0.f16408b) {
                long j3 = j2 + 1;
                if (this.index.compareAndSet(j2, j3)) {
                    g.a.u0.c cVar = this.task.get();
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    this.consumed++;
                    this.actual.onNext(t);
                    try {
                        i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        a aVar = new a(j3, this);
                        if (this.task.replace(aVar)) {
                            bVar.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        this.upstream.get().cancel();
                        this.index.getAndSet(h.q2.t.m0.f16408b);
                        this.actual.onError(th);
                    }
                }
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this.upstream, dVar)) {
                setSubscription(dVar);
            }
        }

        @Override // g.a.y0.e.b.f4.d
        public void onTimeout(long j2) {
            if (this.index.compareAndSet(j2, h.q2.t.m0.f16408b)) {
                g.a.y0.i.j.cancel(this.upstream);
                i.d.b<? extends T> bVar = this.fallback;
                this.fallback = null;
                long j3 = this.consumed;
                if (j3 != 0) {
                    produced(j3);
                }
                bVar.subscribe(new f4.a(this.actual, this));
            }
        }

        @Override // g.a.y0.e.b.e4.c
        public void onTimeoutError(long j2, Throwable th) {
            if (!this.index.compareAndSet(j2, h.q2.t.m0.f16408b)) {
                g.a.c1.a.b(th);
            } else {
                g.a.y0.i.j.cancel(this.upstream);
                this.actual.onError(th);
            }
        }

        void startFirstTimeout(i.d.b<?> bVar) {
            if (bVar != null) {
                a aVar = new a(0L, this);
                if (this.task.replace(aVar)) {
                    bVar.subscribe(aVar);
                }
            }
        }
    }

    /* compiled from: FlowableTimeout.java */
    interface c extends f4.d {
        void onTimeoutError(long j2, Throwable th);
    }

    /* compiled from: FlowableTimeout.java */
    static final class d<T> extends AtomicLong implements g.a.q<T>, i.d.d, c {
        private static final long serialVersionUID = 3764492702657003550L;
        final i.d.c<? super T> actual;
        final g.a.x0.o<? super T, ? extends i.d.b<?>> itemTimeoutIndicator;
        final g.a.y0.a.k task = new g.a.y0.a.k();
        final AtomicReference<i.d.d> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        d(i.d.c<? super T> cVar, g.a.x0.o<? super T, ? extends i.d.b<?>> oVar) {
            this.actual = cVar;
            this.itemTimeoutIndicator = oVar;
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.i.j.cancel(this.upstream);
            this.task.dispose();
        }

        @Override // i.d.c
        public void onComplete() {
            if (getAndSet(h.q2.t.m0.f16408b) != h.q2.t.m0.f16408b) {
                this.task.dispose();
                this.actual.onComplete();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (getAndSet(h.q2.t.m0.f16408b) == h.q2.t.m0.f16408b) {
                g.a.c1.a.b(th);
            } else {
                this.task.dispose();
                this.actual.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            long j2 = get();
            if (j2 != h.q2.t.m0.f16408b) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    g.a.u0.c cVar = this.task.get();
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    this.actual.onNext(t);
                    try {
                        i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        a aVar = new a(j3, this);
                        if (this.task.replace(aVar)) {
                            bVar.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        this.upstream.get().cancel();
                        getAndSet(h.q2.t.m0.f16408b);
                        this.actual.onError(th);
                    }
                }
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            g.a.y0.i.j.deferredSetOnce(this.upstream, this.requested, dVar);
        }

        @Override // g.a.y0.e.b.f4.d
        public void onTimeout(long j2) {
            if (compareAndSet(j2, h.q2.t.m0.f16408b)) {
                g.a.y0.i.j.cancel(this.upstream);
                this.actual.onError(new TimeoutException());
            }
        }

        @Override // g.a.y0.e.b.e4.c
        public void onTimeoutError(long j2, Throwable th) {
            if (!compareAndSet(j2, h.q2.t.m0.f16408b)) {
                g.a.c1.a.b(th);
            } else {
                g.a.y0.i.j.cancel(this.upstream);
                this.actual.onError(th);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            g.a.y0.i.j.deferredRequest(this.upstream, this.requested, j2);
        }

        void startFirstTimeout(i.d.b<?> bVar) {
            if (bVar != null) {
                a aVar = new a(0L, this);
                if (this.task.replace(aVar)) {
                    bVar.subscribe(aVar);
                }
            }
        }
    }

    public e4(g.a.l<T> lVar, i.d.b<U> bVar, g.a.x0.o<? super T, ? extends i.d.b<V>> oVar, i.d.b<? extends T> bVar2) {
        super(lVar);
        this.f14207c = bVar;
        this.f14208d = oVar;
        this.f14209e = bVar2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        i.d.b<? extends T> bVar = this.f14209e;
        if (bVar == null) {
            d dVar = new d(cVar, this.f14208d);
            cVar.onSubscribe(dVar);
            dVar.startFirstTimeout(this.f14207c);
            this.f14110b.a((g.a.q) dVar);
            return;
        }
        b bVar2 = new b(cVar, this.f14208d, bVar);
        cVar.onSubscribe(bVar2);
        bVar2.startFirstTimeout(this.f14207c);
        this.f14110b.a((g.a.q) bVar2);
    }
}
