package g.a.y0.e.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableWindowBoundarySelector.java */
/* loaded from: classes2.dex */
public final class n4<T, B, V> extends g.a.y0.e.b.a<T, g.a.l<T>> {

    /* renamed from: c, reason: collision with root package name */
    final i.d.b<B> f14422c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.o<? super B, ? extends i.d.b<V>> f14423d;

    /* renamed from: e, reason: collision with root package name */
    final int f14424e;

    /* compiled from: FlowableWindowBoundarySelector.java */
    static final class a<T, V> extends g.a.g1.b<V> {

        /* renamed from: b, reason: collision with root package name */
        final c<T, ?, V> f14425b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.d1.g<T> f14426c;

        /* renamed from: d, reason: collision with root package name */
        boolean f14427d;

        a(c<T, ?, V> cVar, g.a.d1.g<T> gVar) {
            this.f14425b = cVar;
            this.f14426c = gVar;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14427d) {
                return;
            }
            this.f14427d = true;
            this.f14425b.a((a) this);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14427d) {
                g.a.c1.a.b(th);
            } else {
                this.f14427d = true;
                this.f14425b.a(th);
            }
        }

        @Override // i.d.c
        public void onNext(V v) {
            if (this.f14427d) {
                return;
            }
            this.f14427d = true;
            a();
            this.f14425b.a((a) this);
        }
    }

    /* compiled from: FlowableWindowBoundarySelector.java */
    static final class b<T, B> extends g.a.g1.b<B> {

        /* renamed from: b, reason: collision with root package name */
        final c<T, B, ?> f14428b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14429c;

        b(c<T, B, ?> cVar) {
            this.f14428b = cVar;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14429c) {
                return;
            }
            this.f14429c = true;
            this.f14428b.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14429c) {
                g.a.c1.a.b(th);
            } else {
                this.f14429c = true;
                this.f14428b.a(th);
            }
        }

        @Override // i.d.c
        public void onNext(B b2) {
            if (this.f14429c) {
                return;
            }
            this.f14428b.a((c<T, B, ?>) b2);
        }
    }

    /* compiled from: FlowableWindowBoundarySelector.java */
    static final class d<T, B> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.d1.g<T> f14430a;

        /* renamed from: b, reason: collision with root package name */
        final B f14431b;

        d(g.a.d1.g<T> gVar, B b2) {
            this.f14430a = gVar;
            this.f14431b = b2;
        }
    }

    public n4(g.a.l<T> lVar, i.d.b<B> bVar, g.a.x0.o<? super B, ? extends i.d.b<V>> oVar, int i2) {
        super(lVar);
        this.f14422c = bVar;
        this.f14423d = oVar;
        this.f14424e = i2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super g.a.l<T>> cVar) {
        this.f14110b.a((g.a.q) new c(new g.a.g1.e(cVar), this.f14422c, this.f14423d, this.f14424e));
    }

    /* compiled from: FlowableWindowBoundarySelector.java */
    static final class c<T, B, V> extends g.a.y0.h.m<T, Object, g.a.l<T>> implements i.d.d {
        final i.d.b<B> m0;
        final g.a.x0.o<? super B, ? extends i.d.b<V>> n0;
        final int o0;
        final g.a.u0.b p0;
        i.d.d q0;
        final AtomicReference<g.a.u0.c> r0;
        final List<g.a.d1.g<T>> s0;
        final AtomicLong t0;

        c(i.d.c<? super g.a.l<T>> cVar, i.d.b<B> bVar, g.a.x0.o<? super B, ? extends i.d.b<V>> oVar, int i2) {
            super(cVar, new g.a.y0.f.a());
            this.r0 = new AtomicReference<>();
            this.t0 = new AtomicLong();
            this.m0 = bVar;
            this.n0 = oVar;
            this.o0 = i2;
            this.p0 = new g.a.u0.b();
            this.s0 = new ArrayList();
            this.t0.lazySet(1L);
        }

        void a(Throwable th) {
            this.q0.cancel();
            this.p0.dispose();
            g.a.y0.a.d.dispose(this.r0);
            this.h0.onError(th);
        }

        @Override // g.a.y0.h.m, g.a.y0.j.u
        public boolean a(i.d.c<? super g.a.l<T>> cVar, Object obj) {
            return false;
        }

        @Override // i.d.d
        public void cancel() {
            this.j0 = true;
        }

        void dispose() {
            this.p0.dispose();
            g.a.y0.a.d.dispose(this.r0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void f() {
            g.a.y0.c.o oVar = this.i0;
            i.d.c<? super V> cVar = this.h0;
            List<g.a.d1.g<T>> list = this.s0;
            int iA = 1;
            while (true) {
                boolean z = this.k0;
                Object objPoll = oVar.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    dispose();
                    Throwable th = this.l0;
                    if (th != null) {
                        Iterator<g.a.d1.g<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<g.a.d1.g<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (objPoll instanceof d) {
                    d dVar = (d) objPoll;
                    g.a.d1.g<T> gVar = dVar.f14430a;
                    if (gVar != null) {
                        if (list.remove(gVar)) {
                            dVar.f14430a.onComplete();
                            if (this.t0.decrementAndGet() == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.j0) {
                        g.a.d1.g<T> gVarM = g.a.d1.g.m(this.o0);
                        long jRequested = requested();
                        if (jRequested != 0) {
                            list.add(gVarM);
                            cVar.onNext(gVarM);
                            if (jRequested != h.q2.t.m0.f16408b) {
                                a(1L);
                            }
                            try {
                                i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.n0.apply(dVar.f14431b), "The publisher supplied is null");
                                a aVar = new a(this, gVarM);
                                if (this.p0.b(aVar)) {
                                    this.t0.getAndIncrement();
                                    bVar.subscribe(aVar);
                                }
                            } catch (Throwable th2) {
                                this.j0 = true;
                                cVar.onError(th2);
                            }
                        } else {
                            this.j0 = true;
                            cVar.onError(new g.a.v0.c("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<g.a.d1.g<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(g.a.y0.j.q.getValue(objPoll));
                    }
                }
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
            if (this.t0.decrementAndGet() == 0) {
                this.p0.dispose();
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
            if (this.t0.decrementAndGet() == 0) {
                this.p0.dispose();
            }
            this.h0.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.k0) {
                return;
            }
            if (e()) {
                Iterator<g.a.d1.g<T>> it = this.s0.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
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
            if (g.a.y0.i.j.validate(this.q0, dVar)) {
                this.q0 = dVar;
                this.h0.onSubscribe(this);
                if (this.j0) {
                    return;
                }
                b bVar = new b(this);
                if (this.r0.compareAndSet(null, bVar)) {
                    this.t0.getAndIncrement();
                    dVar.request(h.q2.t.m0.f16408b);
                    this.m0.subscribe(bVar);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            b(j2);
        }

        void a(B b2) {
            this.i0.offer(new d(null, b2));
            if (b()) {
                f();
            }
        }

        void a(a<T, V> aVar) {
            this.p0.c(aVar);
            this.i0.offer(new d(aVar.f14426c, null));
            if (b()) {
                f();
            }
        }
    }
}
