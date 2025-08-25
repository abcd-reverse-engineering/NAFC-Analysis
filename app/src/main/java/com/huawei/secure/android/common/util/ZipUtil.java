package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class ZipUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7707a = "ZipUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final int f7708b = 104857600;

    /* renamed from: c, reason: collision with root package name */
    private static final int f7709c = 100;

    /* renamed from: d, reason: collision with root package name */
    private static final int f7710d = 4096;

    /* renamed from: e, reason: collision with root package name */
    private static final String f7711e = "..";

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f7712f = {"..\\", "../", "./", ".\\.\\", "%00", "..%2F", "..%5C", ".%2F"};

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
    
        r0 = "zipPath is a invalid path: " + d(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0085, code lost:
    
        r22 = r9;
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0176, code lost:
    
        com.huawei.secure.android.common.util.IOUtil.closeSecure(r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0179, code lost:
    
        if (r10 != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x017b, code lost:
    
        a(r7);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b5  */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.Closeable, java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.io.File> a(java.io.File r17, java.io.File r18, long r19, boolean r21, boolean r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.a(java.io.File, java.io.File, long, boolean, boolean):java.util.List");
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    private static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(str);
    }

    private static String d(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(iLastIndexOf + 1);
    }

    private static void e(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            c(file);
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                c(file);
                return;
            }
            for (File file2 : fileArrListFiles) {
                e(file2);
            }
            c(file);
        }
    }

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z) throws SecurityCommonException {
        return unZip(str, str2, 104857600L, 100, z);
    }

    public static List<File> unZipNew(String str, String str2, boolean z) throws SecurityCommonException {
        return unZipNew(str, str2, 104857600L, 100, z);
    }

    private static void c(File file) {
        if (file == null || file.delete()) {
            return;
        }
        LogsUtil.e(f7707a, "delete file error");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013d  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v15, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r1v9 */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean unZip(java.lang.String r17, java.lang.String r18, long r19, int r21, boolean r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.unZip(java.lang.String, java.lang.String, long, int, boolean):boolean");
    }

    public static List<File> unZipNew(String str, String str2, long j2, int i2, boolean z) throws SecurityCommonException {
        if (!a(str, str2, j2, i2)) {
            return null;
        }
        if (str2.endsWith(File.separator) && str2.length() > File.separator.length()) {
            str2 = str2.substring(0, str2.length() - File.separator.length());
        }
        return a(c(str), c(str2), j2, z, false);
    }

    private static void d(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        LogsUtil.e(f7707a, "mkdirs error , files exists or IOException.");
    }

    private static File b(String str) {
        a(str);
        return new File(str);
    }

    private static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals(f7711e)) {
            return true;
        }
        for (String str2 : f7712f) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static void a(String str) {
        if (!TextUtils.isEmpty(str) && e(str)) {
            throw new IllegalArgumentException("path is not a standard path");
        }
    }

    private static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:35:0x00c3
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @androidx.annotation.RequiresApi(api = 24)
    private static boolean a(java.lang.String r19, long r20, int r22, boolean r23) {
        /*
            r1 = r19
            r2 = r20
            r4 = r22
            java.lang.String r5 = "close zipFile IOException "
            r6 = 0
            java.lang.String r7 = "ZipUtil"
            r8 = 0
            if (r23 != 0) goto L18
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
        L13:
            r8 = r0
            goto L38
        L15:
            r0 = move-exception
            goto Lc7
        L18:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            r0.<init>()     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            java.lang.String r9 = "not a utf8 zip file, use gbk open zip file : "
            r0.append(r9)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            r0.append(r1)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            com.huawei.secure.android.common.util.LogsUtil.i(r7, r0)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            java.lang.String r9 = "GBK"
            java.nio.charset.Charset r9 = java.nio.charset.Charset.forName(r9)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            r0.<init>(r1, r9)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            goto L13
        L38:
            java.util.Enumeration r9 = r8.entries()     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            r10 = 1
            r11 = 0
            r0 = 1
            r13 = 0
        L41:
            boolean r14 = r9.hasMoreElements()     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            if (r14 == 0) goto L9f
            java.lang.Object r14 = r9.nextElement()     // Catch: java.lang.Throwable -> L15 java.lang.IllegalArgumentException -> L74 java.io.IOException -> La4
            java.util.zip.ZipEntry r14 = (java.util.zip.ZipEntry) r14     // Catch: java.lang.Throwable -> L15 java.lang.IllegalArgumentException -> L74 java.io.IOException -> La4
            long r15 = r14.getSize()     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            long r11 = r11 + r15
            int r13 = r13 + 1
            java.lang.String r15 = r14.getName()     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            boolean r15 = e(r15)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            if (r15 != 0) goto L6e
            if (r13 >= r4) goto L6e
            int r15 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r15 > 0) goto L6e
            long r14 = r14.getSize()     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            r16 = -1
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 != 0) goto L41
        L6e:
            java.lang.String r0 = "File name is invalid or too many files or too big"
            com.huawei.secure.android.common.util.LogsUtil.e(r7, r0)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            goto La0
        L74:
            r0 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            r14.<init>()     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            java.lang.String r15 = "not a utf8 zip file, IllegalArgumentException : "
            r14.append(r15)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            r14.append(r0)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            java.lang.String r0 = r14.toString()     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            com.huawei.secure.android.common.util.LogsUtil.i(r7, r0)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            r14 = 24
            if (r0 < r14) goto L98
            boolean r0 = a(r1, r2, r4, r10)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            goto L9f
        L98:
            java.lang.String r0 = "File is not a utf8 zip file and Build.VERSION_CODES < 24"
            com.huawei.secure.android.common.util.LogsUtil.e(r7, r0)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> La4
            r0 = 0
            goto L41
        L9f:
            r6 = r0
        La0:
            r8.close()     // Catch: java.io.IOException -> Lc3
            goto Lc6
        La4:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L15
            r1.<init>()     // Catch: java.lang.Throwable -> L15
            java.lang.String r2 = "not a valid zip file, IOException : "
            r1.append(r2)     // Catch: java.lang.Throwable -> L15
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L15
            r1.append(r0)     // Catch: java.lang.Throwable -> L15
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L15
            com.huawei.secure.android.common.util.LogsUtil.e(r7, r0)     // Catch: java.lang.Throwable -> L15
            if (r8 == 0) goto Lc6
            r8.close()     // Catch: java.io.IOException -> Lc3
            goto Lc6
        Lc3:
            com.huawei.secure.android.common.util.LogsUtil.e(r7, r5)
        Lc6:
            return r6
        Lc7:
            if (r8 == 0) goto Ld0
            r8.close()     // Catch: java.io.IOException -> Lcd
            goto Ld0
        Lcd:
            com.huawei.secure.android.common.util.LogsUtil.e(r7, r5)
        Ld0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.a(java.lang.String, long, int, boolean):boolean");
    }

    private static boolean a(String str, String str2, long j2, int i2) throws SecurityCommonException {
        if (!TextUtils.isEmpty(str) && !e(str)) {
            if (!TextUtils.isEmpty(str2) && !e(str2)) {
                if (a(str, j2, i2, false)) {
                    return true;
                }
                LogsUtil.e(f7707a, "zip file contains valid chars or too many files");
                throw new SecurityCommonException("unsecure zipfile!");
            }
            LogsUtil.e(f7707a, "target directory is not valid");
            return false;
        }
        LogsUtil.e(f7707a, "zip file is not valid");
        return false;
    }

    private static boolean a(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
            return true;
        } catch (Exception e2) {
            LogsUtil.e(f7707a, "unzip fail delete file failed" + e2.getMessage());
            return false;
        }
    }

    private static void a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) throws IOException {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
    }
}
