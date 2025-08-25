package h.g2;

import java.util.Iterator;

/* compiled from: Iterators.kt */
/* loaded from: classes2.dex */
public abstract class u implements Iterator<Byte>, h.q2.t.q1.a {
    public abstract byte b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @i.c.a.d
    public final Byte next() {
        return Byte.valueOf(b());
    }
}
