package g.a.y0.e.f;

/* compiled from: SingleToFlowable.java */
/* loaded from: classes2.dex */
public final class q0<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.q0<? extends T> f15832b;

    /* compiled from: SingleToFlowable.java */
    static final class a<T> extends g.a.y0.i.f<T> implements g.a.n0<T> {
        private static final long serialVersionUID = 187782011903685568L;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15833d;

        a(i.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // g.a.y0.i.f, i.d.d
        public void cancel() {
            super.cancel();
            this.f15833d.dispose();
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15833d, cVar)) {
                this.f15833d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public q0(g.a.q0<? extends T> q0Var) {
        this.f15832b = q0Var;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        this.f15832b.a(new a(cVar));
    }
}
