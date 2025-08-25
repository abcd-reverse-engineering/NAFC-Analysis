package h.g2;

import java.util.Iterator;

/* compiled from: Iterators.kt */
/* loaded from: classes2.dex */
public final class t0<T> implements Iterator<r0<? extends T>>, h.q2.t.q1.a {

    /* renamed from: a, reason: collision with root package name */
    private int f16195a;

    /* renamed from: b, reason: collision with root package name */
    private final Iterator<T> f16196b;

    /* JADX WARN: Multi-variable type inference failed */
    public t0(@i.c.a.d Iterator<? extends T> it) {
        h.q2.t.i0.f(it, "iterator");
        this.f16196b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f16196b.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    @i.c.a.d
    public final r0<T> next() {
        int i2 = this.f16195a;
        this.f16195a = i2 + 1;
        if (i2 < 0) {
            y.f();
        }
        return new r0<>(i2, this.f16196b.next());
    }
}
