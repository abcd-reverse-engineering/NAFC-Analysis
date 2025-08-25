package g.a.y0.e.d;

import java.util.Iterator;

/* compiled from: ObservableFlattenIterable.java */
/* loaded from: classes2.dex */
public final class z0<T, R> extends g.a.y0.e.d.a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends Iterable<? extends R>> f15601b;

    /* compiled from: ObservableFlattenIterable.java */
    static final class a<T, R> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super R> f15602a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends Iterable<? extends R>> f15603b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15604c;

        a(g.a.i0<? super R> i0Var, g.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.f15602a = i0Var;
            this.f15603b = oVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15604c.dispose();
            this.f15604c = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15604c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            g.a.u0.c cVar = this.f15604c;
            g.a.y0.a.d dVar = g.a.y0.a.d.DISPOSED;
            if (cVar == dVar) {
                return;
            }
            this.f15604c = dVar;
            this.f15602a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            g.a.u0.c cVar = this.f15604c;
            g.a.y0.a.d dVar = g.a.y0.a.d.DISPOSED;
            if (cVar == dVar) {
                g.a.c1.a.b(th);
            } else {
                this.f15604c = dVar;
                this.f15602a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15604c == g.a.y0.a.d.DISPOSED) {
                return;
            }
            try {
                Iterator<? extends R> it = this.f15603b.apply(t).iterator();
                g.a.i0<? super R> i0Var = this.f15602a;
                while (it.hasNext()) {
                    try {
                        try {
                            i0Var.onNext((Object) g.a.y0.b.b.a(it.next(), "The iterator returned a null value"));
                        } catch (Throwable th) {
                            g.a.v0.b.b(th);
                            this.f15604c.dispose();
                            onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        g.a.v0.b.b(th2);
                        this.f15604c.dispose();
                        onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                this.f15604c.dispose();
                onError(th3);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15604c, cVar)) {
                this.f15604c = cVar;
                this.f15602a.onSubscribe(this);
            }
        }
    }

    public z0(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
        super(g0Var);
        this.f15601b = oVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super R> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15601b));
    }
}
