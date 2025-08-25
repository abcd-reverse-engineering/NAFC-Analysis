package com.luck.picture.lib;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import java.io.InputStream;

/* loaded from: classes.dex */
public class PictureSelectorExternalUtils {
    public static ExifInterface getExifInterface(Context context, String str) throws Throwable {
        InputStream inputStreamOpenInputStream;
        ExifInterface exifInterface;
        InputStream inputStream = null;
        try {
            try {
                if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(str)) {
                    inputStreamOpenInputStream = context.getContentResolver().openInputStream(Uri.parse(str));
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStream = inputStreamOpenInputStream;
                            exifInterface = new ExifInterface(inputStreamOpenInputStream);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            PictureFileUtils.close(inputStreamOpenInputStream);
                            return null;
                        }
                    } else {
                        inputStream = inputStreamOpenInputStream;
                        exifInterface = null;
                    }
                } else {
                    exifInterface = new ExifInterface(str);
                }
                PictureFileUtils.close(inputStream);
                return exifInterface;
            } catch (Exception e3) {
                e = e3;
                inputStreamOpenInputStream = null;
            } catch (Throwable th) {
                th = th;
                PictureFileUtils.close(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = context;
            PictureFileUtils.close(inputStream);
            throw th;
        }
    }
}
