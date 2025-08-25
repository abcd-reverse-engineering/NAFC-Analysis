package g.a.y0.e.b;

/* compiled from: FlowableDoOnLifecycle.java */
/* loaded from: classes2.dex */
public final class p0<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    private final g.a.x0.g<? super i.d.d> f14465c;

    /* renamed from: d, reason: collision with root package name */
    private final g.a.x0.q f14466d;

    /* renamed from: e, reason: collision with root package name */
    private final g.a.x0.a f14467e;

    /* compiled from: FlowableDoOnLifecycle.java */
    static final class a<T> implements g.a.q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14468a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.g<? super i.d.d> f14469b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.x0.q f14470c;

        /* renamed from: d, reason: collision with root package name */
        final g.a.x0.a f14471d;

        /* renamed from: e, reason: collision with root package name */
        i.d.d f14472e;

        a(i.d.c<? super T> cVar, g.a.x0.g<? super i.d.d> gVar, g.a.x0.q qVar, g.a.x0.a aVar) {
            this.f14468a = cVar;
            this.f14469b = gVar;
            this.f14471d = aVar;
            this.f14470c = qVar;
        }

        @Override // i.d.d
        public void cancel() {
            try {
                this.f14471d.run();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
            this.f14472e.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14472e != g.a.y0.i.j.CANCELLED) {
                this.f14468a.onComplete();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14472e != g.a.y0.i.j.CANCELLED) {
                this.f14468a.onError(th);
            } else {
                g.a.c1.a.b(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.f14468a.onNext(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            try {
                this.f14469b.accept(dVar);
                if (g.a.y0.i.j.validate(this.f14472e, dVar)) {
                    this.f14472e = dVar;
                    this.f14468a.onSubscribe(this);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                dVar.cancel();
                this.f14472e = g.a.y0.i.j.CANCELLED;
                g.a.y0.i.g.error(th, this.f14468a);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            try {
                this.f14470c.a(j2);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
            this.f14472e.request(j2);
        }
    }

    public p0(g.a.l<T> lVar, g.a.x0.g<? super i.d.d> gVar, g.a.x0.q qVar, g.a.x0.a aVar) {
        super(lVar);
        this.f14465c = gVar;
        this.f14466d = qVar;
        this.f14467e = aVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14465c, this.f14466d, this.f14467e));
    }
}
