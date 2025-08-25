package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: FitCenter.java */
/* loaded from: classes.dex */
public class u extends h {

    /* renamed from: c, reason: collision with root package name */
    private static final String f4944c = "com.bumptech.glide.load.resource.bitmap.FitCenter";

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f4945d = f4944c.getBytes(com.bumptech.glide.load.g.f4249b);

    @Override // com.bumptech.glide.load.r.d.h
    protected Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return g0.d(eVar, bitmap, i2, i3);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        return obj instanceof u;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return f4944c.hashCode();
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f4945d);
    }
}
