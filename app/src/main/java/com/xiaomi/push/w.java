package com.xiaomi.push;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes2.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f13485a = {"jpg", "png", "bmp", "gif", "webp"};

    public static void a(File file, File file2) throws Throwable {
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file, false));
            } catch (FileNotFoundException unused) {
            } catch (IOException e2) {
                e = e2;
            }
            try {
                a(zipOutputStream, file2, null, null);
                a(zipOutputStream);
            } catch (FileNotFoundException unused2) {
                zipOutputStream2 = zipOutputStream;
                a(zipOutputStream2);
            } catch (IOException e3) {
                e = e3;
                zipOutputStream2 = zipOutputStream;
                com.xiaomi.channel.commonutils.logger.b.m50a("zip file failure + " + e.getMessage());
                a(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream2 = zipOutputStream;
                a(zipOutputStream2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void b(File file, File file2) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 < 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public static void a(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) throws Throwable {
        FileInputStream fileInputStream;
        File[] fileArrListFiles;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                if (file.isDirectory()) {
                    if (fileFilter != null) {
                        fileArrListFiles = file.listFiles(fileFilter);
                    } else {
                        fileArrListFiles = file.listFiles();
                    }
                    zipOutputStream.putNextEntry(new ZipEntry(str + File.separator));
                    if (!TextUtils.isEmpty(str)) {
                        str2 = str + File.separator;
                    }
                    for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                        a(zipOutputStream, fileArrListFiles[i2], str2 + fileArrListFiles[i2].getName(), null);
                    }
                    File[] fileArrListFiles2 = file.listFiles(new FileFilter() { // from class: com.xiaomi.push.w.1
                        @Override // java.io.FileFilter
                        public boolean accept(File file2) {
                            return file2.isDirectory();
                        }
                    });
                    if (fileArrListFiles2 != null) {
                        for (File file2 : fileArrListFiles2) {
                            a(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
                        }
                    }
                    fileInputStream = null;
                } else {
                    if (!TextUtils.isEmpty(str)) {
                        zipOutputStream.putNextEntry(new ZipEntry(str));
                    } else {
                        zipOutputStream.putNextEntry(new ZipEntry(String.valueOf(new Date().getTime()) + ".txt"));
                    }
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i3 = fileInputStream.read(bArr);
                            if (i3 == -1) {
                                break;
                            } else {
                                zipOutputStream.write(bArr, 0, i3);
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        fileInputStream2 = fileInputStream;
                        com.xiaomi.channel.commonutils.logger.b.d("zipFiction failed with exception:" + e.toString());
                        a((Closeable) fileInputStream2);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        a((Closeable) fileInputStream2);
                        throw th;
                    }
                }
                a((Closeable) fileInputStream);
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static String a(File file) throws Throwable {
        InputStreamReader inputStreamReader;
        StringWriter stringWriter = new StringWriter();
        try {
            try {
                inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
            } catch (IOException e2) {
                e = e2;
                inputStreamReader = null;
            } catch (Throwable th) {
                th = th;
                a((Closeable) null);
                a(stringWriter);
                throw th;
            }
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int i2 = inputStreamReader.read(cArr);
                    if (i2 != -1) {
                        stringWriter.write(cArr, 0, i2);
                    } else {
                        String string = stringWriter.toString();
                        a(inputStreamReader);
                        a(stringWriter);
                        return string;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                com.xiaomi.channel.commonutils.logger.b.c("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                a(inputStreamReader);
                a(stringWriter);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            a((Closeable) null);
            a(stringWriter);
            throw th;
        }
    }

    public static void a(File file, String str) throws Throwable {
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.c("mkdir " + file.getAbsolutePath());
            file.getParentFile().mkdirs();
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter2.write(str);
                    a(bufferedWriter2);
                } catch (IOException e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    com.xiaomi.channel.commonutils.logger.b.c("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    a(bufferedWriter);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    a(bufferedWriter);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                try {
                    int i2 = inputStream.read(bArr, 0, 8192);
                    if (i2 <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    byteArray = null;
                }
            } finally {
                a((Closeable) inputStream);
                a(byteArrayOutputStream);
            }
        }
        byteArray = byteArrayOutputStream.toByteArray();
        return byteArray;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m765a(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static byte[] a(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception unused) {
            return bArr;
        }
    }
}
