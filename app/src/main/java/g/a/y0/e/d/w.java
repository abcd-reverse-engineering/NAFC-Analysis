package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatMapCompletable.java */
/* loaded from: classes2.dex */
public final class w<T> extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15547a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.i> f15548b;

    /* renamed from: c, reason: collision with root package name */
    final int f15549c;

    /* compiled from: ObservableConcatMapCompletable.java */
    static final class a<T> extends AtomicInteger implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = 6893587405571511048L;
        volatile boolean active;
        final g.a.f actual;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final C0217a inner;
        final g.a.x0.o<? super T, ? extends g.a.i> mapper;
        g.a.y0.c.o<T> queue;
        g.a.u0.c s;
        int sourceMode;

        /* compiled from: ObservableConcatMapCompletable.java */
        /* renamed from: g.a.y0.e.d.w$a$a, reason: collision with other inner class name */
        static final class C0217a extends AtomicReference<g.a.u0.c> implements g.a.f {
            private static final long serialVersionUID = -5987419458390772447L;
            final g.a.f actual;
            final a<?> parent;

            C0217a(g.a.f fVar, a<?> aVar) {
                this.actual = fVar;
                this.parent = aVar;
            }

            void dispose() {
                g.a.y0.a.d.dispose(this);
            }

            @Override // g.a.f
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // g.a.f
            public void onError(Throwable th) {
                this.parent.dispose();
                this.actual.onError(th);
            }

            @Override // g.a.f
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.set(this, cVar);
            }
        }

        a(g.a.f fVar, g.a.x0.o<? super T, ? extends g.a.i> oVar, int i2) {
            this.actual = fVar;
            this.mapper = oVar;
            this.bufferSize = i2;
            this.inner = new C0217a(fVar, this);
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
                                g.a.i iVar = (g.a.i) g.a.y0.b.b.a(this.mapper.apply(tPoll), "The mapper returned a null CompletableSource");
                                this.active = true;
                                iVar.a(this.inner);
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
            if (this.sourceMode == 0) {
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

    public w(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends g.a.i> oVar, int i2) {
        this.f15547a = g0Var;
        this.f15548b = oVar;
        this.f15549c = Math.max(8, i2);
    }

    @Override // g.a.c
    public void b(g.a.f fVar) {
        this.f15547a.subscribe(new a(fVar, this.f15548b, this.f15549c));
    }
}
