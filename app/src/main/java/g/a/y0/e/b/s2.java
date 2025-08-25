package g.a.y0.e.b;

import g.a.y0.e.b.r2;
import java.util.concurrent.Callable;

/* compiled from: FlowableReduceWithSingle.java */
/* loaded from: classes2.dex */
public final class s2<T, R> extends g.a.k0<R> {

    /* renamed from: a, reason: collision with root package name */
    final i.d.b<T> f14600a;

    /* renamed from: b, reason: collision with root package name */
    final Callable<R> f14601b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<R, ? super T, R> f14602c;

    public s2(i.d.b<T> bVar, Callable<R> callable, g.a.x0.c<R, ? super T, R> cVar) {
        this.f14600a = bVar;
        this.f14601b = callable;
        this.f14602c = cVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super R> n0Var) {
        try {
            this.f14600a.subscribe(new r2.a(n0Var, this.f14602c, g.a.y0.b.b.a(this.f14601b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, n0Var);
        }
    }
}
