package g.a.y0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableWindowBoundarySupplier.java */
/* loaded from: classes2.dex */
public final class o4<T, B> extends g.a.y0.e.b.a<T, g.a.l<T>> {

    /* renamed from: c, reason: collision with root package name */
    final Callable<? extends i.d.b<B>> f14458c;

    /* renamed from: d, reason: collision with root package name */
    final int f14459d;

    /* compiled from: FlowableWindowBoundarySupplier.java */
    static final class a<T, B> extends g.a.g1.b<B> {

        /* renamed from: b, reason: collision with root package name */
        final b<T, B> f14460b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14461c;

        a(b<T, B> bVar) {
            this.f14460b = bVar;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14461c) {
                return;
            }
            this.f14461c = true;
            this.f14460b.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14461c) {
                g.a.c1.a.b(th);
            } else {
                this.f14461c = true;
                this.f14460b.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(B b2) {
            if (this.f14461c) {
                return;
            }
            this.f14461c = true;
            a();
            this.f14460b.g();
        }
    }

    /* compiled from: FlowableWindowBoundarySupplier.java */
    static final class b<T, B> extends g.a.y0.h.m<T, Object, g.a.l<T>> implements i.d.d {
        static final Object s0 = new Object();
        final Callable<? extends i.d.b<B>> m0;
        final int n0;
        i.d.d o0;
        final AtomicReference<g.a.u0.c> p0;
        g.a.d1.g<T> q0;
        final AtomicLong r0;

        b(i.d.c<? super g.a.l<T>> cVar, Callable<? extends i.d.b<B>> callable, int i2) {
            super(cVar, new g.a.y0.f.a());
            this.p0 = new AtomicReference<>();
            this.r0 = new AtomicLong();
            this.m0 = callable;
            this.n0 = i2;
            this.r0.lazySet(1L);
        }

        @Override // i.d.d
        public void cancel() {
            this.j0 = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void f() {
            g.a.y0.c.o oVar = this.i0;
            i.d.c<? super V> cVar = this.h0;
            g.a.d1.g<T> gVar = this.q0;
            int iA = 1;
            while (true) {
                boolean z = this.k0;
                Object objPoll = oVar.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    g.a.y0.a.d.dispose(this.p0);
                    Throwable th = this.l0;
                    if (th != null) {
                        gVar.onError(th);
                        return;
                    } else {
                        gVar.onComplete();
                        return;
                    }
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (objPoll == s0) {
                    gVar.onComplete();
                    if (this.r0.decrementAndGet() == 0) {
                        g.a.y0.a.d.dispose(this.p0);
                        return;
                    }
                    if (this.j0) {
                        continue;
                    } else {
                        try {
                            i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.m0.call(), "The publisher supplied is null");
                            g.a.d1.g<T> gVarM = g.a.d1.g.m(this.n0);
                            long jRequested = requested();
                            if (jRequested != 0) {
                                this.r0.getAndIncrement();
                                cVar.onNext(gVarM);
                                if (jRequested != h.q2.t.m0.f16408b) {
                                    a(1L);
                                }
                                this.q0 = gVarM;
                                a aVar = new a(this);
                                AtomicReference<g.a.u0.c> atomicReference = this.p0;
                                if (atomicReference.compareAndSet(atomicReference.get(), aVar)) {
                                    bVar.subscribe(aVar);
                                }
                            } else {
                                this.j0 = true;
                                cVar.onError(new g.a.v0.c("Could not deliver new window due to lack of requests"));
                            }
                            gVar = gVarM;
                        } catch (Throwable th2) {
                            g.a.v0.b.b(th2);
                            g.a.y0.a.d.dispose(this.p0);
                            cVar.onError(th2);
                            return;
                        }
                    }
                } else {
                    gVar.onNext(g.a.y0.j.q.getValue(objPoll));
                }
            }
        }

        void g() {
            this.i0.offer(s0);
            if (b()) {
                f();
            }
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.k0) {
                return;
            }
            this.k0 = true;
            if (b()) {
                f();
            }
            if (this.r0.decrementAndGet() == 0) {
                g.a.y0.a.d.dispose(this.p0);
            }
            this.h0.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.k0) {
                g.a.c1.a.b(th);
                return;
            }
            this.l0 = th;
            this.k0 = true;
            if (b()) {
                f();
            }
            if (this.r0.decrementAndGet() == 0) {
                g.a.y0.a.d.dispose(this.p0);
            }
            this.h0.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.k0) {
                return;
            }
            if (e()) {
                this.q0.onNext(t);
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.i0.offer(g.a.y0.j.q.next(t));
                if (!b()) {
                    return;
                }
            }
            f();
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.o0, dVar)) {
                this.o0 = dVar;
                i.d.c<? super V> cVar = this.h0;
                cVar.onSubscribe(this);
                if (this.j0) {
                    return;
                }
                try {
                    i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.m0.call(), "The first window publisher supplied is null");
                    g.a.d1.g<T> gVarM = g.a.d1.g.m(this.n0);
                    long jRequested = requested();
                    if (jRequested == 0) {
                        dVar.cancel();
                        cVar.onError(new g.a.v0.c("Could not deliver first window due to lack of requests"));
                        return;
                    }
                    cVar.onNext(gVarM);
                    if (jRequested != h.q2.t.m0.f16408b) {
                        a(1L);
                    }
                    this.q0 = gVarM;
                    a aVar = new a(this);
                    if (this.p0.compareAndSet(null, aVar)) {
                        this.r0.getAndIncrement();
                        dVar.request(h.q2.t.m0.f16408b);
                        bVar.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    dVar.cancel();
                    cVar.onError(th);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            b(j2);
        }
    }

    public o4(g.a.l<T> lVar, Callable<? extends i.d.b<B>> callable, int i2) {
        super(lVar);
        this.f14458c = callable;
        this.f14459d = i2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super g.a.l<T>> cVar) {
        this.f14110b.a((g.a.q) new b(new g.a.g1.e(cVar), this.f14458c, this.f14459d));
    }
}
