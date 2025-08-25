package com.bumptech.glide.load.p.a0;

/* compiled from: ByteArrayAdapter.java */
/* loaded from: classes.dex */
public final class g implements a<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4341a = "ByteArrayPool";

    @Override // com.bumptech.glide.load.p.a0.a
    public int a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.p.a0.a
    public String getTag() {
        return f4341a;
    }

    @Override // com.bumptech.glide.load.p.a0.a
    public int a(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.p.a0.a
    public byte[] newArray(int i2) {
        return new byte[i2];
    }
}
