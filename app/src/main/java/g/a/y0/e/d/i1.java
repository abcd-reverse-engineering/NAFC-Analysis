package g.a.y0.e.d;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableGroupJoin.java */
/* loaded from: classes2.dex */
public final class i1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends g.a.y0.e.d.a<TLeft, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.g0<? extends TRight> f15198b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super TLeft, ? extends g.a.g0<TLeftEnd>> f15199c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.o<? super TRight, ? extends g.a.g0<TRightEnd>> f15200d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.x0.c<? super TLeft, ? super g.a.b0<TRight>, ? extends R> f15201e;

    /* compiled from: ObservableGroupJoin.java */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements g.a.u0.c, b {
        private static final long serialVersionUID = -6071216598687999801L;
        final g.a.i0<? super R> actual;
        volatile boolean cancelled;
        final g.a.x0.o<? super TLeft, ? extends g.a.g0<TLeftEnd>> leftEnd;
        int leftIndex;
        final g.a.x0.c<? super TLeft, ? super g.a.b0<TRight>, ? extends R> resultSelector;
        final g.a.x0.o<? super TRight, ? extends g.a.g0<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final g.a.u0.b disposables = new g.a.u0.b();
        final g.a.y0.f.c<Object> queue = new g.a.y0.f.c<>(g.a.b0.L());
        final Map<Integer, g.a.f1.j<TRight>> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        a(g.a.i0<? super R> i0Var, g.a.x0.o<? super TLeft, ? extends g.a.g0<TLeftEnd>> oVar, g.a.x0.o<? super TRight, ? extends g.a.g0<TRightEnd>> oVar2, g.a.x0.c<? super TLeft, ? super g.a.b0<TRight>, ? extends R> cVar) {
            this.actual = i0Var;
            this.leftEnd = oVar;
            this.rightEnd = oVar2;
            this.resultSelector = cVar;
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            g.a.y0.f.c<?> cVar = this.queue;
            g.a.i0<? super R> i0Var = this.actual;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    cVar.clear();
                    cancelAll();
                    errorAll(i0Var);
                    return;
                }
                boolean z = this.active.get() == 0;
                Integer num = (Integer) cVar.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    Iterator<g.a.f1.j<TRight>> it = this.lefts.values().iterator();
                    while (it.hasNext()) {
                        it.next().onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    i0Var.onComplete();
                    return;
                }
                if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = cVar.poll();
                    if (num == LEFT_VALUE) {
                        g.a.f1.j jVarV = g.a.f1.j.V();
                        int i2 = this.leftIndex;
                        this.leftIndex = i2 + 1;
                        this.lefts.put(Integer.valueOf(i2), jVarV);
                        try {
                            g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.leftEnd.apply(objPoll), "The leftEnd returned a null ObservableSource");
                            c cVar2 = new c(this, true, i2);
                            this.disposables.b(cVar2);
                            g0Var.subscribe(cVar2);
                            if (this.error.get() != null) {
                                cVar.clear();
                                cancelAll();
                                errorAll(i0Var);
                                return;
                            } else {
                                try {
                                    i0Var.onNext((Object) g.a.y0.b.b.a(this.resultSelector.apply(objPoll, jVarV), "The resultSelector returned a null value"));
                                    Iterator<TRight> it2 = this.rights.values().iterator();
                                    while (it2.hasNext()) {
                                        jVarV.onNext(it2.next());
                                    }
                                } catch (Throwable th) {
                                    fail(th, i0Var, cVar);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            fail(th2, i0Var, cVar);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i3 = this.rightIndex;
                        this.rightIndex = i3 + 1;
                        this.rights.put(Integer.valueOf(i3), objPoll);
                        try {
                            g.a.g0 g0Var2 = (g.a.g0) g.a.y0.b.b.a(this.rightEnd.apply(objPoll), "The rightEnd returned a null ObservableSource");
                            c cVar3 = new c(this, false, i3);
                            this.disposables.b(cVar3);
                            g0Var2.subscribe(cVar3);
                            if (this.error.get() != null) {
                                cVar.clear();
                                cancelAll();
                                errorAll(i0Var);
                                return;
                            } else {
                                Iterator<g.a.f1.j<TRight>> it3 = this.lefts.values().iterator();
                                while (it3.hasNext()) {
                                    it3.next().onNext(objPoll);
                                }
                            }
                        } catch (Throwable th3) {
                            fail(th3, i0Var, cVar);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        c cVar4 = (c) objPoll;
                        g.a.f1.j<TRight> jVarRemove = this.lefts.remove(Integer.valueOf(cVar4.index));
                        this.disposables.a(cVar4);
                        if (jVarRemove != null) {
                            jVarRemove.onComplete();
                        }
                    } else if (num == RIGHT_CLOSE) {
                        c cVar5 = (c) objPoll;
                        this.rights.remove(Integer.valueOf(cVar5.index));
                        this.disposables.a(cVar5);
                    }
                }
            }
            cVar.clear();
        }

        void errorAll(g.a.i0<?> i0Var) {
            Throwable thA = g.a.y0.j.k.a(this.error);
            Iterator<g.a.f1.j<TRight>> it = this.lefts.values().iterator();
            while (it.hasNext()) {
                it.next().onError(thA);
            }
            this.lefts.clear();
            this.rights.clear();
            i0Var.onError(thA);
        }

        void fail(Throwable th, g.a.i0<?> i0Var, g.a.y0.f.c<?> cVar) {
            g.a.v0.b.b(th);
            g.a.y0.j.k.a(this.error, th);
            cVar.clear();
            cancelAll();
            errorAll(i0Var);
        }

        @Override // g.a.y0.e.d.i1.b
        public void innerClose(boolean z, c cVar) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_CLOSE : RIGHT_CLOSE, cVar);
            }
            drain();
        }

        @Override // g.a.y0.e.d.i1.b
        public void innerCloseError(Throwable th) {
            if (g.a.y0.j.k.a(this.error, th)) {
                drain();
            } else {
                g.a.c1.a.b(th);
            }
        }

        @Override // g.a.y0.e.d.i1.b
        public void innerComplete(d dVar) {
            this.disposables.c(dVar);
            this.active.decrementAndGet();
            drain();
        }

        @Override // g.a.y0.e.d.i1.b
        public void innerError(Throwable th) {
            if (!g.a.y0.j.k.a(this.error, th)) {
                g.a.c1.a.b(th);
            } else {
                this.active.decrementAndGet();
                drain();
            }
        }

        @Override // g.a.y0.e.d.i1.b
        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* compiled from: ObservableGroupJoin.java */
    interface b {
        void innerClose(boolean z, c cVar);

        void innerCloseError(Throwable th);

        void innerComplete(d dVar);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    /* compiled from: ObservableGroupJoin.java */
    static final class c extends AtomicReference<g.a.u0.c> implements g.a.i0<Object>, g.a.u0.c {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final b parent;

        c(b bVar, boolean z, int i2) {
            this.parent = bVar;
            this.isLeft = z;
            this.index = i2;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.i0
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.parent.innerCloseError(th);
        }

        @Override // g.a.i0
        public void onNext(Object obj) {
            if (g.a.y0.a.d.dispose(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }
    }

    /* compiled from: ObservableGroupJoin.java */
    static final class d extends AtomicReference<g.a.u0.c> implements g.a.i0<Object>, g.a.u0.c {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final b parent;

        d(b bVar, boolean z) {
            this.parent = bVar;
            this.isLeft = z;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.i0
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // g.a.i0
        public void onNext(Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }
    }

    public i1(g.a.g0<TLeft> g0Var, g.a.g0<? extends TRight> g0Var2, g.a.x0.o<? super TLeft, ? extends g.a.g0<TLeftEnd>> oVar, g.a.x0.o<? super TRight, ? extends g.a.g0<TRightEnd>> oVar2, g.a.x0.c<? super TLeft, ? super g.a.b0<TRight>, ? extends R> cVar) {
        super(g0Var);
        this.f15198b = g0Var2;
        this.f15199c = oVar;
        this.f15200d = oVar2;
        this.f15201e = cVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super R> i0Var) {
        a aVar = new a(i0Var, this.f15199c, this.f15200d, this.f15201e);
        i0Var.onSubscribe(aVar);
        d dVar = new d(aVar, true);
        aVar.disposables.b(dVar);
        d dVar2 = new d(aVar, false);
        aVar.disposables.b(dVar2);
        this.f14934a.subscribe(dVar);
        this.f15198b.subscribe(dVar2);
    }
}
