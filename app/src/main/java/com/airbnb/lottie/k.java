package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: LottieImageAsset.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final int f3592a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3593b;

    /* renamed from: c, reason: collision with root package name */
    private final String f3594c;

    /* renamed from: d, reason: collision with root package name */
    private final String f3595d;

    /* renamed from: e, reason: collision with root package name */
    private final String f3596e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private Bitmap f3597f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public k(int i2, int i3, String str, String str2, String str3) {
        this.f3592a = i2;
        this.f3593b = i3;
        this.f3594c = str;
        this.f3595d = str2;
        this.f3596e = str3;
    }

    @Nullable
    public Bitmap a() {
        return this.f3597f;
    }

    public String b() {
        return this.f3596e;
    }

    public String c() {
        return this.f3595d;
    }

    public int d() {
        return this.f3593b;
    }

    public String e() {
        return this.f3594c;
    }

    public int f() {
        return this.f3592a;
    }

    public boolean g() {
        return this.f3597f != null || (this.f3595d.startsWith("data:") && this.f3595d.indexOf("base64,") > 0);
    }

    public void a(@Nullable Bitmap bitmap) {
        this.f3597f = bitmap;
    }
}
