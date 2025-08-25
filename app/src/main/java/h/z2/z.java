package h.z2;

import h.t0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* compiled from: StringNumberConversionsJVM.kt */
/* loaded from: classes2.dex */
class z extends y {
    @h.m2.f
    @t0(version = "1.1")
    private static final String a(byte b2, int i2) {
        String string = Integer.toString(b2, d.a(d.a(i2)));
        h.q2.t.i0.a((Object) string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return string;
    }

    @t0(version = "1.2")
    @i.c.a.e
    public static final BigInteger b(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toBigIntegerOrNull");
        d.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i3 = str.charAt(0) == '-' ? 1 : 0; i3 < length; i3++) {
                if (d.a(str.charAt(i3), i2) < 0) {
                    return null;
                }
            }
        } else if (d.a(str.charAt(0), i2) < 0) {
            return null;
        }
        return new BigInteger(str, d.a(i2));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final byte c(@i.c.a.d String str, int i2) {
        return Byte.parseByte(str, d.a(i2));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final int d(@i.c.a.d String str, int i2) {
        return Integer.parseInt(str, d.a(i2));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final long e(@i.c.a.d String str, int i2) {
        return Long.parseLong(str, d.a(i2));
    }

    @h.m2.f
    private static final boolean f(@i.c.a.d String str) {
        return Boolean.parseBoolean(str);
    }

    @h.m2.f
    private static final byte g(@i.c.a.d String str) {
        return Byte.parseByte(str);
    }

    @h.m2.f
    private static final double h(@i.c.a.d String str) {
        return Double.parseDouble(str);
    }

    @t0(version = "1.1")
    @i.c.a.e
    public static final Double i(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toDoubleOrNull");
        try {
            if (r.f16727a.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @h.m2.f
    private static final float j(@i.c.a.d String str) {
        return Float.parseFloat(str);
    }

    @t0(version = "1.1")
    @i.c.a.e
    public static final Float k(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toFloatOrNull");
        try {
            if (r.f16727a.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @h.m2.f
    private static final int l(@i.c.a.d String str) {
        return Integer.parseInt(str);
    }

    @h.m2.f
    private static final long m(@i.c.a.d String str) {
        return Long.parseLong(str);
    }

    @h.m2.f
    private static final short n(@i.c.a.d String str) {
        return Short.parseShort(str);
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final String a(short s, int i2) {
        String string = Integer.toString(s, d.a(d.a(i2)));
        h.q2.t.i0.a((Object) string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return string;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger d(@i.c.a.d String str) {
        return new BigInteger(str);
    }

    @t0(version = "1.2")
    @i.c.a.e
    public static final BigInteger e(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toBigIntegerOrNull");
        return b(str, 10);
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final short f(@i.c.a.d String str, int i2) {
        return Short.parseShort(str, d.a(i2));
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final String a(int i2, int i3) {
        String string = Integer.toString(i2, d.a(i3));
        h.q2.t.i0.a((Object) string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return string;
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final String a(long j2, int i2) {
        String string = Long.toString(j2, d.a(i2));
        h.q2.t.i0.a((Object) string, "java.lang.Long.toString(this, checkRadix(radix))");
        return string;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger a(@i.c.a.d String str, int i2) {
        return new BigInteger(str, d.a(i2));
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(@i.c.a.d String str) {
        return new BigDecimal(str);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(@i.c.a.d String str, MathContext mathContext) {
        return new BigDecimal(str, mathContext);
    }

    @t0(version = "1.2")
    @i.c.a.e
    public static final BigDecimal b(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toBigDecimalOrNull");
        try {
            if (r.f16727a.matches(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static final <T> T a(String str, h.q2.s.l<? super String, ? extends T> lVar) {
        try {
            if (r.f16727a.matches(str)) {
                return lVar.invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @t0(version = "1.2")
    @i.c.a.e
    public static final BigDecimal b(@i.c.a.d String str, @i.c.a.d MathContext mathContext) {
        h.q2.t.i0.f(str, "$this$toBigDecimalOrNull");
        h.q2.t.i0.f(mathContext, "mathContext");
        try {
            if (r.f16727a.matches(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
