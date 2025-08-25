package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeTakeUntilMaybe.java */
/* loaded from: classes2.dex */
public final class f1<T, U> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.y<U> f14802b;

    /* compiled from: MaybeTakeUntilMaybe.java */
    static final class a<T, U> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c {
        private static final long serialVersionUID = -2187421758664251153L;
        final g.a.v<? super T> actual;
        final C0203a<U> other = new C0203a<>(this);

        /* compiled from: MaybeTakeUntilMaybe.java */
        /* renamed from: g.a.y0.e.c.f1$a$a, reason: collision with other inner class name */
        static final class C0203a<U> extends AtomicReference<g.a.u0.c> implements g.a.v<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            final a<?, U> parent;

            C0203a(a<?, U> aVar) {
                this.parent = aVar;
            }

            @Override // g.a.v
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // g.a.v
            public void onError(Throwable th) {
                this.parent.otherError(th);
            }

            @Override // g.a.v
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.setOnce(this, cVar);
            }

            @Override // g.a.v, g.a.n0
            public void onSuccess(Object obj) {
                this.parent.otherComplete();
            }
        }

        a(g.a.v<? super T> vVar) {
            this.actual = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
            g.a.y0.a.d.dispose(this.other);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.v
        public void onComplete() {
            g.a.y0.a.d.dispose(this.other);
            if (getAndSet(g.a.y0.a.d.DISPOSED) != g.a.y0.a.d.DISPOSED) {
                this.actual.onComplete();
            }
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            g.a.y0.a.d.dispose(this.other);
            if (getAndSet(g.a.y0.a.d.DISPOSED) != g.a.y0.a.d.DISPOSED) {
                this.actual.onError(th);
            } else {
                g.a.c1.a.b(th);
            }
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            g.a.y0.a.d.dispose(this.other);
            if (getAndSet(g.a.y0.a.d.DISPOSED) != g.a.y0.a.d.DISPOSED) {
                this.actual.onSuccess(t);
            }
        }

        void otherComplete() {
            if (g.a.y0.a.d.dispose(this)) {
                this.actual.onComplete();
            }
        }

        void otherError(Throwable th) {
            if (g.a.y0.a.d.dispose(this)) {
                this.actual.onError(th);
            } else {
                g.a.c1.a.b(th);
            }
        }
    }

    public f1(g.a.y<T> yVar, g.a.y<U> yVar2) {
        super(yVar);
        this.f14802b = yVar2;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        this.f14802b.a(aVar.other);
        this.f14742a.a(aVar);
    }
}
