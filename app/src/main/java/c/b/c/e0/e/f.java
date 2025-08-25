package c.b.c.e0.e;

import java.util.Formatter;

/* compiled from: DetectionResult.java */
/* loaded from: classes.dex */
final class f {

    /* renamed from: e, reason: collision with root package name */
    private static final int f2665e = 2;

    /* renamed from: a, reason: collision with root package name */
    private final a f2666a;

    /* renamed from: b, reason: collision with root package name */
    private final g[] f2667b;

    /* renamed from: c, reason: collision with root package name */
    private c f2668c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2669d;

    f(a aVar, c cVar) {
        this.f2666a = aVar;
        this.f2669d = aVar.a();
        this.f2668c = cVar;
        this.f2667b = new g[this.f2669d + 2];
    }

    private void a(g gVar) {
        if (gVar != null) {
            ((h) gVar).a(this.f2666a);
        }
    }

    private int f() {
        int iG = g();
        if (iG == 0) {
            return 0;
        }
        for (int i2 = 1; i2 < this.f2669d + 1; i2++) {
            d[] dVarArrB = this.f2667b[i2].b();
            for (int i3 = 0; i3 < dVarArrB.length; i3++) {
                if (dVarArrB[i3] != null && !dVarArrB[i3].g()) {
                    a(i2, i3, dVarArrB);
                }
            }
        }
        return iG;
    }

    private int g() {
        h();
        return i() + j();
    }

    private void h() {
        g[] gVarArr = this.f2667b;
        if (gVarArr[0] == null || gVarArr[this.f2669d + 1] == null) {
            return;
        }
        d[] dVarArrB = gVarArr[0].b();
        d[] dVarArrB2 = this.f2667b[this.f2669d + 1].b();
        for (int i2 = 0; i2 < dVarArrB.length; i2++) {
            if (dVarArrB[i2] != null && dVarArrB2[i2] != null && dVarArrB[i2].c() == dVarArrB2[i2].c()) {
                for (int i3 = 1; i3 <= this.f2669d; i3++) {
                    d dVar = this.f2667b[i3].b()[i2];
                    if (dVar != null) {
                        dVar.b(dVarArrB[i2].c());
                        if (!dVar.g()) {
                            this.f2667b[i3].b()[i2] = null;
                        }
                    }
                }
            }
        }
    }

    private int i() {
        g[] gVarArr = this.f2667b;
        if (gVarArr[0] == null) {
            return 0;
        }
        d[] dVarArrB = gVarArr[0].b();
        int i2 = 0;
        for (int i3 = 0; i3 < dVarArrB.length; i3++) {
            if (dVarArrB[i3] != null) {
                int iC = dVarArrB[i3].c();
                int i4 = i2;
                int iA = 0;
                for (int i5 = 1; i5 < this.f2669d + 1 && iA < 2; i5++) {
                    d dVar = this.f2667b[i5].b()[i3];
                    if (dVar != null) {
                        iA = a(iC, iA, dVar);
                        if (!dVar.g()) {
                            i4++;
                        }
                    }
                }
                i2 = i4;
            }
        }
        return i2;
    }

    private int j() {
        g[] gVarArr = this.f2667b;
        int i2 = this.f2669d;
        if (gVarArr[i2 + 1] == null) {
            return 0;
        }
        d[] dVarArrB = gVarArr[i2 + 1].b();
        int i3 = 0;
        for (int i4 = 0; i4 < dVarArrB.length; i4++) {
            if (dVarArrB[i4] != null) {
                int iC = dVarArrB[i4].c();
                int i5 = i3;
                int iA = 0;
                for (int i6 = this.f2669d + 1; i6 > 0 && iA < 2; i6--) {
                    d dVar = this.f2667b[i6].b()[i4];
                    if (dVar != null) {
                        iA = a(iC, iA, dVar);
                        if (!dVar.g()) {
                            i5++;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return i3;
    }

    int b() {
        return this.f2666a.b();
    }

    int c() {
        return this.f2666a.c();
    }

    c d() {
        return this.f2668c;
    }

    g[] e() {
        a(this.f2667b[0]);
        a(this.f2667b[this.f2669d + 1]);
        int i2 = c.b.c.e0.a.f2614b;
        while (true) {
            int iF = f();
            if (iF <= 0 || iF >= i2) {
                break;
            }
            i2 = iF;
        }
        return this.f2667b;
    }

    public String toString() {
        g[] gVarArr = this.f2667b;
        g gVar = gVarArr[0];
        if (gVar == null) {
            gVar = gVarArr[this.f2669d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i2 = 0; i2 < gVar.b().length; i2++) {
            formatter.format("CW %3d:", Integer.valueOf(i2));
            for (int i3 = 0; i3 < this.f2669d + 2; i3++) {
                g[] gVarArr2 = this.f2667b;
                if (gVarArr2[i3] == null) {
                    formatter.format("    |   ", new Object[0]);
                } else {
                    d dVar = gVarArr2[i3].b()[i2];
                    if (dVar == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        formatter.format(" %3d|%3d", Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                    }
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }

    private static int a(int i2, int i3, d dVar) {
        if (dVar == null || dVar.g()) {
            return i3;
        }
        if (!dVar.a(i2)) {
            return i3 + 1;
        }
        dVar.b(i2);
        return 0;
    }

    private void a(int i2, int i3, d[] dVarArr) {
        d dVar = dVarArr[i3];
        d[] dVarArrB = this.f2667b[i2 - 1].b();
        g[] gVarArr = this.f2667b;
        int i4 = i2 + 1;
        d[] dVarArrB2 = gVarArr[i4] != null ? gVarArr[i4].b() : dVarArrB;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = dVarArrB[i3];
        dVarArr2[3] = dVarArrB2[i3];
        if (i3 > 0) {
            int i5 = i3 - 1;
            dVarArr2[0] = dVarArr[i5];
            dVarArr2[4] = dVarArrB[i5];
            dVarArr2[5] = dVarArrB2[i5];
        }
        if (i3 > 1) {
            int i6 = i3 - 2;
            dVarArr2[8] = dVarArr[i6];
            dVarArr2[10] = dVarArrB[i6];
            dVarArr2[11] = dVarArrB2[i6];
        }
        if (i3 < dVarArr.length - 1) {
            int i7 = i3 + 1;
            dVarArr2[1] = dVarArr[i7];
            dVarArr2[6] = dVarArrB[i7];
            dVarArr2[7] = dVarArrB2[i7];
        }
        if (i3 < dVarArr.length - 2) {
            int i8 = i3 + 2;
            dVarArr2[9] = dVarArr[i8];
            dVarArr2[12] = dVarArrB[i8];
            dVarArr2[13] = dVarArrB2[i8];
        }
        int length = dVarArr2.length;
        for (int i9 = 0; i9 < length && !a(dVar, dVarArr2[i9]); i9++) {
        }
    }

    private static boolean a(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.g() || dVar2.a() != dVar.a()) {
            return false;
        }
        dVar.b(dVar2.c());
        return true;
    }

    int a() {
        return this.f2669d;
    }

    public void a(c cVar) {
        this.f2668c = cVar;
    }

    void a(int i2, g gVar) {
        this.f2667b[i2] = gVar;
    }

    g a(int i2) {
        return this.f2667b[i2];
    }
}
