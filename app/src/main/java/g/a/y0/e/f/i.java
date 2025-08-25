package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDelayWithPublisher.java */
/* loaded from: classes2.dex */
public final class i<T, U> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15779a;

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<U> f15780b;

    /* compiled from: SingleDelayWithPublisher.java */
    static final class a<T, U> extends AtomicReference<g.a.u0.c> implements g.a.q<U>, g.a.u0.c {
        private static final long serialVersionUID = -8565274649390031272L;
        final g.a.n0<? super T> actual;
        boolean done;
        i.d.d s;
        final g.a.q0<T> source;

        a(g.a.n0<? super T> n0Var, g.a.q0<T> q0Var) {
            this.actual = n0Var;
            this.source = q0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.s.cancel();
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.source.a(new g.a.y0.d.a0(this, this.actual));
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(U u) {
            this.s.cancel();
            onComplete();
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public i(g.a.q0<T> q0Var, i.d.b<U> bVar) {
        this.f15779a = q0Var;
        this.f15780b = bVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15780b.subscribe(new a(n0Var, this.f15779a));
    }
}
