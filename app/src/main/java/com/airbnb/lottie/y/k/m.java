package com.airbnb.lottie.y.k;

import android.graphics.Path;
import androidx.annotation.Nullable;

/* compiled from: ShapeFill.java */
/* loaded from: classes.dex */
public class m implements b {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3919a;

    /* renamed from: b, reason: collision with root package name */
    private final Path.FillType f3920b;

    /* renamed from: c, reason: collision with root package name */
    private final String f3921c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final com.airbnb.lottie.y.j.a f3922d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final com.airbnb.lottie.y.j.d f3923e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f3924f;

    public m(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.y.j.a aVar, @Nullable com.airbnb.lottie.y.j.d dVar, boolean z2) {
        this.f3921c = str;
        this.f3919a = z;
        this.f3920b = fillType;
        this.f3922d = aVar;
        this.f3923e = dVar;
        this.f3924f = z2;
    }

    @Nullable
    public com.airbnb.lottie.y.j.a a() {
        return this.f3922d;
    }

    public Path.FillType b() {
        return this.f3920b;
    }

    public String c() {
        return this.f3921c;
    }

    @Nullable
    public com.airbnb.lottie.y.j.d d() {
        return this.f3923e;
    }

    public boolean e() {
        return this.f3924f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f3919a + '}';
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new com.airbnb.lottie.w.b.g(jVar, aVar, this);
    }
}
