package h.h2;

import com.umeng.analytics.pro.bh;
import h.q2.t.i0;
import h.t0;

/* compiled from: _ComparisonsJvm.kt */
/* loaded from: classes2.dex */
class c extends b {
    @h.m2.f
    @t0(version = "1.1")
    private static final byte a(byte b2, byte b3) {
        return (byte) Math.max((int) b2, (int) b3);
    }

    @t0(version = "1.1")
    @i.c.a.d
    public static final <T extends Comparable<? super T>> T b(@i.c.a.d T t, @i.c.a.d T t2) {
        i0.f(t, bh.ay);
        i0.f(t2, "b");
        return t.compareTo(t2) >= 0 ? t : t2;
    }

    @t0(version = "1.1")
    @i.c.a.d
    public static final <T extends Comparable<? super T>> T c(@i.c.a.d T t, @i.c.a.d T t2) {
        i0.f(t, bh.ay);
        i0.f(t2, "b");
        return t.compareTo(t2) <= 0 ? t : t2;
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final short a(short s, short s2) {
        return (short) Math.max((int) s, (int) s2);
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final byte b(byte b2, byte b3) {
        return (byte) Math.min((int) b2, (int) b3);
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final int a(int i2, int i3) {
        return Math.max(i2, i3);
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final short b(short s, short s2) {
        return (short) Math.min((int) s, (int) s2);
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final long a(long j2, long j3) {
        return Math.max(j2, j3);
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final int b(int i2, int i3) {
        return Math.min(i2, i3);
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final float a(float f2, float f3) {
        return Math.max(f2, f3);
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final long b(long j2, long j3) {
        return Math.min(j2, j3);
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final double a(double d2, double d3) {
        return Math.max(d2, d3);
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final float b(float f2, float f3) {
        return Math.min(f2, f3);
    }

    @t0(version = "1.1")
    @i.c.a.d
    public static final <T extends Comparable<? super T>> T a(@i.c.a.d T t, @i.c.a.d T t2, @i.c.a.d T t3) {
        i0.f(t, bh.ay);
        i0.f(t2, "b");
        i0.f(t3, bh.aI);
        return (T) b(t, b(t2, t3));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final double b(double d2, double d3) {
        return Math.min(d2, d3);
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final byte a(byte b2, byte b3, byte b4) {
        return (byte) Math.max((int) b2, Math.max((int) b3, (int) b4));
    }

    @t0(version = "1.1")
    @i.c.a.d
    public static final <T extends Comparable<? super T>> T b(@i.c.a.d T t, @i.c.a.d T t2, @i.c.a.d T t3) {
        i0.f(t, bh.ay);
        i0.f(t2, "b");
        i0.f(t3, bh.aI);
        return (T) c(t, c(t2, t3));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final short a(short s, short s2, short s3) {
        return (short) Math.max((int) s, Math.max((int) s2, (int) s3));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final byte b(byte b2, byte b3, byte b4) {
        return (byte) Math.min((int) b2, Math.min((int) b3, (int) b4));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final int a(int i2, int i3, int i4) {
        return Math.max(i2, Math.max(i3, i4));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final short b(short s, short s2, short s3) {
        return (short) Math.min((int) s, Math.min((int) s2, (int) s3));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final long a(long j2, long j3, long j4) {
        return Math.max(j2, Math.max(j3, j4));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final int b(int i2, int i3, int i4) {
        return Math.min(i2, Math.min(i3, i4));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final float a(float f2, float f3, float f4) {
        return Math.max(f2, Math.max(f3, f4));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final long b(long j2, long j3, long j4) {
        return Math.min(j2, Math.min(j3, j4));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final double a(double d2, double d3, double d4) {
        return Math.max(d2, Math.max(d3, d4));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final float b(float f2, float f3, float f4) {
        return Math.min(f2, Math.min(f3, f4));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final double b(double d2, double d3, double d4) {
        return Math.min(d2, Math.min(d3, d4));
    }
}
