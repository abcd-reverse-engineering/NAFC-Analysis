package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDelayWithObservable.java */
/* loaded from: classes2.dex */
public final class h<T, U> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15773a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.g0<U> f15774b;

    /* compiled from: SingleDelayWithObservable.java */
    static final class a<T, U> extends AtomicReference<g.a.u0.c> implements g.a.i0<U>, g.a.u0.c {
        private static final long serialVersionUID = -8565274649390031272L;
        final g.a.n0<? super T> actual;
        boolean done;
        final g.a.q0<T> source;

        a(g.a.n0<? super T> n0Var, g.a.q0<T> q0Var) {
            this.actual = n0Var;
            this.source = q0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.source.a(new g.a.y0.d.a0(this, this.actual));
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(U u) {
            get().dispose();
            onComplete();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.set(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }
    }

    public h(g.a.q0<T> q0Var, g.a.g0<U> g0Var) {
        this.f15773a = q0Var;
        this.f15774b = g0Var;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15774b.subscribe(new a(n0Var, this.f15773a));
    }
}
