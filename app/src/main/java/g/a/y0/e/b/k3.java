package g.a.y0.e.b;

/* compiled from: FlowableSingleMaybe.java */
/* loaded from: classes2.dex */
public final class k3<T> extends g.a.s<T> implements g.a.y0.c.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14327a;

    /* compiled from: FlowableSingleMaybe.java */
    static final class a<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14328a;

        /* renamed from: b, reason: collision with root package name */
        i.d.d f14329b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14330c;

        /* renamed from: d, reason: collision with root package name */
        T f14331d;

        a(g.a.v<? super T> vVar) {
            this.f14328a = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14329b.cancel();
            this.f14329b = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14329b == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14330c) {
                return;
            }
            this.f14330c = true;
            this.f14329b = g.a.y0.i.j.CANCELLED;
            T t = this.f14331d;
            this.f14331d = null;
            if (t == null) {
                this.f14328a.onComplete();
            } else {
                this.f14328a.onSuccess(t);
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14330c) {
                g.a.c1.a.b(th);
                return;
            }
            this.f14330c = true;
            this.f14329b = g.a.y0.i.j.CANCELLED;
            this.f14328a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14330c) {
                return;
            }
            if (this.f14331d == null) {
                this.f14331d = t;
                return;
            }
            this.f14330c = true;
            this.f14329b.cancel();
            this.f14329b = g.a.y0.i.j.CANCELLED;
            this.f14328a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14329b, dVar)) {
                this.f14329b = dVar;
                this.f14328a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public k3(g.a.l<T> lVar) {
        this.f14327a = lVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14327a.a((g.a.q) new a(vVar));
    }

    @Override // g.a.y0.c.b
    public g.a.l<T> b() {
        return g.a.c1.a.a(new j3(this.f14327a, null));
    }
}
