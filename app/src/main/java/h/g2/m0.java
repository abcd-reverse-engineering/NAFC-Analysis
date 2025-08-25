package h.g2;

import java.util.Iterator;

/* compiled from: Iterators.kt */
/* loaded from: classes2.dex */
public abstract class m0 implements Iterator<Float>, h.q2.t.q1.a {
    public abstract float b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @i.c.a.d
    public final Float next() {
        return Float.valueOf(b());
    }
}
