package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: FontCharacterParser.java */
/* loaded from: classes.dex */
class j {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3348a = c.a.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f3349b = c.a.a("shapes");

    private j() {
    }

    static com.airbnb.lottie.y.d a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.d();
        String strM = null;
        String strM2 = null;
        double dJ = 0.0d;
        double dJ2 = 0.0d;
        char cCharAt = 0;
        while (cVar.h()) {
            int iA = cVar.a(f3348a);
            if (iA == 0) {
                cCharAt = cVar.m().charAt(0);
            } else if (iA == 1) {
                dJ = cVar.j();
            } else if (iA == 2) {
                dJ2 = cVar.j();
            } else if (iA == 3) {
                strM = cVar.m();
            } else if (iA == 4) {
                strM2 = cVar.m();
            } else if (iA != 5) {
                cVar.n();
                cVar.o();
            } else {
                cVar.d();
                while (cVar.h()) {
                    if (cVar.a(f3349b) != 0) {
                        cVar.n();
                        cVar.o();
                    } else {
                        cVar.c();
                        while (cVar.h()) {
                            arrayList.add((com.airbnb.lottie.y.k.n) g.a(cVar, gVar));
                        }
                        cVar.e();
                    }
                }
                cVar.f();
            }
        }
        cVar.f();
        return new com.airbnb.lottie.y.d(arrayList, cCharAt, dJ, dJ2, strM, strM2);
    }
}
