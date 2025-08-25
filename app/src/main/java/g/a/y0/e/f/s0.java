package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleUnsubscribeOn.java */
/* loaded from: classes2.dex */
public final class s0<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15846a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f15847b;

    /* compiled from: SingleUnsubscribeOn.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.n0<T>, g.a.u0.c, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final g.a.n0<? super T> actual;
        g.a.u0.c ds;
        final g.a.j0 scheduler;

        a(g.a.n0<? super T> n0Var, g.a.j0 j0Var) {
            this.actual = n0Var;
            this.scheduler = j0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.u0.c andSet = getAndSet(g.a.y0.a.d.DISPOSED);
            if (andSet != g.a.y0.a.d.DISPOSED) {
                this.ds = andSet;
                this.scheduler.a(this);
            }
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
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.ds.dispose();
        }
    }

    public s0(g.a.q0<T> q0Var, g.a.j0 j0Var) {
        this.f15846a = q0Var;
        this.f15847b = j0Var;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15846a.a(new a(n0Var, this.f15847b));
    }
}
