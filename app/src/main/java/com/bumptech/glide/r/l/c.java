package com.bumptech.glide.r.l;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: BitmapImageViewTarget.java */
/* loaded from: classes.dex */
public class c extends j<Bitmap> {
    public c(ImageView imageView) {
        super(imageView);
    }

    @Deprecated
    public c(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.r.l.j
    public void a(Bitmap bitmap) {
        ((ImageView) this.f5312b).setImageBitmap(bitmap);
    }
}
