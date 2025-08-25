package g.a.y0.e.b;

/* compiled from: FlowableSkip.java */
/* loaded from: classes2.dex */
public final class m3<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f14400c;

    /* compiled from: FlowableSkip.java */
    static final class a<T> implements g.a.q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14401a;

        /* renamed from: b, reason: collision with root package name */
        long f14402b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f14403c;

        a(i.d.c<? super T> cVar, long j2) {
            this.f14401a = cVar;
            this.f14402b = j2;
        }

        @Override // i.d.d
        public void cancel() {
            this.f14403c.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14401a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14401a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            long j2 = this.f14402b;
            if (j2 != 0) {
                this.f14402b = j2 - 1;
            } else {
                this.f14401a.onNext(t);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14403c, dVar)) {
                long j2 = this.f14402b;
                this.f14403c = dVar;
                this.f14401a.onSubscribe(this);
                dVar.request(j2);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f14403c.request(j2);
        }
    }

    public m3(g.a.l<T> lVar, long j2) {
        super(lVar);
        this.f14400c = j2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14400c));
    }
}
