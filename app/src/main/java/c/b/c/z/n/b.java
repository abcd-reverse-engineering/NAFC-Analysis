package c.b.c.z.n;

/* compiled from: GenericGFPoly.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final a f3076a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f3077b;

    b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f3076a = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f3077b = iArr;
            return;
        }
        int i2 = 1;
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.f3077b = new int[]{0};
            return;
        }
        this.f3077b = new int[length - i2];
        int[] iArr2 = this.f3077b;
        System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
    }

    int[] a() {
        return this.f3077b;
    }

    int b() {
        return this.f3077b.length - 1;
    }

    boolean c() {
        return this.f3077b[0] == 0;
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
                    int iC = this.f3076a.c(iB2);
                    if (iC == 0) {
                        sb.append('1');
                    } else if (iC == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(iC);
                    }
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
        int[] iArr = this.f3077b;
        int length = iArr.length;
        if (i2 != 1) {
            int iC = iArr[0];
            for (int i3 = 1; i3 < length; i3++) {
                iC = a.c(this.f3076a.b(i2, iC), this.f3077b[i3]);
            }
            return iC;
        }
        int iC2 = 0;
        for (int i4 : iArr) {
            iC2 = a.c(iC2, i4);
        }
        return iC2;
    }

    int b(int i2) {
        return this.f3077b[(r0.length - 1) - i2];
    }

    b c(b bVar) {
        if (!this.f3076a.equals(bVar.f3076a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (c() || bVar.c()) {
            return this.f3076a.d();
        }
        int[] iArr = this.f3077b;
        int length = iArr.length;
        int[] iArr2 = bVar.f3077b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = i2 + i4;
                iArr3[i5] = a.c(iArr3[i5], this.f3076a.b(i3, iArr2[i4]));
            }
        }
        return new b(this.f3076a, iArr3);
    }

    b[] b(b bVar) {
        if (this.f3076a.equals(bVar.f3076a)) {
            if (!bVar.c()) {
                b bVarD = this.f3076a.d();
                int iB = this.f3076a.b(bVar.b(bVar.b()));
                b bVarA = bVarD;
                b bVarA2 = this;
                while (bVarA2.b() >= bVar.b() && !bVarA2.c()) {
                    int iB2 = bVarA2.b() - bVar.b();
                    int iB3 = this.f3076a.b(bVarA2.b(bVarA2.b()), iB);
                    b bVarA3 = bVar.a(iB2, iB3);
                    bVarA = bVarA.a(this.f3076a.a(iB2, iB3));
                    bVarA2 = bVarA2.a(bVarA3);
                }
                return new b[]{bVarA, bVarA2};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    b a(b bVar) {
        if (this.f3076a.equals(bVar.f3076a)) {
            if (c()) {
                return bVar;
            }
            if (bVar.c()) {
                return this;
            }
            int[] iArr = this.f3077b;
            int[] iArr2 = bVar.f3077b;
            if (iArr.length > iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            for (int i2 = length; i2 < iArr2.length; i2++) {
                iArr3[i2] = a.c(iArr[i2 - length], iArr2[i2]);
            }
            return new b(this.f3076a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    b c(int i2) {
        if (i2 == 0) {
            return this.f3076a.d();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f3077b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f3076a.b(this.f3077b[i3], i2);
        }
        return new b(this.f3076a, iArr);
    }

    b a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f3076a.d();
        }
        int length = this.f3077b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.f3076a.b(this.f3077b[i4], i3);
        }
        return new b(this.f3076a, iArr);
    }
}
