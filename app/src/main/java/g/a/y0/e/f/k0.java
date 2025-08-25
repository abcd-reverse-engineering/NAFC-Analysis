package g.a.y0.e.f;

/* compiled from: SingleOnErrorReturn.java */
/* loaded from: classes2.dex */
public final class k0<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<? extends T> f15789a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super Throwable, ? extends T> f15790b;

    /* renamed from: c, reason: collision with root package name */
    final T f15791c;

    /* compiled from: SingleOnErrorReturn.java */
    final class a implements g.a.n0<T> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.n0<? super T> f15792a;

        a(g.a.n0<? super T> n0Var) {
            this.f15792a = n0Var;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            T tApply;
            k0 k0Var = k0.this;
            g.a.x0.o<? super Throwable, ? extends T> oVar = k0Var.f15790b;
            if (oVar != null) {
                try {
                    tApply = oVar.apply(th);
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    this.f15792a.onError(new g.a.v0.a(th, th2));
                    return;
                }
            } else {
                tApply = k0Var.f15791c;
            }
            if (tApply != null) {
                this.f15792a.onSuccess(tApply);
                return;
            }
            NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
            nullPointerException.initCause(th);
            this.f15792a.onError(nullPointerException);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15792a.onSubscribe(cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.f15792a.onSuccess(t);
        }
    }

    public k0(g.a.q0<? extends T> q0Var, g.a.x0.o<? super Throwable, ? extends T> oVar, T t) {
        this.f15789a = q0Var;
        this.f15790b = oVar;
        this.f15791c = t;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15789a.a(new a(n0Var));
    }
}
