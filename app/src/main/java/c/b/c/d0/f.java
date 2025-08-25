package c.b.c.d0;

import java.util.Map;

/* compiled from: Code39Writer.java */
/* loaded from: classes.dex */
public final class f extends r {
    @Override // c.b.c.d0.r, c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<c.b.c.g, ?> map) throws c.b.c.w {
        if (aVar == c.b.c.a.CODE_39) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + aVar);
    }

    @Override // c.b.c.d0.r
    public boolean[] a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int i2 = length + 25;
            int i3 = 0;
            while (i3 < length) {
                int iIndexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i3));
                if (iIndexOf >= 0) {
                    a(e.f2558g[iIndexOf], iArr);
                    int i4 = i2;
                    for (int i5 : iArr) {
                        i4 += i5;
                    }
                    i3++;
                    i2 = i4;
                } else {
                    throw new IllegalArgumentException("Bad contents: " + str);
                }
            }
            boolean[] zArr = new boolean[i2];
            a(e.f2558g[39], iArr);
            int iA = r.a(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int iA2 = iA + r.a(zArr, iA, iArr2, false);
            for (int i6 = 0; i6 < length; i6++) {
                a(e.f2558g["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i6))], iArr);
                int iA3 = iA2 + r.a(zArr, iA2, iArr, true);
                iA2 = iA3 + r.a(zArr, iA3, iArr2, false);
            }
            a(e.f2558g[39], iArr);
            r.a(zArr, iA2, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }

    private static void a(int i2, int[] iArr) {
        for (int i3 = 0; i3 < 9; i3++) {
            int i4 = 1;
            if (((1 << (8 - i3)) & i2) != 0) {
                i4 = 2;
            }
            iArr[i3] = i4;
        }
    }
}
