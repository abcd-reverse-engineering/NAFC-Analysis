package com.bumptech.glide.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.g;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: MediaStoreSignature.java */
/* loaded from: classes.dex */
public class d implements g {

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final String f5351c;

    /* renamed from: d, reason: collision with root package name */
    private final long f5352d;

    /* renamed from: e, reason: collision with root package name */
    private final int f5353e;

    public d(@Nullable String str, long j2, int i2) {
        this.f5351c = str == null ? "" : str;
        this.f5352d = j2;
        this.f5353e = i2;
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f5352d).putInt(this.f5353e).array());
        messageDigest.update(this.f5351c.getBytes(g.f4249b));
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f5352d == dVar.f5352d && this.f5353e == dVar.f5353e && this.f5351c.equals(dVar.f5351c);
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        int iHashCode = this.f5351c.hashCode() * 31;
        long j2 = this.f5352d;
        return ((iHashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f5353e;
    }
}
