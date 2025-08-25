package g.a.y0.e.b;

import java.util.NoSuchElementException;

/* compiled from: FlowableSingleSingle.java */
/* loaded from: classes2.dex */
public final class l3<T> extends g.a.k0<T> implements g.a.y0.c.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14357a;

    /* renamed from: b, reason: collision with root package name */
    final T f14358b;

    /* compiled from: FlowableSingleSingle.java */
    static final class a<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super T> f14359a;

        /* renamed from: b, reason: collision with root package name */
        final T f14360b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f14361c;

        /* renamed from: d, reason: collision with root package name */
        boolean f14362d;

        /* renamed from: e, reason: collision with root package name */
        T f14363e;

        a(g.a.n0<? super T> n0Var, T t) {
            this.f14359a = n0Var;
            this.f14360b = t;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14361c.cancel();
            this.f14361c = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14361c == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14362d) {
                return;
            }
            this.f14362d = true;
            this.f14361c = g.a.y0.i.j.CANCELLED;
            T t = this.f14363e;
            this.f14363e = null;
            if (t == null) {
                t = this.f14360b;
            }
            if (t != null) {
                this.f14359a.onSuccess(t);
            } else {
                this.f14359a.onError(new NoSuchElementException());
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14362d) {
                g.a.c1.a.b(th);
                return;
            }
            this.f14362d = true;
            this.f14361c = g.a.y0.i.j.CANCELLED;
            this.f14359a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14362d) {
                return;
            }
            if (this.f14363e == null) {
                this.f14363e = t;
                return;
            }
            this.f14362d = true;
            this.f14361c.cancel();
            this.f14361c = g.a.y0.i.j.CANCELLED;
            this.f14359a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14361c, dVar)) {
                this.f14361c = dVar;
                this.f14359a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public l3(g.a.l<T> lVar, T t) {
        this.f14357a = lVar;
        this.f14358b = t;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f14357a.a((g.a.q) new a(n0Var, this.f14358b));
    }

    @Override // g.a.y0.c.b
    public g.a.l<T> b() {
        return g.a.c1.a.a(new j3(this.f14357a, this.f14358b));
    }
}
