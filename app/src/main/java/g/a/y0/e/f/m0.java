package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleSubscribeOn.java */
/* loaded from: classes2.dex */
public final class m0<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<? extends T> f15806a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f15807b;

    /* compiled from: SingleSubscribeOn.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.n0<T>, g.a.u0.c, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final g.a.n0<? super T> actual;
        final g.a.q0<? extends T> source;
        final g.a.y0.a.k task = new g.a.y0.a.k();

        a(g.a.n0<? super T> n0Var, g.a.q0<? extends T> q0Var) {
            this.actual = n0Var;
            this.source = q0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
            this.task.dispose();
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
            g.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.a(this);
        }
    }

    public m0(g.a.q0<? extends T> q0Var, g.a.j0 j0Var) {
        this.f15806a = q0Var;
        this.f15807b = j0Var;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        a aVar = new a(n0Var, this.f15806a);
        n0Var.onSubscribe(aVar);
        aVar.task.replace(this.f15807b.a(aVar));
    }
}
