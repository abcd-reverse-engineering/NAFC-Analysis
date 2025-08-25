package g.a.y0.e.b;

import g.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableIntervalRange.java */
/* loaded from: classes2.dex */
public final class r1 extends g.a.l<Long> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f14564b;

    /* renamed from: c, reason: collision with root package name */
    final long f14565c;

    /* renamed from: d, reason: collision with root package name */
    final long f14566d;

    /* renamed from: e, reason: collision with root package name */
    final long f14567e;

    /* renamed from: f, reason: collision with root package name */
    final long f14568f;

    /* renamed from: g, reason: collision with root package name */
    final TimeUnit f14569g;

    /* compiled from: FlowableIntervalRange.java */
    static final class a extends AtomicLong implements i.d.d, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final i.d.c<? super Long> actual;
        long count;
        final long end;
        final AtomicReference<g.a.u0.c> resource = new AtomicReference<>();

        a(i.d.c<? super Long> cVar, long j2, long j3) {
            this.actual = cVar;
            this.count = j2;
            this.end = j3;
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
                long j2 = get();
                if (j2 == 0) {
                    this.actual.onError(new g.a.v0.c("Can't deliver value " + this.count + " due to lack of requests"));
                    g.a.y0.a.d.dispose(this.resource);
                    return;
                }
                long j3 = this.count;
                this.actual.onNext(Long.valueOf(j3));
                if (j3 == this.end) {
                    if (this.resource.get() != g.a.y0.a.d.DISPOSED) {
                        this.actual.onComplete();
                    }
                    g.a.y0.a.d.dispose(this.resource);
                } else {
                    this.count = j3 + 1;
                    if (j2 != h.q2.t.m0.f16408b) {
                        decrementAndGet();
                    }
                }
            }
        }

        public void setResource(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this.resource, cVar);
        }
    }

    public r1(long j2, long j3, long j4, long j5, TimeUnit timeUnit, g.a.j0 j0Var) {
        this.f14567e = j4;
        this.f14568f = j5;
        this.f14569g = timeUnit;
        this.f14564b = j0Var;
        this.f14565c = j2;
        this.f14566d = j3;
    }

    @Override // g.a.l
    public void d(i.d.c<? super Long> cVar) {
        a aVar = new a(cVar, this.f14565c, this.f14566d);
        cVar.onSubscribe(aVar);
        g.a.j0 j0Var = this.f14564b;
        if (!(j0Var instanceof g.a.y0.g.r)) {
            aVar.setResource(j0Var.a(aVar, this.f14567e, this.f14568f, this.f14569g));
            return;
        }
        j0.c cVarA = j0Var.a();
        aVar.setResource(cVarA);
        cVarA.a(aVar, this.f14567e, this.f14568f, this.f14569g);
    }
}
