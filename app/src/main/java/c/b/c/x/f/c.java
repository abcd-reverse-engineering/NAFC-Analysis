package c.b.c.x.f;

/* compiled from: Encoder.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f2880a = 33;

    /* renamed from: b, reason: collision with root package name */
    public static final int f2881b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2882c = 32;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2883d = 4;

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f2884e = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private c() {
    }

    private static int a(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 * 16)) * i2;
    }

    public static a a(byte[] bArr) {
        return a(bArr, 33, 0);
    }

    private static c.b.c.z.a b(c.b.c.z.a aVar, int i2, int i3) {
        int iC = aVar.c() / i3;
        c.b.c.z.n.d dVar = new c.b.c.z.n.d(a(i3));
        int i4 = i2 / i3;
        int[] iArrA = a(aVar, i3, i4);
        dVar.a(iArrA, i4 - iC);
        c.b.c.z.a aVar2 = new c.b.c.z.a();
        aVar2.a(0, i2 % i3);
        for (int i5 : iArrA) {
            aVar2.a(i5, i3);
        }
        return aVar2;
    }

    public static a a(byte[] bArr, int i2, int i3) {
        int i4;
        c.b.c.z.a aVarA;
        boolean z;
        int iAbs;
        int iA;
        int i5;
        c.b.c.z.a aVarA2 = new d(bArr).a();
        int iC = ((aVarA2.c() * i2) / 100) + 11;
        int iC2 = aVarA2.c() + iC;
        int i6 = 0;
        int i7 = 1;
        if (i3 == 0) {
            c.b.c.z.a aVarA3 = null;
            int i8 = 0;
            i4 = 0;
            while (i8 <= 32) {
                boolean z2 = i8 <= 3;
                int i9 = z2 ? i8 + 1 : i8;
                int iA2 = a(i9, z2);
                if (iC2 <= iA2) {
                    int[] iArr = f2884e;
                    if (i4 != iArr[i9]) {
                        i4 = iArr[i9];
                        aVarA3 = a(aVarA2, i4);
                    }
                    int i10 = iA2 - (iA2 % i4);
                    if ((!z2 || aVarA3.c() <= i4 * 64) && aVarA3.c() + iC <= i10) {
                        aVarA = aVarA3;
                        z = z2;
                        iAbs = i9;
                        iA = iA2;
                    }
                }
                i8++;
                i6 = 0;
                i7 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z = i3 < 0;
        iAbs = Math.abs(i3);
        if (iAbs > (z ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i3)));
        }
        iA = a(iAbs, z);
        i4 = f2884e[iAbs];
        int i11 = iA - (iA % i4);
        aVarA = a(aVarA2, i4);
        if (aVarA.c() + iC > i11) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z && aVarA.c() > i4 * 64) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        c.b.c.z.a aVarB = b(aVarA, iA, i4);
        int iC3 = aVarA.c() / i4;
        c.b.c.z.a aVarA4 = a(z, iAbs, iC3);
        int i12 = z ? (iAbs * 4) + 11 : (iAbs * 4) + 14;
        int[] iArr2 = new int[i12];
        int i13 = 2;
        if (z) {
            for (int i14 = 0; i14 < iArr2.length; i14++) {
                iArr2[i14] = i14;
            }
            i5 = i12;
        } else {
            int i15 = i12 / 2;
            i5 = i12 + 1 + (((i15 - 1) / 15) * 2);
            int i16 = i5 / 2;
            for (int i17 = 0; i17 < i15; i17++) {
                iArr2[(i15 - i17) - 1] = (i16 - r15) - 1;
                iArr2[i15 + i17] = (i17 / 15) + i17 + i16 + i7;
            }
        }
        c.b.c.z.b bVar = new c.b.c.z.b(i5);
        int i18 = 0;
        int i19 = 0;
        while (i18 < iAbs) {
            int i20 = (iAbs - i18) * 4;
            int i21 = z ? i20 + 9 : i20 + 12;
            int i22 = 0;
            while (i22 < i21) {
                int i23 = i22 * 2;
                while (i6 < i13) {
                    if (aVarB.b(i19 + i23 + i6)) {
                        int i24 = i18 * 2;
                        bVar.c(iArr2[i24 + i6], iArr2[i24 + i22]);
                    }
                    if (aVarB.b((i21 * 2) + i19 + i23 + i6)) {
                        int i25 = i18 * 2;
                        bVar.c(iArr2[i25 + i22], iArr2[((i12 - 1) - i25) - i6]);
                    }
                    if (aVarB.b((i21 * 4) + i19 + i23 + i6)) {
                        int i26 = (i12 - 1) - (i18 * 2);
                        bVar.c(iArr2[i26 - i6], iArr2[i26 - i22]);
                    }
                    if (aVarB.b((i21 * 6) + i19 + i23 + i6)) {
                        int i27 = i18 * 2;
                        bVar.c(iArr2[((i12 - 1) - i27) - i22], iArr2[i27 + i6]);
                    }
                    i6++;
                    i13 = 2;
                }
                i22++;
                i6 = 0;
                i13 = 2;
            }
            i19 += i21 * 8;
            i18++;
            i6 = 0;
            i13 = 2;
        }
        a(bVar, z, i5, aVarA4);
        if (z) {
            a(bVar, i5 / 2, 5);
        } else {
            int i28 = i5 / 2;
            a(bVar, i28, 7);
            int i29 = 0;
            int i30 = 0;
            while (i29 < (i12 / 2) - 1) {
                for (int i31 = i28 & 1; i31 < i5; i31 += 2) {
                    int i32 = i28 - i30;
                    bVar.c(i32, i31);
                    int i33 = i28 + i30;
                    bVar.c(i33, i31);
                    bVar.c(i31, i32);
                    bVar.c(i31, i33);
                }
                i29 += 15;
                i30 += 16;
            }
        }
        a aVar = new a();
        aVar.a(z);
        aVar.c(i5);
        aVar.b(iAbs);
        aVar.a(iC3);
        aVar.a(bVar);
        return aVar;
    }

    private static void a(c.b.c.z.b bVar, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4 += 2) {
            int i5 = i2 - i4;
            int i6 = i5;
            while (true) {
                int i7 = i2 + i4;
                if (i6 <= i7) {
                    bVar.c(i6, i5);
                    bVar.c(i6, i7);
                    bVar.c(i5, i6);
                    bVar.c(i7, i6);
                    i6++;
                }
            }
        }
        int i8 = i2 - i3;
        bVar.c(i8, i8);
        int i9 = i8 + 1;
        bVar.c(i9, i8);
        bVar.c(i8, i9);
        int i10 = i2 + i3;
        bVar.c(i10, i8);
        bVar.c(i10, i9);
        bVar.c(i10, i10 - 1);
    }

    static c.b.c.z.a a(boolean z, int i2, int i3) {
        c.b.c.z.a aVar = new c.b.c.z.a();
        if (z) {
            aVar.a(i2 - 1, 2);
            aVar.a(i3 - 1, 6);
            return b(aVar, 28, 4);
        }
        aVar.a(i2 - 1, 5);
        aVar.a(i3 - 1, 11);
        return b(aVar, 40, 4);
    }

    private static void a(c.b.c.z.b bVar, boolean z, int i2, c.b.c.z.a aVar) {
        int i3 = i2 / 2;
        int i4 = 0;
        if (z) {
            while (i4 < 7) {
                int i5 = (i3 - 3) + i4;
                if (aVar.b(i4)) {
                    bVar.c(i5, i3 - 5);
                }
                if (aVar.b(i4 + 7)) {
                    bVar.c(i3 + 5, i5);
                }
                if (aVar.b(20 - i4)) {
                    bVar.c(i5, i3 + 5);
                }
                if (aVar.b(27 - i4)) {
                    bVar.c(i3 - 5, i5);
                }
                i4++;
            }
            return;
        }
        while (i4 < 10) {
            int i6 = (i3 - 5) + i4 + (i4 / 5);
            if (aVar.b(i4)) {
                bVar.c(i6, i3 - 7);
            }
            if (aVar.b(i4 + 10)) {
                bVar.c(i3 + 7, i6);
            }
            if (aVar.b(29 - i4)) {
                bVar.c(i6, i3 + 7);
            }
            if (aVar.b(39 - i4)) {
                bVar.c(i3 - 7, i6);
            }
            i4++;
        }
    }

    private static int[] a(c.b.c.z.a aVar, int i2, int i3) {
        int[] iArr = new int[i3];
        int iC = aVar.c() / i2;
        for (int i4 = 0; i4 < iC; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 |= aVar.b((i4 * i2) + i6) ? 1 << ((i2 - i6) - 1) : 0;
            }
            iArr[i4] = i5;
        }
        return iArr;
    }

    private static c.b.c.z.n.a a(int i2) {
        if (i2 == 4) {
            return c.b.c.z.n.a.f3066k;
        }
        if (i2 == 6) {
            return c.b.c.z.n.a.f3065j;
        }
        if (i2 == 8) {
            return c.b.c.z.n.a.n;
        }
        if (i2 == 10) {
            return c.b.c.z.n.a.f3064i;
        }
        if (i2 == 12) {
            return c.b.c.z.n.a.f3063h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i2);
    }

    static c.b.c.z.a a(c.b.c.z.a aVar, int i2) {
        c.b.c.z.a aVar2 = new c.b.c.z.a();
        int iC = aVar.c();
        int i3 = (1 << i2) - 2;
        int i4 = 0;
        while (i4 < iC) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i4 + i6;
                if (i7 >= iC || aVar.b(i7)) {
                    i5 |= 1 << ((i2 - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 == i3) {
                aVar2.a(i8, i2);
            } else if (i8 == 0) {
                aVar2.a(i5 | 1, i2);
            } else {
                aVar2.a(i5, i2);
                i4 += i2;
            }
            i4--;
            i4 += i2;
        }
        return aVar2;
    }
}
