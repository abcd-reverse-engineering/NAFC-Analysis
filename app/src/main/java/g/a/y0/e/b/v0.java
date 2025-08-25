package g.a.y0.e.b;

/* compiled from: FlowableFilter.java */
/* loaded from: classes2.dex */
public final class v0<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.r<? super T> f14657c;

    /* compiled from: FlowableFilter.java */
    static final class a<T> extends g.a.y0.h.a<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.r<? super T> f14658f;

        a(g.a.y0.c.a<? super T> aVar, g.a.x0.r<? super T> rVar) {
            super(aVar);
            this.f14658f = rVar;
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
            g.a.y0.c.l<T> lVar = this.f16007c;
            g.a.x0.r<? super T> rVar = this.f14658f;
            while (true) {
                T tPoll = lVar.poll();
                if (tPoll == null) {
                    return null;
                }
                if (rVar.test(tPoll)) {
                    return tPoll;
                }
                if (this.f16009e == 2) {
                    lVar.request(1L);
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
                return this.f16005a.tryOnNext(null);
            }
            try {
                return this.f14658f.test(t) && this.f16005a.tryOnNext(t);
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }
    }

    /* compiled from: FlowableFilter.java */
    static final class b<T> extends g.a.y0.h.b<T, T> implements g.a.y0.c.a<T> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.r<? super T> f14659f;

        b(i.d.c<? super T> cVar, g.a.x0.r<? super T> rVar) {
            super(cVar);
            this.f14659f = rVar;
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
            g.a.y0.c.l<T> lVar = this.f16012c;
            g.a.x0.r<? super T> rVar = this.f14659f;
            while (true) {
                T tPoll = lVar.poll();
                if (tPoll == null) {
                    return null;
                }
                if (rVar.test(tPoll)) {
                    return tPoll;
                }
                if (this.f16014e == 2) {
                    lVar.request(1L);
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
                this.f16010a.onNext(null);
                return true;
            }
            try {
                boolean zTest = this.f14659f.test(t);
                if (zTest) {
                    this.f16010a.onNext(t);
                }
                return zTest;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }
    }

    public v0(g.a.l<T> lVar, g.a.x0.r<? super T> rVar) {
        super(lVar);
        this.f14657c = rVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        if (cVar instanceof g.a.y0.c.a) {
            this.f14110b.a((g.a.q) new a((g.a.y0.c.a) cVar, this.f14657c));
        } else {
            this.f14110b.a((g.a.q) new b(cVar, this.f14657c));
        }
    }
}
