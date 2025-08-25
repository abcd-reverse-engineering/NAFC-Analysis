package g.a.f1;

import g.a.k0;
import g.a.n0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleSubject.java */
/* loaded from: classes2.dex */
public final class h<T> extends k0<T> implements n0<T> {

    /* renamed from: e, reason: collision with root package name */
    static final a[] f13799e = new a[0];

    /* renamed from: f, reason: collision with root package name */
    static final a[] f13800f = new a[0];

    /* renamed from: c, reason: collision with root package name */
    T f13803c;

    /* renamed from: d, reason: collision with root package name */
    Throwable f13804d;

    /* renamed from: b, reason: collision with root package name */
    final AtomicBoolean f13802b = new AtomicBoolean();

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<a<T>[]> f13801a = new AtomicReference<>(f13799e);

    /* compiled from: SingleSubject.java */
    static final class a<T> extends AtomicReference<h<T>> implements g.a.u0.c {
        private static final long serialVersionUID = -7650903191002190468L;
        final n0<? super T> actual;

        a(n0<? super T> n0Var, h<T> hVar) {
            this.actual = n0Var;
            lazySet(hVar);
        }

        @Override // g.a.u0.c
        public void dispose() {
            h<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b((a) this);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() == null;
        }
    }

    h() {
    }

    @g.a.t0.f
    @g.a.t0.d
    public static <T> h<T> x() {
        return new h<>();
    }

    boolean a(@g.a.t0.f a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f13801a.get();
            if (aVarArr == f13800f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f13801a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // g.a.k0
    protected void b(@g.a.t0.f n0<? super T> n0Var) {
        a<T> aVar = new a<>(n0Var, this);
        n0Var.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.isDisposed()) {
                b((a) aVar);
            }
        } else {
            Throwable th = this.f13804d;
            if (th != null) {
                n0Var.onError(th);
            } else {
                n0Var.onSuccess(this.f13803c);
            }
        }
    }

    @Override // g.a.n0
    public void onError(@g.a.t0.f Throwable th) {
        if (th == null) {
            th = new NullPointerException("Null errors are not allowed in 2.x");
        }
        if (!this.f13802b.compareAndSet(false, true)) {
            g.a.c1.a.b(th);
            return;
        }
        this.f13804d = th;
        for (a<T> aVar : this.f13801a.getAndSet(f13800f)) {
            aVar.actual.onError(th);
        }
    }

    @Override // g.a.n0
    public void onSubscribe(@g.a.t0.f g.a.u0.c cVar) {
        if (this.f13801a.get() == f13800f) {
            cVar.dispose();
        }
    }

    @Override // g.a.n0
    public void onSuccess(@g.a.t0.f T t) {
        if (t == null) {
            onError(new NullPointerException("Null values are not allowed in 2.x"));
            return;
        }
        if (this.f13802b.compareAndSet(false, true)) {
            this.f13803c = t;
            for (a<T> aVar : this.f13801a.getAndSet(f13800f)) {
                aVar.actual.onSuccess(t);
            }
        }
    }

    @g.a.t0.g
    public Throwable r() {
        if (this.f13801a.get() == f13800f) {
            return this.f13804d;
        }
        return null;
    }

    @g.a.t0.g
    public T s() {
        if (this.f13801a.get() == f13800f) {
            return this.f13803c;
        }
        return null;
    }

    public boolean t() {
        return this.f13801a.get().length != 0;
    }

    public boolean u() {
        return this.f13801a.get() == f13800f && this.f13804d != null;
    }

    public boolean v() {
        return this.f13801a.get() == f13800f && this.f13803c != null;
    }

    int w() {
        return this.f13801a.get().length;
    }

    void b(@g.a.t0.f a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f13801a.get();
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
                aVarArr2 = f13799e;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f13801a.compareAndSet(aVarArr, aVarArr2));
    }
}
