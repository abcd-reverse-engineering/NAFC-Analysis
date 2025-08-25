package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDelayWithSingle.java */
/* loaded from: classes2.dex */
public final class j<T, U> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15782a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.q0<U> f15783b;

    /* compiled from: SingleDelayWithSingle.java */
    static final class a<T, U> extends AtomicReference<g.a.u0.c> implements g.a.n0<U>, g.a.u0.c {
        private static final long serialVersionUID = -8565274649390031272L;
        final g.a.n0<? super T> actual;
        final g.a.q0<T> source;

        a(g.a.n0<? super T> n0Var, g.a.q0<T> q0Var) {
            this.actual = n0Var;
            this.source = q0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.set(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(U u) {
            this.source.a(new g.a.y0.d.a0(this, this.actual));
        }
    }

    public j(g.a.q0<T> q0Var, g.a.q0<U> q0Var2) {
        this.f15782a = q0Var;
        this.f15783b = q0Var2;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15783b.a(new a(n0Var, this.f15782a));
    }
}
