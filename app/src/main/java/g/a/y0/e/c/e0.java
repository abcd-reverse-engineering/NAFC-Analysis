package g.a.y0.e.c;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeFlatMapSingle.java */
/* loaded from: classes2.dex */
public final class e0<T, R> extends g.a.k0<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<T> f14789a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> f14790b;

    /* compiled from: MaybeFlatMapSingle.java */
    static final class a<T, R> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c {
        private static final long serialVersionUID = 4827726964688405508L;
        final g.a.n0<? super R> actual;
        final g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> mapper;

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

        @Override // g.a.v
        public void onComplete() {
            this.actual.onError(new NoSuchElementException());
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            try {
                g.a.q0 q0Var = (g.a.q0) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null SingleSource");
                if (isDisposed()) {
                    return;
                }
                q0Var.a(new b(this, this.actual));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                onError(th);
            }
        }
    }

    /* compiled from: MaybeFlatMapSingle.java */
    static final class b<R> implements g.a.n0<R> {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReference<g.a.u0.c> f14791a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.n0<? super R> f14792b;

        b(AtomicReference<g.a.u0.c> atomicReference, g.a.n0<? super R> n0Var) {
            this.f14791a = atomicReference;
            this.f14792b = n0Var;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f14792b.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.replace(this.f14791a, cVar);
        }

        @Override // g.a.n0
        public void onSuccess(R r) {
            this.f14792b.onSuccess(r);
        }
    }

    public e0(g.a.y<T> yVar, g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> oVar) {
        this.f14789a = yVar;
        this.f14790b = oVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super R> n0Var) {
        this.f14789a.a(new a(n0Var, this.f14790b));
    }
}
