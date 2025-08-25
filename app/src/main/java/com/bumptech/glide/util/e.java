package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.e;

/* compiled from: FixedPreloadSizeProvider.java */
/* loaded from: classes.dex */
public class e<T> implements e.b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final int[] f5374a;

    public e(int i2, int i3) {
        this.f5374a = new int[]{i2, i3};
    }

    @Override // com.bumptech.glide.e.b
    @Nullable
    public int[] a(@NonNull T t, int i2, int i3) {
        return this.f5374a;
    }
}
