package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableWindowBoundary.java */
/* loaded from: classes2.dex */
public final class m4<T, B> extends g.a.y0.e.b.a<T, g.a.l<T>> {

    /* renamed from: c, reason: collision with root package name */
    final i.d.b<B> f14404c;

    /* renamed from: d, reason: collision with root package name */
    final int f14405d;

    /* compiled from: FlowableWindowBoundary.java */
    static final class a<T, B> extends g.a.g1.b<B> {

        /* renamed from: b, reason: collision with root package name */
        final b<T, B> f14406b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14407c;

        a(b<T, B> bVar) {
            this.f14406b = bVar;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14407c) {
                return;
            }
            this.f14407c = true;
            this.f14406b.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14407c) {
                g.a.c1.a.b(th);
            } else {
                this.f14407c = true;
                this.f14406b.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(B b2) {
            if (this.f14407c) {
                return;
            }
            this.f14406b.g();
        }
    }

    /* compiled from: FlowableWindowBoundary.java */
    static final class b<T, B> extends g.a.y0.h.m<T, Object, g.a.l<T>> implements i.d.d {
        static final Object s0 = new Object();
        final i.d.b<B> m0;
        final int n0;
        i.d.d o0;
        final AtomicReference<g.a.u0.c> p0;
        g.a.d1.g<T> q0;
        final AtomicLong r0;

        b(i.d.c<? super g.a.l<T>> cVar, i.d.b<B> bVar, int i2) {
            super(cVar, new g.a.y0.f.a());
            this.p0 = new AtomicReference<>();
            this.r0 = new AtomicLong();
            this.m0 = bVar;
            this.n0 = i2;
            this.r0.lazySet(1L);
        }

        @Override // g.a.y0.h.m, g.a.y0.j.u
        public boolean a(i.d.c<? super g.a.l<T>> cVar, Object obj) {
            return false;
        }

        @Override // i.d.d
        public void cancel() {
            this.j0 = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [g.a.d1.g<T>] */
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
                    if (!this.j0) {
                        gVar = (g.a.d1.g<T>) g.a.d1.g.m(this.n0);
                        long jRequested = requested();
                        if (jRequested != 0) {
                            this.r0.getAndIncrement();
                            cVar.onNext(gVar);
                            if (jRequested != h.q2.t.m0.f16408b) {
                                a(1L);
                            }
                            this.q0 = gVar;
                        } else {
                            this.j0 = true;
                            cVar.onError(new g.a.v0.c("Could not deliver new window due to lack of requests"));
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
                g.a.d1.g<T> gVarM = g.a.d1.g.m(this.n0);
                long jRequested = requested();
                if (jRequested == 0) {
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
                    this.m0.subscribe(aVar);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            b(j2);
        }
    }

    public m4(g.a.l<T> lVar, i.d.b<B> bVar, int i2) {
        super(lVar);
        this.f14404c = bVar;
        this.f14405d = i2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super g.a.l<T>> cVar) {
        this.f14110b.a((g.a.q) new b(new g.a.g1.e(cVar), this.f14404c, this.f14405d));
    }
}
