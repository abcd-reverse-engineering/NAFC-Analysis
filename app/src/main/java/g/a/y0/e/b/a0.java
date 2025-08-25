package g.a.y0.e.b;

/* compiled from: FlowableCount.java */
/* loaded from: classes2.dex */
public final class a0<T> extends g.a.y0.e.b.a<T, Long> {

    /* compiled from: FlowableCount.java */
    static final class a extends g.a.y0.i.f<Long> implements g.a.q<Object> {
        private static final long serialVersionUID = 4973004223787171406L;
        long count;
        i.d.d s;

        a(i.d.c<? super Long> cVar) {
            super(cVar);
        }

        @Override // g.a.y0.i.f, i.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            complete(Long.valueOf(this.count));
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(Object obj) {
            this.count++;
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public a0(g.a.l<T> lVar) {
        super(lVar);
    }

    @Override // g.a.l
    protected void d(i.d.c<? super Long> cVar) {
        this.f14110b.a((g.a.q) new a(cVar));
    }
}
