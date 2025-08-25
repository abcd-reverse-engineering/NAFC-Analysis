package g.a.y0.e.d;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTimeout.java */
/* loaded from: classes2.dex */
public final class r3<T, U, V> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.g0<U> f15445b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.g0<V>> f15446c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.g0<? extends T> f15447d;

    /* compiled from: ObservableTimeout.java */
    interface a {
        void innerError(Throwable th);

        void timeout(long j2);
    }

    /* compiled from: ObservableTimeout.java */
    static final class b<T, U, V> extends g.a.a1.e<Object> {

        /* renamed from: b, reason: collision with root package name */
        final a f15448b;

        /* renamed from: c, reason: collision with root package name */
        final long f15449c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15450d;

        b(a aVar, long j2) {
            this.f15448b = aVar;
            this.f15449c = j2;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15450d) {
                return;
            }
            this.f15450d = true;
            this.f15448b.timeout(this.f15449c);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15450d) {
                g.a.c1.a.b(th);
            } else {
                this.f15450d = true;
                this.f15448b.innerError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(Object obj) {
            if (this.f15450d) {
                return;
            }
            this.f15450d = true;
            dispose();
            this.f15448b.timeout(this.f15449c);
        }
    }

    /* compiled from: ObservableTimeout.java */
    static final class c<T, U, V> extends AtomicReference<g.a.u0.c> implements g.a.i0<T>, g.a.u0.c, a {
        private static final long serialVersionUID = 2672739326310051084L;
        final g.a.i0<? super T> actual;
        final g.a.g0<U> firstTimeoutIndicator;
        volatile long index;
        final g.a.x0.o<? super T, ? extends g.a.g0<V>> itemTimeoutIndicator;
        g.a.u0.c s;

        c(g.a.i0<? super T> i0Var, g.a.g0<U> g0Var, g.a.x0.o<? super T, ? extends g.a.g0<V>> oVar) {
            this.actual = i0Var;
            this.firstTimeoutIndicator = g0Var;
            this.itemTimeoutIndicator = oVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (g.a.y0.a.d.dispose(this)) {
                this.s.dispose();
            }
        }

        @Override // g.a.y0.e.d.r3.a
        public void innerError(Throwable th) {
            this.s.dispose();
            this.actual.onError(th);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            g.a.y0.a.d.dispose(this);
            this.actual.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            g.a.y0.a.d.dispose(this);
            this.actual.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            long j2 = this.index + 1;
            this.index = j2;
            this.actual.onNext(t);
            g.a.u0.c cVar = (g.a.u0.c) get();
            if (cVar != null) {
                cVar.dispose();
            }
            try {
                g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.itemTimeoutIndicator.apply(t), "The ObservableSource returned is null");
                b bVar = new b(this, j2);
                if (compareAndSet(cVar, bVar)) {
                    g0Var.subscribe(bVar);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                dispose();
                this.actual.onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                g.a.i0<? super T> i0Var = this.actual;
                g.a.g0<U> g0Var = this.firstTimeoutIndicator;
                if (g0Var == null) {
                    i0Var.onSubscribe(this);
                    return;
                }
                b bVar = new b(this, 0L);
                if (compareAndSet(null, bVar)) {
                    i0Var.onSubscribe(this);
                    g0Var.subscribe(bVar);
                }
            }
        }

        @Override // g.a.y0.e.d.r3.a
        public void timeout(long j2) {
            if (j2 == this.index) {
                dispose();
                this.actual.onError(new TimeoutException());
            }
        }
    }

    /* compiled from: ObservableTimeout.java */
    static final class d<T, U, V> extends AtomicReference<g.a.u0.c> implements g.a.i0<T>, g.a.u0.c, a {
        private static final long serialVersionUID = -1957813281749686898L;
        final g.a.i0<? super T> actual;
        final g.a.y0.a.j<T> arbiter;
        boolean done;
        final g.a.g0<U> firstTimeoutIndicator;
        volatile long index;
        final g.a.x0.o<? super T, ? extends g.a.g0<V>> itemTimeoutIndicator;
        final g.a.g0<? extends T> other;
        g.a.u0.c s;

        d(g.a.i0<? super T> i0Var, g.a.g0<U> g0Var, g.a.x0.o<? super T, ? extends g.a.g0<V>> oVar, g.a.g0<? extends T> g0Var2) {
            this.actual = i0Var;
            this.firstTimeoutIndicator = g0Var;
            this.itemTimeoutIndicator = oVar;
            this.other = g0Var2;
            this.arbiter = new g.a.y0.a.j<>(i0Var, this, 8);
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (g.a.y0.a.d.dispose(this)) {
                this.s.dispose();
            }
        }

        @Override // g.a.y0.e.d.r3.a
        public void innerError(Throwable th) {
            this.s.dispose();
            this.actual.onError(th);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.a(this.s);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.a(th, this.s);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            if (this.arbiter.a((g.a.y0.a.j<T>) t, this.s)) {
                g.a.u0.c cVar = (g.a.u0.c) get();
                if (cVar != null) {
                    cVar.dispose();
                }
                try {
                    g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.itemTimeoutIndicator.apply(t), "The ObservableSource returned is null");
                    b bVar = new b(this, j2);
                    if (compareAndSet(cVar, bVar)) {
                        g0Var.subscribe(bVar);
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.actual.onError(th);
                }
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.arbiter.b(cVar);
                g.a.i0<? super T> i0Var = this.actual;
                g.a.g0<U> g0Var = this.firstTimeoutIndicator;
                if (g0Var == null) {
                    i0Var.onSubscribe(this.arbiter);
                    return;
                }
                b bVar = new b(this, 0L);
                if (compareAndSet(null, bVar)) {
                    i0Var.onSubscribe(this.arbiter);
                    g0Var.subscribe(bVar);
                }
            }
        }

        @Override // g.a.y0.e.d.r3.a
        public void timeout(long j2) {
            if (j2 == this.index) {
                dispose();
                this.other.subscribe(new g.a.y0.d.q(this.arbiter));
            }
        }
    }

    public r3(g.a.g0<T> g0Var, g.a.g0<U> g0Var2, g.a.x0.o<? super T, ? extends g.a.g0<V>> oVar, g.a.g0<? extends T> g0Var3) {
        super(g0Var);
        this.f15445b = g0Var2;
        this.f15446c = oVar;
        this.f15447d = g0Var3;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        g.a.g0<? extends T> g0Var = this.f15447d;
        if (g0Var == null) {
            this.f14934a.subscribe(new c(new g.a.a1.m(i0Var), this.f15445b, this.f15446c));
        } else {
            this.f14934a.subscribe(new d(i0Var, this.f15445b, this.f15446c, g0Var));
        }
    }
}
