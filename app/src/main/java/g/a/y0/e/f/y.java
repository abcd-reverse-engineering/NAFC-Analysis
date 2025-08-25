package g.a.y0.e.f;

import java.util.Iterator;

/* compiled from: SingleFlatMapIterableObservable.java */
/* loaded from: classes2.dex */
public final class y<T, R> extends g.a.b0<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15876a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends Iterable<? extends R>> f15877b;

    /* compiled from: SingleFlatMapIterableObservable.java */
    static final class a<T, R> extends g.a.y0.d.b<R> implements g.a.n0<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        final g.a.i0<? super R> actual;
        volatile boolean cancelled;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15878d;
        volatile Iterator<? extends R> it;
        final g.a.x0.o<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;

        a(g.a.i0<? super R> i0Var, g.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.actual = i0Var;
            this.mapper = oVar;
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.it = null;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.cancelled = true;
            this.f15878d.dispose();
            this.f15878d = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.it == null;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f15878d = g.a.y0.a.d.DISPOSED;
            this.actual.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15878d, cVar)) {
                this.f15878d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            g.a.i0<? super R> i0Var = this.actual;
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    i0Var.onComplete();
                    return;
                }
                if (this.outputFused) {
                    this.it = it;
                    i0Var.onNext(null);
                    i0Var.onComplete();
                    return;
                }
                while (!this.cancelled) {
                    try {
                        i0Var.onNext(it.next());
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                i0Var.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            g.a.v0.b.b(th);
                            i0Var.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        g.a.v0.b.b(th2);
                        i0Var.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                this.actual.onError(th3);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.it;
            if (it == null) {
                return null;
            }
            R r = (R) g.a.y0.b.b.a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.it = null;
            }
            return r;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public y(g.a.q0<T> q0Var, g.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
        this.f15876a = q0Var;
        this.f15877b = oVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super R> i0Var) {
        this.f15876a.a(new a(i0Var, this.f15877b));
    }
}
