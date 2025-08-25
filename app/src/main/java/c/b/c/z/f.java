package c.b.c.z;

import c.b.c.m;

/* compiled from: DefaultGridSampler.java */
/* loaded from: classes.dex */
public final class f extends i {
    @Override // c.b.c.z.i
    public b a(b bVar, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) throws m {
        return a(bVar, i2, i3, k.a(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17));
    }

    @Override // c.b.c.z.i
    public b a(b bVar, int i2, int i3, k kVar) throws m {
        if (i2 > 0 && i3 > 0) {
            b bVar2 = new b(i2, i3);
            float[] fArr = new float[i2 * 2];
            for (int i4 = 0; i4 < i3; i4++) {
                int length = fArr.length;
                float f2 = i4 + 0.5f;
                for (int i5 = 0; i5 < length; i5 += 2) {
                    fArr[i5] = (i5 / 2) + 0.5f;
                    fArr[i5 + 1] = f2;
                }
                kVar.a(fArr);
                i.a(bVar, fArr);
                for (int i6 = 0; i6 < length; i6 += 2) {
                    try {
                        if (bVar.b((int) fArr[i6], (int) fArr[i6 + 1])) {
                            bVar2.c(i6 / 2, i4);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw m.getNotFoundInstance();
                    }
                }
            }
            return bVar2;
        }
        throw m.getNotFoundInstance();
    }
}
