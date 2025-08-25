package g.a.y0.e.c;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: MaybeFlatMapIterableFlowable.java */
/* loaded from: classes2.dex */
public final class b0<T, R> extends g.a.l<R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.y<T> f14751b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends Iterable<? extends R>> f14752c;

    /* compiled from: MaybeFlatMapIterableFlowable.java */
    static final class a<T, R> extends g.a.y0.i.c<R> implements g.a.v<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        final i.d.c<? super R> actual;
        volatile boolean cancelled;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f14753d;
        volatile Iterator<? extends R> it;
        final g.a.x0.o<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        final AtomicLong requested = new AtomicLong();

        a(i.d.c<? super R> cVar, g.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.actual = cVar;
            this.mapper = oVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.cancelled = true;
            this.f14753d.dispose();
            this.f14753d = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.it = null;
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            i.d.c<? super R> cVar = this.actual;
            Iterator<? extends R> it = this.it;
            if (this.outputFused && it != null) {
                cVar.onNext(null);
                cVar.onComplete();
                return;
            }
            int iAddAndGet = 1;
            while (true) {
                if (it != null) {
                    long j2 = this.requested.get();
                    if (j2 == h.q2.t.m0.f16408b) {
                        fastPath(cVar, it);
                        return;
                    }
                    long j3 = 0;
                    while (j3 != j2) {
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            cVar.onNext((Object) g.a.y0.b.b.a(it.next(), "The iterator returned a null value"));
                            if (this.cancelled) {
                                return;
                            }
                            j3++;
                            try {
                                if (!it.hasNext()) {
                                    cVar.onComplete();
                                    return;
                                }
                            } catch (Throwable th) {
                                g.a.v0.b.b(th);
                                cVar.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            g.a.v0.b.b(th2);
                            cVar.onError(th2);
                            return;
                        }
                    }
                    if (j3 != 0) {
                        g.a.y0.j.d.c(this.requested, j3);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (it == null) {
                    it = this.it;
                }
            }
        }

        void fastPath(i.d.c<? super R> cVar, Iterator<? extends R> it) {
            while (!this.cancelled) {
                try {
                    cVar.onNext(it.next());
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            cVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        cVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    cVar.onError(th2);
                    return;
                }
            }
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.it == null;
        }

        @Override // g.a.v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14753d = g.a.y0.a.d.DISPOSED;
            this.actual.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14753d, cVar)) {
                this.f14753d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    this.actual.onComplete();
                } else {
                    this.it = it;
                    drain();
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.actual.onError(th);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.it;
            if (it == null) {
                return null;
            }
            R r = (R) g.a.y0.b.b.a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.it = null;
            }
            return r;
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public b0(g.a.y<T> yVar, g.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
        this.f14751b = yVar;
        this.f14752c = oVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super R> cVar) {
        this.f14751b.a(new a(cVar, this.f14752c));
    }
}
