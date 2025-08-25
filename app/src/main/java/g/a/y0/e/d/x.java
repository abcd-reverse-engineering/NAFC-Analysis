package g.a.y0.e.d;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableConcatMapEager.java */
/* loaded from: classes2.dex */
public final class x<T, R> extends g.a.y0.e.d.a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> f15567b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.y0.j.j f15568c;

    /* renamed from: d, reason: collision with root package name */
    final int f15569d;

    /* renamed from: e, reason: collision with root package name */
    final int f15570e;

    /* compiled from: ObservableConcatMapEager.java */
    static final class a<T, R> extends AtomicInteger implements g.a.i0<T>, g.a.u0.c, g.a.y0.d.u<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        final g.a.i0<? super R> actual;
        volatile boolean cancelled;
        g.a.y0.d.t<R> current;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15571d;
        volatile boolean done;
        final g.a.y0.j.j errorMode;
        final g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        g.a.y0.c.o<T> queue;
        int sourceMode;
        final g.a.y0.j.c error = new g.a.y0.j.c();
        final ArrayDeque<g.a.y0.d.t<R>> observers = new ArrayDeque<>();

        a(g.a.i0<? super R> i0Var, g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> oVar, int i2, int i3, g.a.y0.j.j jVar) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.maxConcurrency = i2;
            this.prefetch = i3;
            this.errorMode = jVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                this.queue.clear();
                disposeAll();
            }
        }

        void disposeAll() {
            g.a.y0.d.t<R> tVar = this.current;
            if (tVar != null) {
                tVar.dispose();
            }
            while (true) {
                g.a.y0.d.t<R> tVarPoll = this.observers.poll();
                if (tVarPoll == null) {
                    return;
                } else {
                    tVarPoll.dispose();
                }
            }
        }

        @Override // g.a.y0.d.u
        public void drain() {
            R rPoll;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            g.a.y0.c.o<T> oVar = this.queue;
            ArrayDeque<g.a.y0.d.t<R>> arrayDeque = this.observers;
            g.a.i0<? super R> i0Var = this.actual;
            g.a.y0.j.j jVar = this.errorMode;
            int iAddAndGet = 1;
            while (true) {
                int i2 = this.activeCount;
                while (i2 != this.maxConcurrency) {
                    if (this.cancelled) {
                        oVar.clear();
                        disposeAll();
                        return;
                    }
                    if (jVar == g.a.y0.j.j.IMMEDIATE && this.error.get() != null) {
                        oVar.clear();
                        disposeAll();
                        i0Var.onError(this.error.terminate());
                        return;
                    }
                    try {
                        T tPoll = oVar.poll();
                        if (tPoll == null) {
                            break;
                        }
                        g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.mapper.apply(tPoll), "The mapper returned a null ObservableSource");
                        g.a.y0.d.t<R> tVar = new g.a.y0.d.t<>(this, this.prefetch);
                        arrayDeque.offer(tVar);
                        g0Var.subscribe(tVar);
                        i2++;
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        this.f15571d.dispose();
                        oVar.clear();
                        disposeAll();
                        this.error.addThrowable(th);
                        i0Var.onError(this.error.terminate());
                        return;
                    }
                }
                this.activeCount = i2;
                if (this.cancelled) {
                    oVar.clear();
                    disposeAll();
                    return;
                }
                if (jVar == g.a.y0.j.j.IMMEDIATE && this.error.get() != null) {
                    oVar.clear();
                    disposeAll();
                    i0Var.onError(this.error.terminate());
                    return;
                }
                g.a.y0.d.t<R> tVar2 = this.current;
                if (tVar2 == null) {
                    if (jVar == g.a.y0.j.j.BOUNDARY && this.error.get() != null) {
                        oVar.clear();
                        disposeAll();
                        i0Var.onError(this.error.terminate());
                        return;
                    }
                    boolean z2 = this.done;
                    g.a.y0.d.t<R> tVarPoll = arrayDeque.poll();
                    boolean z3 = tVarPoll == null;
                    if (z2 && z3) {
                        if (this.error.get() == null) {
                            i0Var.onComplete();
                            return;
                        }
                        oVar.clear();
                        disposeAll();
                        i0Var.onError(this.error.terminate());
                        return;
                    }
                    if (!z3) {
                        this.current = tVarPoll;
                    }
                    tVar2 = tVarPoll;
                }
                if (tVar2 != null) {
                    g.a.y0.c.o<R> oVarQueue = tVar2.queue();
                    while (!this.cancelled) {
                        boolean zIsDone = tVar2.isDone();
                        if (jVar == g.a.y0.j.j.IMMEDIATE && this.error.get() != null) {
                            oVar.clear();
                            disposeAll();
                            i0Var.onError(this.error.terminate());
                            return;
                        }
                        try {
                            rPoll = oVarQueue.poll();
                            z = rPoll == null;
                        } catch (Throwable th2) {
                            g.a.v0.b.b(th2);
                            this.error.addThrowable(th2);
                            this.current = null;
                            this.activeCount--;
                        }
                        if (zIsDone && z) {
                            this.current = null;
                            this.activeCount--;
                        } else if (!z) {
                            i0Var.onNext(rPoll);
                        }
                    }
                    oVar.clear();
                    disposeAll();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // g.a.y0.d.u
        public void innerComplete(g.a.y0.d.t<R> tVar) {
            tVar.setDone();
            drain();
        }

        @Override // g.a.y0.d.u
        public void innerError(g.a.y0.d.t<R> tVar, Throwable th) {
            if (!this.error.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            if (this.errorMode == g.a.y0.j.j.IMMEDIATE) {
                this.f15571d.dispose();
            }
            tVar.setDone();
            drain();
        }

        @Override // g.a.y0.d.u
        public void innerNext(g.a.y0.d.t<R> tVar, R r) {
            tVar.queue().offer(r);
            drain();
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
            if (g.a.y0.a.d.validate(this.f15571d, cVar)) {
                this.f15571d = cVar;
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
                this.queue = new g.a.y0.f.c(this.prefetch);
                this.actual.onSubscribe(this);
            }
        }
    }

    public x(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> oVar, g.a.y0.j.j jVar, int i2, int i3) {
        super(g0Var);
        this.f15567b = oVar;
        this.f15568c = jVar;
        this.f15569d = i2;
        this.f15570e = i3;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super R> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15567b, this.f15569d, this.f15570e, this.f15568c));
    }
}
