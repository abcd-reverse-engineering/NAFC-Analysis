package com.airbnb.lottie.c0;

/* compiled from: LottieRelativeIntegerValueCallback.java */
/* loaded from: classes.dex */
public class h extends j<Integer> {
    /* JADX WARN: Multi-variable type inference failed */
    public Integer b(b<Integer> bVar) {
        T t = this.f3476c;
        if (t != 0) {
            return (Integer) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.c0.j
    public Integer a(b<Integer> bVar) {
        return Integer.valueOf(com.airbnb.lottie.b0.g.a(bVar.g().intValue(), bVar.b().intValue(), bVar.c()) + b(bVar).intValue());
    }
}
