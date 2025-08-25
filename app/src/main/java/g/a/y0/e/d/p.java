package g.a.y0.e.d;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableBufferExactBoundary.java */
/* loaded from: classes2.dex */
public final class p<T, U extends Collection<? super T>, B> extends g.a.y0.e.d.a<T, U> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.g0<B> f15377b;

    /* renamed from: c, reason: collision with root package name */
    final Callable<U> f15378c;

    /* compiled from: ObservableBufferExactBoundary.java */
    static final class a<T, U extends Collection<? super T>, B> extends g.a.a1.e<B> {

        /* renamed from: b, reason: collision with root package name */
        final b<T, U, B> f15379b;

        a(b<T, U, B> bVar) {
            this.f15379b = bVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15379b.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15379b.onError(th);
        }

        @Override // g.a.i0
        public void onNext(B b2) {
            this.f15379b.f();
        }
    }

    /* compiled from: ObservableBufferExactBoundary.java */
    static final class b<T, U extends Collection<? super T>, B> extends g.a.y0.d.w<T, U, U> implements g.a.i0<T>, g.a.u0.c {
        final Callable<U> K;
        final g.a.g0<B> L;
        g.a.u0.c M;
        g.a.u0.c N;
        U O;

        b(g.a.i0<? super U> i0Var, Callable<U> callable, g.a.g0<B> g0Var) {
            super(i0Var, new g.a.y0.f.a());
            this.K = callable;
            this.L = g0Var;
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
            this.N.dispose();
            this.M.dispose();
            if (b()) {
                this.G.clear();
            }
        }

        void f() {
            try {
                U u = (U) g.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.O;
                    if (u2 == null) {
                        return;
                    }
                    this.O = u;
                    a(u2, false, this);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                dispose();
                this.F.onError(th);
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
                try {
                    this.O = (U) g.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.N = aVar;
                    this.F.onSubscribe(this);
                    if (this.H) {
                        return;
                    }
                    this.L.subscribe(aVar);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.H = true;
                    cVar.dispose();
                    g.a.y0.a.e.error(th, this.F);
                }
            }
        }

        public void a(g.a.i0<? super U> i0Var, U u) {
            this.F.onNext(u);
        }
    }

    public p(g.a.g0<T> g0Var, g.a.g0<B> g0Var2, Callable<U> callable) {
        super(g0Var);
        this.f15377b = g0Var2;
        this.f15378c = callable;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super U> i0Var) {
        this.f14934a.subscribe(new b(new g.a.a1.m(i0Var), this.f15378c, this.f15377b));
    }
}
