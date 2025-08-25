package g.a.y0.e.f;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleUsing.java */
/* loaded from: classes2.dex */
public final class t0<T, U> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<U> f15855a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super U, ? extends g.a.q0<? extends T>> f15856b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.g<? super U> f15857c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f15858d;

    /* compiled from: SingleUsing.java */
    static final class a<T, U> extends AtomicReference<Object> implements g.a.n0<T>, g.a.u0.c {
        private static final long serialVersionUID = -5331524057054083935L;
        final g.a.n0<? super T> actual;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15859d;
        final g.a.x0.g<? super U> disposer;
        final boolean eager;

        a(g.a.n0<? super T> n0Var, U u, boolean z, g.a.x0.g<? super U> gVar) {
            super(u);
            this.actual = n0Var;
            this.eager = z;
            this.disposer = gVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15859d.dispose();
            this.f15859d = g.a.y0.a.d.DISPOSED;
            disposeAfter();
        }

        void disposeAfter() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.c1.a.b(th);
                }
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15859d.isDisposed();
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f15859d = g.a.y0.a.d.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    th = new g.a.v0.a(th, th2);
                }
            }
            this.actual.onError(th);
            if (this.eager) {
                return;
            }
            disposeAfter();
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15859d, cVar)) {
                this.f15859d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.f15859d = g.a.y0.a.d.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.actual.onError(th);
                    return;
                }
            }
            this.actual.onSuccess(t);
            if (this.eager) {
                return;
            }
            disposeAfter();
        }
    }

    public t0(Callable<U> callable, g.a.x0.o<? super U, ? extends g.a.q0<? extends T>> oVar, g.a.x0.g<? super U> gVar, boolean z) {
        this.f15855a = callable;
        this.f15856b = oVar;
        this.f15857c = gVar;
        this.f15858d = z;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        try {
            U uCall = this.f15855a.call();
            try {
                ((g.a.q0) g.a.y0.b.b.a(this.f15856b.apply(uCall), "The singleFunction returned a null SingleSource")).a(new a(n0Var, uCall, this.f15858d, this.f15857c));
            } catch (Throwable th) {
                th = th;
                g.a.v0.b.b(th);
                if (this.f15858d) {
                    try {
                        this.f15857c.accept(uCall);
                    } catch (Throwable th2) {
                        g.a.v0.b.b(th2);
                        th = new g.a.v0.a(th, th2);
                    }
                }
                g.a.y0.a.e.error(th, n0Var);
                if (this.f15858d) {
                    return;
                }
                try {
                    this.f15857c.accept(uCall);
                } catch (Throwable th3) {
                    g.a.v0.b.b(th3);
                    g.a.c1.a.b(th3);
                }
            }
        } catch (Throwable th4) {
            g.a.v0.b.b(th4);
            g.a.y0.a.e.error(th4, n0Var);
        }
    }
}
