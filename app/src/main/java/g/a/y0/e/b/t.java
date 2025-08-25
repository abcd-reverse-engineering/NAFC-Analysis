package g.a.y0.e.b;

import java.util.concurrent.Callable;

/* compiled from: FlowableCollectSingle.java */
/* loaded from: classes2.dex */
public final class t<T, U> extends g.a.k0<U> implements g.a.y0.c.b<U> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14613a;

    /* renamed from: b, reason: collision with root package name */
    final Callable<? extends U> f14614b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.b<? super U, ? super T> f14615c;

    /* compiled from: FlowableCollectSingle.java */
    static final class a<T, U> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super U> f14616a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.b<? super U, ? super T> f14617b;

        /* renamed from: c, reason: collision with root package name */
        final U f14618c;

        /* renamed from: d, reason: collision with root package name */
        i.d.d f14619d;

        /* renamed from: e, reason: collision with root package name */
        boolean f14620e;

        a(g.a.n0<? super U> n0Var, U u, g.a.x0.b<? super U, ? super T> bVar) {
            this.f14616a = n0Var;
            this.f14617b = bVar;
            this.f14618c = u;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14619d.cancel();
            this.f14619d = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14619d == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14620e) {
                return;
            }
            this.f14620e = true;
            this.f14619d = g.a.y0.i.j.CANCELLED;
            this.f14616a.onSuccess(this.f14618c);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14620e) {
                g.a.c1.a.b(th);
                return;
            }
            this.f14620e = true;
            this.f14619d = g.a.y0.i.j.CANCELLED;
            this.f14616a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14620e) {
                return;
            }
            try {
                this.f14617b.a(this.f14618c, t);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14619d.cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14619d, dVar)) {
                this.f14619d = dVar;
                this.f14616a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public t(g.a.l<T> lVar, Callable<? extends U> callable, g.a.x0.b<? super U, ? super T> bVar) {
        this.f14613a = lVar;
        this.f14614b = callable;
        this.f14615c = bVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super U> n0Var) {
        try {
            this.f14613a.a((g.a.q) new a(n0Var, g.a.y0.b.b.a(this.f14614b.call(), "The initialSupplier returned a null value"), this.f14615c));
        } catch (Throwable th) {
            g.a.y0.a.e.error(th, n0Var);
        }
    }

    @Override // g.a.y0.c.b
    public g.a.l<U> b() {
        return g.a.c1.a.a(new s(this.f14613a, this.f14614b, this.f14615c));
    }
}
