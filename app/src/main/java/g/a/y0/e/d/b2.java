package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservablePublish.java */
/* loaded from: classes2.dex */
public final class b2<T> extends g.a.z0.a<T> implements g.a.y0.c.g<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f14974a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<b<T>> f14975b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.g0<T> f14976c;

    /* compiled from: ObservablePublish.java */
    static final class a<T> extends AtomicReference<Object> implements g.a.u0.c {
        private static final long serialVersionUID = -1100270633763673112L;
        final g.a.i0<? super T> child;

        a(g.a.i0<? super T> i0Var) {
            this.child = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((b) andSet).b(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() == this;
        }

        void setParent(b<T> bVar) {
            if (compareAndSet(null, bVar)) {
                return;
            }
            bVar.b(this);
        }
    }

    /* compiled from: ObservablePublish.java */
    static final class b<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: e, reason: collision with root package name */
        static final a[] f14977e = new a[0];

        /* renamed from: f, reason: collision with root package name */
        static final a[] f14978f = new a[0];

        /* renamed from: a, reason: collision with root package name */
        final AtomicReference<b<T>> f14979a;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference<g.a.u0.c> f14982d = new AtomicReference<>();

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference<a<T>[]> f14980b = new AtomicReference<>(f14977e);

        /* renamed from: c, reason: collision with root package name */
        final AtomicBoolean f14981c = new AtomicBoolean();

        b(AtomicReference<b<T>> atomicReference) {
            this.f14979a = atomicReference;
        }

        boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f14980b.get();
                if (aVarArr == f14978f) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.f14980b.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        void b(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f14980b.get();
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
                    if (aVarArr[i3].equals(aVar)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = f14977e;
                } else {
                    a<T>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                    System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.f14980b.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // g.a.u0.c
        public void dispose() {
            a<T>[] aVarArr = this.f14980b.get();
            a<T>[] aVarArr2 = f14978f;
            if (aVarArr == aVarArr2 || this.f14980b.getAndSet(aVarArr2) == f14978f) {
                return;
            }
            this.f14979a.compareAndSet(this, null);
            g.a.y0.a.d.dispose(this.f14982d);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14980b.get() == f14978f;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f14979a.compareAndSet(this, null);
            for (a<T> aVar : this.f14980b.getAndSet(f14978f)) {
                aVar.child.onComplete();
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f14979a.compareAndSet(this, null);
            a<T>[] andSet = this.f14980b.getAndSet(f14978f);
            if (andSet.length == 0) {
                g.a.c1.a.b(th);
                return;
            }
            for (a<T> aVar : andSet) {
                aVar.child.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            for (a<T> aVar : this.f14980b.get()) {
                aVar.child.onNext(t);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this.f14982d, cVar);
        }
    }

    /* compiled from: ObservablePublish.java */
    static final class c<T> implements g.a.g0<T> {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicReference<b<T>> f14983a;

        c(AtomicReference<b<T>> atomicReference) {
            this.f14983a = atomicReference;
        }

        @Override // g.a.g0
        public void subscribe(g.a.i0<? super T> i0Var) {
            a aVar = new a(i0Var);
            i0Var.onSubscribe(aVar);
            while (true) {
                b<T> bVar = this.f14983a.get();
                if (bVar == null || bVar.isDisposed()) {
                    b<T> bVar2 = new b<>(this.f14983a);
                    if (this.f14983a.compareAndSet(bVar, bVar2)) {
                        bVar = bVar2;
                    } else {
                        continue;
                    }
                }
                if (bVar.a(aVar)) {
                    aVar.setParent(bVar);
                    return;
                }
            }
        }
    }

    private b2(g.a.g0<T> g0Var, g.a.g0<T> g0Var2, AtomicReference<b<T>> atomicReference) {
        this.f14976c = g0Var;
        this.f14974a = g0Var2;
        this.f14975b = atomicReference;
    }

    public static <T> g.a.z0.a<T> w(g.a.g0<T> g0Var) {
        AtomicReference atomicReference = new AtomicReference();
        return g.a.c1.a.a((g.a.z0.a) new b2(new c(atomicReference), g0Var, atomicReference));
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f14976c.subscribe(i0Var);
    }

    @Override // g.a.z0.a
    public void k(g.a.x0.g<? super g.a.u0.c> gVar) {
        b<T> bVar;
        while (true) {
            bVar = this.f14975b.get();
            if (bVar != null && !bVar.isDisposed()) {
                break;
            }
            b<T> bVar2 = new b<>(this.f14975b);
            if (this.f14975b.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z = !bVar.f14981c.get() && bVar.f14981c.compareAndSet(false, true);
        try {
            gVar.accept(bVar);
            if (z) {
                this.f14974a.subscribe(bVar);
            }
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            throw g.a.y0.j.k.c(th);
        }
    }

    @Override // g.a.y0.c.g
    public g.a.g0<T> source() {
        return this.f14974a;
    }
}
