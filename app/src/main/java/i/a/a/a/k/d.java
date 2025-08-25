package i.a.a.a.k;

import com.umeng.analytics.pro.cw;
import java.math.BigInteger;
import okio.Utf8;

/* compiled from: Base64.java */
/* loaded from: classes2.dex */
public class d extends g {
    static final byte[] A = {cw.f10301k, 10};
    private static final byte[] B = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] C = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] D = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, cw.f10301k, cw.f10302l, cw.f10303m, cw.n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private static final int E = 63;
    private static final int x = 6;
    private static final int y = 3;
    private static final int z = 4;
    private final byte[] r;
    private final byte[] s;
    private final byte[] t;
    private final int u;
    private final int v;
    private int w;

    public d() {
        this(0);
    }

    public static boolean c(byte b2) {
        if (b2 != 61) {
            if (b2 >= 0) {
                byte[] bArr = D;
                if (b2 >= bArr.length || bArr[b2] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    public static byte[] e(byte[] bArr) {
        return new d().decode(bArr);
    }

    public static BigInteger f(byte[] bArr) {
        return new BigInteger(1, e(bArr));
    }

    public static byte[] g(byte[] bArr) {
        return b(bArr, false);
    }

    public static byte[] h(byte[] bArr) {
        return b(bArr, true);
    }

    public static String i(byte[] bArr) {
        return l.f(b(bArr, false));
    }

    public static byte[] j(byte[] bArr) {
        return a(bArr, false, true);
    }

    public static String k(byte[] bArr) {
        return l.f(a(bArr, false, true));
    }

    public static boolean l(byte[] bArr) {
        return m(bArr);
    }

    public static boolean m(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!c(bArr[i2]) && !g.b(bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // i.a.a.a.k.g
    void a(byte[] bArr, int i2, int i3) {
        byte b2;
        if (this.f16746i) {
            return;
        }
        if (i3 < 0) {
            this.f16746i = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            a(this.u);
            int i5 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 == 61) {
                this.f16746i = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = D;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    this.f16748k = (this.f16748k + 1) % 4;
                    this.w = (this.w << 6) + b2;
                    if (this.f16748k == 0) {
                        byte[] bArr3 = this.f16743f;
                        int i6 = this.f16744g;
                        this.f16744g = i6 + 1;
                        int i7 = this.w;
                        bArr3[i6] = (byte) ((i7 >> 16) & 255);
                        int i8 = this.f16744g;
                        this.f16744g = i8 + 1;
                        bArr3[i8] = (byte) ((i7 >> 8) & 255);
                        int i9 = this.f16744g;
                        this.f16744g = i9 + 1;
                        bArr3[i9] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!this.f16746i || this.f16748k == 0) {
            return;
        }
        a(this.u);
        int i10 = this.f16748k;
        if (i10 == 2) {
            this.w >>= 4;
            byte[] bArr4 = this.f16743f;
            int i11 = this.f16744g;
            this.f16744g = i11 + 1;
            bArr4[i11] = (byte) (this.w & 255);
            return;
        }
        if (i10 != 3) {
            return;
        }
        this.w >>= 2;
        byte[] bArr5 = this.f16743f;
        int i12 = this.f16744g;
        this.f16744g = i12 + 1;
        int i13 = this.w;
        bArr5[i12] = (byte) ((i13 >> 8) & 255);
        int i14 = this.f16744g;
        this.f16744g = i14 + 1;
        bArr5[i14] = (byte) (i13 & 255);
    }

    @Override // i.a.a.a.k.g
    void b(byte[] bArr, int i2, int i3) {
        if (this.f16746i) {
            return;
        }
        if (i3 >= 0) {
            int i4 = i2;
            int i5 = 0;
            while (i5 < i3) {
                a(this.v);
                this.f16748k = (this.f16748k + 1) % 3;
                int i6 = i4 + 1;
                int i7 = bArr[i4];
                if (i7 < 0) {
                    i7 += 256;
                }
                this.w = (this.w << 8) + i7;
                if (this.f16748k == 0) {
                    byte[] bArr2 = this.f16743f;
                    int i8 = this.f16744g;
                    this.f16744g = i8 + 1;
                    byte[] bArr3 = this.r;
                    int i9 = this.w;
                    bArr2[i8] = bArr3[(i9 >> 18) & 63];
                    int i10 = this.f16744g;
                    this.f16744g = i10 + 1;
                    bArr2[i10] = bArr3[(i9 >> 12) & 63];
                    int i11 = this.f16744g;
                    this.f16744g = i11 + 1;
                    bArr2[i11] = bArr3[(i9 >> 6) & 63];
                    int i12 = this.f16744g;
                    this.f16744g = i12 + 1;
                    bArr2[i12] = bArr3[i9 & 63];
                    this.f16747j += 4;
                    int i13 = this.f16741d;
                    if (i13 > 0 && i13 <= this.f16747j) {
                        byte[] bArr4 = this.t;
                        System.arraycopy(bArr4, 0, bArr2, this.f16744g, bArr4.length);
                        this.f16744g += this.t.length;
                        this.f16747j = 0;
                    }
                }
                i5++;
                i4 = i6;
            }
            return;
        }
        this.f16746i = true;
        if (this.f16748k == 0 && this.f16741d == 0) {
            return;
        }
        a(this.v);
        int i14 = this.f16744g;
        int i15 = this.f16748k;
        if (i15 == 1) {
            byte[] bArr5 = this.f16743f;
            this.f16744g = i14 + 1;
            byte[] bArr6 = this.r;
            int i16 = this.w;
            bArr5[i14] = bArr6[(i16 >> 2) & 63];
            int i17 = this.f16744g;
            this.f16744g = i17 + 1;
            bArr5[i17] = bArr6[(i16 << 4) & 63];
            if (bArr6 == B) {
                int i18 = this.f16744g;
                this.f16744g = i18 + 1;
                bArr5[i18] = 61;
                int i19 = this.f16744g;
                this.f16744g = i19 + 1;
                bArr5[i19] = 61;
            }
        } else if (i15 == 2) {
            byte[] bArr7 = this.f16743f;
            this.f16744g = i14 + 1;
            byte[] bArr8 = this.r;
            int i20 = this.w;
            bArr7[i14] = bArr8[(i20 >> 10) & 63];
            int i21 = this.f16744g;
            this.f16744g = i21 + 1;
            bArr7[i21] = bArr8[(i20 >> 4) & 63];
            int i22 = this.f16744g;
            this.f16744g = i22 + 1;
            bArr7[i22] = bArr8[(i20 << 2) & 63];
            if (bArr8 == B) {
                int i23 = this.f16744g;
                this.f16744g = i23 + 1;
                bArr7[i23] = 61;
            }
        }
        int i24 = this.f16747j;
        int i25 = this.f16744g;
        this.f16747j = i24 + (i25 - i14);
        if (this.f16741d <= 0 || this.f16747j <= 0) {
            return;
        }
        byte[] bArr9 = this.t;
        System.arraycopy(bArr9, 0, this.f16743f, i25, bArr9.length);
        this.f16744g += this.t.length;
    }

    public boolean d() {
        return this.r == C;
    }

    public d(boolean z2) {
        this(76, A, z2);
    }

    public static byte[] c(String str) {
        return new d().a(str);
    }

    public static boolean d(String str) {
        return m(l.f(str));
    }

    public d(int i2) {
        this(i2, A);
    }

    public d(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    public d(int i2, byte[] bArr, boolean z2) {
        super(3, 4, i2, bArr == null ? 0 : bArr.length);
        this.s = D;
        if (bArr != null) {
            if (a(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + l.f(bArr) + "]");
            }
            if (i2 > 0) {
                this.v = bArr.length + 4;
                this.t = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.t, 0, bArr.length);
            } else {
                this.v = 4;
                this.t = null;
            }
        } else {
            this.v = 4;
            this.t = null;
        }
        this.u = this.v - 1;
        this.r = z2 ? C : B;
    }

    public static byte[] a(byte[] bArr, boolean z2, boolean z3) {
        return a(bArr, z2, z3, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z2, boolean z3, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        d dVar = z2 ? new d(z3) : new d(0, A, z3);
        long jD = dVar.d(bArr);
        if (jD <= i2) {
            return dVar.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + jD + ") than the specified maximum size of " + i2);
    }

    public static byte[] a(BigInteger bigInteger) {
        if (bigInteger != null) {
            return b(b(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    @Override // i.a.a.a.k.g
    protected boolean a(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.s;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }

    public static byte[] b(byte[] bArr, boolean z2) {
        return a(bArr, z2, false);
    }

    static byte[] b(BigInteger bigInteger) {
        int iBitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == iBitLength / 8) {
            return byteArray;
        }
        int i2 = 0;
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
            i2 = 1;
        }
        int i3 = iBitLength / 8;
        int i4 = i3 - length;
        byte[] bArr = new byte[i3];
        System.arraycopy(byteArray, i2, bArr, i4, length);
        return bArr;
    }
}
