package com.heytap.mcssdk.b;

import com.umeng.analytics.pro.cw;
import i.a.a.a.k.l;
import java.math.BigInteger;
import okio.Utf8;

/* loaded from: classes.dex */
public class a extends b {
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

    public a() {
        this(0);
    }

    public a(int i2) {
        this(i2, A);
    }

    public a(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(int r5, byte[] r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L5
            r1 = 0
            goto L6
        L5:
            int r1 = r6.length
        L6:
            r2 = 4
            r3 = 3
            r4.<init>(r3, r2, r5, r1)
            byte[] r1 = com.heytap.mcssdk.b.a.D
            r4.s = r1
            r1 = 0
            if (r6 == 0) goto L4a
            boolean r3 = r4.c(r6)
            if (r3 != 0) goto L2a
            if (r5 <= 0) goto L4a
            int r5 = r6.length
            int r5 = r5 + r2
            r4.v = r5
            int r5 = r6.length
            byte[] r5 = new byte[r5]
            r4.t = r5
            byte[] r5 = r4.t
            int r1 = r6.length
            java.lang.System.arraycopy(r6, r0, r5, r0, r1)
            goto L4e
        L2a:
            java.lang.String r5 = i.a.a.a.k.l.f(r6)
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "lineSeparator must not contain base64 characters: ["
            r7.append(r0)
            r7.append(r5)
            java.lang.String r5 = "]"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        L4a:
            r4.v = r2
            r4.t = r1
        L4e:
            int r5 = r4.v
            int r5 = r5 + (-1)
            r4.u = r5
            if (r7 == 0) goto L59
            byte[] r5 = com.heytap.mcssdk.b.a.C
            goto L5b
        L59:
            byte[] r5 = com.heytap.mcssdk.b.a.B
        L5b:
            r4.r = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.mcssdk.b.a.<init>(int, byte[], boolean):void");
    }

    public a(boolean z2) {
        this(76, A, z2);
    }

    public static byte[] a(BigInteger bigInteger) {
        if (bigInteger != null) {
            return b(b(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    public static byte[] a(byte[] bArr, boolean z2, boolean z3) {
        return a(bArr, z2, z3, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z2, boolean z3, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = z2 ? new a(z3) : new a(0, A, z3);
        long jD = aVar.d(bArr);
        if (jD <= i2) {
            return aVar.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + jD + ") than the specified maximum size of " + i2);
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

    public static byte[] b(byte[] bArr, boolean z2) {
        return a(bArr, z2, false);
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

    public static boolean c(String str) {
        return f(l.f(str));
    }

    public static byte[] d(String str) {
        return new a().a(str);
    }

    public static boolean e(byte[] bArr) {
        return f(bArr);
    }

    public static boolean f(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!c(bArr[i2]) && !b.b(bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public static byte[] g(byte[] bArr) {
        return b(bArr, false);
    }

    public static String h(byte[] bArr) {
        return l.f(b(bArr, false));
    }

    public static byte[] i(byte[] bArr) {
        return a(bArr, false, true);
    }

    public static String j(byte[] bArr) {
        return l.f(a(bArr, false, true));
    }

    public static byte[] k(byte[] bArr) {
        return b(bArr, true);
    }

    public static byte[] l(byte[] bArr) {
        return new a().decode(bArr);
    }

    public static BigInteger m(byte[] bArr) {
        return new BigInteger(1, l(bArr));
    }

    @Override // com.heytap.mcssdk.b.b
    void a(byte[] bArr, int i2, int i3) {
        if (this.f5787i) {
            return;
        }
        if (i3 >= 0) {
            int i4 = i2;
            int i5 = 0;
            while (i5 < i3) {
                a(this.v);
                this.f5789k = (this.f5789k + 1) % 3;
                int i6 = i4 + 1;
                int i7 = bArr[i4];
                if (i7 < 0) {
                    i7 += 256;
                }
                this.w = (this.w << 8) + i7;
                if (this.f5789k == 0) {
                    byte[] bArr2 = this.f5784f;
                    int i8 = this.f5785g;
                    this.f5785g = i8 + 1;
                    byte[] bArr3 = this.r;
                    int i9 = this.w;
                    bArr2[i8] = bArr3[(i9 >> 18) & 63];
                    int i10 = this.f5785g;
                    this.f5785g = i10 + 1;
                    bArr2[i10] = bArr3[(i9 >> 12) & 63];
                    int i11 = this.f5785g;
                    this.f5785g = i11 + 1;
                    bArr2[i11] = bArr3[(i9 >> 6) & 63];
                    int i12 = this.f5785g;
                    this.f5785g = i12 + 1;
                    bArr2[i12] = bArr3[i9 & 63];
                    this.f5788j += 4;
                    int i13 = this.f5782d;
                    if (i13 > 0 && i13 <= this.f5788j) {
                        byte[] bArr4 = this.t;
                        System.arraycopy(bArr4, 0, bArr2, this.f5785g, bArr4.length);
                        this.f5785g += this.t.length;
                        this.f5788j = 0;
                    }
                }
                i5++;
                i4 = i6;
            }
            return;
        }
        this.f5787i = true;
        if (this.f5789k == 0 && this.f5782d == 0) {
            return;
        }
        a(this.v);
        int i14 = this.f5785g;
        int i15 = this.f5789k;
        if (i15 == 1) {
            byte[] bArr5 = this.f5784f;
            this.f5785g = i14 + 1;
            byte[] bArr6 = this.r;
            int i16 = this.w;
            bArr5[i14] = bArr6[(i16 >> 2) & 63];
            int i17 = this.f5785g;
            this.f5785g = i17 + 1;
            bArr5[i17] = bArr6[(i16 << 4) & 63];
            if (bArr6 == B) {
                int i18 = this.f5785g;
                this.f5785g = i18 + 1;
                bArr5[i18] = 61;
                int i19 = this.f5785g;
                this.f5785g = i19 + 1;
                bArr5[i19] = 61;
            }
        } else if (i15 == 2) {
            byte[] bArr7 = this.f5784f;
            this.f5785g = i14 + 1;
            byte[] bArr8 = this.r;
            int i20 = this.w;
            bArr7[i14] = bArr8[(i20 >> 10) & 63];
            int i21 = this.f5785g;
            this.f5785g = i21 + 1;
            bArr7[i21] = bArr8[(i20 >> 4) & 63];
            int i22 = this.f5785g;
            this.f5785g = i22 + 1;
            bArr7[i22] = bArr8[(i20 << 2) & 63];
            if (bArr8 == B) {
                int i23 = this.f5785g;
                this.f5785g = i23 + 1;
                bArr7[i23] = 61;
            }
        }
        int i24 = this.f5788j;
        int i25 = this.f5785g;
        this.f5788j = i24 + (i25 - i14);
        if (this.f5782d <= 0 || this.f5788j <= 0) {
            return;
        }
        byte[] bArr9 = this.t;
        System.arraycopy(bArr9, 0, this.f5784f, i25, bArr9.length);
        this.f5785g += this.t.length;
    }

    @Override // com.heytap.mcssdk.b.b
    protected boolean a(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.s;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.heytap.mcssdk.b.b
    void b(byte[] bArr, int i2, int i3) {
        byte b2;
        if (this.f5787i) {
            return;
        }
        if (i3 < 0) {
            this.f5787i = true;
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
                this.f5787i = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = D;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    this.f5789k = (this.f5789k + 1) % 4;
                    this.w = (this.w << 6) + b2;
                    if (this.f5789k == 0) {
                        byte[] bArr3 = this.f5784f;
                        int i6 = this.f5785g;
                        this.f5785g = i6 + 1;
                        int i7 = this.w;
                        bArr3[i6] = (byte) ((i7 >> 16) & 255);
                        int i8 = this.f5785g;
                        this.f5785g = i8 + 1;
                        bArr3[i8] = (byte) ((i7 >> 8) & 255);
                        int i9 = this.f5785g;
                        this.f5785g = i9 + 1;
                        bArr3[i9] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!this.f5787i || this.f5789k == 0) {
            return;
        }
        a(this.u);
        int i10 = this.f5789k;
        if (i10 == 2) {
            this.w >>= 4;
            byte[] bArr4 = this.f5784f;
            int i11 = this.f5785g;
            this.f5785g = i11 + 1;
            bArr4[i11] = (byte) (this.w & 255);
            return;
        }
        if (i10 != 3) {
            return;
        }
        this.w >>= 2;
        byte[] bArr5 = this.f5784f;
        int i12 = this.f5785g;
        this.f5785g = i12 + 1;
        int i13 = this.w;
        bArr5[i12] = (byte) ((i13 >> 8) & 255);
        int i14 = this.f5785g;
        this.f5785g = i14 + 1;
        bArr5[i14] = (byte) (i13 & 255);
    }

    public boolean d() {
        return this.r == C;
    }
}
