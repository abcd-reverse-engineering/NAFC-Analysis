package g.a.y0.e.c;

import g.a.y0.e.c.u0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeZipArray.java */
/* loaded from: classes2.dex */
public final class r1<T, R> extends g.a.s<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<? extends T>[] f14888a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super Object[], ? extends R> f14889b;

    /* compiled from: MaybeZipArray.java */
    final class a implements g.a.x0.o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // g.a.x0.o
        public R apply(T t) throws Exception {
            return (R) g.a.y0.b.b.a(r1.this.f14889b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    /* compiled from: MaybeZipArray.java */
    static final class b<T, R> extends AtomicInteger implements g.a.u0.c {
        private static final long serialVersionUID = -5556924161382950569L;
        final g.a.v<? super R> actual;
        final c<T>[] observers;
        final Object[] values;
        final g.a.x0.o<? super Object[], ? extends R> zipper;

        b(g.a.v<? super R> vVar, int i2, g.a.x0.o<? super Object[], ? extends R> oVar) {
            super(i2);
            this.actual = vVar;
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

        void innerComplete(int i2) {
            if (getAndSet(0) > 0) {
                disposeExcept(i2);
                this.actual.onComplete();
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

    /* compiled from: MaybeZipArray.java */
    static final class c<T> extends AtomicReference<g.a.u0.c> implements g.a.v<T> {
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

        @Override // g.a.v
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.parent.innerError(th, this.index);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }
    }

    public r1(g.a.y<? extends T>[] yVarArr, g.a.x0.o<? super Object[], ? extends R> oVar) {
        this.f14888a = yVarArr;
        this.f14889b = oVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super R> vVar) {
        g.a.y<? extends T>[] yVarArr = this.f14888a;
        int length = yVarArr.length;
        if (length == 1) {
            yVarArr[0].a(new u0.a(vVar, new a()));
            return;
        }
        b bVar = new b(vVar, length, this.f14889b);
        vVar.onSubscribe(bVar);
        for (int i2 = 0; i2 < length && !bVar.isDisposed(); i2++) {
            g.a.y<? extends T> yVar = yVarArr[i2];
            if (yVar == null) {
                bVar.innerError(new NullPointerException("One of the sources is null"), i2);
                return;
            }
            yVar.a(bVar.observers[i2]);
        }
    }
}
