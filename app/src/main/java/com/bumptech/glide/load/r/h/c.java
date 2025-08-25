package com.bumptech.glide.load.r.h;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* compiled from: DrawableBytesTranscoder.java */
/* loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f4988a;

    /* renamed from: b, reason: collision with root package name */
    private final e<Bitmap, byte[]> f4989b;

    /* renamed from: c, reason: collision with root package name */
    private final e<GifDrawable, byte[]> f4990c;

    public c(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull e<Bitmap, byte[]> eVar2, @NonNull e<GifDrawable, byte[]> eVar3) {
        this.f4988a = eVar;
        this.f4989b = eVar2;
        this.f4990c = eVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static v<GifDrawable> a(@NonNull v<Drawable> vVar) {
        return vVar;
    }

    @Override // com.bumptech.glide.load.r.h.e
    @Nullable
    public v<byte[]> a(@NonNull v<Drawable> vVar, @NonNull j jVar) {
        Drawable drawable = vVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f4989b.a(com.bumptech.glide.load.r.d.g.a(((BitmapDrawable) drawable).getBitmap(), this.f4988a), jVar);
        }
        if (drawable instanceof GifDrawable) {
            return this.f4990c.a(a(vVar), jVar);
        }
        return null;
    }
}
