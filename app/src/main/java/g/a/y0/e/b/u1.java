package g.a.y0.e.b;

/* compiled from: FlowableLastMaybe.java */
/* loaded from: classes2.dex */
public final class u1<T> extends g.a.s<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.d.b<T> f14649a;

    /* compiled from: FlowableLastMaybe.java */
    static final class a<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14650a;

        /* renamed from: b, reason: collision with root package name */
        i.d.d f14651b;

        /* renamed from: c, reason: collision with root package name */
        T f14652c;

        a(g.a.v<? super T> vVar) {
            this.f14650a = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14651b.cancel();
            this.f14651b = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14651b == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14651b = g.a.y0.i.j.CANCELLED;
            T t = this.f14652c;
            if (t == null) {
                this.f14650a.onComplete();
            } else {
                this.f14652c = null;
                this.f14650a.onSuccess(t);
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14651b = g.a.y0.i.j.CANCELLED;
            this.f14652c = null;
            this.f14650a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.f14652c = t;
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14651b, dVar)) {
                this.f14651b = dVar;
                this.f14650a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public u1(i.d.b<T> bVar) {
        this.f14649a = bVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14649a.subscribe(new a(vVar));
    }
}
