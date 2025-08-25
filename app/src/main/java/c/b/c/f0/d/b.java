package c.b.c.f0.d;

import c.b.c.m;
import c.b.c.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AlignmentPatternFinder.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.b f2774a;

    /* renamed from: c, reason: collision with root package name */
    private final int f2776c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2777d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2778e;

    /* renamed from: f, reason: collision with root package name */
    private final int f2779f;

    /* renamed from: g, reason: collision with root package name */
    private final float f2780g;

    /* renamed from: i, reason: collision with root package name */
    private final u f2782i;

    /* renamed from: b, reason: collision with root package name */
    private final List<a> f2775b = new ArrayList(5);

    /* renamed from: h, reason: collision with root package name */
    private final int[] f2781h = new int[3];

    b(c.b.c.z.b bVar, int i2, int i3, int i4, int i5, float f2, u uVar) {
        this.f2774a = bVar;
        this.f2776c = i2;
        this.f2777d = i3;
        this.f2778e = i4;
        this.f2779f = i5;
        this.f2780g = f2;
        this.f2782i = uVar;
    }

    a a() throws m {
        a aVarA;
        a aVarA2;
        int i2 = this.f2776c;
        int i3 = this.f2779f;
        int i4 = this.f2778e + i2;
        int i5 = this.f2777d + (i3 / 2);
        int[] iArr = new int[3];
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i5;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i8 = i2;
            while (i8 < i4 && !this.f2774a.b(i8, i7)) {
                i8++;
            }
            int i9 = 0;
            while (i8 < i4) {
                if (!this.f2774a.b(i8, i7)) {
                    if (i9 == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 == 1) {
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 != 2) {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                } else {
                    if (a(iArr) && (aVarA2 = a(iArr, i7, i8)) != null) {
                        return aVarA2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i9 = 1;
                }
                i8++;
            }
            if (a(iArr) && (aVarA = a(iArr, i7, i4)) != null) {
                return aVarA;
            }
        }
        if (this.f2775b.isEmpty()) {
            throw m.getNotFoundInstance();
        }
        return this.f2775b.get(0);
    }

    private static float a(int[] iArr, int i2) {
        return (i2 - iArr[2]) - (iArr[1] / 2.0f);
    }

    private boolean a(int[] iArr) {
        float f2 = this.f2780g;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - iArr[i2]) >= f3) {
                return false;
            }
        }
        return true;
    }

    private float a(int i2, int i3, int i4, int i5) {
        c.b.c.z.b bVar = this.f2774a;
        int iD = bVar.d();
        int[] iArr = this.f2781h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i6 = i2;
        while (i6 >= 0 && bVar.b(i3, i6) && iArr[1] <= i4) {
            iArr[1] = iArr[1] + 1;
            i6--;
        }
        if (i6 < 0 || iArr[1] > i4) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bVar.b(i3, i6) && iArr[0] <= i4) {
            iArr[0] = iArr[0] + 1;
            i6--;
        }
        if (iArr[0] > i4) {
            return Float.NaN;
        }
        int i7 = i2 + 1;
        while (i7 < iD && bVar.b(i3, i7) && iArr[1] <= i4) {
            iArr[1] = iArr[1] + 1;
            i7++;
        }
        if (i7 == iD || iArr[1] > i4) {
            return Float.NaN;
        }
        while (i7 < iD && !bVar.b(i3, i7) && iArr[2] <= i4) {
            iArr[2] = iArr[2] + 1;
            i7++;
        }
        if (iArr[2] <= i4 && Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i5) * 5 < i5 * 2 && a(iArr)) {
            return a(iArr, i7);
        }
        return Float.NaN;
    }

    private a a(int[] iArr, int i2, int i3) {
        int i4 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i3);
        float fA2 = a(i2, (int) fA, iArr[1] * 2, i4);
        if (Float.isNaN(fA2)) {
            return null;
        }
        float f2 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.f2775b) {
            if (aVar.a(f2, fA2, fA)) {
                return aVar.b(fA2, fA, f2);
            }
        }
        a aVar2 = new a(fA, fA2, f2);
        this.f2775b.add(aVar2);
        u uVar = this.f2782i;
        if (uVar == null) {
            return null;
        }
        uVar.a(aVar2);
        return null;
    }
}
