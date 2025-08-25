package c.b.c.d0.a0;

import c.b.c.d0.q;
import c.b.c.m;
import c.b.c.r;
import c.b.c.t;
import c.b.c.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: RSS14Reader.java */
/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f2474m = {1, 10, 34, 70, 126};
    private static final int[] n = {4, 20, 48, 81};
    private static final int[] o = {0, 161, 961, 2015, 2715};
    private static final int[] p = {0, 336, 1036, 1516};
    private static final int[] q = {8, 6, 4, 3, 1};
    private static final int[] r = {2, 4, 6, 8};
    private static final int[][] s = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: k, reason: collision with root package name */
    private final List<d> f2475k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    private final List<d> f2476l = new ArrayList();

    private static r b(d dVar, d dVar2) {
        String strValueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int iCharAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                iCharAt *= 3;
            }
            i2 += iCharAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        t[] tVarArrA = dVar.d().a();
        t[] tVarArrA2 = dVar2.d().a();
        return new r(String.valueOf(sb.toString()), null, new t[]{tVarArrA[0], tVarArrA[1], tVarArrA2[0], tVarArrA2[1]}, c.b.c.a.RSS_14);
    }

    @Override // c.b.c.d0.q
    public r a(int i2, c.b.c.z.a aVar, Map<c.b.c.e, ?> map) throws m {
        a(this.f2475k, a(aVar, false, i2, map));
        aVar.e();
        a(this.f2476l, a(aVar, true, i2, map));
        aVar.e();
        int size = this.f2475k.size();
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = this.f2475k.get(i3);
            if (dVar.c() > 1) {
                int size2 = this.f2476l.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    d dVar2 = this.f2476l.get(i4);
                    if (dVar2.c() > 1 && a(dVar, dVar2)) {
                        return b(dVar, dVar2);
                    }
                }
            }
        }
        throw m.getNotFoundInstance();
    }

    @Override // c.b.c.d0.q, c.b.c.p
    public void reset() {
        this.f2475k.clear();
        this.f2476l.clear();
    }

    private static void a(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean z = false;
        Iterator<d> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (next.b() == dVar.b()) {
                next.e();
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        collection.add(dVar);
    }

    private static boolean a(d dVar, d dVar2) {
        int iA = (dVar.a() + (dVar2.a() * 16)) % 79;
        int iC = (dVar.d().c() * 9) + dVar2.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        return iA == iC;
    }

    private d a(c.b.c.z.a aVar, boolean z, int i2, Map<c.b.c.e, ?> map) {
        try {
            c cVarA = a(aVar, i2, z, a(aVar, 0, z));
            u uVar = map == null ? null : (u) map.get(c.b.c.e.NEED_RESULT_POINT_CALLBACK);
            if (uVar != null) {
                float fC = (r2[0] + r2[1]) / 2.0f;
                if (z) {
                    fC = (aVar.c() - 1) - fC;
                }
                uVar.a(new t(fC, i2));
            }
            b bVarA = a(aVar, cVarA, true);
            b bVarA2 = a(aVar, cVarA, false);
            return new d((bVarA.b() * 1597) + bVarA2.b(), bVarA.a() + (bVarA2.a() * 4), cVarA);
        } catch (m unused) {
            return null;
        }
    }

    private b a(c.b.c.z.a aVar, c cVar, boolean z) throws m {
        int[] iArrA = a();
        iArrA[0] = 0;
        iArrA[1] = 0;
        iArrA[2] = 0;
        iArrA[3] = 0;
        iArrA[4] = 0;
        iArrA[5] = 0;
        iArrA[6] = 0;
        iArrA[7] = 0;
        if (z) {
            q.b(aVar, cVar.b()[0], iArrA);
        } else {
            q.a(aVar, cVar.b()[1] + 1, iArrA);
            int i2 = 0;
            for (int length = iArrA.length - 1; i2 < length; length--) {
                int i3 = iArrA[i2];
                iArrA[i2] = iArrA[length];
                iArrA[length] = i3;
                i2++;
            }
        }
        int i4 = z ? 16 : 15;
        float fA = a.a(iArrA) / i4;
        int[] iArrE = e();
        int[] iArrC = c();
        float[] fArrF = f();
        float[] fArrD = d();
        for (int i5 = 0; i5 < iArrA.length; i5++) {
            float f2 = iArrA[i5] / fA;
            int i6 = (int) (0.5f + f2);
            if (i6 < 1) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                iArrE[i7] = i6;
                fArrF[i7] = f2 - i6;
            } else {
                iArrC[i7] = i6;
                fArrD[i7] = f2 - i6;
            }
        }
        a(z, i4);
        int i8 = 0;
        int i9 = 0;
        for (int length2 = iArrE.length - 1; length2 >= 0; length2--) {
            i8 = (i8 * 9) + iArrE[length2];
            i9 += iArrE[length2];
        }
        int i10 = 0;
        int i11 = 0;
        for (int length3 = iArrC.length - 1; length3 >= 0; length3--) {
            i10 = (i10 * 9) + iArrC[length3];
            i11 += iArrC[length3];
        }
        int i12 = i8 + (i10 * 3);
        if (!z) {
            if ((i11 & 1) == 0 && i11 <= 10 && i11 >= 4) {
                int i13 = (10 - i11) / 2;
                int i14 = r[i13];
                return new b((f.a(iArrC, 9 - i14, false) * n[i13]) + f.a(iArrE, i14, true) + p[i13], i12);
            }
            throw m.getNotFoundInstance();
        }
        if ((i9 & 1) == 0 && i9 <= 12 && i9 >= 4) {
            int i15 = (12 - i9) / 2;
            int i16 = q[i15];
            return new b((f.a(iArrE, i16, false) * f2474m[i15]) + f.a(iArrC, 9 - i16, true) + o[i15], i12);
        }
        throw m.getNotFoundInstance();
    }

    private int[] a(c.b.c.z.a aVar, int i2, boolean z) throws m {
        int[] iArrB = b();
        iArrB[0] = 0;
        iArrB[1] = 0;
        iArrB[2] = 0;
        iArrB[3] = 0;
        int iC = aVar.c();
        boolean z2 = false;
        while (i2 < iC) {
            z2 = !aVar.b(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < iC) {
            if (aVar.b(i2) ^ z2) {
                iArrB[i4] = iArrB[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else {
                    if (a.b(iArrB)) {
                        return new int[]{i3, i2};
                    }
                    i3 += iArrB[0] + iArrB[1];
                    iArrB[0] = iArrB[2];
                    iArrB[1] = iArrB[3];
                    iArrB[2] = 0;
                    iArrB[3] = 0;
                    i4--;
                }
                iArrB[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw m.getNotFoundInstance();
    }

    private c a(c.b.c.z.a aVar, int i2, boolean z, int[] iArr) throws m {
        int iC;
        int i3;
        boolean zB = aVar.b(iArr[0]);
        int i4 = iArr[0] - 1;
        while (i4 >= 0 && (aVar.b(i4) ^ zB)) {
            i4--;
        }
        int i5 = i4 + 1;
        int i6 = iArr[0] - i5;
        int[] iArrB = b();
        System.arraycopy(iArrB, 0, iArrB, 1, iArrB.length - 1);
        iArrB[0] = i6;
        int iA = a.a(iArrB, s);
        int i7 = iArr[1];
        if (z) {
            int iC2 = (aVar.c() - 1) - i5;
            iC = (aVar.c() - 1) - i7;
            i3 = iC2;
        } else {
            iC = i7;
            i3 = i5;
        }
        return new c(iA, new int[]{i5, iArr[1]}, i3, iC, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0053 A[PHI: r7 r10
  0x0053: PHI (r7v3 boolean) = (r7v1 boolean), (r7v13 boolean) binds: [B:35:0x0051, B:22:0x003a] A[DONT_GENERATE, DONT_INLINE]
  0x0053: PHI (r10v8 boolean) = (r10v6 boolean), (r10v30 boolean) binds: [B:35:0x0051, B:22:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(boolean r10, int r11) throws c.b.c.m {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.d0.a0.e.a(boolean, int):void");
    }
}
