package h.u2;

import h.b2;
import h.g1;
import h.j1;
import h.k;
import h.n1;
import h.q2.t.i0;
import h.t0;
import h.v2.t;
import h.v2.w;

/* compiled from: URandom.kt */
/* loaded from: classes2.dex */
public final class h {
    @t0(version = "1.3")
    @k
    public static final int a(@i.c.a.d f fVar) {
        i0.f(fVar, "$this$nextUInt");
        return j1.c(fVar.d());
    }

    @t0(version = "1.3")
    @k
    public static final int b(@i.c.a.d f fVar, int i2) {
        i0.f(fVar, "$this$nextUInt");
        return a(fVar, 0, i2);
    }

    @t0(version = "1.3")
    @k
    public static final int a(@i.c.a.d f fVar, int i2, int i3) {
        i0.f(fVar, "$this$nextUInt");
        a(i2, i3);
        return j1.c(fVar.a(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @t0(version = "1.3")
    @k
    public static final long b(@i.c.a.d f fVar) {
        i0.f(fVar, "$this$nextULong");
        return n1.c(fVar.e());
    }

    @t0(version = "1.3")
    @k
    public static final int a(@i.c.a.d f fVar, @i.c.a.d t tVar) {
        i0.f(fVar, "$this$nextUInt");
        i0.f(tVar, "range");
        if (!tVar.isEmpty()) {
            return b2.a(tVar.getLast(), -1) < 0 ? a(fVar, tVar.getFirst(), j1.c(tVar.getLast() + 1)) : b2.a(tVar.getFirst(), 0) > 0 ? j1.c(a(fVar, j1.c(tVar.getFirst() - 1), tVar.getLast()) + 1) : a(fVar);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + tVar);
    }

    @t0(version = "1.3")
    @k
    public static final long a(@i.c.a.d f fVar, long j2) {
        i0.f(fVar, "$this$nextULong");
        return a(fVar, 0L, j2);
    }

    @t0(version = "1.3")
    @k
    public static final long a(@i.c.a.d f fVar, long j2, long j3) {
        i0.f(fVar, "$this$nextULong");
        a(j2, j3);
        return n1.c(fVar.a(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    @t0(version = "1.3")
    @k
    public static final long a(@i.c.a.d f fVar, @i.c.a.d w wVar) {
        i0.f(fVar, "$this$nextULong");
        i0.f(wVar, "range");
        if (!wVar.isEmpty()) {
            if (b2.a(wVar.getLast(), -1L) < 0) {
                return a(fVar, wVar.getFirst(), n1.c(wVar.getLast() + n1.c(1 & 4294967295L)));
            }
            if (b2.a(wVar.getFirst(), 0L) <= 0) {
                return b(fVar);
            }
            long j2 = 1 & 4294967295L;
            return n1.c(a(fVar, n1.c(wVar.getFirst() - n1.c(j2)), wVar.getLast()) + n1.c(j2));
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + wVar);
    }

    @t0(version = "1.3")
    @k
    @i.c.a.d
    public static final byte[] a(@i.c.a.d f fVar, @i.c.a.d byte[] bArr) {
        i0.f(fVar, "$this$nextUBytes");
        i0.f(bArr, "array");
        fVar.a(bArr);
        return bArr;
    }

    @t0(version = "1.3")
    @k
    @i.c.a.d
    public static final byte[] a(@i.c.a.d f fVar, int i2) {
        i0.f(fVar, "$this$nextUBytes");
        return g1.b(fVar.b(i2));
    }

    public static /* synthetic */ byte[] a(f fVar, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = g1.c(bArr);
        }
        return a(fVar, bArr, i2, i3);
    }

    @t0(version = "1.3")
    @k
    @i.c.a.d
    public static final byte[] a(@i.c.a.d f fVar, @i.c.a.d byte[] bArr, int i2, int i3) {
        i0.f(fVar, "$this$nextUBytes");
        i0.f(bArr, "array");
        fVar.a(bArr, i2, i3);
        return bArr;
    }

    @k
    public static final void a(int i2, int i3) {
        if (!(b2.a(i3, i2) > 0)) {
            throw new IllegalArgumentException(g.a(j1.a(i2), j1.a(i3)).toString());
        }
    }

    @k
    public static final void a(long j2, long j3) {
        if (!(b2.a(j3, j2) > 0)) {
            throw new IllegalArgumentException(g.a(n1.a(j2), n1.a(j3)).toString());
        }
    }
}
