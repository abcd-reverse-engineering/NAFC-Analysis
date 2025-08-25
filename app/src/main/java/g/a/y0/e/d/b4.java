package g.a.y0.e.d;

import bean.module.ModuelConfig;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWindowBoundarySupplier.java */
/* loaded from: classes2.dex */
public final class b4<T, B> extends g.a.y0.e.d.a<T, g.a.b0<T>> {

    /* renamed from: b, reason: collision with root package name */
    final Callable<? extends g.a.g0<B>> f14985b;

    /* renamed from: c, reason: collision with root package name */
    final int f14986c;

    /* compiled from: ObservableWindowBoundarySupplier.java */
    static final class a<T, B> extends g.a.a1.e<B> {

        /* renamed from: b, reason: collision with root package name */
        final b<T, B> f14987b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14988c;

        a(b<T, B> bVar) {
            this.f14987b = bVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f14988c) {
                return;
            }
            this.f14988c = true;
            this.f14987b.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f14988c) {
                g.a.c1.a.b(th);
            } else {
                this.f14988c = true;
                this.f14987b.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(B b2) {
            if (this.f14988c) {
                return;
            }
            this.f14988c = true;
            dispose();
            this.f14987b.g();
        }
    }

    /* compiled from: ObservableWindowBoundarySupplier.java */
    static final class b<T, B> extends g.a.y0.d.w<T, Object, g.a.b0<T>> implements g.a.u0.c {
        static final Object c0 = new Object();
        final Callable<? extends g.a.g0<B>> K;
        final int L;
        g.a.u0.c M;
        final AtomicReference<g.a.u0.c> N;
        g.a.f1.j<T> O;
        final AtomicLong b0;

        b(g.a.i0<? super g.a.b0<T>> i0Var, Callable<? extends g.a.g0<B>> callable, int i2) {
            super(i0Var, new g.a.y0.f.a());
            this.N = new AtomicReference<>();
            this.b0 = new AtomicLong();
            this.K = callable;
            this.L = i2;
            this.b0.lazySet(1L);
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.H = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void f() {
            g.a.y0.f.a aVar = (g.a.y0.f.a) this.G;
            g.a.i0<? super V> i0Var = this.F;
            g.a.f1.j<T> jVar = this.O;
            int iA = 1;
            while (true) {
                boolean z = this.I;
                Object objPoll = aVar.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    g.a.y0.a.d.dispose(this.N);
                    Throwable th = this.J;
                    if (th != null) {
                        jVar.onError(th);
                        return;
                    } else {
                        jVar.onComplete();
                        return;
                    }
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (objPoll == c0) {
                    jVar.onComplete();
                    if (this.b0.decrementAndGet() == 0) {
                        g.a.y0.a.d.dispose(this.N);
                        return;
                    }
                    if (this.H) {
                        continue;
                    } else {
                        try {
                            g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.K.call(), "The ObservableSource supplied is null");
                            g.a.f1.j<T> jVarI = g.a.f1.j.i(this.L);
                            this.b0.getAndIncrement();
                            this.O = jVarI;
                            i0Var.onNext(jVarI);
                            a aVar2 = new a(this);
                            AtomicReference<g.a.u0.c> atomicReference = this.N;
                            if (atomicReference.compareAndSet(atomicReference.get(), aVar2)) {
                                g0Var.subscribe(aVar2);
                            }
                            jVar = jVarI;
                        } catch (Throwable th2) {
                            g.a.v0.b.b(th2);
                            g.a.y0.a.d.dispose(this.N);
                            i0Var.onError(th2);
                            return;
                        }
                    }
                } else {
                    jVar.onNext((ModuelConfig.AnonymousClass1) g.a.y0.j.q.getValue(objPoll));
                }
            }
        }

        void g() {
            this.G.offer(c0);
            if (b()) {
                f();
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.I) {
                return;
            }
            this.I = true;
            if (b()) {
                f();
            }
            if (this.b0.decrementAndGet() == 0) {
                g.a.y0.a.d.dispose(this.N);
            }
            this.F.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.I) {
                g.a.c1.a.b(th);
                return;
            }
            this.J = th;
            this.I = true;
            if (b()) {
                f();
            }
            if (this.b0.decrementAndGet() == 0) {
                g.a.y0.a.d.dispose(this.N);
            }
            this.F.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (e()) {
                this.O.onNext(t);
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.G.offer(g.a.y0.j.q.next(t));
                if (!b()) {
                    return;
                }
            }
            f();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.M, cVar)) {
                this.M = cVar;
                g.a.i0<? super V> i0Var = this.F;
                i0Var.onSubscribe(this);
                if (this.H) {
                    return;
                }
                try {
                    g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.K.call(), "The first window ObservableSource supplied is null");
                    g.a.f1.j<T> jVarI = g.a.f1.j.i(this.L);
                    this.O = jVarI;
                    i0Var.onNext(jVarI);
                    a aVar = new a(this);
                    if (this.N.compareAndSet(null, aVar)) {
                        this.b0.getAndIncrement();
                        g0Var.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    cVar.dispose();
                    i0Var.onError(th);
                }
            }
        }
    }

    public b4(g.a.g0<T> g0Var, Callable<? extends g.a.g0<B>> callable, int i2) {
        super(g0Var);
        this.f14985b = callable;
        this.f14986c = i2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super g.a.b0<T>> i0Var) {
        this.f14934a.subscribe(new b(new g.a.a1.m(i0Var), this.f14985b, this.f14986c));
    }
}
