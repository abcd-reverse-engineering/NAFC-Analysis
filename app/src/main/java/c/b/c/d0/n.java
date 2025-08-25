package c.b.c.d0;

import java.util.Map;

/* compiled from: ITFWriter.java */
/* loaded from: classes.dex */
public final class n extends r {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f2586a = {1, 1, 1, 1};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f2587b = {3, 1, 1};

    @Override // c.b.c.d0.r, c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<c.b.c.g, ?> map) throws c.b.c.w {
        if (aVar == c.b.c.a.ITF) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + aVar);
    }

    @Override // c.b.c.d0.r
    public boolean[] a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The lenght of the input should be even");
        }
        if (length <= 80) {
            boolean[] zArr = new boolean[(length * 9) + 9];
            int iA = r.a(zArr, 0, f2586a, true);
            for (int i2 = 0; i2 < length; i2 += 2) {
                int iDigit = Character.digit(str.charAt(i2), 10);
                int iDigit2 = Character.digit(str.charAt(i2 + 1), 10);
                int[] iArr = new int[18];
                for (int i3 = 0; i3 < 5; i3++) {
                    int i4 = i3 * 2;
                    int[][] iArr2 = m.f2584i;
                    iArr[i4] = iArr2[iDigit][i3];
                    iArr[i4 + 1] = iArr2[iDigit2][i3];
                }
                iA += r.a(zArr, iA, iArr, true);
            }
            r.a(zArr, iA, f2587b, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }
}
