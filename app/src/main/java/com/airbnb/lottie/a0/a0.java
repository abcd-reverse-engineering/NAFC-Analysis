package com.airbnb.lottie.a0;

import android.graphics.PointF;
import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.k.i;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* compiled from: PolystarShapeParser.java */
/* loaded from: classes.dex */
class a0 {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3327a = c.a.a("nm", "sy", "pt", bh.aA, "r", "or", "os", "ir", bh.ae, "hd");

    private a0() {
    }

    static com.airbnb.lottie.y.k.i a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        String strM = null;
        i.a aVarForValue = null;
        com.airbnb.lottie.y.j.b bVarA = null;
        com.airbnb.lottie.y.j.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.y.j.b bVarA2 = null;
        com.airbnb.lottie.y.j.b bVarC = null;
        com.airbnb.lottie.y.j.b bVarC2 = null;
        com.airbnb.lottie.y.j.b bVarA3 = null;
        com.airbnb.lottie.y.j.b bVarA4 = null;
        boolean zI = false;
        while (cVar.h()) {
            switch (cVar.a(f3327a)) {
                case 0:
                    strM = cVar.m();
                    break;
                case 1:
                    aVarForValue = i.a.forValue(cVar.k());
                    break;
                case 2:
                    bVarA = d.a(cVar, gVar, false);
                    break;
                case 3:
                    mVarB = a.b(cVar, gVar);
                    break;
                case 4:
                    bVarA2 = d.a(cVar, gVar, false);
                    break;
                case 5:
                    bVarC2 = d.c(cVar, gVar);
                    break;
                case 6:
                    bVarA4 = d.a(cVar, gVar, false);
                    break;
                case 7:
                    bVarC = d.c(cVar, gVar);
                    break;
                case 8:
                    bVarA3 = d.a(cVar, gVar, false);
                    break;
                case 9:
                    zI = cVar.i();
                    break;
                default:
                    cVar.n();
                    cVar.o();
                    break;
            }
        }
        return new com.airbnb.lottie.y.k.i(strM, aVarForValue, bVarA, mVarB, bVarA2, bVarC, bVarC2, bVarA3, bVarA4, zI);
    }
}
