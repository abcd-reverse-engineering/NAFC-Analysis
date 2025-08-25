package g.a.y0.e.d;

import java.util.concurrent.Callable;

/* compiled from: ObservableError.java */
/* loaded from: classes2.dex */
public final class s0<T> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends Throwable> f15458a;

    public s0(Callable<? extends Throwable> callable) {
        this.f15458a = callable;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        try {
            th = (Throwable) g.a.y0.b.b.a(this.f15458a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            g.a.v0.b.b(th);
        }
        g.a.y0.a.e.error(th, i0Var);
    }
}
