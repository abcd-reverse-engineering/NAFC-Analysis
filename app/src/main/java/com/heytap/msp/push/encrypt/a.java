package com.heytap.msp.push.encrypt;

import com.umeng.analytics.pro.cw;
import i.a.a.a.k.l;
import java.math.BigInteger;
import okio.Utf8;

/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: m, reason: collision with root package name */
    private static final int f5918m = 6;
    private static final int n = 3;
    private static final int o = 4;
    private static final int s = 63;
    private final byte[] t;
    private final byte[] u;
    private final byte[] v;
    private final int w;
    private final int x;
    private int y;

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f5917a = {cw.f10301k, 10};
    private static final byte[] p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] r = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, cw.f10301k, cw.f10302l, cw.f10303m, cw.n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public a() {
        this(0);
    }

    public a(int i2) {
        this(i2, f5917a);
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
            byte[] r1 = com.heytap.msp.push.encrypt.a.r
            r4.u = r1
            r1 = 0
            if (r6 == 0) goto L4a
            boolean r3 = r4.l(r6)
            if (r3 != 0) goto L2a
            if (r5 <= 0) goto L4a
            int r5 = r6.length
            int r5 = r5 + r2
            r4.x = r5
            int r5 = r6.length
            byte[] r5 = new byte[r5]
            r4.v = r5
            byte[] r5 = r4.v
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
            r4.x = r2
            r4.v = r1
        L4e:
            int r5 = r4.x
            int r5 = r5 + (-1)
            r4.w = r5
            if (r7 == 0) goto L59
            byte[] r5 = com.heytap.msp.push.encrypt.a.q
            goto L5b
        L59:
            byte[] r5 = com.heytap.msp.push.encrypt.a.p
        L5b:
            r4.t = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.msp.push.encrypt.a.<init>(int, byte[], boolean):void");
    }

    public a(boolean z) {
        this(76, f5917a, z);
    }

    public static boolean a(byte b2) {
        if (b2 != 61) {
            if (b2 >= 0) {
                byte[] bArr = r;
                if (b2 >= bArr.length || bArr[b2] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean a(String str) {
        return b(l.f(str));
    }

    public static boolean a(byte[] bArr) {
        return b(bArr);
    }

    public static byte[] a(BigInteger bigInteger) {
        if (bigInteger != null) {
            return a(b(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    public static byte[] a(byte[] bArr, boolean z) {
        return a(bArr, z, false);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2) {
        return a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = z ? new a(z2) : new a(0, f5917a, z2);
        long jM = aVar.m(bArr);
        if (jM <= i2) {
            return aVar.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + jM + ") than the specified maximum size of " + i2);
    }

    public static boolean b(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!a(bArr[i2]) && !b.c(bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public static byte[] b(String str) {
        return new a().c(str);
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

    public static byte[] c(byte[] bArr) {
        return a(bArr, false);
    }

    public static String d(byte[] bArr) {
        return l.f(a(bArr, false));
    }

    public static byte[] e(byte[] bArr) {
        return a(bArr, false, true);
    }

    public static String f(byte[] bArr) {
        return l.f(a(bArr, false, true));
    }

    public static byte[] g(byte[] bArr) {
        return a(bArr, true);
    }

    public static byte[] h(byte[] bArr) {
        return new a().decode(bArr);
    }

    public static BigInteger i(byte[] bArr) {
        return new BigInteger(1, h(bArr));
    }

    @Override // com.heytap.msp.push.encrypt.b
    void a(byte[] bArr, int i2, int i3) {
        if (this.f5929j) {
            return;
        }
        if (i3 >= 0) {
            int i4 = i2;
            int i5 = 0;
            while (i5 < i3) {
                a(this.x);
                this.f5931l = (this.f5931l + 1) % 3;
                int i6 = i4 + 1;
                int i7 = bArr[i4];
                if (i7 < 0) {
                    i7 += 256;
                }
                this.y = (this.y << 8) + i7;
                if (this.f5931l == 0) {
                    byte[] bArr2 = this.f5927h;
                    int i8 = this.f5928i;
                    this.f5928i = i8 + 1;
                    byte[] bArr3 = this.t;
                    int i9 = this.y;
                    bArr2[i8] = bArr3[(i9 >> 18) & 63];
                    int i10 = this.f5928i;
                    this.f5928i = i10 + 1;
                    bArr2[i10] = bArr3[(i9 >> 12) & 63];
                    int i11 = this.f5928i;
                    this.f5928i = i11 + 1;
                    bArr2[i11] = bArr3[(i9 >> 6) & 63];
                    int i12 = this.f5928i;
                    this.f5928i = i12 + 1;
                    bArr2[i12] = bArr3[i9 & 63];
                    this.f5930k += 4;
                    int i13 = this.f5926g;
                    if (i13 > 0 && i13 <= this.f5930k) {
                        byte[] bArr4 = this.v;
                        System.arraycopy(bArr4, 0, bArr2, this.f5928i, bArr4.length);
                        this.f5928i += this.v.length;
                        this.f5930k = 0;
                    }
                }
                i5++;
                i4 = i6;
            }
            return;
        }
        this.f5929j = true;
        if (this.f5931l == 0 && this.f5926g == 0) {
            return;
        }
        a(this.x);
        int i14 = this.f5928i;
        int i15 = this.f5931l;
        if (i15 == 1) {
            byte[] bArr5 = this.f5927h;
            this.f5928i = i14 + 1;
            byte[] bArr6 = this.t;
            int i16 = this.y;
            bArr5[i14] = bArr6[(i16 >> 2) & 63];
            int i17 = this.f5928i;
            this.f5928i = i17 + 1;
            bArr5[i17] = bArr6[(i16 << 4) & 63];
            if (bArr6 == p) {
                int i18 = this.f5928i;
                this.f5928i = i18 + 1;
                bArr5[i18] = 61;
                int i19 = this.f5928i;
                this.f5928i = i19 + 1;
                bArr5[i19] = 61;
            }
        } else if (i15 == 2) {
            byte[] bArr7 = this.f5927h;
            this.f5928i = i14 + 1;
            byte[] bArr8 = this.t;
            int i20 = this.y;
            bArr7[i14] = bArr8[(i20 >> 10) & 63];
            int i21 = this.f5928i;
            this.f5928i = i21 + 1;
            bArr7[i21] = bArr8[(i20 >> 4) & 63];
            int i22 = this.f5928i;
            this.f5928i = i22 + 1;
            bArr7[i22] = bArr8[(i20 << 2) & 63];
            if (bArr8 == p) {
                int i23 = this.f5928i;
                this.f5928i = i23 + 1;
                bArr7[i23] = 61;
            }
        }
        int i24 = this.f5930k;
        int i25 = this.f5928i;
        this.f5930k = i24 + (i25 - i14);
        if (this.f5926g <= 0 || this.f5930k <= 0) {
            return;
        }
        byte[] bArr9 = this.v;
        System.arraycopy(bArr9, 0, this.f5927h, i25, bArr9.length);
        this.f5928i += this.v.length;
    }

    public boolean a() {
        return this.t == q;
    }

    @Override // com.heytap.msp.push.encrypt.b
    void b(byte[] bArr, int i2, int i3) {
        byte b2;
        if (this.f5929j) {
            return;
        }
        if (i3 < 0) {
            this.f5929j = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            a(this.w);
            int i5 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 == 61) {
                this.f5929j = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = r;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    this.f5931l = (this.f5931l + 1) % 4;
                    this.y = (this.y << 6) + b2;
                    if (this.f5931l == 0) {
                        byte[] bArr3 = this.f5927h;
                        int i6 = this.f5928i;
                        this.f5928i = i6 + 1;
                        int i7 = this.y;
                        bArr3[i6] = (byte) ((i7 >> 16) & 255);
                        int i8 = this.f5928i;
                        this.f5928i = i8 + 1;
                        bArr3[i8] = (byte) ((i7 >> 8) & 255);
                        int i9 = this.f5928i;
                        this.f5928i = i9 + 1;
                        bArr3[i9] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!this.f5929j || this.f5931l == 0) {
            return;
        }
        a(this.w);
        int i10 = this.f5931l;
        if (i10 == 2) {
            this.y >>= 4;
            byte[] bArr4 = this.f5927h;
            int i11 = this.f5928i;
            this.f5928i = i11 + 1;
            bArr4[i11] = (byte) (this.y & 255);
            return;
        }
        if (i10 != 3) {
            return;
        }
        this.y >>= 2;
        byte[] bArr5 = this.f5927h;
        int i12 = this.f5928i;
        this.f5928i = i12 + 1;
        int i13 = this.y;
        bArr5[i12] = (byte) ((i13 >> 8) & 255);
        int i14 = this.f5928i;
        this.f5928i = i14 + 1;
        bArr5[i14] = (byte) (i13 & 255);
    }

    @Override // com.heytap.msp.push.encrypt.b
    protected boolean b(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.u;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }
}
