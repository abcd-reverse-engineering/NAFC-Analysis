package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableAmb.java */
/* loaded from: classes2.dex */
public final class h<T> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<? extends T>[] f15171a;

    /* renamed from: b, reason: collision with root package name */
    final Iterable<? extends g.a.g0<? extends T>> f15172b;

    /* compiled from: ObservableAmb.java */
    static final class b<T> extends AtomicReference<g.a.u0.c> implements g.a.i0<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        final g.a.i0<? super T> actual;
        final int index;
        final a<T> parent;
        boolean won;

        b(a<T> aVar, int i2, g.a.i0<? super T> i0Var) {
            this.parent = aVar;
            this.index = i2;
            this.actual = i0Var;
        }

        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else if (this.parent.a(this.index)) {
                this.won = true;
                this.actual.onComplete();
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (!this.parent.a(this.index)) {
                g.a.c1.a.b(th);
            } else {
                this.won = true;
                this.actual.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.won) {
                this.actual.onNext(t);
            } else if (!this.parent.a(this.index)) {
                get().dispose();
            } else {
                this.won = true;
                this.actual.onNext(t);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }
    }

    public h(g.a.g0<? extends T>[] g0VarArr, Iterable<? extends g.a.g0<? extends T>> iterable) {
        this.f15171a = g0VarArr;
        this.f15172b = iterable;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        int length;
        g.a.g0<? extends T>[] g0VarArr = this.f15171a;
        if (g0VarArr == null) {
            g0VarArr = new g.a.b0[8];
            try {
                length = 0;
                for (g.a.g0<? extends T> g0Var : this.f15172b) {
                    if (g0Var == null) {
                        g.a.y0.a.e.error(new NullPointerException("One of the sources is null"), i0Var);
                        return;
                    }
                    if (length == g0VarArr.length) {
                        g.a.g0<? extends T>[] g0VarArr2 = new g.a.g0[(length >> 2) + length];
                        System.arraycopy(g0VarArr, 0, g0VarArr2, 0, length);
                        g0VarArr = g0VarArr2;
                    }
                    int i2 = length + 1;
                    g0VarArr[length] = g0Var;
                    length = i2;
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.y0.a.e.error(th, i0Var);
                return;
            }
        } else {
            length = g0VarArr.length;
        }
        if (length == 0) {
            g.a.y0.a.e.complete(i0Var);
        } else if (length == 1) {
            g0VarArr[0].subscribe(i0Var);
        } else {
            new a(i0Var, length).a(g0VarArr);
        }
    }

    /* compiled from: ObservableAmb.java */
    static final class a<T> implements g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15173a;

        /* renamed from: b, reason: collision with root package name */
        final b<T>[] f15174b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicInteger f15175c = new AtomicInteger();

        a(g.a.i0<? super T> i0Var, int i2) {
            this.f15173a = i0Var;
            this.f15174b = new b[i2];
        }

        public void a(g.a.g0<? extends T>[] g0VarArr) {
            b<T>[] bVarArr = this.f15174b;
            int length = bVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                bVarArr[i2] = new b<>(this, i3, this.f15173a);
                i2 = i3;
            }
            this.f15175c.lazySet(0);
            this.f15173a.onSubscribe(this);
            for (int i4 = 0; i4 < length && this.f15175c.get() == 0; i4++) {
                g0VarArr[i4].subscribe(bVarArr[i4]);
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.f15175c.get() != -1) {
                this.f15175c.lazySet(-1);
                for (b<T> bVar : this.f15174b) {
                    bVar.dispose();
                }
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15175c.get() == -1;
        }

        public boolean a(int i2) {
            int i3 = this.f15175c.get();
            int i4 = 0;
            if (i3 != 0) {
                return i3 == i2;
            }
            if (!this.f15175c.compareAndSet(0, i2)) {
                return false;
            }
            b<T>[] bVarArr = this.f15174b;
            int length = bVarArr.length;
            while (i4 < length) {
                int i5 = i4 + 1;
                if (i5 != i2) {
                    bVarArr[i4].dispose();
                }
                i4 = i5;
            }
            return true;
        }
    }
}
