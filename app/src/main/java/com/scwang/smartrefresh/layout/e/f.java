package com.scwang.smartrefresh.layout.e;

import android.view.animation.Interpolator;

/* compiled from: ViscousFluidInterpolator.java */
/* loaded from: classes.dex */
public class f implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private static final float f8276a = 8.0f;

    /* renamed from: b, reason: collision with root package name */
    private static final float f8277b = 1.0f / a(1.0f);

    /* renamed from: c, reason: collision with root package name */
    private static final float f8278c = 1.0f - (f8277b * a(1.0f));

    private static float a(float f2) {
        float f3 = f2 * f8276a;
        return f3 < 1.0f ? f3 - (1.0f - ((float) Math.exp(-f3))) : ((1.0f - ((float) Math.exp(1.0f - f3))) * 0.63212055f) + 0.36787945f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        float fA = f8277b * a(f2);
        return fA > 0.0f ? fA + f8278c : fA;
    }
}
