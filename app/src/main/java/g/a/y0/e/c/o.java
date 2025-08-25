package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeDelayWithCompletable.java */
/* loaded from: classes2.dex */
public final class o<T> extends g.a.s<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<T> f14860a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.i f14861b;

    /* compiled from: MaybeDelayWithCompletable.java */
    static final class a<T> implements g.a.v<T> {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReference<g.a.u0.c> f14862a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.v<? super T> f14863b;

        a(AtomicReference<g.a.u0.c> atomicReference, g.a.v<? super T> vVar) {
            this.f14862a = atomicReference;
            this.f14863b = vVar;
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14863b.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14863b.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.replace(this.f14862a, cVar);
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.f14863b.onSuccess(t);
        }
    }

    /* compiled from: MaybeDelayWithCompletable.java */
    static final class b<T> extends AtomicReference<g.a.u0.c> implements g.a.f, g.a.u0.c {
        private static final long serialVersionUID = 703409937383992161L;
        final g.a.v<? super T> actual;
        final g.a.y<T> source;

        b(g.a.v<? super T> vVar, g.a.y<T> yVar) {
            this.actual = vVar;
            this.source = yVar;
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
            this.source.a(new a(this, this.actual));
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }
    }

    public o(g.a.y<T> yVar, g.a.i iVar) {
        this.f14860a = yVar;
        this.f14861b = iVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14861b.a(new b(vVar, this.f14860a));
    }
}
