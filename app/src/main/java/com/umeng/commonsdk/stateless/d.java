package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.zip.Deflater;

/* compiled from: UMSLUtils.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static int f10863a;

    /* renamed from: b, reason: collision with root package name */
    private static Object f10864b = new Object();

    public static boolean a(long j2, long j3) {
        return j2 > j3;
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00dd A[EXC_TOP_SPLITTER, PHI: r2 r10
  0x00dd: PHI (r2v3 java.io.FileOutputStream) = (r2v2 java.io.FileOutputStream), (r2v5 java.io.FileOutputStream) binds: [B:37:0x00db, B:43:0x0104] A[DONT_GENERATE, DONT_INLINE]
  0x00dd: PHI (r10v5 boolean) = (r10v4 boolean), (r10v7 boolean) binds: [B:37:0x00db, B:43:0x0104] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r8, java.lang.String r9, java.lang.String r10, byte[] r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.b(android.content.Context, java.lang.String, java.lang.String, byte[]):boolean");
    }

    public static File[] c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f10864b) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + a.f10841f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f10864b) {
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                        Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.3
                            @Override // java.util.Comparator
                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                            public int compare(File file2, File file3) {
                                long jLastModified = file2.lastModified() - file3.lastModified();
                                if (jLastModified > 0) {
                                    return 1;
                                }
                                return jLastModified == 0 ? 0 : -1;
                            }
                        });
                        return fileArrListFiles;
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String d(String str) {
        int iLastIndexOf;
        int iLastIndexOf2;
        return (!TextUtils.isEmpty(str) && str.indexOf("envelope") < 0 && (iLastIndexOf = str.lastIndexOf(c.c.a.b.a.a.s1)) >= 0 && (iLastIndexOf2 = str.lastIndexOf(".")) >= 0) ? str.substring(iLastIndexOf + 1, iLastIndexOf2) : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0065 A[EXC_TOP_SPLITTER, PHI: r1
  0x0065: PHI (r1v2 java.io.FileOutputStream) = (r1v1 java.io.FileOutputStream), (r1v3 java.io.FileOutputStream) binds: [B:22:0x0063, B:27:0x006d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r6, java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            r0 = 101(0x65, float:1.42E-43)
            if (r6 == 0) goto L77
            r1 = 0
            java.lang.Object r2 = com.umeng.commonsdk.stateless.d.f10864b     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L69
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L69
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L5c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r4.<init>()     // Catch: java.lang.Throwable -> L5c
            java.io.File r5 = r6.getFilesDir()     // Catch: java.lang.Throwable -> L5c
            r4.append(r5)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r5 = java.io.File.separator     // Catch: java.lang.Throwable -> L5c
            r4.append(r5)     // Catch: java.lang.Throwable -> L5c
            r4.append(r7)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L5c
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L5c
            boolean r7 = r3.isDirectory()     // Catch: java.lang.Throwable -> L5c
            if (r7 != 0) goto L2e
            r3.mkdir()     // Catch: java.lang.Throwable -> L5c
        L2e:
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L5c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r4.<init>()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Throwable -> L5c
            r4.append(r3)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Throwable -> L5c
            r4.append(r3)     // Catch: java.lang.Throwable -> L5c
            r4.append(r8)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L5c
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L5c
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5c
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L5c
            r8.write(r9)     // Catch: java.lang.Throwable -> L59
            r8.close()     // Catch: java.lang.Throwable -> L59
            r0 = 0
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L5c
            goto L77
        L59:
            r7 = move-exception
            r1 = r8
            goto L5d
        L5c:
            r7 = move-exception
        L5d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L5c
            throw r7     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L69
        L5f:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)     // Catch: java.lang.Throwable -> L70
            if (r1 == 0) goto L77
        L65:
            r1.close()     // Catch: java.lang.Throwable -> L77
            goto L77
        L69:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)     // Catch: java.lang.Throwable -> L70
            if (r1 == 0) goto L77
            goto L65
        L70:
            r6 = move-exception
            if (r1 == 0) goto L76
            r1.close()     // Catch: java.lang.Throwable -> L76
        L76:
            throw r6
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.a(android.content.Context, java.lang.String, java.lang.String, byte[]):int");
    }

    public static String c(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r12) throws java.io.IOException {
        /*
            java.lang.Object r0 = com.umeng.commonsdk.stateless.d.f10864b
            monitor-enter(r0)
            r1 = 0
            r2 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            java.lang.String r4 = "r"
            r3.<init>(r12, r4)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            java.nio.channels.FileChannel r12 = r3.getChannel()     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            java.nio.channels.FileChannel$MapMode r6 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L65
            r7 = 0
            long r9 = r12.size()     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L65
            r5 = r12
            java.nio.MappedByteBuffer r2 = r5.map(r6, r7, r9)     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L65
            java.nio.MappedByteBuffer r2 = r2.load()     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L65
            long r3 = r12.size()     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L65
            int r4 = (int) r3     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L65
            byte[] r3 = new byte[r4]     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L65
            int r4 = r2.remaining()     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L65
            if (r4 <= 0) goto L35
            int r4 = r2.remaining()     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L65
            r2.get(r3, r1, r4)     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L65
        L35:
            if (r12 == 0) goto L3a
            r12.close()     // Catch: java.lang.Throwable -> L3a
        L3a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6c
            return r3
        L3c:
            r2 = move-exception
            goto L45
        L3e:
            r1 = move-exception
            r12 = r2
            goto L66
        L41:
            r12 = move-exception
            r11 = r2
            r2 = r12
            r12 = r11
        L45:
            java.lang.String r3 = "walle"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L65
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
            r5.<init>()     // Catch: java.lang.Throwable -> L65
            java.lang.String r6 = "[stateless] write envelope, e is "
            r5.append(r6)     // Catch: java.lang.Throwable -> L65
            java.lang.String r6 = r2.getMessage()     // Catch: java.lang.Throwable -> L65
            r5.append(r6)     // Catch: java.lang.Throwable -> L65
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L65
            r4[r1] = r5     // Catch: java.lang.Throwable -> L65
            com.umeng.commonsdk.statistics.common.ULog.i(r3, r4)     // Catch: java.lang.Throwable -> L65
            throw r2     // Catch: java.lang.Throwable -> L65
        L65:
            r1 = move-exception
        L66:
            if (r12 == 0) goto L6b
            r12.close()     // Catch: java.lang.Throwable -> L6b
        L6b:
            throw r1     // Catch: java.lang.Throwable -> L6c
        L6c:
            r12 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6c
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.a(java.lang.String):byte[]");
    }

    public static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f10864b) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + a.f10841f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f10864b) {
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                        Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.2
                            @Override // java.util.Comparator
                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                            public int compare(File file2, File file3) {
                                long jLastModified = file2.lastModified() - file3.lastModified();
                                if (jLastModified > 0) {
                                    return 1;
                                }
                                return jLastModified == 0 ? 0 : -1;
                            }
                        });
                        return fileArrListFiles[0];
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static File a(Context context) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        File file = null;
        try {
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        synchronized (f10864b) {
            try {
                ULog.i("walle", "get last envelope begin, thread is " + Thread.currentThread());
                if (context != null && context.getApplicationContext() != null) {
                    String str = context.getApplicationContext().getFilesDir() + File.separator + a.f10840e;
                    if (!TextUtils.isEmpty(str)) {
                        File file2 = new File(str);
                        if (file2.isDirectory() && (fileArrListFiles = file2.listFiles()) != null && fileArrListFiles.length > 0) {
                            File file3 = null;
                            for (File file4 : fileArrListFiles) {
                                try {
                                    if (file4 != null && file4.isDirectory() && (fileArrListFiles2 = file4.listFiles()) != null && fileArrListFiles2.length > 0) {
                                        Arrays.sort(fileArrListFiles2, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.1
                                            @Override // java.util.Comparator
                                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                                            public int compare(File file5, File file6) {
                                                long jLastModified = file5.lastModified() - file6.lastModified();
                                                if (jLastModified > 0) {
                                                    return 1;
                                                }
                                                return jLastModified == 0 ? 0 : -1;
                                            }
                                        });
                                        File file5 = fileArrListFiles2[0];
                                        if (file5 != null && (file3 == null || file3.lastModified() > file5.lastModified())) {
                                            file3 = file5;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    file = file3;
                                    throw th;
                                }
                            }
                            file = file3;
                        }
                    }
                }
                ULog.i("walle", "get last envelope end, thread is " + Thread.currentThread());
                return file;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(b2)));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context, boolean z) {
        String str;
        String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (z) {
                str = context.getApplicationContext().getFilesDir() + File.separator + a.f10840e;
            } else {
                str = context.getApplicationContext().getFilesDir() + File.separator + a.f10841f;
            }
            str2 = str;
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void a(Context context, String str, int i2) {
        try {
            if (str == null) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            File file = new File(str);
            if (!file.isDirectory()) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            synchronized (f10864b) {
                File[] fileArrListFiles = file.listFiles();
                ULog.i("AmapLBS", "[lbs-build] delete file begin " + fileArrListFiles.length + ", thread is " + Thread.currentThread());
                if (fileArrListFiles != null && fileArrListFiles.length >= i2) {
                    ULog.i("AmapLBS", "[lbs-build] file size >= max");
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : fileArrListFiles) {
                        if (file2 != null) {
                            arrayList.add(file2);
                        }
                    }
                    if (arrayList.size() >= i2) {
                        Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.4
                            @Override // java.util.Comparator
                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                            public int compare(File file3, File file4) {
                                if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                    return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                }
                                return -1;
                            }
                        });
                        if (ULog.DEBUG) {
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i3)).getPath());
                            }
                        }
                        for (int i4 = 0; i4 <= arrayList.size() - i2; i4++) {
                            if (arrayList.get(i4) != null) {
                                ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i4)).getPath());
                                try {
                                    ((File) arrayList.get(i4)).delete();
                                    arrayList.remove(i4);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                } else {
                    ULog.i("AmapLBS", "[lbs-build] file size < max");
                }
                ULog.i("AmapLBS", "[lbs-build] delete file end " + fileArrListFiles.length + ", thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void a(Context context, String str, final String str2, int i2) {
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.isDirectory()) {
                synchronized (f10864b) {
                    File[] fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: com.umeng.commonsdk.stateless.d.5
                        @Override // java.io.FilenameFilter
                        public boolean accept(File file2, String str3) {
                            return str3.startsWith(str2);
                        }
                    });
                    if (fileArrListFiles != null && fileArrListFiles.length >= i2) {
                        ULog.i("AmapLBS", "[lbs-build] file size >= max");
                        ArrayList arrayList = new ArrayList();
                        for (File file2 : fileArrListFiles) {
                            if (file2 != null) {
                                arrayList.add(file2);
                            }
                        }
                        if (arrayList.size() >= i2) {
                            Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.6
                                @Override // java.util.Comparator
                                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                                public int compare(File file3, File file4) {
                                    if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                        return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                    }
                                    return -1;
                                }
                            });
                            if (ULog.DEBUG) {
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i3)).getPath());
                                }
                            }
                            for (int i4 = 0; i4 <= arrayList.size() - i2; i4++) {
                                if (arrayList.get(i4) != null) {
                                    ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i4)).getPath());
                                    try {
                                        ((File) arrayList.get(i4)).delete();
                                        arrayList.remove(i4);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    } else {
                        ULog.i("AmapLBS", "[lbs-build] file size < max");
                    }
                    ULog.i("AmapLBS", "[lbs-build] delete file end " + fileArrListFiles.length + ", thread is " + Thread.currentThread());
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static byte[] a(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        f10863a = 0;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int iDeflate = deflater.deflate(bArr2);
                    f10863a += iDeflate;
                    byteArrayOutputStream.write(bArr2, 0, iDeflate);
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
            deflater.end();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }
}
