package h.q2.t;

import java.util.NoSuchElementException;

/* compiled from: ArrayIterators.kt */
/* loaded from: classes2.dex */
final class a extends h.g2.t {

    /* renamed from: a, reason: collision with root package name */
    private int f16369a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean[] f16370b;

    public a(@i.c.a.d boolean[] zArr) {
        i0.f(zArr, "array");
        this.f16370b = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16369a < this.f16370b.length;
    }

    @Override // h.g2.t
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f16370b;
            int i2 = this.f16369a;
            this.f16369a = i2 + 1;
            return zArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f16369a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
