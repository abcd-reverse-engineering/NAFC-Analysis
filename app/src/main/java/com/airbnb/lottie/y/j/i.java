package com.airbnb.lottie.y.j;

import android.graphics.PointF;
import java.util.List;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: classes.dex */
public class i implements m<PointF, PointF> {

    /* renamed from: a, reason: collision with root package name */
    private final b f3839a;

    /* renamed from: b, reason: collision with root package name */
    private final b f3840b;

    public i(b bVar, b bVar2) {
        this.f3839a = bVar;
        this.f3840b = bVar2;
    }

    @Override // com.airbnb.lottie.y.j.m
    public com.airbnb.lottie.w.c.a<PointF, PointF> a() {
        return new com.airbnb.lottie.w.c.m(this.f3839a.a(), this.f3840b.a());
    }

    @Override // com.airbnb.lottie.y.j.m
    public List<com.airbnb.lottie.c0.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.y.j.m
    public boolean c() {
        return this.f3839a.c() && this.f3840b.c();
    }
}
