package g.a.y0.e.b;

import java.util.concurrent.Callable;

/* compiled from: FlowableDefer.java */
/* loaded from: classes2.dex */
public final class f0<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final Callable<? extends i.d.b<? extends T>> f14211b;

    public f0(Callable<? extends i.d.b<? extends T>> callable) {
        this.f14211b = callable;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        try {
            ((i.d.b) g.a.y0.b.b.a(this.f14211b.call(), "The publisher supplied is null")).subscribe(cVar);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.i.g.error(th, cVar);
        }
    }
}
