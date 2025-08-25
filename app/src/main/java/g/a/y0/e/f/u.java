package g.a.y0.e.f;

import java.util.concurrent.Callable;

/* compiled from: SingleError.java */
/* loaded from: classes2.dex */
public final class u<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends Throwable> f15860a;

    public u(Callable<? extends Throwable> callable) {
        this.f15860a = callable;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        try {
            th = (Throwable) g.a.y0.b.b.a(this.f15860a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            g.a.v0.b.b(th);
        }
        g.a.y0.a.e.error(th, n0Var);
    }
}
