package h.q2.t;

import java.util.NoSuchElementException;

/* compiled from: ArrayIterators.kt */
/* loaded from: classes2.dex */
final class f extends h.g2.u0 {

    /* renamed from: a, reason: collision with root package name */
    private int f16380a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f16381b;

    public f(@i.c.a.d int[] iArr) {
        i0.f(iArr, "array");
        this.f16381b = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16380a < this.f16381b.length;
    }

    @Override // h.g2.u0
    public int nextInt() {
        try {
            int[] iArr = this.f16381b;
            int i2 = this.f16380a;
            this.f16380a = i2 + 1;
            return iArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f16380a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
