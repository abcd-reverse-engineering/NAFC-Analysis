package com.airbnb.lottie.a0;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.l.d;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: LayerParser.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3414a = c.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", bh.aJ, "ip", "op", "tm", "cl", "hd");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f3415b = c.a.a("d", bh.ay);

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f3416c = c.a.a("nm");

    /* compiled from: LayerParser.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3417a = new int[d.b.values().length];

        static {
            try {
                f3417a[d.b.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3417a[d.b.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private s() {
    }

    public static com.airbnb.lottie.y.l.d a(com.airbnb.lottie.g gVar) {
        Rect rectA = gVar.a();
        return new com.airbnb.lottie.y.l.d(Collections.emptyList(), gVar, "__container", -1L, d.a.PRE_COMP, -1L, null, Collections.emptyList(), new com.airbnb.lottie.y.j.l(), 0, 0, 0, 0.0f, 0.0f, rectA.width(), rectA.height(), null, null, Collections.emptyList(), d.b.NONE, null, false);
    }

    public static com.airbnb.lottie.y.l.d a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        ArrayList arrayList;
        String str;
        ArrayList arrayList2;
        d.b bVar = d.b.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        cVar.d();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        d.b bVar2 = bVar;
        String strM = null;
        d.a aVar = null;
        String strM2 = null;
        com.airbnb.lottie.y.j.l lVarA = null;
        com.airbnb.lottie.y.j.j jVarB = null;
        com.airbnb.lottie.y.j.k kVarA = null;
        com.airbnb.lottie.y.j.b bVarA = null;
        long jK = -1;
        int iK = 0;
        int iK2 = 0;
        int color = 0;
        int iK3 = 0;
        int iK4 = 0;
        float fJ = 1.0f;
        float fJ2 = 0.0f;
        boolean zI = false;
        String strM3 = "UNSET";
        long jK2 = 0;
        float fJ3 = 0.0f;
        float fE = 0.0f;
        while (cVar.h()) {
            switch (cVar.a(f3414a)) {
                case 0:
                    strM3 = cVar.m();
                    break;
                case 1:
                    jK2 = cVar.k();
                    break;
                case 2:
                    strM2 = cVar.m();
                    break;
                case 3:
                    int iK5 = cVar.k();
                    if (iK5 < d.a.UNKNOWN.ordinal()) {
                        aVar = d.a.values()[iK5];
                        break;
                    } else {
                        aVar = d.a.UNKNOWN;
                        break;
                    }
                case 4:
                    jK = cVar.k();
                    break;
                case 5:
                    iK = (int) (cVar.k() * com.airbnb.lottie.b0.h.a());
                    break;
                case 6:
                    iK2 = (int) (cVar.k() * com.airbnb.lottie.b0.h.a());
                    break;
                case 7:
                    color = Color.parseColor(cVar.m());
                    break;
                case 8:
                    lVarA = c.a(cVar, gVar);
                    break;
                case 9:
                    int iK6 = cVar.k();
                    if (iK6 >= d.b.values().length) {
                        gVar.a("Unsupported matte type: " + iK6);
                        break;
                    } else {
                        bVar2 = d.b.values()[iK6];
                        int i2 = a.f3417a[bVar2.ordinal()];
                        if (i2 == 1) {
                            gVar.a("Unsupported matte type: Luma");
                        } else if (i2 == 2) {
                            gVar.a("Unsupported matte type: Luma Inverted");
                        }
                        gVar.a(1);
                        break;
                    }
                case 10:
                    cVar.c();
                    while (cVar.h()) {
                        arrayList3.add(v.a(cVar, gVar));
                    }
                    gVar.a(arrayList3.size());
                    cVar.e();
                    break;
                case 11:
                    cVar.c();
                    while (cVar.h()) {
                        com.airbnb.lottie.y.k.b bVarA2 = g.a(cVar, gVar);
                        if (bVarA2 != null) {
                            arrayList4.add(bVarA2);
                        }
                    }
                    cVar.e();
                    break;
                case 12:
                    cVar.d();
                    while (cVar.h()) {
                        int iA = cVar.a(f3415b);
                        if (iA == 0) {
                            jVarB = d.b(cVar, gVar);
                        } else if (iA != 1) {
                            cVar.n();
                            cVar.o();
                        } else {
                            cVar.c();
                            if (cVar.h()) {
                                kVarA = b.a(cVar, gVar);
                            }
                            while (cVar.h()) {
                                cVar.o();
                            }
                            cVar.e();
                        }
                    }
                    cVar.f();
                    break;
                case 13:
                    cVar.c();
                    ArrayList arrayList5 = new ArrayList();
                    while (cVar.h()) {
                        cVar.d();
                        while (cVar.h()) {
                            if (cVar.a(f3416c) != 0) {
                                cVar.n();
                                cVar.o();
                            } else {
                                arrayList5.add(cVar.m());
                            }
                        }
                        cVar.f();
                    }
                    cVar.e();
                    gVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    fJ = (float) cVar.j();
                    break;
                case 15:
                    fJ2 = (float) cVar.j();
                    break;
                case 16:
                    iK3 = (int) (cVar.k() * com.airbnb.lottie.b0.h.a());
                    break;
                case 17:
                    iK4 = (int) (cVar.k() * com.airbnb.lottie.b0.h.a());
                    break;
                case 18:
                    fJ3 = (float) cVar.j();
                    break;
                case 19:
                    fE = (float) cVar.j();
                    break;
                case 20:
                    bVarA = d.a(cVar, gVar, false);
                    break;
                case 21:
                    strM = cVar.m();
                    break;
                case 22:
                    zI = cVar.i();
                    break;
                default:
                    cVar.n();
                    cVar.o();
                    break;
            }
        }
        cVar.f();
        ArrayList arrayList6 = new ArrayList();
        if (fJ3 > 0.0f) {
            arrayList = arrayList3;
            str = strM;
            arrayList2 = arrayList6;
            arrayList2.add(new com.airbnb.lottie.c0.a(gVar, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(fJ3)));
        } else {
            arrayList = arrayList3;
            str = strM;
            arrayList2 = arrayList6;
        }
        if (fE <= 0.0f) {
            fE = gVar.e();
        }
        float f2 = fJ3;
        ArrayList arrayList7 = arrayList2;
        arrayList7.add(new com.airbnb.lottie.c0.a(gVar, fValueOf, fValueOf, null, f2, Float.valueOf(fE)));
        arrayList7.add(new com.airbnb.lottie.c0.a(gVar, fValueOf2, fValueOf2, null, fE, Float.valueOf(Float.MAX_VALUE)));
        if (strM3.endsWith(".ai") || "ai".equals(str)) {
            gVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new com.airbnb.lottie.y.l.d(arrayList4, gVar, strM3, jK2, aVar, jK, strM2, arrayList, lVarA, iK, iK2, color, fJ, fJ2, iK3, iK4, jVarB, kVarA, arrayList7, bVar2, bVarA, zI);
    }
}
