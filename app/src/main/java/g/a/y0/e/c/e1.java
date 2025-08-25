package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeSwitchIfEmptySingle.java */
/* loaded from: classes2.dex */
public final class e1<T> extends g.a.k0<T> implements g.a.y0.c.f<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<T> f14793a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.q0<? extends T> f14794b;

    /* compiled from: MaybeSwitchIfEmptySingle.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c {
        private static final long serialVersionUID = 4603919676453758899L;
        final g.a.n0<? super T> actual;
        final g.a.q0<? extends T> other;

        /* compiled from: MaybeSwitchIfEmptySingle.java */
        /* renamed from: g.a.y0.e.c.e1$a$a, reason: collision with other inner class name */
        static final class C0202a<T> implements g.a.n0<T> {

            /* renamed from: a, reason: collision with root package name */
            final g.a.n0<? super T> f14795a;

            /* renamed from: b, reason: collision with root package name */
            final AtomicReference<g.a.u0.c> f14796b;

            C0202a(g.a.n0<? super T> n0Var, AtomicReference<g.a.u0.c> atomicReference) {
                this.f14795a = n0Var;
                this.f14796b = atomicReference;
            }

            @Override // g.a.n0
            public void onError(Throwable th) {
                this.f14795a.onError(th);
            }

            @Override // g.a.n0
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.setOnce(this.f14796b, cVar);
            }

            @Override // g.a.n0
            public void onSuccess(T t) {
                this.f14795a.onSuccess(t);
            }
        }

        a(g.a.n0<? super T> n0Var, g.a.q0<? extends T> q0Var) {
            this.actual = n0Var;
            this.other = q0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.v
        public void onComplete() {
            g.a.u0.c cVar = get();
            if (cVar == g.a.y0.a.d.DISPOSED || !compareAndSet(cVar, null)) {
                return;
            }
            this.other.a(new C0202a(this.actual, this));
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public e1(g.a.y<T> yVar, g.a.q0<? extends T> q0Var) {
        this.f14793a = yVar;
        this.f14794b = q0Var;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f14793a.a(new a(n0Var, this.f14794b));
    }

    @Override // g.a.y0.c.f
    public g.a.y<T> source() {
        return this.f14793a;
    }
}
