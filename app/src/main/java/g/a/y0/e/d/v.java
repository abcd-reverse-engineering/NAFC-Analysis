package g.a.y0.e.d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatMap.java */
/* loaded from: classes2.dex */
public final class v<T, U> extends g.a.y0.e.d.a<T, U> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.g0<? extends U>> f15518b;

    /* renamed from: c, reason: collision with root package name */
    final int f15519c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.y0.j.j f15520d;

    /* compiled from: ObservableConcatMap.java */
    static final class a<T, R> extends AtomicInteger implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final g.a.i0<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15521d;
        volatile boolean done;
        final g.a.y0.j.c error = new g.a.y0.j.c();
        final g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> mapper;
        final C0215a<R> observer;
        g.a.y0.c.o<T> queue;
        int sourceMode;
        final boolean tillTheEnd;

        /* compiled from: ObservableConcatMap.java */
        /* renamed from: g.a.y0.e.d.v$a$a, reason: collision with other inner class name */
        static final class C0215a<R> extends AtomicReference<g.a.u0.c> implements g.a.i0<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final g.a.i0<? super R> actual;
            final a<?, R> parent;

            C0215a(g.a.i0<? super R> i0Var, a<?, R> aVar) {
                this.actual = i0Var;
                this.parent = aVar;
            }

            void dispose() {
                g.a.y0.a.d.dispose(this);
            }

            @Override // g.a.i0
            public void onComplete() {
                a<?, R> aVar = this.parent;
                aVar.active = false;
                aVar.drain();
            }

            @Override // g.a.i0
            public void onError(Throwable th) {
                a<?, R> aVar = this.parent;
                if (!aVar.error.addThrowable(th)) {
                    g.a.c1.a.b(th);
                    return;
                }
                if (!aVar.tillTheEnd) {
                    aVar.f15521d.dispose();
                }
                aVar.active = false;
                aVar.drain();
            }

            @Override // g.a.i0
            public void onNext(R r) {
                this.actual.onNext(r);
            }

            @Override // g.a.i0
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.replace(this, cVar);
            }
        }

        a(g.a.i0<? super R> i0Var, g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> oVar, int i2, boolean z) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.bufferSize = i2;
            this.tillTheEnd = z;
            this.observer = new C0215a<>(i0Var, this);
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.cancelled = true;
            this.f15521d.dispose();
            this.observer.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            g.a.i0<? super R> i0Var = this.actual;
            g.a.y0.c.o<T> oVar = this.queue;
            g.a.y0.j.c cVar = this.error;
            while (true) {
                if (!this.active) {
                    if (this.cancelled) {
                        oVar.clear();
                        return;
                    }
                    if (!this.tillTheEnd && cVar.get() != null) {
                        oVar.clear();
                        this.cancelled = true;
                        i0Var.onError(cVar.terminate());
                        return;
                    }
                    boolean z = this.done;
                    try {
                        T tPoll = oVar.poll();
                        boolean z2 = tPoll == null;
                        if (z && z2) {
                            this.cancelled = true;
                            Throwable thTerminate = cVar.terminate();
                            if (thTerminate != null) {
                                i0Var.onError(thTerminate);
                                return;
                            } else {
                                i0Var.onComplete();
                                return;
                            }
                        }
                        if (!z2) {
                            try {
                                g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.mapper.apply(tPoll), "The mapper returned a null ObservableSource");
                                if (g0Var instanceof Callable) {
                                    try {
                                        a.a.a aVar = (Object) ((Callable) g0Var).call();
                                        if (aVar != null && !this.cancelled) {
                                            i0Var.onNext(aVar);
                                        }
                                    } catch (Throwable th) {
                                        g.a.v0.b.b(th);
                                        cVar.addThrowable(th);
                                    }
                                } else {
                                    this.active = true;
                                    g0Var.subscribe(this.observer);
                                }
                            } catch (Throwable th2) {
                                g.a.v0.b.b(th2);
                                this.cancelled = true;
                                this.f15521d.dispose();
                                oVar.clear();
                                cVar.addThrowable(th2);
                                i0Var.onError(cVar.terminate());
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        g.a.v0.b.b(th3);
                        this.cancelled = true;
                        this.f15521d.dispose();
                        cVar.addThrowable(th3);
                        i0Var.onError(cVar.terminate());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (!this.error.addThrowable(th)) {
                g.a.c1.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15521d, cVar)) {
                this.f15521d = cVar;
                if (cVar instanceof g.a.y0.c.j) {
                    g.a.y0.c.j jVar = (g.a.y0.c.j) cVar;
                    int iRequestFusion = jVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = jVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
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
    }

    /* compiled from: ObservableConcatMap.java */
    static final class b<T, U> extends AtomicInteger implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final g.a.i0<? super U> actual;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        int fusionMode;
        final a<U> inner;
        final g.a.x0.o<? super T, ? extends g.a.g0<? extends U>> mapper;
        g.a.y0.c.o<T> queue;
        g.a.u0.c s;

        /* compiled from: ObservableConcatMap.java */
        static final class a<U> extends AtomicReference<g.a.u0.c> implements g.a.i0<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final g.a.i0<? super U> actual;
            final b<?, ?> parent;

            a(g.a.i0<? super U> i0Var, b<?, ?> bVar) {
                this.actual = i0Var;
                this.parent = bVar;
            }

            void dispose() {
                g.a.y0.a.d.dispose(this);
            }

            @Override // g.a.i0
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // g.a.i0
            public void onError(Throwable th) {
                this.parent.dispose();
                this.actual.onError(th);
            }

            @Override // g.a.i0
            public void onNext(U u) {
                this.actual.onNext(u);
            }

            @Override // g.a.i0
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.set(this, cVar);
            }
        }

        b(g.a.i0<? super U> i0Var, g.a.x0.o<? super T, ? extends g.a.g0<? extends U>> oVar, int i2) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.bufferSize = i2;
            this.inner = new a<>(i0Var, this);
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.s.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.disposed) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        T tPoll = this.queue.poll();
                        boolean z2 = tPoll == null;
                        if (z && z2) {
                            this.disposed = true;
                            this.actual.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.mapper.apply(tPoll), "The mapper returned a null ObservableSource");
                                this.active = true;
                                g0Var.subscribe(this.inner);
                            } catch (Throwable th) {
                                g.a.v0.b.b(th);
                                dispose();
                                this.queue.clear();
                                this.actual.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        g.a.v0.b.b(th2);
                        dispose();
                        this.queue.clear();
                        this.actual.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            dispose();
            this.actual.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                if (cVar instanceof g.a.y0.c.j) {
                    g.a.y0.c.j jVar = (g.a.y0.c.j) cVar;
                    int iRequestFusion = jVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = jVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = jVar;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new g.a.y0.f.c(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }
    }

    public v(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends g.a.g0<? extends U>> oVar, int i2, g.a.y0.j.j jVar) {
        super(g0Var);
        this.f15518b = oVar;
        this.f15520d = jVar;
        this.f15519c = Math.max(8, i2);
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super U> i0Var) {
        if (s2.a(this.f14934a, i0Var, this.f15518b)) {
            return;
        }
        g.a.y0.j.j jVar = this.f15520d;
        if (jVar == g.a.y0.j.j.IMMEDIATE) {
            this.f14934a.subscribe(new b(new g.a.a1.m(i0Var), this.f15518b, this.f15519c));
        } else {
            this.f14934a.subscribe(new a(i0Var, this.f15518b, this.f15519c, jVar == g.a.y0.j.j.END));
        }
    }
}
