package com.airbnb.lottie.w.c;

import java.util.List;

/* compiled from: ScaleKeyframeAnimation.java */
/* loaded from: classes.dex */
public class k extends f<com.airbnb.lottie.c0.k> {

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.c0.k f3767i;

    public k(List<com.airbnb.lottie.c0.a<com.airbnb.lottie.c0.k>> list) {
        super(list);
        this.f3767i = new com.airbnb.lottie.c0.k();
    }

    @Override // com.airbnb.lottie.w.c.a
    public /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.c0.a aVar, float f2) {
        return a((com.airbnb.lottie.c0.a<com.airbnb.lottie.c0.k>) aVar, f2);
    }

    @Override // com.airbnb.lottie.w.c.a
    public com.airbnb.lottie.c0.k a(com.airbnb.lottie.c0.a<com.airbnb.lottie.c0.k> aVar, float f2) {
        com.airbnb.lottie.c0.k kVar;
        com.airbnb.lottie.c0.k kVar2;
        com.airbnb.lottie.c0.k kVar3 = aVar.f3450b;
        if (kVar3 == null || (kVar = aVar.f3451c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.c0.k kVar4 = kVar3;
        com.airbnb.lottie.c0.k kVar5 = kVar;
        com.airbnb.lottie.c0.j<A> jVar = this.f3748e;
        if (jVar != 0 && (kVar2 = (com.airbnb.lottie.c0.k) jVar.a(aVar.f3455g, aVar.f3456h.floatValue(), kVar4, kVar5, f2, d(), e())) != null) {
            return kVar2;
        }
        this.f3767i.b(com.airbnb.lottie.b0.g.c(kVar4.a(), kVar5.a(), f2), com.airbnb.lottie.b0.g.c(kVar4.b(), kVar5.b(), f2));
        return this.f3767i;
    }
}
