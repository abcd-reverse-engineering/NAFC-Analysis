package com.airbnb.lottie.y;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;

/* compiled from: CubicCurveData.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final PointF f3801a;

    /* renamed from: b, reason: collision with root package name */
    private final PointF f3802b;

    /* renamed from: c, reason: collision with root package name */
    private final PointF f3803c;

    public a() {
        this.f3801a = new PointF();
        this.f3802b = new PointF();
        this.f3803c = new PointF();
    }

    public void a(float f2, float f3) {
        this.f3801a.set(f2, f3);
    }

    public void b(float f2, float f3) {
        this.f3802b.set(f2, f3);
    }

    public void c(float f2, float f3) {
        this.f3803c.set(f2, f3);
    }

    public PointF a() {
        return this.f3801a;
    }

    public PointF b() {
        return this.f3802b;
    }

    public PointF c() {
        return this.f3803c;
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f3801a = pointF;
        this.f3802b = pointF2;
        this.f3803c = pointF3;
    }
}
