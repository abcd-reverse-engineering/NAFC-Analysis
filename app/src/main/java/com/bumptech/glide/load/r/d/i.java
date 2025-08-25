package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.r.m.c;

/* compiled from: BitmapTransitionOptions.java */
/* loaded from: classes.dex */
public final class i extends com.bumptech.glide.l<i, Bitmap> {
    @NonNull
    public static i b(@NonNull com.bumptech.glide.r.m.c cVar) {
        return new i().a(cVar);
    }

    @NonNull
    public static i c(int i2) {
        return new i().b(i2);
    }

    @NonNull
    public static i d() {
        return new i().c();
    }

    @NonNull
    public i a(@NonNull com.bumptech.glide.r.m.c cVar) {
        return b((com.bumptech.glide.r.m.g<Drawable>) cVar);
    }

    @NonNull
    public static i b(@NonNull c.a aVar) {
        return new i().a(aVar);
    }

    @NonNull
    public static i c(@NonNull com.bumptech.glide.r.m.g<Bitmap> gVar) {
        return new i().a(gVar);
    }

    @NonNull
    public static i d(@NonNull com.bumptech.glide.r.m.g<Drawable> gVar) {
        return new i().b(gVar);
    }

    @NonNull
    public i a(@NonNull c.a aVar) {
        return b((com.bumptech.glide.r.m.g<Drawable>) aVar.a());
    }

    @NonNull
    public i b(int i2) {
        return a(new c.a(i2));
    }

    @NonNull
    public i c() {
        return a(new c.a());
    }

    @NonNull
    public i b(@NonNull com.bumptech.glide.r.m.g<Drawable> gVar) {
        return a(new com.bumptech.glide.r.m.b(gVar));
    }
}
