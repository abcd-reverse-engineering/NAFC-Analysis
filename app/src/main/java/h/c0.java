package h;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/* compiled from: BigDecimals.kt */
/* loaded from: classes2.dex */
class c0 {
    @h.m2.f
    private static final BigDecimal a(@i.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        h.q2.t.i0.f(bigDecimal, "$this$div");
        BigDecimal bigDecimalDivide = bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
        h.q2.t.i0.a((Object) bigDecimalDivide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return bigDecimalDivide;
    }

    @h.m2.f
    private static final BigDecimal b(@i.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        h.q2.t.i0.f(bigDecimal, "$this$minus");
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(bigDecimal2);
        h.q2.t.i0.a((Object) bigDecimalSubtract, "this.subtract(other)");
        return bigDecimalSubtract;
    }

    @h.m2.f
    @c(level = d.ERROR, message = "Use rem(other) instead", replaceWith = @o0(expression = "rem(other)", imports = {}))
    private static final BigDecimal c(@i.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        h.q2.t.i0.f(bigDecimal, "$this$mod");
        BigDecimal bigDecimalRemainder = bigDecimal.remainder(bigDecimal2);
        h.q2.t.i0.a((Object) bigDecimalRemainder, "this.remainder(other)");
        return bigDecimalRemainder;
    }

    @h.m2.f
    private static final BigDecimal d(@i.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        h.q2.t.i0.f(bigDecimal, "$this$plus");
        BigDecimal bigDecimalAdd = bigDecimal.add(bigDecimal2);
        h.q2.t.i0.a((Object) bigDecimalAdd, "this.add(other)");
        return bigDecimalAdd;
    }

    @h.m2.f
    private static final BigDecimal e(@i.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        h.q2.t.i0.f(bigDecimal, "$this$rem");
        BigDecimal bigDecimalRemainder = bigDecimal.remainder(bigDecimal2);
        h.q2.t.i0.a((Object) bigDecimalRemainder, "this.remainder(other)");
        return bigDecimalRemainder;
    }

    @h.m2.f
    private static final BigDecimal f(@i.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        h.q2.t.i0.f(bigDecimal, "$this$times");
        BigDecimal bigDecimalMultiply = bigDecimal.multiply(bigDecimal2);
        h.q2.t.i0.a((Object) bigDecimalMultiply, "this.multiply(other)");
        return bigDecimalMultiply;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(@i.c.a.d BigDecimal bigDecimal) {
        h.q2.t.i0.f(bigDecimal, "$this$dec");
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(BigDecimal.ONE);
        h.q2.t.i0.a((Object) bigDecimalSubtract, "this.subtract(BigDecimal.ONE)");
        return bigDecimalSubtract;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal b(@i.c.a.d BigDecimal bigDecimal) {
        h.q2.t.i0.f(bigDecimal, "$this$inc");
        BigDecimal bigDecimalAdd = bigDecimal.add(BigDecimal.ONE);
        h.q2.t.i0.a((Object) bigDecimalAdd, "this.add(BigDecimal.ONE)");
        return bigDecimalAdd;
    }

    @h.m2.f
    private static final BigDecimal c(@i.c.a.d BigDecimal bigDecimal) {
        h.q2.t.i0.f(bigDecimal, "$this$unaryMinus");
        BigDecimal bigDecimalNegate = bigDecimal.negate();
        h.q2.t.i0.a((Object) bigDecimalNegate, "this.negate()");
        return bigDecimalNegate;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(int i2) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(i2);
        h.q2.t.i0.a((Object) bigDecimalValueOf, "BigDecimal.valueOf(this.toLong())");
        return bigDecimalValueOf;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(int i2, MathContext mathContext) {
        return new BigDecimal(i2, mathContext);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(long j2) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(j2);
        h.q2.t.i0.a((Object) bigDecimalValueOf, "BigDecimal.valueOf(this)");
        return bigDecimalValueOf;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(long j2, MathContext mathContext) {
        return new BigDecimal(j2, mathContext);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(float f2) {
        return new BigDecimal(String.valueOf(f2));
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(float f2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(f2), mathContext);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(double d2) {
        return new BigDecimal(String.valueOf(d2));
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(double d2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(d2), mathContext);
    }
}
