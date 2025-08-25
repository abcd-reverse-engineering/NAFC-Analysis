package c.b.c.a0.c;

import c.b.c.a0.c.e;

/* compiled from: DataBlock.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f2339a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f2340b;

    private b(int i2, byte[] bArr) {
        this.f2339a = i2;
        this.f2340b = bArr;
    }

    static b[] a(byte[] bArr, e eVar) {
        e.c cVarC = eVar.c();
        e.b[] bVarArrA = cVarC.a();
        int iA = 0;
        for (e.b bVar : bVarArrA) {
            iA += bVar.a();
        }
        b[] bVarArr = new b[iA];
        int length = bVarArrA.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            e.b bVar2 = bVarArrA[i2];
            int i4 = i3;
            int i5 = 0;
            while (i5 < bVar2.a()) {
                int iB = bVar2.b();
                bVarArr[i4] = new b(iB, new byte[cVarC.b() + iB]);
                i5++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
        int length2 = bVarArr[0].f2340b.length - cVarC.b();
        int i6 = length2 - 1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int i9 = i8;
            int i10 = 0;
            while (i10 < i3) {
                bVarArr[i10].f2340b[i7] = bArr[i9];
                i10++;
                i9++;
            }
            i7++;
            i8 = i9;
        }
        boolean z = eVar.g() == 24;
        int i11 = z ? 8 : i3;
        int i12 = i8;
        int i13 = 0;
        while (i13 < i11) {
            bVarArr[i13].f2340b[i6] = bArr[i12];
            i13++;
            i12++;
        }
        int length3 = bVarArr[0].f2340b.length;
        while (length2 < length3) {
            int i14 = 0;
            while (i14 < i3) {
                int i15 = z ? (i14 + 8) % i3 : i14;
                bVarArr[i15].f2340b[(!z || i15 <= 7) ? length2 : length2 - 1] = bArr[i12];
                i14++;
                i12++;
            }
            length2++;
        }
        if (i12 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    int b() {
        return this.f2339a;
    }

    byte[] a() {
        return this.f2340b;
    }
}
