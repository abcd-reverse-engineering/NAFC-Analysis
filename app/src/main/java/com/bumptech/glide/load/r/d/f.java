package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* compiled from: BitmapImageDecoderResourceDecoder.java */
@RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class f extends com.bumptech.glide.load.r.a<Bitmap> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f4858d = "BitmapImageDecoder";

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f4859c = new com.bumptech.glide.load.p.a0.f();

    @Override // com.bumptech.glide.load.r.a
    protected com.bumptech.glide.load.p.v<Bitmap> a(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable(f4858d, 2)) {
            String str = "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i2 + "x" + i3 + "]";
        }
        return new g(bitmapDecodeBitmap, this.f4859c);
    }
}
