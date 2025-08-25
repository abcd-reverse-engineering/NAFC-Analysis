package h.g2;

import java.util.Iterator;

/* compiled from: UIterators.kt */
@h.t0(version = "1.3")
@h.k
/* loaded from: classes2.dex */
public abstract class u1 implements Iterator<h.f1>, h.q2.t.q1.a {
    public abstract byte b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @i.c.a.d
    public final h.f1 next() {
        return h.f1.a(b());
    }
}
