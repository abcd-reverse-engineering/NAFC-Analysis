package com.umeng.socialize.net.dplus.cache1;

import android.text.TextUtils;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
public class CacheExector {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11772a = "CacheExector";

    /* renamed from: b, reason: collision with root package name */
    private final int f11773b = 32;

    /* renamed from: c, reason: collision with root package name */
    private final int f11774c = 5120;

    /* renamed from: d, reason: collision with root package name */
    private final int f11775d = 8;

    /* renamed from: e, reason: collision with root package name */
    private String f11776e;

    public CacheExector(String str) {
        this.f11776e = null;
        this.f11776e = str;
    }

    private double a(long j2) {
        if (j2 <= 0) {
            return 0.0d;
        }
        return j2 / 1024.0d;
    }

    private File a() {
        if (TextUtils.isEmpty(this.f11776e)) {
            return null;
        }
        File file = new File(this.f11776e);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        String str = "Couldn't create directory" + this.f11776e;
        return null;
    }

    private File b(File file, String str) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            return a(file, str);
        }
        File fileC = c(file, str);
        return fileC == null ? a(file, str) : fileC;
    }

    private File c(File file, String str) {
        File[] fileArrA = a(file);
        if (fileArrA == null || fileArrA.length <= 0 || fileArrA.length <= 0) {
            return null;
        }
        File file2 = fileArrA[0];
        if (a(file2.length()) > 32.0d) {
            return null;
        }
        return file2;
    }

    private File d(File file, String str) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            return null;
        }
        return e(file, str);
    }

    private File e(File file, String str) {
        File[] fileArrA = a(file);
        if (fileArrA != null && fileArrA.length > 0) {
            for (File file2 : fileArrA) {
                if (a(file2.length()) <= 40 && file2.getName().endsWith(str)) {
                    return file2;
                }
                String str2 = "getReadableFileFromFiles:file length don't legal" + file2.length();
                deleteFile(file2.getName());
            }
        }
        return null;
    }

    public double checkSize(String str) {
        File fileA = a();
        double dA = 0.0d;
        if (fileA != null && fileA.isDirectory()) {
            File[] fileArrListFiles = fileA.listFiles();
            for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                if (fileArrListFiles[i2] != null && fileArrListFiles[i2].getName().contains(str)) {
                    dA += a(fileArrListFiles[i2].length());
                }
            }
        }
        return dA;
    }

    public boolean deleteFile(String str) {
        File[] fileArrListFiles = a().listFiles();
        boolean zDelete = false;
        for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
            if (fileArrListFiles[i2] != null && fileArrListFiles[i2].getName().contains(str)) {
                zDelete = fileArrListFiles[i2].delete();
            }
        }
        return zDelete;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Class, java.lang.Class<T extends com.umeng.socialize.net.dplus.cache1.IReader>] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.Closeable, java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.umeng.socialize.net.dplus.cache1.CacheExector] */
    public <T extends IReader> T readFile(String str, Class<T> cls) throws Throwable {
        ?? r2;
        FileInputStream fileInputStreamOpenRead;
        BufferedReader bufferedReader;
        T t;
        int i2;
        File fileD = d(a(), str);
        if (fileD == null) {
            return null;
        }
        try {
            fileInputStreamOpenRead = new AtomicFile(fileD).openRead();
        } catch (IOException e2) {
            r2 = UmengText.CACHE.CACHEFILE;
            SLog.error(r2, e2);
            deleteFile(fileD.getName());
            fileInputStreamOpenRead = null;
        }
        try {
            if (fileInputStreamOpenRead == null) {
                return null;
            }
            try {
                t = (T) a(fileD.getName(), cls);
                cls = (Class<T>) new InputStreamReader(fileInputStreamOpenRead);
            } catch (IOException e3) {
                e = e3;
                cls = 0;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                cls = (Class<T>) null;
                r2 = 0;
            }
            try {
                bufferedReader = new BufferedReader(cls);
                i2 = 0;
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                r2 = 0;
                a(fileInputStreamOpenRead);
                a(cls);
                a(r2);
                throw th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    i2++;
                    String str2 = "read file:" + i2 + line;
                    if (!TextUtils.isEmpty(line)) {
                        try {
                            sb.append(line);
                        } catch (Exception e5) {
                            SLog.error(UmengText.CACHE.CACHEFILE, e5);
                        }
                    }
                }
                if (t != null) {
                    t.create(sb.toString());
                }
                a(fileInputStreamOpenRead);
                a(cls);
                a(bufferedReader);
                return t;
            } catch (IOException e6) {
                e = e6;
                SLog.error(UmengText.CACHE.CACHEFILE, e);
                a(fileInputStreamOpenRead);
                a(cls);
                a(bufferedReader);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.io.OutputStreamWriter, java.io.Writer] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.umeng.socialize.net.dplus.cache1.CacheExector] */
    public boolean save(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStreamStartWrite;
        File fileB = b(a(), str2);
        boolean z = false;
        if (fileB == null) {
            return false;
        }
        AtomicFile atomicFile = new AtomicFile(fileB);
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStreamStartWrite = atomicFile.startWrite(true);
        } catch (IOException e2) {
            e = e2;
            SLog.error(UmengText.CACHE.CACHEFILE, e);
            deleteFile(fileB.getName());
            fileOutputStreamStartWrite = null;
        }
        try {
            if (fileOutputStreamStartWrite == null) {
                return false;
            }
            try {
            } catch (IOException e3) {
                e = e3;
                e = 0;
            } catch (Throwable th) {
                th = th;
                e = 0;
            }
            if (TextUtils.isEmpty(str)) {
                e = 0;
                a(bufferedWriter);
                a(e);
                a(fileOutputStreamStartWrite);
                return z;
            }
            e = new OutputStreamWriter(fileOutputStreamStartWrite);
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(e);
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.newLine();
                    bufferedWriter2.flush();
                    atomicFile.finishWrite(fileOutputStreamStartWrite);
                    bufferedWriter = bufferedWriter2;
                    z = true;
                    e = e;
                } catch (IOException e4) {
                    e = e4;
                    bufferedWriter = bufferedWriter2;
                    atomicFile.failWrite(fileOutputStreamStartWrite);
                    SLog.error(UmengText.CACHE.CACHEFILE, e);
                    e = e;
                    a(bufferedWriter);
                    a(e);
                    a(fileOutputStreamStartWrite);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    a(bufferedWriter);
                    a(e);
                    a(fileOutputStreamStartWrite);
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
            }
            a(bufferedWriter);
            a(e);
            a(fileOutputStreamStartWrite);
            return z;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private File a(File file, String str) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        return new File(file, a(str));
    }

    private Comparator<File> b() {
        return new Comparator<File>() { // from class: com.umeng.socialize.net.dplus.cache1.CacheExector.1
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                return Long.valueOf(file.length()).compareTo(Long.valueOf(file2.length()));
            }
        };
    }

    private String a(String str) {
        return String.valueOf(System.currentTimeMillis()) + str;
    }

    private File[] a(File file) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        File[] fileArrListFiles = file.listFiles();
        Arrays.sort(fileArrListFiles, b());
        return fileArrListFiles;
    }

    private void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                SLog.error(UmengText.CACHE.CACHEFILE, e2);
            }
        }
    }

    private <T extends IReader> T a(String str, Class<T> cls) {
        try {
            return cls.getConstructor(String.class).newInstance(str);
        } catch (Throwable th) {
            SLog.error(UmengText.CACHE.CACHEFILE, th);
            return null;
        }
    }
}
