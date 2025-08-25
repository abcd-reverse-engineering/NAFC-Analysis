package h.v2;

import h.q2.t.i0;
import h.q2.t.m0;
import h.t0;
import h.v2.a;
import h.v2.i;
import h.v2.l;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Ranges.kt */
/* loaded from: classes2.dex */
public class q extends p {
    public static final byte a(byte b2, byte b3) {
        return b2 < b3 ? b3 : b2;
    }

    public static int a(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final int a(@i.c.a.d k kVar) {
        return a(kVar, (h.u2.f) h.u2.f.f16499c);
    }

    public static final long a(long j2, long j3) {
        return j2 < j3 ? j3 : j2;
    }

    public static final short a(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    public static final byte b(byte b2, byte b3) {
        return b2 > b3 ? b3 : b2;
    }

    public static final double b(double d2, double d3) {
        return d2 < d3 ? d3 : d2;
    }

    public static final float b(float f2, float f3) {
        return f2 < f3 ? f3 : f2;
    }

    public static int b(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    public static final long b(long j2, long j3) {
        return j2 > j3 ? j3 : j2;
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.j
    private static final Integer b(@i.c.a.d k kVar) {
        return b(kVar, h.u2.f.f16499c);
    }

    public static final short b(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    public static final double c(double d2, double d3) {
        return d2 > d3 ? d3 : d2;
    }

    public static final float c(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    @h.q2.e(name = "intRangeContains")
    public static final boolean c(@i.c.a.d g<Integer> gVar, byte b2) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Integer.valueOf(b2));
    }

    @h.q2.e(name = "longRangeContains")
    public static final boolean d(@i.c.a.d g<Long> gVar, byte b2) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Long.valueOf(b2));
    }

    @h.q2.e(name = "shortRangeContains")
    public static final boolean e(@i.c.a.d g<Short> gVar, byte b2) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Short.valueOf(b2));
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final long a(@i.c.a.d n nVar) {
        return a(nVar, (h.u2.f) h.u2.f.f16499c);
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.j
    private static final Long b(@i.c.a.d n nVar) {
        return b(nVar, h.u2.f.f16499c);
    }

    @h.q2.e(name = "intRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean c(@i.c.a.d g<Integer> gVar, double d2) {
        i0.f(gVar, "$this$contains");
        Integer numB = b(d2);
        if (numB != null) {
            return gVar.contains(numB);
        }
        return false;
    }

    @h.q2.e(name = "longRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean d(@i.c.a.d g<Long> gVar, double d2) {
        i0.f(gVar, "$this$contains");
        Long lC = c(d2);
        if (lC != null) {
            return gVar.contains(lC);
        }
        return false;
    }

    @h.q2.e(name = "shortRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean e(@i.c.a.d g<Short> gVar, double d2) {
        i0.f(gVar, "$this$contains");
        Short shD = d(d2);
        if (shD != null) {
            return gVar.contains(shD);
        }
        return false;
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final char a(@i.c.a.d c cVar) {
        return a(cVar, (h.u2.f) h.u2.f.f16499c);
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.j
    private static final Character b(@i.c.a.d c cVar) {
        return b(cVar, h.u2.f.f16499c);
    }

    @h.q2.e(name = "intRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean c(@i.c.a.d g<Integer> gVar, float f2) {
        i0.f(gVar, "$this$contains");
        Integer numB = b(f2);
        if (numB != null) {
            return gVar.contains(numB);
        }
        return false;
    }

    @h.q2.e(name = "longRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean d(@i.c.a.d g<Long> gVar, float f2) {
        i0.f(gVar, "$this$contains");
        Long lC = c(f2);
        if (lC != null) {
            return gVar.contains(lC);
        }
        return false;
    }

    @h.q2.e(name = "shortRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean e(@i.c.a.d g<Short> gVar, float f2) {
        i0.f(gVar, "$this$contains");
        Short shD = d(f2);
        if (shD != null) {
            return gVar.contains(shD);
        }
        return false;
    }

    @t0(version = "1.3")
    public static final int a(@i.c.a.d k kVar, @i.c.a.d h.u2.f fVar) {
        i0.f(kVar, "$this$random");
        i0.f(fVar, "random");
        try {
            return h.u2.g.a(fVar, kVar);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.e
    public static final Integer b(@i.c.a.d k kVar, @i.c.a.d h.u2.f fVar) {
        i0.f(kVar, "$this$randomOrNull");
        i0.f(fVar, "random");
        if (kVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(h.u2.g.a(fVar, kVar));
    }

    @h.q2.e(name = "floatRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean c(@i.c.a.d g<Float> gVar, int i2) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Float.valueOf(i2));
    }

    @h.q2.e(name = "longRangeContains")
    public static final boolean d(@i.c.a.d g<Long> gVar, int i2) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Long.valueOf(i2));
    }

    @h.q2.e(name = "shortRangeContains")
    public static final boolean e(@i.c.a.d g<Short> gVar, int i2) {
        i0.f(gVar, "$this$contains");
        Short shB = b(i2);
        if (shB != null) {
            return gVar.contains(shB);
        }
        return false;
    }

    @h.q2.e(name = "floatRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean c(@i.c.a.d g<Float> gVar, long j2) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Float.valueOf(j2));
    }

    @h.q2.e(name = "intRangeContains")
    public static final boolean d(@i.c.a.d g<Integer> gVar, long j2) {
        i0.f(gVar, "$this$contains");
        Integer numB = b(j2);
        if (numB != null) {
            return gVar.contains(numB);
        }
        return false;
    }

    @h.q2.e(name = "shortRangeContains")
    public static final boolean e(@i.c.a.d g<Short> gVar, long j2) {
        i0.f(gVar, "$this$contains");
        Short shC = c(j2);
        if (shC != null) {
            return gVar.contains(shC);
        }
        return false;
    }

    @t0(version = "1.3")
    public static final long a(@i.c.a.d n nVar, @i.c.a.d h.u2.f fVar) {
        i0.f(nVar, "$this$random");
        i0.f(fVar, "random");
        try {
            return h.u2.g.a(fVar, nVar);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.e
    public static final Long b(@i.c.a.d n nVar, @i.c.a.d h.u2.f fVar) {
        i0.f(nVar, "$this$randomOrNull");
        i0.f(fVar, "random");
        if (nVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(h.u2.g.a(fVar, nVar));
    }

    @h.q2.e(name = "floatRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean c(@i.c.a.d g<Float> gVar, short s) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Float.valueOf(s));
    }

    @h.q2.e(name = "intRangeContains")
    public static final boolean d(@i.c.a.d g<Integer> gVar, short s) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Integer.valueOf(s));
    }

    @h.q2.e(name = "longRangeContains")
    public static final boolean e(@i.c.a.d g<Long> gVar, short s) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Long.valueOf(s));
    }

    @i.c.a.d
    public static final i c(byte b2, byte b3) {
        return i.f16523d.a(b2, b3, -1);
    }

    @i.c.a.e
    public static final Short d(double d2) {
        double d3 = 32767;
        if (d2 < -32768 || d2 > d3) {
            return null;
        }
        return Short.valueOf((short) d2);
    }

    @t0(version = "1.3")
    public static final char a(@i.c.a.d c cVar, @i.c.a.d h.u2.f fVar) {
        i0.f(cVar, "$this$random");
        i0.f(fVar, "random");
        try {
            return (char) fVar.a((int) cVar.getFirst(), cVar.getLast() + 1);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.e
    public static final Character b(@i.c.a.d c cVar, @i.c.a.d h.u2.f fVar) {
        i0.f(cVar, "$this$randomOrNull");
        i0.f(fVar, "random");
        if (cVar.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) fVar.a((int) cVar.getFirst(), cVar.getLast() + 1));
    }

    @i.c.a.d
    public static i c(int i2, int i3) {
        return i.f16523d.a(i2, i3, -1);
    }

    @i.c.a.e
    public static final Short d(float f2) {
        float f3 = 32767;
        if (f2 < -32768 || f2 > f3) {
            return null;
        }
        return Short.valueOf((short) f2);
    }

    @i.c.a.d
    public static final l c(long j2, long j3) {
        return l.f16533d.a(j2, j3, -1L);
    }

    @i.c.a.d
    public static final k d(byte b2, byte b3) {
        return new k(b2, b3 - 1);
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final boolean a(@i.c.a.d k kVar, Integer num) {
        i0.f(kVar, "$this$contains");
        return num != null && kVar.a(num.intValue());
    }

    @h.q2.e(name = "floatRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean b(@i.c.a.d g<Float> gVar, byte b2) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Float.valueOf(b2));
    }

    @i.c.a.d
    public static final i c(short s, short s2) {
        return i.f16523d.a(s, s2, -1);
    }

    @i.c.a.d
    public static k d(int i2, int i3) {
        if (i3 <= Integer.MIN_VALUE) {
            return k.f16532f.a();
        }
        return new k(i2, i3 - 1);
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final boolean a(@i.c.a.d n nVar, Long l2) {
        i0.f(nVar, "$this$contains");
        return l2 != null && nVar.a(l2.longValue());
    }

    @h.q2.e(name = "floatRangeContains")
    public static final boolean b(@i.c.a.d g<Float> gVar, double d2) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Float.valueOf((float) d2));
    }

    @i.c.a.e
    public static final Long c(double d2) {
        double d3 = Long.MIN_VALUE;
        double d4 = m0.f16408b;
        if (d2 < d3 || d2 > d4) {
            return null;
        }
        return Long.valueOf((long) d2);
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final boolean a(@i.c.a.d c cVar, Character ch) {
        i0.f(cVar, "$this$contains");
        return ch != null && cVar.a(ch.charValue());
    }

    @h.q2.e(name = "doubleRangeContains")
    public static final boolean b(@i.c.a.d g<Double> gVar, float f2) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Double.valueOf(f2));
    }

    @i.c.a.e
    public static final Long c(float f2) {
        float f3 = Long.MIN_VALUE;
        float f4 = m0.f16408b;
        if (f2 < f3 || f2 > f4) {
            return null;
        }
        return Long.valueOf((long) f2);
    }

    @i.c.a.d
    public static final n d(long j2, long j3) {
        if (j3 <= Long.MIN_VALUE) {
            return n.f16542f.a();
        }
        return new n(j2, j3 - 1);
    }

    @h.q2.e(name = "doubleRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean a(@i.c.a.d g<Double> gVar, byte b2) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Double.valueOf(b2));
    }

    @h.q2.e(name = "doubleRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean b(@i.c.a.d g<Double> gVar, int i2) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Double.valueOf(i2));
    }

    @i.c.a.e
    public static final Short c(long j2) {
        long j3 = 32767;
        if (-32768 <= j2 && j3 >= j2) {
            return Short.valueOf((short) j2);
        }
        return null;
    }

    @h.q2.e(name = "byteRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean a(@i.c.a.d g<Byte> gVar, double d2) {
        i0.f(gVar, "$this$contains");
        Byte bA = a(d2);
        if (bA != null) {
            return gVar.contains(bA);
        }
        return false;
    }

    @h.q2.e(name = "doubleRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean b(@i.c.a.d g<Double> gVar, long j2) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Double.valueOf(j2));
    }

    @i.c.a.d
    public static final <T extends Comparable<? super T>> T c(@i.c.a.d T t, @i.c.a.d T t2) {
        i0.f(t, "$this$coerceAtMost");
        i0.f(t2, "maximumValue");
        return t.compareTo(t2) > 0 ? t2 : t;
    }

    @i.c.a.d
    public static final k d(short s, short s2) {
        return new k(s, s2 - 1);
    }

    @h.q2.e(name = "byteRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean a(@i.c.a.d g<Byte> gVar, float f2) {
        i0.f(gVar, "$this$contains");
        Byte bA = a(f2);
        if (bA != null) {
            return gVar.contains(bA);
        }
        return false;
    }

    @h.q2.e(name = "doubleRangeContains")
    @h.c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final boolean b(@i.c.a.d g<Double> gVar, short s) {
        i0.f(gVar, "$this$contains");
        return gVar.contains(Double.valueOf(s));
    }

    @h.q2.e(name = "byteRangeContains")
    public static final boolean a(@i.c.a.d g<Byte> gVar, int i2) {
        i0.f(gVar, "$this$contains");
        Byte bA = a(i2);
        if (bA != null) {
            return gVar.contains(bA);
        }
        return false;
    }

    @i.c.a.e
    public static final Integer b(long j2) {
        long j3 = Integer.MAX_VALUE;
        if (Integer.MIN_VALUE <= j2 && j3 >= j2) {
            return Integer.valueOf((int) j2);
        }
        return null;
    }

    @h.q2.e(name = "byteRangeContains")
    public static final boolean a(@i.c.a.d g<Byte> gVar, long j2) {
        i0.f(gVar, "$this$contains");
        Byte bA = a(j2);
        if (bA != null) {
            return gVar.contains(bA);
        }
        return false;
    }

    @i.c.a.e
    public static final Integer b(double d2) {
        double d3 = Integer.MAX_VALUE;
        if (d2 < Integer.MIN_VALUE || d2 > d3) {
            return null;
        }
        return Integer.valueOf((int) d2);
    }

    @h.q2.e(name = "byteRangeContains")
    public static final boolean a(@i.c.a.d g<Byte> gVar, short s) {
        i0.f(gVar, "$this$contains");
        Byte bA = a(s);
        if (bA != null) {
            return gVar.contains(bA);
        }
        return false;
    }

    @i.c.a.e
    public static final Integer b(float f2) {
        float f3 = Integer.MAX_VALUE;
        if (f2 < Integer.MIN_VALUE || f2 > f3) {
            return null;
        }
        return Integer.valueOf((int) f2);
    }

    @i.c.a.d
    public static final i a(int i2, byte b2) {
        return i.f16523d.a(i2, b2, -1);
    }

    @i.c.a.e
    public static final Short b(int i2) {
        if (-32768 <= i2 && 32767 >= i2) {
            return Short.valueOf((short) i2);
        }
        return null;
    }

    @i.c.a.d
    public static final l a(long j2, byte b2) {
        return l.f16533d.a(j2, b2, -1L);
    }

    @i.c.a.d
    public static final k b(int i2, byte b2) {
        return new k(i2, b2 - 1);
    }

    @i.c.a.d
    public static final i a(short s, byte b2) {
        return i.f16523d.a(s, b2, -1);
    }

    @i.c.a.d
    public static final n b(long j2, byte b2) {
        return new n(j2, b2 - 1);
    }

    @i.c.a.d
    public static final a a(char c2, char c3) {
        return a.f16507d.a(c2, c3, -1);
    }

    @i.c.a.d
    public static final k b(short s, byte b2) {
        return new k(s, b2 - 1);
    }

    @i.c.a.d
    public static final l a(long j2, int i2) {
        return l.f16533d.a(j2, i2, -1L);
    }

    @i.c.a.d
    public static final c b(char c2, char c3) {
        if (c3 <= 0) {
            return c.f16516f.a();
        }
        return new c(c2, (char) (c3 - 1));
    }

    @i.c.a.d
    public static final i a(byte b2, int i2) {
        return i.f16523d.a(b2, i2, -1);
    }

    @i.c.a.d
    public static final i a(short s, int i2) {
        return i.f16523d.a(s, i2, -1);
    }

    @i.c.a.d
    public static final n b(long j2, int i2) {
        return new n(j2, i2 - 1);
    }

    @i.c.a.d
    public static final l a(int i2, long j2) {
        return l.f16533d.a(i2, j2, -1L);
    }

    @i.c.a.d
    public static final k b(byte b2, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return k.f16532f.a();
        }
        return new k(b2, i2 - 1);
    }

    @i.c.a.d
    public static final l a(byte b2, long j2) {
        return l.f16533d.a(b2, j2, -1L);
    }

    @i.c.a.d
    public static final l a(short s, long j2) {
        return l.f16533d.a(s, j2, -1L);
    }

    @i.c.a.d
    public static final k b(short s, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return k.f16532f.a();
        }
        return new k(s, i2 - 1);
    }

    @i.c.a.d
    public static final i a(int i2, short s) {
        return i.f16523d.a(i2, s, -1);
    }

    @i.c.a.d
    public static final l a(long j2, short s) {
        return l.f16533d.a(j2, s, -1L);
    }

    @i.c.a.d
    public static final n b(int i2, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return n.f16542f.a();
        }
        return new n(i2, j2 - 1);
    }

    @i.c.a.d
    public static final i a(byte b2, short s) {
        return i.f16523d.a(b2, s, -1);
    }

    @i.c.a.d
    public static final i a(@i.c.a.d i iVar) {
        i0.f(iVar, "$this$reversed");
        return i.f16523d.a(iVar.getLast(), iVar.getFirst(), -iVar.b());
    }

    @i.c.a.d
    public static final n b(byte b2, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return n.f16542f.a();
        }
        return new n(b2, j2 - 1);
    }

