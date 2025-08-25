package c.b.c.e0.e.k;

import c.b.c.d;

/* compiled from: ErrorCorrection.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f2679a = b.f2680f;

    public int a(int[] iArr, int i2, int[] iArr2) throws d {
        c cVar = new c(this.f2679a, iArr);
        int[] iArr3 = new int[i2];
        boolean z = false;
        for (int i3 = i2; i3 > 0; i3--) {
            int iA = cVar.a(this.f2679a.a(i3));
            iArr3[i2 - i3] = iA;
            if (iA != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        c cVarA = this.f2679a.a();
        if (iArr2 != null) {
            c cVarC = cVarA;
            for (int i4 : iArr2) {
                int iA2 = this.f2679a.a((iArr.length - 1) - i4);
                b bVar = this.f2679a;
                cVarC = cVarC.c(new c(bVar, new int[]{bVar.d(0, iA2), 1}));
            }
        }
        c[] cVarArrA = a(this.f2679a.b(i2, 1), new c(this.f2679a, iArr3), i2);
        c cVar2 = cVarArrA[0];
        c cVar3 = cVarArrA[1];
        int[] iArrA = a(cVar2);
        int[] iArrA2 = a(cVar3, cVar2, iArrA);
        for (int i5 = 0; i5 < iArrA.length; i5++) {
            int length = (iArr.length - 1) - this.f2679a.c(iArrA[i5]);
            if (length < 0) {
                throw d.getChecksumInstance();
            }
            iArr[length] = this.f2679a.d(iArr[length], iArrA2[i5]);
        }
        return iArrA.length;
    }

    private c[] a(c cVar, c cVar2, int i2) throws d {
        if (cVar.b() < cVar2.b()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c cVarC = this.f2679a.c();
        c cVarA = this.f2679a.a();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = cVarA;
            c cVar5 = cVarC;
            cVarC = cVar4;
            if (cVar.b() >= i2 / 2) {
                if (!cVar.c()) {
                    c cVarC2 = this.f2679a.c();
                    int iB = this.f2679a.b(cVar.b(cVar.b()));
                    while (cVar2.b() >= cVar.b() && !cVar2.c()) {
                        int iB2 = cVar2.b() - cVar.b();
                        int iC = this.f2679a.c(cVar2.b(cVar2.b()), iB);
                        cVarC2 = cVarC2.a(this.f2679a.b(iB2, iC));
                        cVar2 = cVar2.d(cVar.a(iB2, iC));
                    }
                    cVarA = cVarC2.c(cVarC).d(cVar5).d();
                } else {
                    throw d.getChecksumInstance();
                }
            } else {
                int iB3 = cVarC.b(0);
                if (iB3 != 0) {
                    int iB4 = this.f2679a.b(iB3);
                    return new c[]{cVarC.c(iB4), cVar.c(iB4)};
                }
                throw d.getChecksumInstance();
            }
        }
    }

    private int[] a(c cVar) throws d {
        int iB = cVar.b();
        int[] iArr = new int[iB];
        int i2 = 0;
        for (int i3 = 1; i3 < this.f2679a.b() && i2 < iB; i3++) {
            if (cVar.a(i3) == 0) {
                iArr[i2] = this.f2679a.b(i3);
                i2++;
            }
        }
        if (i2 == iB) {
            return iArr;
        }
        throw d.getChecksumInstance();
    }

    private int[] a(c cVar, c cVar2, int[] iArr) {
        int iB = cVar2.b();
        int[] iArr2 = new int[iB];
        for (int i2 = 1; i2 <= iB; i2++) {
            iArr2[iB - i2] = this.f2679a.c(i2, cVar2.b(i2));
        }
        c cVar3 = new c(this.f2679a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            int iB2 = this.f2679a.b(iArr[i3]);
            iArr3[i3] = this.f2679a.c(this.f2679a.d(0, cVar.a(iB2)), this.f2679a.b(cVar3.a(iB2)));
        }
        return iArr3;
    }
}
