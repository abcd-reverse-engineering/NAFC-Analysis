package g.a.y0.e.d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSampleTimed.java */
/* loaded from: classes2.dex */
public final class q2<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final long f15417b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f15418c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.j0 f15419d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f15420e;

    /* compiled from: ObservableSampleTimed.java */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        a(g.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            super(i0Var, j2, timeUnit, j0Var);
            this.wip = new AtomicInteger(1);
        }

        @Override // g.a.y0.e.d.q2.c
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

    /* compiled from: ObservableSampleTimed.java */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        b(g.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            super(i0Var, j2, timeUnit, j0Var);
        }

        @Override // g.a.y0.e.d.q2.c
        void complete() {
            this.actual.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    /* compiled from: ObservableSampleTimed.java */
    static abstract class c<T> extends AtomicReference<T> implements g.a.i0<T>, g.a.u0.c, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final g.a.i0<? super T> actual;
        final long period;
        g.a.u0.c s;
        final g.a.j0 scheduler;
        final AtomicReference<g.a.u0.c> timer = new AtomicReference<>();
        final TimeUnit unit;

        c(g.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            this.actual = i0Var;
            this.period = j2;
            this.unit = timeUnit;
            this.scheduler = j0Var;
        }

        void cancelTimer() {
            g.a.y0.a.d.dispose(this.timer);
        }

        abstract void complete();

        @Override // g.a.u0.c
        public void dispose() {
            cancelTimer();
            this.s.dispose();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.actual.onNext(andSet);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            cancelTimer();
            this.actual.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
                g.a.j0 j0Var = this.scheduler;
                long j2 = this.period;
                g.a.y0.a.d.replace(this.timer, j0Var.a(this, j2, j2, this.unit));
            }
        }
    }

    public q2(g.a.g0<T> g0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var, boolean z) {
        super(g0Var);
        this.f15417b = j2;
        this.f15418c = timeUnit;
        this.f15419d = j0Var;
        this.f15420e = z;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        g.a.a1.m mVar = new g.a.a1.m(i0Var);
        if (this.f15420e) {
            this.f14934a.subscribe(new a(mVar, this.f15417b, this.f15418c, this.f15419d));
        } else {
            this.f14934a.subscribe(new b(mVar, this.f15417b, this.f15418c, this.f15419d));
        }
    }
}
