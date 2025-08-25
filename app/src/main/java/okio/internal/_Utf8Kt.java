package okio.internal;

import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.util.Arrays;
import okio.Utf8;

/* compiled from: -Utf8.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class _Utf8Kt {
    @d
    public static final byte[] commonAsUtf8ToByteArray(@d String str) {
        int i2;
        int i3;
        char cCharAt;
        i0.f(str, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 >= 128) {
                int length2 = str.length();
                int i5 = i4;
                while (i4 < length2) {
                    char cCharAt3 = str.charAt(i4);
                    if (cCharAt3 < 128) {
                        int i6 = i5 + 1;
                        bArr[i5] = (byte) cCharAt3;
                        i4++;
                        while (i4 < length2 && str.charAt(i4) < 128) {
                            bArr[i6] = (byte) str.charAt(i4);
                            i4++;
                            i6++;
                        }
                        i5 = i6;
                    } else {
                        if (cCharAt3 < 2048) {
                            int i7 = i5 + 1;
                            bArr[i5] = (byte) ((cCharAt3 >> 6) | 192);
                            byte b2 = (byte) ((cCharAt3 & '?') | 128);
                            i2 = i7 + 1;
                            bArr[i7] = b2;
                        } else if (55296 > cCharAt3 || 57343 < cCharAt3) {
                            int i8 = i5 + 1;
                            bArr[i5] = (byte) ((cCharAt3 >> '\f') | 224);
                            int i9 = i8 + 1;
                            bArr[i8] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            byte b3 = (byte) ((cCharAt3 & '?') | 128);
                            i2 = i9 + 1;
                            bArr[i9] = b3;
                        } else if (cCharAt3 > 56319 || length2 <= (i3 = i4 + 1) || 56320 > (cCharAt = str.charAt(i3)) || 57343 < cCharAt) {
                            i2 = i5 + 1;
                            bArr[i5] = Utf8.REPLACEMENT_BYTE;
                        } else {
                            int iCharAt = ((cCharAt3 << '\n') + str.charAt(i3)) - 56613888;
                            int i10 = i5 + 1;
                            bArr[i5] = (byte) ((iCharAt >> 18) | 240);
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((iCharAt >> 12) & 63) | 128);
                            int i12 = i11 + 1;
                            bArr[i11] = (byte) (((iCharAt >> 6) & 63) | 128);
                            byte b4 = (byte) ((iCharAt & 63) | 128);
                            i2 = i12 + 1;
                            bArr[i12] = b4;
                            i4 += 2;
                            i5 = i2;
                        }
                        i4++;
                        i5 = i2;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i5);
                i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i4] = (byte) cCharAt2;
            i4++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        i0.a((Object) bArrCopyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0111 A[PHI: r6
  0x0111: PHI (r6v42 int) = (r6v39 int), (r6v44 int), (r6v44 int) binds: [B:100:0x0138, B:81:0x0104, B:86:0x010f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114 A[PHI: r6
  0x0114: PHI (r6v41 int) = (r6v40 int), (r6v44 int), (r6v44 int) binds: [B:94:0x0126, B:73:0x00f4, B:78:0x00ff] A[DONT_GENERATE, DONT_INLINE]] */
    @i.c.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String commonToUtf8String(@i.c.a.d byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        return commonToUtf8String(bArr, i2, i3);
    }
}
