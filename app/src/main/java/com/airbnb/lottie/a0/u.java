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

/* compiled from: LottieCompositionParser.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    static c.a f3422a = c.a.a("w", bh.aJ, "ip", "op", SocializeProtocolConstants.PROTOCOL_KEY_FR, "v", "layers", "assets", "fonts", "chars", "markers");

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
            switch (cVar2.a(f3422a)) {
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
                default:
                    map = map4;
                    arrayList = arrayList3;
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
}
