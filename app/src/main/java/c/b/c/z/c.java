package c.b.c.z;

import h.f1;

/* compiled from: BitSource.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f3006a;

    /* renamed from: b, reason: collision with root package name */
    private int f3007b;

    /* renamed from: c, reason: collision with root package name */
    private int f3008c;

    public c(byte[] bArr) {
        this.f3006a = bArr;
    }

    public int a(int i2) {
        int i3;
        if (i2 < 1 || i2 > 32 || i2 > a()) {
            throw new IllegalArgumentException(String.valueOf(i2));
        }
        int i4 = this.f3008c;
        if (i4 > 0) {
            int i5 = 8 - i4;
            int i6 = i2 < i5 ? i2 : i5;
            int i7 = i5 - i6;
            byte[] bArr = this.f3006a;
            int i8 = this.f3007b;
            i3 = (((255 >> (8 - i6)) << i7) & bArr[i8]) >> i7;
            i2 -= i6;
            this.f3008c += i6;
            if (this.f3008c == 8) {
                this.f3008c = 0;
                this.f3007b = i8 + 1;
            }
        } else {
            i3 = 0;
        }
        if (i2 <= 0) {
            return i3;
        }
        while (i2 >= 8) {
            byte[] bArr2 = this.f3006a;
            int i9 = this.f3007b;
            i3 = (i3 << 8) | (bArr2[i9] & f1.f16099c);
            this.f3007b = i9 + 1;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return i3;
        }
        int i10 = 8 - i2;
        int i11 = (i3 << i2) | ((((255 >> i10) << i10) & this.f3006a[this.f3007b]) >> i10);
        this.f3008c += i2;
        return i11;
    }

    public int b() {
        return this.f3008c;
    }

    public int c() {
        return this.f3007b;
    }

    public int a() {
        return ((this.f3006a.length - this.f3007b) * 8) - this.f3008c;
    }
}
