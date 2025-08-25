package c.b.c.z.n;

/* compiled from: ReedSolomonDecoder.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final a f3078a;

    public c(a aVar) {
        this.f3078a = aVar;
    }

    public void a(int[] iArr, int i2) throws e {
        b bVar = new b(this.f3078a, iArr);
        int[] iArr2 = new int[i2];
        boolean z = true;
        for (int i3 = 0; i3 < i2; i3++) {
            a aVar = this.f3078a;
            int iA = bVar.a(aVar.a(aVar.a() + i3));
            iArr2[(iArr2.length - 1) - i3] = iA;
            if (iA != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        b[] bVarArrA = a(this.f3078a.a(i2, 1), new b(this.f3078a, iArr2), i2);
        b bVar2 = bVarArrA[0];
        b bVar3 = bVarArrA[1];
        int[] iArrA = a(bVar2);
        int[] iArrA2 = a(bVar3, iArrA);
        for (int i4 = 0; i4 < iArrA.length; i4++) {
            int length = (iArr.length - 1) - this.f3078a.c(iArrA[i4]);
            if (length < 0) {
                throw new e("Bad error location");
            }
            iArr[length] = a.c(iArr[length], iArrA2[i4]);
        }
    }

    private b[] a(b bVar, b bVar2, int i2) throws e {
        if (bVar.b() < bVar2.b()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b bVarD = this.f3078a.d();
        b bVarB = this.f3078a.b();
        do {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
            b bVar4 = bVarB;
            b bVar5 = bVarD;
            bVarD = bVar4;
            if (bVar.b() >= i2 / 2) {
                if (!bVar.c()) {
                    b bVarD2 = this.f3078a.d();
                    int iB = this.f3078a.b(bVar.b(bVar.b()));
                    while (bVar2.b() >= bVar.b() && !bVar2.c()) {
                        int iB2 = bVar2.b() - bVar.b();
                        int iB3 = this.f3078a.b(bVar2.b(bVar2.b()), iB);
                        bVarD2 = bVarD2.a(this.f3078a.a(iB2, iB3));
                        bVar2 = bVar2.a(bVar.a(iB2, iB3));
                    }
                    bVarB = bVarD2.c(bVarD).a(bVar5);
                } else {
                    throw new e("r_{i-1} was zero");
                }
            } else {
                int iB4 = bVarD.b(0);
                if (iB4 != 0) {
                    int iB5 = this.f3078a.b(iB4);
                    return new b[]{bVarD.c(iB5), bVar.c(iB5)};
                }
                throw new e("sigmaTilde(0) was zero");
            }
        } while (bVar2.b() < bVar.b());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    private int[] a(b bVar) throws e {
        int iB = bVar.b();
        int i2 = 0;
        if (iB == 1) {
            return new int[]{bVar.b(1)};
        }
        int[] iArr = new int[iB];
        for (int i3 = 1; i3 < this.f3078a.c() && i2 < iB; i3++) {
            if (bVar.a(i3) == 0) {
                iArr[i2] = this.f3078a.b(i3);
                i2++;
            }
        }
        if (i2 == iB) {
            return iArr;
        }
        throw new e("Error locator degree does not match number of roots");
    }

    private int[] a(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iB = this.f3078a.b(iArr[i2]);
            int iB2 = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i2 != i3) {
                    int iB3 = this.f3078a.b(iArr[i3], iB);
                    iB2 = this.f3078a.b(iB2, (iB3 & 1) == 0 ? iB3 | 1 : iB3 & (-2));
                }
            }
            iArr2[i2] = this.f3078a.b(bVar.a(iB), this.f3078a.b(iB2));
            if (this.f3078a.a() != 0) {
                iArr2[i2] = this.f3078a.b(iArr2[i2], iB);
            }
        }
        return iArr2;
    }
}
