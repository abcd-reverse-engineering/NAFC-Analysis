package g.a.y0.e.a;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableMerge.java */
/* loaded from: classes2.dex */
public final class y extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final i.d.b<? extends g.a.i> f14106a;

    /* renamed from: b, reason: collision with root package name */
    final int f14107b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f14108c;

    /* compiled from: CompletableMerge.java */
    static final class a extends AtomicInteger implements g.a.q<g.a.i>, g.a.u0.c {
        private static final long serialVersionUID = -2108443387387077490L;
        final g.a.f actual;
        final boolean delayErrors;
        final int maxConcurrency;
        i.d.d s;
        final g.a.u0.b set = new g.a.u0.b();
        final g.a.y0.j.c error = new g.a.y0.j.c();

        /* compiled from: CompletableMerge.java */
        /* renamed from: g.a.y0.e.a.y$a$a, reason: collision with other inner class name */
        final class C0186a extends AtomicReference<g.a.u0.c> implements g.a.f, g.a.u0.c {
            private static final long serialVersionUID = 251330541679988317L;

            C0186a() {
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

        a(g.a.f fVar, int i2, boolean z) {
            this.actual = fVar;
            this.maxConcurrency = i2;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.s.cancel();
            this.set.dispose();
        }

        void innerComplete(C0186a c0186a) {
            this.set.c(c0186a);
            if (decrementAndGet() != 0) {
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.s.request(1L);
                }
            } else {
                Throwable th = this.error.get();
                if (th != null) {
                    this.actual.onError(th);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        void innerError(C0186a c0186a, Throwable th) {
            this.set.c(c0186a);
            if (!this.delayErrors) {
                this.s.cancel();
                this.set.dispose();
                if (!this.error.addThrowable(th)) {
                    g.a.c1.a.b(th);
                    return;
                } else {
                    if (getAndSet(0) > 0) {
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    return;
                }
            }
            if (!this.error.addThrowable(th)) {
                g.a.c1.a.b(th);
            } else if (decrementAndGet() == 0) {
                this.actual.onError(this.error.terminate());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        @Override // i.d.c
        public void onComplete() {
            if (decrementAndGet() == 0) {
                if (this.error.get() != null) {
                    this.actual.onError(this.error.terminate());
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.delayErrors) {
                if (!this.error.addThrowable(th)) {
                    g.a.c1.a.b(th);
                    return;
                } else {
                    if (decrementAndGet() == 0) {
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    return;
                }
            }
            this.set.dispose();
            if (!this.error.addThrowable(th)) {
                g.a.c1.a.b(th);
            } else if (getAndSet(0) > 0) {
                this.actual.onError(this.error.terminate());
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

        @Override // i.d.c
        public void onNext(g.a.i iVar) {
            getAndIncrement();
            C0186a c0186a = new C0186a();
            this.set.b(c0186a);
            iVar.a(c0186a);
        }
    }

    public y(i.d.b<? extends g.a.i> bVar, int i2, boolean z) {
        this.f14106a = bVar;
        this.f14107b = i2;
        this.f14108c = z;
    }

    @Override // g.a.c
    public void b(g.a.f fVar) {
        this.f14106a.subscribe(new a(fVar, this.f14107b, this.f14108c));
    }
}
