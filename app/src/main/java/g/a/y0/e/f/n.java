package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SingleDoFinally.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class n<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15808a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.a f15809b;

    /* compiled from: SingleDoFinally.java */
    static final class a<T> extends AtomicInteger implements g.a.n0<T>, g.a.u0.c {
        private static final long serialVersionUID = 4109457741734051389L;
        final g.a.n0<? super T> actual;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15810d;
        final g.a.x0.a onFinally;

        a(g.a.n0<? super T> n0Var, g.a.x0.a aVar) {
            this.actual = n0Var;
            this.onFinally = aVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15810d.dispose();
            runFinally();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15810d.isDisposed();
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15810d, cVar)) {
                this.f15810d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
            runFinally();
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.c1.a.b(th);
                }
            }
        }
    }

    public n(g.a.q0<T> q0Var, g.a.x0.a aVar) {
        this.f15808a = q0Var;
        this.f15809b = aVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15808a.a(new a(n0Var, this.f15809b));
    }
}
