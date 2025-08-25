package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlatMapCompletable.java */
/* loaded from: classes2.dex */
public final class x0<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.i> f14686c;

    /* renamed from: d, reason: collision with root package name */
    final int f14687d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f14688e;

    /* compiled from: FlowableFlatMapCompletable.java */
    static final class a<T> extends g.a.y0.i.c<T> implements g.a.q<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final i.d.c<? super T> actual;
        volatile boolean cancelled;
        final boolean delayErrors;
        final g.a.x0.o<? super T, ? extends g.a.i> mapper;
        final int maxConcurrency;
        i.d.d s;
        final g.a.y0.j.c errors = new g.a.y0.j.c();
        final g.a.u0.b set = new g.a.u0.b();

        /* compiled from: FlowableFlatMapCompletable.java */
        /* renamed from: g.a.y0.e.b.x0$a$a, reason: collision with other inner class name */
        final class C0196a extends AtomicReference<g.a.u0.c> implements g.a.f, g.a.u0.c {
            private static final long serialVersionUID = 8606673141535671828L;

            C0196a() {
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

        a(i.d.c<? super T> cVar, g.a.x0.o<? super T, ? extends g.a.i> oVar, boolean z, int i2) {
            this.actual = cVar;
            this.mapper = oVar;
            this.delayErrors = z;
            this.maxConcurrency = i2;
            lazySet(1);
        }

        @Override // i.d.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            this.set.dispose();
        }

        @Override // g.a.y0.c.o
        public void clear() {
        }

        void innerComplete(a<T>.C0196a c0196a) {
            this.set.c(c0196a);
            onComplete();
        }

        void innerError(a<T>.C0196a c0196a, Throwable th) {
            this.set.c(c0196a);
            onError(th);
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return true;
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
                cancel();
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
                C0196a c0196a = new C0196a();
                if (this.cancelled || !this.set.b(c0196a)) {
                    return;
                }
                iVar.a(c0196a);
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

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            return null;
        }

        @Override // i.d.d
        public void request(long j2) {
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return i2 & 2;
        }
    }

    public x0(g.a.l<T> lVar, g.a.x0.o<? super T, ? extends g.a.i> oVar, boolean z, int i2) {
        super(lVar);
        this.f14686c = oVar;
        this.f14688e = z;
        this.f14687d = i2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14686c, this.f14688e, this.f14687d));
    }
}
