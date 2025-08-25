package g.a.y0.e.b;

/* compiled from: FlowableDetach.java */
/* loaded from: classes2.dex */
public final class j0<T> extends g.a.y0.e.b.a<T, T> {

    /* compiled from: FlowableDetach.java */
    static final class a<T> implements g.a.q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        i.d.c<? super T> f14297a;

        /* renamed from: b, reason: collision with root package name */
        i.d.d f14298b;

        a(i.d.c<? super T> cVar) {
            this.f14297a = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            i.d.d dVar = this.f14298b;
            this.f14298b = g.a.y0.j.h.INSTANCE;
            this.f14297a = g.a.y0.j.h.asSubscriber();
            dVar.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            i.d.c<? super T> cVar = this.f14297a;
            this.f14298b = g.a.y0.j.h.INSTANCE;
            this.f14297a = g.a.y0.j.h.asSubscriber();
            cVar.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            i.d.c<? super T> cVar = this.f14297a;
            this.f14298b = g.a.y0.j.h.INSTANCE;
            this.f14297a = g.a.y0.j.h.asSubscriber();
            cVar.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.f14297a.onNext(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14298b, dVar)) {
                this.f14298b = dVar;
                this.f14297a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f14298b.request(j2);
        }
    }

    public j0(g.a.l<T> lVar) {
        super(lVar);
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar));
    }
}
