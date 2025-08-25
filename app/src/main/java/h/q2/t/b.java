package h.q2.t;

import java.util.NoSuchElementException;

/* compiled from: ArrayIterators.kt */
/* loaded from: classes2.dex */
final class b extends h.g2.u {

    /* renamed from: a, reason: collision with root package name */
    private int f16372a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f16373b;

    public b(@i.c.a.d byte[] bArr) {
        i0.f(bArr, "array");
        this.f16373b = bArr;
    }

    @Override // h.g2.u
    public byte b() {
        try {
            byte[] bArr = this.f16373b;
            int i2 = this.f16372a;
            this.f16372a = i2 + 1;
            return bArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f16372a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16372a < this.f16373b.length;
    }
}
