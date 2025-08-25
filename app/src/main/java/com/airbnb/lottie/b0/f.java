package com.airbnb.lottie.b0;

/* compiled from: MeanCalculator.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private float f3439a;

    /* renamed from: b, reason: collision with root package name */
    private int f3440b;

    public void a(float f2) {
        this.f3439a += f2;
        this.f3440b++;
        int i2 = this.f3440b;
        if (i2 == Integer.MAX_VALUE) {
            this.f3439a /= 2.0f;
            this.f3440b = i2 / 2;
        }
    }

    public float a() {
        int i2 = this.f3440b;
        if (i2 == 0) {
            return 0.0f;
        }
        return this.f3439a / i2;
    }
}
