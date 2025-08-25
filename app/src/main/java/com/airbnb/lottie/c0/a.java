package com.airbnb.lottie.c0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;

/* compiled from: Keyframe.java */
/* loaded from: classes.dex */
public class a<T> {
    private static final float q = -3987645.8f;
    private static final int r = 784923401;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final com.airbnb.lottie.g f3449a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final T f3450b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public T f3451c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final Interpolator f3452d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final Interpolator f3453e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final Interpolator f3454f;

    /* renamed from: g, reason: collision with root package name */
    public final float f3455g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Float f3456h;

    /* renamed from: i, reason: collision with root package name */
    private float f3457i;

    /* renamed from: j, reason: collision with root package name */
    private float f3458j;

    /* renamed from: k, reason: collision with root package name */
    private int f3459k;

    /* renamed from: l, reason: collision with root package name */
    private int f3460l;

    /* renamed from: m, reason: collision with root package name */
    private float f3461m;
    private float n;
    public PointF o;
    public PointF p;

    public a(com.airbnb.lottie.g gVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.f3457i = q;
        this.f3458j = q;
        this.f3459k = r;
        this.f3460l = r;
        this.f3461m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.f3449a = gVar;
        this.f3450b = t;
        this.f3451c = t2;
        this.f3452d = interpolator;
        this.f3453e = null;
        this.f3454f = null;
        this.f3455g = f2;
        this.f3456h = f3;
    }

    public float a() {
        if (this.f3449a == null) {
            return 1.0f;
        }
        if (this.n == Float.MIN_VALUE) {
            if (this.f3456h == null) {
                this.n = 1.0f;
            } else {
                this.n = d() + ((this.f3456h.floatValue() - this.f3455g) / this.f3449a.d());
            }
        }
        return this.n;
    }

    public float b() {
        if (this.f3458j == q) {
            this.f3458j = ((Float) this.f3451c).floatValue();
        }
        return this.f3458j;
    }

    public int c() {
        if (this.f3460l == r) {
            this.f3460l = ((Integer) this.f3451c).intValue();
        }
        return this.f3460l;
    }

    public float d() {
        com.airbnb.lottie.g gVar = this.f3449a;
        if (gVar == null) {
            return 0.0f;
        }
        if (this.f3461m == Float.MIN_VALUE) {
            this.f3461m = (this.f3455g - gVar.m()) / this.f3449a.d();
        }
        return this.f3461m;
    }

    public float e() {
        if (this.f3457i == q) {
            this.f3457i = ((Float) this.f3450b).floatValue();
        }
        return this.f3457i;
    }

    public int f() {
        if (this.f3459k == r) {
            this.f3459k = ((Integer) this.f3450b).intValue();
        }
        return this.f3459k;
    }

    public boolean g() {
        return this.f3452d == null && this.f3453e == null && this.f3454f == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f3450b + ", endValue=" + this.f3451c + ", startFrame=" + this.f3455g + ", endFrame=" + this.f3456h + ", interpolator=" + this.f3452d + '}';
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= d() && f2 < a();
    }

    public a(com.airbnb.lottie.g gVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, float f2, @Nullable Float f3) {
        this.f3457i = q;
        this.f3458j = q;
        this.f3459k = r;
        this.f3460l = r;
        this.f3461m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.f3449a = gVar;
        this.f3450b = t;
        this.f3451c = t2;
        this.f3452d = null;
        this.f3453e = interpolator;
        this.f3454f = interpolator2;
        this.f3455g = f2;
        this.f3456h = f3;
    }

    protected a(com.airbnb.lottie.g gVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, @Nullable Interpolator interpolator3, float f2, @Nullable Float f3) {
        this.f3457i = q;
        this.f3458j = q;
        this.f3459k = r;
        this.f3460l = r;
        this.f3461m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.f3449a = gVar;
        this.f3450b = t;
        this.f3451c = t2;
        this.f3452d = interpolator;
        this.f3453e = interpolator2;
        this.f3454f = interpolator3;
        this.f3455g = f2;
        this.f3456h = f3;
    }

    public a(T t) {
        this.f3457i = q;
        this.f3458j = q;
        this.f3459k = r;
        this.f3460l = r;
        this.f3461m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.f3449a = null;
        this.f3450b = t;
        this.f3451c = t;
        this.f3452d = null;
        this.f3453e = null;
        this.f3454f = null;
        this.f3455g = Float.MIN_VALUE;
        this.f3456h = Float.valueOf(Float.MAX_VALUE);
    }
}
