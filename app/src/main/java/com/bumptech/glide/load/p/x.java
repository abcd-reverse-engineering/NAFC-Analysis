package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: ResourceCacheKey.java */
/* loaded from: classes.dex */
final class x implements com.bumptech.glide.load.g {

    /* renamed from: k, reason: collision with root package name */
    private static final com.bumptech.glide.util.g<Class<?>, byte[]> f4665k = new com.bumptech.glide.util.g<>(50);

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.b f4666c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.g f4667d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.g f4668e;

    /* renamed from: f, reason: collision with root package name */
    private final int f4669f;

    /* renamed from: g, reason: collision with root package name */
    private final int f4670g;

    /* renamed from: h, reason: collision with root package name */
    private final Class<?> f4671h;

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.j f4672i;

    /* renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.load.n<?> f4673j;

    x(com.bumptech.glide.load.p.a0.b bVar, com.bumptech.glide.load.g gVar, com.bumptech.glide.load.g gVar2, int i2, int i3, com.bumptech.glide.load.n<?> nVar, Class<?> cls, com.bumptech.glide.load.j jVar) {
        this.f4666c = bVar;
        this.f4667d = gVar;
        this.f4668e = gVar2;
        this.f4669f = i2;
        this.f4670g = i3;
        this.f4673j = nVar;
        this.f4671h = cls;
        this.f4672i = jVar;
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f4666c.a(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f4669f).putInt(this.f4670g).array();
        this.f4668e.a(messageDigest);
        this.f4667d.a(messageDigest);
        messageDigest.update(bArr);
        com.bumptech.glide.load.n<?> nVar = this.f4673j;
        if (nVar != null) {
            nVar.a(messageDigest);
        }
        this.f4672i.a(messageDigest);
        messageDigest.update(a());
        this.f4666c.put(bArr);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f4670g == xVar.f4670g && this.f4669f == xVar.f4669f && com.bumptech.glide.util.l.b(this.f4673j, xVar.f4673j) && this.f4671h.equals(xVar.f4671h) && this.f4667d.equals(xVar.f4667d) && this.f4668e.equals(xVar.f4668e) && this.f4672i.equals(xVar.f4672i);
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        int iHashCode = (((((this.f4667d.hashCode() * 31) + this.f4668e.hashCode()) * 31) + this.f4669f) * 31) + this.f4670g;
        com.bumptech.glide.load.n<?> nVar = this.f4673j;
        if (nVar != null) {
            iHashCode = (iHashCode * 31) + nVar.hashCode();
        }
        return (((iHashCode * 31) + this.f4671h.hashCode()) * 31) + this.f4672i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f4667d + ", signature=" + this.f4668e + ", width=" + this.f4669f + ", height=" + this.f4670g + ", decodedResourceClass=" + this.f4671h + ", transformation='" + this.f4673j + "', options=" + this.f4672i + '}';
    }

    private byte[] a() {
        byte[] bArrB = f4665k.b(this.f4671h);
        if (bArrB != null) {
            return bArrB;
        }
        byte[] bytes = this.f4671h.getName().getBytes(com.bumptech.glide.load.g.f4249b);
        f4665k.b(this.f4671h, bytes);
        return bytes;
    }
}
