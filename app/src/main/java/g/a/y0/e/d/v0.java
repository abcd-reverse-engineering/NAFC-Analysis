package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMapCompletable.java */
/* loaded from: classes2.dex */
public final class v0<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.i> f15522b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f15523c;

    /* compiled from: ObservableFlatMapCompletable.java */
    static final class a<T> extends g.a.y0.d.b<T> implements g.a.i0<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final g.a.i0<? super T> actual;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15524d;
        final boolean delayErrors;
        volatile boolean disposed;
        final g.a.x0.o<? super T, ? extends g.a.i> mapper;
        final g.a.y0.j.c errors = new g.a.y0.j.c();
        final g.a.u0.b set = new g.a.u0.b();

        /* compiled from: ObservableFlatMapCompletable.java */
        /* renamed from: g.a.y0.e.d.v0$a$a, reason: collision with other inner class name */
        final class C0216a extends AtomicReference<g.a.u0.c> implements g.a.f, g.a.u0.c {
            private static final long serialVersionUID = 8606673141535671828L;

            C0216a() {
            }

            @Override // g.a.u0.c
            public void dispose() {
                g.a.y0.a.d.dispose(this);
            }

            @Override // g.a.u0.c
            public boolean isDisposed() {
                return g.a.y0.a.d.isDisposed(get());
            }

            @Override // g.a.f
            public void onComplete() {
                a.this.innerComplete(this);
            }

            @Override // g.a.f
            public void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            @Override // g.a.f
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.setOnce(this, cVar);
            }
        }

        a(g.a.i0<? super T> i0Var, g.a.x0.o<? super T, ? extends g.a.i> oVar, boolean z) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // g.a.y0.c.o
        public void clear() {
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.disposed = true;
            this.f15524d.dispose();
            this.set.dispose();
        }

        void innerComplete(a<T>.C0216a c0216a) {
            this.set.c(c0216a);
            onComplete();
        }

        void innerError(a<T>.C0216a c0216a, Throwable th) {
            this.set.c(c0216a);
            onError(th);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15524d.isDisposed();
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return true;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable thTerminate = this.errors.terminate();
                if (thTerminate != null) {
                    this.actual.onError(thTerminate);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            if (this.delayErrors) {
                if (decrementAndGet() == 0) {
                    this.actual.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            dispose();
            if (getAndSet(0) > 0) {
                this.actual.onError(this.errors.terminate());
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            try {
                g.a.i iVar = (g.a.i) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0216a c0216a = new C0216a();
                if (this.disposed || !this.set.b(c0216a)) {
                    return;
                }
                iVar.a(c0216a);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15524d.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15524d, cVar)) {
                this.f15524d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            return null;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return i2 & 2;
        }
    }

    public v0(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends g.a.i> oVar, boolean z) {
        super(g0Var);
        this.f15522b = oVar;
        this.f15523c = z;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15522b, this.f15523c));
    }
}
