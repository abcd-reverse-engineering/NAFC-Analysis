package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMapCompletableCompletable.java */
/* loaded from: classes2.dex */
public final class w0<T> extends g.a.c implements g.a.y0.c.d<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15550a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.i> f15551b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f15552c;

    /* compiled from: ObservableFlatMapCompletableCompletable.java */
    static final class a<T> extends AtomicInteger implements g.a.u0.c, g.a.i0<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final g.a.f actual;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15553d;
        final boolean delayErrors;
        volatile boolean disposed;
        final g.a.x0.o<? super T, ? extends g.a.i> mapper;
        final g.a.y0.j.c errors = new g.a.y0.j.c();
        final g.a.u0.b set = new g.a.u0.b();

        /* compiled from: ObservableFlatMapCompletableCompletable.java */
        /* renamed from: g.a.y0.e.d.w0$a$a, reason: collision with other inner class name */
        final class C0218a extends AtomicReference<g.a.u0.c> implements g.a.f, g.a.u0.c {
            private static final long serialVersionUID = 8606673141535671828L;

            C0218a() {
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

        a(g.a.f fVar, g.a.x0.o<? super T, ? extends g.a.i> oVar, boolean z) {
            this.actual = fVar;
            this.mapper = oVar;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.disposed = true;
            this.f15553d.dispose();
            this.set.dispose();
        }

        void innerComplete(a<T>.C0218a c0218a) {
            this.set.c(c0218a);
            onComplete();
        }

        void innerError(a<T>.C0218a c0218a, Throwable th) {
            this.set.c(c0218a);
            onError(th);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15553d.isDisposed();
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
                C0218a c0218a = new C0218a();
                if (this.disposed || !this.set.b(c0218a)) {
                    return;
                }
                iVar.a(c0218a);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15553d.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15553d, cVar)) {
                this.f15553d = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public w0(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends g.a.i> oVar, boolean z) {
        this.f15550a = g0Var;
        this.f15551b = oVar;
        this.f15552c = z;
    }

    @Override // g.a.y0.c.d
    public g.a.b0<T> a() {
        return g.a.c1.a.a(new v0(this.f15550a, this.f15551b, this.f15552c));
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f15550a.subscribe(new a(fVar, this.f15551b, this.f15552c));
    }
}
