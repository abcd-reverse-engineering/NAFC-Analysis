package g.a.y0.e.b;

import g.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableThrottleFirstTimed.java */
/* loaded from: classes2.dex */
public final class c4<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f14156c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f14157d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.j0 f14158e;

    /* compiled from: FlowableThrottleFirstTimed.java */
    static final class a<T> extends AtomicLong implements g.a.q<T>, i.d.d, Runnable {
        private static final long serialVersionUID = -9102637559663639004L;
        final i.d.c<? super T> actual;
        boolean done;
        volatile boolean gate;
        i.d.d s;
        final long timeout;
        final g.a.y0.a.k timer = new g.a.y0.a.k();
        final TimeUnit unit;
        final j0.c worker;

        a(i.d.c<? super T> cVar, long j2, TimeUnit timeUnit, j0.c cVar2) {
            this.actual = cVar;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar2;
        }

        @Override // i.d.d
        public void cancel() {
            this.s.cancel();
            this.worker.dispose();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done || this.gate) {
                return;
            }
            this.gate = true;
            if (get() == 0) {
                this.done = true;
                cancel();
                this.actual.onError(new g.a.v0.c("Could not deliver value due to lack of requests"));
            } else {
                this.actual.onNext(t);
                g.a.y0.j.d.c(this, 1L);
                g.a.u0.c cVar = this.timer.get();
                if (cVar != null) {
                    cVar.dispose();
                }
                this.timer.replace(this.worker.a(this, this.timeout, this.unit));
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this, j2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }
    }

    public c4(g.a.l<T> lVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        super(lVar);
        this.f14156c = j2;
        this.f14157d = timeUnit;
        this.f14158e = j0Var;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(new g.a.g1.e(cVar), this.f14156c, this.f14157d, this.f14158e.a()));
    }
}
