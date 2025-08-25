package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeFlatten.java */
/* loaded from: classes2.dex */
public final class g0<T, R> extends g.a.y0.e.c.a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.y<? extends R>> f14804b;

    /* compiled from: MaybeFlatten.java */
    static final class a<T, R> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c {
        private static final long serialVersionUID = 4375739915521278546L;
        final g.a.v<? super R> actual;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f14805d;
        final g.a.x0.o<? super T, ? extends g.a.y<? extends R>> mapper;

        /* compiled from: MaybeFlatten.java */
        /* renamed from: g.a.y0.e.c.g0$a$a, reason: collision with other inner class name */
        final class C0204a implements g.a.v<R> {
            C0204a() {
            }

            @Override // g.a.v
            public void onComplete() {
                a.this.actual.onComplete();
            }

            @Override // g.a.v
            public void onError(Throwable th) {
                a.this.actual.onError(th);
            }

            @Override // g.a.v
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.setOnce(a.this, cVar);
            }

            @Override // g.a.v, g.a.n0
            public void onSuccess(R r) {
                a.this.actual.onSuccess(r);
            }
        }

        a(g.a.v<? super R> vVar, g.a.x0.o<? super T, ? extends g.a.y<? extends R>> oVar) {
            this.actual = vVar;
            this.mapper = oVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
            this.f14805d.dispose();
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
            this.actual.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14805d, cVar)) {
                this.f14805d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            try {
                g.a.y yVar = (g.a.y) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (isDisposed()) {
                    return;
                }
                yVar.a(new C0204a());
            } catch (Exception e2) {
                g.a.v0.b.b(e2);
                this.actual.onError(e2);
            }
        }
    }

    public g0(g.a.y<T> yVar, g.a.x0.o<? super T, ? extends g.a.y<? extends R>> oVar) {
        super(yVar);
        this.f14804b = oVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super R> vVar) {
        this.f14742a.a(new a(vVar, this.f14804b));
    }
}
