package g.a.y0.e.b;

/* compiled from: FlowableDelaySubscriptionOther.java */
/* loaded from: classes2.dex */
public final class h0<T, U> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<? extends T> f14264b;

    /* renamed from: c, reason: collision with root package name */
    final i.d.b<U> f14265c;

    /* compiled from: FlowableDelaySubscriptionOther.java */
    final class a implements g.a.q<U> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.y0.i.i f14266a;

        /* renamed from: b, reason: collision with root package name */
        final i.d.c<? super T> f14267b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14268c;

        /* compiled from: FlowableDelaySubscriptionOther.java */
        /* renamed from: g.a.y0.e.b.h0$a$a, reason: collision with other inner class name */
        final class C0191a implements i.d.d {

            /* renamed from: a, reason: collision with root package name */
            private final i.d.d f14270a;

            C0191a(i.d.d dVar) {
                this.f14270a = dVar;
            }

            @Override // i.d.d
            public void cancel() {
                this.f14270a.cancel();
            }

            @Override // i.d.d
            public void request(long j2) {
            }
        }

        /* compiled from: FlowableDelaySubscriptionOther.java */
        final class b implements g.a.q<T> {
            b() {
            }

            @Override // i.d.c
            public void onComplete() {
                a.this.f14267b.onComplete();
            }

            @Override // i.d.c
            public void onError(Throwable th) {
                a.this.f14267b.onError(th);
            }

            @Override // i.d.c
            public void onNext(T t) {
                a.this.f14267b.onNext(t);
            }

            @Override // g.a.q
            public void onSubscribe(i.d.d dVar) {
                a.this.f14266a.setSubscription(dVar);
            }
        }

        a(g.a.y0.i.i iVar, i.d.c<? super T> cVar) {
            this.f14266a = iVar;
            this.f14267b = cVar;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14268c) {
                return;
            }
            this.f14268c = true;
            h0.this.f14264b.subscribe(new b());
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14268c) {
                g.a.c1.a.b(th);
            } else {
                this.f14268c = true;
                this.f14267b.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(U u) {
            onComplete();
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            this.f14266a.setSubscription(new C0191a(dVar));
            dVar.request(h.q2.t.m0.f16408b);
        }
    }

    public h0(i.d.b<? extends T> bVar, i.d.b<U> bVar2) {
        this.f14264b = bVar;
        this.f14265c = bVar2;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        g.a.y0.i.i iVar = new g.a.y0.i.i();
        cVar.onSubscribe(iVar);
        this.f14265c.subscribe(new a(iVar, cVar));
    }
}
