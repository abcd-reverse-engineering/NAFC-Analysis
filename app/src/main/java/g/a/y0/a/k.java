package g.a.y0.a;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SequentialDisposable.java */
/* loaded from: classes2.dex */
public final class k extends AtomicReference<g.a.u0.c> implements g.a.u0.c {
    private static final long serialVersionUID = -754898800686245608L;

    public k() {
    }

    @Override // g.a.u0.c
    public void dispose() {
        d.dispose(this);
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return d.isDisposed(get());
    }

    public boolean replace(g.a.u0.c cVar) {
        return d.replace(this, cVar);
    }

    public boolean update(g.a.u0.c cVar) {
        return d.set(this, cVar);
    }

    public k(g.a.u0.c cVar) {
        lazySet(cVar);
    }
}
