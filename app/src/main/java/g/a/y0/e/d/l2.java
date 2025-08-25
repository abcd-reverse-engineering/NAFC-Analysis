package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableRepeatWhen.java */
/* loaded from: classes2.dex */
public final class l2<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super g.a.b0<Object>, ? extends g.a.g0<?>> f15249b;

    /* compiled from: ObservableRepeatWhen.java */
    static final class a<T> extends AtomicInteger implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final g.a.i0<? super T> actual;
        final g.a.f1.i<Object> signaller;
        final g.a.g0<T> source;
        final AtomicInteger wip = new AtomicInteger();
        final g.a.y0.j.c error = new g.a.y0.j.c();
        final a<T>.C0213a inner = new C0213a();

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference<g.a.u0.c> f15250d = new AtomicReference<>();

        /* compiled from: ObservableRepeatWhen.java */
        /* renamed from: g.a.y0.e.d.l2$a$a, reason: collision with other inner class name */
        final class C0213a extends AtomicReference<g.a.u0.c> implements g.a.i0<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            C0213a() {
            }

            @Override // g.a.i0
            public void onComplete() {
                a.this.innerComplete();
            }

            @Override // g.a.i0
            public void onError(Throwable th) {
                a.this.innerError(th);
            }

            @Override // g.a.i0
            public void onNext(Object obj) {
                a.this.innerNext();
            }

            @Override // g.a.i0
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.setOnce(this, cVar);
            }
        }

        a(g.a.i0<? super T> i0Var, g.a.f1.i<Object> iVar, g.a.g0<T> g0Var) {
            this.actual = i0Var;
            this.signaller = iVar;
            this.source = g0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this.f15250d);
            g.a.y0.a.d.dispose(this.inner);
        }

        void innerComplete() {
            g.a.y0.a.d.dispose(this.f15250d);
            g.a.y0.j.l.a(this.actual, this, this.error);
        }

        void innerError(Throwable th) {
            g.a.y0.a.d.dispose(this.f15250d);
            g.a.y0.j.l.a((g.a.i0<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void innerNext() {
            subscribeNext();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(this.f15250d.get());
        }

        @Override // g.a.i0
        public void onComplete() {
            this.active = false;
            this.signaller.onNext(0);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            g.a.y0.a.d.dispose(this.inner);
            g.a.y0.j.l.a((g.a.i0<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            g.a.y0.j.l.a(this.actual, t, this, this.error);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.replace(this.f15250d, cVar);
        }

        void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public l2(g.a.g0<T> g0Var, g.a.x0.o<? super g.a.b0<Object>, ? extends g.a.g0<?>> oVar) {
        super(g0Var);
        this.f15249b = oVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        g.a.f1.i<T> iVarS = g.a.f1.e.T().S();
        try {
            g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.f15249b.apply(iVarS), "The handler returned a null ObservableSource");
            a aVar = new a(i0Var, iVarS, this.f14934a);
            i0Var.onSubscribe(aVar);
            g0Var.subscribe(aVar.inner);
            aVar.subscribeNext();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, i0Var);
        }
    }
}
