package c.b.c.z;

import java.util.Arrays;

/* compiled from: BitMatrix.java */
/* loaded from: classes.dex */
public final class b implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private final int f3002a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3003b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3004c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f3005d;

    public b(int i2) {
        this(i2, i2);
    }

    public static b b(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int length = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (length < str.length()) {
            if (str.charAt(length) == '\n' || str.charAt(length) == '\r') {
                if (i2 > i3) {
                    if (i4 == -1) {
                        i4 = i2 - i3;
                    } else if (i2 - i3 != i4) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i5++;
                    i3 = i2;
                }
                length++;
            } else {
                if (str.substring(length, str2.length() + length).equals(str2)) {
                    length += str2.length();
                    zArr[i2] = true;
                } else {
                    if (!str.substring(length, str3.length() + length).equals(str3)) {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(length));
                    }
                    length += str3.length();
                    zArr[i2] = false;
                }
                i2++;
            }
        }
        if (i2 > i3) {
            if (i4 == -1) {
                i4 = i2 - i3;
            } else if (i2 - i3 != i4) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i5++;
        }
        b bVar = new b(i4, i5);
        for (int i6 = 0; i6 < i2; i6++) {
            if (zArr[i6]) {
                bVar.c(i6 % i4, i6 / i4);
            }
        }
        return bVar;
    }

    public void a(int i2, int i3) {
        int i4 = (i3 * this.f3004c) + (i2 / 32);
        int[] iArr = this.f3005d;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    public void c(int i2, int i3) {
        int i4 = (i3 * this.f3004c) + (i2 / 32);
        int[] iArr = this.f3005d;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public void d(int i2, int i3) {
        int i4 = (i3 * this.f3004c) + (i2 / 32);
        int[] iArr = this.f3005d;
        iArr[i4] = (~(1 << (i2 & 31))) & iArr[i4];
    }

    public int e() {
        return this.f3004c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3002a == bVar.f3002a && this.f3003b == bVar.f3003b && this.f3004c == bVar.f3004c && Arrays.equals(this.f3005d, bVar.f3005d);
    }

    public int[] f() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f3005d;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        int[] iArr2 = this.f3005d;
        if (i2 == iArr2.length) {
            return null;
        }
        int i3 = this.f3004c;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) * 32;
        int i6 = iArr2[i2];
        int i7 = 0;
        while ((i6 << (31 - i7)) == 0) {
            i7++;
        }
        return new int[]{i5 + i7, i4};
    }

    public int g() {
        return this.f3002a;
    }

    public void h() {
        int iG = g();
        int iD = d();
        a aVar = new a(iG);
        a aVar2 = new a(iG);
        for (int i2 = 0; i2 < (iD + 1) / 2; i2++) {
            aVar = a(i2, aVar);
            int i3 = (iD - 1) - i2;
            aVar2 = a(i3, aVar2);
            aVar.e();
            aVar2.e();
            b(i2, aVar2);
            b(i3, aVar);
        }
    }

    public int hashCode() {
        int i2 = this.f3002a;
        return (((((((i2 * 31) + i2) * 31) + this.f3003b) * 31) + this.f3004c) * 31) + Arrays.hashCode(this.f3005d);
    }

    public String toString() {
        return a("X ", "  ");
    }

    public b(int i2, int i3) {
        if (i2 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f3002a = i2;
        this.f3003b = i3;
        this.f3004c = (i2 + 31) / 32;
        this.f3005d = new int[this.f3004c * i3];
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public b m8clone() {
        return new b(this.f3002a, this.f3003b, this.f3004c, (int[]) this.f3005d.clone());
    }

    public void a(b bVar) {
        if (this.f3002a == bVar.g() && this.f3003b == bVar.d() && this.f3004c == bVar.e()) {
            a aVar = new a((this.f3002a / 32) + 1);
            for (int i2 = 0; i2 < this.f3003b; i2++) {
                int i3 = this.f3004c * i2;
                int[] iArrB = bVar.a(i2, aVar).b();
                for (int i4 = 0; i4 < this.f3004c; i4++) {
                    int[] iArr = this.f3005d;
                    int i5 = i3 + i4;
                    iArr[i5] = iArr[i5] ^ iArrB[i4];
                }
            }
            return;
        }
        throw new IllegalArgumentException("input matrix dimensions do not match");
    }

    public int[] c() {
        int i2 = this.f3002a;
        int i3 = -1;
        int i4 = this.f3003b;
        int i5 = -1;
        int i6 = i2;
        int i7 = 0;
        while (i7 < this.f3003b) {
            int i8 = i5;
            int i9 = i3;
            int i10 = i6;
            int i11 = 0;
            while (true) {
                int i12 = this.f3004c;
                if (i11 < i12) {
                    int i13 = this.f3005d[(i12 * i7) + i11];
                    if (i13 != 0) {
                        if (i7 < i4) {
                            i4 = i7;
                        }
                        if (i7 > i8) {
                            i8 = i7;
                        }
                        int i14 = i11 * 32;
                        int i15 = 31;
                        if (i14 < i10) {
                            int i16 = 0;
                            while ((i13 << (31 - i16)) == 0) {
                                i16++;
                            }
                            int i17 = i16 + i14;
                            if (i17 < i10) {
                                i10 = i17;
                            }
                        }
                        if (i14 + 31 > i9) {
                            while ((i13 >>> i15) == 0) {
                                i15--;
                            }
                            int i18 = i14 + i15;
                            if (i18 > i9) {
                                i9 = i18;
                            }
                        }
                    }
                    i11++;
                }
            }
            i7++;
            i6 = i10;
            i3 = i9;
            i5 = i8;
        }
        int i19 = i3 - i6;
        int i20 = i5 - i4;
        if (i19 < 0 || i20 < 0) {
            return null;
        }
        return new int[]{i6, i4, i19, i20};
    }

    public int d() {
        return this.f3003b;
    }

    private b(int i2, int i3, int i4, int[] iArr) {
        this.f3002a = i2;
        this.f3003b = i3;
        this.f3004c = i4;
        this.f3005d = iArr;
    }

    public void a() {
        int length = this.f3005d.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f3005d[i2] = 0;
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i5 >= 1 && i4 >= 1) {
            int i6 = i4 + i2;
            int i7 = i5 + i3;
            if (i7 > this.f3003b || i6 > this.f3002a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i3 < i7) {
                int i8 = this.f3004c * i3;
                for (int i9 = i2; i9 < i6; i9++) {
                    int[] iArr = this.f3005d;
                    int i10 = (i9 / 32) + i8;
                    iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                }
                i3++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }

    public boolean b(int i2, int i3) {
        return ((this.f3005d[(i3 * this.f3004c) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0;
    }

    public a a(int i2, a aVar) {
        if (aVar != null && aVar.c() >= this.f3002a) {
            aVar.a();
        } else {
            aVar = new a(this.f3002a);
        }
        int i3 = i2 * this.f3004c;
        for (int i4 = 0; i4 < this.f3004c; i4++) {
            aVar.b(i4 * 32, this.f3005d[i3 + i4]);
        }
        return aVar;
    }

    public void b(int i2, a aVar) {
        int[] iArrB = aVar.b();
        int[] iArr = this.f3005d;
        int i3 = this.f3004c;
        System.arraycopy(iArrB, 0, iArr, i2 * i3, i3);
    }

    public int[] b() {
        int length = this.f3005d.length - 1;
        while (length >= 0 && this.f3005d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i2 = this.f3004c;
        int i3 = length / i2;
        int i4 = (length % i2) * 32;
        int i5 = 31;
        while ((this.f3005d[length] >>> i5) == 0) {
            i5--;
        }
        return new int[]{i4 + i5, i3};
    }

    public String a(String str, String str2) {
        return a(str, str2, "\n");
    }

    @Deprecated
    public String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f3003b * (this.f3002a + 1));
        for (int i2 = 0; i2 < this.f3003b; i2++) {
            for (int i3 = 0; i3 < this.f3002a; i3++) {
                sb.append(b(i3, i2) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }
}
