package com.bumptech.glide.load.r.f;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.p.v;

/* compiled from: NonOwnedDrawableResource.java */
/* loaded from: classes.dex */
final class d extends b<Drawable> {
    private d(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    static v<Drawable> a(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new d(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<Drawable> b() {
        return this.f4976a.getClass();
    }

    @Override // com.bumptech.glide.load.p.v
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return Math.max(1, this.f4976a.getIntrinsicWidth() * this.f4976a.getIntrinsicHeight() * 4);
    }
}
