package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMapCompletable.java */
/* loaded from: classes2.dex */
public final class w<T> extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15871a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.i> f15872b;

    /* compiled from: SingleFlatMapCompletable.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.n0<T>, g.a.f, g.a.u0.c {
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

        @Override // g.a.f
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.replace(this, cVar);
        }

        @Override // g.a.n0
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

    public w(g.a.q0<T> q0Var, g.a.x0.o<? super T, ? extends g.a.i> oVar) {
        this.f15871a = q0Var;
        this.f15872b = oVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        a aVar = new a(fVar, this.f15872b);
        fVar.onSubscribe(aVar);
        this.f15871a.a(aVar);
    }
}
