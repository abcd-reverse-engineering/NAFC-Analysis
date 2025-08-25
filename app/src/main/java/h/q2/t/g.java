package h.q2.t;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes2.dex */
final class g<T> implements Iterator<T>, h.q2.t.q1.a {

    /* renamed from: a, reason: collision with root package name */
    private int f16382a;

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.d
    private final T[] f16383b;

    public g(@i.c.a.d T[] tArr) {
        i0.f(tArr, "array");
        this.f16383b = tArr;
    }

    @i.c.a.d
    public final T[] b() {
        return this.f16383b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16382a < this.f16383b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f16383b;
            int i2 = this.f16382a;
            this.f16382a = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f16382a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
