package com.airbnb.lottie.w.c;

import java.util.List;

/* compiled from: GradientColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class d extends f<com.airbnb.lottie.y.k.c> {

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.y.k.c f3758i;

    public d(List<com.airbnb.lottie.c0.a<com.airbnb.lottie.y.k.c>> list) {
        super(list);
        com.airbnb.lottie.y.k.c cVar = list.get(0).f3450b;
        int iC = cVar != null ? cVar.c() : 0;
        this.f3758i = new com.airbnb.lottie.y.k.c(new float[iC], new int[iC]);
    }

    @Override // com.airbnb.lottie.w.c.a
    /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.c0.a aVar, float f2) {
        return a((com.airbnb.lottie.c0.a<com.airbnb.lottie.y.k.c>) aVar, f2);
    }

    @Override // com.airbnb.lottie.w.c.a
    com.airbnb.lottie.y.k.c a(com.airbnb.lottie.c0.a<com.airbnb.lottie.y.k.c> aVar, float f2) {
        this.f3758i.a(aVar.f3450b, aVar.f3451c, f2);
        return this.f3758i;
    }
}
