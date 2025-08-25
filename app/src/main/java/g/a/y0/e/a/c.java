package g.a.y0.e.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableConcat.java */
/* loaded from: classes2.dex */
public final class c extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final i.d.b<? extends g.a.i> f13999a;

    /* renamed from: b, reason: collision with root package name */
    final int f14000b;

    /* compiled from: CompletableConcat.java */
    static final class a extends AtomicInteger implements g.a.q<g.a.i>, g.a.u0.c {
        private static final long serialVersionUID = 9032184911934499404L;
        volatile boolean active;
        final g.a.f actual;
        int consumed;
        volatile boolean done;
        final int limit;
        final int prefetch;
        g.a.y0.c.o<g.a.i> queue;
        i.d.d s;
        int sourceFused;
        final C0182a inner = new C0182a(this);
        final AtomicBoolean once = new AtomicBoolean();

        /* compiled from: CompletableConcat.java */
        /* renamed from: g.a.y0.e.a.c$a$a, reason: collision with other inner class name */
        static final class C0182a extends AtomicReference<g.a.u0.c> implements g.a.f {
            private static final long serialVersionUID = -5454794857847146511L;
            final a parent;

            C0182a(a aVar) {
                this.parent = aVar;
            }

            @Override // g.a.f
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // g.a.f
            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            @Override // g.a.f
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.replace(this, cVar);
            }
        }

        a(g.a.f fVar, int i2) {
            this.actual = fVar;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.s.cancel();
            g.a.y0.a.d.dispose(this.inner);
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!isDisposed()) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        g.a.i iVarPoll = this.queue.poll();
                        boolean z2 = iVarPoll == null;
                        if (z && z2) {
                            if (this.once.compareAndSet(false, true)) {
                                this.actual.onComplete();
                                return;
                            }
                            return;
                        } else if (!z2) {
                            this.active = true;
                            iVarPoll.a(this.inner);
                            request();
                        }
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        innerError(th);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        void innerError(Throwable th) {
            if (!this.once.compareAndSet(false, true)) {
                g.a.c1.a.b(th);
            } else {
                this.s.cancel();
                this.actual.onError(th);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(this.inner.get());
        }

        @Override // i.d.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (!this.once.compareAndSet(false, true)) {
                g.a.c1.a.b(th);
            } else {
                g.a.y0.a.d.dispose(this.inner);
                this.actual.onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                int i2 = this.prefetch;
                long j2 = i2 == Integer.MAX_VALUE ? h.q2.t.m0.f16408b : i2;
                if (dVar instanceof g.a.y0.c.l) {
                    g.a.y0.c.l lVar = (g.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.sourceFused = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceFused = iRequestFusion;
                        this.queue = lVar;
                        this.actual.onSubscribe(this);
                        dVar.request(j2);
                        return;
                    }
                }
                int i3 = this.prefetch;
                if (i3 == Integer.MAX_VALUE) {
                    this.queue = new g.a.y0.f.c(g.a.l.Q());
                } else {
                    this.queue = new g.a.y0.f.b(i3);
                }
                this.actual.onSubscribe(this);
                dVar.request(j2);
            }
        }

        void request() {
            if (this.sourceFused != 1) {
                int i2 = this.consumed + 1;
                if (i2 != this.limit) {
                    this.consumed = i2;
                } else {
                    this.consumed = 0;
                    this.s.request(i2);
                }
            }
        }

        @Override // i.d.c
        public void onNext(g.a.i iVar) {
            if (this.sourceFused != 0 || this.queue.offer(iVar)) {
                drain();
            } else {
                onError(new g.a.v0.c());
            }
        }
    }

    public c(i.d.b<? extends g.a.i> bVar, int i2) {
        this.f13999a = bVar;
        this.f14000b = i2;
    }

    @Override // g.a.c
    public void b(g.a.f fVar) {
        this.f13999a.subscribe(new a(fVar, this.f14000b));
    }
}
