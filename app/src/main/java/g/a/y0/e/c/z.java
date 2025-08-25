package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeFlatMapBiSelector.java */
/* loaded from: classes2.dex */
public final class z<T, U, R> extends g.a.y0.e.c.a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.y<? extends U>> f14926b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<? super T, ? super U, ? extends R> f14927c;

    /* compiled from: MaybeFlatMapBiSelector.java */
    static final class a<T, U, R> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends g.a.y<? extends U>> f14928a;

        /* renamed from: b, reason: collision with root package name */
        final C0206a<T, U, R> f14929b;

        /* compiled from: MaybeFlatMapBiSelector.java */
        /* renamed from: g.a.y0.e.c.z$a$a, reason: collision with other inner class name */
        static final class C0206a<T, U, R> extends AtomicReference<g.a.u0.c> implements g.a.v<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            final g.a.v<? super R> actual;
            final g.a.x0.c<? super T, ? super U, ? extends R> resultSelector;
            T value;

            C0206a(g.a.v<? super R> vVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
                this.actual = vVar;
                this.resultSelector = cVar;
            }

            @Override // g.a.v
            public void onComplete() {
                this.actual.onComplete();
            }

            @Override // g.a.v
            public void onError(Throwable th) {
                this.actual.onError(th);
            }

            @Override // g.a.v
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.setOnce(this, cVar);
            }

            @Override // g.a.v, g.a.n0
            public void onSuccess(U u) {
                T t = this.value;
                this.value = null;
                try {
                    this.actual.onSuccess(g.a.y0.b.b.a(this.resultSelector.apply(t, u), "The resultSelector returned a null value"));
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.actual.onError(th);
                }
            }
        }

        a(g.a.v<? super R> vVar, g.a.x0.o<? super T, ? extends g.a.y<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
            this.f14929b = new C0206a<>(vVar, cVar);
            this.f14928a = oVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this.f14929b);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(this.f14929b.get());
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14929b.actual.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14929b.actual.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this.f14929b, cVar)) {
                this.f14929b.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            try {
                g.a.y yVar = (g.a.y) g.a.y0.b.b.a(this.f14928a.apply(t), "The mapper returned a null MaybeSource");
                if (g.a.y0.a.d.replace(this.f14929b, null)) {
                    C0206a<T, U, R> c0206a = this.f14929b;
                    c0206a.value = t;
                    yVar.a(c0206a);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14929b.actual.onError(th);
            }
        }
    }

    public z(g.a.y<T> yVar, g.a.x0.o<? super T, ? extends g.a.y<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        super(yVar);
        this.f14926b = oVar;
        this.f14927c = cVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super R> vVar) {
        this.f14742a.a(new a(vVar, this.f14926b, this.f14927c));
    }
}
