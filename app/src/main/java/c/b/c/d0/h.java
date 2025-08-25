package c.b.c.d0;

/* compiled from: EAN13Reader.java */
/* loaded from: classes.dex */
public final class h extends x {

    /* renamed from: k, reason: collision with root package name */
    static final int[] f2570k = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: j, reason: collision with root package name */
    private final int[] f2571j = new int[4];

    @Override // c.b.c.d0.x
    protected int a(c.b.c.z.a aVar, int[] iArr, StringBuilder sb) throws c.b.c.m {
        int[] iArr2 = this.f2571j;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iC = aVar.c();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 6 && i2 < iC) {
            int iA = x.a(aVar, iArr2, i2, x.f2605i);
            sb.append((char) ((iA % 10) + 48));
            int i5 = i2;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            if (iA >= 10) {
                i4 = (1 << (5 - i3)) | i4;
            }
            i3++;
            i2 = i5;
        }
        a(sb, i4);
        int i7 = x.a(aVar, i2, true, x.f2603g)[1];
        int i8 = 0;
        while (i8 < 6 && i7 < iC) {
            sb.append((char) (x.a(aVar, iArr2, i7, x.f2604h) + 48));
            int i9 = i7;
            for (int i10 : iArr2) {
                i9 += i10;
            }
            i8++;
            i7 = i9;
        }
        return i7;
    }

    @Override // c.b.c.d0.x
    c.b.c.a a() {
        return c.b.c.a.EAN_13;
    }

    private static void a(StringBuilder sb, int i2) throws c.b.c.m {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f2570k[i3]) {
                sb.insert(0, (char) (i3 + 48));
                return;
            }
        }
        throw c.b.c.m.getNotFoundInstance();
    }
}
