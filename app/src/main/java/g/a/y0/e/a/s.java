package g.a.y0.e.a;

/* compiled from: CompletableFromPublisher.java */
/* loaded from: classes2.dex */
public final class s<T> extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final i.d.b<T> f14094a;

    /* compiled from: CompletableFromPublisher.java */
    static final class a<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f f14095a;

        /* renamed from: b, reason: collision with root package name */
        i.d.d f14096b;

        a(g.a.f fVar) {
            this.f14095a = fVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14096b.cancel();
            this.f14096b = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14096b == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14095a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14095a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14096b, dVar)) {
                this.f14096b = dVar;
                this.f14095a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public s(i.d.b<T> bVar) {
        this.f14094a = bVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14094a.subscribe(new a(fVar));
    }
}
