package com.airbnb.lottie.c0;

/* compiled from: ScaleXY.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private float f3477a;

    /* renamed from: b, reason: collision with root package name */
    private float f3478b;

    public k(float f2, float f3) {
        this.f3477a = f2;
        this.f3478b = f3;
    }

    public float a() {
        return this.f3477a;
    }

    public float b() {
        return this.f3478b;
    }

    public String toString() {
        return a() + "x" + b();
    }

    public boolean a(float f2, float f3) {
        return this.f3477a == f2 && this.f3478b == f3;
    }

    public void b(float f2, float f3) {
        this.f3477a = f2;
        this.f3478b = f3;
    }

    public k() {
        this(1.0f, 1.0f);
    }
}
