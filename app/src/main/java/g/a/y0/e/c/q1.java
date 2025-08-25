package g.a.y0.e.c;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeUsing.java */
/* loaded from: classes2.dex */
public final class q1<T, D> extends g.a.s<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends D> f14878a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super D, ? extends g.a.y<? extends T>> f14879b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.g<? super D> f14880c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f14881d;

    /* compiled from: MaybeUsing.java */
    static final class a<T, D> extends AtomicReference<Object> implements g.a.v<T>, g.a.u0.c {
        private static final long serialVersionUID = -674404550052917487L;
        final g.a.v<? super T> actual;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f14882d;
        final g.a.x0.g<? super D> disposer;
        final boolean eager;

        a(g.a.v<? super T> vVar, D d2, g.a.x0.g<? super D> gVar, boolean z) {
            super(d2);
            this.actual = vVar;
            this.disposer = gVar;
            this.eager = z;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14882d.dispose();
            this.f14882d = g.a.y0.a.d.DISPOSED;
            disposeResourceAfter();
        }

        void disposeResourceAfter() {
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
            return this.f14882d.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14882d = g.a.y0.a.d.DISPOSED;
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
            this.actual.onComplete();
            if (this.eager) {
                return;
            }
            disposeResourceAfter();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14882d = g.a.y0.a.d.DISPOSED;
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
            disposeResourceAfter();
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14882d, cVar)) {
                this.f14882d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.f14882d = g.a.y0.a.d.DISPOSED;
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
            disposeResourceAfter();
        }
    }

    public q1(Callable<? extends D> callable, g.a.x0.o<? super D, ? extends g.a.y<? extends T>> oVar, g.a.x0.g<? super D> gVar, boolean z) {
        this.f14878a = callable;
        this.f14879b = oVar;
        this.f14880c = gVar;
        this.f14881d = z;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        try {
            D dCall = this.f14878a.call();
            try {
                ((g.a.y) g.a.y0.b.b.a(this.f14879b.apply(dCall), "The sourceSupplier returned a null MaybeSource")).a(new a(vVar, dCall, this.f14880c, this.f14881d));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                if (this.f14881d) {
                    try {
                        this.f14880c.accept(dCall);
                    } catch (Throwable th2) {
                        g.a.v0.b.b(th2);
                        g.a.y0.a.e.error(new g.a.v0.a(th, th2), vVar);
                        return;
                    }
                }
                g.a.y0.a.e.error(th, vVar);
                if (this.f14881d) {
                    return;
                }
                try {
                    this.f14880c.accept(dCall);
                } catch (Throwable th3) {
                    g.a.v0.b.b(th3);
                    g.a.c1.a.b(th3);
                }
            }
        } catch (Throwable th4) {
            g.a.v0.b.b(th4);
            g.a.y0.a.e.error(th4, vVar);
        }
    }
}
