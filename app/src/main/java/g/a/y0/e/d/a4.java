package g.a.y0.e.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWindowBoundarySelector.java */
/* loaded from: classes2.dex */
public final class a4<T, B, V> extends g.a.y0.e.d.a<T, g.a.b0<T>> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.g0<B> f14950b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super B, ? extends g.a.g0<V>> f14951c;

    /* renamed from: d, reason: collision with root package name */
    final int f14952d;

    /* compiled from: ObservableWindowBoundarySelector.java */
    static final class a<T, V> extends g.a.a1.e<V> {

        /* renamed from: b, reason: collision with root package name */
        final c<T, ?, V> f14953b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.f1.j<T> f14954c;

        /* renamed from: d, reason: collision with root package name */
        boolean f14955d;

        a(c<T, ?, V> cVar, g.a.f1.j<T> jVar) {
            this.f14953b = cVar;
            this.f14954c = jVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f14955d) {
                return;
            }
            this.f14955d = true;
            this.f14953b.a((a) this);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f14955d) {
                g.a.c1.a.b(th);
            } else {
                this.f14955d = true;
                this.f14953b.a(th);
            }
        }

        @Override // g.a.i0
        public void onNext(V v) {
            if (this.f14955d) {
                return;
            }
            this.f14955d = true;
            dispose();
            this.f14953b.a((a) this);
        }
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    static final class b<T, B> extends g.a.a1.e<B> {

        /* renamed from: b, reason: collision with root package name */
        final c<T, B, ?> f14956b;

        b(c<T, B, ?> cVar) {
            this.f14956b = cVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f14956b.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f14956b.a(th);
        }

        @Override // g.a.i0
        public void onNext(B b2) {
            this.f14956b.a((c<T, B, ?>) b2);
        }
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    static final class d<T, B> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f1.j<T> f14957a;

        /* renamed from: b, reason: collision with root package name */
        final B f14958b;

        d(g.a.f1.j<T> jVar, B b2) {
            this.f14957a = jVar;
            this.f14958b = b2;
        }
    }

    public a4(g.a.g0<T> g0Var, g.a.g0<B> g0Var2, g.a.x0.o<? super B, ? extends g.a.g0<V>> oVar, int i2) {
        super(g0Var);
        this.f14950b = g0Var2;
        this.f14951c = oVar;
        this.f14952d = i2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super g.a.b0<T>> i0Var) {
        this.f14934a.subscribe(new c(new g.a.a1.m(i0Var), this.f14950b, this.f14951c, this.f14952d));
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    static final class c<T, B, V> extends g.a.y0.d.w<T, Object, g.a.b0<T>> implements g.a.u0.c {
        final g.a.g0<B> K;
        final g.a.x0.o<? super B, ? extends g.a.g0<V>> L;
        final int M;
        final g.a.u0.b N;
        g.a.u0.c O;
        final AtomicReference<g.a.u0.c> b0;
        final List<g.a.f1.j<T>> c0;
        final AtomicLong d0;

        c(g.a.i0<? super g.a.b0<T>> i0Var, g.a.g0<B> g0Var, g.a.x0.o<? super B, ? extends g.a.g0<V>> oVar, int i2) {
            super(i0Var, new g.a.y0.f.a());
            this.b0 = new AtomicReference<>();
            this.d0 = new AtomicLong();
            this.K = g0Var;
            this.L = oVar;
            this.M = i2;
            this.N = new g.a.u0.b();
            this.c0 = new ArrayList();
            this.d0.lazySet(1L);
        }

        @Override // g.a.y0.d.w, g.a.y0.j.r
        public void a(g.a.i0<? super g.a.b0<T>> i0Var, Object obj) {
        }

        void a(Throwable th) {
            this.O.dispose();
            this.N.dispose();
            onError(th);
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.H = true;
        }

        void f() {
            this.N.dispose();
            g.a.y0.a.d.dispose(this.b0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g() {
            g.a.y0.f.a aVar = (g.a.y0.f.a) this.G;
            g.a.i0<? super V> i0Var = this.F;
            List<g.a.f1.j<T>> list = this.c0;
            int iA = 1;
            while (true) {
                boolean z = this.I;
                Object objPoll = aVar.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    f();
                    Throwable th = this.J;
                    if (th != null) {
                        Iterator<g.a.f1.j<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<g.a.f1.j<T>> it2 = list.iterator();
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
                    g.a.f1.j<T> jVar = dVar.f14957a;
                    if (jVar != null) {
                        if (list.remove(jVar)) {
                            dVar.f14957a.onComplete();
                            if (this.d0.decrementAndGet() == 0) {
                                f();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.H) {
                        g.a.f1.j<T> jVarI = g.a.f1.j.i(this.M);
                        list.add(jVarI);
                        i0Var.onNext(jVarI);
                        try {
                            g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.L.apply(dVar.f14958b), "The ObservableSource supplied is null");
                            a aVar2 = new a(this, jVarI);
                            if (this.N.b(aVar2)) {
                                this.d0.getAndIncrement();
                                g0Var.subscribe(aVar2);
                            }
                        } catch (Throwable th2) {
                            g.a.v0.b.b(th2);
                            this.H = true;
                            i0Var.onError(th2);
                        }
                    }
                } else {
                    Iterator<g.a.f1.j<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(g.a.y0.j.q.getValue(objPoll));
                    }
                }
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
                g();
            }
            if (this.d0.decrementAndGet() == 0) {
                this.N.dispose();
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
                g();
            }
            if (this.d0.decrementAndGet() == 0) {
                this.N.dispose();
            }
            this.F.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (e()) {
                Iterator<g.a.f1.j<T>> it = this.c0.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.G.offer(g.a.y0.j.q.next(t));
                if (!b()) {
                    return;
                }
            }
            g();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.O, cVar)) {
                this.O = cVar;
                this.F.onSubscribe(this);
                if (this.H) {
                    return;
                }
                b bVar = new b(this);
                if (this.b0.compareAndSet(null, bVar)) {
                    this.d0.getAndIncrement();
                    this.K.subscribe(bVar);
                }
            }
        }

        void a(B b2) {
            this.G.offer(new d(null, b2));
            if (b()) {
                g();
            }
        }

        void a(a<T, V> aVar) {
            this.N.c(aVar);
            this.G.offer(new d(aVar.f14954c, null));
            if (b()) {
                g();
            }
        }
    }
}
