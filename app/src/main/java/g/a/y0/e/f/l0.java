package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleResumeNext.java */
/* loaded from: classes2.dex */
public final class l0<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<? extends T> f15799a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super Throwable, ? extends g.a.q0<? extends T>> f15800b;

    /* compiled from: SingleResumeNext.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.n0<T>, g.a.u0.c {
        private static final long serialVersionUID = -5314538511045349925L;
        final g.a.n0<? super T> actual;
        final g.a.x0.o<? super Throwable, ? extends g.a.q0<? extends T>> nextFunction;

        a(g.a.n0<? super T> n0Var, g.a.x0.o<? super Throwable, ? extends g.a.q0<? extends T>> oVar) {
            this.actual = n0Var;
            this.nextFunction = oVar;
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
            try {
                ((g.a.q0) g.a.y0.b.b.a(this.nextFunction.apply(th), "The nextFunction returned a null SingleSource.")).a(new g.a.y0.d.a0(this, this.actual));
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.actual.onError(new g.a.v0.a(th, th2));
            }
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public l0(g.a.q0<? extends T> q0Var, g.a.x0.o<? super Throwable, ? extends g.a.q0<? extends T>> oVar) {
        this.f15799a = q0Var;
        this.f15800b = oVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15799a.a(new a(n0Var, this.f15800b));
    }
}
