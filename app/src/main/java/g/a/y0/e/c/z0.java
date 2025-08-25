package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeOnErrorNext.java */
/* loaded from: classes2.dex */
public final class z0<T> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super Throwable, ? extends g.a.y<? extends T>> f14930b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f14931c;

    /* compiled from: MaybeOnErrorNext.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c {
        private static final long serialVersionUID = 2026620218879969836L;
        final g.a.v<? super T> actual;
        final boolean allowFatal;
        final g.a.x0.o<? super Throwable, ? extends g.a.y<? extends T>> resumeFunction;

        /* compiled from: MaybeOnErrorNext.java */
        /* renamed from: g.a.y0.e.c.z0$a$a, reason: collision with other inner class name */
        static final class C0207a<T> implements g.a.v<T> {

            /* renamed from: a, reason: collision with root package name */
            final g.a.v<? super T> f14932a;

            /* renamed from: b, reason: collision with root package name */
            final AtomicReference<g.a.u0.c> f14933b;

            C0207a(g.a.v<? super T> vVar, AtomicReference<g.a.u0.c> atomicReference) {
                this.f14932a = vVar;
                this.f14933b = atomicReference;
            }

            @Override // g.a.v
            public void onComplete() {
                this.f14932a.onComplete();
            }

            @Override // g.a.v
            public void onError(Throwable th) {
                this.f14932a.onError(th);
            }

            @Override // g.a.v
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.setOnce(this.f14933b, cVar);
            }

            @Override // g.a.v, g.a.n0
            public void onSuccess(T t) {
                this.f14932a.onSuccess(t);
            }
        }

        a(g.a.v<? super T> vVar, g.a.x0.o<? super Throwable, ? extends g.a.y<? extends T>> oVar, boolean z) {
            this.actual = vVar;
            this.resumeFunction = oVar;
            this.allowFatal = z;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            if (!this.allowFatal && !(th instanceof Exception)) {
                this.actual.onError(th);
                return;
            }
            try {
                g.a.y yVar = (g.a.y) g.a.y0.b.b.a(this.resumeFunction.apply(th), "The resumeFunction returned a null MaybeSource");
                g.a.y0.a.d.replace(this, null);
                yVar.a(new C0207a(this.actual, this));
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.actual.onError(new g.a.v0.a(th, th2));
            }
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public z0(g.a.y<T> yVar, g.a.x0.o<? super Throwable, ? extends g.a.y<? extends T>> oVar, boolean z) {
        super(yVar);
        this.f14930b = oVar;
        this.f14931c = z;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar, this.f14930b, this.f14931c));
    }
}
