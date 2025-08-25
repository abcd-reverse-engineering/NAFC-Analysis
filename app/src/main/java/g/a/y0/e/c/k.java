package g.a.y0.e.c;

import java.util.concurrent.Callable;

/* compiled from: MaybeDefer.java */
/* loaded from: classes2.dex */
public final class k<T> extends g.a.s<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends g.a.y<? extends T>> f14829a;

    public k(Callable<? extends g.a.y<? extends T>> callable) {
        this.f14829a = callable;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        try {
            ((g.a.y) g.a.y0.b.b.a(this.f14829a.call(), "The maybeSupplier returned a null MaybeSource")).a(vVar);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, vVar);
        }
    }
}
