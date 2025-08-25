package g.a.f1;

import g.a.i0;
import g.a.y0.d.l;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AsyncSubject.java */
/* loaded from: classes2.dex */
public final class a<T> extends i<T> {

    /* renamed from: d, reason: collision with root package name */
    static final C0175a[] f13751d = new C0175a[0];

    /* renamed from: e, reason: collision with root package name */
    static final C0175a[] f13752e = new C0175a[0];

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<C0175a<T>[]> f13753a = new AtomicReference<>(f13751d);

    /* renamed from: b, reason: collision with root package name */
    Throwable f13754b;

    /* renamed from: c, reason: collision with root package name */
    T f13755c;

    /* compiled from: AsyncSubject.java */
    /* renamed from: g.a.f1.a$a, reason: collision with other inner class name */
    static final class C0175a<T> extends l<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final a<T> parent;

        C0175a(i0<? super T> i0Var, a<T> aVar) {
            super(i0Var);
            this.parent = aVar;
        }

        @Override // g.a.y0.d.l, g.a.u0.c
        public void dispose() {
            if (super.tryDispose()) {
                this.parent.b((C0175a) this);
            }
        }

        void onComplete() {
            if (isDisposed()) {
                return;
            }
            this.actual.onComplete();
        }

        void onError(Throwable th) {
            if (isDisposed()) {
                g.a.c1.a.b(th);
            } else {
                this.actual.onError(th);
            }
        }
    }

    a() {
    }

    @g.a.t0.d
    public static <T> a<T> X() {
        return new a<>();
    }

    @Override // g.a.f1.i
    public Throwable O() {
        if (this.f13753a.get() == f13752e) {
            return this.f13754b;
        }
        return null;
    }

    @Override // g.a.f1.i
    public boolean P() {
        return this.f13753a.get() == f13752e && this.f13754b == null;
    }

    @Override // g.a.f1.i
    public boolean Q() {
        return this.f13753a.get().length != 0;
    }

    @Override // g.a.f1.i
    public boolean R() {
        return this.f13753a.get() == f13752e && this.f13754b != null;
    }

    public T T() {
        if (this.f13753a.get() == f13752e) {
            return this.f13755c;
        }
        return null;
    }

    public Object[] U() {
        T T = T();
        return T != null ? new Object[]{T} : new Object[0];
    }

    public boolean V() {
        return this.f13753a.get() == f13752e && this.f13755c != null;
    }

    void W() {
        this.f13755c = null;
        NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        this.f13754b = nullPointerException;
        for (C0175a<T> c0175a : this.f13753a.getAndSet(f13752e)) {
            c0175a.onError(nullPointerException);
        }
    }

    boolean a(C0175a<T> c0175a) {
        C0175a<T>[] c0175aArr;
        C0175a<T>[] c0175aArr2;
        do {
            c0175aArr = this.f13753a.get();
            if (c0175aArr == f13752e) {
                return false;
            }
            int length = c0175aArr.length;
            c0175aArr2 = new C0175a[length + 1];
            System.arraycopy(c0175aArr, 0, c0175aArr2, 0, length);
            c0175aArr2[length] = c0175a;
        } while (!this.f13753a.compareAndSet(c0175aArr, c0175aArr2));
        return true;
    }

    void b(C0175a<T> c0175a) {
        C0175a<T>[] c0175aArr;
        C0175a<T>[] c0175aArr2;
        do {
            c0175aArr = this.f13753a.get();
            int length = c0175aArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (c0175aArr[i3] == c0175a) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                c0175aArr2 = f13751d;
            } else {
                C0175a<T>[] c0175aArr3 = new C0175a[length - 1];
                System.arraycopy(c0175aArr, 0, c0175aArr3, 0, i2);
                System.arraycopy(c0175aArr, i2 + 1, c0175aArr3, i2, (length - i2) - 1);
                c0175aArr2 = c0175aArr3;
            }
        } while (!this.f13753a.compareAndSet(c0175aArr, c0175aArr2));
    }

    public T[] c(T[] tArr) {
        T T = T();
        if (T == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 1);
        }
        tArr[0] = T;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    @Override // g.a.b0
    protected void d(i0<? super T> i0Var) {
        C0175a<T> c0175a = new C0175a<>(i0Var, this);
        i0Var.onSubscribe(c0175a);
        if (a((C0175a) c0175a)) {
            if (c0175a.isDisposed()) {
                b((C0175a) c0175a);
                return;
            }
            return;
        }
        Throwable th = this.f13754b;
        if (th != null) {
            i0Var.onError(th);
            return;
        }
        T t = this.f13755c;
        if (t != null) {
            c0175a.complete(t);
        } else {
            c0175a.onComplete();
        }
    }

    @Override // g.a.i0
    public void onComplete() {
        C0175a<T>[] c0175aArr = this.f13753a.get();
        C0175a<T>[] c0175aArr2 = f13752e;
        if (c0175aArr == c0175aArr2) {
            return;
        }
        T t = this.f13755c;
        C0175a<T>[] andSet = this.f13753a.getAndSet(c0175aArr2);
        int i2 = 0;
        if (t == null) {
            int length = andSet.length;
            while (i2 < length) {
                andSet[i2].onComplete();
                i2++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i2 < length2) {
            andSet[i2].complete(t);
            i2++;
        }
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        C0175a<T>[] c0175aArr = this.f13753a.get();
        C0175a<T>[] c0175aArr2 = f13752e;
        if (c0175aArr == c0175aArr2) {
            g.a.c1.a.b(th);
            return;
        }
        this.f13755c = null;
        this.f13754b = th;
        for (C0175a<T> c0175a : this.f13753a.getAndSet(c0175aArr2)) {
            c0175a.onError(th);
        }
    }

    @Override // g.a.i0
    public void onNext(T t) {
        if (this.f13753a.get() == f13752e) {
            return;
        }
        if (t == null) {
            W();
        } else {
            this.f13755c = t;
        }
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        if (this.f13753a.get() == f13752e) {
            cVar.dispose();
        }
    }
}
