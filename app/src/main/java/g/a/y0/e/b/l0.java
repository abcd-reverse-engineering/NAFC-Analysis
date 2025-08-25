package g.a.y0.e.b;

/* compiled from: FlowableDistinctUntilChanged.java */
/* loaded from: classes2.dex */
public final class l0<T, K> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, K> f14336c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.d<? super K, ? super K> f14337d;

    /* compiled from: FlowableDistinctUntilChanged.java */
    static final class a<T, K> extends g.a.y0.h.a<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.o<? super T, K> f14338f;

        /* renamed from: g, reason: collision with root package name */
        final g.a.x0.d<? super K, ? super K> f14339g;

        /* renamed from: h, reason: collision with root package name */
        K f14340h;

        /* renamed from: i, reason: collision with root package name */
        boolean f14341i;

        a(g.a.y0.c.a<? super T> aVar, g.a.x0.o<? super T, K> oVar, g.a.x0.d<? super K, ? super K> dVar) {
            super(aVar);
            this.f14338f = oVar;
            this.f14339g = dVar;
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.f16006b.request(1L);
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            while (true) {
                T tPoll = this.f16007c.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f14338f.apply(tPoll);
                if (!this.f14341i) {
                    this.f14341i = true;
                    this.f14340h = kApply;
                    return tPoll;
                }
                if (!this.f14339g.a(this.f14340h, kApply)) {
                    this.f14340h = kApply;
                    return tPoll;
                }
                this.f14340h = kApply;
                if (this.f16009e != 1) {
                    this.f16006b.request(1L);
                }
            }
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (this.f16008d) {
                return false;
            }
            if (this.f16009e != 0) {
                return this.f16005a.tryOnNext(t);
            }
            try {
                K kApply = this.f14338f.apply(t);
                if (this.f14341i) {
                    boolean zA = this.f14339g.a(this.f14340h, kApply);
                    this.f14340h = kApply;
                    if (zA) {
                        return false;
                    }
                } else {
                    this.f14341i = true;
                    this.f14340h = kApply;
                }
                this.f16005a.onNext(t);
                return true;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }
    }

    /* compiled from: FlowableDistinctUntilChanged.java */
    static final class b<T, K> extends g.a.y0.h.b<T, T> implements g.a.y0.c.a<T> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.o<? super T, K> f14342f;

        /* renamed from: g, reason: collision with root package name */
        final g.a.x0.d<? super K, ? super K> f14343g;

        /* renamed from: h, reason: collision with root package name */
        K f14344h;

        /* renamed from: i, reason: collision with root package name */
        boolean f14345i;

        b(i.d.c<? super T> cVar, g.a.x0.o<? super T, K> oVar, g.a.x0.d<? super K, ? super K> dVar) {
            super(cVar);
            this.f14342f = oVar;
            this.f14343g = dVar;
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.f16011b.request(1L);
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            while (true) {
                T tPoll = this.f16012c.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f14342f.apply(tPoll);
                if (!this.f14345i) {
                    this.f14345i = true;
                    this.f14344h = kApply;
                    return tPoll;
                }
                if (!this.f14343g.a(this.f14344h, kApply)) {
                    this.f14344h = kApply;
                    return tPoll;
                }
                this.f14344h = kApply;
                if (this.f16014e != 1) {
                    this.f16011b.request(1L);
                }
            }
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (this.f16013d) {
                return false;
            }
            if (this.f16014e != 0) {
                this.f16010a.onNext(t);
                return true;
            }
            try {
                K kApply = this.f14342f.apply(t);
                if (this.f14345i) {
                    boolean zA = this.f14343g.a(this.f14344h, kApply);
                    this.f14344h = kApply;
                    if (zA) {
                        return false;
                    }
                } else {
                    this.f14345i = true;
                    this.f14344h = kApply;
                }
                this.f16010a.onNext(t);
                return true;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }
    }

    public l0(g.a.l<T> lVar, g.a.x0.o<? super T, K> oVar, g.a.x0.d<? super K, ? super K> dVar) {
        super(lVar);
        this.f14336c = oVar;
        this.f14337d = dVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        if (cVar instanceof g.a.y0.c.a) {
            this.f14110b.a((g.a.q) new a((g.a.y0.c.a) cVar, this.f14336c, this.f14337d));
        } else {
            this.f14110b.a((g.a.q) new b(cVar, this.f14336c, this.f14337d));
        }
    }
}
