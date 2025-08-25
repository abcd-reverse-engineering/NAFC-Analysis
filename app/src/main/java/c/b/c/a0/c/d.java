package c.b.c.a0.c;

import c.b.c.h;
import h.f1;

/* compiled from: Decoder.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.n.c f2348a = new c.b.c.z.n.c(c.b.c.z.n.a.f3068m);

    public c.b.c.z.e a(boolean[][] zArr) throws c.b.c.d, h {
        int length = zArr.length;
        c.b.c.z.b bVar = new c.b.c.z.b(length);
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                if (zArr[i2][i3]) {
                    bVar.c(i3, i2);
                }
            }
        }
        return a(bVar);
    }

    public c.b.c.z.e a(c.b.c.z.b bVar) throws c.b.c.d, h {
        a aVar = new a(bVar);
        b[] bVarArrA = b.a(aVar.b(), aVar.a());
        int length = bVarArrA.length;
        int iB = 0;
        for (b bVar2 : bVarArrA) {
            iB += bVar2.b();
        }
        byte[] bArr = new byte[iB];
        for (int i2 = 0; i2 < length; i2++) {
            b bVar3 = bVarArrA[i2];
            byte[] bArrA = bVar3.a();
            int iB2 = bVar3.b();
            a(bArrA, iB2);
            for (int i3 = 0; i3 < iB2; i3++) {
                bArr[(i3 * length) + i2] = bArrA[i3];
            }
        }
        return c.a(bArr);
    }

    private void a(byte[] bArr, int i2) throws c.b.c.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & f1.f16099c;
        }
        try {
            this.f2348a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (c.b.c.z.n.e unused) {
            throw c.b.c.d.getChecksumInstance();
        }
    }
}
