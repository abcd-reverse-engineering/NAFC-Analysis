package g.a.y0.e.b;

/* compiled from: FlowableReduceSeedSingle.java */
/* loaded from: classes2.dex */
public final class r2<T, R> extends g.a.k0<R> {

    /* renamed from: a, reason: collision with root package name */
    final i.d.b<T> f14570a;

    /* renamed from: b, reason: collision with root package name */
    final R f14571b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<R, ? super T, R> f14572c;

    /* compiled from: FlowableReduceSeedSingle.java */
    static final class a<T, R> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super R> f14573a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.c<R, ? super T, R> f14574b;

        /* renamed from: c, reason: collision with root package name */
        R f14575c;

        /* renamed from: d, reason: collision with root package name */
        i.d.d f14576d;

        a(g.a.n0<? super R> n0Var, g.a.x0.c<R, ? super T, R> cVar, R r) {
            this.f14573a = n0Var;
            this.f14575c = r;
            this.f14574b = cVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14576d.cancel();
            this.f14576d = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14576d == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            R r = this.f14575c;
            this.f14575c = null;
            this.f14576d = g.a.y0.i.j.CANCELLED;
            this.f14573a.onSuccess(r);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14575c = null;
            this.f14576d = g.a.y0.i.j.CANCELLED;
            this.f14573a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            try {
                this.f14575c = (R) g.a.y0.b.b.a(this.f14574b.apply(this.f14575c, t), "The reducer returned a null value");
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14576d.cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14576d, dVar)) {
                this.f14576d = dVar;
                this.f14573a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public r2(i.d.b<T> bVar, R r, g.a.x0.c<R, ? super T, R> cVar) {
        this.f14570a = bVar;
        this.f14571b = r;
        this.f14572c = cVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super R> n0Var) {
        this.f14570a.subscribe(new a(n0Var, this.f14572c, this.f14571b));
    }
}
