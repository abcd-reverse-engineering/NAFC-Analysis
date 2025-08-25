package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleCache.java */
/* loaded from: classes2.dex */
public final class b<T> extends g.a.k0<T> implements g.a.n0<T> {

    /* renamed from: f, reason: collision with root package name */
    static final a[] f15727f = new a[0];

    /* renamed from: g, reason: collision with root package name */
    static final a[] f15728g = new a[0];

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<? extends T> f15729a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicInteger f15730b = new AtomicInteger();

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<a<T>[]> f15731c = new AtomicReference<>(f15727f);

    /* renamed from: d, reason: collision with root package name */
    T f15732d;

    /* renamed from: e, reason: collision with root package name */
    Throwable f15733e;

    /* compiled from: SingleCache.java */
    static final class a<T> extends AtomicBoolean implements g.a.u0.c {
        private static final long serialVersionUID = 7514387411091976596L;
        final g.a.n0<? super T> actual;
        final b<T> parent;

        a(g.a.n0<? super T> n0Var, b<T> bVar) {
            this.actual = n0Var;
            this.parent = bVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.b((a) this);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get();
        }
    }

    public b(g.a.q0<? extends T> q0Var) {
        this.f15729a = q0Var;
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f15731c.get();
            if (aVarArr == f15728g) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f15731c.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        a<T> aVar = new a<>(n0Var, this);
        n0Var.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.isDisposed()) {
                b((a) aVar);
            }
            if (this.f15730b.getAndIncrement() == 0) {
                this.f15729a.a(this);
                return;
            }
            return;
        }
        Throwable th = this.f15733e;
        if (th != null) {
            n0Var.onError(th);
        } else {
            n0Var.onSuccess(this.f15732d);
        }
    }

    @Override // g.a.n0
    public void onError(Throwable th) {
        this.f15733e = th;
        for (a<T> aVar : this.f15731c.getAndSet(f15728g)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onError(th);
            }
        }
    }

    @Override // g.a.n0
    public void onSubscribe(g.a.u0.c cVar) {
    }

    @Override // g.a.n0
    public void onSuccess(T t) {
        this.f15732d = t;
        for (a<T> aVar : this.f15731c.getAndSet(f15728g)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onSuccess(t);
            }
        }
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f15731c.get();
            int length = aVarArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (aVarArr[i3] == aVar) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                aVarArr2 = f15727f;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f15731c.compareAndSet(aVarArr, aVarArr2));
    }
}
