package com.airbnb.lottie.a0;

import android.graphics.PointF;
import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* compiled from: CircleShapeParser.java */
/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f3335a = c.a.a("nm", bh.aA, bh.aE, "hd", "d");

    private e() {
    }

    static com.airbnb.lottie.y.k.a a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar, int i2) throws IOException {
        boolean z = i2 == 3;
        String strM = null;
        com.airbnb.lottie.y.j.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.y.j.f fVarE = null;
        boolean zI = false;
        while (cVar.h()) {
            int iA = cVar.a(f3335a);
            if (iA == 0) {
                strM = cVar.m();
            } else if (iA == 1) {
                mVarB = a.b(cVar, gVar);
            } else if (iA == 2) {
                fVarE = d.e(cVar, gVar);
            } else if (iA == 3) {
                zI = cVar.i();
            } else if (iA != 4) {
                cVar.n();
                cVar.o();
            } else {
                z = cVar.k() == 3;
            }
        }
        return new com.airbnb.lottie.y.k.a(strM, mVarB, fVarE, z, zI);
    }
}
