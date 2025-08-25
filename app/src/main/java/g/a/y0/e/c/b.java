package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: MaybeAmb.java */
/* loaded from: classes2.dex */
public final class b<T> extends g.a.s<T> {

    /* renamed from: a, reason: collision with root package name */
    private final g.a.y<? extends T>[] f14749a;

    /* renamed from: b, reason: collision with root package name */
    private final Iterable<? extends g.a.y<? extends T>> f14750b;

    /* compiled from: MaybeAmb.java */
    static final class a<T> extends AtomicBoolean implements g.a.v<T>, g.a.u0.c {
        private static final long serialVersionUID = -7044685185359438206L;
        final g.a.v<? super T> actual;
        final g.a.u0.b set = new g.a.u0.b();

        a(g.a.v<? super T> vVar) {
            this.actual = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.set.dispose();
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get();
        }

        @Override // g.a.v
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.actual.onComplete();
            }
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                g.a.c1.a.b(th);
            } else {
                this.set.dispose();
                this.actual.onError(th);
            }
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            this.set.b(cVar);
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.actual.onSuccess(t);
            }
        }
    }

    public b(g.a.y<? extends T>[] yVarArr, Iterable<? extends g.a.y<? extends T>> iterable) {
        this.f14749a = yVarArr;
        this.f14750b = iterable;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        int length;
        g.a.y<? extends T>[] yVarArr = this.f14749a;
        if (yVarArr == null) {
            yVarArr = new g.a.y[8];
            try {
                length = 0;
                for (g.a.y<? extends T> yVar : this.f14750b) {
                    if (yVar == null) {
                        g.a.y0.a.e.error(new NullPointerException("One of the sources is null"), vVar);
                        return;
                    }
                    if (length == yVarArr.length) {
                        g.a.y<? extends T>[] yVarArr2 = new g.a.y[(length >> 2) + length];
                        System.arraycopy(yVarArr, 0, yVarArr2, 0, length);
                        yVarArr = yVarArr2;
                    }
                    int i2 = length + 1;
                    yVarArr[length] = yVar;
                    length = i2;
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.y0.a.e.error(th, vVar);
                return;
            }
        } else {
            length = yVarArr.length;
        }
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        for (int i3 = 0; i3 < length; i3++) {
            g.a.y<? extends T> yVar2 = yVarArr[i3];
            if (aVar.isDisposed()) {
                return;
            }
            if (yVar2 == null) {
                aVar.onError(new NullPointerException("One of the MaybeSources is null"));
                return;
            }
            yVar2.a(aVar);
        }
        if (length == 0) {
            vVar.onComplete();
        }
    }
}
