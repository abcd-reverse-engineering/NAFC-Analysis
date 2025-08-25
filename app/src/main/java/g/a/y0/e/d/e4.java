package g.a.y0.e.d;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: ObservableWithLatestFromMany.java */
/* loaded from: classes2.dex */
public final class e4<T, R> extends g.a.y0.e.d.a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    @g.a.t0.g
    final g.a.g0<?>[] f15094b;

    /* renamed from: c, reason: collision with root package name */
    @g.a.t0.g
    final Iterable<? extends g.a.g0<?>> f15095c;

    /* renamed from: d, reason: collision with root package name */
    @g.a.t0.f
    final g.a.x0.o<? super Object[], R> f15096d;

    /* compiled from: ObservableWithLatestFromMany.java */
    final class a implements g.a.x0.o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // g.a.x0.o
        public R apply(T t) throws Exception {
            return (R) g.a.y0.b.b.a(e4.this.f15096d.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }

    /* compiled from: ObservableWithLatestFromMany.java */
    static final class b<T, R> extends AtomicInteger implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = 1577321883966341961L;
        final g.a.i0<? super R> actual;
        final g.a.x0.o<? super Object[], R> combiner;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference<g.a.u0.c> f15098d;
        volatile boolean done;
        final g.a.y0.j.c error;
        final c[] observers;
        final AtomicReferenceArray<Object> values;

        b(g.a.i0<? super R> i0Var, g.a.x0.o<? super Object[], R> oVar, int i2) {
            this.actual = i0Var;
            this.combiner = oVar;
            c[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c(this, i3);
            }
            this.observers = cVarArr;
            this.values = new AtomicReferenceArray<>(i2);
            this.f15098d = new AtomicReference<>();
            this.error = new g.a.y0.j.c();
        }

        void cancelAllBut(int i2) {
            c[] cVarArr = this.observers;
            for (int i3 = 0; i3 < cVarArr.length; i3++) {
                if (i3 != i2) {
                    cVarArr[i3].dispose();
                }
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this.f15098d);
            for (c cVar : this.observers) {
                cVar.dispose();
            }
        }

        void innerComplete(int i2, boolean z) {
            if (z) {
                return;
            }
            this.done = true;
            cancelAllBut(i2);
            g.a.y0.j.l.a(this.actual, this, this.error);
        }

        void innerError(int i2, Throwable th) {
            this.done = true;
            g.a.y0.a.d.dispose(this.f15098d);
            cancelAllBut(i2);
            g.a.y0.j.l.a((g.a.i0<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void innerNext(int i2, Object obj) {
            this.values.set(i2, obj);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(this.f15098d.get());
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            g.a.y0.j.l.a(this.actual, this, this.error);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            g.a.y0.j.l.a((g.a.i0<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i2 = 0;
            objArr[0] = t;
            while (i2 < length) {
                Object obj = atomicReferenceArray.get(i2);
                if (obj == null) {
                    return;
                }
                i2++;
                objArr[i2] = obj;
            }
            try {
                g.a.y0.j.l.a(this.actual, g.a.y0.b.b.a(this.combiner.apply(objArr), "combiner returned a null value"), this, this.error);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this.f15098d, cVar);
        }

        void subscribe(g.a.g0<?>[] g0VarArr, int i2) {
            c[] cVarArr = this.observers;
            AtomicReference<g.a.u0.c> atomicReference = this.f15098d;
            for (int i3 = 0; i3 < i2 && !g.a.y0.a.d.isDisposed(atomicReference.get()) && !this.done; i3++) {
                g0VarArr[i3].subscribe(cVarArr[i3]);
            }
        }
    }

    /* compiled from: ObservableWithLatestFromMany.java */
    static final class c extends AtomicReference<g.a.u0.c> implements g.a.i0<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final b<?, ?> parent;

        c(b<?, ?> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.i0
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // g.a.i0
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }
    }

    public e4(@g.a.t0.f g.a.g0<T> g0Var, @g.a.t0.f g.a.g0<?>[] g0VarArr, @g.a.t0.f g.a.x0.o<? super Object[], R> oVar) {
        super(g0Var);
        this.f15094b = g0VarArr;
        this.f15095c = null;
        this.f15096d = oVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super R> i0Var) {
        int length;
        g.a.g0<?>[] g0VarArr = this.f15094b;
        if (g0VarArr == null) {
            g0VarArr = new g.a.g0[8];
            try {
                length = 0;
                for (g.a.g0<?> g0Var : this.f15095c) {
                    if (length == g0VarArr.length) {
                        g0VarArr = (g.a.g0[]) Arrays.copyOf(g0VarArr, (length >> 1) + length);
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
            new u1(this.f14934a, new a()).d((g.a.i0) i0Var);
            return;
        }
        b bVar = new b(i0Var, this.f15096d, length);
        i0Var.onSubscribe(bVar);
        bVar.subscribe(g0VarArr, length);
        this.f14934a.subscribe(bVar);
    }

    public e4(@g.a.t0.f g.a.g0<T> g0Var, @g.a.t0.f Iterable<? extends g.a.g0<?>> iterable, @g.a.t0.f g.a.x0.o<? super Object[], R> oVar) {
        super(g0Var);
        this.f15094b = null;
        this.f15095c = iterable;
        this.f15096d = oVar;
    }
}
