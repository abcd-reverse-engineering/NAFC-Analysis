package g.a.y0.e.d;

import g.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableThrottleFirstTimed.java */
/* loaded from: classes2.dex */
public final class p3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final long f15393b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f15394c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.j0 f15395d;

    /* compiled from: ObservableThrottleFirstTimed.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.i0<T>, g.a.u0.c, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        final g.a.i0<? super T> actual;
        boolean done;
        volatile boolean gate;
        g.a.u0.c s;
        final long timeout;
        final TimeUnit unit;
        final j0.c worker;

        a(g.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, j0.c cVar) {
            this.actual = i0Var;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.s.dispose();
            this.worker.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.gate || this.done) {
                return;
            }
            this.gate = true;
            this.actual.onNext(t);
            g.a.u0.c cVar = get();
            if (cVar != null) {
                cVar.dispose();
            }
            g.a.y0.a.d.replace(this, this.worker.a(this, this.timeout, this.unit));
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }
    }

    public p3(g.a.g0<T> g0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        super(g0Var);
        this.f15393b = j2;
        this.f15394c = timeUnit;
        this.f15395d = j0Var;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(new g.a.a1.m(i0Var), this.f15393b, this.f15394c, this.f15395d.a()));
    }
}
