package com.bumptech.glide.load.r.e;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.util.j;

/* compiled from: BytesResource.java */
/* loaded from: classes.dex */
public class b implements v<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f4974a;

    public b(byte[] bArr) {
        this.f4974a = (byte[]) j.a(bArr);
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return this.f4974a.length;
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<byte[]> b() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.p.v
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public byte[] get() {
        return this.f4974a;
    }
}
