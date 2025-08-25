package g.a.y0.e.f;

import java.util.concurrent.Callable;

/* compiled from: SingleDefer.java */
/* loaded from: classes2.dex */
public final class e<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends g.a.q0<? extends T>> f15750a;

    public e(Callable<? extends g.a.q0<? extends T>> callable) {
        this.f15750a = callable;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        try {
            ((g.a.q0) g.a.y0.b.b.a(this.f15750a.call(), "The singleSupplier returned a null SingleSource")).a(n0Var);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, n0Var);
        }
    }
}
