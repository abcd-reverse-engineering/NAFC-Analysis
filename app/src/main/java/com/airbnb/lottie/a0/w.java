package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.k.h;
import java.io.IOException;

/* compiled from: MergePathsParser.java */
/* loaded from: classes.dex */
class w {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3423a = c.a.a("nm", "mm", "hd");

    private w() {
    }

    static com.airbnb.lottie.y.k.h a(com.airbnb.lottie.a0.l0.c cVar) throws IOException {
        String strM = null;
        h.a aVarForId = null;
        boolean zI = false;
        while (cVar.h()) {
            int iA = cVar.a(f3423a);
            if (iA == 0) {
                strM = cVar.m();
            } else if (iA == 1) {
                aVarForId = h.a.forId(cVar.k());
            } else if (iA != 2) {
                cVar.n();
                cVar.o();
            } else {
                zI = cVar.i();
            }
        }
        return new com.airbnb.lottie.y.k.h(strM, aVarForId, zI);
    }
}
