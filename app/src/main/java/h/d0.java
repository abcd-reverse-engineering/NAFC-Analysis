package h;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* compiled from: BigIntegers.kt */
/* loaded from: classes2.dex */
class d0 extends c0 {
    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger a(@i.c.a.d BigInteger bigInteger) {
        h.q2.t.i0.f(bigInteger, "$this$dec");
        BigInteger bigIntegerSubtract = bigInteger.subtract(BigInteger.ONE);
        h.q2.t.i0.a((Object) bigIntegerSubtract, "this.subtract(BigInteger.ONE)");
        return bigIntegerSubtract;
    }

    @h.m2.f
    private static final BigInteger b(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        h.q2.t.i0.f(bigInteger, "$this$div");
        BigInteger bigIntegerDivide = bigInteger.divide(bigInteger2);
        h.q2.t.i0.a((Object) bigIntegerDivide, "this.divide(other)");
        return bigIntegerDivide;
    }

    @h.m2.f
    private static final BigInteger c(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        h.q2.t.i0.f(bigInteger, "$this$minus");
        BigInteger bigIntegerSubtract = bigInteger.subtract(bigInteger2);
        h.q2.t.i0.a((Object) bigIntegerSubtract, "this.subtract(other)");
        return bigIntegerSubtract;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger d(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerOr = bigInteger.or(bigInteger2);
        h.q2.t.i0.a((Object) bigIntegerOr, "this.or(other)");
        return bigIntegerOr;
    }

    @h.m2.f
    private static final BigInteger e(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        h.q2.t.i0.f(bigInteger, "$this$plus");
        BigInteger bigIntegerAdd = bigInteger.add(bigInteger2);
        h.q2.t.i0.a((Object) bigIntegerAdd, "this.add(other)");
        return bigIntegerAdd;
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final BigInteger f(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        h.q2.t.i0.f(bigInteger, "$this$rem");
        BigInteger bigIntegerRemainder = bigInteger.remainder(bigInteger2);
        h.q2.t.i0.a((Object) bigIntegerRemainder, "this.remainder(other)");
        return bigIntegerRemainder;
    }

    @h.m2.f
    private static final BigInteger g(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        h.q2.t.i0.f(bigInteger, "$this$times");
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger2);
        h.q2.t.i0.a((Object) bigIntegerMultiply, "this.multiply(other)");
        return bigIntegerMultiply;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger h(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerXor = bigInteger.xor(bigInteger2);
        h.q2.t.i0.a((Object) bigIntegerXor, "this.xor(other)");
        return bigIntegerXor;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger a(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerAnd = bigInteger.and(bigInteger2);
        h.q2.t.i0.a((Object) bigIntegerAnd, "this.and(other)");
        return bigIntegerAnd;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger b(@i.c.a.d BigInteger bigInteger) {
        h.q2.t.i0.f(bigInteger, "$this$inc");
        BigInteger bigIntegerAdd = bigInteger.add(BigInteger.ONE);
        h.q2.t.i0.a((Object) bigIntegerAdd, "this.add(BigInteger.ONE)");
        return bigIntegerAdd;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger c(@i.c.a.d BigInteger bigInteger) {
        BigInteger bigIntegerNot = bigInteger.not();
        h.q2.t.i0.a((Object) bigIntegerNot, "this.not()");
        return bigIntegerNot;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal d(@i.c.a.d BigInteger bigInteger) {
        return new BigDecimal(bigInteger);
    }

    @h.m2.f
    private static final BigInteger e(@i.c.a.d BigInteger bigInteger) {
        h.q2.t.i0.f(bigInteger, "$this$unaryMinus");
        BigInteger bigIntegerNegate = bigInteger.negate();
        h.q2.t.i0.a((Object) bigIntegerNegate, "this.negate()");
        return bigIntegerNegate;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger a(@i.c.a.d BigInteger bigInteger, int i2) {
        BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(i2);
        h.q2.t.i0.a((Object) bigIntegerShiftLeft, "this.shiftLeft(n)");
        return bigIntegerShiftLeft;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger b(@i.c.a.d BigInteger bigInteger, int i2) {
        BigInteger bigIntegerShiftRight = bigInteger.shiftRight(i2);
        h.q2.t.i0.a((Object) bigIntegerShiftRight, "this.shiftRight(n)");
        return bigIntegerShiftRight;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger a(int i2) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i2);
        h.q2.t.i0.a((Object) bigIntegerValueOf, "BigInteger.valueOf(this.toLong())");
        return bigIntegerValueOf;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger a(long j2) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(j2);
        h.q2.t.i0.a((Object) bigIntegerValueOf, "BigInteger.valueOf(this)");
        return bigIntegerValueOf;
    }

    static /* synthetic */ BigDecimal a(BigInteger bigInteger, int i2, MathContext mathContext, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            h.q2.t.i0.a((Object) mathContext, "MathContext.UNLIMITED");
        }
        return new BigDecimal(bigInteger, i2, mathContext);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(@i.c.a.d BigInteger bigInteger, int i2, MathContext mathContext) {
        return new BigDecimal(bigInteger, i2, mathContext);
    }
}
