package h.g2;

import h.b2;

/* compiled from: UArraySorting.kt */
/* loaded from: classes2.dex */
public final class s1 {
    @h.k
    private static final int a(byte[] bArr, int i2, int i3) {
        int i4;
        byte bA = h.g1.a(bArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                int iA = h.g1.a(bArr, i2) & h.f1.f16099c;
                i4 = bA & h.f1.f16099c;
                if (h.q2.t.i0.a(iA, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (h.q2.t.i0.a(h.g1.a(bArr, i3) & h.f1.f16099c, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                byte bA2 = h.g1.a(bArr, i2);
                h.g1.a(bArr, i2, h.g1.a(bArr, i3));
                h.g1.a(bArr, i3, bA2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @h.k
    private static final void b(byte[] bArr, int i2, int i3) {
        int iA = a(bArr, i2, i3);
        int i4 = iA - 1;
        if (i2 < i4) {
            b(bArr, i2, i4);
        }
        if (iA < i3) {
            b(bArr, iA, i3);
        }
    }

    @h.k
    private static final void b(short[] sArr, int i2, int i3) {
        int iA = a(sArr, i2, i3);
        int i4 = iA - 1;
        if (i2 < i4) {
            b(sArr, i2, i4);
        }
        if (iA < i3) {
            b(sArr, iA, i3);
        }
    }

    @h.k
    private static final int a(short[] sArr, int i2, int i3) {
        int i4;
        short sA = h.u1.a(sArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                int iA = h.u1.a(sArr, i2) & h.t1.f16480c;
                i4 = sA & h.t1.f16480c;
                if (h.q2.t.i0.a(iA, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (h.q2.t.i0.a(h.u1.a(sArr, i3) & h.t1.f16480c, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                short sA2 = h.u1.a(sArr, i2);
                h.u1.a(sArr, i2, h.u1.a(sArr, i3));
                h.u1.a(sArr, i3, sA2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @h.k
    private static final void b(int[] iArr, int i2, int i3) {
        int iA = a(iArr, i2, i3);
        int i4 = iA - 1;
        if (i2 < i4) {
            b(iArr, i2, i4);
        }
        if (iA < i3) {
            b(iArr, iA, i3);
        }
    }

    @h.k
    private static final void b(long[] jArr, int i2, int i3) {
        int iA = a(jArr, i2, i3);
        int i4 = iA - 1;
        if (i2 < i4) {
            b(jArr, i2, i4);
        }
        if (iA < i3) {
            b(jArr, iA, i3);
        }
    }

    @h.k
    private static final int a(int[] iArr, int i2, int i3) {
        int iB = h.k1.b(iArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (b2.a(h.k1.b(iArr, i2), iB) < 0) {
                i2++;
            }
            while (b2.a(h.k1.b(iArr, i3), iB) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                int iB2 = h.k1.b(iArr, i2);
                h.k1.a(iArr, i2, h.k1.b(iArr, i3));
                h.k1.a(iArr, i3, iB2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @h.k
    private static final int a(long[] jArr, int i2, int i3) {
        long jA = h.o1.a(jArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (b2.a(h.o1.a(jArr, i2), jA) < 0) {
                i2++;
            }
            while (b2.a(h.o1.a(jArr, i3), jA) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                long jA2 = h.o1.a(jArr, i2);
                h.o1.a(jArr, i2, h.o1.a(jArr, i3));
                h.o1.a(jArr, i3, jA2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @h.k
    public static final void a(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "array");
        b(bArr, 0, h.g1.c(bArr) - 1);
    }

    @h.k
    public static final void a(@i.c.a.d short[] sArr) {
        h.q2.t.i0.f(sArr, "array");
        b(sArr, 0, h.u1.c(sArr) - 1);
    }

    @h.k
    public static final void a(@i.c.a.d int[] iArr) {
        h.q2.t.i0.f(iArr, "array");
        b(iArr, 0, h.k1.c(iArr) - 1);
    }

    @h.k
    public static final void a(@i.c.a.d long[] jArr) {
        h.q2.t.i0.f(jArr, "array");
        b(jArr, 0, h.o1.c(jArr) - 1);
    }
}
