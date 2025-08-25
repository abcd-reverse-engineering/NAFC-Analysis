package h.q2.t;

import java.util.NoSuchElementException;

/* compiled from: ArrayIterators.kt */
/* loaded from: classes2.dex */
final class k extends h.g2.o1 {

    /* renamed from: a, reason: collision with root package name */
    private int f16401a;

    /* renamed from: b, reason: collision with root package name */
    private final short[] f16402b;

    public k(@i.c.a.d short[] sArr) {
        i0.f(sArr, "array");
        this.f16402b = sArr;
    }

    @Override // h.g2.o1
    public short b() {
        try {
            short[] sArr = this.f16402b;
            int i2 = this.f16401a;
            this.f16401a = i2 + 1;
            return sArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f16401a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16401a < this.f16402b.length;
    }
}
