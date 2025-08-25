package com.airbnb.lottie.c0;

import androidx.annotation.NonNull;

/* compiled from: LottieRelativeFloatValueCallback.java */
/* loaded from: classes.dex */
public class g extends j<Float> {
    public g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Float b(b<Float> bVar) {
        T t = this.f3476c;
        if (t != 0) {
            return (Float) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    public g(@NonNull Float f2) {
        super(f2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.c0.j
    public Float a(b<Float> bVar) {
        return Float.valueOf(com.airbnb.lottie.b0.g.c(bVar.g().floatValue(), bVar.b().floatValue(), bVar.c()) + b(bVar).floatValue());
    }
}
