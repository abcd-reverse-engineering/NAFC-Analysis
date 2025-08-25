package g.a.f1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableSubject.java */
/* loaded from: classes2.dex */
public final class c extends g.a.c implements g.a.f {

    /* renamed from: d, reason: collision with root package name */
    static final a[] f13774d = new a[0];

    /* renamed from: e, reason: collision with root package name */
    static final a[] f13775e = new a[0];

    /* renamed from: c, reason: collision with root package name */
    Throwable f13778c;

    /* renamed from: b, reason: collision with root package name */
    final AtomicBoolean f13777b = new AtomicBoolean();

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<a[]> f13776a = new AtomicReference<>(f13774d);

    /* compiled from: CompletableSubject.java */
    static final class a extends AtomicReference<c> implements g.a.u0.c {
        private static final long serialVersionUID = -7650903191002190468L;
        final g.a.f actual;

        a(g.a.f fVar, c cVar) {
            this.actual = fVar;
            lazySet(cVar);
        }

        @Override // g.a.u0.c
        public void dispose() {
            c andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b(this);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() == null;
        }
    }

    c() {
    }

    @g.a.t0.d
    public static c x() {
        return new c();
    }

    boolean a(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f13776a.get();
            if (aVarArr == f13775e) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f13776a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        a aVar = new a(fVar, this);
        fVar.onSubscribe(aVar);
        if (a(aVar)) {
            if (aVar.isDisposed()) {
                b(aVar);
            }
        } else {
            Throwable th = this.f13778c;
            if (th != null) {
                fVar.onError(th);
            } else {
                fVar.onComplete();
            }
        }
    }

    @Override // g.a.f
    public void onComplete() {
        if (this.f13777b.compareAndSet(false, true)) {
            for (a aVar : this.f13776a.getAndSet(f13775e)) {
                aVar.actual.onComplete();
            }
        }
    }

    @Override // g.a.f
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("Null errors are not allowed in 2.x");
        }
        if (!this.f13777b.compareAndSet(false, true)) {
            g.a.c1.a.b(th);
            return;
        }
        this.f13778c = th;
        for (a aVar : this.f13776a.getAndSet(f13775e)) {
            aVar.actual.onError(th);
        }
    }

    @Override // g.a.f
    public void onSubscribe(g.a.u0.c cVar) {
        if (this.f13776a.get() == f13775e) {
            cVar.dispose();
        }
    }

    public Throwable s() {
        if (this.f13776a.get() == f13775e) {
            return this.f13778c;
        }
        return null;
    }

    public boolean t() {
        return this.f13776a.get() == f13775e && this.f13778c == null;
    }

    public boolean u() {
        return this.f13776a.get().length != 0;
    }

    public boolean v() {
        return this.f13776a.get() == f13775e && this.f13778c != null;
    }

    int w() {
        return this.f13776a.get().length;
    }

    void b(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f13776a.get();
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
                aVarArr2 = f13774d;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f13776a.compareAndSet(aVarArr, aVarArr2));
    }
}
