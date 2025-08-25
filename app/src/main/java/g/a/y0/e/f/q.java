package g.a.y0.e.f;

/* compiled from: SingleDoOnEvent.java */
/* loaded from: classes2.dex */
public final class q<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15828a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.b<? super T, ? super Throwable> f15829b;

    /* compiled from: SingleDoOnEvent.java */
    final class a implements g.a.n0<T> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.n0<? super T> f15830a;

        a(g.a.n0<? super T> n0Var) {
            this.f15830a = n0Var;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            try {
                q.this.f15829b.a(null, th);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                th = new g.a.v0.a(th, th2);
            }
            this.f15830a.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15830a.onSubscribe(cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            try {
                q.this.f15829b.a(t, null);
                this.f15830a.onSuccess(t);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15830a.onError(th);
            }
        }
    }

    public q(g.a.q0<T> q0Var, g.a.x0.b<? super T, ? super Throwable> bVar) {
        this.f15828a = q0Var;
        this.f15829b = bVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15828a.a(new a(n0Var));
    }
}
