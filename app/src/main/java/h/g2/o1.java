package h.g2;

import java.util.Iterator;

/* compiled from: Iterators.kt */
/* loaded from: classes2.dex */
public abstract class o1 implements Iterator<Short>, h.q2.t.q1.a {
    public abstract short b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    @i.c.a.d
    public final Short next() {
        return Short.valueOf(b());
    }
}
