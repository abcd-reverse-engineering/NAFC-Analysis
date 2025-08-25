package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDoOnDispose.java */
/* loaded from: classes2.dex */
public final class o<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15813a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.a f15814b;

    /* compiled from: SingleDoOnDispose.java */
    static final class a<T> extends AtomicReference<g.a.x0.a> implements g.a.n0<T>, g.a.u0.c {
        private static final long serialVersionUID = -8583764624474935784L;
        final g.a.n0<? super T> actual;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15815d;

        a(g.a.n0<? super T> n0Var, g.a.x0.a aVar) {
            this.actual = n0Var;
            lazySet(aVar);
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.x0.a andSet = getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.run();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.c1.a.b(th);
                }
                this.f15815d.dispose();
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15815d.isDisposed();
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15815d, cVar)) {
                this.f15815d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public o(g.a.q0<T> q0Var, g.a.x0.a aVar) {
        this.f15813a = q0Var;
        this.f15814b = aVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15813a.a(new a(n0Var, this.f15814b));
    }
}
