package com.luck.picture.lib.widget.longimage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes.dex */
public class SkiaImageRegionDecoder implements ImageRegionDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private BitmapRegionDecoder decoder;
    private final Object decoderLock = new Object();

    @Override // com.luck.picture.lib.widget.longimage.ImageRegionDecoder
    public Bitmap decodeRegion(Rect rect, int i2) {
        Bitmap bitmapDecodeRegion;
        synchronized (this.decoderLock) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i2;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            bitmapDecodeRegion = this.decoder.decodeRegion(rect, options);
            if (bitmapDecodeRegion == null) {
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
        }
        return bitmapDecodeRegion;
    }

    @Override // com.luck.picture.lib.widget.longimage.ImageRegionDecoder
    public Point init(Context context, Uri uri) throws Exception {
        int identifier;
        String string = uri.toString();
        if (string.startsWith(RESOURCE_PREFIX)) {
            String authority = uri.getAuthority();
            Resources resources = context.getPackageName().equals(authority) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                identifier = resources.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                }
            } else {
                identifier = 0;
            }
            this.decoder = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(identifier), false);
        } else if (string.startsWith(ASSET_PREFIX)) {
            this.decoder = BitmapRegionDecoder.newInstance(context.getAssets().open(string.substring(22), 1), false);
        } else if (string.startsWith(FILE_PREFIX)) {
            this.decoder = BitmapRegionDecoder.newInstance(string.substring(7), false);
        } else {
            InputStream inputStreamOpenInputStream = null;
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                this.decoder = BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Exception unused2) {
                    }
                }
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        }
        return new Point(this.decoder.getWidth(), this.decoder.getHeight());
    }

    @Override // com.luck.picture.lib.widget.longimage.ImageRegionDecoder
    public boolean isReady() {
        BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
        return (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) ? false : true;
    }

    @Override // com.luck.picture.lib.widget.longimage.ImageRegionDecoder
    public void recycle() {
        this.decoder.recycle();
    }
}
