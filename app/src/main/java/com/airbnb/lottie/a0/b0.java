package com.airbnb.lottie.a0;

import android.graphics.PointF;
import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* compiled from: RectangleShapeParser.java */
/* loaded from: classes.dex */
class b0 {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f3330a = c.a.a("nm", bh.aA, bh.aE, "r", "hd");

    private b0() {
    }

    static com.airbnb.lottie.y.k.j a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        String strM = null;
        com.airbnb.lottie.y.j.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.y.j.f fVarE = null;
        com.airbnb.lottie.y.j.b bVarC = null;
        boolean zI = false;
        while (cVar.h()) {
            int iA = cVar.a(f3330a);
            if (iA == 0) {
                strM = cVar.m();
            } else if (iA == 1) {
                mVarB = a.b(cVar, gVar);
            } else if (iA == 2) {
                fVarE = d.e(cVar, gVar);
            } else if (iA == 3) {
                bVarC = d.c(cVar, gVar);
            } else if (iA != 4) {
                cVar.o();
            } else {
                zI = cVar.i();
            }
        }
        return new com.airbnb.lottie.y.k.j(strM, mVarB, fVarE, bVarC, zI);
    }
}
