package h;

/* compiled from: NumbersJVM.kt */
/* loaded from: classes2.dex */
class e0 extends d0 {
    @h.m2.f
    private static final boolean a(double d2) {
        return (Double.isInfinite(d2) || Double.isNaN(d2)) ? false : true;
    }

    @h.m2.f
    private static final boolean b(double d2) {
        return Double.isInfinite(d2);
    }

    @h.m2.f
    private static final boolean c(double d2) {
        return Double.isNaN(d2);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final long d(double d2) {
        return Double.doubleToLongBits(d2);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final long e(double d2) {
        return Double.doubleToRawLongBits(d2);
    }

    @h.m2.f
    private static final boolean a(float f2) {
        return (Float.isInfinite(f2) || Float.isNaN(f2)) ? false : true;
    }

    @h.m2.f
    private static final boolean b(float f2) {
        return Float.isInfinite(f2);
    }

    @h.m2.f
    private static final boolean c(float f2) {
        return Float.isNaN(f2);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final int d(float f2) {
        return Float.floatToIntBits(f2);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final int e(float f2) {
        return Float.floatToRawIntBits(f2);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final double a(@i.c.a.d h.q2.t.w wVar, long j2) {
        return Double.longBitsToDouble(j2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final int b(int i2) {
        return Integer.bitCount(i2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final int c(int i2) {
        return Integer.numberOfTrailingZeros(i2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final int d(int i2) {
        return Integer.highestOneBit(i2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final int e(int i2) {
        return Integer.lowestOneBit(i2);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final float a(@i.c.a.d h.q2.t.z zVar, int i2) {
        return Float.intBitsToFloat(i2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final int b(int i2, int i3) {
        return Integer.rotateRight(i2, i3);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final int c(long j2) {
        return Long.numberOfTrailingZeros(j2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final long d(long j2) {
        return Long.highestOneBit(j2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final long e(long j2) {
        return Long.lowestOneBit(j2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final int a(int i2) {
        return Integer.numberOfLeadingZeros(i2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final int b(long j2) {
        return Long.bitCount(j2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final int a(int i2, int i3) {
        return Integer.rotateLeft(i2, i3);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final long b(long j2, int i2) {
        return Long.rotateRight(j2, i2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final int a(long j2) {
        return Long.numberOfLeadingZeros(j2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @j
    private static final long a(long j2, int i2) {
        return Long.rotateLeft(j2, i2);
    }
}
