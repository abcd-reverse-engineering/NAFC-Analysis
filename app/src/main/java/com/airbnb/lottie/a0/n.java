package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.k.p;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: GradientStrokeParser.java */
/* loaded from: classes.dex */
class n {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f3402a = c.a.a("nm", "g", "o", "t", bh.aE, "e", "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f3403b = c.a.a(bh.aA, "k");

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f3404c = c.a.a("n", "v");

    private n() {
    }

    static com.airbnb.lottie.y.k.e a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        com.airbnb.lottie.y.j.c cVar2;
        ArrayList arrayList = new ArrayList();
        com.airbnb.lottie.y.j.d dVar = null;
        String strM = null;
        com.airbnb.lottie.y.k.f fVar = null;
        com.airbnb.lottie.y.j.c cVarA = null;
        com.airbnb.lottie.y.j.f fVarE = null;
        com.airbnb.lottie.y.j.f fVarE2 = null;
        com.airbnb.lottie.y.j.b bVarC = null;
        p.b bVar = null;
        p.c cVar3 = null;
        float fJ = 0.0f;
        com.airbnb.lottie.y.j.b bVar2 = null;
        boolean zI = false;
        while (cVar.h()) {
            switch (cVar.a(f3402a)) {
                case 0:
                    strM = cVar.m();
                    break;
                case 1:
                    int iK = -1;
                    cVar.d();
                    while (cVar.h()) {
                        int iA = cVar.a(f3403b);
                        if (iA != 0) {
                            cVar2 = cVarA;
                            if (iA != 1) {
                                cVar.n();
                                cVar.o();
                            } else {
                                cVarA = d.a(cVar, gVar, iK);
                            }
                        } else {
                            cVar2 = cVarA;
                            iK = cVar.k();
                        }
                        cVarA = cVar2;
                    }
                    cVar.f();
                    break;
                case 2:
                    dVar = d.d(cVar, gVar);
                    break;
                case 3:
                    fVar = cVar.k() == 1 ? com.airbnb.lottie.y.k.f.LINEAR : com.airbnb.lottie.y.k.f.RADIAL;
                    break;
                case 4:
                    fVarE = d.e(cVar, gVar);
                    break;
                case 5:
                    fVarE2 = d.e(cVar, gVar);
                    break;
                case 6:
                    bVarC = d.c(cVar, gVar);
                    break;
                case 7:
                    bVar = p.b.values()[cVar.k() - 1];
                    break;
                case 8:
                    cVar3 = p.c.values()[cVar.k() - 1];
                    break;
                case 9:
                    fJ = (float) cVar.j();
                    break;
                case 10:
                    zI = cVar.i();
                    break;
                case 11:
                    cVar.c();
                    while (cVar.h()) {
                        cVar.d();
                        String strM2 = null;
                        com.airbnb.lottie.y.j.b bVarC2 = null;
                        while (cVar.h()) {
                            int iA2 = cVar.a(f3404c);
                            if (iA2 != 0) {
                                com.airbnb.lottie.y.j.b bVar3 = bVar2;
                                if (iA2 != 1) {
                                    cVar.n();
                                    cVar.o();
                                } else {
                                    bVarC2 = d.c(cVar, gVar);
                                }
                                bVar2 = bVar3;
                            } else {
                                strM2 = cVar.m();
                            }
                        }
                        com.airbnb.lottie.y.j.b bVar4 = bVar2;
                        cVar.f();
                        if (strM2.equals("o")) {
                            bVar2 = bVarC2;
                        } else {
                            if (strM2.equals("d") || strM2.equals("g")) {
                                gVar.a(true);
                                arrayList.add(bVarC2);
                            }
                            bVar2 = bVar4;
                        }
                    }
                    com.airbnb.lottie.y.j.b bVar5 = bVar2;
                    cVar.e();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar2 = bVar5;
                    break;
                default:
                    cVar.n();
                    cVar.o();
                    break;
            }
        }
        if (dVar == null) {
            dVar = new com.airbnb.lottie.y.j.d(Collections.singletonList(new com.airbnb.lottie.c0.a(100)));
        }
        return new com.airbnb.lottie.y.k.e(strM, fVar, cVarA, dVar, fVarE, fVarE2, bVarC, bVar, cVar3, fJ, arrayList, bVar2, zI);
    }
}
