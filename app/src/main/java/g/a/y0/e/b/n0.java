package g.a.y0.e.b;

/* compiled from: FlowableDoFinally.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class n0<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.a f14416c;

    /* compiled from: FlowableDoFinally.java */
    static final class a<T> extends g.a.y0.i.c<T> implements g.a.y0.c.a<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final g.a.y0.c.a<? super T> actual;
        final g.a.x0.a onFinally;
        g.a.y0.c.l<T> qs;
        i.d.d s;
        boolean syncFused;

        a(g.a.y0.c.a<? super T> aVar, g.a.x0.a aVar2) {
            this.actual = aVar;
            this.onFinally = aVar2;
        }

        @Override // i.d.d
        public void cancel() {
            this.s.cancel();
            runFinally();
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.qs.clear();
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // i.d.c
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof g.a.y0.c.l) {
                    this.qs = (g.a.y0.c.l) dVar;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.qs.poll();
            if (tPoll == null && this.syncFused) {
                runFinally();
            }
            return tPoll;
        }

        @Override // i.d.d
        public void request(long j2) {
            this.s.request(j2);
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            g.a.y0.c.l<T> lVar = this.qs;
            if (lVar == null || (i2 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = lVar.requestFusion(i2);
            if (iRequestFusion != 0) {
                this.syncFused = iRequestFusion == 1;
            }
            return iRequestFusion;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.c1.a.b(th);
                }
            }
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            return this.actual.tryOnNext(t);
        }
    }

    /* compiled from: FlowableDoFinally.java */
    static final class b<T> extends g.a.y0.i.c<T> implements g.a.q<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final i.d.c<? super T> actual;
        final g.a.x0.a onFinally;
        g.a.y0.c.l<T> qs;
        i.d.d s;
        boolean syncFused;

        b(i.d.c<? super T> cVar, g.a.x0.a aVar) {
            this.actual = cVar;
            this.onFinally = aVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.s.cancel();
            runFinally();
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.qs.clear();
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // i.d.c
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof g.a.y0.c.l) {
                    this.qs = (g.a.y0.c.l) dVar;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.qs.poll();
            if (tPoll == null && this.syncFused) {
                runFinally();
            }
            return tPoll;
        }

        @Override // i.d.d
        public void request(long j2) {
            this.s.request(j2);
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            g.a.y0.c.l<T> lVar = this.qs;
            if (lVar == null || (i2 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = lVar.requestFusion(i2);
            if (iRequestFusion != 0) {
                this.syncFused = iRequestFusion == 1;
            }
            return iRequestFusion;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.c1.a.b(th);
                }
            }
        }
    }

    public n0(g.a.l<T> lVar, g.a.x0.a aVar) {
        super(lVar);
        this.f14416c = aVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        if (cVar instanceof g.a.y0.c.a) {
            this.f14110b.a((g.a.q) new a((g.a.y0.c.a) cVar, this.f14416c));
        } else {
            this.f14110b.a((g.a.q) new b(cVar, this.f14416c));
        }
    }
}
