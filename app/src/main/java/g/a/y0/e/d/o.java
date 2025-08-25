package g.a.y0.e.d;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableBufferBoundarySupplier.java */
/* loaded from: classes2.dex */
public final class o<T, U extends Collection<? super T>, B> extends g.a.y0.e.d.a<T, U> {

    /* renamed from: b, reason: collision with root package name */
    final Callable<? extends g.a.g0<B>> f15350b;

    /* renamed from: c, reason: collision with root package name */
    final Callable<U> f15351c;

    /* compiled from: ObservableBufferBoundarySupplier.java */
    static final class a<T, U extends Collection<? super T>, B> extends g.a.a1.e<B> {

        /* renamed from: b, reason: collision with root package name */
        final b<T, U, B> f15352b;

        /* renamed from: c, reason: collision with root package name */
        boolean f15353c;

        a(b<T, U, B> bVar) {
            this.f15352b = bVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15353c) {
                return;
            }
            this.f15353c = true;
            this.f15352b.g();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15353c) {
                g.a.c1.a.b(th);
            } else {
                this.f15353c = true;
                this.f15352b.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(B b2) {
            if (this.f15353c) {
                return;
            }
            this.f15353c = true;
            dispose();
            this.f15352b.g();
        }
    }

    /* compiled from: ObservableBufferBoundarySupplier.java */
    static final class b<T, U extends Collection<? super T>, B> extends g.a.y0.d.w<T, U, U> implements g.a.i0<T>, g.a.u0.c {
        final Callable<U> K;
        final Callable<? extends g.a.g0<B>> L;
        g.a.u0.c M;
        final AtomicReference<g.a.u0.c> N;
        U O;

        b(g.a.i0<? super U> i0Var, Callable<U> callable, Callable<? extends g.a.g0<B>> callable2) {
            super(i0Var, new g.a.y0.f.a());
            this.N = new AtomicReference<>();
            this.K = callable;
            this.L = callable2;
        }

        @Override // g.a.y0.d.w, g.a.y0.j.r
        public /* bridge */ /* synthetic */ void a(g.a.i0 i0Var, Object obj) {
            a((g.a.i0<? super g.a.i0>) i0Var, (g.a.i0) obj);
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.H) {
                return;
            }
            this.H = true;
            this.M.dispose();
            f();
            if (b()) {
                this.G.clear();
            }
        }

        void f() {
            g.a.y0.a.d.dispose(this.N);
        }

        void g() {
            try {
                U u = (U) g.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                try {
                    g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.L.call(), "The boundary ObservableSource supplied is null");
                    a aVar = new a(this);
                    if (this.N.compareAndSet(this.N.get(), aVar)) {
                        synchronized (this) {
                            U u2 = this.O;
                            if (u2 == null) {
                                return;
                            }
                            this.O = u;
                            g0Var.subscribe(aVar);
                            a(u2, false, this);
                        }
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.H = true;
                    this.M.dispose();
                    this.F.onError(th);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                dispose();
                this.F.onError(th2);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // g.a.i0
        public void onComplete() {
            synchronized (this) {
                U u = this.O;
                if (u == null) {
                    return;
                }
                this.O = null;
                this.G.offer(u);
                this.I = true;
                if (b()) {
                    g.a.y0.j.v.a((g.a.y0.c.n) this.G, (g.a.i0) this.F, false, (g.a.u0.c) this, (g.a.y0.j.r) this);
                }
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            dispose();
            this.F.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            synchronized (this) {
                U u = this.O;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.M, cVar)) {
                this.M = cVar;
                g.a.i0<? super V> i0Var = this.F;
                try {
                    this.O = (U) g.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                    try {
                        g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.L.call(), "The boundary ObservableSource supplied is null");
                        a aVar = new a(this);
                        this.N.set(aVar);
                        i0Var.onSubscribe(this);
                        if (this.H) {
                            return;
                        }
                        g0Var.subscribe(aVar);
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        this.H = true;
                        cVar.dispose();
                        g.a.y0.a.e.error(th, i0Var);
                    }
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    this.H = true;
                    cVar.dispose();
                    g.a.y0.a.e.error(th2, i0Var);
                }
            }
        }

        public void a(g.a.i0<? super U> i0Var, U u) {
            this.F.onNext(u);
        }
    }

    public o(g.a.g0<T> g0Var, Callable<? extends g.a.g0<B>> callable, Callable<U> callable2) {
        super(g0Var);
        this.f15350b = callable;
        this.f15351c = callable2;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super U> i0Var) {
        this.f14934a.subscribe(new b(new g.a.a1.m(i0Var), this.f15351c, this.f15350b));
    }
}
