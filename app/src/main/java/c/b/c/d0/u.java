package c.b.c.d0;

import java.util.EnumMap;
import java.util.Map;

/* compiled from: UPCEANExtension2Support.java */
/* loaded from: classes.dex */
final class u {

    /* renamed from: a, reason: collision with root package name */
    private final int[] f2592a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f2593b = new StringBuilder();

    u() {
    }

    c.b.c.r a(int i2, c.b.c.z.a aVar, int[] iArr) throws c.b.c.m {
        StringBuilder sb = this.f2593b;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map<c.b.c.s, Object> mapA = a(string);
        float f2 = i2;
        c.b.c.r rVar = new c.b.c.r(string, null, new c.b.c.t[]{new c.b.c.t((iArr[0] + iArr[1]) / 2.0f, f2), new c.b.c.t(iA, f2)}, c.b.c.a.UPC_EAN_EXTENSION);
        if (mapA != null) {
            rVar.a(mapA);
        }
        return rVar;
    }

    int a(c.b.c.z.a aVar, int[] iArr, StringBuilder sb) throws c.b.c.m {
        int[] iArr2 = this.f2592a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iC = aVar.c();
        int iD = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 2 && iD < iC) {
            int iA = x.a(aVar, iArr2, iD, x.f2605i);
            sb.append((char) ((iA % 10) + 48));
            int i4 = iD;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (iA >= 10) {
                i3 = (1 << (1 - i2)) | i3;
            }
            iD = i2 != 1 ? aVar.d(aVar.c(i4)) : i4;
            i2++;
        }
        if (sb.length() == 2) {
            if (Integer.parseInt(sb.toString()) % 4 == i3) {
                return iD;
            }
            throw c.b.c.m.getNotFoundInstance();
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    private static Map<c.b.c.s, Object> a(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(c.b.c.s.class);
        enumMap.put((EnumMap) c.b.c.s.ISSUE_NUMBER, (c.b.c.s) Integer.valueOf(str));
        return enumMap;
    }
}
