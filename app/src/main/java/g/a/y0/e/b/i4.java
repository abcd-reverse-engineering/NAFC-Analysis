package g.a.y0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: FlowableToListSingle.java */
/* loaded from: classes2.dex */
public final class i4<T, U extends Collection<? super T>> extends g.a.k0<U> implements g.a.y0.c.b<U> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14286a;

    /* renamed from: b, reason: collision with root package name */
    final Callable<U> f14287b;

    /* compiled from: FlowableToListSingle.java */
    static final class a<T, U extends Collection<? super T>> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super U> f14288a;

        /* renamed from: b, reason: collision with root package name */
        i.d.d f14289b;

        /* renamed from: c, reason: collision with root package name */
        U f14290c;

        a(g.a.n0<? super U> n0Var, U u) {
            this.f14288a = n0Var;
            this.f14290c = u;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14289b.cancel();
            this.f14289b = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14289b == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14289b = g.a.y0.i.j.CANCELLED;
            this.f14288a.onSuccess(this.f14290c);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14290c = null;
            this.f14289b = g.a.y0.i.j.CANCELLED;
            this.f14288a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.f14290c.add(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14289b, dVar)) {
                this.f14289b = dVar;
                this.f14288a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public i4(g.a.l<T> lVar) {
        this(lVar, g.a.y0.j.b.asCallable());
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super U> n0Var) {
        try {
            this.f14286a.a((g.a.q) new a(n0Var, (Collection) g.a.y0.b.b.a(this.f14287b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, n0Var);
        }
    }

    public i4(g.a.l<T> lVar, Callable<U> callable) {
        this.f14286a = lVar;
        this.f14287b = callable;
    }

    @Override // g.a.y0.c.b
    public g.a.l<U> b() {
        return g.a.c1.a.a(new h4(this.f14286a, this.f14287b));
    }
}
