package com.bumptech.glide.load.r;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.n;
import com.bumptech.glide.load.p.v;
import java.security.MessageDigest;

/* compiled from: UnitTransformation.java */
/* loaded from: classes.dex */
public final class c<T> implements n<T> {

    /* renamed from: c, reason: collision with root package name */
    private static final n<?> f4832c = new c();

    private c() {
    }

    @NonNull
    public static <T> c<T> a() {
        return (c) f4832c;
    }

    @Override // com.bumptech.glide.load.n
    @NonNull
    public v<T> a(@NonNull Context context, @NonNull v<T> vVar, int i2, int i3) {
        return vVar;
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
    }
}
