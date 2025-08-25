package g.a.y0.e.b;

import java.util.concurrent.Callable;

/* compiled from: FlowableError.java */
/* loaded from: classes2.dex */
public final class u0<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final Callable<? extends Throwable> f14648b;

    public u0(Callable<? extends Throwable> callable) {
        this.f14648b = callable;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        try {
            th = (Throwable) g.a.y0.b.b.a(this.f14648b.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            g.a.v0.b.b(th);
        }
        g.a.y0.i.g.error(th, cVar);
    }
}
