package com.bumptech.glide.load.p;

import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Jobs.java */
/* loaded from: classes.dex */
final class s {

    /* renamed from: a, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.g, l<?>> f4644a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.g, l<?>> f4645b = new HashMap();

    s() {
    }

    @VisibleForTesting
    Map<com.bumptech.glide.load.g, l<?>> a() {
        return Collections.unmodifiableMap(this.f4644a);
    }

    void b(com.bumptech.glide.load.g gVar, l<?> lVar) {
        Map<com.bumptech.glide.load.g, l<?>> mapA = a(lVar.g());
        if (lVar.equals(mapA.get(gVar))) {
            mapA.remove(gVar);
        }
    }

    l<?> a(com.bumptech.glide.load.g gVar, boolean z) {
        return a(z).get(gVar);
    }

    void a(com.bumptech.glide.load.g gVar, l<?> lVar) {
        a(lVar.g()).put(gVar, lVar);
    }

    private Map<com.bumptech.glide.load.g, l<?>> a(boolean z) {
        return z ? this.f4645b : this.f4644a;
    }
}
