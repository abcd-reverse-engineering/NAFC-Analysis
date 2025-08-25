package g.a.y0.e.a;

import g.a.q0;

/* compiled from: CompletableFromSingle.java */
/* loaded from: classes2.dex */
public final class u<T> extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final q0<T> f14098a;

    /* compiled from: CompletableFromSingle.java */
    static final class a<T> implements g.a.n0<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f f14099a;

        a(g.a.f fVar) {
            this.f14099a = fVar;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            this.f14099a.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f14099a.onSubscribe(cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.f14099a.onComplete();
        }
    }

    public u(q0<T> q0Var) {
        this.f14098a = q0Var;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14098a.a(new a(fVar));
    }
}
