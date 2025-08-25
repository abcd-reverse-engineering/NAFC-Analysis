package g.a.y0.e.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableTakeLastTimed.java */
/* loaded from: classes2.dex */
public final class x3<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f14708c;

    /* renamed from: d, reason: collision with root package name */
    final long f14709d;

    /* renamed from: e, reason: collision with root package name */
    final TimeUnit f14710e;

    /* renamed from: f, reason: collision with root package name */
    final g.a.j0 f14711f;

    /* renamed from: g, reason: collision with root package name */
    final int f14712g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f14713h;

    /* compiled from: FlowableTakeLastTimed.java */
    static final class a<T> extends AtomicInteger implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -5677354903406201275L;
        final i.d.c<? super T> actual;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final g.a.y0.f.c<Object> queue;
        final AtomicLong requested = new AtomicLong();
        i.d.d s;
        final g.a.j0 scheduler;
        final long time;
        final TimeUnit unit;

        a(i.d.c<? super T> cVar, long j2, long j3, TimeUnit timeUnit, g.a.j0 j0Var, int i2, boolean z) {
            this.actual = cVar;
            this.count = j2;
            this.time = j3;
            this.unit = timeUnit;
            this.scheduler = j0Var;
            this.queue = new g.a.y0.f.c<>(i2);
            this.delayError = z;
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z, i.d.c<? super T> cVar, boolean z2) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z2) {
                if (!z) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                cVar.onError(th2);
                return true;
            }
            if (!z) {
                return false;
            }
            cVar.onComplete();
            return true;
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            i.d.c<? super T> cVar = this.actual;
            g.a.y0.f.c<Object> cVar2 = this.queue;
            boolean z = this.delayError;
            int iAddAndGet = 1;
            do {
                if (this.done) {
                    if (checkTerminated(cVar2.isEmpty(), cVar, z)) {
                        return;
                    }
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (true) {
                        if (checkTerminated(cVar2.a() == null, cVar, z)) {
                            return;
                        }
                        if (j2 != j3) {
                            cVar2.poll();
                            cVar.onNext(cVar2.poll());
                            j3++;
                        } else if (j3 != 0) {
                            g.a.y0.j.d.c(this.requested, j3);
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // i.d.c
        public void onComplete() {
            trim(this.scheduler.a(this.unit), this.queue);
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.delayError) {
                trim(this.scheduler.a(this.unit), this.queue);
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onNext(T t) {
            g.a.y0.f.c<Object> cVar = this.queue;
            long jA = this.scheduler.a(this.unit);
            cVar.offer(Long.valueOf(jA), t);
            trim(jA, cVar);
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
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }

        void trim(long j2, g.a.y0.f.c<Object> cVar) {
            long j3 = this.time;
            long j4 = this.count;
            boolean z = j4 == h.q2.t.m0.f16408b;
            while (!cVar.isEmpty()) {
                if (((Long) cVar.a()).longValue() >= j2 - j3 && (z || (cVar.b() >> 1) <= j4)) {
                    return;
                }
                cVar.poll();
                cVar.poll();
            }
        }
    }

    public x3(g.a.l<T> lVar, long j2, long j3, TimeUnit timeUnit, g.a.j0 j0Var, int i2, boolean z) {
        super(lVar);
        this.f14708c = j2;
        this.f14709d = j3;
        this.f14710e = timeUnit;
        this.f14711f = j0Var;
        this.f14712g = i2;
        this.f14713h = z;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14708c, this.f14709d, this.f14710e, this.f14711f, this.f14712g, this.f14713h));
    }
}
