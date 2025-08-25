package g.a.y0.e.a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableTimer.java */
/* loaded from: classes2.dex */
public final class k0 extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final long f14067a;

    /* renamed from: b, reason: collision with root package name */
    final TimeUnit f14068b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.j0 f14069c;

    /* compiled from: CompletableTimer.java */
    static final class a extends AtomicReference<g.a.u0.c> implements g.a.u0.c, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        final g.a.f actual;

        a(g.a.f fVar) {
            this.actual = fVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.actual.onComplete();
        }

        void setFuture(g.a.u0.c cVar) {
            g.a.y0.a.d.replace(this, cVar);
        }
    }

    public k0(long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        this.f14067a = j2;
        this.f14068b = timeUnit;
        this.f14069c = j0Var;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        a aVar = new a(fVar);
        fVar.onSubscribe(aVar);
        aVar.setFuture(this.f14069c.a(aVar, this.f14067a, this.f14068b));
    }
}
