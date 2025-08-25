package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: DataCacheKey.java */
/* loaded from: classes.dex */
final class d implements com.bumptech.glide.load.g {

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.g f4489c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.g f4490d;

    d(com.bumptech.glide.load.g gVar, com.bumptech.glide.load.g gVar2) {
        this.f4489c = gVar;
        this.f4490d = gVar2;
    }

    com.bumptech.glide.load.g a() {
        return this.f4489c;
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f4489c.equals(dVar.f4489c) && this.f4490d.equals(dVar.f4490d);
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return (this.f4489c.hashCode() * 31) + this.f4490d.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f4489c + ", signature=" + this.f4490d + '}';
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        this.f4489c.a(messageDigest);
        this.f4490d.a(messageDigest);
    }
}
