package g.a.a1;

import g.a.n0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ResourceSingleObserver.java */
/* loaded from: classes2.dex */
public abstract class k<T> implements n0<T>, g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<g.a.u0.c> f13637a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final g.a.y0.a.i f13638b = new g.a.y0.a.i();

    protected void a() {
    }

    public final void a(@g.a.t0.f g.a.u0.c cVar) {
        g.a.y0.b.b.a(cVar, "resource is null");
        this.f13638b.b(cVar);
    }

    @Override // g.a.u0.c
    public final void dispose() {
        if (g.a.y0.a.d.dispose(this.f13637a)) {
            this.f13638b.dispose();
        }
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return g.a.y0.a.d.isDisposed(this.f13637a.get());
    }

    @Override // g.a.n0
    public final void onSubscribe(@g.a.t0.f g.a.u0.c cVar) {
        if (g.a.y0.j.i.a(this.f13637a, cVar, (Class<?>) k.class)) {
            a();
        }
    }
}
