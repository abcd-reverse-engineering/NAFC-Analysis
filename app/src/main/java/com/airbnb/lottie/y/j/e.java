package com.airbnb.lottie.y.j;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;

/* compiled from: AnimatablePathValue.java */
/* loaded from: classes.dex */
public class e implements m<PointF, PointF> {

    /* renamed from: a, reason: collision with root package name */
    private final List<com.airbnb.lottie.c0.a<PointF>> f3838a;

    public e() {
        this.f3838a = Collections.singletonList(new com.airbnb.lottie.c0.a(new PointF(0.0f, 0.0f)));
    }

    @Override // com.airbnb.lottie.y.j.m
    public com.airbnb.lottie.w.c.a<PointF, PointF> a() {
        return this.f3838a.get(0).g() ? new com.airbnb.lottie.w.c.j(this.f3838a) : new com.airbnb.lottie.w.c.i(this.f3838a);
    }

    @Override // com.airbnb.lottie.y.j.m
    public List<com.airbnb.lottie.c0.a<PointF>> b() {
        return this.f3838a;
    }

    @Override // com.airbnb.lottie.y.j.m
    public boolean c() {
        return this.f3838a.size() == 1 && this.f3838a.get(0).g();
    }

    public e(List<com.airbnb.lottie.c0.a<PointF>> list) {
        this.f3838a = list;
    }
}
