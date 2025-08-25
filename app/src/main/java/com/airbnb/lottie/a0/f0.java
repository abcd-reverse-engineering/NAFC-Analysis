package com.airbnb.lottie.a0;

import android.graphics.Path;
import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.util.Collections;

/* compiled from: ShapeFillParser.java */
/* loaded from: classes.dex */
class f0 {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3339a = c.a.a("nm", bh.aI, "o", "fillEnabled", "r", "hd");

    private f0() {
    }

    static com.airbnb.lottie.y.k.m a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        com.airbnb.lottie.y.j.d dVar = null;
        String strM = null;
        com.airbnb.lottie.y.j.a aVarA = null;
        int iK = 1;
        boolean zI = false;
        boolean zI2 = false;
        while (cVar.h()) {
            int iA = cVar.a(f3339a);
            if (iA == 0) {
                strM = cVar.m();
            } else if (iA == 1) {
                aVarA = d.a(cVar, gVar);
            } else if (iA == 2) {
                dVar = d.d(cVar, gVar);
            } else if (iA == 3) {
                zI = cVar.i();
            } else if (iA == 4) {
                iK = cVar.k();
            } else if (iA != 5) {
                cVar.n();
                cVar.o();
            } else {
                zI2 = cVar.i();
            }
        }
        if (dVar == null) {
            dVar = new com.airbnb.lottie.y.j.d(Collections.singletonList(new com.airbnb.lottie.c0.a(100)));
        }
        return new com.airbnb.lottie.y.k.m(strM, zI, iK == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVarA, dVar, zI2);
    }
}
