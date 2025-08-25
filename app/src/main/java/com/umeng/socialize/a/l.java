package com.umeng.socialize.a;

import com.umeng.commonsdk.debug.UMRTLog;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: UMZipUtils.java */
/* loaded from: classes2.dex */
public class l {
    public static void a(byte[] bArr, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream2.write(bArr);
                c.a(gZIPOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    UMRTLog.e("zip", th.getMessage());
                } finally {
                    c.a(gZIPOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void b(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream = null;
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr));
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int i2 = gZIPInputStream2.read(bArr2);
                    if (i2 == -1) {
                        c.a(gZIPInputStream2);
                        return;
                    }
                    outputStream.write(bArr2, 0, i2);
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                try {
                    UMRTLog.e("unzip", th.getMessage());
                } finally {
                    c.a(gZIPInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
