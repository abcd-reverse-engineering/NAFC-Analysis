package com.airbnb.lottie.y.k;

import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup.java */
/* loaded from: classes.dex */
public class n implements b {

    /* renamed from: a, reason: collision with root package name */
    private final String f3925a;

    /* renamed from: b, reason: collision with root package name */
    private final List<b> f3926b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f3927c;

    public n(String str, List<b> list, boolean z) {
        this.f3925a = str;
        this.f3926b = list;
        this.f3927c = z;
    }

    public List<b> a() {
        return this.f3926b;
    }

    public String b() {
        return this.f3925a;
    }

    public boolean c() {
        return this.f3927c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f3925a + "' Shapes: " + Arrays.toString(this.f3926b.toArray()) + '}';
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new com.airbnb.lottie.w.b.d(jVar, aVar, this);
    }
}
