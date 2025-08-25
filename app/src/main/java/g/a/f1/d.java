package g.a.f1;

import g.a.s;
import g.a.v;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeSubject.java */
/* loaded from: classes2.dex */
public final class d<T> extends s<T> implements v<T> {

    /* renamed from: e, reason: collision with root package name */
    static final a[] f13779e = new a[0];

    /* renamed from: f, reason: collision with root package name */
    static final a[] f13780f = new a[0];

    /* renamed from: c, reason: collision with root package name */
    T f13783c;

    /* renamed from: d, reason: collision with root package name */
    Throwable f13784d;

    /* renamed from: b, reason: collision with root package name */
    final AtomicBoolean f13782b = new AtomicBoolean();

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<a<T>[]> f13781a = new AtomicReference<>(f13779e);

    /* compiled from: MaybeSubject.java */
    static final class a<T> extends AtomicReference<d<T>> implements g.a.u0.c {
        private static final long serialVersionUID = -7650903191002190468L;
        final v<? super T> actual;

        a(v<? super T> vVar, d<T> dVar) {
            this.actual = vVar;
            lazySet(dVar);
        }

        @Override // g.a.u0.c
        public void dispose() {
            d<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b((a) this);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() == null;
        }
    }

    d() {
    }

    @g.a.t0.d
    public static <T> d<T> A() {
        return new d<>();
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f13781a.get();
            if (aVarArr == f13780f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f13781a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // g.a.s
    protected void b(v<? super T> vVar) {
        a<T> aVar = new a<>(vVar, this);
        vVar.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.isDisposed()) {
                b((a) aVar);
                return;
            }
            return;
        }
        Throwable th = this.f13784d;
        if (th != null) {
            vVar.onError(th);
            return;
        }
        T t = this.f13783c;
        if (t == null) {
            vVar.onComplete();
        } else {
            vVar.onSuccess(t);
        }
    }

    @Override // g.a.v
    public void onComplete() {
        if (this.f13782b.compareAndSet(false, true)) {
            for (a<T> aVar : this.f13781a.getAndSet(f13780f)) {
                aVar.actual.onComplete();
            }
        }
    }

    @Override // g.a.v
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("Null errors are not allowed in 2.x");
        }
        if (!this.f13782b.compareAndSet(false, true)) {
            g.a.c1.a.b(th);
            return;
        }
        this.f13784d = th;
        for (a<T> aVar : this.f13781a.getAndSet(f13780f)) {
            aVar.actual.onError(th);
        }
    }

    @Override // g.a.v
    public void onSubscribe(g.a.u0.c cVar) {
        if (this.f13781a.get() == f13780f) {
            cVar.dispose();
        }
    }

    @Override // g.a.v, g.a.n0
    public void onSuccess(T t) {
        if (t == null) {
            onError(new NullPointerException("Null values are not allowed in 2.x"));
            return;
        }
        if (this.f13782b.compareAndSet(false, true)) {
            this.f13783c = t;
            for (a<T> aVar : this.f13781a.getAndSet(f13780f)) {
                aVar.actual.onSuccess(t);
            }
        }
    }

    public Throwable t() {
        if (this.f13781a.get() == f13780f) {
            return this.f13784d;
        }
        return null;
    }

    public T u() {
        if (this.f13781a.get() == f13780f) {
            return this.f13783c;
        }
        return null;
    }

    public boolean v() {
        return this.f13781a.get() == f13780f && this.f13783c == null && this.f13784d == null;
    }

    public boolean w() {
        return this.f13781a.get().length != 0;
    }

    public boolean x() {
        return this.f13781a.get() == f13780f && this.f13784d != null;
    }

    public boolean y() {
        return this.f13781a.get() == f13780f && this.f13783c != null;
    }

    int z() {
        return this.f13781a.get().length;
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f13781a.get();
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
                aVarArr2 = f13779e;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f13781a.compareAndSet(aVarArr, aVarArr2));
    }
}
