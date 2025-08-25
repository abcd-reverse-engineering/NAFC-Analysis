package com.airbnb.lottie.z;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NetworkCache.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final e f3990a;

    public g(@NonNull e eVar) {
        this.f3990a = eVar;
    }

    @Nullable
    private File b(String str) throws FileNotFoundException {
        File file = new File(b(), a(str, c.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(b(), a(str, c.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public void a() {
        File fileB = b();
        if (fileB.exists()) {
            File[] fileArrListFiles = fileB.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file : fileB.listFiles()) {
                    file.delete();
                }
            }
            fileB.delete();
        }
    }

    private File b() {
        File fileA = this.f3990a.a();
        if (fileA.isFile()) {
            fileA.delete();
        }
        if (!fileA.exists()) {
            fileA.mkdirs();
        }
        return fileA;
    }

    @Nullable
    @WorkerThread
    Pair<c, InputStream> a(String str) {
        c cVar;
        try {
            File fileB = b(str);
            if (fileB == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileB);
            if (fileB.getAbsolutePath().endsWith(".zip")) {
                cVar = c.ZIP;
            } else {
                cVar = c.JSON;
            }
            com.airbnb.lottie.b0.d.a("Cache hit for " + str + " at " + fileB.getAbsolutePath());
            return new Pair<>(cVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    File a(String str, InputStream inputStream, c cVar) throws IOException {
        File file = new File(b(), a(str, cVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 != -1) {
                        fileOutputStream.write(bArr, 0, i2);
                    } else {
                        fileOutputStream.flush();
                        return file;
                    }
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }

    void a(String str, c cVar) {
        File file = new File(b(), a(str, cVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        com.airbnb.lottie.b0.d.a("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        com.airbnb.lottie.b0.d.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    private static String a(String str, c cVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? cVar.tempExtension() : cVar.extension);
        return sb.toString();
    }
}
