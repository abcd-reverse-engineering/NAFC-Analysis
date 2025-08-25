package g.a.y0.e.d;

import g.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTimeoutTimed.java */
/* loaded from: classes2.dex */
public final class s3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: f, reason: collision with root package name */
    static final g.a.u0.c f15467f = new a();

    /* renamed from: b, reason: collision with root package name */
    final long f15468b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f15469c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.j0 f15470d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.g0<? extends T> f15471e;

    /* compiled from: ObservableTimeoutTimed.java */
    static final class a implements g.a.u0.c {
        a() {
        }

        @Override // g.a.u0.c
        public void dispose() {
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return true;
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    static final class b<T> extends AtomicReference<g.a.u0.c> implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = -8387234228317808253L;
        final g.a.i0<? super T> actual;
        volatile boolean done;
        volatile long index;
        g.a.u0.c s;
        final long timeout;
        final TimeUnit unit;
        final j0.c worker;

        /* compiled from: ObservableTimeoutTimed.java */
        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final long f15472a;

            a(long j2) {
                this.f15472a = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f15472a == b.this.index) {
                    b bVar = b.this;
                    bVar.done = true;
                    bVar.s.dispose();
                    g.a.y0.a.d.dispose(b.this);
                    b.this.actual.onError(new TimeoutException());
                    b.this.worker.dispose();
                }
            }
        }

        b(g.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, j0.c cVar) {
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
            dispose();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            dispose();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            this.actual.onNext(t);
            scheduleTimeout(j2);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
                scheduleTimeout(0L);
            }
        }

        void scheduleTimeout(long j2) {
            g.a.u0.c cVar = get();
            if (cVar != null) {
                cVar.dispose();
            }
            if (compareAndSet(cVar, s3.f15467f)) {
                g.a.y0.a.d.replace(this, this.worker.a(new a(j2), this.timeout, this.unit));
            }
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    static final class c<T> extends AtomicReference<g.a.u0.c> implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = -4619702551964128179L;
        final g.a.i0<? super T> actual;
        final g.a.y0.a.j<T> arbiter;
        volatile boolean done;
        volatile long index;
        final g.a.g0<? extends T> other;
        g.a.u0.c s;
        final long timeout;
        final TimeUnit unit;
        final j0.c worker;

        /* compiled from: ObservableTimeoutTimed.java */
        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final long f15474a;

            a(long j2) {
                this.f15474a = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f15474a == c.this.index) {
                    c cVar = c.this;
                    cVar.done = true;
                    cVar.s.dispose();
                    g.a.y0.a.d.dispose(c.this);
                    c.this.subscribeNext();
                    c.this.worker.dispose();
                }
            }
        }

        c(g.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, j0.c cVar, g.a.g0<? extends T> g0Var) {
            this.actual = i0Var;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar;
            this.other = g0Var;
            this.arbiter = new g.a.y0.a.j<>(i0Var, this, 8);
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
            this.arbiter.a(this.s);
            this.worker.dispose();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.arbiter.a(th, this.s);
            this.worker.dispose();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            if (this.arbiter.a((g.a.y0.a.j<T>) t, this.s)) {
                scheduleTimeout(j2);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                if (this.arbiter.b(cVar)) {
                    this.actual.onSubscribe(this.arbiter);
                    scheduleTimeout(0L);
                }
            }
        }

        void scheduleTimeout(long j2) {
            g.a.u0.c cVar = get();
            if (cVar != null) {
                cVar.dispose();
            }
            if (compareAndSet(cVar, s3.f15467f)) {
                g.a.y0.a.d.replace(this, this.worker.a(new a(j2), this.timeout, this.unit));
            }
        }

        void subscribeNext() {
            this.other.subscribe(new g.a.y0.d.q(this.arbiter));
        }
    }

    public s3(g.a.g0<T> g0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var, g.a.g0<? extends T> g0Var2) {
        super(g0Var);
        this.f15468b = j2;
        this.f15469c = timeUnit;
        this.f15470d = j0Var;
        this.f15471e = g0Var2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        if (this.f15471e == null) {
            this.f14934a.subscribe(new b(new g.a.a1.m(i0Var), this.f15468b, this.f15469c, this.f15470d.a()));
        } else {
            this.f14934a.subscribe(new c(i0Var, this.f15468b, this.f15469c, this.f15470d.a(), this.f15471e));
        }
    }
}
