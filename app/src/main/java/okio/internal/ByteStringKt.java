package okio.internal;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.cw;
import h.e1;
import h.f1;
import h.g2.q;
import h.q2.t.i0;
import h.y;
import h.z2.b0;
import i.c.a.d;
import i.c.a.e;
import java.util.Arrays;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.Util;

/* compiled from: ByteString.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0080\b\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a\r\u0010\u0011\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a\u0015\u0010\u0012\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0080\b\u001a\u000f\u0010\u0014\u001a\u0004\u0018\u00010\n*\u00020\u0010H\u0080\b\u001a\r\u0010\u0015\u001a\u00020\n*\u00020\u0010H\u0080\b\u001a\r\u0010\u0016\u001a\u00020\n*\u00020\u0010H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0080\b\u001a\u0017\u0010\u001a\u001a\u00020\u0018*\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001bH\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u001d*\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0005H\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0005*\u00020\nH\u0080\b\u001a\r\u0010 \u001a\u00020\u0005*\u00020\nH\u0080\b\u001a\r\u0010!\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a\u001d\u0010\"\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\u0080\b\u001a\r\u0010$\u001a\u00020\u0007*\u00020\nH\u0080\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\u0080\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0005H\u0080\b\u001a-\u0010&\u001a\u00020\u0018*\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0080\b\u001a-\u0010&\u001a\u00020\u0018*\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010*\u001a\u00020\u0018*\u00020\n2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010*\u001a\u00020\u0018*\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0080\b\u001a\u001d\u0010,\u001a\u00020\n*\u00020\n2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0080\b\u001a\r\u0010/\u001a\u00020\n*\u00020\nH\u0080\b\u001a\r\u00100\u001a\u00020\n*\u00020\nH\u0080\b\u001a\r\u00101\u001a\u00020\u0007*\u00020\nH\u0080\b\u001a\u001d\u00102\u001a\u00020\n*\u00020\u00072\u0006\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0080\b\u001a\r\u00103\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a\r\u00104\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a$\u00105\u001a\u000206*\u00020\n2\u0006\u00107\u001a\u0002082\u0006\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u00069"}, d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", bh.aE, "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", bh.aI, "", "commonBase64", "", "commonBase64Url", "commonCompareTo", DispatchConstants.OTHER, "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "offset", "otherOffset", "byteCount", "commonStartsWith", RequestParameters.PREFIX, "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "", "buffer", "Lokio/Buffer;", "okio"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ByteStringKt {

    @d
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0069, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0072, code lost:
    
        r19 = r6;
        r6 = r5;
        r5 = r19;
     */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int codePointIndexToCharIndex(byte[] r20, int r21) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }

    @d
    public static final String commonBase64(@d ByteString byteString) {
        i0.f(byteString, "$this$commonBase64");
        return Base64.encodeBase64$default(byteString.getData$okio(), null, 1, null);
    }

    @d
    public static final String commonBase64Url(@d ByteString byteString) {
        i0.f(byteString, "$this$commonBase64Url");
        return Base64.encodeBase64(byteString.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@d ByteString byteString, @d ByteString byteString2) {
        i0.f(byteString, "$this$commonCompareTo");
        i0.f(byteString2, DispatchConstants.OTHER);
        int size = byteString.size();
        int size2 = byteString2.size();
        int iMin = Math.min(size, size2);
        for (int i2 = 0; i2 < iMin; i2++) {
            int i3 = byteString.getByte(i2) & f1.f16099c;
            int i4 = byteString2.getByte(i2) & f1.f16099c;
            if (i3 != i4) {
                return i3 < i4 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    @e
    public static final ByteString commonDecodeBase64(@d String str) {
        i0.f(str, "$this$commonDecodeBase64");
        byte[] bArrDecodeBase64ToArray = Base64.decodeBase64ToArray(str);
        if (bArrDecodeBase64ToArray != null) {
            return new ByteString(bArrDecodeBase64ToArray);
        }
        return null;
    }

    @d
    public static final ByteString commonDecodeHex(@d String str) {
        i0.f(str, "$this$commonDecodeHex");
        if (!(str.length() % 2 == 0)) {
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }
        byte[] bArr = new byte[str.length() / 2];
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((decodeHexDigit(str.charAt(i3)) << 4) + decodeHexDigit(str.charAt(i3 + 1)));
        }
        return new ByteString(bArr);
    }

    @d
    public static final ByteString commonEncodeUtf8(@d String str) {
        i0.f(str, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(@d ByteString byteString, @d ByteString byteString2) {
        i0.f(byteString, "$this$commonEndsWith");
        i0.f(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEquals(@d ByteString byteString, @e Object obj) {
        i0.f(byteString, "$this$commonEquals");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@d ByteString byteString, int i2) {
        i0.f(byteString, "$this$commonGetByte");
        return byteString.getData$okio()[i2];
    }

    public static final int commonGetSize(@d ByteString byteString) {
        i0.f(byteString, "$this$commonGetSize");
        return byteString.getData$okio().length;
    }

    public static final int commonHashCode(@d ByteString byteString) {
        i0.f(byteString, "$this$commonHashCode");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int iHashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(iHashCode);
        return iHashCode;
    }

    @d
    public static final String commonHex(@d ByteString byteString) {
        i0.f(byteString, "$this$commonHex");
        char[] cArr = new char[byteString.getData$okio().length * 2];
        int i2 = 0;
        for (byte b2 : byteString.getData$okio()) {
            int i3 = i2 + 1;
            cArr[i2] = getHEX_DIGIT_CHARS()[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = getHEX_DIGIT_CHARS()[b2 & cw.f10303m];
        }
        return new String(cArr);
    }

    public static final int commonIndexOf(@d ByteString byteString, @d byte[] bArr, int i2) {
        i0.f(byteString, "$this$commonIndexOf");
        i0.f(bArr, DispatchConstants.OTHER);
        int length = byteString.getData$okio().length - bArr.length;
        int iMax = Math.max(i2, 0);
        if (iMax > length) {
            return -1;
        }
        while (!Util.arrayRangeEquals(byteString.getData$okio(), iMax, bArr, 0, bArr.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    @d
    public static final byte[] commonInternalArray(@d ByteString byteString) {
        i0.f(byteString, "$this$commonInternalArray");
        return byteString.getData$okio();
    }

    public static final int commonLastIndexOf(@d ByteString byteString, @d ByteString byteString2, int i2) {
        i0.f(byteString, "$this$commonLastIndexOf");
        i0.f(byteString2, DispatchConstants.OTHER);
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i2);
    }

    @d
    public static final ByteString commonOf(@d byte[] bArr) {
        i0.f(bArr, "data");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(bArrCopyOf);
    }

    public static final boolean commonRangeEquals(@d ByteString byteString, int i2, @d ByteString byteString2, int i3, int i4) {
        i0.f(byteString, "$this$commonRangeEquals");
        i0.f(byteString2, DispatchConstants.OTHER);
        return byteString2.rangeEquals(i3, byteString.getData$okio(), i2, i4);
    }

    public static final boolean commonStartsWith(@d ByteString byteString, @d ByteString byteString2) {
        i0.f(byteString, "$this$commonStartsWith");
        i0.f(byteString2, RequestParameters.PREFIX);
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    @d
    public static final ByteString commonSubstring(@d ByteString byteString, int i2, int i3) {
        i0.f(byteString, "$this$commonSubstring");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (i3 <= byteString.getData$okio().length) {
            if (i3 - i2 >= 0) {
                return (i2 == 0 && i3 == byteString.getData$okio().length) ? byteString : new ByteString(q.a(byteString.getData$okio(), i2, i3));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
    }

    @d
    public static final ByteString commonToAsciiLowercase(@d ByteString byteString) {
        byte b2;
        i0.f(byteString, "$this$commonToAsciiLowercase");
        for (int i2 = 0; i2 < byteString.getData$okio().length; i2++) {
            byte b3 = byteString.getData$okio()[i2];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] data$okio = byteString.getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i2] = (byte) (b3 + 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b5 = bArrCopyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        bArrCopyOf[i3] = (byte) (b5 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return byteString;
    }

    @d
    public static final ByteString commonToAsciiUppercase(@d ByteString byteString) {
        byte b2;
        i0.f(byteString, "$this$commonToAsciiUppercase");
        for (int i2 = 0; i2 < byteString.getData$okio().length; i2++) {
            byte b3 = byteString.getData$okio()[i2];
            byte b4 = (byte) 97;
            if (b3 >= b4 && b3 <= (b2 = (byte) 122)) {
                byte[] data$okio = byteString.getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i2] = (byte) (b3 - 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b5 = bArrCopyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        bArrCopyOf[i3] = (byte) (b5 - 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return byteString;
    }

    @d
    public static final byte[] commonToByteArray(@d ByteString byteString) {
        i0.f(byteString, "$this$commonToByteArray");
        byte[] data$okio = byteString.getData$okio();
        byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
        i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    @d
    public static final ByteString commonToByteString(@d byte[] bArr, int i2, int i3) {
        i0.f(bArr, "$this$commonToByteString");
        Util.checkOffsetAndCount(bArr.length, i2, i3);
        return new ByteString(q.a(bArr, i2, i3 + i2));
    }

    @d
    public static final String commonToString(@d ByteString byteString) {
        ByteString byteString2 = byteString;
        i0.f(byteString2, "$this$commonToString");
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int iCodePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (iCodePointIndexToCharIndex != -1) {
            String strUtf8 = byteString.utf8();
            if (strUtf8 == null) {
                throw new e1("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = strUtf8.substring(0, iCodePointIndexToCharIndex);
            i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String strA = b0.a(b0.a(b0.a(strSubstring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (iCodePointIndexToCharIndex >= strUtf8.length()) {
                return "[text=" + strA + ']';
            }
            return "[size=" + byteString.getData$okio().length + " text=" + strA + "…]";
        }
        if (byteString.getData$okio().length <= 64) {
            return "[hex=" + byteString.hex() + ']';
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[size=");
        sb.append(byteString.getData$okio().length);
        sb.append(" hex=");
        if (64 <= byteString.getData$okio().length) {
            if (64 != byteString.getData$okio().length) {
                byteString2 = new ByteString(q.a(byteString.getData$okio(), 0, 64));
            }
            sb.append(byteString2.hex());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
    }

    @d
    public static final String commonUtf8(@d ByteString byteString) {
        i0.f(byteString, "$this$commonUtf8");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(@d ByteString byteString, @d Buffer buffer, int i2, int i3) {
        i0.f(byteString, "$this$commonWrite");
        i0.f(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int decodeHexDigit(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    @d
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(@d ByteString byteString, @d byte[] bArr) {
        i0.f(byteString, "$this$commonEndsWith");
        i0.f(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonLastIndexOf(@d ByteString byteString, @d byte[] bArr, int i2) {
        i0.f(byteString, "$this$commonLastIndexOf");
        i0.f(bArr, DispatchConstants.OTHER);
        for (int iMin = Math.min(i2, byteString.getData$okio().length - bArr.length); iMin >= 0; iMin--) {
            if (Util.arrayRangeEquals(byteString.getData$okio(), iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(@d ByteString byteString, int i2, @d byte[] bArr, int i3, int i4) {
        i0.f(byteString, "$this$commonRangeEquals");
        i0.f(bArr, DispatchConstants.OTHER);
        return i2 >= 0 && i2 <= byteString.getData$okio().length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && Util.arrayRangeEquals(byteString.getData$okio(), i2, bArr, i3, i4);
    }

    public static final boolean commonStartsWith(@d ByteString byteString, @d byte[] bArr) {
        i0.f(byteString, "$this$commonStartsWith");
        i0.f(bArr, RequestParameters.PREFIX);
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }
}
