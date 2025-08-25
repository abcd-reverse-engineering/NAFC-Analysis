package h.q2.t;

import java.util.NoSuchElementException;

/* compiled from: ArrayIterators.kt */
/* loaded from: classes2.dex */
final class d extends h.g2.h0 {

    /* renamed from: a, reason: collision with root package name */
    private int f16376a;

    /* renamed from: b, reason: collision with root package name */
    private final double[] f16377b;

    public d(@i.c.a.d double[] dArr) {
        i0.f(dArr, "array");
        this.f16377b = dArr;
    }

    @Override // h.g2.h0
    public double b() {
        try {
            double[] dArr = this.f16377b;
            int i2 = this.f16376a;
            this.f16376a = i2 + 1;
            return dArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f16376a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16376a < this.f16377b.length;
    }
}
