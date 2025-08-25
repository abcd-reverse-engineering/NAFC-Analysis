package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableSequenceEqual.java */
/* loaded from: classes2.dex */
public final class v2<T> extends g.a.b0<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<? extends T> f15533a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.g0<? extends T> f15534b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.d<? super T, ? super T> f15535c;

    /* renamed from: d, reason: collision with root package name */
    final int f15536d;

    /* compiled from: ObservableSequenceEqual.java */
    static final class a<T> extends AtomicInteger implements g.a.u0.c {
        private static final long serialVersionUID = -6178010334400373240L;
        final g.a.i0<? super Boolean> actual;
        volatile boolean cancelled;
        final g.a.x0.d<? super T, ? super T> comparer;
        final g.a.g0<? extends T> first;
        final b<T>[] observers;
        final g.a.y0.a.a resources = new g.a.y0.a.a(2);
        final g.a.g0<? extends T> second;
        T v1;
        T v2;

        a(g.a.i0<? super Boolean> i0Var, int i2, g.a.g0<? extends T> g0Var, g.a.g0<? extends T> g0Var2, g.a.x0.d<? super T, ? super T> dVar) {
            this.actual = i0Var;
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
                bVarArr[0].f15538b.clear();
                bVarArr[1].f15538b.clear();
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
            g.a.y0.f.c<T> cVar = bVar.f15538b;
            b<T> bVar2 = bVarArr[1];
            g.a.y0.f.c<T> cVar2 = bVar2.f15538b;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = bVar.f15540d;
                if (z && (th2 = bVar.f15541e) != null) {
                    cancel(cVar, cVar2);
                    this.actual.onError(th2);
                    return;
                }
                boolean z2 = bVar2.f15540d;
                if (z2 && (th = bVar2.f15541e) != null) {
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
                    this.actual.onNext(true);
                    this.actual.onComplete();
                    return;
                }
                if (z && z2 && z3 != z4) {
                    cancel(cVar, cVar2);
                    this.actual.onNext(false);
                    this.actual.onComplete();
                    return;
                }
                if (!z3 && !z4) {
                    try {
                        if (!this.comparer.a(this.v1, this.v2)) {
                            cancel(cVar, cVar2);
                            this.actual.onNext(false);
                            this.actual.onComplete();
                            return;
                        }
                        this.v1 = null;
                        this.v2 = null;
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

    /* compiled from: ObservableSequenceEqual.java */
    static final class b<T> implements g.a.i0<T> {

        /* renamed from: a, reason: collision with root package name */
        final a<T> f15537a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.y0.f.c<T> f15538b;

        /* renamed from: c, reason: collision with root package name */
        final int f15539c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f15540d;

        /* renamed from: e, reason: collision with root package name */
        Throwable f15541e;

        b(a<T> aVar, int i2, int i3) {
            this.f15537a = aVar;
            this.f15539c = i2;
            this.f15538b = new g.a.y0.f.c<>(i3);
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15540d = true;
            this.f15537a.drain();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15541e = th;
            this.f15540d = true;
            this.f15537a.drain();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15538b.offer(t);
            this.f15537a.drain();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15537a.setDisposable(cVar, this.f15539c);
        }
    }

    public v2(g.a.g0<? extends T> g0Var, g.a.g0<? extends T> g0Var2, g.a.x0.d<? super T, ? super T> dVar, int i2) {
        this.f15533a = g0Var;
        this.f15534b = g0Var2;
        this.f15535c = dVar;
        this.f15536d = i2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super Boolean> i0Var) {
        a aVar = new a(i0Var, this.f15536d, this.f15533a, this.f15534b, this.f15535c);
        i0Var.onSubscribe(aVar);
        aVar.subscribe();
    }
}
