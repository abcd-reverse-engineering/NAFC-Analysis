package c.b.c.e0.e.k;

/* compiled from: ModulusPoly.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final b f2686a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f2687b;

    c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f2686a = bVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f2687b = iArr;
            return;
        }
        int i2 = 1;
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.f2687b = new int[]{0};
            return;
        }
        this.f2687b = new int[length - i2];
        int[] iArr2 = this.f2687b;
        System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
    }

    int[] a() {
        return this.f2687b;
    }

    int b() {
        return this.f2687b.length - 1;
    }

    boolean c() {
        return this.f2687b[0] == 0;
    }

    c d(c cVar) {
        if (this.f2686a.equals(cVar.f2686a)) {
            return cVar.c() ? this : a(cVar.d());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int iB = b(); iB >= 0; iB--) {
            int iB2 = b(iB);
            if (iB2 != 0) {
                if (iB2 < 0) {
                    sb.append(" - ");
                    iB2 = -iB2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iB == 0 || iB2 != 1) {
                    sb.append(iB2);
                }
                if (iB != 0) {
                    if (iB == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iB);
                    }
                }
            }
        }
        return sb.toString();
    }

    int a(int i2) {
        if (i2 == 0) {
            return b(0);
        }
        int[] iArr = this.f2687b;
        int length = iArr.length;
        if (i2 != 1) {
            int iA = iArr[0];
            for (int i3 = 1; i3 < length; i3++) {
                b bVar = this.f2686a;
                iA = bVar.a(bVar.c(i2, iA), this.f2687b[i3]);
            }
            return iA;
        }
        int iA2 = 0;
        for (int i4 : iArr) {
            iA2 = this.f2686a.a(iA2, i4);
        }
        return iA2;
    }

    int b(int i2) {
        return this.f2687b[(r0.length - 1) - i2];
    }

    c c(c cVar) {
        if (!this.f2686a.equals(cVar.f2686a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (c() || cVar.c()) {
            return this.f2686a.c();
        }
        int[] iArr = this.f2687b;
        int length = iArr.length;
        int[] iArr2 = cVar.f2687b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = i2 + i4;
                b bVar = this.f2686a;
                iArr3[i5] = bVar.a(iArr3[i5], bVar.c(i3, iArr2[i4]));
            }
        }
        return new c(this.f2686a, iArr3);
    }

    c[] b(c cVar) {
        if (this.f2686a.equals(cVar.f2686a)) {
            if (!cVar.c()) {
                c cVarC = this.f2686a.c();
                int iB = this.f2686a.b(cVar.b(cVar.b()));
                c cVarA = cVarC;
                c cVarD = this;
                while (cVarD.b() >= cVar.b() && !cVarD.c()) {
                    int iB2 = cVarD.b() - cVar.b();
                    int iC = this.f2686a.c(cVarD.b(cVarD.b()), iB);
                    c cVarA2 = cVar.a(iB2, iC);
                    cVarA = cVarA.a(this.f2686a.b(iB2, iC));
                    cVarD = cVarD.d(cVarA2);
                }
                return new c[]{cVarA, cVarD};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    c d() {
        int length = this.f2687b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f2686a.d(0, this.f2687b[i2]);
        }
        return new c(this.f2686a, iArr);
    }

    c a(c cVar) {
        if (this.f2686a.equals(cVar.f2686a)) {
            if (c()) {
                return cVar;
            }
            if (cVar.c()) {
                return this;
            }
            int[] iArr = this.f2687b;
            int[] iArr2 = cVar.f2687b;
            if (iArr.length > iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            for (int i2 = length; i2 < iArr2.length; i2++) {
                iArr3[i2] = this.f2686a.a(iArr[i2 - length], iArr2[i2]);
            }
            return new c(this.f2686a, iArr3);
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    c c(int i2) {
        if (i2 == 0) {
            return this.f2686a.c();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f2687b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f2686a.c(this.f2687b[i3], i2);
        }
        return new c(this.f2686a, iArr);
    }

    c a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f2686a.c();
        }
        int length = this.f2687b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.f2686a.c(this.f2687b[i4], i3);
        }
        return new c(this.f2686a, iArr);
    }
}
