package g.a.y0.e.a;

import java.util.concurrent.Callable;

/* compiled from: CompletableDefer.java */
/* loaded from: classes2.dex */
public final class g extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends g.a.i> f14012a;

    public g(Callable<? extends g.a.i> callable) {
        this.f14012a = callable;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        try {
            ((g.a.i) g.a.y0.b.b.a(this.f14012a.call(), "The completableSupplier returned a null CompletableSource")).a(fVar);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, fVar);
        }
    }
}
