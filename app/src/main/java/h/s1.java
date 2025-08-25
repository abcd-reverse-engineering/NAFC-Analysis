package h;

/* compiled from: UNumbers.kt */
@h.q2.e(name = "UNumbersKt")
/* loaded from: classes2.dex */
public final class s1 {
    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int a(int i2) {
        return Integer.numberOfLeadingZeros(i2);
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int b(int i2) {
        return Integer.bitCount(i2);
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int c(int i2) {
        return Integer.numberOfTrailingZeros(i2);
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int d(int i2) {
        return j1.c(Integer.highestOneBit(i2));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int e(int i2) {
        return j1.c(Integer.lowestOneBit(i2));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int a(int i2, int i3) {
        return j1.c(Integer.rotateLeft(i2, i3));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int b(int i2, int i3) {
        return j1.c(Integer.rotateRight(i2, i3));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int c(long j2) {
        return Long.numberOfTrailingZeros(j2);
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final long d(long j2) {
        return n1.c(Long.highestOneBit(j2));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final long e(long j2) {
        return n1.c(Long.lowestOneBit(j2));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int a(long j2) {
        return Long.numberOfLeadingZeros(j2);
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int b(long j2) {
        return Long.bitCount(j2);
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int c(byte b2) {
        return Integer.numberOfTrailingZeros(b2 | 256);
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final byte d(byte b2) {
        return f1.c((byte) Integer.highestOneBit(b2 & f1.f16099c));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final byte e(byte b2) {
        return f1.c((byte) Integer.lowestOneBit(b2 & f1.f16099c));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final long a(long j2, int i2) {
        return n1.c(Long.rotateLeft(j2, i2));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final long b(long j2, int i2) {
        return n1.c(Long.rotateRight(j2, i2));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int c(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final short d(short s) {
        return t1.c((short) Integer.highestOneBit(s & t1.f16480c));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final short e(short s) {
        return t1.c((short) Integer.lowestOneBit(s & t1.f16480c));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int a(byte b2) {
        return Integer.numberOfLeadingZeros(b2 & f1.f16099c) - 24;
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int b(byte b2) {
        return Integer.bitCount(j1.c(b2 & f1.f16099c));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final byte a(byte b2, int i2) {
        return f1.c(f0.a(b2, i2));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final byte b(byte b2, int i2) {
        return f1.c(f0.b(b2, i2));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int a(short s) {
        return Integer.numberOfLeadingZeros(s & t1.f16480c) - 16;
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final int b(short s) {
        return Integer.bitCount(j1.c(s & t1.f16480c));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final short a(short s, int i2) {
        return t1.c(f0.a(s, i2));
    }

    @h.m2.f
    @j
    @t0(version = "1.3")
    @k
    private static final short b(short s, int i2) {
        return t1.c(f0.b(s, i2));
    }
}
