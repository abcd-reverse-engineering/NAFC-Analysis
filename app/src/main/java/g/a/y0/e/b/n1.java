package g.a.y0.e.b;

/* compiled from: FlowableIgnoreElements.java */
/* loaded from: classes2.dex */
public final class n1<T> extends g.a.y0.e.b.a<T, T> {

    /* compiled from: FlowableIgnoreElements.java */
    static final class a<T> implements g.a.q<T>, g.a.y0.c.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14417a;

        /* renamed from: b, reason: collision with root package name */
        i.d.d f14418b;

        a(i.d.c<? super T> cVar) {
            this.f14417a = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.f14418b.cancel();
        }

        @Override // g.a.y0.c.o
        public void clear() {
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return true;
        }

        @Override // g.a.y0.c.o
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14417a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14417a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14418b, dVar)) {
                this.f14418b = dVar;
                this.f14417a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() {
            return null;
        }

        @Override // i.d.d
        public void request(long j2) {
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return i2 & 2;
        }

        @Override // g.a.y0.c.o
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    public n1(g.a.l<T> lVar) {
        super(lVar);
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar));
    }
}
