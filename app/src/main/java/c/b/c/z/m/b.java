package c.b.c.z.m;

import c.b.c.m;
import c.b.c.t;

/* compiled from: MonochromeRectangleDetector.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    private static final int f3052b = 32;

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.b f3053a;

    public b(c.b.c.z.b bVar) {
        this.f3053a = bVar;
    }

    public t[] a() throws m {
        int iD = this.f3053a.d();
        int iG = this.f3053a.g();
        int i2 = iD / 2;
        int i3 = iG / 2;
        int iMax = Math.max(1, iD / 256);
        int iMax2 = Math.max(1, iG / 256);
        int i4 = -iMax;
        int i5 = i3 / 2;
        int iB = ((int) a(i3, 0, 0, iG, i2, i4, 0, iD, i5).b()) - 1;
        int i6 = i2 / 2;
        t tVarA = a(i3, -iMax2, 0, iG, i2, 0, iB, iD, i6);
        int iA = ((int) tVarA.a()) - 1;
        t tVarA2 = a(i3, iMax2, iA, iG, i2, 0, iB, iD, i6);
        int iA2 = ((int) tVarA2.a()) + 1;
        t tVarA3 = a(i3, 0, iA, iA2, i2, iMax, iB, iD, i5);
        return new t[]{a(i3, 0, iA, iA2, i2, i4, iB, ((int) tVarA3.b()) + 1, i3 / 4), tVarA, tVarA2, tVarA3};
    }

    private t a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) throws m {
        int[] iArrA;
        int i11 = i2;
        int i12 = i6;
        int[] iArr = null;
        while (i12 < i9 && i12 >= i8 && i11 < i5 && i11 >= i4) {
            if (i3 == 0) {
                iArrA = a(i12, i10, i4, i5, true);
            } else {
                iArrA = a(i11, i10, i8, i9, false);
            }
            if (iArrA == null) {
                if (iArr == null) {
                    throw m.getNotFoundInstance();
                }
                if (i3 == 0) {
                    int i13 = i12 - i7;
                    if (iArr[0] < i2) {
                        if (iArr[1] > i2) {
                            return new t(i7 > 0 ? iArr[0] : iArr[1], i13);
                        }
                        return new t(iArr[0], i13);
                    }
                    return new t(iArr[1], i13);
                }
                int i14 = i11 - i3;
                if (iArr[0] < i6) {
                    if (iArr[1] > i6) {
                        return new t(i14, i3 < 0 ? iArr[0] : iArr[1]);
                    }
                    return new t(i14, iArr[0]);
                }
                return new t(i14, iArr[1]);
            }
            i12 += i7;
            i11 += i3;
            iArr = iArrA;
        }
        throw m.getNotFoundInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0031 A[EDGE_INSN: B:69:0x0031->B:22:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:72:0x001c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0067 A[EDGE_INSN: B:85:0x0067->B:47:0x0067 BREAK  A[LOOP:3: B:38:0x0053->B:90:0x0053], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int[] a(int r6, int r7, int r8, int r9, boolean r10) {
        /*
            r5 = this;
            int r0 = r8 + r9
            r1 = 2
            int r0 = r0 / r1
            r2 = r0
        L5:
            if (r2 < r8) goto L3a
            c.b.c.z.b r3 = r5.f3053a
            if (r10 == 0) goto L12
            boolean r3 = r3.b(r2, r6)
            if (r3 == 0) goto L1b
            goto L18
        L12:
            boolean r3 = r3.b(r6, r2)
            if (r3 == 0) goto L1b
        L18:
            int r2 = r2 + (-1)
            goto L5
        L1b:
            r3 = r2
        L1c:
            int r3 = r3 + (-1)
            if (r3 < r8) goto L31
            c.b.c.z.b r4 = r5.f3053a
            if (r10 == 0) goto L2b
            boolean r4 = r4.b(r3, r6)
            if (r4 == 0) goto L1c
            goto L31
        L2b:
            boolean r4 = r4.b(r6, r3)
            if (r4 == 0) goto L1c
        L31:
            int r4 = r2 - r3
            if (r3 < r8) goto L3a
            if (r4 <= r7) goto L38
            goto L3a
        L38:
            r2 = r3
            goto L5
        L3a:
            r8 = 1
            int r2 = r2 + r8
        L3c:
            if (r0 >= r9) goto L70
            c.b.c.z.b r3 = r5.f3053a
            if (r10 == 0) goto L49
            boolean r3 = r3.b(r0, r6)
            if (r3 == 0) goto L52
            goto L4f
        L49:
            boolean r3 = r3.b(r6, r0)
            if (r3 == 0) goto L52
        L4f:
            int r0 = r0 + 1
            goto L3c
        L52:
            r3 = r0
        L53:
            int r3 = r3 + r8
            if (r3 >= r9) goto L67
            c.b.c.z.b r4 = r5.f3053a
            if (r10 == 0) goto L61
            boolean r4 = r4.b(r3, r6)
            if (r4 == 0) goto L53
            goto L67
        L61:
            boolean r4 = r4.b(r6, r3)
            if (r4 == 0) goto L53
        L67:
            int r4 = r3 - r0
            if (r3 >= r9) goto L70
            if (r4 <= r7) goto L6e
            goto L70
        L6e:
            r0 = r3
            goto L3c
        L70:
            int r0 = r0 + (-1)
            if (r0 <= r2) goto L7c
            int[] r6 = new int[r1]
            r7 = 0
            r6[r7] = r2
            r6[r8] = r0
            goto L7d
        L7c:
            r6 = 0
        L7d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.z.m.b.a(int, int, int, int, boolean):int[]");
    }
}
