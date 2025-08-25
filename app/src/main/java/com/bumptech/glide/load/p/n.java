package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: EngineKey.java */
/* loaded from: classes.dex */
class n implements com.bumptech.glide.load.g {

    /* renamed from: c, reason: collision with root package name */
    private final Object f4623c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4624d;

    /* renamed from: e, reason: collision with root package name */
    private final int f4625e;

    /* renamed from: f, reason: collision with root package name */
    private final Class<?> f4626f;

    /* renamed from: g, reason: collision with root package name */
    private final Class<?> f4627g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.g f4628h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.n<?>> f4629i;

    /* renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.load.j f4630j;

    /* renamed from: k, reason: collision with root package name */
    private int f4631k;

    n(Object obj, com.bumptech.glide.load.g gVar, int i2, int i3, Map<Class<?>, com.bumptech.glide.load.n<?>> map, Class<?> cls, Class<?> cls2, com.bumptech.glide.load.j jVar) {
        this.f4623c = com.bumptech.glide.util.j.a(obj);
        this.f4628h = (com.bumptech.glide.load.g) com.bumptech.glide.util.j.a(gVar, "Signature must not be null");
        this.f4624d = i2;
        this.f4625e = i3;
        this.f4629i = (Map) com.bumptech.glide.util.j.a(map);
        this.f4626f = (Class) com.bumptech.glide.util.j.a(cls, "Resource class must not be null");
        this.f4627g = (Class) com.bumptech.glide.util.j.a(cls2, "Transcode class must not be null");
        this.f4630j = (com.bumptech.glide.load.j) com.bumptech.glide.util.j.a(jVar);
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f4623c.equals(nVar.f4623c) && this.f4628h.equals(nVar.f4628h) && this.f4625e == nVar.f4625e && this.f4624d == nVar.f4624d && this.f4629i.equals(nVar.f4629i) && this.f4626f.equals(nVar.f4626f) && this.f4627g.equals(nVar.f4627g) && this.f4630j.equals(nVar.f4630j);
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        if (this.f4631k == 0) {
            this.f4631k = this.f4623c.hashCode();
            this.f4631k = (this.f4631k * 31) + this.f4628h.hashCode();
            this.f4631k = (this.f4631k * 31) + this.f4624d;
            this.f4631k = (this.f4631k * 31) + this.f4625e;
            this.f4631k = (this.f4631k * 31) + this.f4629i.hashCode();
            this.f4631k = (this.f4631k * 31) + this.f4626f.hashCode();
            this.f4631k = (this.f4631k * 31) + this.f4627g.hashCode();
            this.f4631k = (this.f4631k * 31) + this.f4630j.hashCode();
        }
        return this.f4631k;
    }

    public String toString() {
        return "EngineKey{model=" + this.f4623c + ", width=" + this.f4624d + ", height=" + this.f4625e + ", resourceClass=" + this.f4626f + ", transcodeClass=" + this.f4627g + ", signature=" + this.f4628h + ", hashCode=" + this.f4631k + ", transformations=" + this.f4629i + ", options=" + this.f4630j + '}';
    }
}
