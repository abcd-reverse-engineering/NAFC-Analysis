package com.luck.picture.lib.config;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.luck.picture.lib.R;
import java.io.File;

/* loaded from: classes.dex */
public final class PictureMimeType {
    public static final String DCIM = "DCIM/Camera";
    public static final String JPEG = ".jpg";
    public static final String MIME_TYPE_3GP = "video/3gp";
    public static final String MIME_TYPE_AUDIO = "audio/mpeg";
    public static final String MIME_TYPE_AVI = "video/avi";
    public static final String MIME_TYPE_BMP = "image/bmp";
    public static final String MIME_TYPE_GIF = "image/gif";
    public static final String MIME_TYPE_IMAGE = "image/jpeg";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final String MIME_TYPE_JPG = "image/jpg";
    public static final String MIME_TYPE_MP4 = "video/mp4";
    public static final String MIME_TYPE_MPEG = "video/mpeg";
    public static final String MIME_TYPE_PNG = "image/png";
    public static final String MIME_TYPE_PREFIX_AUDIO = "audio";
    public static final String MIME_TYPE_PREFIX_IMAGE = "image";
    public static final String MIME_TYPE_PREFIX_VIDEO = "video";
    public static final String MIME_TYPE_VIDEO = "video/mp4";
    public static final String MIME_TYPE_WEBP = "image/webp";
    public static final String MP4 = ".mp4";
    public static final String PNG = ".png";

    public static boolean eqAudio(String str) {
        return str != null && str.startsWith("audio");
    }

    public static boolean eqImage(String str) {
        return str != null && str.startsWith("image");
    }

    public static boolean eqVideo(String str) {
        return str != null && str.startsWith("video");
    }

    public static String getImageMimeType(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "image/jpeg";
            }
            String name = new File(str).getName();
            return "image/" + name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "image/jpeg";
        }
    }

    public static String getLastImgSuffix(String str) {
        try {
            int iLastIndexOf = str.lastIndexOf("/") + 1;
            if (iLastIndexOf <= 0) {
                return PNG;
            }
            return "." + str.substring(iLastIndexOf);
        } catch (Exception e2) {
            e2.printStackTrace();
            return PNG;
        }
    }

    public static int getMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if (str.startsWith("video")) {
            return 2;
        }
        return str.startsWith("audio") ? 3 : 1;
    }

    public static String getMimeType(int i2) {
        return i2 != 2 ? i2 != 3 ? "image/jpeg" : MIME_TYPE_AUDIO : "video/mp4";
    }

    public static boolean isContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("content://");
    }

    public static boolean isGif(String str) {
        return str != null && (str.equals(MIME_TYPE_GIF) || str.equals("image/GIF"));
    }

    public static boolean isHttp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(HttpConstant.HTTP) || str.startsWith(HttpConstant.HTTPS) || str.startsWith("/http") || str.startsWith("/https");
    }

    public static boolean isJPEG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("image/jpeg") || str.startsWith("image/jpg");
    }

    public static boolean isJPG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("image/jpg");
    }

    public static boolean isMimeTypeSame(String str, String str2) {
        return getMimeType(str) == getMimeType(str2);
    }

    public static boolean isSuffixOfImage(String str) {
        return (!TextUtils.isEmpty(str) && str.endsWith(".PNG")) || str.endsWith(PNG) || str.endsWith(".jpeg") || str.endsWith(".gif") || str.endsWith(".GIF") || str.endsWith(".jpg") || str.endsWith(".webp") || str.endsWith(".WEBP") || str.endsWith(".JPEG") || str.endsWith(".bmp");
    }

    public static final String of3GP() {
        return MIME_TYPE_3GP;
    }

    public static final String ofAVI() {
        return MIME_TYPE_AVI;
    }

    public static final int ofAll() {
        return 0;
    }

    @Deprecated
    public static final int ofAudio() {
        return 3;
    }

    public static final String ofBMP() {
        return MIME_TYPE_BMP;
    }

    public static final String ofGIF() {
        return MIME_TYPE_GIF;
    }

    public static final int ofImage() {
        return 1;
    }

    public static final String ofJPEG() {
        return "image/jpeg";
    }

    public static final String ofMP4() {
        return "video/mp4";
    }

    public static final String ofMPEG() {
        return MIME_TYPE_MPEG;
    }

    public static final String ofPNG() {
        return MIME_TYPE_PNG;
    }

    public static final int ofVideo() {
        return 2;
    }

    public static final String ofWEBP() {
        return MIME_TYPE_WEBP;
    }

    public static String s(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        return eqVideo(str) ? applicationContext.getString(R.string.picture_video_error) : eqAudio(str) ? applicationContext.getString(R.string.picture_audio_error) : applicationContext.getString(R.string.picture_error);
    }
}
