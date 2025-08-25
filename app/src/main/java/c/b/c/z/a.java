package c.b.c.z;

import java.util.Arrays;

/* compiled from: BitArray.java */
/* loaded from: classes.dex */
public final class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int[] f3000a;

    /* renamed from: b, reason: collision with root package name */
    private int f3001b;

    public a() {
        this.f3001b = 0;
        this.f3000a = new int[1];
    }

    private void f(int i2) {
        if (i2 > this.f3000a.length * 32) {
            int[] iArrG = g(i2);
            int[] iArr = this.f3000a;
            System.arraycopy(iArr, 0, iArrG, 0, iArr.length);
            this.f3000a = iArrG;
        }
    }

    private static int[] g(int i2) {
        return new int[(i2 + 31) / 32];
    }

    public void a(int i2) {
        int[] iArr = this.f3000a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) ^ iArr[i3];
    }

    public boolean b(int i2) {
        return ((1 << (i2 & 31)) & this.f3000a[i2 / 32]) != 0;
    }

    public int c() {
        return this.f3001b;
    }

    public int d() {
        return (this.f3001b + 7) / 8;
    }

    public void e(int i2) {
        int[] iArr = this.f3000a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f3001b == aVar.f3001b && Arrays.equals(this.f3000a, aVar.f3000a);
    }

    public int hashCode() {
        return (this.f3001b * 31) + Arrays.hashCode(this.f3000a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f3001b);
        for (int i2 = 0; i2 < this.f3001b; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(b(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void a() {
        int length = this.f3000a.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f3000a[i2] = 0;
        }
    }

    public void b(int i2, int i3) {
        this.f3000a[i2 / 32] = i3;
    }

    public int c(int i2) {
        int i3 = this.f3001b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & this.f3000a[i4];
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f3000a;
            if (i4 == iArr.length) {
                return this.f3001b;
            }
            i5 = iArr[i4];
        }
        int iNumberOfTrailingZeros = (i4 * 32) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f3001b;
        return iNumberOfTrailingZeros > i6 ? i6 : iNumberOfTrailingZeros;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public a m7clone() {
        return new a((int[]) this.f3000a.clone(), this.f3001b);
    }

    public int d(int i2) {
        int i3 = this.f3001b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & (~this.f3000a[i4]);
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f3000a;
            if (i4 == iArr.length) {
                return this.f3001b;
            }
            i5 = ~iArr[i4];
        }
        int iNumberOfTrailingZeros = (i4 * 32) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f3001b;
        return iNumberOfTrailingZeros > i6 ? i6 : iNumberOfTrailingZeros;
    }

    public void e() {
        int[] iArr = new int[this.f3000a.length];
        int i2 = (this.f3001b - 1) / 32;
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            long j2 = this.f3000a[i4];
            long j3 = ((j2 & 1431655765) << 1) | ((j2 >> 1) & 1431655765);
            long j4 = ((j3 & 858993459) << 2) | ((j3 >> 2) & 858993459);
            long j5 = ((j4 & 252645135) << 4) | ((j4 >> 4) & 252645135);
            long j6 = ((j5 & 16711935) << 8) | ((j5 >> 8) & 16711935);
            iArr[i2 - i4] = (int) (((j6 & 65535) << 16) | ((j6 >> 16) & 65535));
        }
        int i5 = this.f3001b;
        int i6 = i3 * 32;
        if (i5 != i6) {
            int i7 = i6 - i5;
            int i8 = 1;
            for (int i9 = 0; i9 < 31 - i7; i9++) {
                i8 = (i8 << 1) | 1;
            }
            int i10 = (iArr[0] >> i7) & i8;
            for (int i11 = 1; i11 < i3; i11++) {
                int i12 = iArr[i11];
                iArr[i11 - 1] = i10 | (i12 << (32 - i7));
                i10 = (i12 >> i7) & i8;
            }
            iArr[i3 - 1] = i10;
        }
        this.f3000a = iArr;
    }

    public void b(a aVar) {
        if (this.f3000a.length != aVar.f3000a.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.f3000a;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ aVar.f3000a[i2];
            i2++;
        }
    }

    public a(int i2) {
        this.f3001b = i2;
        this.f3000a = g(i2);
    }

    public boolean a(int i2, int i3, boolean z) {
        int i4;
        if (i3 < i2) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return true;
        }
        int i5 = i3 - 1;
        int i6 = i2 / 32;
        int i7 = i5 / 32;
        int i8 = i6;
        while (i8 <= i7) {
            int i9 = i8 > i6 ? 0 : i2 & 31;
            int i10 = i8 < i7 ? 31 : i5 & 31;
            if (i9 == 0 && i10 == 31) {
                i4 = -1;
            } else {
                i4 = 0;
                while (i9 <= i10) {
                    i4 |= 1 << i9;
                    i9++;
                }
            }
            int i11 = this.f3000a[i8] & i4;
            if (!z) {
                i4 = 0;
            }
            if (i11 != i4) {
                return false;
            }
            i8++;
        }
        return true;
    }

    a(int[] iArr, int i2) {
        this.f3000a = iArr;
        this.f3001b = i2;
    }

    public int[] b() {
        return this.f3000a;
    }

    public void a(boolean z) {
        f(this.f3001b + 1);
        if (z) {
            int[] iArr = this.f3000a;
            int i2 = this.f3001b;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.f3001b++;
    }

    public void c(int i2, int i3) {
        if (i3 < i2) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = 0;
            int i9 = i7 > i5 ? 0 : i2 & 31;
            int i10 = i7 < i6 ? 31 : i4 & 31;
            if (i9 == 0 && i10 == 31) {
                i8 = -1;
            } else {
                while (i9 <= i10) {
                    i8 |= 1 << i9;
                    i9++;
                }
            }
            int[] iArr = this.f3000a;
            iArr[i7] = i8 | iArr[i7];
            i7++;
        }
    }

    public void a(int i2, int i3) {
        if (i3 >= 0 && i3 <= 32) {
            f(this.f3001b + i3);
            while (i3 > 0) {
                boolean z = true;
                if (((i2 >> (i3 - 1)) & 1) != 1) {
                    z = false;
                }
                a(z);
                i3--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public void a(a aVar) {
        int i2 = aVar.f3001b;
        f(this.f3001b + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            a(aVar.b(i3));
        }
    }

    public void a(int i2, byte[] bArr, int i3, int i4) {
        int i5 = i2;
        int i6 = 0;
        while (i6 < i4) {
            int i7 = i5;
            int i8 = 0;
            for (int i9 = 0; i9 < 8; i9++) {
                if (b(i7)) {
                    i8 |= 1 << (7 - i9);
                }
                i7++;
            }
            bArr[i3 + i6] = (byte) i8;
            i6++;
            i5 = i7;
        }
    }
}
