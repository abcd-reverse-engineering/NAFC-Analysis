package com.airbnb.lottie.a0;

import android.graphics.PointF;
import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeDataParser.java */
/* loaded from: classes.dex */
public class e0 implements k0<com.airbnb.lottie.y.k.l> {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f3336a = new e0();

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f3337b = c.a.a(bh.aI, "v", bh.aF, "o");

    private e0() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.a0.k0
    public com.airbnb.lottie.y.k.l a(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        if (cVar.peek() == c.b.BEGIN_ARRAY) {
            cVar.c();
        }
        cVar.d();
        List<PointF> listE = null;
        List<PointF> listE2 = null;
        List<PointF> listE3 = null;
        boolean zI = false;
        while (cVar.h()) {
            int iA = cVar.a(f3337b);
            if (iA == 0) {
                zI = cVar.i();
            } else if (iA == 1) {
                listE = p.e(cVar, f2);
            } else if (iA == 2) {
                listE2 = p.e(cVar, f2);
            } else if (iA != 3) {
                cVar.n();
                cVar.o();
            } else {
                listE3 = p.e(cVar, f2);
            }
        }
        cVar.f();
        if (cVar.peek() == c.b.END_ARRAY) {
            cVar.e();
        }
        if (listE == null || listE2 == null || listE3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listE.isEmpty()) {
            return new com.airbnb.lottie.y.k.l(new PointF(), false, Collections.emptyList());
        }
        int size = listE.size();
        PointF pointF = listE.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 1; i2 < size; i2++) {
            PointF pointF2 = listE.get(i2);
            int i3 = i2 - 1;
            arrayList.add(new com.airbnb.lottie.y.a(com.airbnb.lottie.b0.g.a(listE.get(i3), listE3.get(i3)), com.airbnb.lottie.b0.g.a(pointF2, listE2.get(i2)), pointF2));
        }
        if (zI) {
            PointF pointF3 = listE.get(0);
            int i4 = size - 1;
            arrayList.add(new com.airbnb.lottie.y.a(com.airbnb.lottie.b0.g.a(listE.get(i4), listE3.get(i4)), com.airbnb.lottie.b0.g.a(pointF3, listE2.get(0)), pointF3));
        }
        return new com.airbnb.lottie.y.k.l(pointF, zI, arrayList);
    }
}
