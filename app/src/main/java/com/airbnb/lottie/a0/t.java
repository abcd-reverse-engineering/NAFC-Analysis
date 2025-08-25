package com.airbnb.lottie.a0;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.l.d;
import com.umeng.analytics.pro.bh;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LottieCompositionMoshiParser.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3418a = c.a.a("w", bh.aJ, "ip", "op", SocializeProtocolConstants.PROTOCOL_KEY_FR, "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b, reason: collision with root package name */
    static c.a f3419b = c.a.a("id", "layers", "w", bh.aJ, bh.aA, bh.aK);

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f3420c = c.a.a("list");

    /* renamed from: d, reason: collision with root package name */
    private static final c.a f3421d = c.a.a(SocializeProtocolConstants.PROTOCOL_KEY_COMMENT_COUNT, "tm", "dr");

    public static com.airbnb.lottie.g a(com.airbnb.lottie.a0.l0.c cVar) throws IOException {
        HashMap map;
        ArrayList arrayList;
        com.airbnb.lottie.a0.l0.c cVar2 = cVar;
        float fA = com.airbnb.lottie.b0.h.a();
        LongSparseArray<com.airbnb.lottie.y.l.d> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<com.airbnb.lottie.y.d> sparseArrayCompat = new SparseArrayCompat<>();
        com.airbnb.lottie.g gVar = new com.airbnb.lottie.g();
        cVar.d();
        int iK = 0;
        int iK2 = 0;
        float fJ = 0.0f;
        float fJ2 = 0.0f;
        float fJ3 = 0.0f;
        while (cVar.h()) {
            switch (cVar2.a(f3418a)) {
                case 0:
                    iK = cVar.k();
                    break;
                case 1:
                    iK2 = cVar.k();
                    break;
                case 2:
                    map = map4;
                    arrayList = arrayList3;
                    fJ = (float) cVar.j();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 3:
                    map = map4;
                    arrayList = arrayList3;
                    fJ2 = ((float) cVar.j()) - 0.01f;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 4:
                    map = map4;
                    arrayList = arrayList3;
                    fJ3 = (float) cVar.j();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 5:
                    String[] strArrSplit = cVar.m().split("\\.");
                    if (!com.airbnb.lottie.b0.h.a(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        gVar.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 6:
                    a(cVar2, gVar, arrayList2, longSparseArray);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 7:
                    a(cVar2, gVar, map2, map3);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 8:
                    a(cVar2, map4);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 9:
                    a(cVar2, gVar, sparseArrayCompat);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 10:
                    a(cVar2, gVar, arrayList3);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                default:
                    map = map4;
                    arrayList = arrayList3;
                    cVar.n();
                    cVar.o();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
            }
            cVar2 = cVar;
        }
        gVar.a(new Rect(0, 0, (int) (iK * fA), (int) (iK2 * fA)), fJ, fJ2, fJ3, arrayList2, longSparseArray, map2, map3, sparseArrayCompat, map4, arrayList3);
        return gVar;
    }

    private static void a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar, List<com.airbnb.lottie.y.l.d> list, LongSparseArray<com.airbnb.lottie.y.l.d> longSparseArray) throws IOException {
        cVar.c();
        int i2 = 0;
        while (cVar.h()) {
            com.airbnb.lottie.y.l.d dVarA = s.a(cVar, gVar);
            if (dVarA.d() == d.a.IMAGE) {
                i2++;
            }
            list.add(dVarA);
            longSparseArray.put(dVarA.b(), dVarA);
            if (i2 > 4) {
                com.airbnb.lottie.b0.d.b("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.e();
    }

    private static void a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar, Map<String, List<com.airbnb.lottie.y.l.d>> map, Map<String, com.airbnb.lottie.k> map2) throws IOException {
        cVar.c();
        while (cVar.h()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            cVar.d();
            String strM = null;
            String strM2 = null;
            String strM3 = null;
            int iK = 0;
            int iK2 = 0;
            while (cVar.h()) {
                int iA = cVar.a(f3419b);
                if (iA == 0) {
                    strM = cVar.m();
                } else if (iA == 1) {
                    cVar.c();
                    while (cVar.h()) {
                        com.airbnb.lottie.y.l.d dVarA = s.a(cVar, gVar);
                        longSparseArray.put(dVarA.b(), dVarA);
                        arrayList.add(dVarA);
                    }
                    cVar.e();
                } else if (iA == 2) {
                    iK = cVar.k();
                } else if (iA == 3) {
                    iK2 = cVar.k();
                } else if (iA == 4) {
                    strM2 = cVar.m();
                } else if (iA != 5) {
                    cVar.n();
                    cVar.o();
                } else {
                    strM3 = cVar.m();
                }
            }
            cVar.f();
            if (strM2 != null) {
                com.airbnb.lottie.k kVar = new com.airbnb.lottie.k(iK, iK2, strM, strM2, strM3);
                map2.put(kVar.e(), kVar);
            } else {
                map.put(strM, arrayList);
            }
        }
        cVar.e();
    }

    private static void a(com.airbnb.lottie.a0.l0.c cVar, Map<String, com.airbnb.lottie.y.c> map) throws IOException {
        cVar.d();
        while (cVar.h()) {
            if (cVar.a(f3420c) != 0) {
                cVar.n();
                cVar.o();
            } else {
                cVar.c();
                while (cVar.h()) {
                    com.airbnb.lottie.y.c cVarA = k.a(cVar);
                    map.put(cVarA.c(), cVarA);
                }
                cVar.e();
            }
        }
        cVar.f();
    }

    private static void a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar, SparseArrayCompat<com.airbnb.lottie.y.d> sparseArrayCompat) throws IOException {
        cVar.c();
        while (cVar.h()) {
            com.airbnb.lottie.y.d dVarA = j.a(cVar, gVar);
            sparseArrayCompat.put(dVarA.hashCode(), dVarA);
        }
        cVar.e();
    }

    private static void a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar, List<com.airbnb.lottie.y.h> list) throws IOException {
        cVar.c();
        while (cVar.h()) {
            String strM = null;
            cVar.d();
            float fJ = 0.0f;
            float fJ2 = 0.0f;
            while (cVar.h()) {
                int iA = cVar.a(f3421d);
                if (iA == 0) {
                    strM = cVar.m();
                } else if (iA == 1) {
                    fJ = (float) cVar.j();
                } else if (iA != 2) {
                    cVar.n();
                    cVar.o();
                } else {
                    fJ2 = (float) cVar.j();
                }
            }
            cVar.f();
            list.add(new com.airbnb.lottie.y.h(strM, fJ, fJ2));
        }
        cVar.e();
    }
}
