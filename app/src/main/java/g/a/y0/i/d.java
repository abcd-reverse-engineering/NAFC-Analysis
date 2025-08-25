package g.a.y0.i;

import g.a.y0.c.l;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BasicQueueSubscription.java */
/* loaded from: classes2.dex */
public abstract class d<T> extends AtomicLong implements l<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    @Override // g.a.y0.c.o
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // g.a.y0.c.o
    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
