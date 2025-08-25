package c.b.c.d0;

/* compiled from: Code128Reader.java */
/* loaded from: classes.dex */
public final class c extends q {

    /* renamed from: a, reason: collision with root package name */
    static final int[][] f2530a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* renamed from: b, reason: collision with root package name */
    private static final float f2531b = 0.25f;

    /* renamed from: c, reason: collision with root package name */
    private static final float f2532c = 0.7f;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2533d = 98;

    /* renamed from: e, reason: collision with root package name */
    private static final int f2534e = 99;

    /* renamed from: f, reason: collision with root package name */
    private static final int f2535f = 100;

    /* renamed from: g, reason: collision with root package name */
    private static final int f2536g = 101;

    /* renamed from: h, reason: collision with root package name */
    private static final int f2537h = 102;

    /* renamed from: i, reason: collision with root package name */
    private static final int f2538i = 97;

    /* renamed from: j, reason: collision with root package name */
    private static final int f2539j = 96;

    /* renamed from: k, reason: collision with root package name */
    private static final int f2540k = 101;

    /* renamed from: l, reason: collision with root package name */
    private static final int f2541l = 100;

    /* renamed from: m, reason: collision with root package name */
    private static final int f2542m = 103;
    private static final int n = 104;
    private static final int o = 105;
    private static final int p = 106;

    private static int[] a(c.b.c.z.a aVar) throws c.b.c.m {
        int iC = aVar.c();
        int iC2 = aVar.c(0);
        int[] iArr = new int[6];
        int length = iArr.length;
        int i2 = iC2;
        boolean z = false;
        int i3 = 0;
        while (iC2 < iC) {
            if (aVar.b(iC2) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 == i4) {
                    float f2 = f2531b;
                    int i5 = -1;
                    for (int i6 = 103; i6 <= 105; i6++) {
                        float fA = q.a(iArr, f2530a[i6], f2532c);
                        if (fA < f2) {
                            i5 = i6;
                            f2 = fA;
                        }
                    }
                    if (i5 >= 0 && aVar.a(Math.max(0, i2 - ((iC2 - i2) / 2)), i2, false)) {
                        return new int[]{i2, iC2, i5};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i7 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i7);
                    iArr[i7] = 0;
                    iArr[i4] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArr[i3] = 1;
                z = !z;
            }
            iC2++;
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    private static int a(c.b.c.z.a aVar, int[] iArr, int i2) throws c.b.c.m {
        q.a(aVar, i2, iArr);
        float f2 = f2531b;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[][] iArr2 = f2530a;
            if (i4 >= iArr2.length) {
                break;
            }
            float fA = q.a(iArr, iArr2[i4], f2532c);
            if (fA < f2) {
                i3 = i4;
                f2 = fA;
            }
            i4++;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0149 A[PHI: r19
  0x0149: PHI (r19v7 boolean) = (r19v5 boolean), (r19v12 boolean) binds: [B:71:0x011b, B:44:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // c.b.c.d0.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c.b.c.r a(int r25, c.b.c.z.a r26, java.util.Map<c.b.c.e, ?> r27) throws c.b.c.d, c.b.c.h, c.b.c.m {
        /*
            Method dump skipped, instructions count: 664
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.d0.c.a(int, c.b.c.z.a, java.util.Map):c.b.c.r");
    }
}
