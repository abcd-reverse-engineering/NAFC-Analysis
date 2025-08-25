package com.bumptech.glide.n;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

/* compiled from: Util.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f5138a = Charset.forName(i.a.a.a.c.f16730b);

    /* renamed from: b, reason: collision with root package name */
    static final Charset f5139b = Charset.forName("UTF-8");

    private c() {
    }

    static String a(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int i2 = reader.read(cArr);
                if (i2 == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, i2);
            }
        } finally {
            reader.close();
        }
    }

    static void a(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }

    static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }
}
