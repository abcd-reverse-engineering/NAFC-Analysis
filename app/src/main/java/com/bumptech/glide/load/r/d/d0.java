package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: Rotate.java */
/* loaded from: classes.dex */
public class d0 extends h {

    /* renamed from: d, reason: collision with root package name */
    private static final String f4848d = "com.bumptech.glide.load.resource.bitmap.Rotate";

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f4849e = f4848d.getBytes(com.bumptech.glide.load.g.f4249b);

    /* renamed from: c, reason: collision with root package name */
    private final int f4850c;

    public d0(int i2) {
        this.f4850c = i2;
    }

    @Override // com.bumptech.glide.load.r.d.h
    protected Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return g0.a(bitmap, this.f4850c);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        return (obj instanceof d0) && this.f4850c == ((d0) obj).f4850c;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return com.bumptech.glide.util.l.a(f4848d.hashCode(), com.bumptech.glide.util.l.b(this.f4850c));
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f4849e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f4850c).array());
    }
}
