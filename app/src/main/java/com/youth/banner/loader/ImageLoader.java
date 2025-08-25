package com.youth.banner.loader;

import android.content.Context;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public abstract class ImageLoader implements ImageLoaderInterface<ImageView> {
    @Override // com.youth.banner.loader.ImageLoaderInterface
    public ImageView createImageView(Context context) {
        return new ImageView(context);
    }
}
