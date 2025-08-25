package com.bumptech.glide.r.l;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: BitmapThumbnailImageViewTarget.java */
/* loaded from: classes.dex */
public class d extends q<Bitmap> {
    public d(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.r.l.q
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Drawable b(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.f5312b).getResources(), bitmap);
    }

    @Deprecated
    public d(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
