package g.a.y0.e.b;

/* compiled from: FlowableDematerialize.java */
/* loaded from: classes2.dex */
public final class i0<T> extends g.a.y0.e.b.a<g.a.a0<T>, T> {

    /* compiled from: FlowableDematerialize.java */
    static final class a<T> implements g.a.q<g.a.a0<T>>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14282a;

        /* renamed from: b, reason: collision with root package name */
        boolean f14283b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f14284c;

        a(i.d.c<? super T> cVar) {
            this.f14282a = cVar;
        }

        @Override // i.d.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(g.a.a0<T> a0Var) {
            if (this.f14283b) {
                if (a0Var.d()) {
                    g.a.c1.a.b(a0Var.a());
                }
            } else if (a0Var.d()) {
                this.f14284c.cancel();
                onError(a0Var.a());
            } else if (!a0Var.c()) {
                this.f14282a.onNext(a0Var.b());
            } else {
                this.f14284c.cancel();
                onComplete();
            }
        }

        @Override // i.d.d
        public void cancel() {
            this.f14284c.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14283b) {
                return;
            }
            this.f14283b = true;
            this.f14282a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14283b) {
                g.a.c1.a.b(th);
            } else {
                this.f14283b = true;
                this.f14282a.onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14284c, dVar)) {
                this.f14284c = dVar;
                this.f14282a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f14284c.request(j2);
        }
    }

    public i0(g.a.l<g.a.a0<T>> lVar) {
        super(lVar);
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar));
    }
}
