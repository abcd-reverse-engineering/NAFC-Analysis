package c.b.c.e0.e;

import c.b.c.m;
import c.b.c.t;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

/* compiled from: PDF417ScanningDecoder.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2675a = 2;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2676b = 3;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2677c = 512;

    /* renamed from: d, reason: collision with root package name */
    private static final c.b.c.e0.e.k.a f2678d = new c.b.c.e0.e.k.a();

    private j() {
    }

    public static c.b.c.z.e a(c.b.c.z.b bVar, t tVar, t tVar2, t tVar3, t tVar4, int i2, int i3) throws c.b.c.d, c.b.c.h, m {
        h hVar;
        int i4;
        int i5;
        int i6;
        h hVarA = null;
        f fVarB = null;
        h hVarA2 = null;
        c cVar = new c(bVar, tVar, tVar2, tVar3, tVar4);
        int i7 = 0;
        while (i7 < 2) {
            if (tVar != null) {
                hVarA = a(bVar, cVar, tVar, true, i2, i3);
            }
            hVar = hVarA;
            if (tVar3 != null) {
                hVarA2 = a(bVar, cVar, tVar3, false, i2, i3);
            }
            fVarB = b(hVar, hVarA2);
            if (fVarB == null) {
                throw m.getNotFoundInstance();
            }
            if (i7 != 0 || fVarB.d() == null || (fVarB.d().f() >= cVar.f() && fVarB.d().d() <= cVar.d())) {
                fVarB.a(cVar);
                break;
            }
            cVar = fVarB.d();
            i7++;
            hVarA = hVar;
        }
        hVar = hVarA;
        int iA = fVarB.a() + 1;
        fVarB.a(0, hVar);
        fVarB.a(iA, hVarA2);
        boolean z = hVar != null;
        int i8 = i2;
        int i9 = i3;
        for (int i10 = 1; i10 <= iA; i10++) {
            int i11 = z ? i10 : iA - i10;
            if (fVarB.a(i11) == null) {
                g hVar2 = (i11 == 0 || i11 == iA) ? new h(cVar, i11 == 0) : new g(cVar);
                fVarB.a(i11, hVar2);
                int i12 = -1;
                int iMax = i9;
                int i13 = -1;
                int iMin = i8;
                int iF = cVar.f();
                while (iF <= cVar.d()) {
                    int iA2 = a(fVarB, i11, iF, z);
                    if (iA2 >= 0 && iA2 <= cVar.c()) {
                        i4 = iA2;
                    } else if (i13 == i12) {
                        i5 = i13;
                        i6 = iMax;
                        iMax = i6;
                        i13 = i5;
                        iF++;
                        i12 = -1;
                    } else {
                        i4 = i13;
                    }
                    i5 = i13;
                    int i14 = iMax;
                    d dVarA = a(bVar, cVar.e(), cVar.c(), z, i4, iF, iMin, i14);
                    if (dVarA != null) {
                        hVar2.a(iF, dVarA);
                        iMin = Math.min(iMin, dVarA.f());
                        iMax = Math.max(i14, dVarA.f());
                        i13 = i4;
                        iF++;
                        i12 = -1;
                    } else {
                        i6 = i14;
                        iMax = i6;
                        i13 = i5;
                        iF++;
                        i12 = -1;
                    }
                }
                i8 = iMin;
                i9 = iMax;
            }
        }
        return b(fVarB);
    }

    private static boolean a(int i2, int i3, int i4) {
        return i3 + (-2) <= i2 && i2 <= i4 + 2;
    }

    private static f b(h hVar, h hVar2) throws c.b.c.h, m {
        a aVarA;
        if ((hVar == null && hVar2 == null) || (aVarA = a(hVar, hVar2)) == null) {
            return null;
        }
        return new f(aVarA, c.a(a(hVar), a(hVar2)));
    }

    private static int c(int i2) {
        return 2 << i2;
    }

    private static int b(int[] iArr) {
        int iMax = -1;
        for (int i2 : iArr) {
            iMax = Math.max(iMax, i2);
        }
        return iMax;
    }

    private static c.b.c.z.e b(f fVar) throws c.b.c.d, c.b.c.h, m {
        b[][] bVarArrA = a(fVar);
        a(fVar, bVarArrA);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[fVar.c() * fVar.a()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < fVar.c(); i2++) {
            int i3 = 0;
            while (i3 < fVar.a()) {
                int i4 = i3 + 1;
                int[] iArrA = bVarArrA[i2][i4].a();
                int iA = (fVar.a() * i2) + i3;
                if (iArrA.length == 0) {
                    arrayList.add(Integer.valueOf(iA));
                } else if (iArrA.length == 1) {
                    iArr[iA] = iArrA[0];
                } else {
                    arrayList3.add(Integer.valueOf(iA));
                    arrayList2.add(iArrA);
                }
                i3 = i4;
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            iArr2[i5] = (int[]) arrayList2.get(i5);
        }
        return a(fVar.b(), iArr, c.b.c.e0.a.a(arrayList), c.b.c.e0.a.a(arrayList3), iArr2);
    }

    private static c a(h hVar) throws c.b.c.h, m {
        int[] iArrD;
        if (hVar == null || (iArrD = hVar.d()) == null) {
            return null;
        }
        int iB = b(iArrD);
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArrD) {
            i3 += iB - i4;
            if (i4 > 0) {
                break;
            }
        }
        d[] dVarArrB = hVar.b();
        for (int i5 = 0; i3 > 0 && dVarArrB[i5] == null; i5++) {
            i3--;
        }
        for (int length = iArrD.length - 1; length >= 0; length--) {
            i2 += iB - iArrD[length];
            if (iArrD[length] > 0) {
                break;
            }
        }
        for (int length2 = dVarArrB.length - 1; i2 > 0 && dVarArrB[length2] == null; length2--) {
            i2--;
        }
        return hVar.a().a(i3, i2, hVar.e());
    }

    private static int[] b(c.b.c.z.b bVar, int i2, int i3, boolean z, int i4, int i5) {
        int[] iArr = new int[8];
        int i6 = z ? 1 : -1;
        int i7 = 0;
        boolean z2 = z;
        while (true) {
            if (((!z || i4 >= i3) && (z || i4 < i2)) || i7 >= iArr.length) {
                break;
            }
            if (bVar.b(i4, i5) == z2) {
                iArr[i7] = iArr[i7] + 1;
                i4 += i6;
            } else {
                i7++;
                z2 = !z2;
            }
        }
        if (i7 == iArr.length || (((z && i4 == i3) || (!z && i4 == i2)) && i7 == iArr.length - 1)) {
            return iArr;
        }
        return null;
    }

    private static int b(int i2) {
        return a(a(i2));
    }

    private static a a(h hVar, h hVar2) {
        a aVarC;
        a aVarC2;
        if (hVar == null || (aVarC = hVar.c()) == null) {
            if (hVar2 == null) {
                return null;
            }
            return hVar2.c();
        }
        if (hVar2 == null || (aVarC2 = hVar2.c()) == null || aVarC.a() == aVarC2.a() || aVarC.b() == aVarC2.b() || aVarC.c() == aVarC2.c()) {
            return aVarC;
        }
        return null;
    }

    private static h a(c.b.c.z.b bVar, c cVar, t tVar, boolean z, int i2, int i3) {
        h hVar = new h(cVar, z);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int iA = (int) tVar.a();
            for (int iB = (int) tVar.b(); iB <= cVar.d() && iB >= cVar.f(); iB += i5) {
                d dVarA = a(bVar, 0, bVar.g(), z, iA, iB, i2, i3);
                if (dVarA != null) {
                    hVar.a(iB, dVarA);
                    if (z) {
                        iA = dVarA.d();
                    } else {
                        iA = dVarA.b();
                    }
                }
            }
            i4++;
        }
        return hVar;
    }

    private static void a(f fVar, b[][] bVarArr) throws m {
        int[] iArrA = bVarArr[0][1].a();
        int iA = (fVar.a() * fVar.c()) - c(fVar.b());
        if (iArrA.length != 0) {
            if (iArrA[0] != iA) {
                bVarArr[0][1].b(iA);
            }
        } else {
            if (iA >= 1 && iA <= 928) {
                bVarArr[0][1].b(iA);
                return;
            }
            throw m.getNotFoundInstance();
        }
    }

    private static c.b.c.z.e a(int i2, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws c.b.c.d, c.b.c.h {
        int[] iArr5 = new int[iArr3.length];
        int i3 = 100;
        while (true) {
            int i4 = i3 - 1;
            if (i3 > 0) {
                for (int i5 = 0; i5 < iArr5.length; i5++) {
                    iArr[iArr3[i5]] = iArr4[i5][iArr5[i5]];
                }
                try {
                    return a(iArr, i2, iArr2);
                } catch (c.b.c.d unused) {
                    if (iArr5.length == 0) {
                        throw c.b.c.d.getChecksumInstance();
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 >= iArr5.length) {
                            break;
                        }
                        if (iArr5[i6] < iArr4[i6].length - 1) {
                            iArr5[i6] = iArr5[i6] + 1;
                            break;
                        }
                        iArr5[i6] = 0;
                        if (i6 == iArr5.length - 1) {
                            throw c.b.c.d.getChecksumInstance();
                        }
                        i6++;
                    }
                    i3 = i4;
                }
            } else {
                throw c.b.c.d.getChecksumInstance();
            }
        }
    }

    private static b[][] a(f fVar) throws c.b.c.h {
        int iC;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, fVar.c(), fVar.a() + 2);
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            for (int i3 = 0; i3 < bVarArr[i2].length; i3++) {
                bVarArr[i2][i3] = new b();
            }
        }
        int i4 = 0;
        for (g gVar : fVar.e()) {
            if (gVar != null) {
                for (d dVar : gVar.b()) {
                    if (dVar != null && (iC = dVar.c()) >= 0) {
                        if (iC < bVarArr.length) {
                            bVarArr[iC][i4].b(dVar.e());
                        } else {
                            throw c.b.c.h.getFormatInstance();
                        }
                    }
                }
            }
            i4++;
        }
        return bVarArr;
    }

    private static boolean a(f fVar, int i2) {
        return i2 >= 0 && i2 <= fVar.a() + 1;
    }

    private static int a(f fVar, int i2, int i3, boolean z) {
        int i4 = z ? 1 : -1;
        int i5 = i2 - i4;
        d dVarA = a(fVar, i5) ? fVar.a(i5).a(i3) : null;
        if (dVarA != null) {
            return z ? dVarA.b() : dVarA.d();
        }
        d dVarB = fVar.a(i2).b(i3);
        if (dVarB != null) {
            return z ? dVarB.d() : dVarB.b();
        }
        if (a(fVar, i5)) {
            dVarB = fVar.a(i5).b(i3);
        }
        if (dVarB != null) {
            return z ? dVarB.b() : dVarB.d();
        }
        int i6 = 0;
        while (true) {
            i2 -= i4;
            if (a(fVar, i2)) {
                for (d dVar : fVar.a(i2).b()) {
                    if (dVar != null) {
                        return (z ? dVar.b() : dVar.d()) + (i4 * i6 * (dVar.b() - dVar.d()));
                    }
                }
                i6++;
            } else {
                c cVarD = fVar.d();
                return z ? cVarD.e() : cVarD.c();
            }
        }
    }

    private static d a(c.b.c.z.b bVar, int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
        int i8;
        int iD;
        int iA;
        int iA2 = a(bVar, i2, i3, z, i4, i5);
        int[] iArrB = b(bVar, i2, i3, z, iA2, i5);
        if (iArrB == null) {
            return null;
        }
        int iA3 = c.b.c.e0.a.a(iArrB);
        if (z) {
            iA2 += iA3;
            i8 = iA2;
        } else {
            for (int i9 = 0; i9 < iArrB.length / 2; i9++) {
                int i10 = iArrB[i9];
                iArrB[i9] = iArrB[(iArrB.length - 1) - i9];
                iArrB[(iArrB.length - 1) - i9] = i10;
            }
            i8 = iA2 - iA3;
        }
        if (a(iA3, i6, i7) && (iA = c.b.c.e0.a.a((iD = i.d(iArrB)))) != -1) {
            return new d(i8, iA2, b(iD), iA);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0024, code lost:
    
        r0 = -r0;
        r2 = !r2;
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(c.b.c.z.b r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r8
            r8 = r9
        L8:
            r3 = 2
            if (r1 >= r3) goto L2a
        Lb:
            if (r2 == 0) goto Lf
            if (r8 >= r6) goto L13
        Lf:
            if (r2 != 0) goto L24
            if (r8 >= r7) goto L24
        L13:
            boolean r4 = r5.b(r8, r10)
            if (r2 != r4) goto L24
            int r4 = r9 - r8
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L22
            return r9
        L22:
            int r8 = r8 + r0
            goto Lb
        L24:
            int r0 = -r0
            r2 = r2 ^ 1
            int r1 = r1 + 1
            goto L8
        L2a:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.e0.e.j.a(c.b.c.z.b, int, int, boolean, int, int):int");
    }

    private static c.b.c.z.e a(int[] iArr, int i2, int[] iArr2) throws c.b.c.d, c.b.c.h {
        if (iArr.length != 0) {
            int i3 = 1 << (i2 + 1);
            int iA = a(iArr, iArr2, i3);
            a(iArr, i3);
            c.b.c.z.e eVarA = e.a(iArr, String.valueOf(i2));
            eVarA.b(Integer.valueOf(iA));
            eVarA.a(Integer.valueOf(iArr2.length));
            return eVarA;
        }
        throw c.b.c.h.getFormatInstance();
    }

    private static int a(int[] iArr, int[] iArr2, int i2) throws c.b.c.d {
        if ((iArr2 == null || iArr2.length <= (i2 / 2) + 3) && i2 >= 0 && i2 <= 512) {
            return f2678d.a(iArr, i2, iArr2);
        }
        throw c.b.c.d.getChecksumInstance();
    }

    private static void a(int[] iArr, int i2) throws c.b.c.h {
        if (iArr.length >= 4) {
            int i3 = iArr[0];
            if (i3 > iArr.length) {
                throw c.b.c.h.getFormatInstance();
            }
            if (i3 == 0) {
                if (i2 < iArr.length) {
                    iArr[0] = iArr.length - i2;
                    return;
                }
                throw c.b.c.h.getFormatInstance();
            }
            return;
        }
        throw c.b.c.h.getFormatInstance();
    }

    private static int[] a(int i2) {
        int[] iArr = new int[8];
        int length = iArr.length - 1;
        int i3 = 0;
        while (true) {
            int i4 = i2 & 1;
            if (i4 != i3) {
                length--;
                if (length < 0) {
                    return iArr;
                }
                i3 = i4;
            }
            iArr[length] = iArr[length] + 1;
            i2 >>= 1;
        }
    }

    private static int a(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    public static String a(b[][] bVarArr) {
        Formatter formatter = new Formatter();
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            formatter.format("Row %2d: ", Integer.valueOf(i2));
            for (int i3 = 0; i3 < bVarArr[i2].length; i3++) {
                b bVar = bVarArr[i2][i3];
                if (bVar.a().length == 0) {
                    formatter.format("        ", null);
                } else {
                    formatter.format("%4d(%2d)", Integer.valueOf(bVar.a()[0]), bVar.a(bVar.a()[0]));
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
