package com.airbnb.lottie.y;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;

/* compiled from: LottieCompositionCache.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static final g f3830b = new g();

    /* renamed from: a, reason: collision with root package name */
    private final LruCache<String, com.airbnb.lottie.g> f3831a = new LruCache<>(20);

    @VisibleForTesting
    g() {
    }

    public static g b() {
        return f3830b;
    }

    @Nullable
    public com.airbnb.lottie.g a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f3831a.get(str);
    }

    public void a(@Nullable String str, com.airbnb.lottie.g gVar) {
        if (str == null) {
            return;
        }
        this.f3831a.put(str, gVar);
    }

    public void a() {
        this.f3831a.evictAll();
    }

    public void a(int i2) {
        this.f3831a.resize(i2);
    }
}
