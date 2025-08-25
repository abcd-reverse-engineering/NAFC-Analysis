package g.a.y0.e.a;

/* compiled from: CompletableToObservable.java */
/* loaded from: classes2.dex */
public final class m0<T> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14076a;

    /* compiled from: CompletableToObservable.java */
    static final class a implements g.a.f {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.i0<?> f14077a;

        a(g.a.i0<?> i0Var) {
            this.f14077a = i0Var;
        }

        @Override // g.a.f
        public void onComplete() {
            this.f14077a.onComplete();
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            this.f14077a.onError(th);
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            this.f14077a.onSubscribe(cVar);
        }
    }

    public m0(g.a.i iVar) {
        this.f14076a = iVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f14076a.a(new a(i0Var));
    }
}
