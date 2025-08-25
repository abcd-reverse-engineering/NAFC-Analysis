package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowablePublishMulticast.java */
/* loaded from: classes2.dex */
public final class m2<T, R> extends g.a.y0.e.b.a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super g.a.l<T>, ? extends i.d.b<? extends R>> f14382c;

    /* renamed from: d, reason: collision with root package name */
    final int f14383d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f14384e;

    /* compiled from: FlowablePublishMulticast.java */
    static final class b<T> extends AtomicLong implements i.d.d {
        private static final long serialVersionUID = 8664815189257569791L;
        final i.d.c<? super T> actual;
        final a<T> parent;

        b(i.d.c<? super T> cVar, a<T> aVar) {
            this.actual = cVar;
            this.parent = aVar;
        }

        @Override // i.d.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.b((b) this);
                this.parent.U();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.b(this, j2);
                this.parent.U();
            }
        }
    }

    /* compiled from: FlowablePublishMulticast.java */
    static final class c<R> implements g.a.q<R>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super R> f14397a;

        /* renamed from: b, reason: collision with root package name */
        final a<?> f14398b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f14399c;

        c(i.d.c<? super R> cVar, a<?> aVar) {
            this.f14397a = cVar;
            this.f14398b = aVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.f14399c.cancel();
            this.f14398b.dispose();
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14397a.onComplete();
            this.f14398b.dispose();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14397a.onError(th);
            this.f14398b.dispose();
        }

        @Override // i.d.c
        public void onNext(R r) {
            this.f14397a.onNext(r);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14399c, dVar)) {
                this.f14399c = dVar;
                this.f14397a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f14399c.request(j2);
        }
    }

    public m2(g.a.l<T> lVar, g.a.x0.o<? super g.a.l<T>, ? extends i.d.b<? extends R>> oVar, int i2, boolean z) {
        super(lVar);
        this.f14382c = oVar;
        this.f14383d = i2;
        this.f14384e = z;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super R> cVar) {
        a aVar = new a(this.f14383d, this.f14384e);
        try {
            ((i.d.b) g.a.y0.b.b.a(this.f14382c.apply(aVar), "selector returned a null Publisher")).subscribe(new c(cVar, aVar));
            this.f14110b.a((g.a.q) aVar);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.i.g.error(th, cVar);
        }
    }

    /* compiled from: FlowablePublishMulticast.java */
    static final class a<T> extends g.a.l<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: m, reason: collision with root package name */
        static final b[] f14385m = new b[0];
        static final b[] n = new b[0];

        /* renamed from: d, reason: collision with root package name */
        final int f14388d;

        /* renamed from: e, reason: collision with root package name */
        final int f14389e;

        /* renamed from: f, reason: collision with root package name */
        final boolean f14390f;

        /* renamed from: h, reason: collision with root package name */
        volatile g.a.y0.c.o<T> f14392h;

        /* renamed from: i, reason: collision with root package name */
        int f14393i;

        /* renamed from: j, reason: collision with root package name */
        volatile boolean f14394j;

        /* renamed from: k, reason: collision with root package name */
        Throwable f14395k;

        /* renamed from: l, reason: collision with root package name */
        int f14396l;

        /* renamed from: b, reason: collision with root package name */
        final AtomicInteger f14386b = new AtomicInteger();

        /* renamed from: g, reason: collision with root package name */
        final AtomicReference<i.d.d> f14391g = new AtomicReference<>();

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference<b<T>[]> f14387c = new AtomicReference<>(f14385m);

        a(int i2, boolean z) {
            this.f14388d = i2;
            this.f14389e = i2 - (i2 >> 2);
            this.f14390f = z;
        }

        void T() {
            for (b<T> bVar : this.f14387c.getAndSet(n)) {
                if (bVar.get() != Long.MIN_VALUE) {
                    bVar.actual.onComplete();
                }
            }
        }

        void U() {
            Throwable th;
            Throwable th2;
            if (this.f14386b.getAndIncrement() != 0) {
                return;
            }
            g.a.y0.c.o<T> oVar = this.f14392h;
            int i2 = this.f14396l;
            int i3 = this.f14389e;
            boolean z = this.f14393i != 1;
            int i4 = i2;
            int iAddAndGet = 1;
            while (true) {
                b<T>[] bVarArr = this.f14387c.get();
                int length = bVarArr.length;
                if (oVar != null && length != 0) {
                    long j2 = Long.MAX_VALUE;
                    for (b<T> bVar : bVarArr) {
                        long j3 = bVar.get();
                        if (j3 != Long.MIN_VALUE && j2 > j3) {
                            j2 = j3;
                        }
                    }
                    long j4 = 0;
                    while (j4 != j2) {
                        if (isDisposed()) {
                            oVar.clear();
                            return;
                        }
                        boolean z2 = this.f14394j;
                        if (z2 && !this.f14390f && (th2 = this.f14395k) != null) {
                            b(th2);
                            return;
                        }
                        try {
                            T tPoll = oVar.poll();
                            boolean z3 = tPoll == null;
                            if (z2 && z3) {
                                Throwable th3 = this.f14395k;
                                if (th3 != null) {
                                    b(th3);
                                    return;
                                } else {
                                    T();
                                    return;
                                }
                            }
                            if (z3) {
                                break;
                            }
                            int length2 = bVarArr.length;
                            int i5 = 0;
                            while (i5 < length2) {
                                int i6 = length2;
                                b<T> bVar2 = bVarArr[i5];
                                if (bVar2.get() != Long.MIN_VALUE) {
                                    bVar2.actual.onNext(tPoll);
                                }
                                i5++;
                                length2 = i6;
                            }
                            j4++;
                            if (z) {
                                int i7 = i4 + 1;
                                if (i7 == i3) {
                                    this.f14391g.get().request(i3);
                                    i4 = 0;
                                } else {
                                    i4 = i7;
                                }
                            }
                        } catch (Throwable th4) {
                            g.a.v0.b.b(th4);
                            g.a.y0.i.j.cancel(this.f14391g);
                            b(th4);
                            return;
                        }
                    }
                    if (j4 == j2) {
                        if (isDisposed()) {
                            oVar.clear();
                            return;
                        }
                        boolean z4 = this.f14394j;
                        if (z4 && !this.f14390f && (th = this.f14395k) != null) {
                            b(th);
                            return;
                        }
                        if (z4 && oVar.isEmpty()) {
                            Throwable th5 = this.f14395k;
                            if (th5 != null) {
                                b(th5);
                                return;
                            } else {
                                T();
                                return;
                            }
                        }
                    }
                    for (b<T> bVar3 : bVarArr) {
                        g.a.y0.j.d.c(bVar3, j4);
                    }
                }
                this.f14396l = i4;
                iAddAndGet = this.f14386b.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (oVar == null) {
                    oVar = this.f14392h;
                }
            }
        }

        boolean a(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f14387c.get();
                if (bVarArr == n) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f14387c.compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        void b(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f14387c.get();
                if (bVarArr == n || bVarArr == f14385m) {
                    return;
                }
                int length = bVarArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (bVarArr[i3] == bVar) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = f14385m;
                } else {
                    b<T>[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.f14387c.compareAndSet(bVarArr, bVarArr2));
        }

        @Override // g.a.l
        protected void d(i.d.c<? super T> cVar) {
            b<T> bVar = new b<>(cVar, this);
            cVar.onSubscribe(bVar);
            if (a((b) bVar)) {
                if (bVar.isCancelled()) {
                    b((b) bVar);
                    return;
                } else {
                    U();
                    return;
                }
            }
            Throwable th = this.f14395k;
            if (th != null) {
                cVar.onError(th);
            } else {
                cVar.onComplete();
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.c.o<T> oVar;
            g.a.y0.i.j.cancel(this.f14391g);
            if (this.f14386b.getAndIncrement() != 0 || (oVar = this.f14392h) == null) {
                return;
            }
            oVar.clear();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.i.j.isCancelled(this.f14391g.get());
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14394j) {
                return;
            }
            this.f14394j = true;
            U();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14394j) {
                g.a.c1.a.b(th);
                return;
            }
            this.f14395k = th;
            this.f14394j = true;
            U();
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14394j) {
                return;
            }
            if (this.f14393i != 0 || this.f14392h.offer(t)) {
                U();
            } else {
                this.f14391g.get().cancel();
                onError(new g.a.v0.c());
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this.f14391g, dVar)) {
                if (dVar instanceof g.a.y0.c.l) {
                    g.a.y0.c.l lVar = (g.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.f14393i = iRequestFusion;
                        this.f14392h = lVar;
                        this.f14394j = true;
                        U();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.f14393i = iRequestFusion;
                        this.f14392h = lVar;
                        g.a.y0.j.v.a(dVar, this.f14388d);
                        return;
                    }
                }
                this.f14392h = g.a.y0.j.v.a(this.f14388d);
                g.a.y0.j.v.a(dVar, this.f14388d);
            }
        }

        void b(Throwable th) {
            for (b<T> bVar : this.f14387c.getAndSet(n)) {
                if (bVar.get() != Long.MIN_VALUE) {
                    bVar.actual.onError(th);
                }
            }
        }
    }
}
