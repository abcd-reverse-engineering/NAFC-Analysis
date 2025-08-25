package com.airbnb.lottie.w.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class i extends f<PointF> {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f3762i;

    /* renamed from: j, reason: collision with root package name */
    private final float[] f3763j;

    /* renamed from: k, reason: collision with root package name */
    private final PathMeasure f3764k;

    /* renamed from: l, reason: collision with root package name */
    private h f3765l;

    public i(List<? extends com.airbnb.lottie.c0.a<PointF>> list) {
        super(list);
        this.f3762i = new PointF();
        this.f3763j = new float[2];
        this.f3764k = new PathMeasure();
    }

    @Override // com.airbnb.lottie.w.c.a
    public /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.c0.a aVar, float f2) {
        return a((com.airbnb.lottie.c0.a<PointF>) aVar, f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.w.c.a
    public PointF a(com.airbnb.lottie.c0.a<PointF> aVar, float f2) {
        PointF pointF;
        h hVar = (h) aVar;
        Path pathI = hVar.i();
        if (pathI == null) {
            return aVar.f3450b;
        }
        com.airbnb.lottie.c0.j<A> jVar = this.f3748e;
        if (jVar != 0 && (pointF = (PointF) jVar.a(hVar.f3455g, hVar.f3456h.floatValue(), hVar.f3450b, hVar.f3451c, d(), f2, e())) != null) {
            return pointF;
        }
        if (this.f3765l != hVar) {
            this.f3764k.setPath(pathI, false);
            this.f3765l = hVar;
        }
        PathMeasure pathMeasure = this.f3764k;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f3763j, null);
        PointF pointF2 = this.f3762i;
        float[] fArr = this.f3763j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f3762i;
    }
}
