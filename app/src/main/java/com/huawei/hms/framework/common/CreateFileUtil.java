package com.huawei.hms.framework.common;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import com.umeng.analytics.pro.cw;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public class CreateFileUtil {
    private static final String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
    private static final String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
    private static final String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
    private static final String TAG = "CreateFileUtil";

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i2] = cArr2[(b2 >>> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & cw.f10303m];
        }
        return new String(cArr);
    }

    public static void deleteSecure(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        Logger.w(TAG, "deleteSecure exception");
    }

    public static String getCacheDirPath(Context context) {
        return context == null ? "" : ContextCompat.getProtectedStorageContext(context).getCacheDir().getPath();
    }

    public static String getCanonicalPath(String str) {
        try {
            return newFile(str).getCanonicalPath();
        } catch (IOException e2) {
            Logger.w(TAG, "the canonicalPath has IOException", e2);
            return str;
        } catch (SecurityException e3) {
            Logger.w(TAG, "the canonicalPath has securityException", e3);
            return str;
        } catch (Exception e4) {
            Logger.w(TAG, "the canonicalPath has other Exception", e4);
            return str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0030 A[EXC_TOP_SPLITTER, PHI: r2 r10
  0x0030: PHI (r2v6 java.lang.String) = 
  (r2v0 java.lang.String)
  (r2v0 java.lang.String)
  (r2v0 java.lang.String)
  (r2v0 java.lang.String)
  (r2v0 java.lang.String)
  (r2v13 java.lang.String)
 binds: [B:53:0x0076, B:34:0x0050, B:39:0x005a, B:44:0x0064, B:49:0x006e, B:12:0x002e] A[DONT_GENERATE, DONT_INLINE]
  0x0030: PHI (r10v13 java.io.FileInputStream) = 
  (r10v8 java.io.FileInputStream)
  (r10v9 java.io.FileInputStream)
  (r10v10 java.io.FileInputStream)
  (r10v11 java.io.FileInputStream)
  (r10v12 java.io.FileInputStream)
  (r10v14 java.io.FileInputStream)
 binds: [B:53:0x0076, B:34:0x0050, B:39:0x005a, B:44:0x0064, B:49:0x006e, B:12:0x002e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileHashData(java.lang.String r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Close FileInputStream failed!"
            java.lang.String r1 = "CreateFileUtil"
            r2 = 0
            java.security.MessageDigest r11 = java.security.MessageDigest.getInstance(r11)     // Catch: java.lang.Throwable -> L44 java.lang.IndexOutOfBoundsException -> L47 java.lang.IllegalArgumentException -> L51 java.io.IOException -> L5b java.io.FileNotFoundException -> L65 java.security.NoSuchAlgorithmException -> L6f
            java.io.FileInputStream r10 = newSafeFileInputStream(r10)     // Catch: java.lang.Throwable -> L44 java.lang.IndexOutOfBoundsException -> L47 java.lang.IllegalArgumentException -> L51 java.io.IOException -> L5b java.io.FileNotFoundException -> L65 java.security.NoSuchAlgorithmException -> L6f
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L38 java.lang.IndexOutOfBoundsException -> L3a java.lang.IllegalArgumentException -> L3c java.io.IOException -> L3e java.io.FileNotFoundException -> L40 java.security.NoSuchAlgorithmException -> L42
            r4 = 0
            r6 = r4
        L14:
            int r8 = r10.read(r3)     // Catch: java.lang.Throwable -> L38 java.lang.IndexOutOfBoundsException -> L3a java.lang.IllegalArgumentException -> L3c java.io.IOException -> L3e java.io.FileNotFoundException -> L40 java.security.NoSuchAlgorithmException -> L42
            r9 = -1
            if (r8 == r9) goto L22
            r9 = 0
            r11.update(r3, r9, r8)     // Catch: java.lang.Throwable -> L38 java.lang.IndexOutOfBoundsException -> L3a java.lang.IllegalArgumentException -> L3c java.io.IOException -> L3e java.io.FileNotFoundException -> L40 java.security.NoSuchAlgorithmException -> L42
            long r8 = (long) r8     // Catch: java.lang.Throwable -> L38 java.lang.IndexOutOfBoundsException -> L3a java.lang.IllegalArgumentException -> L3c java.io.IOException -> L3e java.io.FileNotFoundException -> L40 java.security.NoSuchAlgorithmException -> L42
            long r6 = r6 + r8
            goto L14
        L22:
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L2e
            byte[] r11 = r11.digest()     // Catch: java.lang.Throwable -> L38 java.lang.IndexOutOfBoundsException -> L3a java.lang.IllegalArgumentException -> L3c java.io.IOException -> L3e java.io.FileNotFoundException -> L40 java.security.NoSuchAlgorithmException -> L42
            java.lang.String r2 = byteArrayToHex(r11)     // Catch: java.lang.Throwable -> L38 java.lang.IndexOutOfBoundsException -> L3a java.lang.IllegalArgumentException -> L3c java.io.IOException -> L3e java.io.FileNotFoundException -> L40 java.security.NoSuchAlgorithmException -> L42
        L2e:
            if (r10 == 0) goto L79
        L30:
            r10.close()     // Catch: java.io.IOException -> L34
            goto L79
        L34:
            com.huawei.hms.framework.common.Logger.e(r1, r0)
            goto L79
        L38:
            r11 = move-exception
            goto L7a
        L3a:
            r11 = move-exception
            goto L49
        L3c:
            r11 = move-exception
            goto L53
        L3e:
            r11 = move-exception
            goto L5d
        L40:
            r11 = move-exception
            goto L67
        L42:
            r11 = move-exception
            goto L71
        L44:
            r11 = move-exception
            r10 = r2
            goto L7a
        L47:
            r11 = move-exception
            r10 = r2
        L49:
            java.lang.String r3 = "getFileHashData IndexOutOfBoundsException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L38
            if (r10 == 0) goto L79
            goto L30
        L51:
            r11 = move-exception
            r10 = r2
        L53:
            java.lang.String r3 = "getFileHashData IllegalArgumentException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L38
            if (r10 == 0) goto L79
            goto L30
        L5b:
            r11 = move-exception
            r10 = r2
        L5d:
            java.lang.String r3 = "getFileHashData IOException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L38
            if (r10 == 0) goto L79
            goto L30
        L65:
            r11 = move-exception
            r10 = r2
        L67:
            java.lang.String r3 = "getFileHashData FileNotFoundException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L38
            if (r10 == 0) goto L79
            goto L30
        L6f:
            r11 = move-exception
            r10 = r2
        L71:
            java.lang.String r3 = "getFileHashData NoSuchAlgorithmException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L38
            if (r10 == 0) goto L79
            goto L30
        L79:
            return r2
        L7a:
            if (r10 == 0) goto L83
            r10.close()     // Catch: java.io.IOException -> L80
            goto L83
        L80:
            com.huawei.hms.framework.common.Logger.e(r1, r0)
        L83:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.CreateFileUtil.getFileHashData(java.lang.String, java.lang.String):java.lang.String");
    }

    @Deprecated
    public static boolean isPVersion() {
        return EmuiUtil.isUpPVersion();
    }

    public static File newFile(String str) {
        if (str == null) {
            return null;
        }
        return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_FILE_NAME)) ? new ExternalStorageFile(str) : new File(str);
    }

    public static FileInputStream newFileInputStream(String str) throws FileNotFoundException {
        if (str != null) {
            return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_INPUTSTREAM_NAME)) ? new ExternalStorageFileInputStream(str) : new FileInputStream(str);
        }
        Logger.w(TAG, "newFileInputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static FileOutputStream newFileOutputStream(File file) throws FileNotFoundException {
        if (file != null) {
            return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_OUTPUTSTREAM_NAME)) ? new ExternalStorageFileOutputStream(file) : new FileOutputStream(file);
        }
        Logger.e(TAG, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static RandomAccessFile newRandomAccessFile(String str, String str2) throws FileNotFoundException {
        if (str != null) {
            return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(RANDOM_ACCESS_FILE_NAME)) ? new ExternalStorageRandomAccessFile(str, str2) : new RandomAccessFile(str, str2);
        }
        Logger.w(TAG, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static File newSafeFile(String str) {
        if (str == null) {
            return null;
        }
        try {
            File fileNewFile = newFile(str);
            return !fileNewFile.exists() ? new File(str) : fileNewFile;
        } catch (RuntimeException unused) {
            Logger.w(TAG, "newFile is runtimeException");
            return new File(str);
        } catch (Throwable unused2) {
            Logger.w(TAG, "newFile is Throwable");
            return new File(str);
        }
    }

    public static FileInputStream newSafeFileInputStream(String str) throws FileNotFoundException {
        try {
            return newFileInputStream(str);
        } catch (FileNotFoundException unused) {
            Logger.w(TAG, "newFileInputStream is fileNotFoundException");
            return new FileInputStream(str);
        } catch (RuntimeException unused2) {
            Logger.w(TAG, "newFileInputStream is runtimeException");
            return new FileInputStream(str);
        } catch (Throwable unused3) {
            Logger.w(TAG, "newFileInputStream is Throwable");
            return new FileInputStream(str);
        }
    }

    public static FileOutputStream newSafeFileOutputStream(File file) throws FileNotFoundException {
        try {
            return newFileOutputStream(file);
        } catch (FileNotFoundException unused) {
            Logger.w(TAG, "newFileOutputStream is fileNotFoundException");
            return new FileOutputStream(file);
        } catch (RuntimeException unused2) {
            Logger.w(TAG, "newFileOutputStream is runtimeException");
            return new FileOutputStream(file);
        } catch (Throwable unused3) {
            Logger.w(TAG, "newFileOutputStream is Throwable");
            return new FileOutputStream(file);
        }
    }

    public static RandomAccessFile newSafeRandomAccessFile(String str, String str2) throws FileNotFoundException {
        if (str == null) {
            Logger.w(TAG, "newRandomAccessFile  file is null");
            throw new FileNotFoundException("file is null");
        }
        try {
            return newRandomAccessFile(str, str2);
        } catch (FileNotFoundException unused) {
            Logger.w(TAG, "newRandomAccessFile is fileNotFoundException");
            return new RandomAccessFile(str, str2);
        } catch (RuntimeException unused2) {
            Logger.w(TAG, "newRandomAccessFile is runtimeException");
            return new RandomAccessFile(str, str2);
        } catch (Throwable unused3) {
            Logger.w(TAG, "newRandomAccessFile is Throwable");
            return new RandomAccessFile(str, str2);
        }
    }

    public static void deleteSecure(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        deleteSecure(newFile(str));
    }
}
