package c.b.c.f0;

import c.b.c.f0.c.f;
import c.b.c.f0.e.c;
import c.b.c.g;
import c.b.c.v;
import c.b.c.w;
import java.util.Map;

/* compiled from: QRCodeWriter.java */
/* loaded from: classes.dex */
public final class b implements v {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2743a = 4;

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3) throws w {
        return a(str, aVar, i2, i3, null);
    }

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<g, ?> map) throws w {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (aVar != c.b.c.a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + aVar);
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        f fVar = f.L;
        int iIntValue = 4;
        if (map != null) {
            f fVar2 = (f) map.get(g.ERROR_CORRECTION);
            if (fVar2 != null) {
                fVar = fVar2;
            }
            Integer num = (Integer) map.get(g.MARGIN);
            if (num != null) {
                iIntValue = num.intValue();
            }
        }
        return a(c.a(str, fVar, map), i2, i3, iIntValue);
    }

    private static c.b.c.z.b a(c.b.c.f0.e.f fVar, int i2, int i3, int i4) {
        c.b.c.f0.e.b bVarC = fVar.c();
        if (bVarC != null) {
            int iC = bVarC.c();
            int iB = bVarC.b();
            int i5 = i4 * 2;
            int i6 = iC + i5;
            int i7 = i5 + iB;
            int iMax = Math.max(i2, i6);
            int iMax2 = Math.max(i3, i7);
            int iMin = Math.min(iMax / i6, iMax2 / i7);
            int i8 = (iMax - (iC * iMin)) / 2;
            int i9 = (iMax2 - (iB * iMin)) / 2;
            c.b.c.z.b bVar = new c.b.c.z.b(iMax, iMax2);
            int i10 = 0;
            while (i10 < iB) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < iC) {
                    if (bVarC.a(i12, i10) == 1) {
                        bVar.a(i11, i9, iMin, iMin);
                    }
                    i12++;
                    i11 += iMin;
                }
                i10++;
                i9 += iMin;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }
}
