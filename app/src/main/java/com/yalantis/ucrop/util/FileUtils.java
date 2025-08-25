package com.yalantis.ucrop.util;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.c.a.b.a.a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;

/* loaded from: classes2.dex */
public class FileUtils {
    private static final String TAG = "FileUtils";
    private static SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd_HHmmssSS");

    private FileUtils() {
    }

    public static boolean copyFile(FileInputStream fileInputStream, String str) throws Throwable {
        FileChannel channel;
        if (fileInputStream == null) {
            return false;
        }
        FileChannel fileChannel = null;
        try {
            channel = fileInputStream.getChannel();
            try {
                FileChannel channel2 = new FileOutputStream(new File(str)).getChannel();
                try {
                    channel.transferTo(0L, channel.size(), channel2);
                    channel.close();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    if (channel2 != null) {
                        channel2.close();
                    }
                    return true;
                } catch (Exception unused) {
                    fileChannel = channel2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileChannel = channel2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
            channel = null;
        } catch (Throwable th3) {
            th = th3;
            channel = null;
        }
    }

    public static String getCreateFileName(String str) {
        return str + sf.format(Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[PHI: r8
  0x002d: PHI (r8v5 android.database.Cursor) = (r8v4 android.database.Cursor), (r8v6 android.database.Cursor) binds: [B:20:0x0049, B:13:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L34
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L34
            if (r8 == 0) goto L2b
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L4d
            if (r9 == 0) goto L2b
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L4d
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L4d
            if (r8 == 0) goto L28
            r8.close()
        L28:
            return r9
        L29:
            r9 = move-exception
            goto L36
        L2b:
            if (r8 == 0) goto L4c
        L2d:
            r8.close()
            goto L4c
        L31:
            r9 = move-exception
            r8 = r7
            goto L4e
        L34:
            r9 = move-exception
            r8 = r7
        L36:
            java.util.Locale r10 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r11 = "getDataColumn: _data - [%s]"
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4d
            r1 = 0
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L4d
            r0[r1] = r9     // Catch: java.lang.Throwable -> L4d
            java.lang.String.format(r10, r11, r0)     // Catch: java.lang.Throwable -> L4d
            if (r8 == 0) goto L4c
            goto L2d
        L4c:
            return r7
        L4d:
            r9 = move-exception
        L4e:
            if (r8 == 0) goto L53
            r8.close()
        L53:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.FileUtils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    @SuppressLint({"NewApi"})
    public static String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    if (SdkUtils.isQ()) {
                        return context.getExternalFilesDir("").getAbsolutePath() + "/" + strArrSplit[1];
                    }
                    return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                }
            } else if (isDownloadsDocument(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (!TextUtils.isEmpty(documentId)) {
                    try {
                        return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                    } catch (NumberFormatException e2) {
                        e2.getMessage();
                        return null;
                    }
                }
            } else if (isMediaDocument(uri)) {
                String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
                String str = strArrSplit2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return getDataColumn(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return isGooglePhotosUri(uri) ? uri.getLastPathSegment() : getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static String rename(String str) {
        String strSubstring = str.substring(0, str.lastIndexOf("."));
        String strSubstring2 = str.substring(str.lastIndexOf("."));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strSubstring);
        stringBuffer.append(a.s1);
        stringBuffer.append(getCreateFileName());
        stringBuffer.append(strSubstring2);
        return stringBuffer.toString();
    }

    public static String getCreateFileName() {
        return sf.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static void copyFile(@NonNull String str, @NonNull String str2) throws Throwable {
        FileChannel channel;
        if (str.equalsIgnoreCase(str2)) {
            return;
        }
        FileChannel fileChannel = null;
        try {
            FileChannel channel2 = new FileInputStream(new File(str)).getChannel();
            try {
                channel = new FileOutputStream(new File(str2)).getChannel();
                try {
                    channel2.transferTo(0L, channel2.size(), channel);
                    channel2.close();
                    if (channel2 != null) {
                        channel2.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                } catch (Throwable th) {
                    fileChannel = channel2;
                    th = th;
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                fileChannel = channel2;
                th = th2;
                channel = null;
            }
        } catch (Throwable th3) {
            th = th3;
            channel = null;
        }
    }
}
