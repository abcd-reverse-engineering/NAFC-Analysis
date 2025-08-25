package g.a.y0.e.d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableSkipLastTimed.java */
/* loaded from: classes2.dex */
public final class c3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final long f15011b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f15012c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.j0 f15013d;

    /* renamed from: e, reason: collision with root package name */
    final int f15014e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f15015f;

    /* compiled from: ObservableSkipLastTimed.java */
    static final class a<T> extends AtomicInteger implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = -5677354903406201275L;
        final g.a.i0<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final g.a.y0.f.c<Object> queue;
        g.a.u0.c s;
        final g.a.j0 scheduler;
        final long time;
        final TimeUnit unit;

        a(g.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var, int i2, boolean z) {
            this.actual = i0Var;
            this.time = j2;
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
            this.s.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            g.a.i0<? super T> i0Var = this.actual;
            g.a.y0.f.c<Object> cVar = this.queue;
            boolean z = this.delayError;
            TimeUnit timeUnit = this.unit;
            g.a.j0 j0Var = this.scheduler;
            long j2 = this.time;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z2 = this.done;
                Long l2 = (Long) cVar.a();
                boolean z3 = l2 == null;
                long jA = j0Var.a(timeUnit);
                if (!z3 && l2.longValue() > jA - j2) {
                    z3 = true;
                }
                if (z2) {
                    if (!z) {
                        Throwable th = this.error;
                        if (th != null) {
                            this.queue.clear();
                            i0Var.onError(th);
                            return;
                        } else if (z3) {
                            i0Var.onComplete();
                            return;
                        }
                    } else if (z3) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            i0Var.onError(th2);
                            return;
                        } else {
                            i0Var.onComplete();
                            return;
                        }
                    }
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    cVar.poll();
                    i0Var.onNext(cVar.poll());
                }
            }
            this.queue.clear();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.queue.offer(Long.valueOf(this.scheduler.a(this.unit)), t);
            drain();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public c3(g.a.g0<T> g0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var, int i2, boolean z) {
        super(g0Var);
        this.f15011b = j2;
        this.f15012c = timeUnit;
        this.f15013d = j0Var;
        this.f15014e = i2;
        this.f15015f = z;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15011b, this.f15012c, this.f15013d, this.f15014e, this.f15015f));
    }
}
