package g.a.y0.e.c;

import java.util.NoSuchElementException;

/* compiled from: MaybeToSingle.java */
/* loaded from: classes2.dex */
public final class n1<T> extends g.a.k0<T> implements g.a.y0.c.f<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<T> f14855a;

    /* renamed from: b, reason: collision with root package name */
    final T f14856b;

    /* compiled from: MaybeToSingle.java */
    static final class a<T> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super T> f14857a;

        /* renamed from: b, reason: collision with root package name */
        final T f14858b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14859c;

        a(g.a.n0<? super T> n0Var, T t) {
            this.f14857a = n0Var;
            this.f14858b = t;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14859c.dispose();
            this.f14859c = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14859c.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14859c = g.a.y0.a.d.DISPOSED;
            T t = this.f14858b;
            if (t != null) {
                this.f14857a.onSuccess(t);
            } else {
                this.f14857a.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14859c = g.a.y0.a.d.DISPOSED;
            this.f14857a.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14859c, cVar)) {
                this.f14859c = cVar;
                this.f14857a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.f14859c = g.a.y0.a.d.DISPOSED;
            this.f14857a.onSuccess(t);
        }
    }

    public n1(g.a.y<T> yVar, T t) {
        this.f14855a = yVar;
        this.f14856b = t;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f14855a.a(new a(n0Var, this.f14856b));
    }

    @Override // g.a.y0.c.f
    public g.a.y<T> source() {
        return this.f14855a;
    }
}
