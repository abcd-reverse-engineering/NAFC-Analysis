package g.a.y0.e.a;

import java.util.concurrent.Callable;

/* compiled from: CompletableToSingle.java */
/* loaded from: classes2.dex */
public final class n0<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14079a;

    /* renamed from: b, reason: collision with root package name */
    final Callable<? extends T> f14080b;

    /* renamed from: c, reason: collision with root package name */
    final T f14081c;

    /* compiled from: CompletableToSingle.java */
    final class a implements g.a.f {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.n0<? super T> f14082a;

        a(g.a.n0<? super T> n0Var) {
            this.f14082a = n0Var;
        }

        @Override // g.a.f
        public void onComplete() {
            T tCall;
            n0 n0Var = n0.this;
            Callable<? extends T> callable = n0Var.f14080b;
            if (callable != null) {
                try {
                    tCall = callable.call();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.f14082a.onError(th);
                    return;
                }
            } else {
                tCall = n0Var.f14081c;
            }
            if (tCall == null) {
                this.f14082a.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.f14082a.onSuccess(tCall);
            }
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            this.f14082a.onError(th);
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            this.f14082a.onSubscribe(cVar);
        }
    }

    public n0(g.a.i iVar, Callable<? extends T> callable, T t) {
        this.f14079a = iVar;
        this.f14081c = t;
        this.f14080b = callable;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f14079a.a(new a(n0Var));
    }
}
