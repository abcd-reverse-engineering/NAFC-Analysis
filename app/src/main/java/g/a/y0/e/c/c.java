package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeCache.java */
/* loaded from: classes2.dex */
public final class c<T> extends g.a.s<T> implements g.a.v<T> {

    /* renamed from: e, reason: collision with root package name */
    static final a[] f14763e = new a[0];

    /* renamed from: f, reason: collision with root package name */
    static final a[] f14764f = new a[0];

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<g.a.y<T>> f14765a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<a<T>[]> f14766b = new AtomicReference<>(f14763e);

    /* renamed from: c, reason: collision with root package name */
    T f14767c;

    /* renamed from: d, reason: collision with root package name */
    Throwable f14768d;

    /* compiled from: MaybeCache.java */
    static final class a<T> extends AtomicReference<c<T>> implements g.a.u0.c {
        private static final long serialVersionUID = -5791853038359966195L;
        final g.a.v<? super T> actual;

        a(g.a.v<? super T> vVar, c<T> cVar) {
            super(cVar);
            this.actual = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            c<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b((a) this);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() == null;
        }
    }

    public c(g.a.y<T> yVar) {
        this.f14765a = new AtomicReference<>(yVar);
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f14766b.get();
            if (aVarArr == f14764f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f14766b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        a<T> aVar = new a<>(vVar, this);
        vVar.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.isDisposed()) {
                b((a) aVar);
                return;
            }
            g.a.y<T> andSet = this.f14765a.getAndSet(null);
            if (andSet != null) {
                andSet.a(this);
                return;
            }
            return;
        }
        if (aVar.isDisposed()) {
            return;
        }
        Throwable th = this.f14768d;
        if (th != null) {
            vVar.onError(th);
            return;
        }
        T t = this.f14767c;
        if (t != null) {
            vVar.onSuccess(t);
        } else {
            vVar.onComplete();
        }
    }

    @Override // g.a.v
    public void onComplete() {
        for (a<T> aVar : this.f14766b.getAndSet(f14764f)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onComplete();
            }
        }
    }

    @Override // g.a.v
    public void onError(Throwable th) {
        this.f14768d = th;
        for (a<T> aVar : this.f14766b.getAndSet(f14764f)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onError(th);
            }
        }
    }

    @Override // g.a.v
    public void onSubscribe(g.a.u0.c cVar) {
    }

    @Override // g.a.v, g.a.n0
    public void onSuccess(T t) {
        this.f14767c = t;
        for (a<T> aVar : this.f14766b.getAndSet(f14764f)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onSuccess(t);
            }
        }
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f14766b.get();
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
                aVarArr2 = f14763e;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f14766b.compareAndSet(aVarArr, aVarArr2));
    }
}
