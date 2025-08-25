package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleObserveOn.java */
/* loaded from: classes2.dex */
public final class j0<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15784a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f15785b;

    /* compiled from: SingleObserveOn.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.n0<T>, g.a.u0.c, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final g.a.n0<? super T> actual;
        Throwable error;
        final g.a.j0 scheduler;
        T value;

        a(g.a.n0<? super T> n0Var, g.a.j0 j0Var) {
            this.actual = n0Var;
            this.scheduler = j0Var;
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
            this.error = th;
            g.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.value = t;
            g.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
            } else {
                this.actual.onSuccess(this.value);
            }
        }
    }

    public j0(g.a.q0<T> q0Var, g.a.j0 j0Var) {
        this.f15784a = q0Var;
        this.f15785b = j0Var;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15784a.a(new a(n0Var, this.f15785b));
    }
}
