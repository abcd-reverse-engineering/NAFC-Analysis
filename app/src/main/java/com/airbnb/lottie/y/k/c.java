package com.airbnb.lottie.y.k;

/* compiled from: GradientColor.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f3860a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f3861b;

    public c(float[] fArr, int[] iArr) {
        this.f3860a = fArr;
        this.f3861b = iArr;
    }

    public int[] a() {
        return this.f3861b;
    }

    public float[] b() {
        return this.f3860a;
    }

    public int c() {
        return this.f3861b.length;
    }

    public void a(c cVar, c cVar2, float f2) {
        if (cVar.f3861b.length == cVar2.f3861b.length) {
            for (int i2 = 0; i2 < cVar.f3861b.length; i2++) {
                this.f3860a[i2] = com.airbnb.lottie.b0.g.c(cVar.f3860a[i2], cVar2.f3860a[i2], f2);
                this.f3861b[i2] = com.airbnb.lottie.b0.b.a(f2, cVar.f3861b[i2], cVar2.f3861b[i2]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f3861b.length + " vs " + cVar2.f3861b.length + ")");
    }
}
