package g.a.y0.a;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CancellableDisposable.java */
/* loaded from: classes2.dex */
public final class b extends AtomicReference<g.a.x0.f> implements g.a.u0.c {
    private static final long serialVersionUID = 5718521705281392066L;

    public b(g.a.x0.f fVar) {
        super(fVar);
    }

    @Override // g.a.u0.c
    public void dispose() {
        g.a.x0.f andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e2) {
            g.a.v0.b.b(e2);
            g.a.c1.a.b(e2);
        }
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return get() == null;
    }
}
