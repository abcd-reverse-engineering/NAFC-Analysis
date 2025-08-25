package g.a.y0.e.f;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleTakeUntil.java */
/* loaded from: classes2.dex */
public final class n0<T, U> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15811a;

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<U> f15812b;

    /* compiled from: SingleTakeUntil.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.n0<T>, g.a.u0.c {
        private static final long serialVersionUID = -622603812305745221L;
        final g.a.n0<? super T> actual;
        final b other = new b(this);

        a(g.a.n0<? super T> n0Var) {
            this.actual = n0Var;
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
            this.other.dispose();
            g.a.u0.c cVar = get();
            g.a.y0.a.d dVar = g.a.y0.a.d.DISPOSED;
            if (cVar == dVar || getAndSet(dVar) == g.a.y0.a.d.DISPOSED) {
                g.a.c1.a.b(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.other.dispose();
            g.a.u0.c cVar = get();
            g.a.y0.a.d dVar = g.a.y0.a.d.DISPOSED;
            if (cVar == dVar || getAndSet(dVar) == g.a.y0.a.d.DISPOSED) {
                return;
            }
            this.actual.onSuccess(t);
        }

        void otherError(Throwable th) {
            g.a.u0.c andSet;
            g.a.u0.c cVar = get();
            g.a.y0.a.d dVar = g.a.y0.a.d.DISPOSED;
            if (cVar == dVar || (andSet = getAndSet(dVar)) == g.a.y0.a.d.DISPOSED) {
                g.a.c1.a.b(th);
                return;
            }
            if (andSet != null) {
                andSet.dispose();
            }
            this.actual.onError(th);
        }
    }

    /* compiled from: SingleTakeUntil.java */
    static final class b extends AtomicReference<i.d.d> implements g.a.q<Object> {
        private static final long serialVersionUID = 5170026210238877381L;
        final a<?> parent;

        b(a<?> aVar) {
            this.parent = aVar;
        }

        public void dispose() {
            g.a.y0.i.j.cancel(this);
        }

        @Override // i.d.c
        public void onComplete() {
            i.d.d dVar = get();
            g.a.y0.i.j jVar = g.a.y0.i.j.CANCELLED;
            if (dVar != jVar) {
                lazySet(jVar);
                this.parent.otherError(new CancellationException());
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.parent.otherError(th);
        }

        @Override // i.d.c
        public void onNext(Object obj) {
            if (g.a.y0.i.j.cancel(this)) {
                this.parent.otherError(new CancellationException());
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public n0(g.a.q0<T> q0Var, i.d.b<U> bVar) {
        this.f15811a = q0Var;
        this.f15812b = bVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        a aVar = new a(n0Var);
        n0Var.onSubscribe(aVar);
        this.f15812b.subscribe(aVar.other);
        this.f15811a.a(aVar);
    }
}
