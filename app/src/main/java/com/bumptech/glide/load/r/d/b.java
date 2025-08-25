package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.File;

/* compiled from: BitmapDrawableEncoder.java */
/* loaded from: classes.dex */
public class b implements com.bumptech.glide.load.m<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f4836a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.m<Bitmap> f4837b;

    public b(com.bumptech.glide.load.p.a0.e eVar, com.bumptech.glide.load.m<Bitmap> mVar) {
        this.f4836a = eVar;
        this.f4837b = mVar;
    }

    @Override // com.bumptech.glide.load.d
    public boolean a(@NonNull com.bumptech.glide.load.p.v<BitmapDrawable> vVar, @NonNull File file, @NonNull com.bumptech.glide.load.j jVar) {
        return this.f4837b.a(new g(vVar.get().getBitmap(), this.f4836a), file, jVar);
    }

    @Override // com.bumptech.glide.load.m
    @NonNull
    public com.bumptech.glide.load.c a(@NonNull com.bumptech.glide.load.j jVar) {
        return this.f4837b.a(jVar);
    }
}
