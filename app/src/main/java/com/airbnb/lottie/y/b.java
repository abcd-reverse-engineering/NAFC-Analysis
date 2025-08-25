package com.airbnb.lottie.y;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

/* compiled from: DocumentData.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f3804a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3805b;

    /* renamed from: c, reason: collision with root package name */
    public final float f3806c;

    /* renamed from: d, reason: collision with root package name */
    public final a f3807d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3808e;

    /* renamed from: f, reason: collision with root package name */
    public final float f3809f;

    /* renamed from: g, reason: collision with root package name */
    public final float f3810g;

    /* renamed from: h, reason: collision with root package name */
    @ColorInt
    public final int f3811h;

    /* renamed from: i, reason: collision with root package name */
    @ColorInt
    public final int f3812i;

    /* renamed from: j, reason: collision with root package name */
    public final float f3813j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3814k;

    /* compiled from: DocumentData.java */
    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b(String str, String str2, float f2, a aVar, int i2, float f3, float f4, @ColorInt int i3, @ColorInt int i4, float f5, boolean z) {
        this.f3804a = str;
        this.f3805b = str2;
        this.f3806c = f2;
        this.f3807d = aVar;
        this.f3808e = i2;
        this.f3809f = f3;
        this.f3810g = f4;
        this.f3811h = i3;
        this.f3812i = i4;
        this.f3813j = f5;
        this.f3814k = z;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.f3804a.hashCode() * 31) + this.f3805b.hashCode()) * 31) + this.f3806c)) * 31) + this.f3807d.ordinal()) * 31) + this.f3808e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f3809f);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f3811h;
    }
}
