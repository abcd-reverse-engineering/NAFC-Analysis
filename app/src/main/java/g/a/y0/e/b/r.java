package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableCache.java */
/* loaded from: classes2.dex */
public final class r<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final a<T> f14547c;

    /* renamed from: d, reason: collision with root package name */
    final AtomicBoolean f14548d;

    /* compiled from: FlowableCache.java */
    static final class a<T> extends g.a.y0.j.n implements g.a.q<T> {

        /* renamed from: k, reason: collision with root package name */
        static final b[] f14549k = new b[0];

        /* renamed from: l, reason: collision with root package name */
        static final b[] f14550l = new b[0];

        /* renamed from: f, reason: collision with root package name */
        final g.a.l<T> f14551f;

        /* renamed from: g, reason: collision with root package name */
        final AtomicReference<i.d.d> f14552g;

        /* renamed from: h, reason: collision with root package name */
        final AtomicReference<b<T>[]> f14553h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f14554i;

        /* renamed from: j, reason: collision with root package name */
        boolean f14555j;

        a(g.a.l<T> lVar, int i2) {
            super(i2);
            this.f14552g = new AtomicReference<>();
            this.f14551f = lVar;
            this.f14553h = new AtomicReference<>(f14549k);
        }

        public void a(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f14553h.get();
                if (bVarArr == f14550l) {
                    return;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f14553h.compareAndSet(bVarArr, bVarArr2));
        }

        public void b(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f14553h.get();
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
                    bVarArr2 = f14549k;
                } else {
                    b<T>[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.f14553h.compareAndSet(bVarArr, bVarArr2));
        }

        public void c() {
            this.f14551f.a((g.a.q) this);
            this.f14554i = true;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14555j) {
                return;
            }
            this.f14555j = true;
            a(g.a.y0.j.q.complete());
            g.a.y0.i.j.cancel(this.f14552g);
            for (b<T> bVar : this.f14553h.getAndSet(f14550l)) {
                bVar.replay();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14555j) {
                g.a.c1.a.b(th);
                return;
            }
            this.f14555j = true;
            a(g.a.y0.j.q.error(th));
            g.a.y0.i.j.cancel(this.f14552g);
            for (b<T> bVar : this.f14553h.getAndSet(f14550l)) {
                bVar.replay();
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14555j) {
                return;
            }
            a(g.a.y0.j.q.next(t));
            for (b<T> bVar : this.f14553h.get()) {
                bVar.replay();
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this.f14552g, dVar)) {
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    /* compiled from: FlowableCache.java */
    static final class b<T> extends AtomicInteger implements i.d.d {

        /* renamed from: a, reason: collision with root package name */
        private static final long f14556a = -1;
        private static final long serialVersionUID = -2557562030197141021L;
        final i.d.c<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final AtomicLong requested = new AtomicLong();
        final a<T> state;

        b(i.d.c<? super T> cVar, a<T> aVar) {
            this.child = cVar;
            this.state = aVar;
        }

        @Override // i.d.d
        public void cancel() {
            if (this.requested.getAndSet(-1L) != -1) {
                this.state.b(this);
            }
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            i.d.c<? super T> cVar = this.child;
            AtomicLong atomicLong = this.requested;
            int i2 = 1;
            int iAddAndGet = 1;
            while (true) {
                long j2 = atomicLong.get();
                if (j2 < 0) {
                    return;
                }
                int iB = this.state.b();
                if (iB != 0) {
                    Object[] objArrA = this.currentBuffer;
                    if (objArrA == null) {
                        objArrA = this.state.a();
                        this.currentBuffer = objArrA;
                    }
                    int length = objArrA.length - i2;
                    int i3 = this.index;
                    int i4 = this.currentIndexInBuffer;
                    int i5 = 0;
                    while (i3 < iB && j2 > 0) {
                        if (atomicLong.get() == -1) {
                            return;
                        }
                        if (i4 == length) {
                            objArrA = (Object[]) objArrA[length];
                            i4 = 0;
                        }
                        if (g.a.y0.j.q.accept(objArrA[i4], cVar)) {
                            return;
                        }
                        i4++;
                        i3++;
                        j2--;
                        i5++;
                    }
                    if (atomicLong.get() == -1) {
                        return;
                    }
                    if (j2 == 0) {
                        Object obj = objArrA[i4];
                        if (g.a.y0.j.q.isComplete(obj)) {
                            cVar.onComplete();
                            return;
                        } else if (g.a.y0.j.q.isError(obj)) {
                            cVar.onError(g.a.y0.j.q.getError(obj));
                            return;
                        }
                    }
                    if (i5 != 0) {
                        g.a.y0.j.d.d(atomicLong, i5);
                    }
                    this.index = i3;
                    this.currentIndexInBuffer = i4;
                    this.currentBuffer = objArrA;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                } else {
                    i2 = 1;
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            long j3;
            if (g.a.y0.i.j.validate(j2)) {
                do {
                    j3 = this.requested.get();
                    if (j3 == -1) {
                        return;
                    }
                } while (!this.requested.compareAndSet(j3, g.a.y0.j.d.a(j3, j2)));
                replay();
            }
        }
    }

    public r(g.a.l<T> lVar, int i2) {
        super(lVar);
        this.f14547c = new a<>(lVar, i2);
        this.f14548d = new AtomicBoolean();
    }

    int T() {
        return this.f14547c.b();
    }

    boolean U() {
        return this.f14547c.f14553h.get().length != 0;
    }

    boolean V() {
        return this.f14547c.f14554i;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        b<T> bVar = new b<>(cVar, this.f14547c);
        this.f14547c.a((b) bVar);
        cVar.onSubscribe(bVar);
        if (this.f14548d.get() || !this.f14548d.compareAndSet(false, true)) {
            return;
        }
        this.f14547c.c();
    }
}
