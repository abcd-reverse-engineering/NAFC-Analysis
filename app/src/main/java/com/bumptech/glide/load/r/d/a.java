package com.bumptech.glide.load.r.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: BitmapDrawableDecoder.java */
/* loaded from: classes.dex */
public class a<DataType> implements com.bumptech.glide.load.l<DataType, BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.l<DataType, Bitmap> f4833a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f4834b;

    public a(Context context, com.bumptech.glide.load.l<DataType, Bitmap> lVar) {
        this(context.getResources(), lVar);
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull DataType datatype, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        return this.f4833a.a(datatype, jVar);
    }

    @Deprecated
    public a(Resources resources, com.bumptech.glide.load.p.a0.e eVar, com.bumptech.glide.load.l<DataType, Bitmap> lVar) {
        this(resources, lVar);
    }

    @Override // com.bumptech.glide.load.l
    public com.bumptech.glide.load.p.v<BitmapDrawable> a(@NonNull DataType datatype, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        return z.a(this.f4834b, this.f4833a.a(datatype, i2, i3, jVar));
    }

    public a(@NonNull Resources resources, @NonNull com.bumptech.glide.load.l<DataType, Bitmap> lVar) {
        this.f4834b = (Resources) com.bumptech.glide.util.j.a(resources);
        this.f4833a = (com.bumptech.glide.load.l) com.bumptech.glide.util.j.a(lVar);
    }
}
