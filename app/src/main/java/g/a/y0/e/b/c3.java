package g.a.y0.e.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSampleTimed.java */
/* loaded from: classes2.dex */
public final class c3<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f14152c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f14153d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.j0 f14154e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f14155f;

    /* compiled from: FlowableSampleTimed.java */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        a(i.d.c<? super T> cVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            super(cVar, j2, timeUnit, j0Var);
            this.wip = new AtomicInteger(1);
        }

        @Override // g.a.y0.e.b.c3.c
        void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.actual.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.actual.onComplete();
                }
            }
        }
    }

    /* compiled from: FlowableSampleTimed.java */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        b(i.d.c<? super T> cVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            super(cVar, j2, timeUnit, j0Var);
        }

        @Override // g.a.y0.e.b.c3.c
        void complete() {
            this.actual.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    /* compiled from: FlowableSampleTimed.java */
    static abstract class c<T> extends AtomicReference<T> implements g.a.q<T>, i.d.d, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final i.d.c<? super T> actual;
        final long period;
        i.d.d s;
        final g.a.j0 scheduler;
        final TimeUnit unit;
        final AtomicLong requested = new AtomicLong();
        final g.a.y0.a.k timer = new g.a.y0.a.k();

        c(i.d.c<? super T> cVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            this.actual = cVar;
            this.period = j2;
            this.unit = timeUnit;
            this.scheduler = j0Var;
        }

        @Override // i.d.d
        public void cancel() {
            cancelTimer();
            this.s.cancel();
        }

        void cancelTimer() {
            g.a.y0.a.d.dispose(this.timer);
        }

        abstract void complete();

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(andSet);
                    g.a.y0.j.d.c(this.requested, 1L);
                } else {
                    cancel();
                    this.actual.onError(new g.a.v0.c("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        @Override // i.d.c
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            cancelTimer();
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                g.a.y0.a.k kVar = this.timer;
                g.a.j0 j0Var = this.scheduler;
                long j2 = this.period;
                kVar.replace(j0Var.a(this, j2, j2, this.unit));
                dVar.request(h.q2.t.m0.f16408b);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
            }
        }
    }

    public c3(g.a.l<T> lVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var, boolean z) {
        super(lVar);
        this.f14152c = j2;
        this.f14153d = timeUnit;
        this.f14154e = j0Var;
        this.f14155f = z;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        g.a.g1.e eVar = new g.a.g1.e(cVar);
        if (this.f14155f) {
            this.f14110b.a((g.a.q) new a(eVar, this.f14152c, this.f14153d, this.f14154e));
        } else {
            this.f14110b.a((g.a.q) new b(eVar, this.f14152c, this.f14153d, this.f14154e));
        }
    }
}
