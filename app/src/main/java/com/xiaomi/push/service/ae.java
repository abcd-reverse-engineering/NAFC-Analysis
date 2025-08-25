package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    private static long f13319a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f975a = false;

    /* renamed from: b, reason: collision with root package name */
    private static long f13320b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f13321a;

        /* renamed from: a, reason: collision with other field name */
        byte[] f976a;

        public a(byte[] bArr, int i2) {
            this.f976a = bArr;
            this.f13321a = i2;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f13322a;

        /* renamed from: a, reason: collision with other field name */
        public Bitmap f977a;

        public b(Bitmap bitmap, long j2) {
            this.f977a = bitmap;
            this.f13322a = j2;
        }
    }

    public static b a(Context context, String str, boolean z) throws Throwable {
        Bitmap bitmapB;
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0L);
        try {
            try {
                bitmapB = b(context, str);
            } catch (Exception e2) {
                e = e2;
            }
            if (bitmapB != null) {
                bVar.f977a = bitmapB;
                com.xiaomi.push.w.a((Closeable) null);
                return bVar;
            }
            a aVarA = a(str, z);
            if (aVarA == null) {
                com.xiaomi.push.w.a((Closeable) null);
                return bVar;
            }
            bVar.f13322a = aVarA.f13321a;
            byte[] bArr = aVarA.f976a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int iA = a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = iA;
                        bVar.f977a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e3) {
                        e = e3;
                        byteArrayInputStream = byteArrayInputStream2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        com.xiaomi.push.w.a((Closeable) byteArrayInputStream);
                        return bVar;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayInputStream = byteArrayInputStream2;
                        com.xiaomi.push.w.a((Closeable) byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.f977a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            a(context, aVarA.f976a, str);
            com.xiaomi.push.w.a((Closeable) byteArrayInputStream);
            return bVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static synchronized Bitmap b(Context context, String str) {
        Bitmap bitmap;
        File file;
        FileInputStream fileInputStream = null;
        Bitmap bitmapDecodeStream = null;
        try {
            file = new File(a(context), com.xiaomi.push.bb.a(str));
        } catch (Throwable th) {
            th = th;
            bitmap = null;
        }
        if (!file.exists()) {
            return null;
        }
        if (System.currentTimeMillis() - file.lastModified() > 1209600000) {
            com.xiaomi.channel.commonutils.logger.b.m50a("The pic cache has expired.");
            return null;
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream2);
            file.setLastModified(System.currentTimeMillis());
            com.xiaomi.push.w.a((Closeable) fileInputStream2);
            bitmap = bitmapDecodeStream;
        } catch (Throwable th2) {
            Bitmap bitmap2 = bitmapDecodeStream;
            fileInputStream = fileInputStream2;
            th = th2;
            bitmap = bitmap2;
            try {
                com.xiaomi.channel.commonutils.logger.b.d("Load bmp from cache error: " + th);
                return bitmap;
            } finally {
                com.xiaomi.push.w.a((Closeable) fileInputStream);
            }
        }
        return bitmap;
    }

    private static synchronized void b(Context context) {
        String str;
        File file;
        if (f975a) {
            return;
        }
        f13319a = 0L;
        f13320b = 0L;
        try {
            file = new File(a(context));
        } catch (Throwable th) {
            try {
                com.xiaomi.channel.commonutils.logger.b.d("Init pic cache error: " + th);
                f975a = true;
                str = "Init pic cache finish.";
            } finally {
                f975a = true;
                com.xiaomi.channel.commonutils.logger.b.b("Init pic cache finish.");
            }
        }
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    f13319a += file2.length();
                    if (f13320b <= 0) {
                        f13320b = file2.lastModified();
                    } else {
                        f13320b = Math.min(f13320b, file2.lastModified());
                    }
                }
            }
            f975a = true;
            str = "Init pic cache finish.";
            com.xiaomi.channel.commonutils.logger.b.b(str);
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0106: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:64:0x0106 */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e4 A[PHI: r1
  0x00e4: PHI (r1v5 java.net.HttpURLConnection) = (r1v4 java.net.HttpURLConnection), (r1v6 java.net.HttpURLConnection) binds: [B:55:0x00e2, B:60:0x0101] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.xiaomi.push.service.ae.a a(java.lang.String r10, boolean r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ae.a(java.lang.String, boolean):com.xiaomi.push.service.ae$a");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static Bitmap a(Context context, String str) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStreamOpenInputStream2;
        int iA;
        Uri uri = Uri.parse(str);
        try {
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    iA = a((Context) context, inputStreamOpenInputStream);
                    inputStreamOpenInputStream2 = context.getContentResolver().openInputStream(uri);
                } catch (IOException e2) {
                    e = e2;
                    inputStreamOpenInputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    context = 0;
                    com.xiaomi.push.w.a((Closeable) context);
                    com.xiaomi.push.w.a((Closeable) inputStreamOpenInputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                inputStreamOpenInputStream2 = null;
                inputStreamOpenInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                context = 0;
                inputStreamOpenInputStream = null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = iA;
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options);
                com.xiaomi.push.w.a((Closeable) inputStreamOpenInputStream2);
                com.xiaomi.push.w.a((Closeable) inputStreamOpenInputStream);
                return bitmapDecodeStream;
            } catch (IOException e4) {
                e = e4;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.w.a((Closeable) inputStreamOpenInputStream2);
                com.xiaomi.push.w.a((Closeable) inputStreamOpenInputStream);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        int i2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth != -1 && options.outHeight != -1) {
            int iRound = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
            int i3 = options.outWidth;
            if (i3 <= iRound || (i2 = options.outHeight) <= iRound) {
                return 1;
            }
            return Math.min(i3 / iRound, i2 / iRound);
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("decode dimension failed for bitmap.");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.FileOutputStream, java.io.OutputStream] */
    private static void a(Context context, byte[] bArr, String str) throws Throwable {
        if (bArr == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("cannot save small icon cause bitmap is null");
            return;
        }
        m676a(context);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                File file = new File(a(context));
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, com.xiaomi.push.bb.a((String) str));
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                str = new FileOutputStream(file2);
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(str);
                    try {
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.flush();
                        f13319a += file2.length();
                        if (f13320b <= 0) {
                            f13320b = file2.lastModified();
                        } else {
                            f13320b = Math.min(f13320b, file2.lastModified());
                        }
                        com.xiaomi.push.w.a(bufferedOutputStream2);
                        str = str;
                    } catch (Exception e2) {
                        e = e2;
                        bufferedOutputStream = bufferedOutputStream2;
                        com.xiaomi.channel.commonutils.logger.b.d("Save pic error: " + e);
                        com.xiaomi.push.w.a(bufferedOutputStream);
                        str = str;
                        com.xiaomi.push.w.a((Closeable) str);
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        com.xiaomi.push.w.a(bufferedOutputStream);
                        com.xiaomi.push.w.a((Closeable) str);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                str = 0;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
            }
            com.xiaomi.push.w.a((Closeable) str);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static synchronized void m676a(Context context) {
        File file;
        long jLastModified;
        b(context);
        if (f13319a >= 62914560 || System.currentTimeMillis() - f13320b >= 1209600000) {
            try {
                file = new File(a(context));
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("Clear pic cache error: " + th);
            }
            if (!file.exists()) {
                com.xiaomi.channel.commonutils.logger.b.m50a("The pic cache dir do not exists.");
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                a(fileArrListFiles);
                long length = f13319a;
                int length2 = fileArrListFiles.length - 1;
                while (true) {
                    if (length2 < 0) {
                        jLastModified = 0;
                        break;
                    }
                    File file2 = fileArrListFiles[length2];
                    if (file2 != null) {
                        if (length <= 31457280 && System.currentTimeMillis() - file2.lastModified() <= 864000000) {
                            jLastModified = file2.lastModified();
                            break;
                        }
                        length -= file2.length();
                        file2.delete();
                    }
                    length2--;
                }
                f13319a = Math.max(length, 0L);
                f13320b = jLastModified;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m50a("The pic cache file list is null.");
            }
        }
    }

    private static void a(File[] fileArr) {
        if (fileArr != null) {
            try {
                if (fileArr.length > 1) {
                    Arrays.sort(fileArr, new Comparator<File>() { // from class: com.xiaomi.push.service.ae.1
                        @Override // java.util.Comparator
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            if (file == file2) {
                                return 0;
                            }
                            if (file == null) {
                                return 1;
                            }
                            if (file2 == null) {
                                return -1;
                            }
                            long jLastModified = file.lastModified() - file2.lastModified();
                            if (jLastModified == 0) {
                                return 0;
                            }
                            return jLastModified < 0 ? 1 : -1;
                        }
                    });
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("Sort pic cache error: " + th);
            }
        }
    }

    private static String a(Context context) {
        return context.getCacheDir().getPath() + File.separator + "mipush_icon";
    }
}
