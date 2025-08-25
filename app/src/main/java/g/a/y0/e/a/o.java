package g.a.y0.e.a;

import java.util.concurrent.Callable;

/* compiled from: CompletableErrorSupplier.java */
/* loaded from: classes2.dex */
public final class o extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends Throwable> f14084a;

    public o(Callable<? extends Throwable> callable) {
        this.f14084a = callable;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        try {
            th = (Throwable) g.a.y0.b.b.a(this.f14084a.call(), "The error returned is null");
        } catch (Throwable th) {
            th = th;
            g.a.v0.b.b(th);
        }
        g.a.y0.a.e.error(th, fVar);
    }
}
