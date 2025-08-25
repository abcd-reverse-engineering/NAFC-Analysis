package g.a.y0.e.b;

/* compiled from: FlowableReduceMaybe.java */
/* loaded from: classes2.dex */
public final class q2<T> extends g.a.s<T> implements g.a.y0.c.h<T>, g.a.y0.c.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14531a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.c<T, T, T> f14532b;

    /* compiled from: FlowableReduceMaybe.java */
    static final class a<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14533a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.c<T, T, T> f14534b;

        /* renamed from: c, reason: collision with root package name */
        T f14535c;

        /* renamed from: d, reason: collision with root package name */
        i.d.d f14536d;

        /* renamed from: e, reason: collision with root package name */
        boolean f14537e;

        a(g.a.v<? super T> vVar, g.a.x0.c<T, T, T> cVar) {
            this.f14533a = vVar;
            this.f14534b = cVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14536d.cancel();
            this.f14537e = true;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14537e;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14537e) {
                return;
            }
            this.f14537e = true;
            T t = this.f14535c;
            if (t != null) {
                this.f14533a.onSuccess(t);
            } else {
                this.f14533a.onComplete();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14537e) {
                g.a.c1.a.b(th);
            } else {
                this.f14537e = true;
                this.f14533a.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14537e) {
                return;
            }
            T t2 = this.f14535c;
            if (t2 == null) {
                this.f14535c = t;
                return;
            }
            try {
                this.f14535c = (T) g.a.y0.b.b.a((Object) this.f14534b.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14536d.cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14536d, dVar)) {
                this.f14536d = dVar;
                this.f14533a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public q2(g.a.l<T> lVar, g.a.x0.c<T, T, T> cVar) {
        this.f14531a = lVar;
        this.f14532b = cVar;
    }

    @Override // g.a.y0.c.b
    public g.a.l<T> b() {
        return g.a.c1.a.a(new p2(this.f14531a, this.f14532b));
    }

    @Override // g.a.y0.c.h
    public i.d.b<T> source() {
        return this.f14531a;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14531a.a((g.a.q) new a(vVar, this.f14532b));
    }
}
