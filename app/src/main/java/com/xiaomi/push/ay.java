package com.xiaomi.push;

import h.f1;

/* loaded from: classes2.dex */
public class ay {

    /* renamed from: a, reason: collision with other field name */
    private static byte[] f204a;

    /* renamed from: a, reason: collision with root package name */
    private static final String f12472a = System.getProperty("line.separator");

    /* renamed from: a, reason: collision with other field name */
    private static char[] f205a = new char[64];

    static {
        char c2 = 'A';
        int i2 = 0;
        while (c2 <= 'Z') {
            f205a[i2] = c2;
            c2 = (char) (c2 + 1);
            i2++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            f205a[i2] = c3;
            c3 = (char) (c3 + 1);
            i2++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            f205a[i2] = c4;
            c4 = (char) (c4 + 1);
            i2++;
        }
        char[] cArr = f205a;
        cArr[i2] = '+';
        cArr[i2 + 1] = '/';
        f204a = new byte[128];
        int i3 = 0;
        while (true) {
            byte[] bArr = f204a;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = -1;
            i3++;
        }
        for (int i4 = 0; i4 < 64; i4++) {
            f204a[f205a[i4]] = (byte) i4;
        }
    }

    public static String a(String str) {
        return new String(a(str.getBytes()));
    }

    public static String b(String str) {
        return new String(m161a(str));
    }

    public static char[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static char[] a(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = ((i3 * 4) + 2) / 3;
        char[] cArr = new char[((i3 + 2) / 3) * 4];
        int i9 = i3 + i2;
        int i10 = 0;
        while (i2 < i9) {
            int i11 = i2 + 1;
            int i12 = bArr[i2] & f1.f16099c;
            if (i11 < i9) {
                i4 = i11 + 1;
                i5 = bArr[i11] & f1.f16099c;
            } else {
                i4 = i11;
                i5 = 0;
            }
            if (i4 < i9) {
                i6 = i4 + 1;
                i7 = bArr[i4] & f1.f16099c;
            } else {
                i6 = i4;
                i7 = 0;
            }
            int i13 = i12 >>> 2;
            int i14 = ((i12 & 3) << 4) | (i5 >>> 4);
            int i15 = ((i5 & 15) << 2) | (i7 >>> 6);
            int i16 = i7 & 63;
            int i17 = i10 + 1;
            char[] cArr2 = f205a;
            cArr[i10] = cArr2[i13];
            int i18 = i17 + 1;
            cArr[i17] = cArr2[i14];
            char c2 = '=';
            cArr[i18] = i18 < i8 ? cArr2[i15] : '=';
            int i19 = i18 + 1;
            if (i19 < i8) {
                c2 = f205a[i16];
            }
            cArr[i19] = c2;
            i10 = i19 + 1;
            i2 = i6;
        }
        return cArr;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static byte[] m161a(String str) {
        return a(str.toCharArray());
    }

    public static byte[] a(char[] cArr) {
        return a(cArr, 0, cArr.length);
    }

    public static byte[] a(char[] cArr, int i2, int i3) {
        int i4;
        char c2;
        int i5;
        if (i3 % 4 == 0) {
            while (i3 > 0 && cArr[(i2 + i3) - 1] == '=') {
                i3--;
            }
            int i6 = (i3 * 3) / 4;
            byte[] bArr = new byte[i6];
            int i7 = i3 + i2;
            int i8 = 0;
            while (i2 < i7) {
                int i9 = i2 + 1;
                char c3 = cArr[i2];
                int i10 = i9 + 1;
                char c4 = cArr[i9];
                char c5 = 'A';
                if (i10 < i7) {
                    i4 = i10 + 1;
                    c2 = cArr[i10];
                } else {
                    i4 = i10;
                    c2 = 'A';
                }
                if (i4 < i7) {
                    int i11 = i4 + 1;
                    char c6 = cArr[i4];
                    i4 = i11;
                    c5 = c6;
                }
                if (c3 <= 127 && c4 <= 127 && c2 <= 127 && c5 <= 127) {
                    byte[] bArr2 = f204a;
                    byte b2 = bArr2[c3];
                    byte b3 = bArr2[c4];
                    byte b4 = bArr2[c2];
                    byte b5 = bArr2[c5];
                    if (b2 >= 0 && b3 >= 0 && b4 >= 0 && b5 >= 0) {
                        int i12 = (b2 << 2) | (b3 >>> 4);
                        int i13 = ((b3 & com.umeng.analytics.pro.cw.f10303m) << 4) | (b4 >>> 2);
                        int i14 = ((b4 & 3) << 6) | b5;
                        int i15 = i8 + 1;
                        bArr[i8] = (byte) i12;
                        if (i15 < i6) {
                            i5 = i15 + 1;
                            bArr[i15] = (byte) i13;
                        } else {
                            i5 = i15;
                        }
                        if (i5 < i6) {
                            i8 = i5 + 1;
                            bArr[i5] = (byte) i14;
                        } else {
                            i8 = i5;
                        }
                        i2 = i4;
                    } else {
                        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                    }
                } else {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }
}
