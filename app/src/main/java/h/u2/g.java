package h.u2;

import h.q2.t.i0;
import h.q2.t.m0;
import h.t0;
import h.v2.k;
import h.v2.n;

/* compiled from: Random.kt */
/* loaded from: classes2.dex */
public final class g {
    @t0(version = "1.3")
    @i.c.a.d
    public static final f a(int i2) {
        return new i(i2, i2 >> 31);
    }

    public static final int b(int i2) {
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    public static final int b(int i2, int i3) {
        return (i2 >>> (32 - i3)) & ((-i3) >> 31);
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final f a(long j2) {
        return new i((int) j2, (int) (j2 >> 32));
    }

    @t0(version = "1.3")
    public static final int a(@i.c.a.d f fVar, @i.c.a.d k kVar) {
        i0.f(fVar, "$this$nextInt");
        i0.f(kVar, "range");
        if (!kVar.isEmpty()) {
            return kVar.getLast() < Integer.MAX_VALUE ? fVar.a(kVar.getFirst(), kVar.getLast() + 1) : kVar.getFirst() > Integer.MIN_VALUE ? fVar.a(kVar.getFirst() - 1, kVar.getLast()) + 1 : fVar.d();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + kVar);
    }

    @t0(version = "1.3")
    public static final long a(@i.c.a.d f fVar, @i.c.a.d n nVar) {
        i0.f(fVar, "$this$nextLong");
        i0.f(nVar, "range");
        if (!nVar.isEmpty()) {
            return nVar.getLast() < m0.f16408b ? fVar.a(nVar.getFirst(), nVar.getLast() + 1) : nVar.getFirst() > Long.MIN_VALUE ? fVar.a(nVar.getFirst() - 1, nVar.getLast()) + 1 : fVar.e();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + nVar);
    }

    public static final void a(int i2, int i3) {
        if (!(i3 > i2)) {
            throw new IllegalArgumentException(a(Integer.valueOf(i2), Integer.valueOf(i3)).toString());
        }
    }

    public static final void a(long j2, long j3) {
        if (!(j3 > j2)) {
            throw new IllegalArgumentException(a(Long.valueOf(j2), Long.valueOf(j3)).toString());
        }
    }

    public static final void a(double d2, double d3) {
        if (!(d3 > d2)) {
            throw new IllegalArgumentException(a(Double.valueOf(d2), Double.valueOf(d3)).toString());
        }
    }

    @i.c.a.d
    public static final String a(@i.c.a.d Object obj, @i.c.a.d Object obj2) {
        i0.f(obj, "from");
        i0.f(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }
}
