package com.scwang.smartrefresh.layout.e;

import android.content.res.Resources;

/* compiled from: DensityUtil.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public float f8274a = Resources.getSystem().getDisplayMetrics().density;

    public static int b(float f2) {
        return (int) ((f2 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public int a(float f2) {
        return (int) ((f2 * this.f8274a) + 0.5f);
    }

    public static float b(int i2) {
        return i2 / Resources.getSystem().getDisplayMetrics().density;
    }

    public float a(int i2) {
        return i2 / this.f8274a;
    }
}
