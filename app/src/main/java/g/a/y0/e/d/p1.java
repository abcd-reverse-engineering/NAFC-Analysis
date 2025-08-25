package g.a.y0.e.d;

import g.a.y0.e.d.i1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableJoin.java */
/* loaded from: classes2.dex */
public final class p1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends g.a.y0.e.d.a<TLeft, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.g0<? extends TRight> f15387b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super TLeft, ? extends g.a.g0<TLeftEnd>> f15388c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.o<? super TRight, ? extends g.a.g0<TRightEnd>> f15389d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.x0.c<? super TLeft, ? super TRight, ? extends R> f15390e;

    /* compiled from: ObservableJoin.java */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements g.a.u0.c, i1.b {
        private static final long serialVersionUID = -6071216598687999801L;
        final g.a.i0<? super R> actual;
        volatile boolean cancelled;
        final g.a.x0.o<? super TLeft, ? extends g.a.g0<TLeftEnd>> leftEnd;
        int leftIndex;
        final g.a.x0.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final g.a.x0.o<? super TRight, ? extends g.a.g0<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final g.a.u0.b disposables = new g.a.u0.b();
        final g.a.y0.f.c<Object> queue = new g.a.y0.f.c<>(g.a.b0.L());
        final Map<Integer, TLeft> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        a(g.a.i0<? super R> i0Var, g.a.x0.o<? super TLeft, ? extends g.a.g0<TLeftEnd>> oVar, g.a.x0.o<? super TRight, ? extends g.a.g0<TRightEnd>> oVar2, g.a.x0.c<? super TLeft, ? super TRight, ? extends R> cVar) {
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
                        int i2 = this.leftIndex;
                        this.leftIndex = i2 + 1;
                        this.lefts.put(Integer.valueOf(i2), objPoll);
                        try {
                            g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.leftEnd.apply(objPoll), "The leftEnd returned a null ObservableSource");
                            i1.c cVar2 = new i1.c(this, true, i2);
                            this.disposables.b(cVar2);
                            g0Var.subscribe(cVar2);
                            if (this.error.get() != null) {
                                cVar.clear();
                                cancelAll();
                                errorAll(i0Var);
                                return;
                            } else {
                                Iterator<TRight> it = this.rights.values().iterator();
                                while (it.hasNext()) {
                                    try {
                                        i0Var.onNext((Object) g.a.y0.b.b.a(this.resultSelector.apply(objPoll, it.next()), "The resultSelector returned a null value"));
                                    } catch (Throwable th) {
                                        fail(th, i0Var, cVar);
                                        return;
                                    }
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
                            i1.c cVar3 = new i1.c(this, false, i3);
                            this.disposables.b(cVar3);
                            g0Var2.subscribe(cVar3);
                            if (this.error.get() != null) {
                                cVar.clear();
                                cancelAll();
                                errorAll(i0Var);
                                return;
                            } else {
                                Iterator<TLeft> it2 = this.lefts.values().iterator();
                                while (it2.hasNext()) {
                                    try {
                                        i0Var.onNext((Object) g.a.y0.b.b.a(this.resultSelector.apply(it2.next(), objPoll), "The resultSelector returned a null value"));
                                    } catch (Throwable th3) {
                                        fail(th3, i0Var, cVar);
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            fail(th4, i0Var, cVar);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        i1.c cVar4 = (i1.c) objPoll;
                        this.lefts.remove(Integer.valueOf(cVar4.index));
                        this.disposables.a(cVar4);
                    } else {
                        i1.c cVar5 = (i1.c) objPoll;
                        this.rights.remove(Integer.valueOf(cVar5.index));
                        this.disposables.a(cVar5);
                    }
                }
            }
            cVar.clear();
        }

        void errorAll(g.a.i0<?> i0Var) {
            Throwable thA = g.a.y0.j.k.a(this.error);
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
        public void innerClose(boolean z, i1.c cVar) {
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
        public void innerComplete(i1.d dVar) {
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

    public p1(g.a.g0<TLeft> g0Var, g.a.g0<? extends TRight> g0Var2, g.a.x0.o<? super TLeft, ? extends g.a.g0<TLeftEnd>> oVar, g.a.x0.o<? super TRight, ? extends g.a.g0<TRightEnd>> oVar2, g.a.x0.c<? super TLeft, ? super TRight, ? extends R> cVar) {
        super(g0Var);
        this.f15387b = g0Var2;
        this.f15388c = oVar;
        this.f15389d = oVar2;
        this.f15390e = cVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super R> i0Var) {
        a aVar = new a(i0Var, this.f15388c, this.f15389d, this.f15390e);
        i0Var.onSubscribe(aVar);
        i1.d dVar = new i1.d(aVar, true);
        aVar.disposables.b(dVar);
        i1.d dVar2 = new i1.d(aVar, false);
        aVar.disposables.b(dVar2);
        this.f14934a.subscribe(dVar);
        this.f15387b.subscribe(dVar2);
    }
}
