package c.b.c.e0;

import c.b.c.e;
import c.b.c.e0.e.j;
import c.b.c.h;
import c.b.c.m;
import c.b.c.p;
import c.b.c.r;
import c.b.c.s;
import c.b.c.t;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: PDF417Reader.java */
/* loaded from: classes.dex */
public final class b implements p, c.b.c.c0.c {
    @Override // c.b.c.p
    public r a(c.b.c.c cVar) throws c.b.c.d, h, m {
        return a(cVar, (Map<e, ?>) null);
    }

    @Override // c.b.c.c0.c
    public r[] b(c.b.c.c cVar) throws m {
        return b(cVar, (Map<e, ?>) null);
    }

    @Override // c.b.c.p
    public void reset() {
    }

    @Override // c.b.c.p
    public r a(c.b.c.c cVar, Map<e, ?> map) throws c.b.c.d, h, m {
        r[] rVarArrA = a(cVar, map, false);
        if (rVarArrA == null || rVarArrA.length == 0 || rVarArrA[0] == null) {
            throw m.getNotFoundInstance();
        }
        return rVarArrA[0];
    }

    @Override // c.b.c.c0.c
    public r[] b(c.b.c.c cVar, Map<e, ?> map) throws m {
        try {
            return a(cVar, map, true);
        } catch (c.b.c.d | h unused) {
            throw m.getNotFoundInstance();
        }
    }

    private static int b(t tVar, t tVar2) {
        if (tVar == null || tVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(tVar.a() - tVar2.a());
    }

    private static int b(t[] tVarArr) {
        return Math.min(Math.min(b(tVarArr[0], tVarArr[4]), (b(tVarArr[6], tVarArr[2]) * 17) / 18), Math.min(b(tVarArr[1], tVarArr[5]), (b(tVarArr[7], tVarArr[3]) * 17) / 18));
    }

    private static r[] a(c.b.c.c cVar, Map<e, ?> map, boolean z) throws c.b.c.d, h, m {
        ArrayList arrayList = new ArrayList();
        c.b.c.e0.f.b bVarA = c.b.c.e0.f.a.a(cVar, map, z);
        for (t[] tVarArr : bVarA.b()) {
            c.b.c.z.e eVarA = j.a(bVarA.a(), tVarArr[4], tVarArr[5], tVarArr[6], tVarArr[7], b(tVarArr), a(tVarArr));
            r rVar = new r(eVarA.i(), eVarA.f(), tVarArr, c.b.c.a.PDF_417);
            rVar.a(s.ERROR_CORRECTION_LEVEL, eVarA.b());
            c cVar2 = (c) eVarA.e();
            if (cVar2 != null) {
                rVar.a(s.PDF417_EXTRA_METADATA, cVar2);
            }
            arrayList.add(rVar);
        }
        return (r[]) arrayList.toArray(new r[arrayList.size()]);
    }

    private static int a(t tVar, t tVar2) {
        if (tVar == null || tVar2 == null) {
            return 0;
        }
        return (int) Math.abs(tVar.a() - tVar2.a());
    }

    private static int a(t[] tVarArr) {
        return Math.max(Math.max(a(tVarArr[0], tVarArr[4]), (a(tVarArr[6], tVarArr[2]) * 17) / 18), Math.max(a(tVarArr[1], tVarArr[5]), (a(tVarArr[7], tVarArr[3]) * 17) / 18));
    }
}
