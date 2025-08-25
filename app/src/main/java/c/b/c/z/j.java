package c.b.c.z;

import c.b.c.m;
import h.f1;
import java.lang.reflect.Array;

/* compiled from: HybridBinarizer.java */
/* loaded from: classes.dex */
public final class j extends h {

    /* renamed from: i, reason: collision with root package name */
    private static final int f3030i = 3;

    /* renamed from: j, reason: collision with root package name */
    private static final int f3031j = 8;

    /* renamed from: k, reason: collision with root package name */
    private static final int f3032k = 7;

    /* renamed from: l, reason: collision with root package name */
    private static final int f3033l = 40;

    /* renamed from: m, reason: collision with root package name */
    private static final int f3034m = 24;

    /* renamed from: h, reason: collision with root package name */
    private b f3035h;

    public j(c.b.c.j jVar) {
        super(jVar);
    }

    private static int a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    @Override // c.b.c.z.h, c.b.c.b
    public b a() throws m {
        b bVar = this.f3035h;
        if (bVar != null) {
            return bVar;
        }
        c.b.c.j jVarC = c();
        int iC = jVarC.c();
        int iA = jVarC.a();
        if (iC < 40 || iA < 40) {
            this.f3035h = super.a();
        } else {
            byte[] bArrB = jVarC.b();
            int i2 = iC >> 3;
            if ((iC & 7) != 0) {
                i2++;
            }
            int i3 = i2;
            int i4 = iA >> 3;
            if ((iA & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int[][] iArrA = a(bArrB, i3, i5, iC, iA);
            b bVar2 = new b(iC, iA);
            a(bArrB, i3, i5, iC, iA, iArrA, bVar2);
            this.f3035h = bVar2;
        }
        return this.f3035h;
    }

    @Override // c.b.c.z.h, c.b.c.b
    public c.b.c.b a(c.b.c.j jVar) {
        return new j(jVar);
    }

    private static void a(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, b bVar) {
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i6 << 3;
            int i8 = i5 - 8;
            if (i7 > i8) {
                i7 = i8;
            }
            for (int i9 = 0; i9 < i2; i9++) {
                int i10 = i9 << 3;
                int i11 = i4 - 8;
                if (i10 <= i11) {
                    i11 = i10;
                }
                int iA = a(i9, 2, i2 - 3);
                int iA2 = a(i6, 2, i3 - 3);
                int i12 = 0;
                for (int i13 = -2; i13 <= 2; i13++) {
                    int[] iArr2 = iArr[iA2 + i13];
                    i12 += iArr2[iA - 2] + iArr2[iA - 1] + iArr2[iA] + iArr2[iA + 1] + iArr2[iA + 2];
                }
                a(bArr, i11, i7, i12 / 25, i4, bVar);
            }
        }
    }

    private static void a(byte[] bArr, int i2, int i3, int i4, int i5, b bVar) {
        int i6 = (i3 * i5) + i2;
        int i7 = 0;
        while (i7 < 8) {
            for (int i8 = 0; i8 < 8; i8++) {
                if ((bArr[i6 + i8] & 255) <= i4) {
                    bVar.c(i2 + i8, i3 + i7);
                }
            }
            i7++;
            i6 += i5;
        }
    }

    private static int[][] a(byte[] bArr, int i2, int i3, int i4, int i5) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i3, i2);
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i6 << 3;
            int i8 = i5 - 8;
            if (i7 > i8) {
                i7 = i8;
            }
            for (int i9 = 0; i9 < i2; i9++) {
                int i10 = i9 << 3;
                int i11 = i4 - 8;
                if (i10 > i11) {
                    i10 = i11;
                }
                int i12 = (i7 * i4) + i10;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                int i16 = 255;
                while (i13 < 8) {
                    int i17 = i14;
                    for (int i18 = 0; i18 < 8; i18++) {
                        int i19 = bArr[i12 + i18] & f1.f16099c;
                        i17 += i19;
                        if (i19 < i16) {
                            i16 = i19;
                        }
                        if (i19 > i15) {
                            i15 = i19;
                        }
                    }
                    if (i15 - i16 > 24) {
                        while (true) {
                            i13++;
                            i12 += i4;
                            if (i13 < 8) {
                                for (int i20 = 0; i20 < 8; i20++) {
                                    i17 += bArr[i12 + i20] & f1.f16099c;
                                }
                            }
                        }
                    }
                    i14 = i17;
                    i13++;
                    i12 += i4;
                }
                int i21 = i14 >> 6;
                if (i15 - i16 <= 24) {
                    i21 = i16 / 2;
                    if (i6 > 0 && i9 > 0) {
                        int i22 = i6 - 1;
                        int i23 = i9 - 1;
                        int i24 = ((iArr[i22][i9] + (iArr[i6][i23] * 2)) + iArr[i22][i23]) / 4;
                        if (i16 < i24) {
                            i21 = i24;
                        }
                    }
                }
                iArr[i6][i9] = i21;
            }
        }
        return iArr;
    }
}
