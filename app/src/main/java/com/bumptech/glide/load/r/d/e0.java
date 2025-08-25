package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: RoundedCorners.java */
/* loaded from: classes.dex */
public final class e0 extends h {

    /* renamed from: d, reason: collision with root package name */
    private static final String f4855d = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f4856e = f4855d.getBytes(com.bumptech.glide.load.g.f4249b);

    /* renamed from: c, reason: collision with root package name */
    private final int f4857c;

    public e0(int i2) {
        com.bumptech.glide.util.j.a(i2 > 0, "roundingRadius must be greater than 0.");
        this.f4857c = i2;
    }

    @Override // com.bumptech.glide.load.r.d.h
    protected Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return g0.b(eVar, bitmap, this.f4857c);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        return (obj instanceof e0) && this.f4857c == ((e0) obj).f4857c;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return com.bumptech.glide.util.l.a(f4855d.hashCode(), com.bumptech.glide.util.l.b(this.f4857c));
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f4856e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f4857c).array());
    }
}
