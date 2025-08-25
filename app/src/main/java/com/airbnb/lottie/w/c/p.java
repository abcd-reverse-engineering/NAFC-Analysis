package com.airbnb.lottie.w.c;

import androidx.annotation.Nullable;
import java.util.Collections;

/* compiled from: ValueCallbackKeyframeAnimation.java */
/* loaded from: classes.dex */
public class p<K, A> extends a<K, A> {

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.c0.b<A> f3788i;

    /* renamed from: j, reason: collision with root package name */
    private final A f3789j;

    public p(com.airbnb.lottie.c0.j<A> jVar) {
        this(jVar, null);
    }

    @Override // com.airbnb.lottie.w.c.a
    public void a(float f2) {
        this.f3747d = f2;
    }

    @Override // com.airbnb.lottie.w.c.a
    float b() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.w.c.a
    public A f() {
        com.airbnb.lottie.c0.j<A> jVar = this.f3748e;
        A a2 = this.f3789j;
        return jVar.a(0.0f, 0.0f, a2, a2, e(), e(), e());
    }

    @Override // com.airbnb.lottie.w.c.a
    public void g() {
        if (this.f3748e != null) {
            super.g();
        }
    }

    public p(com.airbnb.lottie.c0.j<A> jVar, @Nullable A a2) {
        super(Collections.emptyList());
        this.f3788i = new com.airbnb.lottie.c0.b<>();
        a(jVar);
        this.f3789j = a2;
    }

    @Override // com.airbnb.lottie.w.c.a
    A a(com.airbnb.lottie.c0.a<K> aVar, float f2) {
        return f();
    }
}
