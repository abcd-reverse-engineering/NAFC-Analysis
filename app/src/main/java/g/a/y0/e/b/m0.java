package g.a.y0.e.b;

/* compiled from: FlowableDoAfterNext.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class m0<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.g<? super T> f14377c;

    /* compiled from: FlowableDoAfterNext.java */
    static final class a<T> extends g.a.y0.h.a<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.g<? super T> f14378f;

        a(g.a.y0.c.a<? super T> aVar, g.a.x0.g<? super T> gVar) {
            super(aVar);
            this.f14378f = gVar;
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.f16005a.onNext(t);
            if (this.f16009e == 0) {
                try {
                    this.f14378f.accept(t);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.f16007c.poll();
            if (tPoll != null) {
                this.f14378f.accept(tPoll);
            }
            return tPoll;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            boolean zTryOnNext = this.f16005a.tryOnNext(t);
            try {
                this.f14378f.accept(t);
            } catch (Throwable th) {
                a(th);
            }
            return zTryOnNext;
        }
    }

    /* compiled from: FlowableDoAfterNext.java */
    static final class b<T> extends g.a.y0.h.b<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.g<? super T> f14379f;

        b(i.d.c<? super T> cVar, g.a.x0.g<? super T> gVar) {
            super(cVar);
            this.f14379f = gVar;
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f16013d) {
                return;
            }
            this.f16010a.onNext(t);
            if (this.f16014e == 0) {
                try {
                    this.f14379f.accept(t);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.f16012c.poll();
            if (tPoll != null) {
                this.f14379f.accept(tPoll);
            }
            return tPoll;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public m0(g.a.l<T> lVar, g.a.x0.g<? super T> gVar) {
        super(lVar);
        this.f14377c = gVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        if (cVar instanceof g.a.y0.c.a) {
            this.f14110b.a((g.a.q) new a((g.a.y0.c.a) cVar, this.f14377c));
        } else {
            this.f14110b.a((g.a.q) new b(cVar, this.f14377c));
        }
    }
}
