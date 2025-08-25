package com.luck.picture.lib.compress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
class Engine {
    private static final int DEFAULT_QUALITY = 80;
    private int compressQuality;
    private boolean focusAlpha;
    private int srcHeight;
    private InputStreamProvider srcImg;
    private int srcWidth;
    private File tagImg;

    Engine(InputStreamProvider inputStreamProvider, File file, boolean z, int i2) throws IOException {
        this.tagImg = file;
        this.srcImg = inputStreamProvider;
        this.focusAlpha = z;
        this.compressQuality = i2 <= 0 ? 80 : i2;
        if (inputStreamProvider.getMedia() != null && inputStreamProvider.getMedia().getWidth() > 0 && inputStreamProvider.getMedia().getHeight() > 0) {
            this.srcWidth = inputStreamProvider.getMedia().getWidth();
            this.srcHeight = inputStreamProvider.getMedia().getHeight();
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeStream(inputStreamProvider.open(), null, options);
        this.srcWidth = options.outWidth;
        this.srcHeight = options.outHeight;
    }

    private int computeSize() {
        int i2 = this.srcWidth;
        if (i2 % 2 == 1) {
            i2++;
        }
        this.srcWidth = i2;
        int i3 = this.srcHeight;
        if (i3 % 2 == 1) {
            i3++;
        }
        this.srcHeight = i3;
        int iMax = Math.max(this.srcWidth, this.srcHeight);
        float fMin = Math.min(this.srcWidth, this.srcHeight) / iMax;
        if (fMin > 1.0f || fMin <= 0.5625d) {
            double d2 = fMin;
            if (d2 > 0.5625d || d2 <= 0.5d) {
                return (int) Math.ceil(iMax / (1280.0d / d2));
            }
            int i4 = iMax / 1280;
            if (i4 == 0) {
                return 1;
            }
            return i4;
        }
        if (iMax < 1664) {
            return 1;
        }
        if (iMax < 4990) {
            return 2;
        }
        if (iMax <= 4990 || iMax >= 10240) {
            return iMax / 1280;
        }
        return 4;
    }

    private Bitmap rotatingImage(Bitmap bitmap, int i2) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    File compress() throws IOException {
        int orientation;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = computeSize();
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.srcImg.open(), null, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.srcImg.getMedia() != null && Checker.SINGLE.isJPG(this.srcImg.getMedia().getMimeType()) && (orientation = this.srcImg.getMedia().getOrientation()) > 0) {
            bitmapDecodeStream = rotatingImage(bitmapDecodeStream, orientation);
        }
        if (bitmapDecodeStream != null) {
            int i2 = this.compressQuality;
            if (i2 <= 0 || i2 > 100) {
                i2 = 80;
            }
            this.compressQuality = i2;
            bitmapDecodeStream.compress(this.focusAlpha ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, this.compressQuality, byteArrayOutputStream);
            bitmapDecodeStream.recycle();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.tagImg);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        byteArrayOutputStream.close();
        return this.tagImg;
    }
}
