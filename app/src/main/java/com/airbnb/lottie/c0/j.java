package com.airbnb.lottie.c0;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: LottieValueCallback.java */
/* loaded from: classes.dex */
public class j<T> {

    /* renamed from: a, reason: collision with root package name */
    private final b<T> f3474a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private com.airbnb.lottie.w.c.a<?, ?> f3475b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    protected T f3476c;

    public j() {
        this.f3474a = new b<>();
        this.f3476c = null;
    }

    @Nullable
    public T a(b<T> bVar) {
        return this.f3476c;
    }

    public final void a(@Nullable T t) {
        this.f3476c = t;
        com.airbnb.lottie.w.c.a<?, ?> aVar = this.f3475b;
        if (aVar != null) {
            aVar.g();
        }
    }

    public j(@Nullable T t) {
        this.f3474a = new b<>();
        this.f3476c = null;
        this.f3476c = t;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T a(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        return a((b) this.f3474a.a(f2, f3, t, t2, f4, f5, f6));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void a(@Nullable com.airbnb.lottie.w.c.a<?, ?> aVar) {
        this.f3475b = aVar;
    }
}
