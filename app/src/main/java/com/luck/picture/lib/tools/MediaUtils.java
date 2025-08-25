package com.luck.picture.lib.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.hms.android.SystemUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.umeng.analytics.pro.bl;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class MediaUtils {
    public static final String HUAWEI_RECORD_PATH = "Sounds/CallRecord";
    public static final String HUAWEI_RECORD_PATH_pt = "Sounds";
    public static final String LETV_RECORD_PATH = "Recorder/remote";
    public static final String LETV_RECORD_PATH_pt = "Recorder";
    public static final String OPPO_RECORD_PATH = "Recordings/Call Recordings";
    public static final String OPPO_RECORD_PATH_6 = "Recordings";
    public static final String SANUNG_RECORD_PATH = "Sounds";
    public static final String VIVO_RECORD_PATH = "录音/通话录音";
    public static final String VIVO_RECORD_PATH_OT = "Record";
    public static final String VIVO_RECORD_PATH_OT_pt = "Record/Call";
    public static final String VIVO_RECORD_PATH_pt = "录音";
    public static final String XIAOMI_RECORD_PATH = "MIUI/sound_recorder/call_rec";
    public static final String XIAOMI_RECORD_PATH_pt = "MIUI/sound_recorder";

    @Nullable
    public static Uri createImageUri(Context context) {
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        String string = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        contentValues.put("datetaken", string);
        contentValues.put("mime_type", "image/jpeg");
        if (externalStorageState.equals("mounted")) {
            contentValues.put("relative_path", PictureMimeType.DCIM);
            uriArr[0] = context.getContentResolver().insert(MediaStore.Images.Media.getContentUri("external"), contentValues);
        } else {
            uriArr[0] = context.getContentResolver().insert(MediaStore.Images.Media.getContentUri(UMModuleRegister.INNER), contentValues);
        }
        return uriArr[0];
    }

    @Nullable
    public static Uri createVideoUri(Context context) {
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        String string = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("_display_name", DateUtils.getCreateFileName("VID_"));
        contentValues.put("datetaken", string);
        contentValues.put("mime_type", "video/mp4");
        if (externalStorageState.equals("mounted")) {
            contentValues.put("relative_path", PictureMimeType.DCIM);
            uriArr[0] = context.getContentResolver().insert(MediaStore.Video.Media.getContentUri("external"), contentValues);
        } else {
            uriArr[0] = context.getContentResolver().insert(MediaStore.Video.Media.getContentUri(UMModuleRegister.INNER), contentValues);
        }
        return uriArr[0];
    }

    public static long extractDuration(Context context, boolean z, String str) {
        return z ? getLocalDuration(context, Uri.parse(str)) : getLocalDuration(str);
    }

    @Nullable
    public static String getAudioFilePathFromUri(Context context, Uri uri) {
        String string = "";
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    cursorQuery.moveToFirst();
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            return string;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public static boolean getFolder(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = Build.BRAND;
        if (str2.equalsIgnoreCase("xiaomi")) {
            if (str.contains("MIUI/sound_recorder/call_rec") || str.contains(XIAOMI_RECORD_PATH_pt)) {
                return true;
            }
        } else if (str2.equalsIgnoreCase("oppo")) {
            if (str.contains("Recordings/Call Recordings") || str.contains("Recordings")) {
                return true;
            }
        } else if (str2.equalsIgnoreCase("huawei") || str2.equalsIgnoreCase(SystemUtils.PRODUCT_HONOR)) {
            if (str.contains("Sounds/CallRecord") || str.contains("Sounds")) {
                return true;
            }
        } else if (str2.equalsIgnoreCase("vivo")) {
            if (str.contains("录音/通话录音") || str.contains(VIVO_RECORD_PATH_pt) || str.contains(VIVO_RECORD_PATH_OT) || str.contains(VIVO_RECORD_PATH_OT_pt)) {
                return true;
            }
        } else if (str2.equalsIgnoreCase("sansung")) {
            if (str.contains("Sounds")) {
                return true;
            }
        } else if (str2.equalsIgnoreCase("Letv") && (str.contains("Recorder/remote") || str.contains(LETV_RECORD_PATH_pt))) {
            return true;
        }
        return false;
    }

    public static int getImageOrientationForUrl(Context context, String str) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        ExifInterface exifInterface = null;
        InputStream inputStream2 = null;
        try {
            try {
                if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(str)) {
                    inputStreamOpenInputStream = context.getContentResolver().openInputStream(Uri.parse(str));
                    if (inputStreamOpenInputStream != null) {
                        try {
                            exifInterface = new ExifInterface(inputStreamOpenInputStream);
                        } catch (Exception e2) {
                            e = e2;
                            inputStream2 = inputStreamOpenInputStream;
                            e.printStackTrace();
                            PictureFileUtils.close(inputStream2);
                            return 0;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStreamOpenInputStream;
                            PictureFileUtils.close(inputStream);
                            throw th;
                        }
                    }
                } else {
                    exifInterface = new ExifInterface(str);
                    inputStreamOpenInputStream = null;
                }
                int attributeInt = exifInterface != null ? exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1) : 0;
                PictureFileUtils.close(inputStreamOpenInputStream);
                return attributeInt;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int[] getImageSizeForUri(Context context, Uri uri) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        int[] iArr = new int[2];
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            try {
                parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor(), null, options);
                        parcelFileDescriptor = null;
                        iArr[0] = options.outWidth;
                        iArr[1] = options.outHeight;
                    } catch (Exception e2) {
                        e = e2;
                        parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                        e.printStackTrace();
                        PictureFileUtils.close(parcelFileDescriptor);
                        return iArr;
                    } catch (Throwable th) {
                        th = th;
                        PictureFileUtils.close(parcelFileDescriptorOpenFileDescriptor);
                        throw th;
                    }
                }
                PictureFileUtils.close(parcelFileDescriptorOpenFileDescriptor);
            } catch (Exception e3) {
                e = e3;
            }
            return iArr;
        } catch (Throwable th2) {
            th = th2;
            parcelFileDescriptorOpenFileDescriptor = parcelFileDescriptor;
        }
    }

    public static int[] getImageSizeForUrl(String str) {
        int[] iArr = new int[2];
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            int attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, 1);
            int attributeInt2 = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, 1);
            iArr[0] = attributeInt;
            iArr[1] = attributeInt2;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return iArr;
    }

    public static int[] getImageSizeForUrlToAndroidQ(Context context, String str) {
        int[] iArr = new int[2];
        Cursor cursorQuery = null;
        try {
            try {
                if (Build.VERSION.SDK_INT >= 26 && (cursorQuery = context.getApplicationContext().getContentResolver().query(Uri.parse(str), null, null, null)) != null) {
                    cursorQuery.moveToFirst();
                    iArr[0] = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow(SocializeProtocolConstants.WIDTH));
                    iArr[1] = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow(SocializeProtocolConstants.HEIGHT));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            return iArr;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public static int getLastImageId(Context context, String str) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, "_data like ?", new String[]{PictureFileUtils.getDCIMCameraPath(context, str) + "%"}, "_id DESC");
                if (cursorQuery == null || cursorQuery.getCount() <= 0 || !cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return -1;
                }
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(bl.f10170d));
                if (DateUtils.dateDiffer(cursorQuery.getLong(cursorQuery.getColumnIndex("date_added"))) > 1) {
                    i2 = -1;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return i2;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return -1;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    private static long getLocalDuration(Context context, Uri uri) throws SecurityException, IllegalArgumentException {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, uri);
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String getRecordFolder(Context context) {
        File externalFilesDir = SdkVersionUtils.checkedAndroid_Q() ? context.getExternalFilesDir("") : Environment.getExternalStorageDirectory();
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("xiaomi")) {
            return XIAOMI_RECORD_PATH_pt;
        }
        if (str.equalsIgnoreCase("oppo")) {
            return "Recordings";
        }
        if (!str.equalsIgnoreCase("huawei") && !str.equalsIgnoreCase(SystemUtils.PRODUCT_HONOR)) {
            if (str.equalsIgnoreCase("vivo")) {
                return new File(externalFilesDir, VIVO_RECORD_PATH_pt).exists() ? VIVO_RECORD_PATH_pt : VIVO_RECORD_PATH_OT;
            }
            if (!str.equalsIgnoreCase("sansung")) {
                if (str.equalsIgnoreCase("Letv")) {
                    return LETV_RECORD_PATH_pt;
                }
                return null;
            }
        }
        return "Sounds";
    }

    public static int getVideoOrientationForUri(Context context, Uri uri) throws SecurityException, IllegalArgumentException {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, uri);
            int i2 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(24));
            if (i2 != 90) {
                return i2 != 270 ? 0 : 8;
            }
            return 6;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int getVideoOrientationForUrl(String str) throws IllegalArgumentException {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            int i2 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(24));
            if (i2 != 90) {
                return i2 != 270 ? 0 : 8;
            }
            return 6;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int[] getVideoSizeForUri(Context context, Uri uri) throws SecurityException, IllegalArgumentException {
        int[] iArr = new int[2];
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, uri);
            iArr[0] = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
            iArr[1] = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return iArr;
    }

    public static int[] getVideoSizeForUrl(String str) throws IllegalArgumentException {
        int[] iArr = new int[2];
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            iArr[0] = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
            iArr[1] = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return iArr;
    }

    public static boolean isLongImg(int i2, int i3) {
        return i3 > i2 * 3;
    }

    public static boolean isLongImg(LocalMedia localMedia) {
        if (localMedia != null) {
            return localMedia.getHeight() > localMedia.getWidth() * 3;
        }
        return false;
    }

    public static void removeMedia(Context context, int i2) {
        try {
            context.getApplicationContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{Long.toString(i2)});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int setOrientation(Context context, LocalMedia localMedia) throws Throwable {
        if (localMedia.getOrientation() != -1) {
            return localMedia.getOrientation();
        }
        int videoOrientationForUri = 0;
        if (PictureMimeType.eqImage(localMedia.getMimeType())) {
            videoOrientationForUri = getImageOrientationForUrl(context, localMedia.getPath());
        } else if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
            videoOrientationForUri = PictureMimeType.isContent(localMedia.getPath()) ? getVideoOrientationForUri(context, Uri.parse(localMedia.getPath())) : getVideoOrientationForUrl(localMedia.getPath());
        }
        if (videoOrientationForUri == 6 || videoOrientationForUri == 8) {
            int width = localMedia.getWidth();
            localMedia.setWidth(localMedia.getHeight());
            localMedia.setHeight(width);
        }
        localMedia.setOrientation(videoOrientationForUri);
        return videoOrientationForUri;
    }

    private static long getLocalDuration(String str) throws IllegalArgumentException {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }
}
