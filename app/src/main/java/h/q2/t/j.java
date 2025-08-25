package h.q2.t;

import java.util.NoSuchElementException;

/* compiled from: ArrayIterators.kt */
/* loaded from: classes2.dex */
final class j extends h.g2.v0 {

    /* renamed from: a, reason: collision with root package name */
    private int f16394a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f16395b;

    public j(@i.c.a.d long[] jArr) {
        i0.f(jArr, "array");
        this.f16395b = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16394a < this.f16395b.length;
    }

    @Override // h.g2.v0
    public long nextLong() {
        try {
            long[] jArr = this.f16395b;
            int i2 = this.f16394a;
            this.f16394a = i2 + 1;
            return jArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f16394a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
