package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeFlatMapSingleElement.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class f0<T, R> extends g.a.s<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<T> f14798a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> f14799b;

    /* compiled from: MaybeFlatMapSingleElement.java */
    static final class a<T, R> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c {
        private static final long serialVersionUID = 4827726964688405508L;
        final g.a.v<? super R> actual;
        final g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> mapper;

        a(g.a.v<? super R> vVar, g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> oVar) {
            this.actual = vVar;
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
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            try {
                ((g.a.q0) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null SingleSource")).a(new b(this, this.actual));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                onError(th);
            }
        }
    }

    /* compiled from: MaybeFlatMapSingleElement.java */
    static final class b<R> implements g.a.n0<R> {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReference<g.a.u0.c> f14800a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.v<? super R> f14801b;

        b(AtomicReference<g.a.u0.c> atomicReference, g.a.v<? super R> vVar) {
            this.f14800a = atomicReference;
            this.f14801b = vVar;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f14801b.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.replace(this.f14800a, cVar);
        }

        @Override // g.a.n0
        public void onSuccess(R r) {
            this.f14801b.onSuccess(r);
        }
    }

    public f0(g.a.y<T> yVar, g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> oVar) {
        this.f14798a = yVar;
        this.f14799b = oVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super R> vVar) {
        this.f14798a.a(new a(vVar, this.f14799b));
    }
}
