package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableSequenceEqualSingle.java */
/* loaded from: classes2.dex */
public final class w2<T> extends g.a.k0<Boolean> implements g.a.y0.c.d<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<? extends T> f15556a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.g0<? extends T> f15557b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.d<? super T, ? super T> f15558c;

    /* renamed from: d, reason: collision with root package name */
    final int f15559d;

    /* compiled from: ObservableSequenceEqualSingle.java */
    static final class a<T> extends AtomicInteger implements g.a.u0.c {
        private static final long serialVersionUID = -6178010334400373240L;
        final g.a.n0<? super Boolean> actual;
        volatile boolean cancelled;
        final g.a.x0.d<? super T, ? super T> comparer;
        final g.a.g0<? extends T> first;
        final b<T>[] observers;
        final g.a.y0.a.a resources = new g.a.y0.a.a(2);
        final g.a.g0<? extends T> second;
        T v1;
        T v2;

        a(g.a.n0<? super Boolean> n0Var, int i2, g.a.g0<? extends T> g0Var, g.a.g0<? extends T> g0Var2, g.a.x0.d<? super T, ? super T> dVar) {
            this.actual = n0Var;
            this.first = g0Var;
            this.second = g0Var2;
            this.comparer = dVar;
            this.observers = new b[]{new b<>(this, 0, i2), new b<>(this, 1, i2)};
        }

        void cancel(g.a.y0.f.c<T> cVar, g.a.y0.f.c<T> cVar2) {
            this.cancelled = true;
            cVar.clear();
            cVar2.clear();
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() == 0) {
                b<T>[] bVarArr = this.observers;
                bVarArr[0].f15561b.clear();
                bVarArr[1].f15561b.clear();
            }
        }

        void drain() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            b<T>[] bVarArr = this.observers;
            b<T> bVar = bVarArr[0];
            g.a.y0.f.c<T> cVar = bVar.f15561b;
            b<T> bVar2 = bVarArr[1];
            g.a.y0.f.c<T> cVar2 = bVar2.f15561b;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = bVar.f15563d;
                if (z && (th2 = bVar.f15564e) != null) {
                    cancel(cVar, cVar2);
                    this.actual.onError(th2);
                    return;
                }
                boolean z2 = bVar2.f15563d;
                if (z2 && (th = bVar2.f15564e) != null) {
                    cancel(cVar, cVar2);
                    this.actual.onError(th);
                    return;
                }
                if (this.v1 == null) {
                    this.v1 = cVar.poll();
                }
                boolean z3 = this.v1 == null;
                if (this.v2 == null) {
                    this.v2 = cVar2.poll();
                }
                boolean z4 = this.v2 == null;
                if (z && z2 && z3 && z4) {
                    this.actual.onSuccess(true);
                    return;
                }
                if (z && z2 && z3 != z4) {
                    cancel(cVar, cVar2);
                    this.actual.onSuccess(false);
                    return;
                }
                if (!z3 && !z4) {
                    try {
                        if (!this.comparer.a(this.v1, this.v2)) {
                            cancel(cVar, cVar2);
                            this.actual.onSuccess(false);
                            return;
                        } else {
                            this.v1 = null;
                            this.v2 = null;
                        }
                    } catch (Throwable th3) {
                        g.a.v0.b.b(th3);
                        cancel(cVar, cVar2);
                        this.actual.onError(th3);
                        return;
                    }
                }
                if (z3 || z4) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            cVar.clear();
            cVar2.clear();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        boolean setDisposable(g.a.u0.c cVar, int i2) {
            return this.resources.setResource(i2, cVar);
        }

        void subscribe() {
            b<T>[] bVarArr = this.observers;
            this.first.subscribe(bVarArr[0]);
            this.second.subscribe(bVarArr[1]);
        }
    }

    /* compiled from: ObservableSequenceEqualSingle.java */
    static final class b<T> implements g.a.i0<T> {

        /* renamed from: a, reason: collision with root package name */
        final a<T> f15560a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.y0.f.c<T> f15561b;

        /* renamed from: c, reason: collision with root package name */
        final int f15562c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f15563d;

        /* renamed from: e, reason: collision with root package name */
        Throwable f15564e;

        b(a<T> aVar, int i2, int i3) {
            this.f15560a = aVar;
            this.f15562c = i2;
            this.f15561b = new g.a.y0.f.c<>(i3);
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15563d = true;
            this.f15560a.drain();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15564e = th;
            this.f15563d = true;
            this.f15560a.drain();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15561b.offer(t);
            this.f15560a.drain();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15560a.setDisposable(cVar, this.f15562c);
        }
    }

    public w2(g.a.g0<? extends T> g0Var, g.a.g0<? extends T> g0Var2, g.a.x0.d<? super T, ? super T> dVar, int i2) {
        this.f15556a = g0Var;
        this.f15557b = g0Var2;
        this.f15558c = dVar;
        this.f15559d = i2;
    }

    @Override // g.a.y0.c.d
    public g.a.b0<Boolean> a() {
        return g.a.c1.a.a(new v2(this.f15556a, this.f15557b, this.f15558c, this.f15559d));
    }

    @Override // g.a.k0
    public void b(g.a.n0<? super Boolean> n0Var) {
        a aVar = new a(n0Var, this.f15559d, this.f15556a, this.f15557b, this.f15558c);
        n0Var.onSubscribe(aVar);
        aVar.subscribe();
    }
}
