package g.a.y0.d;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BasicIntQueueDisposable.java */
/* loaded from: classes2.dex */
public abstract class b<T> extends AtomicInteger implements g.a.y0.c.j<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // g.a.y0.c.o
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // g.a.y0.c.o
    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
