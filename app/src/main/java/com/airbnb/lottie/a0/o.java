package com.airbnb.lottie.a0;

import java.io.IOException;

/* compiled from: IntegerParser.java */
/* loaded from: classes.dex */
public class o implements k0<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final o f3405a = new o();

    private o() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.a0.k0
    public Integer a(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        return Integer.valueOf(Math.round(p.b(cVar) * f2));
    }
}
