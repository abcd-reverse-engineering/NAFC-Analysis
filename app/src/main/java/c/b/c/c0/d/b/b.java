package c.b.c.c0.d.b;

import c.b.c.f0.d.d;
import c.b.c.f0.d.e;
import c.b.c.f0.d.f;
import c.b.c.m;
import c.b.c.t;
import c.b.c.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: MultiFinderPatternFinder.java */
/* loaded from: classes.dex */
final class b extends e {

    /* renamed from: i, reason: collision with root package name */
    private static final f[] f2441i = new f[0];

    /* renamed from: j, reason: collision with root package name */
    private static final float f2442j = 180.0f;

    /* renamed from: k, reason: collision with root package name */
    private static final float f2443k = 9.0f;

    /* renamed from: l, reason: collision with root package name */
    private static final float f2444l = 0.05f;

    /* renamed from: m, reason: collision with root package name */
    private static final float f2445m = 0.5f;

    /* compiled from: MultiFinderPatternFinder.java */
    /* renamed from: c.b.c.c0.d.b.b$b, reason: collision with other inner class name */
    private static final class C0035b implements Comparator<d>, Serializable {
        private C0035b() {
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            double d2 = dVar2.d() - dVar.d();
            if (d2 < 0.0d) {
                return -1;
            }
            return d2 > 0.0d ? 1 : 0;
        }
    }

    b(c.b.c.z.b bVar) {
        super(bVar);
    }

    private d[][] c() throws m {
        List<d> listB = b();
        int size = listB.size();
        int i2 = 3;
        if (size < 3) {
            throw m.getNotFoundInstance();
        }
        char c2 = 0;
        if (size == 3) {
            return new d[][]{new d[]{listB.get(0), listB.get(1), listB.get(2)}};
        }
        Collections.sort(listB, new C0035b());
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < size - 2) {
            d dVar = listB.get(i3);
            if (dVar != null) {
                int i4 = i3 + 1;
                while (i4 < size - 1) {
                    d dVar2 = listB.get(i4);
                    if (dVar2 != null) {
                        float fD = (dVar.d() - dVar2.d()) / Math.min(dVar.d(), dVar2.d());
                        float fAbs = Math.abs(dVar.d() - dVar2.d());
                        float f2 = f2444l;
                        float f3 = f2445m;
                        if (fAbs > f2445m && fD >= f2444l) {
                            break;
                        }
                        int i5 = i4 + 1;
                        while (i5 < size) {
                            d dVar3 = listB.get(i5);
                            if (dVar3 != null) {
                                float fD2 = (dVar2.d() - dVar3.d()) / Math.min(dVar2.d(), dVar3.d());
                                if (Math.abs(dVar2.d() - dVar3.d()) > f3 && fD2 >= f2) {
                                    break;
                                }
                                d[] dVarArr = new d[i2];
                                dVarArr[c2] = dVar;
                                dVarArr[1] = dVar2;
                                dVarArr[2] = dVar3;
                                t.a(dVarArr);
                                f fVar = new f(dVarArr);
                                float fA = t.a(fVar.b(), fVar.a());
                                float fA2 = t.a(fVar.c(), fVar.a());
                                float fA3 = t.a(fVar.b(), fVar.c());
                                float fD3 = (fA + fA3) / (dVar.d() * 2.0f);
                                if (fD3 <= f2442j && fD3 >= f2443k && Math.abs((fA - fA3) / Math.min(fA, fA3)) < 0.1f) {
                                    float fSqrt = (float) Math.sqrt((fA * fA) + (fA3 * fA3));
                                    if (Math.abs((fA2 - fSqrt) / Math.min(fA2, fSqrt)) < 0.1f) {
                                        arrayList.add(dVarArr);
                                    }
                                }
                            }
                            i5++;
                            i2 = 3;
                            c2 = 0;
                            f2 = f2444l;
                            f3 = f2445m;
                        }
                    }
                    i4++;
                    i2 = 3;
                    c2 = 0;
                }
            }
            i3++;
            i2 = 3;
            c2 = 0;
        }
        if (arrayList.isEmpty()) {
            throw m.getNotFoundInstance();
        }
        return (d[][]) arrayList.toArray(new d[arrayList.size()][]);
    }

    public f[] b(Map<c.b.c.e, ?> map) throws m {
        boolean z = map != null && map.containsKey(c.b.c.e.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(c.b.c.e.PURE_BARCODE);
        c.b.c.z.b bVarA = a();
        int iD = bVarA.d();
        int iG = bVarA.g();
        int i2 = (int) ((iD / 228.0f) * 3.0f);
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        for (int i3 = i2 - 1; i3 < iD; i3 += i2) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < iG; i5++) {
                if (bVarA.b(i5, i3)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 != 4) {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                } else if (e.a(iArr) && a(iArr, i3, i5, z2)) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i4 = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i4 = 3;
                }
            }
            if (e.a(iArr)) {
                a(iArr, i3, iG, z2);
            }
        }
        d[][] dVarArrC = c();
        ArrayList arrayList = new ArrayList();
        for (d[] dVarArr : dVarArrC) {
            t.a(dVarArr);
            arrayList.add(new f(dVarArr));
        }
        return arrayList.isEmpty() ? f2441i : (f[]) arrayList.toArray(new f[arrayList.size()]);
    }

    b(c.b.c.z.b bVar, u uVar) {
        super(bVar, uVar);
    }
}
