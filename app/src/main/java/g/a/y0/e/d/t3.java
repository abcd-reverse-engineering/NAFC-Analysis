package g.a.y0.e.d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTimer.java */
/* loaded from: classes2.dex */
public final class t3 extends g.a.b0<Long> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.j0 f15493a;

    /* renamed from: b, reason: collision with root package name */
    final long f15494b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f15495c;

    /* compiled from: ObservableTimer.java */
    static final class a extends AtomicReference<g.a.u0.c> implements g.a.u0.c, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final g.a.i0<? super Long> actual;

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
            if (isDisposed()) {
                return;
            }
            this.actual.onNext(0L);
            lazySet(g.a.y0.a.e.INSTANCE);
            this.actual.onComplete();
        }

        public void setResource(g.a.u0.c cVar) {
            g.a.y0.a.d.trySet(this, cVar);
        }
    }

    public t3(long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        this.f15494b = j2;
        this.f15495c = timeUnit;
        this.f15493a = j0Var;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super Long> i0Var) {
        a aVar = new a(i0Var);
        i0Var.onSubscribe(aVar);
        aVar.setResource(this.f15493a.a(aVar, this.f15494b, this.f15495c));
    }
}
