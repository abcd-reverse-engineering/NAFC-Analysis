package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: CenterCrop.java */
/* loaded from: classes.dex */
public class l extends h {

    /* renamed from: c, reason: collision with root package name */
    private static final String f4895c = "com.bumptech.glide.load.resource.bitmap.CenterCrop";

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f4896d = f4895c.getBytes(com.bumptech.glide.load.g.f4249b);

    @Override // com.bumptech.glide.load.r.d.h
    protected Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return g0.a(eVar, bitmap, i2, i3);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        return obj instanceof l;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return f4895c.hashCode();
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f4896d);
    }
}
