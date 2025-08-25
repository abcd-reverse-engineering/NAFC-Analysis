package g.a.g1;

import g.a.q;
import g.a.y0.a.i;
import g.a.y0.i.j;
import h.q2.t.m0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ResourceSubscriber.java */
/* loaded from: classes2.dex */
public abstract class c<T> implements q<T>, g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<i.d.d> f13817a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final i f13818b = new i();

    /* renamed from: c, reason: collision with root package name */
    private final AtomicLong f13819c = new AtomicLong();

    public final void a(g.a.u0.c cVar) {
        g.a.y0.b.b.a(cVar, "resource is null");
        this.f13818b.b(cVar);
    }

    @Override // g.a.u0.c
    public final void dispose() {
        if (j.cancel(this.f13817a)) {
            this.f13818b.dispose();
        }
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return j.isCancelled(this.f13817a.get());
    }

    @Override // g.a.q
    public final void onSubscribe(i.d.d dVar) {
        if (g.a.y0.j.i.a(this.f13817a, dVar, (Class<?>) c.class)) {
            long andSet = this.f13819c.getAndSet(0L);
            if (andSet != 0) {
                dVar.request(andSet);
            }
            a();
        }
    }

    protected void a() {
        a(m0.f16408b);
    }

    protected final void a(long j2) {
        j.deferredRequest(this.f13817a, this.f13819c, j2);
    }
}
