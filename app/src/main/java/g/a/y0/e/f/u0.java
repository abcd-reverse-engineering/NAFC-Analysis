package g.a.y0.e.f;

import g.a.y0.e.f.h0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleZipArray.java */
/* loaded from: classes2.dex */
public final class u0<T, R> extends g.a.k0<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<? extends T>[] f15861a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super Object[], ? extends R> f15862b;

    /* compiled from: SingleZipArray.java */
    final class a implements g.a.x0.o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // g.a.x0.o
        public R apply(T t) throws Exception {
            return (R) g.a.y0.b.b.a(u0.this.f15862b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    /* compiled from: SingleZipArray.java */
    static final class b<T, R> extends AtomicInteger implements g.a.u0.c {
        private static final long serialVersionUID = -5556924161382950569L;
        final g.a.n0<? super R> actual;
        final c<T>[] observers;
        final Object[] values;
        final g.a.x0.o<? super Object[], ? extends R> zipper;

        b(g.a.n0<? super R> n0Var, int i2, g.a.x0.o<? super Object[], ? extends R> oVar) {
            super(i2);
            this.actual = n0Var;
            this.zipper = oVar;
            c<T>[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c<>(this, i3);
            }
            this.observers = cVarArr;
            this.values = new Object[i2];
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (c<T> cVar : this.observers) {
                    cVar.dispose();
                }
            }
        }

        void disposeExcept(int i2) {
            c<T>[] cVarArr = this.observers;
            int length = cVarArr.length;
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3].dispose();
            }
            while (true) {
                i2++;
                if (i2 >= length) {
                    return;
                } else {
                    cVarArr[i2].dispose();
                }
            }
        }

        void innerError(Throwable th, int i2) {
            if (getAndSet(0) <= 0) {
                g.a.c1.a.b(th);
            } else {
                disposeExcept(i2);
                this.actual.onError(th);
            }
        }

        void innerSuccess(T t, int i2) {
            this.values[i2] = t;
            if (decrementAndGet() == 0) {
                try {
                    this.actual.onSuccess(g.a.y0.b.b.a(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.actual.onError(th);
                }
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() <= 0;
        }
    }

    /* compiled from: SingleZipArray.java */
    static final class c<T> extends AtomicReference<g.a.u0.c> implements g.a.n0<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final b<T, ?> parent;

        c(b<T, ?> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.parent.innerError(th, this.index);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }
    }

    public u0(g.a.q0<? extends T>[] q0VarArr, g.a.x0.o<? super Object[], ? extends R> oVar) {
        this.f15861a = q0VarArr;
        this.f15862b = oVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super R> n0Var) {
        g.a.q0<? extends T>[] q0VarArr = this.f15861a;
        int length = q0VarArr.length;
        if (length == 1) {
            q0VarArr[0].a(new h0.a(n0Var, new a()));
            return;
        }
        b bVar = new b(n0Var, length, this.f15862b);
        n0Var.onSubscribe(bVar);
        for (int i2 = 0; i2 < length && !bVar.isDisposed(); i2++) {
            g.a.q0<? extends T> q0Var = q0VarArr[i2];
            if (q0Var == null) {
                bVar.innerError(new NullPointerException("One of the sources is null"), i2);
                return;
            }
            q0Var.a(bVar.observers[i2]);
        }
    }
}
