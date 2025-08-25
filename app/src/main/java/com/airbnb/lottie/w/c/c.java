package com.airbnb.lottie.w.c;

import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<com.airbnb.lottie.c0.a<Float>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.w.c.a
    /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.c0.a aVar, float f2) {
        return a((com.airbnb.lottie.c0.a<Float>) aVar, f2);
    }

    float b(com.airbnb.lottie.c0.a<Float> aVar, float f2) {
        Float f3;
        if (aVar.f3450b == null || aVar.f3451c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.c0.j<A> jVar = this.f3748e;
        return (jVar == 0 || (f3 = (Float) jVar.a(aVar.f3455g, aVar.f3456h.floatValue(), aVar.f3450b, aVar.f3451c, f2, d(), e())) == null) ? com.airbnb.lottie.b0.g.c(aVar.e(), aVar.b(), f2) : f3.floatValue();
    }

    public float i() {
        return b(a(), c());
    }

    @Override // com.airbnb.lottie.w.c.a
    Float a(com.airbnb.lottie.c0.a<Float> aVar, float f2) {
        return Float.valueOf(b(aVar, f2));
    }
}
