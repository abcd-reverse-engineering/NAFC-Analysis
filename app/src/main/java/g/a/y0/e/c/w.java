package g.a.y0.e.c;

import java.util.concurrent.Callable;

/* compiled from: MaybeErrorCallable.java */
/* loaded from: classes2.dex */
public final class w<T> extends g.a.s<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends Throwable> f14910a;

    public w(Callable<? extends Throwable> callable) {
        this.f14910a = callable;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        vVar.onSubscribe(g.a.u0.d.a());
        try {
            th = (Throwable) g.a.y0.b.b.a(this.f14910a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            g.a.v0.b.b(th);
        }
        vVar.onError(th);
    }
}
