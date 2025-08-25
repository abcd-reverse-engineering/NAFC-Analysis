package c.b.c.c0;

import c.b.c.e;
import c.b.c.m;
import c.b.c.p;
import c.b.c.q;
import c.b.c.r;
import c.b.c.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: GenericMultipleBarcodeReader.java */
/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: b, reason: collision with root package name */
    private static final int f2435b = 100;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2436c = 4;

    /* renamed from: a, reason: collision with root package name */
    private final p f2437a;

    public b(p pVar) {
        this.f2437a = pVar;
    }

    private void a(c.b.c.c cVar, Map<e, ?> map, List<r> list, int i2, int i3, int i4) {
        boolean z;
        float f2;
        int i5;
        int i6;
        if (i4 > 4) {
            return;
        }
        try {
            r rVarA = this.f2437a.a(cVar, map);
            Iterator<r> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().e().equals(rVarA.e())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                list.add(a(rVarA, i2, i3));
            }
            t[] tVarArrD = rVarA.d();
            if (tVarArrD == null || tVarArrD.length == 0) {
                return;
            }
            int iC = cVar.c();
            int iB = cVar.b();
            float f3 = iB;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = iC;
            for (t tVar : tVarArrD) {
                if (tVar != null) {
                    float fA = tVar.a();
                    float fB = tVar.b();
                    if (fA < f6) {
                        f6 = fA;
                    }
                    if (fB < f3) {
                        f3 = fB;
                    }
                    if (fA > f4) {
                        f4 = fA;
                    }
                    if (fB > f5) {
                        f5 = fB;
                    }
                }
            }
            if (f6 > 100.0f) {
                f2 = f3;
                i5 = iB;
                i6 = iC;
                a(cVar.a(0, 0, (int) f6, iB), map, list, i2, i3, i4 + 1);
            } else {
                f2 = f3;
                i5 = iB;
                i6 = iC;
            }
            if (f2 > 100.0f) {
                a(cVar.a(0, 0, i6, (int) f2), map, list, i2, i3, i4 + 1);
            }
            if (f4 < i6 - 100) {
                int i7 = (int) f4;
                a(cVar.a(i7, 0, i6 - i7, i5), map, list, i2 + i7, i3, i4 + 1);
            }
            if (f5 < i5 - 100) {
                int i8 = (int) f5;
                a(cVar.a(0, i8, i6, i5 - i8), map, list, i2, i3 + i8, i4 + 1);
            }
        } catch (q unused) {
        }
    }

    @Override // c.b.c.c0.c
    public r[] b(c.b.c.c cVar) throws m {
        return b(cVar, null);
    }

    @Override // c.b.c.c0.c
    public r[] b(c.b.c.c cVar, Map<e, ?> map) throws m {
        ArrayList arrayList = new ArrayList();
        a(cVar, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw m.getNotFoundInstance();
        }
        return (r[]) arrayList.toArray(new r[arrayList.size()]);
    }

    private static r a(r rVar, int i2, int i3) {
        t[] tVarArrD = rVar.d();
        if (tVarArrD == null) {
            return rVar;
        }
        t[] tVarArr = new t[tVarArrD.length];
        for (int i4 = 0; i4 < tVarArrD.length; i4++) {
            t tVar = tVarArrD[i4];
            if (tVar != null) {
                tVarArr[i4] = new t(tVar.a() + i2, tVar.b() + i3);
            }
        }
        r rVar2 = new r(rVar.e(), rVar.b(), tVarArr, rVar.a());
        rVar2.a(rVar.c());
        return rVar2;
    }
}
