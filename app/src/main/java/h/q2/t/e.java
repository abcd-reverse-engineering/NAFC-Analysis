package h.q2.t;

import java.util.NoSuchElementException;

/* compiled from: ArrayIterators.kt */
/* loaded from: classes2.dex */
final class e extends h.g2.m0 {

    /* renamed from: a, reason: collision with root package name */
    private int f16378a;

    /* renamed from: b, reason: collision with root package name */
    private final float[] f16379b;

    public e(@i.c.a.d float[] fArr) {
        i0.f(fArr, "array");
        this.f16379b = fArr;
    }

    @Override // h.g2.m0
    public float b() {
        try {
            float[] fArr = this.f16379b;
            int i2 = this.f16378a;
            this.f16378a = i2 + 1;
            return fArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f16378a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16378a < this.f16379b.length;
    }
}
