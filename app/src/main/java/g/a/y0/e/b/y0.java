package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlatMapCompletableCompletable.java */
/* loaded from: classes2.dex */
public final class y0<T> extends g.a.c implements g.a.y0.c.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14719a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.i> f14720b;

    /* renamed from: c, reason: collision with root package name */
    final int f14721c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f14722d;

    /* compiled from: FlowableFlatMapCompletableCompletable.java */
    static final class a<T> extends AtomicInteger implements g.a.q<T>, g.a.u0.c {
        private static final long serialVersionUID = 8443155186132538303L;
        final g.a.f actual;
        final boolean delayErrors;
        volatile boolean disposed;
        final g.a.x0.o<? super T, ? extends g.a.i> mapper;
        final int maxConcurrency;
        i.d.d s;
        final g.a.y0.j.c errors = new g.a.y0.j.c();
        final g.a.u0.b set = new g.a.u0.b();

        /* compiled from: FlowableFlatMapCompletableCompletable.java */
        /* renamed from: g.a.y0.e.b.y0$a$a, reason: collision with other inner class name */
        final class C0197a extends AtomicReference<g.a.u0.c> implements g.a.f, g.a.u0.c {
            private static final long serialVersionUID = 8606673141535671828L;

            C0197a() {
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

        a(g.a.f fVar, g.a.x0.o<? super T, ? extends g.a.i> oVar, boolean z, int i2) {
            this.actual = fVar;
            this.mapper = oVar;
            this.delayErrors = z;
            this.maxConcurrency = i2;
            lazySet(1);
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.disposed = true;
            this.s.cancel();
            this.set.dispose();
        }

        void innerComplete(a<T>.C0197a c0197a) {
            this.set.c(c0197a);
            onComplete();
        }

        void innerError(a<T>.C0197a c0197a, Throwable th) {
            this.set.c(c0197a);
            onError(th);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        @Override // i.d.c
        public void onComplete() {
            if (decrementAndGet() != 0) {
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.s.request(1L);
                }
            } else {
                Throwable thTerminate = this.errors.terminate();
                if (thTerminate != null) {
                    this.actual.onError(thTerminate);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.actual.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            if (decrementAndGet() == 0) {
                this.actual.onError(this.errors.terminate());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            try {
                g.a.i iVar = (g.a.i) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0197a c0197a = new C0197a();
                if (this.disposed || !this.set.b(c0197a)) {
                    return;
                }
                iVar.a(c0197a);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    dVar.request(h.q2.t.m0.f16408b);
                } else {
                    dVar.request(i2);
                }
            }
        }
    }

    public y0(g.a.l<T> lVar, g.a.x0.o<? super T, ? extends g.a.i> oVar, boolean z, int i2) {
        this.f14719a = lVar;
        this.f14720b = oVar;
        this.f14722d = z;
        this.f14721c = i2;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14719a.a((g.a.q) new a(fVar, this.f14720b, this.f14722d, this.f14721c));
    }

    @Override // g.a.y0.c.b
    public g.a.l<T> b() {
        return g.a.c1.a.a(new x0(this.f14719a, this.f14720b, this.f14722d, this.f14721c));
    }
}
