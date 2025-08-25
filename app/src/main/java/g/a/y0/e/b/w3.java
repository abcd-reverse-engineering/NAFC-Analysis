package g.a.y0.e.b;

/* compiled from: FlowableTakeLastOne.java */
/* loaded from: classes2.dex */
public final class w3<T> extends g.a.y0.e.b.a<T, T> {

    /* compiled from: FlowableTakeLastOne.java */
    static final class a<T> extends g.a.y0.i.f<T> implements g.a.q<T> {
        private static final long serialVersionUID = -5467847744262967226L;
        i.d.d s;

        a(i.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // g.a.y0.i.f, i.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.value = null;
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.value = t;
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

    public w3(g.a.l<T> lVar) {
        super(lVar);
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar));
    }
}
