package g.a.a1;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ResourceCompletableObserver.java */
/* loaded from: classes2.dex */
public abstract class h implements g.a.f, g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<g.a.u0.c> f13631a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final g.a.y0.a.i f13632b = new g.a.y0.a.i();

    protected void a() {
    }

    public final void a(@g.a.t0.f g.a.u0.c cVar) {
        g.a.y0.b.b.a(cVar, "resource is null");
        this.f13632b.b(cVar);
    }

    @Override // g.a.u0.c
    public final void dispose() {
        if (g.a.y0.a.d.dispose(this.f13631a)) {
            this.f13632b.dispose();
        }
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return g.a.y0.a.d.isDisposed(this.f13631a.get());
    }

    @Override // g.a.f
    public final void onSubscribe(@g.a.t0.f g.a.u0.c cVar) {
        if (g.a.y0.j.i.a(this.f13631a, cVar, (Class<?>) h.class)) {
            a();
        }
    }
}
