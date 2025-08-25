package okio;

import com.umeng.analytics.pro.cw;
import h.f1;
import h.q2.e;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.util.Arrays;

/* compiled from: -Base64.kt */
@e(name = "-Base64")
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0000\u001a\u0016\u0010\b\u001a\u00020\u0007*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006\n"}, d2 = {"BASE64", "", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "okio"}, k = 2, mv = {1, 1, 16})
/* renamed from: okio.-Base64, reason: invalid class name */
/* loaded from: classes2.dex */
public final class Base64 {

    @d
    private static final byte[] BASE64 = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();

    @d
    private static final byte[] BASE64_URL_SAFE = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();

    @i.c.a.e
    public static final byte[] decodeBase64ToArray(@d String str) {
        int i2;
        char cCharAt;
        i0.f(str, "$this$decodeBase64ToArray");
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        byte[] bArr = new byte[(int) ((length * 6) / 8)];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt2 = str.charAt(i6);
            if ('A' <= cCharAt2 && 'Z' >= cCharAt2) {
                i2 = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && 'z' >= cCharAt2) {
                i2 = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && '9' >= cCharAt2) {
                i2 = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i2 = 62;
            } else if (cCharAt2 == '/' || cCharAt2 == '_') {
                i2 = 63;
            } else {
                if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i4 = (i4 << 6) | i2;
            i3++;
            if (i3 % 4 == 0) {
                int i7 = i5 + 1;
                bArr[i5] = (byte) (i4 >> 16);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (i4 >> 8);
                bArr[i8] = (byte) i4;
                i5 = i8 + 1;
            }
        }
        int i9 = i3 % 4;
        if (i9 == 1) {
            return null;
        }
        if (i9 == 2) {
            bArr[i5] = (byte) ((i4 << 12) >> 16);
            i5++;
        } else if (i9 == 3) {
            int i10 = i4 << 6;
            int i11 = i5 + 1;
            bArr[i5] = (byte) (i10 >> 16);
            i5 = i11 + 1;
            bArr[i11] = (byte) (i10 >> 8);
        }
        if (i5 == bArr.length) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i5);
        i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf;
    }

    @d
    public static final String encodeBase64(@d byte[] bArr, @d byte[] bArr2) {
        i0.f(bArr, "$this$encodeBase64");
        i0.f(bArr2, "map");
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            int i5 = i4 + 1;
            byte b3 = bArr[i4];
            int i6 = i5 + 1;
            byte b4 = bArr[i5];
            int i7 = i3 + 1;
            bArr3[i3] = bArr2[(b2 & f1.f16099c) >> 2];
            int i8 = i7 + 1;
            bArr3[i7] = bArr2[((b2 & 3) << 4) | ((b3 & f1.f16099c) >> 4)];
            int i9 = i8 + 1;
            bArr3[i8] = bArr2[((b3 & cw.f10303m) << 2) | ((b4 & f1.f16099c) >> 6)];
            i3 = i9 + 1;
            bArr3[i9] = bArr2[b4 & Utf8.REPLACEMENT_BYTE];
            i2 = i6;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b5 = bArr[i2];
            int i10 = i3 + 1;
            bArr3[i3] = bArr2[(b5 & f1.f16099c) >> 2];
            int i11 = i10 + 1;
            bArr3[i10] = bArr2[(b5 & 3) << 4];
            byte b6 = (byte) 61;
            bArr3[i11] = b6;
            bArr3[i11 + 1] = b6;
        } else if (length2 == 2) {
            int i12 = i2 + 1;
            byte b7 = bArr[i2];
            byte b8 = bArr[i12];
            int i13 = i3 + 1;
            bArr3[i3] = bArr2[(b7 & f1.f16099c) >> 2];
            int i14 = i13 + 1;
            bArr3[i13] = bArr2[((b7 & 3) << 4) | ((b8 & f1.f16099c) >> 4)];
            bArr3[i14] = bArr2[(b8 & cw.f10303m) << 2];
            bArr3[i14 + 1] = (byte) 61;
        }
        return Platform.toUtf8String(bArr3);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    @d
    public static final byte[] getBASE64() {
        return BASE64;
    }

    @d
    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}
