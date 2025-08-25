package c.b.c.a0;

import c.b.c.a0.c.d;
import c.b.c.c;
import c.b.c.e;
import c.b.c.h;
import c.b.c.m;
import c.b.c.p;
import c.b.c.r;
import c.b.c.s;
import c.b.c.t;
import c.b.c.z.g;
import java.util.List;
import java.util.Map;

/* compiled from: DataMatrixReader.java */
/* loaded from: classes.dex */
public final class a implements p {

    /* renamed from: b, reason: collision with root package name */
    private static final t[] f2334b = new t[0];

    /* renamed from: a, reason: collision with root package name */
    private final d f2335a = new d();

    @Override // c.b.c.p
    public r a(c cVar) throws c.b.c.d, h, m {
        return a(cVar, (Map<e, ?>) null);
    }

    @Override // c.b.c.p
    public void reset() {
    }

    @Override // c.b.c.p
    public r a(c cVar, Map<e, ?> map) throws c.b.c.d, h, m {
        t[] tVarArrB;
        c.b.c.z.e eVarA;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            g gVarA = new c.b.c.a0.d.a(cVar.a()).a();
            c.b.c.z.e eVarA2 = this.f2335a.a(gVarA.a());
            tVarArrB = gVarA.b();
            eVarA = eVarA2;
        } else {
            eVarA = this.f2335a.a(a(cVar.a()));
            tVarArrB = f2334b;
        }
        r rVar = new r(eVarA.i(), eVarA.f(), tVarArrB, c.b.c.a.DATA_MATRIX);
        List<byte[]> listA = eVarA.a();
        if (listA != null) {
            rVar.a(s.BYTE_SEGMENTS, listA);
        }
        String strB = eVarA.b();
        if (strB != null) {
            rVar.a(s.ERROR_CORRECTION_LEVEL, strB);
        }
        return rVar;
    }

    private static c.b.c.z.b a(c.b.c.z.b bVar) throws m {
        int[] iArrF = bVar.f();
        int[] iArrB = bVar.b();
        if (iArrF != null && iArrB != null) {
            int iA = a(iArrF, bVar);
            int i2 = iArrF[1];
            int i3 = iArrB[1];
            int i4 = iArrF[0];
            int i5 = ((iArrB[0] - i4) + 1) / iA;
            int i6 = ((i3 - i2) + 1) / iA;
            if (i5 > 0 && i6 > 0) {
                int i7 = iA / 2;
                int i8 = i2 + i7;
                int i9 = i4 + i7;
                c.b.c.z.b bVar2 = new c.b.c.z.b(i5, i6);
                for (int i10 = 0; i10 < i6; i10++) {
                    int i11 = (i10 * iA) + i8;
                    for (int i12 = 0; i12 < i5; i12++) {
                        if (bVar.b((i12 * iA) + i9, i11)) {
                            bVar2.c(i12, i10);
                        }
                    }
                }
                return bVar2;
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }

    private static int a(int[] iArr, c.b.c.z.b bVar) throws m {
        int iG = bVar.g();
        int i2 = iArr[0];
        int i3 = iArr[1];
        while (i2 < iG && bVar.b(i2, i3)) {
            i2++;
        }
        if (i2 != iG) {
            int i4 = i2 - iArr[0];
            if (i4 != 0) {
                return i4;
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }
}
