package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeFlatMapCompletable.java */
/* loaded from: classes2.dex */
public final class a0<T> extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<T> f14743a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.i> f14744b;

    /* compiled from: MaybeFlatMapCompletable.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.f, g.a.u0.c {
        private static final long serialVersionUID = -2177128922851101253L;
        final g.a.f actual;
        final g.a.x0.o<? super T, ? extends g.a.i> mapper;

        a(g.a.f fVar, g.a.x0.o<? super T, ? extends g.a.i> oVar) {
            this.actual = fVar;
            this.mapper = oVar;
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
            this.actual.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.replace(this, cVar);
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            try {
                g.a.i iVar = (g.a.i) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                if (isDisposed()) {
                    return;
                }
                iVar.a(this);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                onError(th);
            }
        }
    }

    public a0(g.a.y<T> yVar, g.a.x0.o<? super T, ? extends g.a.i> oVar) {
        this.f14743a = yVar;
        this.f14744b = oVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        a aVar = new a(fVar, this.f14744b);
        fVar.onSubscribe(aVar);
        this.f14743a.a(aVar);
    }
}
