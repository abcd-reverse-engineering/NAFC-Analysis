package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableCache.java */
/* loaded from: classes2.dex */
public final class r<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final a<T> f15428b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicBoolean f15429c;

    /* compiled from: ObservableCache.java */
    static final class a<T> extends g.a.y0.j.n implements g.a.i0<T> {

        /* renamed from: k, reason: collision with root package name */
        static final b[] f15430k = new b[0];

        /* renamed from: l, reason: collision with root package name */
        static final b[] f15431l = new b[0];

        /* renamed from: f, reason: collision with root package name */
        final g.a.b0<? extends T> f15432f;

        /* renamed from: g, reason: collision with root package name */
        final g.a.y0.a.k f15433g;

        /* renamed from: h, reason: collision with root package name */
        final AtomicReference<b<T>[]> f15434h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f15435i;

        /* renamed from: j, reason: collision with root package name */
        boolean f15436j;

        a(g.a.b0<? extends T> b0Var, int i2) {
            super(i2);
            this.f15432f = b0Var;
            this.f15434h = new AtomicReference<>(f15430k);
            this.f15433g = new g.a.y0.a.k();
        }

        public boolean a(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f15434h.get();
                if (bVarArr == f15431l) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f15434h.compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        public void b(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f15434h.get();
                int length = bVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (bVarArr[i3].equals(bVar)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = f15430k;
                } else {
                    b<T>[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.f15434h.compareAndSet(bVarArr, bVarArr2));
        }

        public void c() {
            this.f15432f.subscribe(this);
            this.f15435i = true;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15436j) {
                return;
            }
            this.f15436j = true;
            a(g.a.y0.j.q.complete());
            this.f15433g.dispose();
            for (b<T> bVar : this.f15434h.getAndSet(f15431l)) {
                bVar.replay();
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15436j) {
                return;
            }
            this.f15436j = true;
            a(g.a.y0.j.q.error(th));
            this.f15433g.dispose();
            for (b<T> bVar : this.f15434h.getAndSet(f15431l)) {
                bVar.replay();
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15436j) {
                return;
            }
            a(g.a.y0.j.q.next(t));
            for (b<T> bVar : this.f15434h.get()) {
                bVar.replay();
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15433g.update(cVar);
        }
    }

    /* compiled from: ObservableCache.java */
    static final class b<T> extends AtomicInteger implements g.a.u0.c {
        private static final long serialVersionUID = 7058506693698832024L;
        volatile boolean cancelled;
        final g.a.i0<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final a<T> state;

        b(g.a.i0<? super T> i0Var, a<T> aVar) {
            this.child = i0Var;
            this.state = aVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.b(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            g.a.i0<? super T> i0Var = this.child;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                int iB = this.state.b();
                if (iB != 0) {
                    Object[] objArrA = this.currentBuffer;
                    if (objArrA == null) {
                        objArrA = this.state.a();
                        this.currentBuffer = objArrA;
                    }
                    int length = objArrA.length - 1;
                    int i2 = this.index;
                    int i3 = this.currentIndexInBuffer;
                    while (i2 < iB) {
                        if (this.cancelled) {
                            return;
                        }
                        if (i3 == length) {
                            objArrA = (Object[]) objArrA[length];
                            i3 = 0;
                        }
                        if (g.a.y0.j.q.accept(objArrA[i3], i0Var)) {
                            return;
                        }
                        i3++;
                        i2++;
                    }
                    if (this.cancelled) {
                        return;
                    }
                    this.index = i2;
                    this.currentIndexInBuffer = i3;
                    this.currentBuffer = objArrA;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    private r(g.a.b0<T> b0Var, a<T> aVar) {
        super(b0Var);
        this.f15428b = aVar;
        this.f15429c = new AtomicBoolean();
    }

    public static <T> g.a.b0<T> a(g.a.b0<T> b0Var) {
        return a((g.a.b0) b0Var, 16);
    }

    int O() {
        return this.f15428b.b();
    }

    boolean P() {
        return this.f15428b.f15434h.get().length != 0;
    }

    boolean Q() {
        return this.f15428b.f15435i;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        b<T> bVar = new b<>(i0Var, this.f15428b);
        i0Var.onSubscribe(bVar);
        this.f15428b.a((b) bVar);
        if (!this.f15429c.get() && this.f15429c.compareAndSet(false, true)) {
            this.f15428b.c();
        }
        bVar.replay();
    }

    public static <T> g.a.b0<T> a(g.a.b0<T> b0Var, int i2) {
        g.a.y0.b.b.a(i2, "capacityHint");
        return g.a.c1.a.a(new r(b0Var, new a(b0Var, i2)));
    }
}
