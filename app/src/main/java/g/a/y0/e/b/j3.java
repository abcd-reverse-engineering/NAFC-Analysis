package g.a.y0.e.b;

/* compiled from: FlowableSingle.java */
/* loaded from: classes2.dex */
public final class j3<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final T f14310c;

    /* compiled from: FlowableSingle.java */
    static final class a<T> extends g.a.y0.i.f<T> implements g.a.q<T> {
        private static final long serialVersionUID = -5526049321428043809L;
        final T defaultValue;
        boolean done;
        i.d.d s;

        a(i.d.c<? super T> cVar, T t) {
            super(cVar);
            this.defaultValue = t;
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
            T t = this.value;
            this.value = null;
            if (t == null) {
                t = this.defaultValue;
            }
            if (t == null) {
                this.actual.onComplete();
            } else {
                complete(t);
            }
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
            if (this.value == null) {
                this.value = t;
                return;
            }
            this.done = true;
            this.s.cancel();
            this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
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

    public j3(g.a.l<T> lVar, T t) {
        super(lVar);
        this.f14310c = t;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14310c));
    }
}
