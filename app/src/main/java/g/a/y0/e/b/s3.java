package g.a.y0.e.b;

/* compiled from: FlowableSwitchIfEmpty.java */
/* loaded from: classes2.dex */
public final class s3<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final i.d.b<? extends T> f14603c;

    /* compiled from: FlowableSwitchIfEmpty.java */
    static final class a<T> implements g.a.q<T> {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14604a;

        /* renamed from: b, reason: collision with root package name */
        final i.d.b<? extends T> f14605b;

        /* renamed from: d, reason: collision with root package name */
        boolean f14607d = true;

        /* renamed from: c, reason: collision with root package name */
        final g.a.y0.i.i f14606c = new g.a.y0.i.i();

        a(i.d.c<? super T> cVar, i.d.b<? extends T> bVar) {
            this.f14604a = cVar;
            this.f14605b = bVar;
        }

        @Override // i.d.c
        public void onComplete() {
            if (!this.f14607d) {
                this.f14604a.onComplete();
            } else {
                this.f14607d = false;
                this.f14605b.subscribe(this);
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14604a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14607d) {
                this.f14607d = false;
            }
            this.f14604a.onNext(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            this.f14606c.setSubscription(dVar);
        }
    }

    public s3(g.a.l<T> lVar, i.d.b<? extends T> bVar) {
        super(lVar);
        this.f14603c = bVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        a aVar = new a(cVar, this.f14603c);
        cVar.onSubscribe(aVar.f14606c);
        this.f14110b.a((g.a.q) aVar);
    }
}
