package h.r2;

import h.m2.f;
import h.q2.t.w;
import h.q2.t.z;
import h.t0;

/* compiled from: MathJVM.kt */
/* loaded from: classes2.dex */
class d extends c {
    @f
    @t0(version = "1.2")
    private static final double A(double d2) {
        return Math.signum(d2);
    }

    @f
    @t0(version = "1.2")
    public static /* synthetic */ void B(double d2) {
    }

    @f
    @t0(version = "1.2")
    public static /* synthetic */ void B(float f2) {
    }

    @f
    @t0(version = "1.2")
    private static final double C(double d2) {
        return Math.sin(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double D(double d2) {
        return Math.sinh(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double E(double d2) {
        return Math.sqrt(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double F(double d2) {
        return Math.tan(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double G(double d2) {
        return Math.tanh(d2);
    }

    @t0(version = "1.2")
    public static final double H(double d2) {
        return (Double.isNaN(d2) || Double.isInfinite(d2)) ? d2 : d2 > ((double) 0) ? Math.floor(d2) : Math.ceil(d2);
    }

    @f
    @t0(version = "1.2")
    public static /* synthetic */ void I(double d2) {
    }

    @f
    @t0(version = "1.2")
    public static /* synthetic */ void I(float f2) {
    }

    @f
    @t0(version = "1.2")
    private static final double a(double d2) {
        return Math.abs(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double b(double d2, double d3) {
        return Math.atan2(d2, d3);
    }

    @f
    @t0(version = "1.2")
    public static /* synthetic */ void b(double d2) {
    }

    @f
    @t0(version = "1.2")
    public static /* synthetic */ void b(float f2) {
    }

    @f
    @t0(version = "1.2")
    public static /* synthetic */ void b(int i2) {
    }

    @f
    @t0(version = "1.2")
    public static /* synthetic */ void b(long j2) {
    }

    @f
    @t0(version = "1.2")
    private static final double c(double d2) {
        return Math.acos(d2);
    }

    @t0(version = "1.2")
    public static final double d(double d2) {
        double d3 = 1;
        if (d2 < d3) {
            return w.f16453f.d();
        }
        if (d2 > a.f16472e) {
            return Math.log(d2) + a.f16468a;
        }
        double d4 = d2 - d3;
        if (d4 >= a.f16471d) {
            return Math.log(d2 + Math.sqrt((d2 * d2) - d3));
        }
        double dSqrt = Math.sqrt(d4);
        if (dSqrt >= a.f16470c) {
            dSqrt -= ((dSqrt * dSqrt) * dSqrt) / 12;
        }
        return dSqrt * Math.sqrt(2.0d);
    }

    public static final int d(int i2) {
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static final int d(long j2) {
        if (j2 < 0) {
            return -1;
        }
        return j2 > 0 ? 1 : 0;
    }

    @f
    @t0(version = "1.2")
    private static final double e(double d2) {
        return Math.asin(d2);
    }

    @t0(version = "1.2")
    public static /* synthetic */ void e(int i2) {
    }

    @t0(version = "1.2")
    public static /* synthetic */ void e(long j2) {
    }

    @t0(version = "1.2")
    public static final double f(double d2) {
        double d3 = a.f16471d;
        if (d2 < d3) {
            return d2 <= (-d3) ? -f(-d2) : Math.abs(d2) >= a.f16470c ? d2 - (((d2 * d2) * d2) / 6) : d2;
        }
        if (d2 <= a.f16473f) {
            return Math.log(d2 + Math.sqrt((d2 * d2) + 1));
        }
        if (d2 > a.f16472e) {
            return Math.log(d2) + a.f16468a;
        }
        double d4 = d2 * 2;
        return Math.log(d4 + (1 / d4));
    }

    @f
    @t0(version = "1.2")
    private static final double g(double d2) {
        return Math.atan(d2);
    }

    @t0(version = "1.2")
    public static final double h(double d2) {
        if (Math.abs(d2) < a.f16471d) {
            return Math.abs(d2) > a.f16470c ? d2 + (((d2 * d2) * d2) / 3) : d2;
        }
        double d3 = 1;
        return Math.log((d3 + d2) / (d3 - d2)) / 2;
    }

    @f
    @t0(version = "1.2")
    private static final double i(double d2) {
        return Math.ceil(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double j(double d2) {
        return Math.cos(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double k(double d2) {
        return Math.cosh(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double l(double d2) {
        return Math.exp(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double m(double d2) {
        return Math.expm1(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double n(double d2) {
        return Math.floor(d2);
    }

    private static final double o(double d2) {
        return Math.abs(d2);
    }

    private static final double p(double d2) {
        return Math.signum(d2);
    }

    private static final double q(double d2) {
        return Math.ulp(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double r(double d2) {
        return Math.log(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double s(double d2) {
        return Math.log1p(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double t(double d2) {
        return Math.log10(d2);
    }

    @t0(version = "1.2")
    public static final double u(double d2) {
        return Math.log(d2) / a.f16468a;
    }

    @f
    @t0(version = "1.2")
    private static final double v(double d2) {
        return Math.nextAfter(d2, w.f16453f.c());
    }

    @f
    @t0(version = "1.2")
    private static final double w(double d2) {
        return Math.nextUp(d2);
    }

    @f
    @t0(version = "1.2")
    private static final double x(double d2) {
        return Math.rint(d2);
    }

    @t0(version = "1.2")
    public static final int y(double d2) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d2 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (d2 < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d2);
    }

    @t0(version = "1.2")
    public static final long z(double d2) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d2);
    }

    @f
    @t0(version = "1.2")
    private static final float A(float f2) {
        return Math.signum(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float C(float f2) {
        return (float) Math.sin(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float D(float f2) {
        return (float) Math.sinh(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float E(float f2) {
        return (float) Math.sqrt(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float F(float f2) {
        return (float) Math.tan(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float G(float f2) {
        return (float) Math.tanh(f2);
    }

    @f
    @t0(version = "1.2")
    private static final double a(double d2, int i2) {
        return Math.pow(d2, i2);
    }

    @f
    @t0(version = "1.2")
    private static final double b(double d2, int i2) {
        return Math.copySign(d2, i2);
    }

    @f
    @t0(version = "1.2")
    private static final double c(double d2, double d3) {
        return Math.hypot(d2, d3);
    }

    @f
    @t0(version = "1.2")
    private static final double e(double d2, double d3) {
        return Math.max(d2, d3);
    }

    @f
    @t0(version = "1.2")
    private static final double g(double d2, double d3) {
        return Math.nextAfter(d2, d3);
    }

    @f
    @t0(version = "1.2")
    private static final double i(double d2, double d3) {
        return Math.copySign(d2, d3);
    }

    @f
    @t0(version = "1.2")
    private static final float j(float f2) {
        return (float) Math.cos(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float k(float f2) {
        return (float) Math.cosh(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float l(float f2) {
        return (float) Math.exp(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float m(float f2) {
        return (float) Math.expm1(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float n(float f2) {
        return (float) Math.floor(f2);
    }

    private static final float o(float f2) {
        return Math.abs(f2);
    }

    private static final float p(float f2) {
        return Math.signum(f2);
    }

    private static final float q(float f2) {
        return Math.ulp(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float r(float f2) {
        return (float) Math.log(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float s(float f2) {
        return (float) Math.log1p(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float t(float f2) {
        return (float) Math.log10(f2);
    }

    @t0(version = "1.2")
    public static final float u(float f2) {
        return (float) (Math.log(f2) / a.f16468a);
    }

    @f
    @t0(version = "1.2")
    private static final float v(float f2) {
        return Math.nextAfter(f2, w.f16453f.c());
    }

    @f
    @t0(version = "1.2")
    private static final float w(float f2) {
        return Math.nextUp(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float x(float f2) {
        return (float) Math.rint(f2);
    }

    @t0(version = "1.2")
    public static final long z(float f2) {
        return z(f2);
    }

    @f
    @t0(version = "1.2")
    private static final double a(double d2, double d3) {
        return Math.IEEEremainder(d2, d3);
    }

    @f
    @t0(version = "1.2")
    private static final float b(float f2, float f3) {
        return (float) Math.atan2(f2, f3);
    }

    @f
    @t0(version = "1.2")
    private static final float c(float f2) {
        return (float) Math.acos(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float e(float f2) {
        return (float) Math.asin(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float g(float f2) {
        return (float) Math.atan(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float i(float f2) {
        return (float) Math.ceil(f2);
    }

    @t0(version = "1.2")
    public static final float H(float f2) {
        double dCeil;
        if (Float.isNaN(f2) || Float.isInfinite(f2)) {
            return f2;
        }
        if (f2 > 0) {
            dCeil = Math.floor(f2);
        } else {
            dCeil = Math.ceil(f2);
        }
        return (float) dCeil;
    }

    @f
    @t0(version = "1.2")
    private static final float a(float f2) {
        return Math.abs(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float b(float f2, int i2) {
        return Math.copySign(f2, i2);
    }

    @f
    @t0(version = "1.2")
    private static final float c(float f2, float f3) {
        return (float) Math.hypot(f2, f3);
    }

    @f
    @t0(version = "1.2")
    private static final float e(float f2, float f3) {
        return Math.max(f2, f3);
    }

    @f
    @t0(version = "1.2")
    private static final float g(float f2, float f3) {
        return Math.nextAfter(f2, f3);
    }

    @f
    @t0(version = "1.2")
    private static final double h(double d2, double d3) {
        return Math.pow(d2, d3);
    }

    @f
    @t0(version = "1.2")
    private static final float i(float f2, float f3) {
        return Math.copySign(f2, f3);
    }

    @t0(version = "1.2")
    public static final int y(float f2) {
        if (Float.isNaN(f2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float a(float f2, int i2) {
        return (float) Math.pow(f2, i2);
    }

    @f
    @t0(version = "1.2")
    private static final int b(int i2, int i3) {
        return Math.min(i2, i3);
    }

    private static final int c(int i2) {
        return Math.abs(i2);
    }

    @f
    @t0(version = "1.2")
    private static final float h(float f2) {
        return (float) h(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float a(float f2, float f3) {
        return (float) Math.IEEEremainder(f2, f3);
    }

    @f
    @t0(version = "1.2")
    private static final long b(long j2, long j3) {
        return Math.min(j2, j3);
    }

    private static final long c(long j2) {
        return Math.abs(j2);
    }

    @f
    @t0(version = "1.2")
    private static final float h(float f2, float f3) {
        return (float) Math.pow(f2, f3);
    }

    @f
    @t0(version = "1.2")
    private static final int a(int i2) {
        return Math.abs(i2);
    }

    @f
    @t0(version = "1.2")
    private static final int a(int i2, int i3) {
        return Math.max(i2, i3);
    }

    @f
    @t0(version = "1.2")
    private static final long a(long j2) {
        return Math.abs(j2);
    }

    @t0(version = "1.2")
    public static final double d(double d2, double d3) {
        if (d3 > 0.0d && d3 != 1.0d) {
            return Math.log(d2) / Math.log(d3);
        }
        return w.f16453f.d();
    }

    @f
    @t0(version = "1.2")
    private static final double f(double d2, double d3) {
        return Math.min(d2, d3);
    }

    @f
    @t0(version = "1.2")
    private static final long a(long j2, long j3) {
        return Math.max(j2, j3);
    }

    @f
    @t0(version = "1.2")
    private static final float f(float f2) {
        return (float) f(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float d(float f2) {
        return (float) d(f2);
    }

    @f
    @t0(version = "1.2")
    private static final float f(float f2, float f3) {
        return Math.min(f2, f3);
    }

    @t0(version = "1.2")
    public static final float d(float f2, float f3) {
        if (f3 > 0.0f && f3 != 1.0f) {
            return (float) (Math.log(f2) / Math.log(f3));
        }
        return z.f16466f.d();
    }
}
