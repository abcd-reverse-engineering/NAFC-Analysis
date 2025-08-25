package g.a.y0.e.b;

/* compiled from: FlowableHide.java */
/* loaded from: classes2.dex */
public final class m1<T> extends g.a.y0.e.b.a<T, T> {

    /* compiled from: FlowableHide.java */
    static final class a<T> implements g.a.q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14380a;

        /* renamed from: b, reason: collision with root package name */
        i.d.d f14381b;

        a(i.d.c<? super T> cVar) {
            this.f14380a = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.f14381b.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14380a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14380a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.f14380a.onNext(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14381b, dVar)) {
                this.f14381b = dVar;
                this.f14380a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f14381b.request(j2);
        }
    }

    public m1(g.a.l<T> lVar) {
        super(lVar);
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar));
    }
}
