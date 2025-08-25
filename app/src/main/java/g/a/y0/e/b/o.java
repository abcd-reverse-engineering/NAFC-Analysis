package g.a.y0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableBufferBoundarySupplier.java */
/* loaded from: classes2.dex */
public final class o<T, U extends Collection<? super T>, B> extends g.a.y0.e.b.a<T, U> {

    /* renamed from: c, reason: collision with root package name */
    final Callable<? extends i.d.b<B>> f14432c;

    /* renamed from: d, reason: collision with root package name */
    final Callable<U> f14433d;

    /* compiled from: FlowableBufferBoundarySupplier.java */
    static final class a<T, U extends Collection<? super T>, B> extends g.a.g1.b<B> {

        /* renamed from: b, reason: collision with root package name */
        final b<T, U, B> f14434b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14435c;

        a(b<T, U, B> bVar) {
            this.f14434b = bVar;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14435c) {
                return;
            }
            this.f14435c = true;
            this.f14434b.g();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14435c) {
                g.a.c1.a.b(th);
            } else {
                this.f14435c = true;
                this.f14434b.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(B b2) {
            if (this.f14435c) {
                return;
            }
            this.f14435c = true;
            a();
            this.f14434b.g();
        }
    }

    /* compiled from: FlowableBufferBoundarySupplier.java */
    static final class b<T, U extends Collection<? super T>, B> extends g.a.y0.h.m<T, U, U> implements g.a.q<T>, i.d.d, g.a.u0.c {
        final Callable<U> m0;
        final Callable<? extends i.d.b<B>> n0;
        i.d.d o0;
        final AtomicReference<g.a.u0.c> p0;
        U q0;

        b(i.d.c<? super U> cVar, Callable<U> callable, Callable<? extends i.d.b<B>> callable2) {
            super(cVar, new g.a.y0.f.a());
            this.p0 = new AtomicReference<>();
            this.m0 = callable;
            this.n0 = callable2;
        }

        @Override // g.a.y0.h.m, g.a.y0.j.u
        public /* bridge */ /* synthetic */ boolean a(i.d.c cVar, Object obj) {
            return a((i.d.c<? super i.d.c>) cVar, (i.d.c) obj);
        }

        @Override // i.d.d
        public void cancel() {
            if (this.j0) {
                return;
            }
            this.j0 = true;
            this.o0.cancel();
            f();
            if (b()) {
                this.i0.clear();
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.o0.cancel();
            f();
        }

        void f() {
            g.a.y0.a.d.dispose(this.p0);
        }

        void g() {
            try {
                U u = (U) g.a.y0.b.b.a(this.m0.call(), "The buffer supplied is null");
                try {
                    i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.n0.call(), "The boundary publisher supplied is null");
                    a aVar = new a(this);
                    if (this.p0.compareAndSet(this.p0.get(), aVar)) {
                        synchronized (this) {
                            U u2 = this.q0;
                            if (u2 == null) {
                                return;
                            }
                            this.q0 = u;
                            bVar.subscribe(aVar);
                            a(u2, false, this);
                        }
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.j0 = true;
                    this.o0.cancel();
                    this.h0.onError(th);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                cancel();
                this.h0.onError(th2);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.p0.get() == g.a.y0.a.d.DISPOSED;
        }

        @Override // i.d.c
        public void onComplete() {
            synchronized (this) {
                U u = this.q0;
                if (u == null) {
                    return;
                }
                this.q0 = null;
                this.i0.offer(u);
                this.k0 = true;
                if (b()) {
                    g.a.y0.j.v.a((g.a.y0.c.n) this.i0, (i.d.c) this.h0, false, (g.a.u0.c) this, (g.a.y0.j.u) this);
                }
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            cancel();
            this.h0.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.q0;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.o0, dVar)) {
                this.o0 = dVar;
                i.d.c<? super V> cVar = this.h0;
                try {
                    this.q0 = (U) g.a.y0.b.b.a(this.m0.call(), "The buffer supplied is null");
                    try {
                        i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.n0.call(), "The boundary publisher supplied is null");
                        a aVar = new a(this);
                        this.p0.set(aVar);
                        cVar.onSubscribe(this);
                        if (this.j0) {
                            return;
                        }
                        dVar.request(h.q2.t.m0.f16408b);
                        bVar.subscribe(aVar);
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        this.j0 = true;
                        dVar.cancel();
                        g.a.y0.i.g.error(th, cVar);
                    }
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    this.j0 = true;
                    dVar.cancel();
                    g.a.y0.i.g.error(th2, cVar);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            b(j2);
        }

        public boolean a(i.d.c<? super U> cVar, U u) {
            this.h0.onNext(u);
            return true;
        }
    }

    public o(g.a.l<T> lVar, Callable<? extends i.d.b<B>> callable, Callable<U> callable2) {
        super(lVar);
        this.f14432c = callable;
        this.f14433d = callable2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super U> cVar) {
        this.f14110b.a((g.a.q) new b(new g.a.g1.e(cVar), this.f14433d, this.f14432c));
    }
}
