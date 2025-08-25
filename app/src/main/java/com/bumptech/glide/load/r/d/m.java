package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: CenterInside.java */
/* loaded from: classes.dex */
public class m extends h {

    /* renamed from: c, reason: collision with root package name */
    private static final String f4897c = "com.bumptech.glide.load.resource.bitmap.CenterInside";

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f4898d = f4897c.getBytes(com.bumptech.glide.load.g.f4249b);

    @Override // com.bumptech.glide.load.r.d.h
    protected Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return g0.b(eVar, bitmap, i2, i3);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        return obj instanceof m;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return f4897c.hashCode();
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f4898d);
    }
}
