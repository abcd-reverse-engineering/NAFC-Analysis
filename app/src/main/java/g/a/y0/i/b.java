package g.a.y0.i;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AsyncSubscription.java */
/* loaded from: classes2.dex */
public final class b extends AtomicLong implements i.d.d, g.a.u0.c {
    private static final long serialVersionUID = 7028635084060361255L;
    final AtomicReference<i.d.d> actual;
    final AtomicReference<g.a.u0.c> resource;

    public b() {
        this.resource = new AtomicReference<>();
        this.actual = new AtomicReference<>();
    }

    @Override // i.d.d
    public void cancel() {
        dispose();
    }

    @Override // g.a.u0.c
    public void dispose() {
        j.cancel(this.actual);
        g.a.y0.a.d.dispose(this.resource);
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return this.actual.get() == j.CANCELLED;
    }

    public boolean replaceResource(g.a.u0.c cVar) {
        return g.a.y0.a.d.replace(this.resource, cVar);
    }

    @Override // i.d.d
    public void request(long j2) {
        j.deferredRequest(this.actual, this, j2);
    }

    public boolean setResource(g.a.u0.c cVar) {
        return g.a.y0.a.d.set(this.resource, cVar);
    }

    public void setSubscription(i.d.d dVar) {
        j.deferredSetOnce(this.actual, this, dVar);
    }

    public b(g.a.u0.c cVar) {
        this();
        this.resource.lazySet(cVar);
    }
}
