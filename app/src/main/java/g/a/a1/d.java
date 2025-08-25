package g.a.a1;

import g.a.v;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DisposableMaybeObserver.java */
/* loaded from: classes2.dex */
public abstract class d<T> implements v<T>, g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<g.a.u0.c> f13628a = new AtomicReference<>();

    protected void a() {
    }

    @Override // g.a.u0.c
    public final void dispose() {
        g.a.y0.a.d.dispose(this.f13628a);
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return this.f13628a.get() == g.a.y0.a.d.DISPOSED;
    }

    @Override // g.a.v
    public final void onSubscribe(@g.a.t0.f g.a.u0.c cVar) {
        if (g.a.y0.j.i.a(this.f13628a, cVar, (Class<?>) d.class)) {
            a();
        }
    }
}
