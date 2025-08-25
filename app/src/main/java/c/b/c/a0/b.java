package c.b.c.a0;

import c.b.c.a0.e.e;
import c.b.c.a0.e.i;
import c.b.c.a0.e.j;
import c.b.c.a0.e.k;
import c.b.c.a0.e.l;
import c.b.c.f;
import c.b.c.g;
import c.b.c.v;
import java.util.Map;

/* compiled from: DataMatrixWriter.java */
/* loaded from: classes.dex */
public final class b implements v {
    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3) {
        return a(str, aVar, i2, i3, null);
    }

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<g, ?> map) {
        f fVar;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (aVar != c.b.c.a.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + aVar);
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        l lVar = l.FORCE_NONE;
        f fVar2 = null;
        if (map != null) {
            l lVar2 = (l) map.get(g.DATA_MATRIX_SHAPE);
            if (lVar2 != null) {
                lVar = lVar2;
            }
            fVar = (f) map.get(g.MIN_SIZE);
            if (fVar == null) {
                fVar = null;
            }
            f fVar3 = (f) map.get(g.MAX_SIZE);
            if (fVar3 != null) {
                fVar2 = fVar3;
            }
        } else {
            fVar = null;
        }
        String strA = j.a(str, lVar, fVar, fVar2);
        k kVarA = k.a(strA.length(), lVar, fVar, fVar2, true);
        e eVar = new e(i.a(strA, kVarA), kVarA.g(), kVarA.f());
        eVar.d();
        return a(eVar, kVarA);
    }

    private static c.b.c.z.b a(e eVar, k kVar) {
        int iG = kVar.g();
        int iF = kVar.f();
        c.b.c.f0.e.b bVar = new c.b.c.f0.e.b(kVar.i(), kVar.h());
        int i2 = 0;
        for (int i3 = 0; i3 < iF; i3++) {
            if (i3 % kVar.f2403e == 0) {
                int i4 = 0;
                for (int i5 = 0; i5 < kVar.i(); i5++) {
                    bVar.a(i4, i2, i5 % 2 == 0);
                    i4++;
                }
                i2++;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < iG; i7++) {
                if (i7 % kVar.f2402d == 0) {
                    bVar.a(i6, i2, true);
                    i6++;
                }
                bVar.a(i6, i2, eVar.a(i7, i3));
                i6++;
                int i8 = kVar.f2402d;
                if (i7 % i8 == i8 - 1) {
                    bVar.a(i6, i2, i3 % 2 == 0);
                    i6++;
                }
            }
            i2++;
            int i9 = kVar.f2403e;
            if (i3 % i9 == i9 - 1) {
                int i10 = 0;
                for (int i11 = 0; i11 < kVar.i(); i11++) {
                    bVar.a(i10, i2, true);
                    i10++;
                }
                i2++;
            }
        }
        return a(bVar);
    }

    private static c.b.c.z.b a(c.b.c.f0.e.b bVar) {
        int iC = bVar.c();
        int iB = bVar.b();
        c.b.c.z.b bVar2 = new c.b.c.z.b(iC, iB);
        bVar2.a();
        for (int i2 = 0; i2 < iC; i2++) {
            for (int i3 = 0; i3 < iB; i3++) {
                if (bVar.a(i2, i3) == 1) {
                    bVar2.c(i2, i3);
                }
            }
        }
        return bVar2;
    }
}
