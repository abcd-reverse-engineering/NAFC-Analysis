package g.a.y0.e.f;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleTimer.java */
/* loaded from: classes2.dex */
public final class p0 extends g.a.k0<Long> {

    /* renamed from: a, reason: collision with root package name */
    final long f15825a;

    /* renamed from: b, reason: collision with root package name */
    final TimeUnit f15826b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.j0 f15827c;

    /* compiled from: SingleTimer.java */
    static final class a extends AtomicReference<g.a.u0.c> implements g.a.u0.c, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;
        final g.a.n0<? super Long> actual;

        a(g.a.n0<? super Long> n0Var) {
            this.actual = n0Var;
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
            this.actual.onSuccess(0L);
        }

        void setFuture(g.a.u0.c cVar) {
            g.a.y0.a.d.replace(this, cVar);
        }
    }

    public p0(long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        this.f15825a = j2;
        this.f15826b = timeUnit;
        this.f15827c = j0Var;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super Long> n0Var) {
        a aVar = new a(n0Var);
        n0Var.onSubscribe(aVar);
        aVar.setFuture(this.f15827c.a(aVar, this.f15825a, this.f15826b));
    }
}
