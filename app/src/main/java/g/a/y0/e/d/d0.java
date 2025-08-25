package g.a.y0.e.d;

import java.util.concurrent.Callable;

/* compiled from: ObservableDefer.java */
/* loaded from: classes2.dex */
public final class d0<T> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends g.a.g0<? extends T>> f15034a;

    public d0(Callable<? extends g.a.g0<? extends T>> callable) {
        this.f15034a = callable;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        try {
            ((g.a.g0) g.a.y0.b.b.a(this.f15034a.call(), "null ObservableSource supplied")).subscribe(i0Var);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, i0Var);
        }
    }
}
