package g.a.y0.e.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableBufferBoundary.java */
/* loaded from: classes2.dex */
public final class n<T, U extends Collection<? super T>, Open, Close> extends g.a.y0.e.d.a<T, U> {

    /* renamed from: b, reason: collision with root package name */
    final Callable<U> f15330b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.g0<? extends Open> f15331c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.o<? super Open, ? extends g.a.g0<? extends Close>> f15332d;

    /* compiled from: ObservableBufferBoundary.java */
    static final class a<T, U extends Collection<? super T>, Open, Close> extends g.a.y0.d.w<T, U, U> implements g.a.u0.c {
        final g.a.g0<? extends Open> K;
        final g.a.x0.o<? super Open, ? extends g.a.g0<? extends Close>> L;
        final Callable<U> M;
        final g.a.u0.b N;
        g.a.u0.c O;
        final List<U> b0;
        final AtomicInteger c0;

        a(g.a.i0<? super U> i0Var, g.a.g0<? extends Open> g0Var, g.a.x0.o<? super Open, ? extends g.a.g0<? extends Close>> oVar, Callable<U> callable) {
            super(i0Var, new g.a.y0.f.a());
            this.c0 = new AtomicInteger();
            this.K = g0Var;
            this.L = oVar;
            this.M = callable;
            this.b0 = new LinkedList();
            this.N = new g.a.u0.b();
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
        }

        void f() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.b0);
                this.b0.clear();
            }
            g.a.y0.c.n<U> nVar = this.G;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                nVar.offer((Collection) it.next());
            }
            this.I = true;
            if (b()) {
                g.a.y0.j.v.a((g.a.y0.c.n) nVar, (g.a.i0) this.F, false, (g.a.u0.c) this, (g.a.y0.j.r) this);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.c0.decrementAndGet() == 0) {
                f();
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            dispose();
            this.H = true;
            synchronized (this) {
                this.b0.clear();
            }
            this.F.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.b0.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.O, cVar)) {
                this.O = cVar;
                c cVar2 = new c(this);
                this.N.b(cVar2);
                this.F.onSubscribe(this);
                this.c0.lazySet(1);
                this.K.subscribe(cVar2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(g.a.i0<? super U> i0Var, U u) {
            i0Var.onNext(u);
        }

        void a(Open open) {
            if (this.H) {
                return;
            }
            try {
                Collection collection = (Collection) g.a.y0.b.b.a(this.M.call(), "The buffer supplied is null");
                try {
                    g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.L.apply(open), "The buffer closing Observable is null");
                    if (this.H) {
                        return;
                    }
                    synchronized (this) {
                        if (this.H) {
                            return;
                        }
                        this.b0.add(collection);
                        b bVar = new b(collection, this);
                        this.N.b(bVar);
                        this.c0.getAndIncrement();
                        g0Var.subscribe(bVar);
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                onError(th2);
            }
        }

        void a(g.a.u0.c cVar) {
            if (this.N.a(cVar) && this.c0.decrementAndGet() == 0) {
                f();
            }
        }

        void a(U u, g.a.u0.c cVar) {
            boolean zRemove;
            synchronized (this) {
                zRemove = this.b0.remove(u);
            }
            if (zRemove) {
                b(u, false, this);
            }
            if (this.N.a(cVar) && this.c0.decrementAndGet() == 0) {
                f();
            }
        }
    }

    /* compiled from: ObservableBufferBoundary.java */
    static final class b<T, U extends Collection<? super T>, Open, Close> extends g.a.a1.e<Close> {

        /* renamed from: b, reason: collision with root package name */
        final a<T, U, Open, Close> f15333b;

        /* renamed from: c, reason: collision with root package name */
        final U f15334c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15335d;

        b(U u, a<T, U, Open, Close> aVar) {
            this.f15333b = aVar;
            this.f15334c = u;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15335d) {
                return;
            }
            this.f15335d = true;
            this.f15333b.a((a<T, U, Open, Close>) this.f15334c, (g.a.u0.c) this);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15335d) {
                g.a.c1.a.b(th);
            } else {
                this.f15333b.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(Close close) {
            onComplete();
        }
    }

    /* compiled from: ObservableBufferBoundary.java */
    static final class c<T, U extends Collection<? super T>, Open, Close> extends g.a.a1.e<Open> {

        /* renamed from: b, reason: collision with root package name */
        final a<T, U, Open, Close> f15336b;

        /* renamed from: c, reason: collision with root package name */
        boolean f15337c;

        c(a<T, U, Open, Close> aVar) {
            this.f15336b = aVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15337c) {
                return;
            }
            this.f15337c = true;
            this.f15336b.a((g.a.u0.c) this);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15337c) {
                g.a.c1.a.b(th);
            } else {
                this.f15337c = true;
                this.f15336b.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(Open open) {
            if (this.f15337c) {
                return;
            }
            this.f15336b.a((a<T, U, Open, Close>) open);
        }
    }

    public n(g.a.g0<T> g0Var, g.a.g0<? extends Open> g0Var2, g.a.x0.o<? super Open, ? extends g.a.g0<? extends Close>> oVar, Callable<U> callable) {
        super(g0Var);
        this.f15331c = g0Var2;
        this.f15332d = oVar;
        this.f15330b = callable;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super U> i0Var) {
        this.f14934a.subscribe(new a(new g.a.a1.m(i0Var), this.f15331c, this.f15332d, this.f15330b));
    }
}
