package g.a.y0.e.d;

import g.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableIntervalRange.java */
/* loaded from: classes2.dex */
public final class o1 extends g.a.b0<Long> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.j0 f15364a;

    /* renamed from: b, reason: collision with root package name */
    final long f15365b;

    /* renamed from: c, reason: collision with root package name */
    final long f15366c;

    /* renamed from: d, reason: collision with root package name */
    final long f15367d;

    /* renamed from: e, reason: collision with root package name */
    final long f15368e;

    /* renamed from: f, reason: collision with root package name */
    final TimeUnit f15369f;

    /* compiled from: ObservableIntervalRange.java */
    static final class a extends AtomicReference<g.a.u0.c> implements g.a.u0.c, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        final g.a.i0<? super Long> actual;
        long count;
        final long end;

        a(g.a.i0<? super Long> i0Var, long j2, long j3) {
            this.actual = i0Var;
            this.count = j2;
            this.end = j3;
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
            if (isDisposed()) {
                return;
            }
            long j2 = this.count;
            this.actual.onNext(Long.valueOf(j2));
            if (j2 != this.end) {
                this.count = j2 + 1;
            } else {
                g.a.y0.a.d.dispose(this);
                this.actual.onComplete();
            }
        }

        public void setResource(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }
    }

    public o1(long j2, long j3, long j4, long j5, TimeUnit timeUnit, g.a.j0 j0Var) {
        this.f15367d = j4;
        this.f15368e = j5;
        this.f15369f = timeUnit;
        this.f15364a = j0Var;
        this.f15365b = j2;
        this.f15366c = j3;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super Long> i0Var) {
        a aVar = new a(i0Var, this.f15365b, this.f15366c);
        i0Var.onSubscribe(aVar);
        g.a.j0 j0Var = this.f15364a;
        if (!(j0Var instanceof g.a.y0.g.r)) {
            aVar.setResource(j0Var.a(aVar, this.f15367d, this.f15368e, this.f15369f));
            return;
        }
        j0.c cVarA = j0Var.a();
        aVar.setResource(cVarA);
        cVarA.a(aVar, this.f15367d, this.f15368e, this.f15369f);
    }
}
