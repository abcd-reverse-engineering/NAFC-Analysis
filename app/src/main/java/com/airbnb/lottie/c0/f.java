package com.airbnb.lottie.c0;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: LottieInterpolatedValue.java */
/* loaded from: classes.dex */
abstract class f<T> extends j<T> {

    /* renamed from: d, reason: collision with root package name */
    private final T f3470d;

    /* renamed from: e, reason: collision with root package name */
    private final T f3471e;

    /* renamed from: f, reason: collision with root package name */
    private final Interpolator f3472f;

    f(T t, T t2) {
        this(t, t2, new LinearInterpolator());
    }

    @Override // com.airbnb.lottie.c0.j
    public T a(b<T> bVar) {
        return a(this.f3470d, this.f3471e, this.f3472f.getInterpolation(bVar.e()));
    }

    abstract T a(T t, T t2, float f2);

    f(T t, T t2, Interpolator interpolator) {
        this.f3470d = t;
        this.f3471e = t2;
        this.f3472f = interpolator;
    }
}
