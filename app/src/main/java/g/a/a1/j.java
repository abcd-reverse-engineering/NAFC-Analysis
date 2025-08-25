package g.a.a1;

import g.a.i0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ResourceObserver.java */
/* loaded from: classes2.dex */
public abstract class j<T> implements i0<T>, g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<g.a.u0.c> f13635a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final g.a.y0.a.i f13636b = new g.a.y0.a.i();

    protected void a() {
    }

    public final void a(@g.a.t0.f g.a.u0.c cVar) {
        g.a.y0.b.b.a(cVar, "resource is null");
        this.f13636b.b(cVar);
    }

    @Override // g.a.u0.c
    public final void dispose() {
        if (g.a.y0.a.d.dispose(this.f13635a)) {
            this.f13636b.dispose();
        }
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return g.a.y0.a.d.isDisposed(this.f13635a.get());
    }

    @Override // g.a.i0
    public final void onSubscribe(g.a.u0.c cVar) {
        if (g.a.y0.j.i.a(this.f13635a, cVar, (Class<?>) j.class)) {
            a();
        }
    }
}
