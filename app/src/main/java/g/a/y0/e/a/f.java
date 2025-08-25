package g.a.y0.e.a;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableCreate.java */
/* loaded from: classes2.dex */
public final class f extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g f14007a;

    /* compiled from: CompletableCreate.java */
    static final class a extends AtomicReference<g.a.u0.c> implements g.a.e, g.a.u0.c {
        private static final long serialVersionUID = -2467358622224974244L;
        final g.a.f actual;

        a(g.a.f fVar) {
            this.actual = fVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.e, g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.e
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

        @Override // g.a.e
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            g.a.c1.a.b(th);
        }

        @Override // g.a.e
        public void setCancellable(g.a.x0.f fVar) {
            setDisposable(new g.a.y0.a.b(fVar));
        }

        @Override // g.a.e
        public void setDisposable(g.a.u0.c cVar) {
            g.a.y0.a.d.set(this, cVar);
        }

        @Override // g.a.e
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

    public f(g.a.g gVar) {
        this.f14007a = gVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        a aVar = new a(fVar);
        fVar.onSubscribe(aVar);
        try {
            this.f14007a.a(aVar);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            aVar.onError(th);
        }
    }
}