    @i.c.a.d
    public static final l a(@i.c.a.d l lVar) {
        i0.f(lVar, "$this$reversed");
        return l.f16533d.a(lVar.getLast(), lVar.getFirst(), -lVar.b());
    }

    @i.c.a.d
    public static final a a(@i.c.a.d a aVar) {
        i0.f(aVar, "$this$reversed");
        return a.f16507d.a(aVar.getLast(), aVar.getFirst(), -aVar.b());
    }

    @i.c.a.d
    public static final n b(short s, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return n.f16542f.a();
        }
        return new n(s, j2 - 1);
    }

    @i.c.a.d
    public static i a(@i.c.a.d i iVar, int i2) {
        i0.f(iVar, "$this$step");
        p.a(i2 > 0, Integer.valueOf(i2));
        i.a aVar = i.f16523d;
        int first = iVar.getFirst();
        int last = iVar.getLast();
        if (iVar.b() <= 0) {
            i2 = -i2;
        }
        return aVar.a(first, last, i2);
    }

    @i.c.a.d
    public static final k b(int i2, short s) {
        return new k(i2, s - 1);
    }

    @i.c.a.d
    public static final l a(@i.c.a.d l lVar, long j2) {
        i0.f(lVar, "$this$step");
        p.a(j2 > 0, Long.valueOf(j2));
        l.a aVar = l.f16533d;
        long first = lVar.getFirst();
        long last = lVar.getLast();
        if (lVar.b() <= 0) {
            j2 = -j2;
        }
        return aVar.a(first, last, j2);
    }

    @i.c.a.d
    public static final n b(long j2, short s) {
        return new n(j2, s - 1);
    }

    @i.c.a.d
    public static final k b(byte b2, short s) {
        return new k(b2, s - 1);
    }

    @i.c.a.d
    public static final a a(@i.c.a.d a aVar, int i2) {
        i0.f(aVar, "$this$step");
        p.a(i2 > 0, Integer.valueOf(i2));
        a.C0249a c0249a = a.f16507d;
        char first = aVar.getFirst();
        char last = aVar.getLast();
        if (aVar.b() <= 0) {
            i2 = -i2;
        }
        return c0249a.a(first, last, i2);
    }

    @i.c.a.d
    public static final <T extends Comparable<? super T>> T b(@i.c.a.d T t, @i.c.a.d T t2) {
        i0.f(t, "$this$coerceAtLeast");
        i0.f(t2, "minimumValue");
        return t.compareTo(t2) < 0 ? t2 : t;
    }

    @i.c.a.e
    public static final Byte a(int i2) {
        if (-128 <= i2 && 127 >= i2) {
            return Byte.valueOf((byte) i2);
        }
        return null;
    }

    @i.c.a.e
    public static final Byte a(long j2) {
        long j3 = 127;
        if (-128 <= j2 && j3 >= j2) {
            return Byte.valueOf((byte) j2);
        }
        return null;
    }

    @i.c.a.e
    public static final Byte a(short s) {
        short s2 = (short) 127;
        if (((short) (-128)) <= s && s2 >= s) {
            return Byte.valueOf((byte) s);
        }
        return null;
    }

    @i.c.a.e
    public static final Byte a(double d2) {
        double d3 = 127;
        if (d2 < -128 || d2 > d3) {
            return null;
        }
        return Byte.valueOf((byte) d2);
    }

    @i.c.a.e
    public static final Byte a(float f2) {
        float f3 = 127;
        if (f2 < -128 || f2 > f3) {
            return null;
        }
        return Byte.valueOf((byte) f2);
    }

    @i.c.a.d
    public static final <T extends Comparable<? super T>> T a(@i.c.a.d T t, @i.c.a.e T t2, @i.c.a.e T t3) {
        i0.f(t, "$this$coerceIn");
        if (t2 != null && t3 != null) {
            if (t2.compareTo(t3) <= 0) {
                if (t.compareTo(t2) < 0) {
                    return t2;
                }
                if (t.compareTo(t3) > 0) {
                    return t3;
                }
            } else {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t3 + " is less than minimum " + t2 + '.');
            }
        } else {
            if (t2 != null && t.compareTo(t2) < 0) {
                return t2;
            }
            if (t3 != null && t.compareTo(t3) > 0) {
                return t3;
            }
        }
        return t;
    }

    public static final byte a(byte b2, byte b3, byte b4) {
        if (b3 <= b4) {
            return b2 < b3 ? b3 : b2 > b4 ? b4 : b2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b4) + " is less than minimum " + ((int) b3) + '.');
    }

    public static final short a(short s, short s2, short s3) {
        if (s2 <= s3) {
            return s < s2 ? s2 : s > s3 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s3) + " is less than minimum " + ((int) s2) + '.');
    }

    public static int a(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    public static final long a(long j2, long j3, long j4) {
        if (j3 <= j4) {
            return j2 < j3 ? j3 : j2 > j4 ? j4 : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j4 + " is less than minimum " + j3 + '.');
    }

    public static final float a(float f2, float f3, float f4) {
        if (f3 <= f4) {
            return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f4 + " is less than minimum " + f3 + '.');
    }

    public static final double a(double d2, double d3, double d4) {
        if (d3 <= d4) {
            return d2 < d3 ? d3 : d2 > d4 ? d4 : d2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d4 + " is less than minimum " + d3 + '.');
    }

    @t0(version = "1.1")
    @i.c.a.d
    public static final <T extends Comparable<? super T>> T a(@i.c.a.d T t, @i.c.a.d f<T> fVar) {
        i0.f(t, "$this$coerceIn");
        i0.f(fVar, "range");
        if (!fVar.isEmpty()) {
            return (!fVar.a(t, fVar.getStart()) || fVar.a(fVar.getStart(), t)) ? (!fVar.a(fVar.getEndInclusive(), t) || fVar.a(t, fVar.getEndInclusive())) ? t : fVar.getEndInclusive() : fVar.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + fVar + '.');
    }

    @i.c.a.d
    public static final <T extends Comparable<? super T>> T a(@i.c.a.d T t, @i.c.a.d g<T> gVar) {
        i0.f(t, "$this$coerceIn");
        i0.f(gVar, "range");
        if (gVar instanceof f) {
            return (T) a((Comparable) t, (f) gVar);
        }
        if (!gVar.isEmpty()) {
            return t.compareTo(gVar.getStart()) < 0 ? (T) gVar.getStart() : t.compareTo(gVar.getEndInclusive()) > 0 ? (T) gVar.getEndInclusive() : t;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + '.');
    }

    public static final int a(int i2, @i.c.a.d g<Integer> gVar) {
        i0.f(gVar, "range");
        if (gVar instanceof f) {
            return ((Number) a(Integer.valueOf(i2), (f<Integer>) gVar)).intValue();
        }
        if (!gVar.isEmpty()) {
            return i2 < ((Number) gVar.getStart()).intValue() ? ((Number) gVar.getStart()).intValue() : i2 > ((Number) gVar.getEndInclusive()).intValue() ? ((Number) gVar.getEndInclusive()).intValue() : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + '.');
    }

    public static final long a(long j2, @i.c.a.d g<Long> gVar) {
        i0.f(gVar, "range");
        if (gVar instanceof f) {
            return ((Number) a(Long.valueOf(j2), (f<Long>) gVar)).longValue();
        }
        if (!gVar.isEmpty()) {
            return j2 < ((Number) gVar.getStart()).longValue() ? ((Number) gVar.getStart()).longValue() : j2 > ((Number) gVar.getEndInclusive()).longValue() ? ((Number) gVar.getEndInclusive()).longValue() : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + '.');
    }
}
