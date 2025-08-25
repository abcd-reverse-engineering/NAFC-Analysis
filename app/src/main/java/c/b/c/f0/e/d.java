package c.b.c.f0.e;

/* compiled from: MaskUtil.java */
/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2806a = 3;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2807b = 3;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2808c = 40;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2809d = 10;

    private d() {
    }

    static int a(b bVar) {
        return a(bVar, true) + a(bVar, false);
    }

    static int b(b bVar) {
        byte[][] bArrA = bVar.a();
        int iC = bVar.c();
        int iB = bVar.b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < iB - 1) {
            int i4 = i3;
            int i5 = 0;
            while (i5 < iC - 1) {
                byte b2 = bArrA[i2][i5];
                int i6 = i5 + 1;
                if (b2 == bArrA[i2][i6]) {
                    int i7 = i2 + 1;
                    if (b2 == bArrA[i7][i5] && b2 == bArrA[i7][i6]) {
                        i4++;
                    }
                }
                i5 = i6;
            }
            i2++;
            i3 = i4;
        }
        return i3 * 3;
    }

    static int c(b bVar) {
        byte[][] bArrA = bVar.a();
        int iC = bVar.c();
        int iB = bVar.b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < iB) {
            int i4 = i3;
            for (int i5 = 0; i5 < iC; i5++) {
                byte[] bArr = bArrA[i2];
                int i6 = i5 + 6;
                if (i6 < iC && bArr[i5] == 1 && bArr[i5 + 1] == 0 && bArr[i5 + 2] == 1 && bArr[i5 + 3] == 1 && bArr[i5 + 4] == 1 && bArr[i5 + 5] == 0 && bArr[i6] == 1 && (a(bArr, i5 - 4, i5) || a(bArr, i5 + 7, i5 + 11))) {
                    i4++;
                }
                int i7 = i2 + 6;
                if (i7 < iB && bArrA[i2][i5] == 1 && bArrA[i2 + 1][i5] == 0 && bArrA[i2 + 2][i5] == 1 && bArrA[i2 + 3][i5] == 1 && bArrA[i2 + 4][i5] == 1 && bArrA[i2 + 5][i5] == 0 && bArrA[i7][i5] == 1 && (a(bArrA, i5, i2 - 4, i2) || a(bArrA, i5, i2 + 7, i2 + 11))) {
                    i4++;
                }
            }
            i2++;
            i3 = i4;
        }
        return i3 * 40;
    }

    static int d(b bVar) {
        byte[][] bArrA = bVar.a();
        int iC = bVar.c();
        int iB = bVar.b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < iB) {
            byte[] bArr = bArrA[i2];
            int i4 = i3;
            for (int i5 = 0; i5 < iC; i5++) {
                if (bArr[i5] == 1) {
                    i4++;
                }
            }
            i2++;
            i3 = i4;
        }
        int iB2 = bVar.b() * bVar.c();
        return ((Math.abs((i3 * 2) - iB2) * 10) / iB2) * 10;
    }

    private static boolean a(byte[] bArr, int i2, int i3) {
        while (i2 < i3) {
            if (i2 >= 0 && i2 < bArr.length && bArr[i2] == 1) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private static boolean a(byte[][] bArr, int i2, int i3, int i4) {
        while (i3 < i4) {
            if (i3 >= 0 && i3 < bArr.length && bArr[i3][i2] == 1) {
                return false;
            }
            i3++;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean a(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L41;
                case 1: goto L42;
                case 2: goto L3e;
                case 3: goto L3a;
                case 4: goto L35;
                case 5: goto L2d;
                case 6: goto L24;
                case 7: goto L1b;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Invalid mask pattern: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L1b:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L2b
        L24:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L2b:
            r1 = r1 & r0
            goto L44
        L2d:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L44
        L35:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L41
        L3a:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L44
        L3e:
            int r1 = r2 % 3
            goto L44
        L41:
            int r3 = r3 + r2
        L42:
            r1 = r3 & 1
        L44:
            if (r1 != 0) goto L47
            goto L48
        L47:
            r0 = 0
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.f0.e.d.a(int, int, int):boolean");
    }

    private static int a(b bVar, boolean z) {
        int iB = z ? bVar.b() : bVar.c();
        int iC = z ? bVar.c() : bVar.b();
        byte[][] bArrA = bVar.a();
        int i2 = 0;
        for (int i3 = 0; i3 < iB; i3++) {
            int i4 = i2;
            int i5 = 0;
            byte b2 = -1;
            for (int i6 = 0; i6 < iC; i6++) {
                byte b3 = z ? bArrA[i3][i6] : bArrA[i6][i3];
                if (b3 == b2) {
                    i5++;
                } else {
                    if (i5 >= 5) {
                        i4 += (i5 - 5) + 3;
                    }
                    i5 = 1;
                    b2 = b3;
                }
            }
            if (i5 >= 5) {
                i4 += (i5 - 5) + 3;
            }
            i2 = i4;
        }
        return i2;
    }
}
