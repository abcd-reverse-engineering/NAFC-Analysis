package g.a.y0.e.b;

/* compiled from: FlowableSkipWhile.java */
/* loaded from: classes2.dex */
public final class q3<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.r<? super T> f14538c;

    /* compiled from: FlowableSkipWhile.java */
    static final class a<T> implements g.a.q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14539a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f14540b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f14541c;

        /* renamed from: d, reason: collision with root package name */
        boolean f14542d;

        a(i.d.c<? super T> cVar, g.a.x0.r<? super T> rVar) {
            this.f14539a = cVar;
            this.f14540b = rVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.f14541c.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14539a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14539a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14542d) {
                this.f14539a.onNext(t);
                return;
            }
            try {
                if (this.f14540b.test(t)) {
                    this.f14541c.request(1L);
                } else {
                    this.f14542d = true;
                    this.f14539a.onNext(t);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14541c.cancel();
                this.f14539a.onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14541c, dVar)) {
                this.f14541c = dVar;
                this.f14539a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f14541c.request(j2);
        }
    }

    public q3(g.a.l<T> lVar, g.a.x0.r<? super T> rVar) {
        super(lVar);
        this.f14538c = rVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14538c));
    }
}
