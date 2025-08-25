package c.b.c.d0;

/* compiled from: EAN8Reader.java */
/* loaded from: classes.dex */
public final class j extends x {

    /* renamed from: j, reason: collision with root package name */
    private final int[] f2573j = new int[4];

    @Override // c.b.c.d0.x
    protected int a(c.b.c.z.a aVar, int[] iArr, StringBuilder sb) throws c.b.c.m {
        int[] iArr2 = this.f2573j;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iC = aVar.c();
        int i2 = iArr[1];
        int i3 = 0;
        while (i3 < 4 && i2 < iC) {
            sb.append((char) (x.a(aVar, iArr2, i2, x.f2604h) + 48));
            int i4 = i2;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            i3++;
            i2 = i4;
        }
        int i6 = x.a(aVar, i2, true, x.f2603g)[1];
        int i7 = 0;
        while (i7 < 4 && i6 < iC) {
            sb.append((char) (x.a(aVar, iArr2, i6, x.f2604h) + 48));
            int i8 = i6;
            for (int i9 : iArr2) {
                i8 += i9;
            }
            i7++;
            i6 = i8;
        }
        return i6;
    }

    @Override // c.b.c.d0.x
    c.b.c.a a() {
        return c.b.c.a.EAN_8;
    }
}
