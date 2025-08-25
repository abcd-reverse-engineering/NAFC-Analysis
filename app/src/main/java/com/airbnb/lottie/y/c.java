package com.airbnb.lottie.y;

import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: Font.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f3816a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3817b;

    /* renamed from: c, reason: collision with root package name */
    private final String f3818c;

    /* renamed from: d, reason: collision with root package name */
    private final float f3819d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private Typeface f3820e;

    public c(String str, String str2, String str3, float f2) {
        this.f3816a = str;
        this.f3817b = str2;
        this.f3818c = str3;
        this.f3819d = f2;
    }

    float a() {
        return this.f3819d;
    }

    public String b() {
        return this.f3816a;
    }

    public String c() {
        return this.f3817b;
    }

    public String d() {
        return this.f3818c;
    }

    @Nullable
    public Typeface e() {
        return this.f3820e;
    }

    public void a(@Nullable Typeface typeface) {
        this.f3820e = typeface;
    }
}
