package com.airbnb.lottie.c0;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* compiled from: LottieInterpolatedPointValue.java */
/* loaded from: classes.dex */
public class e extends f<PointF> {

    /* renamed from: g, reason: collision with root package name */
    private final PointF f3469g;

    public e(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
        this.f3469g = new PointF();
    }

    @Override // com.airbnb.lottie.c0.f, com.airbnb.lottie.c0.j
    public /* bridge */ /* synthetic */ Object a(b bVar) {
        return super.a(bVar);
    }

    public e(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
        this.f3469g = new PointF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.c0.f
    public PointF a(PointF pointF, PointF pointF2, float f2) {
        this.f3469g.set(com.airbnb.lottie.b0.g.c(pointF.x, pointF2.x, f2), com.airbnb.lottie.b0.g.c(pointF.y, pointF2.y, f2));
        return this.f3469g;
    }
}
