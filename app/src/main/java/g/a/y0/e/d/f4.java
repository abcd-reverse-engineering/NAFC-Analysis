package g.a.y0.e.d;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableZip.java */
/* loaded from: classes2.dex */
public final class f4<T, R> extends g.a.b0<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<? extends T>[] f15122a;

    /* renamed from: b, reason: collision with root package name */
    final Iterable<? extends g.a.g0<? extends T>> f15123b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super Object[], ? extends R> f15124c;

    /* renamed from: d, reason: collision with root package name */
    final int f15125d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f15126e;

    /* compiled from: ObservableZip.java */
    static final class a<T, R> extends AtomicInteger implements g.a.u0.c {
        private static final long serialVersionUID = 2983708048395377667L;
        final g.a.i0<? super R> actual;
        volatile boolean cancelled;
        final boolean delayError;
        final b<T, R>[] observers;
        final T[] row;
        final g.a.x0.o<? super Object[], ? extends R> zipper;

        a(g.a.i0<? super R> i0Var, g.a.x0.o<? super Object[], ? extends R> oVar, int i2, boolean z) {
            this.actual = i0Var;
            this.zipper = oVar;
            this.observers = new b[i2];
            this.row = (T[]) new Object[i2];
            this.delayError = z;
        }

        void cancel() {
            clear();
            cancelSources();
        }

        void cancelSources() {
            for (b<T, R> bVar : this.observers) {
                bVar.a();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, g.a.i0<? super R> i0Var, boolean z3, b<?, ?> bVar) {
            if (this.cancelled) {
                cancel();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = bVar.f15130d;
                cancel();
                if (th != null) {
                    i0Var.onError(th);
                } else {
                    i0Var.onComplete();
                }
                return true;
            }
            Throwable th2 = bVar.f15130d;
            if (th2 != null) {
                cancel();
                i0Var.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            cancel();
            i0Var.onComplete();
            return true;
        }

        void clear() {
            for (b<T, R> bVar : this.observers) {
                bVar.f15128b.clear();
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear();
            }
        }

        public void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            b<T, R>[] bVarArr = this.observers;
            g.a.i0<? super R> i0Var = this.actual;
            T[] tArr = this.row;
            boolean z = this.delayError;
            int iAddAndGet = 1;
            while (true) {
                int i2 = 0;
                int i3 = 0;
                for (b<T, R> bVar : bVarArr) {
                    if (tArr[i3] == null) {
                        boolean z2 = bVar.f15129c;
                        T tPoll = bVar.f15128b.poll();
                        boolean z3 = tPoll == null;
                        if (checkTerminated(z2, z3, i0Var, z, bVar)) {
                            return;
                        }
                        if (z3) {
                            i2++;
                        } else {
                            tArr[i3] = tPoll;
                        }
                    } else if (bVar.f15129c && !z && (th = bVar.f15130d) != null) {
                        cancel();
                        i0Var.onError(th);
                        return;
                    }
                    i3++;
                }
                if (i2 != 0) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        i0Var.onNext((Object) g.a.y0.b.b.a(this.zipper.apply(tArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        g.a.v0.b.b(th2);
                        cancel();
                        i0Var.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(g.a.g0<? extends T>[] g0VarArr, int i2) {
            b<T, R>[] bVarArr = this.observers;
            int length = bVarArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                bVarArr[i3] = new b<>(this, i2);
            }
            lazySet(0);
            this.actual.onSubscribe(this);
            for (int i4 = 0; i4 < length && !this.cancelled; i4++) {
                g0VarArr[i4].subscribe(bVarArr[i4]);
            }
        }
    }

    /* compiled from: ObservableZip.java */
    static final class b<T, R> implements g.a.i0<T> {

        /* renamed from: a, reason: collision with root package name */
        final a<T, R> f15127a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.y0.f.c<T> f15128b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f15129c;

        /* renamed from: d, reason: collision with root package name */
        Throwable f15130d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReference<g.a.u0.c> f15131e = new AtomicReference<>();

        b(a<T, R> aVar, int i2) {
            this.f15127a = aVar;
            this.f15128b = new g.a.y0.f.c<>(i2);
        }

        public void a() {
            g.a.y0.a.d.dispose(this.f15131e);
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15129c = true;
            this.f15127a.drain();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15130d = th;
            this.f15129c = true;
            this.f15127a.drain();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15128b.offer(t);
            this.f15127a.drain();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this.f15131e, cVar);
        }
    }

    public f4(g.a.g0<? extends T>[] g0VarArr, Iterable<? extends g.a.g0<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar, int i2, boolean z) {
        this.f15122a = g0VarArr;
        this.f15123b = iterable;
        this.f15124c = oVar;
        this.f15125d = i2;
        this.f15126e = z;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super R> i0Var) {
        int length;
        g.a.g0<? extends T>[] g0VarArr = this.f15122a;
        if (g0VarArr == null) {
            g0VarArr = new g.a.b0[8];
            length = 0;
            for (g.a.g0<? extends T> g0Var : this.f15123b) {
                if (length == g0VarArr.length) {
                    g.a.g0<? extends T>[] g0VarArr2 = new g.a.g0[(length >> 2) + length];
                    System.arraycopy(g0VarArr, 0, g0VarArr2, 0, length);
                    g0VarArr = g0VarArr2;
                }
                g0VarArr[length] = g0Var;
                length++;
            }
        } else {
            length = g0VarArr.length;
        }
        if (length == 0) {
            g.a.y0.a.e.complete(i0Var);
        } else {
            new a(i0Var, this.f15124c, length, this.f15126e).subscribe(g0VarArr, this.f15125d);
        }
    }
}
