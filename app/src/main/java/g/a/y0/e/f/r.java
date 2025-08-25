package g.a.y0.e.f;

/* compiled from: SingleDoOnSubscribe.java */
/* loaded from: classes2.dex */
public final class r<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15834a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.g<? super g.a.u0.c> f15835b;

    /* compiled from: SingleDoOnSubscribe.java */
    static final class a<T> implements g.a.n0<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super T> f15836a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.g<? super g.a.u0.c> f15837b;

        /* renamed from: c, reason: collision with root package name */
        boolean f15838c;

        a(g.a.n0<? super T> n0Var, g.a.x0.g<? super g.a.u0.c> gVar) {
            this.f15836a = n0Var;
            this.f15837b = gVar;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            if (this.f15838c) {
                g.a.c1.a.b(th);
            } else {
                this.f15836a.onError(th);
            }
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            try {
                this.f15837b.accept(cVar);
                this.f15836a.onSubscribe(cVar);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15838c = true;
                cVar.dispose();
                g.a.y0.a.e.error(th, this.f15836a);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            if (this.f15838c) {
                return;
            }
            this.f15836a.onSuccess(t);
        }
    }

    public r(g.a.q0<T> q0Var, g.a.x0.g<? super g.a.u0.c> gVar) {
        this.f15834a = q0Var;
        this.f15835b = gVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15834a.a(new a(n0Var, this.f15835b));
    }
}
