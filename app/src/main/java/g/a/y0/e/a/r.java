package g.a.y0.e.a;

/* compiled from: CompletableFromObservable.java */
/* loaded from: classes2.dex */
public final class r<T> extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f14092a;

    /* compiled from: CompletableFromObservable.java */
    static final class a<T> implements g.a.i0<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f f14093a;

        a(g.a.f fVar) {
            this.f14093a = fVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f14093a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f14093a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f14093a.onSubscribe(cVar);
        }
    }

    public r(g.a.g0<T> g0Var) {
        this.f14092a = g0Var;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14092a.subscribe(new a(fVar));
    }
}
