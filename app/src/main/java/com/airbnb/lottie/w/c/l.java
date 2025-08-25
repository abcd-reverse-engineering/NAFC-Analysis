package com.airbnb.lottie.w.c;

import android.graphics.Path;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation.java */
/* loaded from: classes.dex */
public class l extends a<com.airbnb.lottie.y.k.l, Path> {

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.y.k.l f3768i;

    /* renamed from: j, reason: collision with root package name */
    private final Path f3769j;

    public l(List<com.airbnb.lottie.c0.a<com.airbnb.lottie.y.k.l>> list) {
        super(list);
        this.f3768i = new com.airbnb.lottie.y.k.l();
        this.f3769j = new Path();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.w.c.a
    public Path a(com.airbnb.lottie.c0.a<com.airbnb.lottie.y.k.l> aVar, float f2) {
        this.f3768i.a(aVar.f3450b, aVar.f3451c, f2);
        com.airbnb.lottie.b0.g.a(this.f3768i, this.f3769j);
        return this.f3769j;
    }
}
