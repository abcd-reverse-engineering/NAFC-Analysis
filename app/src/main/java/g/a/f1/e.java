package g.a.f1;

import g.a.i0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PublishSubject.java */
/* loaded from: classes2.dex */
public final class e<T> extends i<T> {

    /* renamed from: c, reason: collision with root package name */
    static final a[] f13785c = new a[0];

    /* renamed from: d, reason: collision with root package name */
    static final a[] f13786d = new a[0];

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<a<T>[]> f13787a = new AtomicReference<>(f13786d);

    /* renamed from: b, reason: collision with root package name */
    Throwable f13788b;

    /* compiled from: PublishSubject.java */
    static final class a<T> extends AtomicBoolean implements g.a.u0.c {
        private static final long serialVersionUID = 3562861878281475070L;
        final i0<? super T> actual;
        final e<T> parent;

        a(i0<? super T> i0Var, e<T> eVar) {
            this.actual = i0Var;
            this.parent = eVar;
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

        public void onComplete() {
            if (get()) {
                return;
            }
            this.actual.onComplete();
        }

        public void onError(Throwable th) {
            if (get()) {
                g.a.c1.a.b(th);
            } else {
                this.actual.onError(th);
            }
        }

        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.actual.onNext(t);
        }
    }

    e() {
    }

    @g.a.t0.d
    public static <T> e<T> T() {
        return new e<>();
    }

    @Override // g.a.f1.i
    public Throwable O() {
        if (this.f13787a.get() == f13785c) {
            return this.f13788b;
        }
        return null;
    }

    @Override // g.a.f1.i
    public boolean P() {
        return this.f13787a.get() == f13785c && this.f13788b == null;
    }

    @Override // g.a.f1.i
    public boolean Q() {
        return this.f13787a.get().length != 0;
    }

    @Override // g.a.f1.i
    public boolean R() {
        return this.f13787a.get() == f13785c && this.f13788b != null;
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f13787a.get();
            if (aVarArr == f13785c) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f13787a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f13787a.get();
            if (aVarArr == f13785c || aVarArr == f13786d) {
                return;
            }
            int length = aVarArr.length;
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
                aVarArr2 = f13786d;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f13787a.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // g.a.b0
    public void d(i0<? super T> i0Var) {
        a<T> aVar = new a<>(i0Var, this);
        i0Var.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.isDisposed()) {
                b((a) aVar);
            }
        } else {
            Throwable th = this.f13788b;
            if (th != null) {
                i0Var.onError(th);
            } else {
                i0Var.onComplete();
            }
        }
    }

    @Override // g.a.i0
    public void onComplete() {
        a<T>[] aVarArr = this.f13787a.get();
        a<T>[] aVarArr2 = f13785c;
        if (aVarArr == aVarArr2) {
            return;
        }
        for (a<T> aVar : this.f13787a.getAndSet(aVarArr2)) {
            aVar.onComplete();
        }
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        if (this.f13787a.get() == f13785c) {
            g.a.c1.a.b(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.f13788b = th;
        for (a<T> aVar : this.f13787a.getAndSet(f13785c)) {
            aVar.onError(th);
        }
    }

    @Override // g.a.i0
    public void onNext(T t) {
        if (this.f13787a.get() == f13785c) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        for (a<T> aVar : this.f13787a.get()) {
            aVar.onNext(t);
        }
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        if (this.f13787a.get() == f13785c) {
            cVar.dispose();
        }
    }
}
