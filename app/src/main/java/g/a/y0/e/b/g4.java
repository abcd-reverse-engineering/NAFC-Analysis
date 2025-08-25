package g.a.y0.e.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableTimer.java */
/* loaded from: classes2.dex */
public final class g4 extends g.a.l<Long> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f14256b;

    /* renamed from: c, reason: collision with root package name */
    final long f14257c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f14258d;

    /* compiled from: FlowableTimer.java */
    static final class a extends AtomicReference<g.a.u0.c> implements i.d.d, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final i.d.c<? super Long> actual;
        volatile boolean requested;

        a(i.d.c<? super Long> cVar) {
            this.actual = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                this.requested = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != g.a.y0.a.d.DISPOSED) {
                if (!this.requested) {
                    lazySet(g.a.y0.a.e.INSTANCE);
                    this.actual.onError(new g.a.v0.c("Can't deliver value due to lack of requests"));
                } else {
                    this.actual.onNext(0L);
                    lazySet(g.a.y0.a.e.INSTANCE);
                    this.actual.onComplete();
                }
            }
        }

        public void setResource(g.a.u0.c cVar) {
            g.a.y0.a.d.trySet(this, cVar);
        }
    }

    public g4(long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        this.f14257c = j2;
        this.f14258d = timeUnit;
        this.f14256b = j0Var;
    }

    @Override // g.a.l
    public void d(i.d.c<? super Long> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        aVar.setResource(this.f14256b.a(aVar, this.f14257c, this.f14258d));
    }
}
