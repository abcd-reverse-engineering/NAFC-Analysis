package h;

/* compiled from: UnsignedUtils.kt */
@h.q2.e(name = "UnsignedKt")
/* loaded from: classes2.dex */
public final class b2 {
    @n0
    public static final double a(int i2) {
        return (Integer.MAX_VALUE & i2) + (((i2 >>> 31) << 30) * 2);
    }

    @n0
    public static final double a(long j2) {
        return ((j2 >>> 11) * 2048) + (j2 & 2047);
    }

    @n0
    public static final int a(int i2, int i3) {
        return h.q2.t.i0.a(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
    }

    @n0
    public static final int a(long j2, long j3) {
        return ((j2 ^ Long.MIN_VALUE) > (j3 ^ Long.MIN_VALUE) ? 1 : ((j2 ^ Long.MIN_VALUE) == (j3 ^ Long.MIN_VALUE) ? 0 : -1));
    }

    @n0
    public static final int b(int i2, int i3) {
        return j1.c((int) ((i2 & 4294967295L) / (i3 & 4294967295L)));
    }

    @n0
    public static final int c(int i2, int i3) {
        return j1.c((int) ((i2 & 4294967295L) % (i3 & 4294967295L)));
    }

    @n0
    public static final int a(double d2) {
        if (Double.isNaN(d2) || d2 <= a(0)) {
            return 0;
        }
        if (d2 >= a(-1)) {
            return -1;
        }
        double d3 = Integer.MAX_VALUE;
        return d2 <= d3 ? j1.c((int) d2) : j1.c(j1.c((int) (d2 - d3)) + j1.c(Integer.MAX_VALUE));
    }

    @n0
    public static final long b(long j2, long j3) {
        if (j3 < 0) {
            return a(j2, j3) < 0 ? n1.c(0L) : n1.c(1L);
        }
        if (j2 >= 0) {
            return n1.c(j2 / j3);
        }
        long j4 = ((j2 >>> 1) / j3) << 1;
        return n1.c(j4 + (a(n1.c(j2 - (j4 * j3)), n1.c(j3)) < 0 ? 0 : 1));
    }

    @n0
    public static final long c(long j2, long j3) {
        if (j3 < 0) {
            return a(j2, j3) < 0 ? j2 : n1.c(j2 - j3);
        }
        if (j2 >= 0) {
            return n1.c(j2 % j3);
        }
        long j4 = j2 - ((((j2 >>> 1) / j3) << 1) * j3);
        if (a(n1.c(j4), n1.c(j3)) < 0) {
            j3 = 0;
        }
        return n1.c(j4 - j3);
    }

    @n0
    public static final long b(double d2) {
        if (Double.isNaN(d2) || d2 <= a(0L)) {
            return 0L;
        }
        if (d2 >= a(-1L)) {
            return -1L;
        }
        if (d2 < h.q2.t.m0.f16408b) {
            return n1.c((long) d2);
        }
        return n1.c(n1.c((long) (d2 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @i.c.a.d
    public static final String a(long j2, int i2) {
        if (j2 >= 0) {
            String string = Long.toString(j2, h.z2.d.a(i2));
            h.q2.t.i0.a((Object) string, "java.lang.Long.toString(this, checkRadix(radix))");
            return string;
        }
        long j3 = i2;
        long j4 = ((j2 >>> 1) / j3) << 1;
        long j5 = j2 - (j4 * j3);
        if (j5 >= j3) {
            j5 -= j3;
            j4++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j4, h.z2.d.a(i2));
        h.q2.t.i0.a((Object) string2, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(string2);
        String string3 = Long.toString(j5, h.z2.d.a(i2));
        h.q2.t.i0.a((Object) string3, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(string3);
        return sb.toString();
    }

    @i.c.a.d
    public static final String b(long j2) {
        return a(j2, 10);
    }
}
