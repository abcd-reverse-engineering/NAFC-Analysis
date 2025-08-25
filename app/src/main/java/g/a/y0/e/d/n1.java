package g.a.y0.e.d;

import g.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableInterval.java */
/* loaded from: classes2.dex */
public final class n1 extends g.a.b0<Long> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.j0 f15340a;

    /* renamed from: b, reason: collision with root package name */
    final long f15341b;

    /* renamed from: c, reason: collision with root package name */
    final long f15342c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f15343d;

    /* compiled from: ObservableInterval.java */
    static final class a extends AtomicReference<g.a.u0.c> implements g.a.u0.c, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        final g.a.i0<? super Long> actual;
        long count;

        a(g.a.i0<? super Long> i0Var) {
            this.actual = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() == g.a.y0.a.d.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != g.a.y0.a.d.DISPOSED) {
                g.a.i0<? super Long> i0Var = this.actual;
                long j2 = this.count;
                this.count = 1 + j2;
                i0Var.onNext(Long.valueOf(j2));
            }
        }

        public void setResource(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }
    }

    public n1(long j2, long j3, TimeUnit timeUnit, g.a.j0 j0Var) {
        this.f15341b = j2;
        this.f15342c = j3;
        this.f15343d = timeUnit;
        this.f15340a = j0Var;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super Long> i0Var) {
        a aVar = new a(i0Var);
        i0Var.onSubscribe(aVar);
        g.a.j0 j0Var = this.f15340a;
        if (!(j0Var instanceof g.a.y0.g.r)) {
            aVar.setResource(j0Var.a(aVar, this.f15341b, this.f15342c, this.f15343d));
            return;
        }
        j0.c cVarA = j0Var.a();
        aVar.setResource(cVarA);
        cVarA.a(aVar, this.f15341b, this.f15342c, this.f15343d);
    }
}
