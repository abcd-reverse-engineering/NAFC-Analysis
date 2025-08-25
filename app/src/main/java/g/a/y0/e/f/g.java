package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDelayWithCompletable.java */
/* loaded from: classes2.dex */
public final class g<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15769a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.i f15770b;

    /* compiled from: SingleDelayWithCompletable.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.f, g.a.u0.c {
        private static final long serialVersionUID = -8565274649390031272L;
        final g.a.n0<? super T> actual;
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

        @Override // g.a.f
        public void onComplete() {
            this.source.a(new g.a.y0.d.a0(this, this.actual));
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }
    }

    public g(g.a.q0<T> q0Var, g.a.i iVar) {
        this.f15769a = q0Var;
        this.f15770b = iVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15770b.a(new a(n0Var, this.f15769a));
    }
}
