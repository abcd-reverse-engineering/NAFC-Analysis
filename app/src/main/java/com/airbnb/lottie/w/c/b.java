package com.airbnb.lottie.w.c;

import java.util.List;

/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<com.airbnb.lottie.c0.a<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.w.c.a
    /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.c0.a aVar, float f2) {
        return a((com.airbnb.lottie.c0.a<Integer>) aVar, f2);
    }

    public int b(com.airbnb.lottie.c0.a<Integer> aVar, float f2) {
        Integer num;
        Integer num2 = aVar.f3450b;
        if (num2 == null || aVar.f3451c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = num2.intValue();
        int iIntValue2 = aVar.f3451c.intValue();
        com.airbnb.lottie.c0.j<A> jVar = this.f3748e;
        return (jVar == 0 || (num = (Integer) jVar.a(aVar.f3455g, aVar.f3456h.floatValue(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), f2, d(), e())) == null) ? com.airbnb.lottie.b0.b.a(com.airbnb.lottie.b0.g.a(f2, 0.0f, 1.0f), iIntValue, iIntValue2) : num.intValue();
    }

    public int i() {
        return b(a(), c());
    }

    @Override // com.airbnb.lottie.w.c.a
    Integer a(com.airbnb.lottie.c0.a<Integer> aVar, float f2) {
        return Integer.valueOf(b(aVar, f2));
    }
}
