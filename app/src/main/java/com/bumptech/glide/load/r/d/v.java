package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: GranularRoundedCorners.java */
/* loaded from: classes.dex */
public final class v extends h {

    /* renamed from: g, reason: collision with root package name */
    private static final String f4946g = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners";

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f4947h = f4946g.getBytes(com.bumptech.glide.load.g.f4249b);

    /* renamed from: c, reason: collision with root package name */
    private final float f4948c;

    /* renamed from: d, reason: collision with root package name */
    private final float f4949d;

    /* renamed from: e, reason: collision with root package name */
    private final float f4950e;

    /* renamed from: f, reason: collision with root package name */
    private final float f4951f;

    public v(float f2, float f3, float f4, float f5) {
        this.f4948c = f2;
        this.f4949d = f3;
        this.f4950e = f4;
        this.f4951f = f5;
    }

    @Override // com.bumptech.glide.load.r.d.h
    protected Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return g0.a(eVar, bitmap, this.f4948c, this.f4949d, this.f4950e, this.f4951f);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f4948c == vVar.f4948c && this.f4949d == vVar.f4949d && this.f4950e == vVar.f4950e && this.f4951f == vVar.f4951f;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return com.bumptech.glide.util.l.a(this.f4951f, com.bumptech.glide.util.l.a(this.f4950e, com.bumptech.glide.util.l.a(this.f4949d, com.bumptech.glide.util.l.a(f4946g.hashCode(), com.bumptech.glide.util.l.a(this.f4948c)))));
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f4947h);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.f4948c).putFloat(this.f4949d).putFloat(this.f4950e).putFloat(this.f4951f).array());
    }
}
