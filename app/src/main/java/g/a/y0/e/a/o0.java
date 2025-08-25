package g.a.y0.e.a;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableUsing.java */
/* loaded from: classes2.dex */
public final class o0<R> extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final Callable<R> f14085a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super R, ? extends g.a.i> f14086b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.g<? super R> f14087c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f14088d;

    /* compiled from: CompletableUsing.java */
    static final class a<R> extends AtomicReference<Object> implements g.a.f, g.a.u0.c {
        private static final long serialVersionUID = -674404550052917487L;
        final g.a.f actual;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f14089d;
        final g.a.x0.g<? super R> disposer;
        final boolean eager;

        a(g.a.f fVar, R r, g.a.x0.g<? super R> gVar, boolean z) {
            super(r);
            this.actual = fVar;
            this.disposer = gVar;
            this.eager = z;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14089d.dispose();
            this.f14089d = g.a.y0.a.d.DISPOSED;
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
            return this.f14089d.isDisposed();
        }

        @Override // g.a.f
        public void onComplete() {
            this.f14089d = g.a.y0.a.d.DISPOSED;
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

        @Override // g.a.f
        public void onError(Throwable th) {
            this.f14089d = g.a.y0.a.d.DISPOSED;
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

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14089d, cVar)) {
                this.f14089d = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public o0(Callable<R> callable, g.a.x0.o<? super R, ? extends g.a.i> oVar, g.a.x0.g<? super R> gVar, boolean z) {
        this.f14085a = callable;
        this.f14086b = oVar;
        this.f14087c = gVar;
        this.f14088d = z;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        try {
            R rCall = this.f14085a.call();
            try {
                ((g.a.i) g.a.y0.b.b.a(this.f14086b.apply(rCall), "The completableFunction returned a null CompletableSource")).a(new a(fVar, rCall, this.f14087c, this.f14088d));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                if (this.f14088d) {
                    try {
                        this.f14087c.accept(rCall);
                    } catch (Throwable th2) {
                        g.a.v0.b.b(th2);
                        g.a.y0.a.e.error(new g.a.v0.a(th, th2), fVar);
                        return;
                    }
                }
                g.a.y0.a.e.error(th, fVar);
                if (this.f14088d) {
                    return;
                }
                try {
                    this.f14087c.accept(rCall);
                } catch (Throwable th3) {
                    g.a.v0.b.b(th3);
                    g.a.c1.a.b(th3);
                }
            }
        } catch (Throwable th4) {
            g.a.v0.b.b(th4);
            g.a.y0.a.e.error(th4, fVar);
        }
    }
}
