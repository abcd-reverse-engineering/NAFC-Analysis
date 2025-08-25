package c.b.c.f0.d;

import c.b.c.m;
import c.b.c.t;
import c.b.c.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: FinderPatternFinder.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: f, reason: collision with root package name */
    private static final int f2787f = 2;

    /* renamed from: g, reason: collision with root package name */
    protected static final int f2788g = 3;

    /* renamed from: h, reason: collision with root package name */
    protected static final int f2789h = 57;

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.b f2790a;

    /* renamed from: b, reason: collision with root package name */
    private final List<d> f2791b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2792c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f2793d;

    /* renamed from: e, reason: collision with root package name */
    private final u f2794e;

    /* compiled from: FinderPatternFinder.java */
    private static final class b implements Comparator<d>, Serializable {
        private final float average;

        private b(float f2) {
            this.average = f2;
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            if (dVar2.c() != dVar.c()) {
                return dVar2.c() - dVar.c();
            }
            float fAbs = Math.abs(dVar2.d() - this.average);
            float fAbs2 = Math.abs(dVar.d() - this.average);
            if (fAbs < fAbs2) {
                return 1;
            }
            return fAbs == fAbs2 ? 0 : -1;
        }
    }

    /* compiled from: FinderPatternFinder.java */
    private static final class c implements Comparator<d>, Serializable {
        private final float average;

        private c(float f2) {
            this.average = f2;
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            float fAbs = Math.abs(dVar2.d() - this.average);
            float fAbs2 = Math.abs(dVar.d() - this.average);
            if (fAbs < fAbs2) {
                return -1;
            }
            return fAbs == fAbs2 ? 0 : 1;
        }
    }

    public e(c.b.c.z.b bVar) {
        this(bVar, null);
    }

    private float c(int i2, int i3, int i4, int i5) {
        c.b.c.z.b bVar = this.f2790a;
        int iD = bVar.d();
        int[] iArrD = d();
        int i6 = i2;
        while (i6 >= 0 && bVar.b(i3, i6)) {
            iArrD[2] = iArrD[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bVar.b(i3, i6) && iArrD[1] <= i4) {
            iArrD[1] = iArrD[1] + 1;
            i6--;
        }
        if (i6 < 0 || iArrD[1] > i4) {
            return Float.NaN;
        }
        while (i6 >= 0 && bVar.b(i3, i6) && iArrD[0] <= i4) {
            iArrD[0] = iArrD[0] + 1;
            i6--;
        }
        if (iArrD[0] > i4) {
            return Float.NaN;
        }
        int i7 = i2 + 1;
        while (i7 < iD && bVar.b(i3, i7)) {
            iArrD[2] = iArrD[2] + 1;
            i7++;
        }
        if (i7 == iD) {
            return Float.NaN;
        }
        while (i7 < iD && !bVar.b(i3, i7) && iArrD[3] < i4) {
            iArrD[3] = iArrD[3] + 1;
            i7++;
        }
        if (i7 == iD || iArrD[3] >= i4) {
            return Float.NaN;
        }
        while (i7 < iD && bVar.b(i3, i7) && iArrD[4] < i4) {
            iArrD[4] = iArrD[4] + 1;
            i7++;
        }
        if (iArrD[4] < i4 && Math.abs(((((iArrD[0] + iArrD[1]) + iArrD[2]) + iArrD[3]) + iArrD[4]) - i5) * 5 < i5 * 2 && a(iArrD)) {
            return a(iArrD, i7);
        }
        return Float.NaN;
    }

    private int[] d() {
        int[] iArr = this.f2793d;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    private boolean e() {
        int size = this.f2791b.size();
        float fAbs = 0.0f;
        int i2 = 0;
        float fD = 0.0f;
        for (d dVar : this.f2791b) {
            if (dVar.c() >= 2) {
                i2++;
                fD += dVar.d();
            }
        }
        if (i2 < 3) {
            return false;
        }
        float f2 = fD / size;
        Iterator<d> it = this.f2791b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().d() - f2);
        }
        return fAbs <= fD * 0.05f;
    }

    private d[] f() throws m {
        int size = this.f2791b.size();
        if (size < 3) {
            throw m.getNotFoundInstance();
        }
        float fD = 0.0f;
        if (size > 3) {
            Iterator<d> it = this.f2791b.iterator();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (it.hasNext()) {
                float fD2 = it.next().d();
                f2 += fD2;
                f3 += fD2 * fD2;
            }
            float f4 = f2 / size;
            float fSqrt = (float) Math.sqrt((f3 / r0) - (f4 * f4));
            Collections.sort(this.f2791b, new c(f4));
            float fMax = Math.max(0.2f * f4, fSqrt);
            int i2 = 0;
            while (i2 < this.f2791b.size() && this.f2791b.size() > 3) {
                if (Math.abs(this.f2791b.get(i2).d() - f4) > fMax) {
                    this.f2791b.remove(i2);
                    i2--;
                }
                i2++;
            }
        }
        if (this.f2791b.size() > 3) {
            Iterator<d> it2 = this.f2791b.iterator();
            while (it2.hasNext()) {
                fD += it2.next().d();
            }
            Collections.sort(this.f2791b, new b(fD / this.f2791b.size()));
            List<d> list = this.f2791b;
            list.subList(3, list.size()).clear();
        }
        return new d[]{this.f2791b.get(0), this.f2791b.get(1), this.f2791b.get(2)};
    }

    protected final c.b.c.z.b a() {
        return this.f2790a;
    }

    protected final List<d> b() {
        return this.f2791b;
    }

    public e(c.b.c.z.b bVar, u uVar) {
        this.f2790a = bVar;
        this.f2791b = new ArrayList();
        this.f2793d = new int[5];
        this.f2794e = uVar;
    }

    private float b(int i2, int i3, int i4, int i5) {
        c.b.c.z.b bVar = this.f2790a;
        int iG = bVar.g();
        int[] iArrD = d();
        int i6 = i2;
        while (i6 >= 0 && bVar.b(i6, i3)) {
            iArrD[2] = iArrD[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bVar.b(i6, i3) && iArrD[1] <= i4) {
            iArrD[1] = iArrD[1] + 1;
            i6--;
        }
        if (i6 < 0 || iArrD[1] > i4) {
            return Float.NaN;
        }
        while (i6 >= 0 && bVar.b(i6, i3) && iArrD[0] <= i4) {
            iArrD[0] = iArrD[0] + 1;
            i6--;
        }
        if (iArrD[0] > i4) {
            return Float.NaN;
        }
        int i7 = i2 + 1;
        while (i7 < iG && bVar.b(i7, i3)) {
            iArrD[2] = iArrD[2] + 1;
            i7++;
        }
        if (i7 == iG) {
            return Float.NaN;
        }
        while (i7 < iG && !bVar.b(i7, i3) && iArrD[3] < i4) {
            iArrD[3] = iArrD[3] + 1;
            i7++;
        }
        if (i7 == iG || iArrD[3] >= i4) {
            return Float.NaN;
        }
        while (i7 < iG && bVar.b(i7, i3) && iArrD[4] < i4) {
            iArrD[4] = iArrD[4] + 1;
            i7++;
        }
        if (iArrD[4] < i4 && Math.abs(((((iArrD[0] + iArrD[1]) + iArrD[2]) + iArrD[3]) + iArrD[4]) - i5) * 5 < i5 && a(iArrD)) {
            return a(iArrD, i7);
        }
        return Float.NaN;
    }

    final f a(Map<c.b.c.e, ?> map) throws m {
        boolean z = map != null && map.containsKey(c.b.c.e.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(c.b.c.e.PURE_BARCODE);
        int iD = this.f2790a.d();
        int iG = this.f2790a.g();
        int i2 = (iD * 3) / 228;
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        int i4 = i2;
        boolean zE = false;
        while (i3 < iD && !zE) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            boolean zE2 = zE;
            int i5 = i4;
            int i6 = 0;
            int i7 = 0;
            while (i6 < iG) {
                if (this.f2790a.b(i6, i3)) {
                    if ((i7 & 1) == 1) {
                        i7++;
                    }
                    iArr[i7] = iArr[i7] + 1;
                } else if ((i7 & 1) != 0) {
                    iArr[i7] = iArr[i7] + 1;
                } else if (i7 != 4) {
                    i7++;
                    iArr[i7] = iArr[i7] + 1;
                } else if (a(iArr) && a(iArr, i3, i6, z2)) {
                    if (this.f2792c) {
                        zE2 = e();
                    } else {
                        int iC = c();
                        if (iC > iArr[2]) {
                            i3 += (iC - iArr[2]) - 2;
                            i6 = iG - 1;
                        }
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i7 = 0;
                    i5 = 2;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i7 = 3;
                }
                i6++;
            }
            if (a(iArr) && a(iArr, i3, iG, z2)) {
                int i8 = iArr[0];
                if (this.f2792c) {
                    i4 = i8;
                    zE = e();
                    i3 += i4;
                } else {
                    i4 = i8;
                }
            } else {
                i4 = i5;
            }
            zE = zE2;
            i3 += i4;
        }
        d[] dVarArrF = f();
        t.a(dVarArrF);
        return new f(dVarArrF);
    }

    private int c() {
        if (this.f2791b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.f2791b) {
            if (dVar2.c() >= 2) {
                if (dVar != null) {
                    this.f2792c = true;
                    return ((int) (Math.abs(dVar.a() - dVar2.a()) - Math.abs(dVar.b() - dVar2.b()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    private static float a(int[] iArr, int i2) {
        return ((i2 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    protected static boolean a(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 2.0f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    private boolean a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArrD = d();
        int i11 = 0;
        while (i2 >= i11 && i3 >= i11 && this.f2790a.b(i3 - i11, i2 - i11)) {
            iArrD[2] = iArrD[2] + 1;
            i11++;
        }
        if (i2 < i11 || i3 < i11) {
            return false;
        }
        while (i2 >= i11 && i3 >= i11 && !this.f2790a.b(i3 - i11, i2 - i11) && iArrD[1] <= i4) {
            iArrD[1] = iArrD[1] + 1;
            i11++;
        }
        if (i2 < i11 || i3 < i11 || iArrD[1] > i4) {
            return false;
        }
        while (i2 >= i11 && i3 >= i11 && this.f2790a.b(i3 - i11, i2 - i11) && iArrD[0] <= i4) {
            iArrD[0] = iArrD[0] + 1;
            i11++;
        }
        if (iArrD[0] > i4) {
            return false;
        }
        int iD = this.f2790a.d();
        int iG = this.f2790a.g();
        int i12 = 1;
        while (true) {
            i6 = i2 + i12;
            if (i6 >= iD || (i10 = i3 + i12) >= iG || !this.f2790a.b(i10, i6)) {
                break;
            }
            iArrD[2] = iArrD[2] + 1;
            i12++;
        }
        if (i6 >= iD || i3 + i12 >= iG) {
            return false;
        }
        while (true) {
            i7 = i2 + i12;
            if (i7 >= iD || (i9 = i3 + i12) >= iG || this.f2790a.b(i9, i7) || iArrD[3] >= i4) {
                break;
            }
            iArrD[3] = iArrD[3] + 1;
            i12++;
        }
        if (i7 >= iD || i3 + i12 >= iG || iArrD[3] >= i4) {
            return false;
        }
        while (true) {
            int i13 = i2 + i12;
            if (i13 >= iD || (i8 = i3 + i12) >= iG || !this.f2790a.b(i8, i13) || iArrD[4] >= i4) {
                break;
            }
            iArrD[4] = iArrD[4] + 1;
            i12++;
        }
        return iArrD[4] < i4 && Math.abs(((((iArrD[0] + iArrD[1]) + iArrD[2]) + iArrD[3]) + iArrD[4]) - i5) < i5 * 2 && a(iArrD);
    }

    protected final boolean a(int[] iArr, int i2, int i3, boolean z) {
        boolean z2 = false;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i3);
        float fC = c(i2, iA, iArr[2], i4);
        if (!Float.isNaN(fC)) {
            int i5 = (int) fC;
            float fB = b(iA, i5, iArr[2], i4);
            if (!Float.isNaN(fB) && (!z || a(i5, (int) fB, iArr[2], i4))) {
                float f2 = i4 / 7.0f;
                int i6 = 0;
                while (true) {
                    if (i6 >= this.f2791b.size()) {
                        break;
                    }
                    d dVar = this.f2791b.get(i6);
                    if (dVar.a(f2, fC, fB)) {
                        this.f2791b.set(i6, dVar.b(fC, fB, f2));
                        z2 = true;
                        break;
                    }
                    i6++;
                }
                if (!z2) {
                    d dVar2 = new d(fB, fC, f2);
                    this.f2791b.add(dVar2);
                    u uVar = this.f2794e;
                    if (uVar != null) {
                        uVar.a(dVar2);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
