package g.a.y0.e.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableCache.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class b extends g.a.c implements g.a.f {

    /* renamed from: e, reason: collision with root package name */
    static final a[] f13992e = new a[0];

    /* renamed from: f, reason: collision with root package name */
    static final a[] f13993f = new a[0];

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f13994a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<a[]> f13995b = new AtomicReference<>(f13992e);

    /* renamed from: c, reason: collision with root package name */
    final AtomicBoolean f13996c = new AtomicBoolean();

    /* renamed from: d, reason: collision with root package name */
    Throwable f13997d;

    /* compiled from: CompletableCache.java */
    final class a extends AtomicBoolean implements g.a.u0.c {
        private static final long serialVersionUID = 8943152917179642732L;
        final g.a.f actual;

        a(g.a.f fVar) {
            this.actual = fVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                b.this.b(this);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get();
        }
    }

    public b(g.a.i iVar) {
        this.f13994a = iVar;
    }

    boolean a(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f13995b.get();
            if (aVarArr == f13993f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f13995b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        a aVar = new a(fVar);
        fVar.onSubscribe(aVar);
        if (a(aVar)) {
            if (aVar.isDisposed()) {
                b(aVar);
            }
            if (this.f13996c.compareAndSet(false, true)) {
                this.f13994a.a(this);
                return;
            }
            return;
        }
        Throwable th = this.f13997d;
        if (th != null) {
            fVar.onError(th);
        } else {
            fVar.onComplete();
        }
    }

    @Override // g.a.f
    public void onComplete() {
        for (a aVar : this.f13995b.getAndSet(f13993f)) {
            if (!aVar.get()) {
                aVar.actual.onComplete();
            }
        }
    }

    @Override // g.a.f
    public void onError(Throwable th) {
        this.f13997d = th;
        for (a aVar : this.f13995b.getAndSet(f13993f)) {
            if (!aVar.get()) {
                aVar.actual.onError(th);
            }
        }
    }

    @Override // g.a.f
    public void onSubscribe(g.a.u0.c cVar) {
    }

    void b(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f13995b.get();
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
                aVarArr2 = f13992e;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f13995b.compareAndSet(aVarArr, aVarArr2));
    }
}
