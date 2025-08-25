package g.a.y0.e.c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeTimer.java */
/* loaded from: classes2.dex */
public final class j1 extends g.a.s<Long> {

    /* renamed from: a, reason: collision with root package name */
    final long f14826a;

    /* renamed from: b, reason: collision with root package name */
    final TimeUnit f14827b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.j0 f14828c;

    /* compiled from: MaybeTimer.java */
    static final class a extends AtomicReference<g.a.u0.c> implements g.a.u0.c, Runnable {
        private static final long serialVersionUID = 2875964065294031672L;
        final g.a.v<? super Long> actual;

        a(g.a.v<? super Long> vVar) {
            this.actual = vVar;
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

    public j1(long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        this.f14826a = j2;
        this.f14827b = timeUnit;
        this.f14828c = j0Var;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super Long> vVar) {
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        aVar.setFuture(this.f14828c.a(aVar, this.f14826a, this.f14827b));
    }
}
