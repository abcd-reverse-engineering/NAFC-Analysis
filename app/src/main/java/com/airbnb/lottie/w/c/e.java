package com.airbnb.lottie.w.c;

import java.util.List;

/* compiled from: IntegerKeyframeAnimation.java */
/* loaded from: classes.dex */
public class e extends f<Integer> {
    public e(List<com.airbnb.lottie.c0.a<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.w.c.a
    /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.c0.a aVar, float f2) {
        return a((com.airbnb.lottie.c0.a<Integer>) aVar, f2);
    }

    int b(com.airbnb.lottie.c0.a<Integer> aVar, float f2) {
        Integer num;
        if (aVar.f3450b == null || aVar.f3451c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.c0.j<A> jVar = this.f3748e;
        return (jVar == 0 || (num = (Integer) jVar.a(aVar.f3455g, aVar.f3456h.floatValue(), aVar.f3450b, aVar.f3451c, f2, d(), e())) == null) ? com.airbnb.lottie.b0.g.a(aVar.f(), aVar.c(), f2) : num.intValue();
    }

    public int i() {
        return b(a(), c());
    }

    @Override // com.airbnb.lottie.w.c.a
    Integer a(com.airbnb.lottie.c0.a<Integer> aVar, float f2) {
        return Integer.valueOf(b(aVar, f2));
    }
}
