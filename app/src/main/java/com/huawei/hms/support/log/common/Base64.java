package com.huawei.hms.support.log.common;

import com.umeng.analytics.pro.cw;
import h.f1;
import okio.Utf8;

/* loaded from: classes.dex */
public final class Base64 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f7323a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', '='};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f7324b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, cw.f10301k, cw.f10302l, cw.f10303m, cw.n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    private Base64() {
    }

    private static int a(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt > 255 || f7324b[cCharAt] < 0) {
                length--;
            }
        }
        return length;
    }

    public static byte[] decode(String str) {
        if (str == null) {
            return new byte[0];
        }
        int iA = a(str);
        int i2 = (iA / 4) * 3;
        int i3 = iA % 4;
        if (i3 == 3) {
            i2 += 2;
        }
        if (i3 == 2) {
            i2++;
        }
        byte[] bArr = new byte[i2];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            byte b2 = cCharAt > 255 ? (byte) -1 : f7324b[cCharAt];
            if (b2 >= 0) {
                i6 += 6;
                i5 = (i5 << 6) | b2;
                if (i6 >= 8) {
                    i6 -= 8;
                    bArr[i4] = (byte) (255 & (i5 >> i6));
                    i4++;
                }
            }
        }
        return i4 != i2 ? new byte[0] : bArr;
    }

    public static String encode(byte[] bArr) {
        return bArr == null ? "" : encode(bArr, bArr.length);
    }

    public static String encode(byte[] bArr, int i2) {
        boolean z;
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[((i2 + 2) / 3) * 4];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = (bArr[i3] & f1.f16099c) << 8;
            int i6 = i3 + 1;
            boolean z2 = true;
            if (i6 < i2) {
                i5 |= bArr[i6] & f1.f16099c;
                z = true;
            } else {
                z = false;
            }
            int i7 = i5 << 8;
            int i8 = i3 + 2;
            if (i8 < i2) {
                i7 |= bArr[i8] & f1.f16099c;
            } else {
                z2 = false;
            }
            int i9 = i4 + 3;
            char[] cArr2 = f7323a;
            int i10 = 64;
            cArr[i9] = cArr2[z2 ? i7 & 63 : 64];
            int i11 = i7 >> 6;
            int i12 = i4 + 2;
            if (z) {
                i10 = i11 & 63;
            }
            cArr[i12] = cArr2[i10];
            int i13 = i11 >> 6;
            cArr[i4 + 1] = cArr2[i13 & 63];
            cArr[i4 + 0] = cArr2[(i13 >> 6) & 63];
            i3 += 3;
            i4 += 4;
        }
        return new String(cArr);
    }
}
