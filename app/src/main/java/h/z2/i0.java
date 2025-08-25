package h.z2;

import h.b2;
import h.f1;
import h.j1;
import h.n1;
import h.t0;
import h.t1;

/* compiled from: UStrings.kt */
@h.q2.e(name = "UStringsKt")
/* loaded from: classes2.dex */
public final class i0 {
    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final String a(byte b2, int i2) {
        String string = Integer.toString(b2 & f1.f16099c, d.a(i2));
        h.q2.t.i0.a((Object) string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return string;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final f1 b(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toUByteOrNull");
        return b(str, 10);
    }

    @t0(version = "1.3")
    @h.k
    public static final int c(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toUInt");
        j1 j1VarD = d(str);
        if (j1VarD != null) {
            return j1VarD.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final j1 d(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toUIntOrNull");
        return d(str, 10);
    }

    @t0(version = "1.3")
    @h.k
    public static final long e(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toULong");
        n1 n1VarF = f(str);
        if (n1VarF != null) {
            return n1VarF.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final n1 f(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toULongOrNull");
        return f(str, 10);
    }

    @t0(version = "1.3")
    @h.k
    public static final short g(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toUShort");
        t1 t1VarH = h(str);
        if (t1VarH != null) {
            return t1VarH.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final t1 h(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toUShortOrNull");
        return h(str, 10);
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final String a(short s, int i2) {
        String string = Integer.toString(s & t1.f16480c, d.a(i2));
        h.q2.t.i0.a((Object) string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return string;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final f1 b(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toUByteOrNull");
        j1 j1VarD = d(str, i2);
        if (j1VarD == null) {
            return null;
        }
        int iA = j1VarD.a();
        if (b2.a(iA, j1.c(255)) > 0) {
            return null;
        }
        return f1.a(f1.c((byte) iA));
    }

    @t0(version = "1.3")
    @h.k
    public static final int c(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toUInt");
        j1 j1VarD = d(str, i2);
        if (j1VarD != null) {
            return j1VarD.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final j1 d(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toUIntOrNull");
        d.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        int i4 = 1;
        if (cCharAt >= '0') {
            i4 = 0;
        } else if (length == 1 || cCharAt != '+') {
            return null;
        }
        int iC = j1.c(i2);
        int iB = 119304647;
        while (i4 < length) {
            int iA = d.a(str.charAt(i4), i2);
            if (iA < 0) {
                return null;
            }
            if (b2.a(i3, iB) > 0) {
                if (iB == 119304647) {
                    iB = b2.b(-1, iC);
                    if (b2.a(i3, iB) > 0) {
                    }
                }
                return null;
            }
            int iC2 = j1.c(i3 * iC);
            int iC3 = j1.c(j1.c(iA) + iC2);
            if (b2.a(iC3, iC2) < 0) {
                return null;
            }
            i4++;
            i3 = iC3;
        }
        return j1.a(i3);
    }

    @t0(version = "1.3")
    @h.k
    public static final long e(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toULong");
        n1 n1VarF = f(str, i2);
        if (n1VarF != null) {
            return n1VarF.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final n1 f(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toULongOrNull");
        d.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        long j2 = -1;
        int i3 = 0;
        char cCharAt = str.charAt(0);
        if (cCharAt < '0') {
            if (length == 1 || cCharAt != '+') {
                return null;
            }
            i3 = 1;
        }
        long jC = n1.c(i2);
        long j3 = 0;
        long jB = 512409557603043100L;
        while (i3 < length) {
            if (d.a(str.charAt(i3), i2) < 0) {
                return null;
            }
            if (b2.a(j3, jB) > 0) {
                if (jB == 512409557603043100L) {
                    jB = b2.b(j2, jC);
                    if (b2.a(j3, jB) > 0) {
                    }
                }
                return null;
            }
            long jC2 = n1.c(j3 * jC);
            long jC3 = n1.c(n1.c(j1.c(r15) & 4294967295L) + jC2);
            if (b2.a(jC3, jC2) < 0) {
                return null;
            }
            i3++;
            j3 = jC3;
            j2 = -1;
        }
        return n1.a(j3);
    }

    @t0(version = "1.3")
    @h.k
    public static final short g(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toUShort");
        t1 t1VarH = h(str, i2);
        if (t1VarH != null) {
            return t1VarH.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final t1 h(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toUShortOrNull");
        j1 j1VarD = d(str, i2);
        if (j1VarD == null) {
            return null;
        }
        int iA = j1VarD.a();
        if (b2.a(iA, j1.c(65535)) > 0) {
            return null;
        }
        return t1.a(t1.c((short) iA));
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final String a(int i2, int i3) {
        String string = Long.toString(i2 & 4294967295L, d.a(i3));
        h.q2.t.i0.a((Object) string, "java.lang.Long.toString(this, checkRadix(radix))");
        return string;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final String a(long j2, int i2) {
        return b2.a(j2, d.a(i2));
    }

    @t0(version = "1.3")
    @h.k
    public static final byte a(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toUByte");
        f1 f1VarB = b(str);
        if (f1VarB != null) {
            return f1VarB.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    public static final byte a(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toUByte");
        f1 f1VarB = b(str, i2);
        if (f1VarB != null) {
            return f1VarB.a();
        }
        a0.a(str);
        throw null;
    }
}
