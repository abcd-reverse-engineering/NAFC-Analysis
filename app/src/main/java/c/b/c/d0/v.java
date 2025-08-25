package c.b.c.d0;

import java.util.EnumMap;
import java.util.Map;

/* compiled from: UPCEANExtension5Support.java */
/* loaded from: classes.dex */
final class v {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f2594c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: a, reason: collision with root package name */
    private final int[] f2595a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f2596b = new StringBuilder();

    v() {
    }

    private static Map<c.b.c.s, Object> b(String str) {
        String strA;
        if (str.length() != 5 || (strA = a(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(c.b.c.s.class);
        enumMap.put((EnumMap) c.b.c.s.SUGGESTED_PRICE, (c.b.c.s) strA);
        return enumMap;
    }

    c.b.c.r a(int i2, c.b.c.z.a aVar, int[] iArr) throws c.b.c.m {
        StringBuilder sb = this.f2596b;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map<c.b.c.s, Object> mapB = b(string);
        float f2 = i2;
        c.b.c.r rVar = new c.b.c.r(string, null, new c.b.c.t[]{new c.b.c.t((iArr[0] + iArr[1]) / 2.0f, f2), new c.b.c.t(iA, f2)}, c.b.c.a.UPC_EAN_EXTENSION);
        if (mapB != null) {
            rVar.a(mapB);
        }
        return rVar;
    }

    int a(c.b.c.z.a aVar, int[] iArr, StringBuilder sb) throws c.b.c.m {
        int[] iArr2 = this.f2595a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iC = aVar.c();
        int iD = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 5 && iD < iC) {
            int iA = x.a(aVar, iArr2, iD, x.f2605i);
            sb.append((char) ((iA % 10) + 48));
            int i4 = iD;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (iA >= 10) {
                i3 |= 1 << (4 - i2);
            }
            iD = i2 != 4 ? aVar.d(aVar.c(i4)) : i4;
            i2++;
        }
        if (sb.length() == 5) {
            if (a((CharSequence) sb.toString()) == a(i3)) {
                return iD;
            }
            throw c.b.c.m.getNotFoundInstance();
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            iCharAt += charSequence.charAt(i2) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i3 = length - 1; i3 >= 0; i3 -= 2) {
            iCharAt2 += charSequence.charAt(i3) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    private static int a(int i2) throws c.b.c.m {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f2594c[i3]) {
                return i3;
            }
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    private static String a(String str) throws NumberFormatException {
        String strValueOf;
        char cCharAt = str.charAt(0);
        String str2 = "";
        if (cCharAt == '0') {
            str2 = "£";
        } else if (cCharAt == '5') {
            str2 = "$";
        } else if (cCharAt == '9') {
            if ("90000".equals(str)) {
                return null;
            }
            if ("99991".equals(str)) {
                return "0.00";
            }
            if ("99990".equals(str)) {
                return "Used";
            }
        }
        int i2 = Integer.parseInt(str.substring(1));
        String strValueOf2 = String.valueOf(i2 / 100);
        int i3 = i2 % 100;
        if (i3 < 10) {
            strValueOf = "0" + i3;
        } else {
            strValueOf = String.valueOf(i3);
        }
        return str2 + strValueOf2 + '.' + strValueOf;
    }
}
