package g.a.y0.e.b;

import java.util.NoSuchElementException;

/* compiled from: FlowableLastSingle.java */
/* loaded from: classes2.dex */
public final class v1<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.d.b<T> f14660a;

    /* renamed from: b, reason: collision with root package name */
    final T f14661b;

    /* compiled from: FlowableLastSingle.java */
    static final class a<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super T> f14662a;

        /* renamed from: b, reason: collision with root package name */
        final T f14663b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f14664c;

        /* renamed from: d, reason: collision with root package name */
        T f14665d;

        a(g.a.n0<? super T> n0Var, T t) {
            this.f14662a = n0Var;
            this.f14663b = t;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14664c.cancel();
            this.f14664c = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14664c == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14664c = g.a.y0.i.j.CANCELLED;
            T t = this.f14665d;
            if (t != null) {
                this.f14665d = null;
                this.f14662a.onSuccess(t);
                return;
            }
            T t2 = this.f14663b;
            if (t2 != null) {
                this.f14662a.onSuccess(t2);
            } else {
                this.f14662a.onError(new NoSuchElementException());
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14664c = g.a.y0.i.j.CANCELLED;
            this.f14665d = null;
            this.f14662a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.f14665d = t;
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14664c, dVar)) {
                this.f14664c = dVar;
                this.f14662a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public v1(i.d.b<T> bVar, T t) {
        this.f14660a = bVar;
        this.f14661b = t;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f14660a.subscribe(new a(n0Var, this.f14661b));
    }
}
