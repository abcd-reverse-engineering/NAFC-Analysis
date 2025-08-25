package okio;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.cw;
import h.q2.e;
import h.q2.t.i0;
import h.t1;
import h.y;
import i.c.a.d;
import okio.internal.ByteStringKt;

/* compiled from: -Util.kt */
@e(name = "-Util")
@y(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\fH\u0000\u001a\u0019\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\fH\u0080\b\u001a\u0019\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010\u000f\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0080\f\u001a\u0015\u0010\u000f\u001a\u00020\f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0080\f\u001a\u0015\u0010\u000f\u001a\u00020\f*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\fH\u0080\f\u001a\f\u0010\u0012\u001a\u00020\u0005*\u00020\u0005H\u0000\u001a\f\u0010\u0012\u001a\u00020\f*\u00020\fH\u0000\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0013H\u0000\u001a\u0015\u0010\u0014\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0080\f\u001a\u0015\u0010\u0015\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0080\f\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0010H\u0000\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0005H\u0000\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\fH\u0000¨\u0006\u0018"}, d2 = {"arrayRangeEquals", "", bh.ay, "", "aOffset", "", "b", "bOffset", "byteCount", "checkOffsetAndCount", "", "size", "", "offset", "minOf", "and", "", DispatchConstants.OTHER, "reverseBytes", "", "shl", "shr", "toHexString", "", "okio"}, k = 2, mv = {1, 1, 16})
/* renamed from: okio.-Util, reason: invalid class name */
/* loaded from: classes2.dex */
public final class Util {
    public static final int and(byte b2, int i2) {
        return b2 & i2;
    }

    public static final long and(byte b2, long j2) {
        return b2 & j2;
    }

    public static final long and(int i2, long j2) {
        return i2 & j2;
    }

    public static final boolean arrayRangeEquals(@d byte[] bArr, int i2, @d byte[] bArr2, int i3, int i4) {
        i0.f(bArr, bh.ay);
        i0.f(bArr2, "b");
        for (int i5 = 0; i5 < i4; i5++) {
            if (bArr[i5 + i2] != bArr2[i5 + i3]) {
                return false;
            }
        }
        return true;
    }

    public static final void checkOffsetAndCount(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException("size=" + j2 + " offset=" + j3 + " byteCount=" + j4);
        }
    }

    public static final long minOf(long j2, int i2) {
        return Math.min(j2, i2);
    }

    public static final int reverseBytes(int i2) {
        return ((i2 & 255) << 24) | (((-16777216) & i2) >>> 24) | ((16711680 & i2) >>> 8) | ((65280 & i2) << 8);
    }

    public static final long reverseBytes(long j2) {
        return ((j2 & 255) << 56) | (((-72057594037927936L) & j2) >>> 56) | ((71776119061217280L & j2) >>> 40) | ((280375465082880L & j2) >>> 24) | ((1095216660480L & j2) >>> 8) | ((4278190080L & j2) << 8) | ((16711680 & j2) << 24) | ((65280 & j2) << 40);
    }

    public static final short reverseBytes(short s) {
        int i2 = s & t1.f16480c;
        return (short) (((i2 & 255) << 8) | ((65280 & i2) >>> 8));
    }

    public static final int shl(byte b2, int i2) {
        return b2 << i2;
    }

    public static final int shr(byte b2, int i2) {
        return b2 >> i2;
    }

    @d
    public static final String toHexString(byte b2) {
        return new String(new char[]{ByteStringKt.getHEX_DIGIT_CHARS()[(b2 >> 4) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[b2 & cw.f10303m]});
    }

    public static final long minOf(int i2, long j2) {
        return Math.min(i2, j2);
    }

    @d
    public static final String toHexString(int i2) {
        if (i2 == 0) {
            return "0";
        }
        int i3 = 0;
        char[] cArr = {ByteStringKt.getHEX_DIGIT_CHARS()[(i2 >> 28) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i2 >> 24) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i2 >> 20) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i2 >> 16) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i2 >> 12) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i2 >> 8) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i2 >> 4) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[i2 & 15]};
        while (i3 < cArr.length && cArr[i3] == '0') {
            i3++;
        }
        return new String(cArr, i3, cArr.length - i3);
    }

    @d
    public static final String toHexString(long j2) {
        if (j2 == 0) {
            return "0";
        }
        int i2 = 0;
        char[] cArr = {ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 60) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 56) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 52) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 48) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 44) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 40) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 36) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 32) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 28) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 24) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 20) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 16) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 12) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 8) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j2 >> 4) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) (j2 & 15)]};
        while (i2 < cArr.length && cArr[i2] == '0') {
            i2++;
        }
        return new String(cArr, i2, cArr.length - i2);
    }
}
