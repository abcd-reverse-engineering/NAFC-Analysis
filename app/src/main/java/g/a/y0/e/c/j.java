package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeCreate.java */
/* loaded from: classes2.dex */
public final class j<T> extends g.a.s<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.w<T> f14822a;

    /* compiled from: MaybeCreate.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.u<T>, g.a.u0.c {
        private static final long serialVersionUID = -2467358622224974244L;
        final g.a.v<? super T> actual;

        a(g.a.v<? super T> vVar) {
            this.actual = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u, g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.u
        public void onComplete() {
            g.a.u0.c andSet;
            g.a.u0.c cVar = get();
            g.a.y0.a.d dVar = g.a.y0.a.d.DISPOSED;
            if (cVar == dVar || (andSet = getAndSet(dVar)) == g.a.y0.a.d.DISPOSED) {
                return;
            }
            try {
                this.actual.onComplete();
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        @Override // g.a.u
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            g.a.c1.a.b(th);
        }

        @Override // g.a.u
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

        @Override // g.a.u
        public void setCancellable(g.a.x0.f fVar) {
            setDisposable(new g.a.y0.a.b(fVar));
        }

        @Override // g.a.u
        public void setDisposable(g.a.u0.c cVar) {
            g.a.y0.a.d.set(this, cVar);
        }

        @Override // g.a.u
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

    public j(g.a.w<T> wVar) {
        this.f14822a = wVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        try {
            this.f14822a.a(aVar);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            aVar.onError(th);
        }
    }
}
