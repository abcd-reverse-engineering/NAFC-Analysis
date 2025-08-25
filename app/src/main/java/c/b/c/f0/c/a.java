package c.b.c.f0.c;

/* compiled from: BitMatrixParser.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.b f2744a;

    /* renamed from: b, reason: collision with root package name */
    private j f2745b;

    /* renamed from: c, reason: collision with root package name */
    private g f2746c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2747d;

    a(c.b.c.z.b bVar) throws c.b.c.h {
        int iD = bVar.d();
        if (iD < 21 || (iD & 3) != 1) {
            throw c.b.c.h.getFormatInstance();
        }
        this.f2744a = bVar;
    }

    private int a(int i2, int i3, int i4) {
        return this.f2747d ? this.f2744a.b(i3, i2) : this.f2744a.b(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
    }

    byte[] b() throws c.b.c.h {
        g gVarC = c();
        j jVarD = d();
        c cVarA = c.a(gVarC.a());
        int iD = this.f2744a.d();
        cVarA.a(this.f2744a, iD);
        c.b.c.z.b bVarA = jVarD.a();
        byte[] bArr = new byte[jVarD.d()];
        int i2 = iD - 1;
        int i3 = i2;
        int i4 = 0;
        boolean z = true;
        int i5 = 0;
        int i6 = 0;
        while (i3 > 0) {
            if (i3 == 6) {
                i3--;
            }
            int i7 = i6;
            int i8 = i5;
            int i9 = i4;
            int i10 = 0;
            while (i10 < iD) {
                int i11 = z ? i2 - i10 : i10;
                int i12 = i7;
                int i13 = i8;
                int i14 = i9;
                for (int i15 = 0; i15 < 2; i15++) {
                    int i16 = i3 - i15;
                    if (!bVarA.b(i16, i11)) {
                        i13++;
                        int i17 = i12 << 1;
                        int i18 = this.f2744a.b(i16, i11) ? i17 | 1 : i17;
                        if (i13 == 8) {
                            bArr[i14] = (byte) i18;
                            i14++;
                            i13 = 0;
                            i12 = 0;
                        } else {
                            i12 = i18;
                        }
                    }
                }
                i10++;
                i9 = i14;
                i8 = i13;
                i7 = i12;
            }
            z = !z;
            i3 -= 2;
            i4 = i9;
            i5 = i8;
            i6 = i7;
        }
        if (i4 == jVarD.d()) {
            return bArr;
        }
        throw c.b.c.h.getFormatInstance();
    }

    g c() throws c.b.c.h {
        g gVar = this.f2746c;
        if (gVar != null) {
            return gVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            iA2 = a(i2, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i3 = 5; i3 >= 0; i3--) {
            iA3 = a(8, i3, iA3);
        }
        int iD = this.f2744a.d();
        int i4 = iD - 7;
        for (int i5 = iD - 1; i5 >= i4; i5--) {
            iA = a(8, i5, iA);
        }
        for (int i6 = iD - 8; i6 < iD; i6++) {
            iA = a(i6, 8, iA);
        }
        this.f2746c = g.a(iA3, iA);
        g gVar2 = this.f2746c;
        if (gVar2 != null) {
            return gVar2;
        }
        throw c.b.c.h.getFormatInstance();
    }

    j d() throws c.b.c.h {
        j jVar = this.f2745b;
        if (jVar != null) {
            return jVar;
        }
        int iD = this.f2744a.d();
        int i2 = (iD - 17) / 4;
        if (i2 <= 6) {
            return j.c(i2);
        }
        int i3 = iD - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = iD - 9; i5 >= i3; i5--) {
                iA2 = a(i5, i4, iA2);
            }
        }
        j jVarA = j.a(iA2);
        if (jVarA != null && jVarA.c() == iD) {
            this.f2745b = jVarA;
            return jVarA;
        }
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = iD - 9; i7 >= i3; i7--) {
                iA = a(i6, i7, iA);
            }
        }
        j jVarA2 = j.a(iA);
        if (jVarA2 == null || jVarA2.c() != iD) {
            throw c.b.c.h.getFormatInstance();
        }
        this.f2745b = jVarA2;
        return jVarA2;
    }

    void e() {
        g gVar = this.f2746c;
        if (gVar == null) {
            return;
        }
        c.a(gVar.a()).a(this.f2744a, this.f2744a.d());
    }

    void a(boolean z) {
        this.f2745b = null;
        this.f2746c = null;
        this.f2747d = z;
    }

    void a() {
        int i2 = 0;
        while (i2 < this.f2744a.g()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.f2744a.d(); i4++) {
                if (this.f2744a.b(i2, i4) != this.f2744a.b(i4, i2)) {
                    this.f2744a.a(i4, i2);
                    this.f2744a.a(i2, i4);
                }
            }
            i2 = i3;
        }
    }
}
