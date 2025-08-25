package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservablePublishSelector.java */
/* loaded from: classes2.dex */
public final class c2<T, R> extends g.a.y0.e.d.a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super g.a.b0<T>, ? extends g.a.g0<R>> f15007b;

    /* compiled from: ObservablePublishSelector.java */
    static final class a<T, R> implements g.a.i0<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f1.e<T> f15008a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference<g.a.u0.c> f15009b;

        a(g.a.f1.e<T> eVar, AtomicReference<g.a.u0.c> atomicReference) {
            this.f15008a = eVar;
            this.f15009b = atomicReference;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15008a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15008a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15008a.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this.f15009b, cVar);
        }
    }

    /* compiled from: ObservablePublishSelector.java */
    static final class b<T, R> extends AtomicReference<g.a.u0.c> implements g.a.i0<R>, g.a.u0.c {
        private static final long serialVersionUID = 854110278590336484L;
        final g.a.i0<? super R> actual;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15010d;

        b(g.a.i0<? super R> i0Var) {
            this.actual = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15010d.dispose();
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15010d.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            g.a.y0.a.d.dispose(this);
            this.actual.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            g.a.y0.a.d.dispose(this);
            this.actual.onError(th);
        }

        @Override // g.a.i0
        public void onNext(R r) {
            this.actual.onNext(r);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15010d, cVar)) {
                this.f15010d = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public c2(g.a.g0<T> g0Var, g.a.x0.o<? super g.a.b0<T>, ? extends g.a.g0<R>> oVar) {
        super(g0Var);
        this.f15007b = oVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super R> i0Var) {
        g.a.f1.e eVarT = g.a.f1.e.T();
        try {
            g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.f15007b.apply(eVarT), "The selector returned a null ObservableSource");
            b bVar = new b(i0Var);
            g0Var.subscribe(bVar);
            this.f14934a.subscribe(new a(eVarT, bVar));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, i0Var);
        }
    }
}
