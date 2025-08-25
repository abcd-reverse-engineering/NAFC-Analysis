package h.v2;

import h.b2;
import h.f1;
import h.j1;
import h.n1;
import h.q2.t.i0;
import h.t0;
import h.t1;
import h.v2.r;
import h.v2.u;
import java.util.NoSuchElementException;

/* compiled from: _URanges.kt */
/* loaded from: classes2.dex */
class y {
    @h.m2.f
    @t0(version = "1.3")
    @h.k
    private static final int a(@i.c.a.d t tVar) {
        return a(tVar, h.u2.f.f16499c);
    }

    @h.m2.f
    @h.j
    @t0(version = "1.3")
    @h.k
    private static final j1 b(@i.c.a.d t tVar) {
        return b(tVar, h.u2.f.f16499c);
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final r c(byte b2, byte b3) {
        return r.f16543d.a(j1.c(b2 & f1.f16099c), j1.c(b3 & f1.f16099c), -1);
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final t d(byte b2, byte b3) {
        return i0.a(b3 & f1.f16099c, 0) <= 0 ? t.f16552f.a() : new t(j1.c(b2 & f1.f16099c), j1.c(j1.c(r3) - 1), null);
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.k
    private static final long a(@i.c.a.d w wVar) {
        return a(wVar, h.u2.f.f16499c);
    }

    @h.m2.f
    @h.j
    @t0(version = "1.3")
    @h.k
    private static final n1 b(@i.c.a.d w wVar) {
        return b(wVar, h.u2.f.f16499c);
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final r c(int i2, int i3) {
        return r.f16543d.a(i2, i3, -1);
    }

    @t0(version = "1.3")
    @h.k
    public static final int a(@i.c.a.d t tVar, @i.c.a.d h.u2.f fVar) {
        i0.f(tVar, "$this$random");
        i0.f(fVar, "random");
        try {
            return h.u2.h.a(fVar, tVar);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @h.j
    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final j1 b(@i.c.a.d t tVar, @i.c.a.d h.u2.f fVar) {
        i0.f(tVar, "$this$randomOrNull");
        i0.f(fVar, "random");
        if (tVar.isEmpty()) {
            return null;
        }
        return j1.a(h.u2.h.a(fVar, tVar));
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final u c(long j2, long j3) {
        return u.f16553d.a(j2, j3, -1L);
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final t d(int i2, int i3) {
        return b2.a(i3, 0) <= 0 ? t.f16552f.a() : new t(i2, j1.c(i3 - 1), null);
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final r c(short s, short s2) {
        return r.f16543d.a(j1.c(s & t1.f16480c), j1.c(s2 & t1.f16480c), -1);
    }

    @t0(version = "1.3")
    @h.k
    public static final long a(@i.c.a.d w wVar, @i.c.a.d h.u2.f fVar) {
        i0.f(wVar, "$this$random");
        i0.f(fVar, "random");
        try {
            return h.u2.h.a(fVar, wVar);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @h.j
    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final n1 b(@i.c.a.d w wVar, @i.c.a.d h.u2.f fVar) {
        i0.f(wVar, "$this$randomOrNull");
        i0.f(fVar, "random");
        if (wVar.isEmpty()) {
            return null;
        }
        return n1.a(h.u2.h.a(fVar, wVar));
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final w d(long j2, long j3) {
        return b2.a(j3, 0L) <= 0 ? w.f16562f.a() : new w(j2, n1.c(j3 - n1.c(1 & 4294967295L)), null);
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.k
    private static final boolean a(@i.c.a.d t tVar, j1 j1Var) {
        i0.f(tVar, "$this$contains");
        return j1Var != null && tVar.a(j1Var.a());
    }

    @t0(version = "1.3")
    @h.k
    public static final int b(int i2, int i3) {
        return b2.a(i2, i3) > 0 ? i3 : i2;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final t d(short s, short s2) {
        return i0.a(s2 & t1.f16480c, 0) <= 0 ? t.f16552f.a() : new t(j1.c(s & t1.f16480c), j1.c(j1.c(r3) - 1), null);
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.k
    private static final boolean a(@i.c.a.d w wVar, n1 n1Var) {
        i0.f(wVar, "$this$contains");
        return n1Var != null && wVar.a(n1Var.a());
    }

    @t0(version = "1.3")
    @h.k
    public static final long b(long j2, long j3) {
        return b2.a(j2, j3) > 0 ? j3 : j2;
    }

    @t0(version = "1.3")
    @h.k
    public static final boolean a(@i.c.a.d t tVar, byte b2) {
        i0.f(tVar, "$this$contains");
        return tVar.a(j1.c(b2 & f1.f16099c));
    }

    @t0(version = "1.3")
    @h.k
    public static final byte b(byte b2, byte b3) {
        return i0.a(b2 & f1.f16099c, b3 & f1.f16099c) > 0 ? b3 : b2;
    }

    @t0(version = "1.3")
    @h.k
    public static final boolean a(@i.c.a.d w wVar, byte b2) {
        i0.f(wVar, "$this$contains");
        return wVar.a(n1.c(b2 & 255));
    }

    @t0(version = "1.3")
    @h.k
    public static final short b(short s, short s2) {
        return i0.a(s & t1.f16480c, 65535 & s2) > 0 ? s2 : s;
    }

    @t0(version = "1.3")
    @h.k
    public static final boolean a(@i.c.a.d w wVar, int i2) {
        i0.f(wVar, "$this$contains");
        return wVar.a(n1.c(i2 & 4294967295L));
    }

    @t0(version = "1.3")
    @h.k
    public static final boolean a(@i.c.a.d t tVar, long j2) {
        i0.f(tVar, "$this$contains");
        return n1.c(j2 >>> 32) == 0 && tVar.a(j1.c((int) j2));
    }

    @t0(version = "1.3")
    @h.k
    public static final boolean a(@i.c.a.d t tVar, short s) {
        i0.f(tVar, "$this$contains");
        return tVar.a(j1.c(s & t1.f16480c));
    }

    @t0(version = "1.3")
    @h.k
    public static final boolean a(@i.c.a.d w wVar, short s) {
        i0.f(wVar, "$this$contains");
        return wVar.a(n1.c(s & 65535));
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final r a(@i.c.a.d r rVar) {
        i0.f(rVar, "$this$reversed");
        return r.f16543d.a(rVar.getLast(), rVar.getFirst(), -rVar.b());
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final u a(@i.c.a.d u uVar) {
        i0.f(uVar, "$this$reversed");
        return u.f16553d.a(uVar.getLast(), uVar.getFirst(), -uVar.b());
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final r a(@i.c.a.d r rVar, int i2) {
        i0.f(rVar, "$this$step");
        p.a(i2 > 0, Integer.valueOf(i2));
        r.a aVar = r.f16543d;
        int first = rVar.getFirst();
        int last = rVar.getLast();
        if (rVar.b() <= 0) {
            i2 = -i2;
        }
        return aVar.a(first, last, i2);
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final u a(@i.c.a.d u uVar, long j2) {
        i0.f(uVar, "$this$step");
        p.a(j2 > 0, Long.valueOf(j2));
        u.a aVar = u.f16553d;
        long first = uVar.getFirst();
        long last = uVar.getLast();
        if (uVar.b() <= 0) {
            j2 = -j2;
        }
        return aVar.a(first, last, j2);
    }

    @t0(version = "1.3")
    @h.k
    public static final int a(int i2, int i3) {
        return b2.a(i2, i3) < 0 ? i3 : i2;
    }

    @t0(version = "1.3")
    @h.k
    public static final long a(long j2, long j3) {
        return b2.a(j2, j3) < 0 ? j3 : j2;
    }

    @t0(version = "1.3")
    @h.k
    public static final byte a(byte b2, byte b3) {
        return i0.a(b2 & f1.f16099c, b3 & f1.f16099c) < 0 ? b3 : b2;
    }

    @t0(version = "1.3")
    @h.k
    public static final short a(short s, short s2) {
        return i0.a(s & t1.f16480c, 65535 & s2) < 0 ? s2 : s;
    }

    @t0(version = "1.3")
    @h.k
    public static final int a(int i2, int i3, int i4) {
        if (b2.a(i3, i4) <= 0) {
            return b2.a(i2, i3) < 0 ? i3 : b2.a(i2, i4) > 0 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j1.n(i4) + " is less than minimum " + j1.n(i3) + '.');
    }

    @t0(version = "1.3")
    @h.k
    public static final long a(long j2, long j3, long j4) {
        if (b2.a(j3, j4) <= 0) {
            return b2.a(j2, j3) < 0 ? j3 : b2.a(j2, j4) > 0 ? j4 : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + n1.n(j4) + " is less than minimum " + n1.n(j3) + '.');
    }

    @t0(version = "1.3")
    @h.k
    public static final byte a(byte b2, byte b3, byte b4) {
        int i2 = b3 & f1.f16099c;
        int i3 = b4 & f1.f16099c;
        if (i0.a(i2, i3) <= 0) {
            int i4 = b2 & f1.f16099c;
            return i0.a(i4, i2) < 0 ? b3 : i0.a(i4, i3) > 0 ? b4 : b2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f1.n(b4) + " is less than minimum " + f1.n(b3) + '.');
    }

    @t0(version = "1.3")
    @h.k
    public static final short a(short s, short s2, short s3) {
        int i2 = s2 & t1.f16480c;
        int i3 = s3 & t1.f16480c;
        if (i0.a(i2, i3) <= 0) {
            int i4 = 65535 & s;
            return i0.a(i4, i2) < 0 ? s2 : i0.a(i4, i3) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t1.n(s3) + " is less than minimum " + t1.n(s2) + '.');
    }

    @t0(version = "1.3")
    @h.k
    public static final int a(int i2, @i.c.a.d g<j1> gVar) {
        i0.f(gVar, "range");
        if (gVar instanceof f) {
            return ((j1) q.a(j1.a(i2), (f<j1>) gVar)).a();
        }
        if (!gVar.isEmpty()) {
            return b2.a(i2, ((j1) gVar.getStart()).a()) < 0 ? ((j1) gVar.getStart()).a() : b2.a(i2, ((j1) gVar.getEndInclusive()).a()) > 0 ? ((j1) gVar.getEndInclusive()).a() : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + '.');
    }

    @t0(version = "1.3")
    @h.k
    public static final long a(long j2, @i.c.a.d g<n1> gVar) {
        i0.f(gVar, "range");
        if (gVar instanceof f) {
            return ((n1) q.a(n1.a(j2), (f<n1>) gVar)).a();
        }
        if (!gVar.isEmpty()) {
            return b2.a(j2, ((n1) gVar.getStart()).a()) < 0 ? ((n1) gVar.getStart()).a() : b2.a(j2, ((n1) gVar.getEndInclusive()).a()) > 0 ? ((n1) gVar.getEndInclusive()).a() : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + '.');
    }
}
