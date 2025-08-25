package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMapMaybe.java */
/* loaded from: classes2.dex */
public final class z<T, R> extends g.a.s<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<? extends T> f15879a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.y<? extends R>> f15880b;

    /* compiled from: SingleFlatMapMaybe.java */
    static final class a<R> implements g.a.v<R> {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReference<g.a.u0.c> f15881a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.v<? super R> f15882b;

        a(AtomicReference<g.a.u0.c> atomicReference, g.a.v<? super R> vVar) {
            this.f15881a = atomicReference;
            this.f15882b = vVar;
        }

        @Override // g.a.v
        public void onComplete() {
            this.f15882b.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f15882b.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.replace(this.f15881a, cVar);
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(R r) {
            this.f15882b.onSuccess(r);
        }
    }

    /* compiled from: SingleFlatMapMaybe.java */
    static final class b<T, R> extends AtomicReference<g.a.u0.c> implements g.a.n0<T>, g.a.u0.c {
        private static final long serialVersionUID = -5843758257109742742L;
        final g.a.v<? super R> actual;
        final g.a.x0.o<? super T, ? extends g.a.y<? extends R>> mapper;

        b(g.a.v<? super R> vVar, g.a.x0.o<? super T, ? extends g.a.y<? extends R>> oVar) {
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

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            try {
                g.a.y yVar = (g.a.y) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (isDisposed()) {
                    return;
                }
                yVar.a(new a(this, this.actual));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                onError(th);
            }
        }
    }

    public z(g.a.q0<? extends T> q0Var, g.a.x0.o<? super T, ? extends g.a.y<? extends R>> oVar) {
        this.f15880b = oVar;
        this.f15879a = q0Var;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super R> vVar) {
        this.f15879a.a(new b(vVar, this.f15880b));
    }
}
