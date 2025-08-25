package com.bumptech.glide.r.l;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* compiled from: DrawableImageViewTarget.java */
/* loaded from: classes.dex */
public class g extends j<Drawable> {
    public g(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.r.l.j
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void a(@Nullable Drawable drawable) {
        ((ImageView) this.f5312b).setImageDrawable(drawable);
    }

    @Deprecated
    public g(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
