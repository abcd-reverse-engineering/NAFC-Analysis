package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleCreate.java */
/* loaded from: classes2.dex */
public final class d<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.o0<T> f15746a;

    /* compiled from: SingleCreate.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.m0<T>, g.a.u0.c {
        private static final long serialVersionUID = -2467358622224974244L;
        final g.a.n0<? super T> actual;

        a(g.a.n0<? super T> n0Var) {
            this.actual = n0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.m0, g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.m0
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            g.a.c1.a.b(th);
        }

        @Override // g.a.m0
        public void onSuccess(T t) {
            g.a.u0.c andSet;
            g.a.u0.c cVar = get();
            g.a.y0.a.d dVar = g.a.y0.a.d.DISPOSED;
            if (cVar == dVar || (andSet = getAndSet(dVar)) == g.a.y0.a.d.DISPOSED) {
                return;
            }
            try {
                if (t == null) {
                    this.actual.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.actual.onSuccess(t);
                }
                if (andSet != null) {
                    andSet.dispose();
                }
            } catch (Throwable th) {
                if (andSet != null) {
                    andSet.dispose();
                }
                throw th;
            }
        }

        @Override // g.a.m0
        public void setCancellable(g.a.x0.f fVar) {
            setDisposable(new g.a.y0.a.b(fVar));
        }

        @Override // g.a.m0
        public void setDisposable(g.a.u0.c cVar) {
            g.a.y0.a.d.set(this, cVar);
        }

        @Override // g.a.m0
        public boolean tryOnError(Throwable th) {
            g.a.u0.c andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            g.a.u0.c cVar = get();
            g.a.y0.a.d dVar = g.a.y0.a.d.DISPOSED;
            if (cVar == dVar || (andSet = getAndSet(dVar)) == g.a.y0.a.d.DISPOSED) {
                return false;
            }
            try {
                this.actual.onError(th);
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    public d(g.a.o0<T> o0Var) {
        this.f15746a = o0Var;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        a aVar = new a(n0Var);
        n0Var.onSubscribe(aVar);
        try {
            this.f15746a.a(aVar);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            aVar.onError(th);
        }
    }
}
