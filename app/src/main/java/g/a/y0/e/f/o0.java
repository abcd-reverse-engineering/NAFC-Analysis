package g.a.y0.e.f;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleTimeout.java */
/* loaded from: classes2.dex */
public final class o0<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15816a;

    /* renamed from: b, reason: collision with root package name */
    final long f15817b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f15818c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.j0 f15819d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.q0<? extends T> f15820e;

    /* compiled from: SingleTimeout.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.n0<T>, Runnable, g.a.u0.c {
        private static final long serialVersionUID = 37497744973048446L;
        final g.a.n0<? super T> actual;
        final C0227a<T> fallback;
        g.a.q0<? extends T> other;
        final AtomicReference<g.a.u0.c> task = new AtomicReference<>();

        /* compiled from: SingleTimeout.java */
        /* renamed from: g.a.y0.e.f.o0$a$a, reason: collision with other inner class name */
        static final class C0227a<T> extends AtomicReference<g.a.u0.c> implements g.a.n0<T> {
            private static final long serialVersionUID = 2071387740092105509L;
            final g.a.n0<? super T> actual;

            C0227a(g.a.n0<? super T> n0Var) {
                this.actual = n0Var;
            }

            @Override // g.a.n0
            public void onError(Throwable th) {
                this.actual.onError(th);
            }

            @Override // g.a.n0
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.setOnce(this, cVar);
            }

            @Override // g.a.n0
            public void onSuccess(T t) {
                this.actual.onSuccess(t);
            }
        }

        a(g.a.n0<? super T> n0Var, g.a.q0<? extends T> q0Var) {
            this.actual = n0Var;
            this.other = q0Var;
            if (q0Var != null) {
                this.fallback = new C0227a<>(n0Var);
            } else {
                this.fallback = null;
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
            g.a.y0.a.d.dispose(this.task);
            C0227a<T> c0227a = this.fallback;
            if (c0227a != null) {
                g.a.y0.a.d.dispose(c0227a);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            g.a.u0.c cVar = get();
            g.a.y0.a.d dVar = g.a.y0.a.d.DISPOSED;
            if (cVar == dVar || !compareAndSet(cVar, dVar)) {
                g.a.c1.a.b(th);
            } else {
                g.a.y0.a.d.dispose(this.task);
                this.actual.onError(th);
            }
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            g.a.u0.c cVar = get();
            g.a.y0.a.d dVar = g.a.y0.a.d.DISPOSED;
            if (cVar == dVar || !compareAndSet(cVar, dVar)) {
                return;
            }
            g.a.y0.a.d.dispose(this.task);
            this.actual.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            g.a.u0.c cVar = get();
            g.a.y0.a.d dVar = g.a.y0.a.d.DISPOSED;
            if (cVar == dVar || !compareAndSet(cVar, dVar)) {
                return;
            }
            if (cVar != null) {
                cVar.dispose();
            }
            g.a.q0<? extends T> q0Var = this.other;
            if (q0Var == null) {
                this.actual.onError(new TimeoutException());
            } else {
                this.other = null;
                q0Var.a(this.fallback);
            }
        }
    }

    public o0(g.a.q0<T> q0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var, g.a.q0<? extends T> q0Var2) {
        this.f15816a = q0Var;
        this.f15817b = j2;
        this.f15818c = timeUnit;
        this.f15819d = j0Var;
        this.f15820e = q0Var2;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        a aVar = new a(n0Var, this.f15820e);
        n0Var.onSubscribe(aVar);
        g.a.y0.a.d.replace(aVar.task, this.f15819d.a(aVar, this.f15817b, this.f15818c));
        this.f15816a.a(aVar);
    }
}
