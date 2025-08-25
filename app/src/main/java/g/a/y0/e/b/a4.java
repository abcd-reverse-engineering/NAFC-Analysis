package g.a.y0.e.b;

/* compiled from: FlowableTakeUntilPredicate.java */
/* loaded from: classes2.dex */
public final class a4<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.r<? super T> f14119c;

    /* compiled from: FlowableTakeUntilPredicate.java */
    static final class a<T> implements g.a.q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14120a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f14121b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f14122c;

        /* renamed from: d, reason: collision with root package name */
        boolean f14123d;

        a(i.d.c<? super T> cVar, g.a.x0.r<? super T> rVar) {
            this.f14120a = cVar;
            this.f14121b = rVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.f14122c.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14123d) {
                return;
            }
            this.f14123d = true;
            this.f14120a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14123d) {
                g.a.c1.a.b(th);
            } else {
                this.f14123d = true;
                this.f14120a.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14123d) {
                return;
            }
            this.f14120a.onNext(t);
            try {
                if (this.f14121b.test(t)) {
                    this.f14123d = true;
                    this.f14122c.cancel();
                    this.f14120a.onComplete();
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14122c.cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14122c, dVar)) {
                this.f14122c = dVar;
                this.f14120a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f14122c.request(j2);
        }
    }

    public a4(g.a.l<T> lVar, g.a.x0.r<? super T> rVar) {
        super(lVar);
        this.f14119c = rVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14119c));
    }
}
