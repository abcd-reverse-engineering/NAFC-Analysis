package c.b.c.f0.e;

import c.b.c.f0.c.j;
import c.b.c.w;
import com.luck.picture.lib.config.PictureConfig;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* compiled from: MatrixUtil.java */
/* loaded from: classes.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f2810a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f2811b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c, reason: collision with root package name */
    private static final int[][] f2812c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, PictureConfig.PREVIEW_VIDEO_CODE}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f2813d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* renamed from: e, reason: collision with root package name */
    private static final int f2814e = 7973;

    /* renamed from: f, reason: collision with root package name */
    private static final int f2815f = 1335;

    /* renamed from: g, reason: collision with root package name */
    private static final int f2816g = 21522;

    private e() {
    }

    static int a(int i2) {
        int i3 = 0;
        while (i2 != 0) {
            i2 >>>= 1;
            i3++;
        }
        return i3;
    }

    static void a(b bVar) {
        bVar.a((byte) -1);
    }

    private static void b(b bVar) throws w {
        if (bVar.a(8, bVar.b() - 8) == 0) {
            throw new w();
        }
        bVar.a(8, bVar.b() - 8, 1);
    }

    private static boolean b(int i2) {
        return i2 == -1;
    }

    static void c(j jVar, b bVar) throws w {
        if (jVar.e() < 7) {
            return;
        }
        c.b.c.z.a aVar = new c.b.c.z.a();
        a(jVar, aVar);
        int i2 = 0;
        int i3 = 17;
        while (i2 < 6) {
            int i4 = i3;
            for (int i5 = 0; i5 < 3; i5++) {
                boolean zB = aVar.b(i4);
                i4--;
                bVar.a(i2, (bVar.b() - 11) + i5, zB);
                bVar.a((bVar.b() - 11) + i5, i2, zB);
            }
            i2++;
            i3 = i4;
        }
    }

    private static void d(b bVar) {
        int i2 = 8;
        while (i2 < bVar.c() - 8) {
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (b(bVar.a(i2, 6))) {
                bVar.a(i2, 6, i4);
            }
            if (b(bVar.a(6, i2))) {
                bVar.a(6, i2, i4);
            }
            i2 = i3;
        }
    }

    static void a(c.b.c.z.a aVar, c.b.c.f0.c.f fVar, j jVar, int i2, b bVar) throws w {
        a(bVar);
        a(jVar, bVar);
        a(fVar, i2, bVar);
        c(jVar, bVar);
        a(aVar, i2, bVar);
    }

    private static void b(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 5; i4++) {
            for (int i5 = 0; i5 < 5; i5++) {
                bVar.a(i2 + i5, i3 + i4, f2811b[i4][i5]);
            }
        }
    }

    private static void b(j jVar, b bVar) {
        if (jVar.e() < 2) {
            return;
        }
        int iE = jVar.e() - 1;
        int[][] iArr = f2812c;
        int[] iArr2 = iArr[iE];
        int length = iArr[iE].length;
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = iArr2[i2];
                int i5 = iArr2[i3];
                if (i5 != -1 && i4 != -1 && b(bVar.a(i5, i4))) {
                    b(i5 - 2, i4 - 2, bVar);
                }
            }
        }
    }

    static void a(j jVar, b bVar) throws w {
        c(bVar);
        b(bVar);
        b(jVar, bVar);
        d(bVar);
    }

    private static void c(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 7; i4++) {
            for (int i5 = 0; i5 < 7; i5++) {
                bVar.a(i2 + i5, i3 + i4, f2810a[i4][i5]);
            }
        }
    }

    private static void d(int i2, int i3, b bVar) throws w {
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = i3 + i4;
            if (b(bVar.a(i2, i5))) {
                bVar.a(i2, i5, 0);
            } else {
                throw new w();
            }
        }
    }

    private static void c(b bVar) throws w {
        int length = f2810a[0].length;
        c(0, 0, bVar);
        c(bVar.c() - length, 0, bVar);
        c(0, bVar.c() - length, bVar);
        a(0, 7, bVar);
        a(bVar.c() - 8, 7, bVar);
        a(0, bVar.c() - 8, bVar);
        d(7, 0, bVar);
        d((bVar.b() - 7) - 1, 0, bVar);
        d(7, bVar.b() - 7, bVar);
    }

    static void a(c.b.c.f0.c.f fVar, int i2, b bVar) throws w {
        c.b.c.z.a aVar = new c.b.c.z.a();
        a(fVar, i2, aVar);
        for (int i3 = 0; i3 < aVar.c(); i3++) {
            boolean zB = aVar.b((aVar.c() - 1) - i3);
            int[][] iArr = f2813d;
            bVar.a(iArr[i3][0], iArr[i3][1], zB);
            if (i3 < 8) {
                bVar.a((bVar.c() - i3) - 1, 8, zB);
            } else {
                bVar.a(8, (bVar.b() - 7) + (i3 - 8), zB);
            }
        }
    }

    static void a(c.b.c.z.a aVar, int i2, b bVar) throws w {
        boolean zB;
        int iC = bVar.c() - 1;
        int iB = bVar.b() - 1;
        int i3 = 0;
        int i4 = -1;
        while (iC > 0) {
            if (iC == 6) {
                iC--;
            }
            while (iB >= 0 && iB < bVar.b()) {
                int i5 = i3;
                for (int i6 = 0; i6 < 2; i6++) {
                    int i7 = iC - i6;
                    if (b(bVar.a(i7, iB))) {
                        if (i5 < aVar.c()) {
                            zB = aVar.b(i5);
                            i5++;
                        } else {
                            zB = false;
                        }
                        if (i2 != -1 && d.a(i2, i7, iB)) {
                            zB = !zB;
                        }
                        bVar.a(i7, iB, zB);
                    }
                }
                iB += i4;
                i3 = i5;
            }
            i4 = -i4;
            iB += i4;
            iC -= 2;
        }
        if (i3 == aVar.c()) {
            return;
        }
        throw new w("Not all bits consumed: " + i3 + '/' + aVar.c());
    }

    static int a(int i2, int i3) {
        if (i3 != 0) {
            int iA = a(i3);
            int iA2 = i2 << (iA - 1);
            while (a(iA2) >= iA) {
                iA2 ^= i3 << (a(iA2) - iA);
            }
            return iA2;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void a(c.b.c.f0.c.f fVar, int i2, c.b.c.z.a aVar) throws w {
        if (f.b(i2)) {
            int bits = (fVar.getBits() << 3) | i2;
            aVar.a(bits, 5);
            aVar.a(a(bits, f2815f), 10);
            c.b.c.z.a aVar2 = new c.b.c.z.a();
            aVar2.a(f2816g, 15);
            aVar.b(aVar2);
            if (aVar.c() == 15) {
                return;
            }
            throw new w("should not happen but we got: " + aVar.c());
        }
        throw new w("Invalid mask pattern");
    }

    static void a(j jVar, c.b.c.z.a aVar) throws w {
        aVar.a(jVar.e(), 6);
        aVar.a(a(jVar.e(), f2814e), 12);
        if (aVar.c() == 18) {
            return;
        }
        throw new w("should not happen but we got: " + aVar.c());
    }

    private static void a(int i2, int i3, b bVar) throws w {
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i2 + i4;
            if (b(bVar.a(i5, i3))) {
                bVar.a(i5, i3, 0);
            } else {
                throw new w();
            }
        }
    }
}
