package g.a.y0.e.b;

/* compiled from: FlowableMap.java */
/* loaded from: classes2.dex */
public final class y1<T, U> extends g.a.y0.e.b.a<T, U> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends U> f14723c;

    /* compiled from: FlowableMap.java */
    static final class a<T, U> extends g.a.y0.h.a<T, U> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends U> f14724f;

        a(g.a.y0.c.a<? super U> aVar, g.a.x0.o<? super T, ? extends U> oVar) {
            super(aVar);
            this.f14724f = oVar;
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f16008d) {
                return;
            }
            if (this.f16009e != 0) {
                this.f16005a.onNext(null);
                return;
            }
            try {
                this.f16005a.onNext(g.a.y0.b.b.a(this.f14724f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public U poll() throws Exception {
            T tPoll = this.f16007c.poll();
            if (tPoll != null) {
                return (U) g.a.y0.b.b.a(this.f14724f.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
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
            try {
                return this.f16005a.tryOnNext(g.a.y0.b.b.a(this.f14724f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }
    }

    /* compiled from: FlowableMap.java */
    static final class b<T, U> extends g.a.y0.h.b<T, U> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends U> f14725f;

        b(i.d.c<? super U> cVar, g.a.x0.o<? super T, ? extends U> oVar) {
            super(cVar);
            this.f14725f = oVar;
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f16013d) {
                return;
            }
            if (this.f16014e != 0) {
                this.f16010a.onNext(null);
                return;
            }
            try {
                this.f16010a.onNext(g.a.y0.b.b.a(this.f14725f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public U poll() throws Exception {
            T tPoll = this.f16012c.poll();
            if (tPoll != null) {
                return (U) g.a.y0.b.b.a(this.f14725f.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public y1(g.a.l<T> lVar, g.a.x0.o<? super T, ? extends U> oVar) {
        super(lVar);
        this.f14723c = oVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super U> cVar) {
        if (cVar instanceof g.a.y0.c.a) {
            this.f14110b.a((g.a.q) new a((g.a.y0.c.a) cVar, this.f14723c));
        } else {
            this.f14110b.a((g.a.q) new b(cVar, this.f14723c));
        }
    }
}
