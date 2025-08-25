package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: CircleCrop.java */
/* loaded from: classes.dex */
public class n extends h {

    /* renamed from: c, reason: collision with root package name */
    private static final int f4899c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final String f4900d = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f4901e = f4900d.getBytes(com.bumptech.glide.load.g.f4249b);

    @Override // com.bumptech.glide.load.r.d.h
    protected Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return g0.c(eVar, bitmap, i2, i3);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        return obj instanceof n;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return f4900d.hashCode();
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f4901e);
    }
}
