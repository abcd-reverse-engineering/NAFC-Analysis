package g.a.y0.e.b;

import g.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableInterval.java */
/* loaded from: classes2.dex */
public final class q1 extends g.a.l<Long> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f14527b;

    /* renamed from: c, reason: collision with root package name */
    final long f14528c;

    /* renamed from: d, reason: collision with root package name */
    final long f14529d;

    /* renamed from: e, reason: collision with root package name */
    final TimeUnit f14530e;

    /* compiled from: FlowableInterval.java */
    static final class a extends AtomicLong implements i.d.d, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final i.d.c<? super Long> actual;
        long count;
        final AtomicReference<g.a.u0.c> resource = new AtomicReference<>();

        a(i.d.c<? super Long> cVar) {
            this.actual = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.a.d.dispose(this.resource);
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this, j2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.resource.get() != g.a.y0.a.d.DISPOSED) {
                if (get() != 0) {
                    i.d.c<? super Long> cVar = this.actual;
                    long j2 = this.count;
                    this.count = j2 + 1;
                    cVar.onNext(Long.valueOf(j2));
                    g.a.y0.j.d.c(this, 1L);
                    return;
                }
                this.actual.onError(new g.a.v0.c("Can't deliver value " + this.count + " due to lack of requests"));
                g.a.y0.a.d.dispose(this.resource);
            }
        }

        public void setResource(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this.resource, cVar);
        }
    }

    public q1(long j2, long j3, TimeUnit timeUnit, g.a.j0 j0Var) {
        this.f14528c = j2;
        this.f14529d = j3;
        this.f14530e = timeUnit;
        this.f14527b = j0Var;
    }

    @Override // g.a.l
    public void d(i.d.c<? super Long> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        g.a.j0 j0Var = this.f14527b;
        if (!(j0Var instanceof g.a.y0.g.r)) {
            aVar.setResource(j0Var.a(aVar, this.f14528c, this.f14529d, this.f14530e));
            return;
        }
        j0.c cVarA = j0Var.a();
        aVar.setResource(cVarA);
        cVarA.a(aVar, this.f14528c, this.f14529d, this.f14530e);
    }
}
