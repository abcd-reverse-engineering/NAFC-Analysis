package okio;

import h.q2.e;
import h.q2.f;
import h.q2.s.l;
import h.q2.t.i0;
import h.q2.t.n;
import h.y;
import h.y1;
import i.c.a.d;

/* compiled from: Utf8.kt */
@e(name = "Utf8")
@y(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0080\b\u001a1\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u001a1\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u001a1\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u001a1\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u001a1\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u001a1\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i2) {
        return (i2 >= 0 && 31 >= i2) || (127 <= i2 && 159 >= i2);
    }

    public static final boolean isUtf8Continuation(byte b2) {
        return (b2 & 192) == 128;
    }

    public static final int process2Utf8Bytes(@d byte[] bArr, int i2, int i3, @d l<? super Integer, y1> lVar) {
        i0.f(bArr, "$this$process2Utf8Bytes");
        i0.f(lVar, "yield");
        int i4 = i2 + 1;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i3 <= i4) {
            lVar.invoke(numValueOf);
            return 1;
        }
        byte b2 = bArr[i2];
        byte b3 = bArr[i4];
        if (!((b3 & 192) == 128)) {
            lVar.invoke(numValueOf);
            return 1;
        }
        int i5 = (b3 ^ n.f16413a) ^ (b2 << 6);
        if (i5 < 128) {
            lVar.invoke(numValueOf);
            return 2;
        }
        lVar.invoke(Integer.valueOf(i5));
        return 2;
    }

    public static final int process3Utf8Bytes(@d byte[] bArr, int i2, int i3, @d l<? super Integer, y1> lVar) {
        i0.f(bArr, "$this$process3Utf8Bytes");
        i0.f(lVar, "yield");
        int i4 = i2 + 2;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i3 <= i4) {
            lVar.invoke(numValueOf);
            int i5 = i2 + 1;
            if (i3 > i5) {
                if ((bArr[i5] & 192) == 128) {
                    return 2;
                }
            }
            return 1;
        }
        byte b2 = bArr[i2];
        byte b3 = bArr[i2 + 1];
        if (!((b3 & 192) == 128)) {
            lVar.invoke(numValueOf);
            return 1;
        }
        byte b4 = bArr[i4];
        if (!((b4 & 192) == 128)) {
            lVar.invoke(numValueOf);
            return 2;
        }
        int i6 = ((b4 ^ n.f16413a) ^ (b3 << 6)) ^ (b2 << 12);
        if (i6 < 2048) {
            lVar.invoke(numValueOf);
            return 3;
        }
        if (55296 <= i6 && 57343 >= i6) {
            lVar.invoke(numValueOf);
            return 3;
        }
        lVar.invoke(Integer.valueOf(i6));
        return 3;
    }

    public static final int process4Utf8Bytes(@d byte[] bArr, int i2, int i3, @d l<? super Integer, y1> lVar) {
        i0.f(bArr, "$this$process4Utf8Bytes");
        i0.f(lVar, "yield");
        int i4 = i2 + 3;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i3 <= i4) {
            lVar.invoke(numValueOf);
            int i5 = i2 + 1;
            if (i3 > i5) {
                if ((bArr[i5] & 192) == 128) {
                    int i6 = i2 + 2;
                    if (i3 > i6) {
                        if ((bArr[i6] & 192) == 128) {
                            return 3;
                        }
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b2 = bArr[i2];
        byte b3 = bArr[i2 + 1];
        if (!((b3 & 192) == 128)) {
            lVar.invoke(numValueOf);
            return 1;
        }
        byte b4 = bArr[i2 + 2];
        if (!((b4 & 192) == 128)) {
            lVar.invoke(numValueOf);
            return 2;
        }
        byte b5 = bArr[i4];
        if (!((b5 & 192) == 128)) {
            lVar.invoke(numValueOf);
            return 3;
        }
        int i7 = (((b5 ^ n.f16413a) ^ (b4 << 6)) ^ (b3 << 12)) ^ (b2 << 18);
        if (i7 > 1114111) {
            lVar.invoke(numValueOf);
            return 4;
        }
        if (55296 <= i7 && 57343 >= i7) {
            lVar.invoke(numValueOf);
            return 4;
        }
        if (i7 < 65536) {
            lVar.invoke(numValueOf);
            return 4;
        }
        lVar.invoke(Integer.valueOf(i7));
        return 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void processUtf16Chars(@i.c.a.d byte[] r16, int r17, int r18, @i.c.a.d h.q2.s.l<? super java.lang.Character, h.y1> r19) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, h.q2.s.l):void");
    }

    public static final void processUtf8Bytes(@d String str, int i2, int i3, @d l<? super Byte, y1> lVar) {
        int i4;
        char cCharAt;
        i0.f(str, "$this$processUtf8Bytes");
        i0.f(lVar, "yield");
        while (i2 < i3) {
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 128) {
                lVar.invoke(Byte.valueOf((byte) cCharAt2));
                i2++;
                while (i2 < i3 && str.charAt(i2) < 128) {
                    lVar.invoke(Byte.valueOf((byte) str.charAt(i2)));
                    i2++;
                }
            } else {
                if (cCharAt2 < 2048) {
                    lVar.invoke(Byte.valueOf((byte) ((cCharAt2 >> 6) | 192)));
                    lVar.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (55296 > cCharAt2 || 57343 < cCharAt2) {
                    lVar.invoke(Byte.valueOf((byte) ((cCharAt2 >> '\f') | 224)));
                    lVar.invoke(Byte.valueOf((byte) (((cCharAt2 >> 6) & 63) | 128)));
                    lVar.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (cCharAt2 > 56319 || i3 <= (i4 = i2 + 1) || 56320 > (cCharAt = str.charAt(i4)) || 57343 < cCharAt) {
                    lVar.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                } else {
                    int iCharAt = ((cCharAt2 << '\n') + str.charAt(i4)) - 56613888;
                    lVar.invoke(Byte.valueOf((byte) ((iCharAt >> 18) | 240)));
                    lVar.invoke(Byte.valueOf((byte) (((iCharAt >> 12) & 63) | 128)));
                    lVar.invoke(Byte.valueOf((byte) (((iCharAt >> 6) & 63) | 128)));
                    lVar.invoke(Byte.valueOf((byte) ((iCharAt & 63) | 128)));
                    i2 += 2;
                }
                i2++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void processUtf8CodePoints(@i.c.a.d byte[] r16, int r17, int r18, @i.c.a.d h.q2.s.l<? super java.lang.Integer, h.y1> r19) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, h.q2.s.l):void");
    }

    @e(name = "size")
    @f
    public static final long size(@d String str) {
        return size$default(str, 0, 0, 3, null);
    }

    @e(name = "size")
    @f
    public static final long size(@d String str, int i2) {
        return size$default(str, i2, 0, 2, null);
    }

    @e(name = "size")
    @f
    public static final long size(@d String str, int i2, int i3) {
        int i4;
        i0.f(str, "$this$utf8Size");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
        }
        if (!(i3 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
        }
        long j2 = 0;
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                j2++;
            } else {
                if (cCharAt < 2048) {
                    i4 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i4 = 3;
                } else {
                    int i5 = i2 + 1;
                    char cCharAt2 = i5 < i3 ? str.charAt(i5) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j2++;
                        i2 = i5;
                    } else {
                        j2 += 4;
                        i2 += 2;
                    }
                }
                j2 += i4;
            }
            i2++;
        }
        return j2;
    }

    public static /* synthetic */ long size$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return size(str, i2, i3);
    }
}
