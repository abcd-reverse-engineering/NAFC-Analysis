package com.airbnb.lottie.y.j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue.java */
/* loaded from: classes.dex */
abstract class n<V, O> implements m<V, O> {

    /* renamed from: a, reason: collision with root package name */
    final List<com.airbnb.lottie.c0.a<V>> f3854a;

    n(V v) {
        this(Collections.singletonList(new com.airbnb.lottie.c0.a(v)));
    }

    @Override // com.airbnb.lottie.y.j.m
    public List<com.airbnb.lottie.c0.a<V>> b() {
        return this.f3854a;
    }

    @Override // com.airbnb.lottie.y.j.m
    public boolean c() {
        return this.f3854a.isEmpty() || (this.f3854a.size() == 1 && this.f3854a.get(0).g());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f3854a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f3854a.toArray()));
        }
        return sb.toString();
    }

    n(List<com.airbnb.lottie.c0.a<V>> list) {
        this.f3854a = list;
    }
}
