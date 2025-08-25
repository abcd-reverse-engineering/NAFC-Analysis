package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: BitmapResource.java */
/* loaded from: classes.dex */
public class g implements com.bumptech.glide.load.p.v<Bitmap>, com.bumptech.glide.load.p.r {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap f4864a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f4865b;

    public g(@NonNull Bitmap bitmap, @NonNull com.bumptech.glide.load.p.a0.e eVar) {
        this.f4864a = (Bitmap) com.bumptech.glide.util.j.a(bitmap, "Bitmap must not be null");
        this.f4865b = (com.bumptech.glide.load.p.a0.e) com.bumptech.glide.util.j.a(eVar, "BitmapPool must not be null");
    }

    @Nullable
    public static g a(@Nullable Bitmap bitmap, @NonNull com.bumptech.glide.load.p.a0.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new g(bitmap, eVar);
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<Bitmap> b() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.p.r
    public void c() {
        this.f4864a.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.p.v
    public void recycle() {
        this.f4865b.a(this.f4864a);
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return com.bumptech.glide.util.l.a(this.f4864a);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Bitmap get() {
        return this.f4864a;
    }
}
