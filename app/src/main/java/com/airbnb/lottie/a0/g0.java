package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ShapeGroupParser.java */
/* loaded from: classes.dex */
class g0 {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f3341a = c.a.a("nm", "hd", "it");

    private g0() {
    }

    static com.airbnb.lottie.y.k.n a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strM = null;
        boolean zI = false;
        while (cVar.h()) {
            int iA = cVar.a(f3341a);
            if (iA == 0) {
                strM = cVar.m();
            } else if (iA == 1) {
                zI = cVar.i();
            } else if (iA != 2) {
                cVar.o();
            } else {
                cVar.c();
                while (cVar.h()) {
                    com.airbnb.lottie.y.k.b bVarA = g.a(cVar, gVar);
                    if (bVarA != null) {
                        arrayList.add(bVarA);
                    }
                }
                cVar.e();
            }
        }
        return new com.airbnb.lottie.y.k.n(strM, arrayList, zI);
    }
}
