package g.a.y0.e.d;

import java.util.concurrent.Callable;

/* compiled from: ObservableCollectSingle.java */
/* loaded from: classes2.dex */
public final class t<T, U> extends g.a.k0<U> implements g.a.y0.c.d<U> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15476a;

    /* renamed from: b, reason: collision with root package name */
    final Callable<? extends U> f15477b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.b<? super U, ? super T> f15478c;

    /* compiled from: ObservableCollectSingle.java */
    static final class a<T, U> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super U> f15479a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.b<? super U, ? super T> f15480b;

        /* renamed from: c, reason: collision with root package name */
        final U f15481c;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15482d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15483e;

        a(g.a.n0<? super U> n0Var, U u, g.a.x0.b<? super U, ? super T> bVar) {
            this.f15479a = n0Var;
            this.f15480b = bVar;
            this.f15481c = u;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15482d.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15482d.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15483e) {
                return;
            }
            this.f15483e = true;
            this.f15479a.onSuccess(this.f15481c);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15483e) {
                g.a.c1.a.b(th);
            } else {
                this.f15483e = true;
                this.f15479a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15483e) {
                return;
            }
            try {
                this.f15480b.a(this.f15481c, t);
            } catch (Throwable th) {
                this.f15482d.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15482d, cVar)) {
                this.f15482d = cVar;
                this.f15479a.onSubscribe(this);
            }
        }
    }

    public t(g.a.g0<T> g0Var, Callable<? extends U> callable, g.a.x0.b<? super U, ? super T> bVar) {
        this.f15476a = g0Var;
        this.f15477b = callable;
        this.f15478c = bVar;
    }

    @Override // g.a.y0.c.d
    public g.a.b0<U> a() {
        return g.a.c1.a.a(new s(this.f15476a, this.f15477b, this.f15478c));
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super U> n0Var) {
        try {
            this.f15476a.subscribe(new a(n0Var, g.a.y0.b.b.a(this.f15477b.call(), "The initialSupplier returned a null value"), this.f15478c));
        } catch (Throwable th) {
            g.a.y0.a.e.error(th, n0Var);
        }
    }
}
