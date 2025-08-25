package com.airbnb.lottie.w.c;

import android.graphics.PointF;
import java.util.List;

/* compiled from: PointKeyframeAnimation.java */
/* loaded from: classes.dex */
public class j extends f<PointF> {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f3766i;

    public j(List<com.airbnb.lottie.c0.a<PointF>> list) {
        super(list);
        this.f3766i = new PointF();
    }

    @Override // com.airbnb.lottie.w.c.a
    public /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.c0.a aVar, float f2) {
        return a((com.airbnb.lottie.c0.a<PointF>) aVar, f2);
    }

    @Override // com.airbnb.lottie.w.c.a
    protected /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.c0.a aVar, float f2, float f3, float f4) {
        return a((com.airbnb.lottie.c0.a<PointF>) aVar, f2, f3, f4);
    }

    @Override // com.airbnb.lottie.w.c.a
    public PointF a(com.airbnb.lottie.c0.a<PointF> aVar, float f2) {
        return a(aVar, f2, f2, f2);
    }

    @Override // com.airbnb.lottie.w.c.a
    protected PointF a(com.airbnb.lottie.c0.a<PointF> aVar, float f2, float f3, float f4) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f3450b;
        if (pointF3 != null && (pointF = aVar.f3451c) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            com.airbnb.lottie.c0.j<A> jVar = this.f3748e;
            if (jVar != 0 && (pointF2 = (PointF) jVar.a(aVar.f3455g, aVar.f3456h.floatValue(), pointF4, pointF5, f2, d(), e())) != null) {
                return pointF2;
            }
            PointF pointF6 = this.f3766i;
            float f5 = pointF4.x;
            float f6 = f5 + (f3 * (pointF5.x - f5));
            float f7 = pointF4.y;
            pointF6.set(f6, f7 + (f4 * (pointF5.y - f7)));
            return this.f3766i;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
