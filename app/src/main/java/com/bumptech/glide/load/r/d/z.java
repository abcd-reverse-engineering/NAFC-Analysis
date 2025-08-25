package com.bumptech.glide.load.r.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: LazyBitmapDrawableResource.java */
/* loaded from: classes.dex */
public final class z implements com.bumptech.glide.load.p.v<BitmapDrawable>, com.bumptech.glide.load.p.r {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f4971a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.p.v<Bitmap> f4972b;

    private z(@NonNull Resources resources, @NonNull com.bumptech.glide.load.p.v<Bitmap> vVar) {
        this.f4971a = (Resources) com.bumptech.glide.util.j.a(resources);
        this.f4972b = (com.bumptech.glide.load.p.v) com.bumptech.glide.util.j.a(vVar);
    }

    @Deprecated
    public static z a(Context context, Bitmap bitmap) {
        return (z) a(context.getResources(), g.a(bitmap, com.bumptech.glide.b.a(context).d()));
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.p.r
    public void c() {
        com.bumptech.glide.load.p.v<Bitmap> vVar = this.f4972b;
        if (vVar instanceof com.bumptech.glide.load.p.r) {
            ((com.bumptech.glide.load.p.r) vVar).c();
        }
    }

    @Override // com.bumptech.glide.load.p.v
    public void recycle() {
        this.f4972b.recycle();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f4971a, this.f4972b.get());
    }

    @Deprecated
    public static z a(Resources resources, com.bumptech.glide.load.p.a0.e eVar, Bitmap bitmap) {
        return (z) a(resources, g.a(bitmap, eVar));
    }

    @Nullable
    public static com.bumptech.glide.load.p.v<BitmapDrawable> a(@NonNull Resources resources, @Nullable com.bumptech.glide.load.p.v<Bitmap> vVar) {
        if (vVar == null) {
            return null;
        }
        return new z(resources, vVar);
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return this.f4972b.a();
    }
}
