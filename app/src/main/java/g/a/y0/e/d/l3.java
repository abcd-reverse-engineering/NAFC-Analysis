package g.a.y0.e.d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableTakeLastTimed.java */
/* loaded from: classes2.dex */
public final class l3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final long f15251b;

    /* renamed from: c, reason: collision with root package name */
    final long f15252c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f15253d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.j0 f15254e;

    /* renamed from: f, reason: collision with root package name */
    final int f15255f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f15256g;

    /* compiled from: ObservableTakeLastTimed.java */
    static final class a<T> extends AtomicBoolean implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = -5677354903406201275L;
        final g.a.i0<? super T> actual;
        volatile boolean cancelled;
        final long count;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15257d;
        final boolean delayError;
        Throwable error;
        final g.a.y0.f.c<Object> queue;
        final g.a.j0 scheduler;
        final long time;
        final TimeUnit unit;

        a(g.a.i0<? super T> i0Var, long j2, long j3, TimeUnit timeUnit, g.a.j0 j0Var, int i2, boolean z) {
            this.actual = i0Var;
            this.count = j2;
            this.time = j3;
            this.unit = timeUnit;
            this.scheduler = j0Var;
            this.queue = new g.a.y0.f.c<>(i2);
            this.delayError = z;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f15257d.dispose();
            if (compareAndSet(false, true)) {
                this.queue.clear();
            }
        }

        void drain() {
            Throwable th;
            if (compareAndSet(false, true)) {
                g.a.i0<? super T> i0Var = this.actual;
                g.a.y0.f.c<Object> cVar = this.queue;
                boolean z = this.delayError;
                while (!this.cancelled) {
                    if (!z && (th = this.error) != null) {
                        cVar.clear();
                        i0Var.onError(th);
                        return;
                    }
                    Object objPoll = cVar.poll();
                    if (objPoll == null) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            i0Var.onError(th2);
                            return;
                        } else {
                            i0Var.onComplete();
                            return;
                        }
                    }
                    Object objPoll2 = cVar.poll();
                    if (((Long) objPoll).longValue() >= this.scheduler.a(this.unit) - this.time) {
                        i0Var.onNext(objPoll2);
                    }
                }
                cVar.clear();
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // g.a.i0
        public void onComplete() {
            drain();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.error = th;
            drain();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            g.a.y0.f.c<Object> cVar = this.queue;
            long jA = this.scheduler.a(this.unit);
            long j2 = this.time;
            long j3 = this.count;
            boolean z = j3 == h.q2.t.m0.f16408b;
            cVar.offer(Long.valueOf(jA), t);
            while (!cVar.isEmpty()) {
                if (((Long) cVar.a()).longValue() > jA - j2 && (z || (cVar.b() >> 1) <= j3)) {
                    return;
                }
                cVar.poll();
                cVar.poll();
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15257d, cVar)) {
                this.f15257d = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public l3(g.a.g0<T> g0Var, long j2, long j3, TimeUnit timeUnit, g.a.j0 j0Var, int i2, boolean z) {
        super(g0Var);
        this.f15251b = j2;
        this.f15252c = j3;
        this.f15253d = timeUnit;
        this.f15254e = j0Var;
        this.f15255f = i2;
        this.f15256g = z;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15251b, this.f15252c, this.f15253d, this.f15254e, this.f15255f, this.f15256g));
    }
}
