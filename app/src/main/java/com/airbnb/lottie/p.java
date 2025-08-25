package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: LottieResult.java */
/* loaded from: classes.dex */
public final class p<V> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final V f3611a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Throwable f3612b;

    public p(V v) {
        this.f3611a = v;
        this.f3612b = null;
    }

    @Nullable
    public Throwable a() {
        return this.f3612b;
    }

    @Nullable
    public V b() {
        return this.f3611a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (b() != null && b().equals(pVar.b())) {
            return true;
        }
        if (a() == null || pVar.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public p(Throwable th) {
        this.f3612b = th;
        this.f3611a = null;
    }
}
