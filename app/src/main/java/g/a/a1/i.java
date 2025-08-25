package g.a.a1;

import g.a.v;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ResourceMaybeObserver.java */
/* loaded from: classes2.dex */
public abstract class i<T> implements v<T>, g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<g.a.u0.c> f13633a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final g.a.y0.a.i f13634b = new g.a.y0.a.i();

    protected void a() {
    }

    public final void a(@g.a.t0.f g.a.u0.c cVar) {
        g.a.y0.b.b.a(cVar, "resource is null");
        this.f13634b.b(cVar);
    }

    @Override // g.a.u0.c
    public final void dispose() {
        if (g.a.y0.a.d.dispose(this.f13633a)) {
            this.f13634b.dispose();
        }
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return g.a.y0.a.d.isDisposed(this.f13633a.get());
    }

    @Override // g.a.v
    public final void onSubscribe(@g.a.t0.f g.a.u0.c cVar) {
        if (g.a.y0.j.i.a(this.f13633a, cVar, (Class<?>) i.class)) {
            a();
        }
    }
}
