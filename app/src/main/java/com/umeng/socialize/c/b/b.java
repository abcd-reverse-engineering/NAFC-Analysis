package com.umeng.socialize.c.b;

import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: FileUtil.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f11649a = new b();

    private b() {
    }

    public static b a() {
        return f11649a;
    }

    public File b() throws IOException {
        File file = new File(c(), d());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        return file;
    }

    public File c() {
        File file = new File(ContextUtil.getContext().getExternalFilesDir(null), c.f11650a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public String d() {
        return SocializeUtils.hexdigest(String.valueOf(System.currentTimeMillis())) + ".jpg";
    }

    public byte[] a(File file) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, i2);
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    try {
                        fileInputStream.close();
                        byteArrayOutputStream2.close();
                    } catch (IOException e2) {
                        SLog.error(UmengText.IMAGE.CLOSE, e2);
                    }
                    return byteArray;
                } catch (Throwable th) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th;
                    try {
                        SLog.error(UmengText.IMAGE.READ_IMAGE_ERROR, th);
                        if (fileInputStream != null) {
                            try {
                            } catch (IOException e3) {
                                return DefaultClass.getBytes();
                            }
                        }
                        return DefaultClass.getBytes();
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e32) {
                                SLog.error(UmengText.IMAGE.CLOSE, e32);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }
}
