package c.b.c.d0;

import java.util.Map;

/* compiled from: OneDimensionalCodeWriter.java */
/* loaded from: classes.dex */
public abstract class r implements c.b.c.v {
    public int a() {
        return 10;
    }

    @Override // c.b.c.v
    public final c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3) throws c.b.c.w {
        return a(str, aVar, i2, i3, null);
    }

    public abstract boolean[] a(String str);

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<c.b.c.g, ?> map) throws c.b.c.w {
        Integer num;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i2 >= 0 && i3 >= 0) {
            int iA = a();
            if (map != null && (num = (Integer) map.get(c.b.c.g.MARGIN)) != null) {
                iA = num.intValue();
            }
            return a(a(str), i2, i3, iA);
        }
        throw new IllegalArgumentException("Negative size is not allowed. Input: " + i2 + 'x' + i3);
    }

    private static c.b.c.z.b a(boolean[] zArr, int i2, int i3, int i4) {
        int length = zArr.length;
        int i5 = i4 + length;
        int iMax = Math.max(i2, i5);
        int iMax2 = Math.max(1, i3);
        int i6 = iMax / i5;
        c.b.c.z.b bVar = new c.b.c.z.b(iMax, iMax2);
        int i7 = (iMax - (length * i6)) / 2;
        int i8 = 0;
        while (i8 < length) {
            if (zArr[i8]) {
                bVar.a(i7, 0, i6, iMax2);
            }
            i8++;
            i7 += i6;
        }
        return bVar;
    }

    protected static int a(boolean[] zArr, int i2, int[] iArr, boolean z) {
        int length = iArr.length;
        int i3 = i2;
        boolean z2 = z;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = iArr[i4];
            int i7 = i3;
            int i8 = 0;
            while (i8 < i6) {
                zArr[i7] = z2;
                i8++;
                i7++;
            }
            i5 += i6;
            z2 = !z2;
            i4++;
            i3 = i7;
        }
        return i5;
    }
}
