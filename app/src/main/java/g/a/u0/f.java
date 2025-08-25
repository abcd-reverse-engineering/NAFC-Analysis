package g.a.u0;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ReferenceDisposable.java */
/* loaded from: classes2.dex */
abstract class f<T> extends AtomicReference<T> implements c {
    private static final long serialVersionUID = 6537757548749041217L;

    f(T t) {
        super(g.a.y0.b.b.a((Object) t, "value is null"));
    }

    @Override // g.a.u0.c
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        onDisposed(andSet);
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return get() == null;
    }

    protected abstract void onDisposed(@g.a.t0.f T t);
}
