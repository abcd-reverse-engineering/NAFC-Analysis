package g.a.y0.e.d;

import g.a.y0.e.d.g2;
import java.util.concurrent.Callable;

/* compiled from: ObservableReduceWithSingle.java */
/* loaded from: classes2.dex */
public final class h2<T, R> extends g.a.k0<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15183a;

    /* renamed from: b, reason: collision with root package name */
    final Callable<R> f15184b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<R, ? super T, R> f15185c;

    public h2(g.a.g0<T> g0Var, Callable<R> callable, g.a.x0.c<R, ? super T, R> cVar) {
        this.f15183a = g0Var;
        this.f15184b = callable;
        this.f15185c = cVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super R> n0Var) {
        try {
            this.f15183a.subscribe(new g2.a(n0Var, this.f15185c, g.a.y0.b.b.a(this.f15184b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, n0Var);
        }
    }
}
