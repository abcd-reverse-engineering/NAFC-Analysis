package g.a.y0.e.b;

/* compiled from: FlowableAny.java */
/* loaded from: classes2.dex */
public final class i<T> extends g.a.y0.e.b.a<T, Boolean> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.r<? super T> f14281c;

    /* compiled from: FlowableAny.java */
    static final class a<T> extends g.a.y0.i.f<Boolean> implements g.a.q<T> {
        private static final long serialVersionUID = -2311252482644620661L;
        boolean done;
        final g.a.x0.r<? super T> predicate;
        i.d.d s;

        a(i.d.c<? super Boolean> cVar, g.a.x0.r<? super T> rVar) {
            super(cVar);
            this.predicate = rVar;
        }

        @Override // g.a.y0.i.f, i.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            complete(false);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                if (this.predicate.test(t)) {
                    this.done = true;
                    this.s.cancel();
                    complete(true);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
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

    public i(g.a.l<T> lVar, g.a.x0.r<? super T> rVar) {
        super(lVar);
        this.f14281c = rVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super Boolean> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14281c));
    }
}
