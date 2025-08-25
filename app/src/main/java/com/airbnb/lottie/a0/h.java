package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.b;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* compiled from: DocumentDataParser.java */
/* loaded from: classes.dex */
public class h implements k0<com.airbnb.lottie.y.b> {

    /* renamed from: a, reason: collision with root package name */
    public static final h f3342a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f3343b = c.a.a("t", "f", bh.aE, "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private h() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.a0.k0
    public com.airbnb.lottie.y.b a(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        b.a aVar = b.a.CENTER;
        cVar.d();
        b.a aVar2 = aVar;
        String strM = null;
        String strM2 = null;
        float fJ = 0.0f;
        int iK = 0;
        float fJ2 = 0.0f;
        float fJ3 = 0.0f;
        int iA = 0;
        int iA2 = 0;
        float fJ4 = 0.0f;
        boolean zI = true;
        while (cVar.h()) {
            switch (cVar.a(f3343b)) {
                case 0:
                    strM = cVar.m();
                    break;
                case 1:
                    strM2 = cVar.m();
                    break;
                case 2:
                    fJ = (float) cVar.j();
                    break;
                case 3:
                    int iK2 = cVar.k();
                    if (iK2 <= b.a.CENTER.ordinal() && iK2 >= 0) {
                        aVar2 = b.a.values()[iK2];
                        break;
                    } else {
                        aVar2 = b.a.CENTER;
                        break;
                    }
                    break;
                case 4:
                    iK = cVar.k();
                    break;
                case 5:
                    fJ2 = (float) cVar.j();
                    break;
                case 6:
                    fJ3 = (float) cVar.j();
                    break;
                case 7:
                    iA = p.a(cVar);
                    break;
                case 8:
                    iA2 = p.a(cVar);
                    break;
                case 9:
                    fJ4 = (float) cVar.j();
                    break;
                case 10:
                    zI = cVar.i();
                    break;
                default:
                    cVar.n();
                    cVar.o();
                    break;
            }
        }
        cVar.f();
        return new com.airbnb.lottie.y.b(strM, strM2, fJ, aVar2, iK, fJ2, fJ3, iA, iA2, fJ4, zI);
    }
}
