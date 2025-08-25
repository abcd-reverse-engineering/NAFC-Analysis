package g.a.y0.e.b;

/* compiled from: FlowableOnErrorNext.java */
/* loaded from: classes2.dex */
public final class j2<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super Throwable, ? extends i.d.b<? extends T>> f14302c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f14303d;

    /* compiled from: FlowableOnErrorNext.java */
    static final class a<T> implements g.a.q<T> {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14304a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super Throwable, ? extends i.d.b<? extends T>> f14305b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f14306c;

        /* renamed from: d, reason: collision with root package name */
        final g.a.y0.i.i f14307d = new g.a.y0.i.i();

        /* renamed from: e, reason: collision with root package name */
        boolean f14308e;

        /* renamed from: f, reason: collision with root package name */
        boolean f14309f;

        a(i.d.c<? super T> cVar, g.a.x0.o<? super Throwable, ? extends i.d.b<? extends T>> oVar, boolean z) {
            this.f14304a = cVar;
            this.f14305b = oVar;
            this.f14306c = z;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14309f) {
                return;
            }
            this.f14309f = true;
            this.f14308e = true;
            this.f14304a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14308e) {
                if (this.f14309f) {
                    g.a.c1.a.b(th);
                    return;
                } else {
                    this.f14304a.onError(th);
                    return;
                }
            }
            this.f14308e = true;
            if (this.f14306c && !(th instanceof Exception)) {
                this.f14304a.onError(th);
                return;
            }
            try {
                i.d.b<? extends T> bVarApply = this.f14305b.apply(th);
                if (bVarApply != null) {
                    bVarApply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Publisher is null");
                nullPointerException.initCause(th);
                this.f14304a.onError(nullPointerException);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.f14304a.onError(new g.a.v0.a(th, th2));
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14309f) {
                return;
            }
            this.f14304a.onNext(t);
            if (this.f14308e) {
                return;
            }
            this.f14307d.produced(1L);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            this.f14307d.setSubscription(dVar);
        }
    }

    public j2(g.a.l<T> lVar, g.a.x0.o<? super Throwable, ? extends i.d.b<? extends T>> oVar, boolean z) {
        super(lVar);
        this.f14302c = oVar;
        this.f14303d = z;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        a aVar = new a(cVar, this.f14302c, this.f14303d);
        cVar.onSubscribe(aVar.f14307d);
        this.f14110b.a((g.a.q) aVar);
    }
}
