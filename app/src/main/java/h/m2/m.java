package h.m2;

import h.n0;

/* compiled from: progressionUtil.kt */
/* loaded from: classes2.dex */
public final class m {
    private static final int a(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 >= 0 ? i4 : i4 + i3;
    }

    @n0
    public static final int b(int i2, int i3, int i4) {
        if (i4 > 0) {
            return i2 >= i3 ? i3 : i3 - a(i3, i2, i4);
        }
        if (i4 < 0) {
            return i2 <= i3 ? i3 : i3 + a(i2, i3, -i4);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final long a(long j2, long j3) {
        long j4 = j2 % j3;
        return j4 >= 0 ? j4 : j4 + j3;
    }

    private static final int a(int i2, int i3, int i4) {
        return a(a(i2, i4) - a(i3, i4), i4);
    }

    private static final long a(long j2, long j3, long j4) {
        return a(a(j2, j4) - a(j3, j4), j4);
    }

    @n0
    public static final long b(long j2, long j3, long j4) {
        if (j4 > 0) {
            return j2 >= j3 ? j3 : j3 - a(j3, j2, j4);
        }
        if (j4 < 0) {
            return j2 <= j3 ? j3 : j3 + a(j2, j3, -j4);
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
