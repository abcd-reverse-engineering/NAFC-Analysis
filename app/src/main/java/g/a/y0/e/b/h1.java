package g.a.y0.e.b;

/* compiled from: FlowableFromObservable.java */
/* loaded from: classes2.dex */
public final class h1<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    private final g.a.b0<T> f14273b;

    /* compiled from: FlowableFromObservable.java */
    static class a<T> implements g.a.i0<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        private final i.d.c<? super T> f14274a;

        /* renamed from: b, reason: collision with root package name */
        private g.a.u0.c f14275b;

        a(i.d.c<? super T> cVar) {
            this.f14274a = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.f14275b.dispose();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f14274a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f14274a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f14274a.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f14275b = cVar;
            this.f14274a.onSubscribe(this);
        }

        @Override // i.d.d
        public void request(long j2) {
        }
    }

    public h1(g.a.b0<T> b0Var) {
        this.f14273b = b0Var;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14273b.subscribe(new a(cVar));
    }
}
