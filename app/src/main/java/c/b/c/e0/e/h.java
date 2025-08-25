package c.b.c.e0.e;

import c.b.c.t;

/* compiled from: DetectionResultRowIndicatorColumn.java */
/* loaded from: classes.dex */
final class h extends g {

    /* renamed from: d, reason: collision with root package name */
    private final boolean f2673d;

    h(c cVar, boolean z) {
        super(cVar);
        this.f2673d = z;
    }

    int a(a aVar) {
        d[] dVarArrB = b();
        f();
        a(dVarArrB, aVar);
        c cVarA = a();
        t tVarG = this.f2673d ? cVarA.g() : cVarA.h();
        t tVarA = this.f2673d ? cVarA.a() : cVarA.b();
        int iC = c((int) tVarG.b());
        int iC2 = c((int) tVarA.b());
        float fC = (iC2 - iC) / aVar.c();
        int iC3 = -1;
        int i2 = 0;
        int iMax = 1;
        while (iC < iC2) {
            if (dVarArrB[iC] != null) {
                d dVar = dVarArrB[iC];
                int iC4 = dVar.c() - iC3;
                if (iC4 == 0) {
                    i2++;
                } else {
                    if (iC4 == 1) {
                        iMax = Math.max(iMax, i2);
                        iC3 = dVar.c();
                    } else if (iC4 < 0 || dVar.c() >= aVar.c() || iC4 > iC) {
                        dVarArrB[iC] = null;
                    } else {
                        if (iMax > 2) {
                            iC4 *= iMax - 2;
                        }
                        boolean z = iC4 >= iC;
                        for (int i3 = 1; i3 <= iC4 && !z; i3++) {
                            z = dVarArrB[iC - i3] != null;
                        }
                        if (z) {
                            dVarArrB[iC] = null;
                        } else {
                            iC3 = dVar.c();
                        }
                    }
                    i2 = 1;
                }
            }
            iC++;
        }
        return (int) (fC + 0.5d);
    }

    int b(a aVar) {
        c cVarA = a();
        t tVarG = this.f2673d ? cVarA.g() : cVarA.h();
        t tVarA = this.f2673d ? cVarA.a() : cVarA.b();
        int iC = c((int) tVarG.b());
        int iC2 = c((int) tVarA.b());
        float fC = (iC2 - iC) / aVar.c();
        d[] dVarArrB = b();
        int iC3 = -1;
        int i2 = 0;
        int iMax = 1;
        while (iC < iC2) {
            if (dVarArrB[iC] != null) {
                d dVar = dVarArrB[iC];
                dVar.h();
                int iC4 = dVar.c() - iC3;
                if (iC4 == 0) {
                    i2++;
                } else {
                    if (iC4 == 1) {
                        iMax = Math.max(iMax, i2);
                        iC3 = dVar.c();
                    } else if (dVar.c() >= aVar.c()) {
                        dVarArrB[iC] = null;
                    } else {
                        iC3 = dVar.c();
                    }
                    i2 = 1;
                }
            }
            iC++;
        }
        return (int) (fC + 0.5d);
    }

    a c() {
        d[] dVarArrB = b();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : dVarArrB) {
            if (dVar != null) {
                dVar.h();
                int iE = dVar.e() % 30;
                int iC = dVar.c();
                if (!this.f2673d) {
                    iC += 2;
                }
                int i2 = iC % 3;
                if (i2 == 0) {
                    bVar2.b((iE * 3) + 1);
                } else if (i2 == 1) {
                    bVar4.b(iE / 3);
                    bVar3.b(iE % 3);
                } else if (i2 == 2) {
                    bVar.b(iE + 1);
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] < 1 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        a(dVarArrB, aVar);
        return aVar;
    }

    int[] d() throws c.b.c.h {
        a aVarC = c();
        if (aVarC == null) {
            return null;
        }
        b(aVarC);
        int[] iArr = new int[aVarC.c()];
        for (d dVar : b()) {
            if (dVar != null) {
                int iC = dVar.c();
                if (iC >= iArr.length) {
                    throw c.b.c.h.getFormatInstance();
                }
                iArr[iC] = iArr[iC] + 1;
            }
        }
        return iArr;
    }

    boolean e() {
        return this.f2673d;
    }

    void f() {
        for (d dVar : b()) {
            if (dVar != null) {
                dVar.h();
            }
        }
    }

    @Override // c.b.c.e0.e.g
    public String toString() {
        return "IsLeft: " + this.f2673d + '\n' + super.toString();
    }

    private void a(d[] dVarArr, a aVar) {
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            d dVar = dVarArr[i2];
            if (dVarArr[i2] != null) {
                int iE = dVar.e() % 30;
                int iC = dVar.c();
                if (iC > aVar.c()) {
                    dVarArr[i2] = null;
                } else {
                    if (!this.f2673d) {
                        iC += 2;
                    }
                    int i3 = iC % 3;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2 && iE + 1 != aVar.a()) {
                                dVarArr[i2] = null;
                            }
                        } else if (iE / 3 != aVar.b() || iE % 3 != aVar.d()) {
                            dVarArr[i2] = null;
                        }
                    } else if ((iE * 3) + 1 != aVar.e()) {
                        dVarArr[i2] = null;
                    }
                }
            }
        }
    }
}
