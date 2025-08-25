package g.a.y0.e.c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeDelay.java */
/* loaded from: classes2.dex */
public final class l<T> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final long f14835b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f14836c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.j0 f14837d;

    /* compiled from: MaybeDelay.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c, Runnable {
        private static final long serialVersionUID = 5566860102500855068L;
        final g.a.v<? super T> actual;
        final long delay;
        Throwable error;
        final g.a.j0 scheduler;
        final TimeUnit unit;
        T value;

        a(g.a.v<? super T> vVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            this.actual = vVar;
            this.delay = j2;
            this.unit = timeUnit;
            this.scheduler = j0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.v
        public void onComplete() {
            schedule();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.error = th;
            schedule();
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.value = t;
            schedule();
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.actual.onSuccess(t);
            } else {
                this.actual.onComplete();
            }
        }

        void schedule() {
            g.a.y0.a.d.replace(this, this.scheduler.a(this, this.delay, this.unit));
        }
    }

    public l(g.a.y<T> yVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        super(yVar);
        this.f14835b = j2;
        this.f14836c = timeUnit;
        this.f14837d = j0Var;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar, this.f14835b, this.f14836c, this.f14837d));
    }
}
