package g.a.a1;

import g.a.i0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DisposableObserver.java */
/* loaded from: classes2.dex */
public abstract class e<T> implements i0<T>, g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<g.a.u0.c> f13629a = new AtomicReference<>();

    protected void a() {
    }

    @Override // g.a.u0.c
    public final void dispose() {
        g.a.y0.a.d.dispose(this.f13629a);
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return this.f13629a.get() == g.a.y0.a.d.DISPOSED;
    }

    @Override // g.a.i0
    public final void onSubscribe(@g.a.t0.f g.a.u0.c cVar) {
        if (g.a.y0.j.i.a(this.f13629a, cVar, getClass())) {
            a();
        }
    }
}
