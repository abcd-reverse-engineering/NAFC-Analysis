package c.b.c.d0;

import java.util.Map;

/* compiled from: EAN13Writer.java */
/* loaded from: classes.dex */
public final class i extends y {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2572a = 95;

    @Override // c.b.c.d0.r, c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<c.b.c.g, ?> map) throws c.b.c.w {
        if (aVar == c.b.c.a.EAN_13) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + aVar);
    }

    @Override // c.b.c.d0.r
    public boolean[] a(String str) throws NumberFormatException {
        if (str.length() == 13) {
            try {
                if (x.a((CharSequence) str)) {
                    int i2 = h.f2570k[Integer.parseInt(str.substring(0, 1))];
                    boolean[] zArr = new boolean[95];
                    int iA = r.a(zArr, 0, x.f2602f, true) + 0;
                    int i3 = 1;
                    while (i3 <= 6) {
                        int i4 = i3 + 1;
                        int i5 = Integer.parseInt(str.substring(i3, i4));
                        if (((i2 >> (6 - i3)) & 1) == 1) {
                            i5 += 10;
                        }
                        iA += r.a(zArr, iA, x.f2605i[i5], false);
                        i3 = i4;
                    }
                    int iA2 = iA + r.a(zArr, iA, x.f2603g, false);
                    int i6 = 7;
                    while (i6 <= 12) {
                        int i7 = i6 + 1;
                        iA2 += r.a(zArr, iA2, x.f2604h[Integer.parseInt(str.substring(i6, i7))], true);
                        i6 = i7;
                    }
                    r.a(zArr, iA2, x.f2602f, true);
                    return zArr;
                }
                throw new IllegalArgumentException("Contents do not pass checksum");
            } catch (c.b.c.h unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
    }
}
