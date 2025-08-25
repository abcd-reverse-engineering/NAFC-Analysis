package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMap.java */
/* loaded from: classes2.dex */
public final class v<T, R> extends g.a.k0<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<? extends T> f15864a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> f15865b;

    /* compiled from: SingleFlatMap.java */
    static final class a<T, R> extends AtomicReference<g.a.u0.c> implements g.a.n0<T>, g.a.u0.c {
        private static final long serialVersionUID = 3258103020495908596L;
        final g.a.n0<? super R> actual;
        final g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> mapper;

        /* compiled from: SingleFlatMap.java */
        /* renamed from: g.a.y0.e.f.v$a$a, reason: collision with other inner class name */
        static final class C0228a<R> implements g.a.n0<R> {

            /* renamed from: a, reason: collision with root package name */
            final AtomicReference<g.a.u0.c> f15866a;

            /* renamed from: b, reason: collision with root package name */
            final g.a.n0<? super R> f15867b;

            C0228a(AtomicReference<g.a.u0.c> atomicReference, g.a.n0<? super R> n0Var) {
                this.f15866a = atomicReference;
                this.f15867b = n0Var;
            }

            @Override // g.a.n0
            public void onError(Throwable th) {
                this.f15867b.onError(th);
            }

            @Override // g.a.n0
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.replace(this.f15866a, cVar);
            }

            @Override // g.a.n0
            public void onSuccess(R r) {
                this.f15867b.onSuccess(r);
            }
        }

        a(g.a.n0<? super R> n0Var, g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> oVar) {
            this.actual = n0Var;
            this.mapper = oVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            try {
                g.a.q0 q0Var = (g.a.q0) g.a.y0.b.b.a(this.mapper.apply(t), "The single returned by the mapper is null");
                if (isDisposed()) {
                    return;
                }
                q0Var.a(new C0228a(this, this.actual));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.actual.onError(th);
            }
        }
    }

    public v(g.a.q0<? extends T> q0Var, g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> oVar) {
        this.f15865b = oVar;
        this.f15864a = q0Var;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super R> n0Var) {
        this.f15864a.a(new a(n0Var, this.f15865b));
    }
}
