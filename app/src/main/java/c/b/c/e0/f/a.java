package c.b.c.e0.f;

import c.b.c.c;
import c.b.c.e;
import c.b.c.m;
import c.b.c.t;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: Detector.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    private static final float f2690c = 0.42f;

    /* renamed from: d, reason: collision with root package name */
    private static final float f2691d = 0.8f;

    /* renamed from: g, reason: collision with root package name */
    private static final int f2694g = 3;

    /* renamed from: h, reason: collision with root package name */
    private static final int f2695h = 5;

    /* renamed from: i, reason: collision with root package name */
    private static final int f2696i = 25;

    /* renamed from: j, reason: collision with root package name */
    private static final int f2697j = 5;

    /* renamed from: k, reason: collision with root package name */
    private static final int f2698k = 10;

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f2688a = {0, 4, 1, 5};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f2689b = {6, 2, 7, 3};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f2692e = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f2693f = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private a() {
    }

    public static b a(c cVar, Map<e, ?> map, boolean z) throws m {
        c.b.c.z.b bVarA = cVar.a();
        List<t[]> listA = a(z, bVarA);
        if (listA.isEmpty()) {
            bVarA = bVarA.m8clone();
            bVarA.h();
            listA = a(z, bVarA);
        }
        return new b(bVarA, listA);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r5 != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r4.hasNext() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        r5 = (c.b.c.t[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r5[1] == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r3 = (int) java.lang.Math.max(r3, r5[1].b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        if (r5[3] == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        r3 = java.lang.Math.max(r3, (int) r5[3].b());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<c.b.c.t[]> a(boolean r8, c.b.c.z.b r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L8:
            r4 = 0
            r5 = 0
        La:
            int r6 = r9.d()
            if (r3 >= r6) goto L7e
            c.b.c.t[] r4 = a(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L53
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L53
            if (r5 != 0) goto L20
            goto L7e
        L20:
            java.util.Iterator r4 = r0.iterator()
        L24:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L50
            java.lang.Object r5 = r4.next()
            c.b.c.t[] r5 = (c.b.c.t[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L40
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.b()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L40:
            r7 = r5[r6]
            if (r7 == 0) goto L24
            r5 = r5[r6]
            float r5 = r5.b()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L24
        L50:
            int r3 = r3 + 5
            goto L8
        L53:
            r0.add(r4)
            if (r8 != 0) goto L59
            goto L7e
        L59:
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L6c
            r5 = r4[r3]
            float r5 = r5.a()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.b()
            goto L7a
        L6c:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.a()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.b()
        L7a:
            int r3 = (int) r3
            r4 = r5
            r5 = 1
            goto La
        L7e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.e0.f.a.a(boolean, c.b.c.z.b):java.util.List");
    }

    private static t[] a(c.b.c.z.b bVar, int i2, int i3) {
        int iD = bVar.d();
        int iG = bVar.g();
        t[] tVarArr = new t[8];
        a(tVarArr, a(bVar, iD, iG, i2, i3, f2692e), f2688a);
        if (tVarArr[4] != null) {
            i3 = (int) tVarArr[4].a();
            i2 = (int) tVarArr[4].b();
        }
        a(tVarArr, a(bVar, iD, iG, i2, i3, f2693f), f2689b);
        return tVarArr;
    }

    private static void a(t[] tVarArr, t[] tVarArr2, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            tVarArr[iArr[i2]] = tVarArr2[i2];
        }
    }

    private static t[] a(c.b.c.z.b bVar, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6;
        boolean z;
        int i7;
        int[] iArr2;
        t[] tVarArr = new t[4];
        int[] iArr3 = new int[iArr.length];
        int i8 = i4;
        while (true) {
            if (i8 >= i2) {
                z = false;
                break;
            }
            int[] iArrA = a(bVar, i5, i8, i3, false, iArr, iArr3);
            if (iArrA != null) {
                while (true) {
                    iArr2 = iArrA;
                    if (i8 <= 0) {
                        break;
                    }
                    i8--;
                    iArrA = a(bVar, i5, i8, i3, false, iArr, iArr3);
                    if (iArrA == null) {
                        i8++;
                        break;
                    }
                }
                float f2 = i8;
                tVarArr[0] = new t(iArr2[0], f2);
                tVarArr[1] = new t(iArr2[1], f2);
                z = true;
            } else {
                i8 += 5;
            }
        }
        int i9 = i8 + 1;
        if (z) {
            int[] iArr4 = {(int) tVarArr[0].a(), (int) tVarArr[1].a()};
            int i10 = i9;
            int i11 = 0;
            while (true) {
                if (i10 >= i2) {
                    i7 = i11;
                    break;
                }
                i7 = i11;
                int[] iArrA2 = a(bVar, iArr4[0], i10, i3, false, iArr, iArr3);
                if (iArrA2 != null && Math.abs(iArr4[0] - iArrA2[0]) < 5 && Math.abs(iArr4[1] - iArrA2[1]) < 5) {
                    iArr4 = iArrA2;
                    i11 = 0;
                } else {
                    if (i7 > 25) {
                        break;
                    }
                    i11 = i7 + 1;
                }
                i10++;
            }
            i9 = i10 - (i7 + 1);
            float f3 = i9;
            tVarArr[2] = new t(iArr4[0], f3);
            tVarArr[3] = new t(iArr4[1], f3);
        }
        if (i9 - i8 < 10) {
            for (i6 = 0; i6 < tVarArr.length; i6++) {
                tVarArr[i6] = null;
            }
        }
        return tVarArr;
    }

    private static int[] a(c.b.c.z.b bVar, int i2, int i3, int i4, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int length = iArr.length;
        int i5 = 0;
        while (bVar.b(i2, i3) && i2 > 0) {
            int i6 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i2--;
            i5 = i6;
        }
        int i7 = i2;
        boolean z2 = z;
        int i8 = 0;
        while (i2 < i4) {
            if (bVar.b(i2, i3) ^ z2) {
                iArr2[i8] = iArr2[i8] + 1;
            } else {
                int i9 = length - 1;
                if (i8 != i9) {
                    i8++;
                } else {
                    if (a(iArr2, iArr, f2691d) < f2690c) {
                        return new int[]{i7, i2};
                    }
                    i7 += iArr2[0] + iArr2[1];
                    int i10 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i10);
                    iArr2[i10] = 0;
                    iArr2[i9] = 0;
                    i8--;
                }
                iArr2[i8] = 1;
                z2 = !z2;
            }
            i2++;
        }
        if (i8 != length - 1 || a(iArr2, iArr, f2691d) >= f2690c) {
            return null;
        }
        return new int[]{i7, i2 - 1};
    }

    private static float a(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }
}
