package k.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import cn.cloudwalk.libproject.util.FileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FileUtil.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static FileOutputStream f17022a;

    /* renamed from: b, reason: collision with root package name */
    private static FileInputStream f17023b;

    /* renamed from: c, reason: collision with root package name */
    private static Properties f17024c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile String f17025d;

    /* renamed from: e, reason: collision with root package name */
    private static AtomicBoolean f17026e = new AtomicBoolean(false);

    public static boolean a(File file) {
        File[] fileArrListFiles;
        k.a.a.a.j.e.b(FileUtil.TAG, "deleteFile : file.getName", true);
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
        }
        return file.delete();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0084, code lost:
    
        r3 = com.hihonor.honorid.d.a.b.a(r9, r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[Catch: all -> 0x00f0, DONT_GENERATE, FINALLY_INSNS, SYNTHETIC, TRY_LEAVE, TryCatch #10 {, blocks: (B:17:0x005b, B:21:0x0068, B:23:0x006c, B:19:0x005f, B:34:0x008e, B:38:0x009b, B:40:0x009f, B:36:0x0092, B:46:0x00b2, B:50:0x00bf, B:61:0x00de, B:48:0x00b6, B:67:0x00ec, B:73:0x00fb, B:76:0x0106, B:75:0x00ff, B:71:0x00f2, B:55:0x00cd, B:59:0x00da, B:57:0x00d1, B:44:0x00a9, B:53:0x00c4), top: B:93:0x0005, inners: #1, #3, #5, #6, #7, #9, #11, #12, #13, #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.lang.String b(android.content.Context r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.c.b(android.content.Context, java.lang.String):java.lang.String");
    }

    public static void c(Context context, String str) {
        f17025d = str;
        b(context, "encryptversion", str);
    }

    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(context.getFilesDir(), str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r7, java.lang.String r8, byte[] r9) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "IOException "
            java.lang.String r1 = "FileUtil"
            r2 = 0
            if (r7 == 0) goto L98
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            if (r3 != 0) goto L98
            if (r8 == 0) goto L98
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto L98
            if (r9 != 0) goto L19
            goto L98
        L19:
            r3 = 0
            r4 = 1
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            boolean r6 = r5.exists()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            if (r6 != 0) goto L2f
            boolean r5 = r5.mkdirs()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            if (r5 != 0) goto L2f
            return r2
        L2d:
            r7 = move-exception
            goto L8e
        L2f:
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r6.<init>()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r6.append(r7)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r6.append(r8)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            java.lang.String r7 = r6.toString()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r7.write(r9)     // Catch: java.lang.Exception -> L50 java.lang.RuntimeException -> L5c java.io.IOException -> L6c java.io.FileNotFoundException -> L7c java.lang.Throwable -> L8b
            r7.close()     // Catch: java.io.IOException -> L67
            goto L6a
        L4f:
            r7 = r3
        L50:
            java.lang.String r8 = "Exception "
            k.a.a.a.j.e.a(r1, r8, r4)     // Catch: java.lang.Throwable -> L8b
            if (r7 == 0) goto L6a
            r7.close()     // Catch: java.io.IOException -> L67
            goto L6a
        L5b:
            r7 = r3
        L5c:
            java.lang.String r8 = "RuntimeException "
            k.a.a.a.j.e.a(r1, r8, r4)     // Catch: java.lang.Throwable -> L8b
            if (r7 == 0) goto L6a
            r7.close()     // Catch: java.io.IOException -> L67
            goto L6a
        L67:
            k.a.a.a.j.e.a(r1, r0, r4)
        L6a:
            return r4
        L6b:
            r7 = r3
        L6c:
            java.lang.String r8 = "writeAgreement IOException"
            k.a.a.a.j.e.a(r1, r8, r4)     // Catch: java.lang.Throwable -> L8b
            if (r7 == 0) goto L7a
            r7.close()     // Catch: java.io.IOException -> L77
            goto L7a
        L77:
            k.a.a.a.j.e.a(r1, r0, r4)
        L7a:
            return r2
        L7b:
            r7 = r3
        L7c:
            java.lang.String r8 = "writeAgreement FileNotFoundException"
            k.a.a.a.j.e.a(r1, r8, r4)     // Catch: java.lang.Throwable -> L8b
            if (r7 == 0) goto L8a
            r7.close()     // Catch: java.io.IOException -> L87
            goto L8a
        L87:
            k.a.a.a.j.e.a(r1, r0, r4)
        L8a:
            return r2
        L8b:
            r8 = move-exception
            r3 = r7
            r7 = r8
        L8e:
            if (r3 == 0) goto L97
            r3.close()     // Catch: java.io.IOException -> L94
            goto L97
        L94:
            k.a.a.a.j.e.a(r1, r0, r4)
        L97:
            throw r7
        L98:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.c.a(java.lang.String, java.lang.String, byte[]):boolean");
    }

    public static String a(Context context) {
        if (f17026e.compareAndSet(false, true)) {
            f17025d = b(context, "encryptversion");
        }
        return f17025d;
    }

    private static void a(Context context, String str, String str2) throws IOException {
        String strB;
        File filesDir = context.getFilesDir();
        if (filesDir == null || filesDir.getPath() == null) {
            return;
        }
        if (new File(filesDir.getPath() + "/settings.properties").exists()) {
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput("settings.properties");
            f17023b = fileInputStreamOpenFileInput;
            if (fileInputStreamOpenFileInput != null) {
                f17024c.load(fileInputStreamOpenFileInput);
            } else {
                k.a.a.a.j.e.b(FileUtil.TAG, "inStream is null", true);
            }
        }
        f17022a = context.openFileOutput("settings.properties", 0);
        String[] strArrA = c.c.a.b.a.b.a();
        int length = strArrA.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                strB = str2;
                break;
            } else {
                if (str.equals(strArrA[i2])) {
                    strB = com.hihonor.honorid.d.a.b.b(context, str2);
                    break;
                }
                i2++;
            }
        }
        int i3 = 0;
        while (strB.length() > 8388588 && i3 < 3) {
            i3++;
            k.a.a.a.j.e.b(FileUtil.TAG, i3 + " mValue.length() is " + strB.length(), true);
            int length2 = strArrA.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    break;
                }
                if (str.equals(strArrA[i4])) {
                    strB = com.hihonor.honorid.d.a.b.b(context, str2);
                    break;
                }
                i4++;
            }
        }
        if (strB.length() > 8388588) {
            k.a.a.a.j.e.a(FileUtil.TAG, "final mValue.length() is " + strB.length(), true);
            return;
        }
        f17024c.setProperty(str, strB);
        FileOutputStream fileOutputStream = f17022a;
        if (fileOutputStream != null) {
            f17024c.store(fileOutputStream, "accountagent");
        } else {
            k.a.a.a.j.e.b(FileUtil.TAG, "outStream is null", true);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:33:0x005a
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static synchronized void b(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.Class<k.a.a.a.c> r0 = k.a.a.a.c.class
            monitor-enter(r0)
            r1 = 1
            if (r3 == 0) goto L86
            if (r5 == 0) goto L86
            if (r4 != 0) goto Lc
            goto L86
        Lc:
            r2 = 0
            k.a.a.a.c.f17022a = r2     // Catch: java.lang.Throwable -> L8f
            k.a.a.a.c.f17023b = r2     // Catch: java.lang.Throwable -> L8f
            java.util.Properties r2 = new java.util.Properties     // Catch: java.lang.Throwable -> L8f
            r2.<init>()     // Catch: java.lang.Throwable -> L8f
            k.a.a.a.c.f17024c = r2     // Catch: java.lang.Throwable -> L8f
            a(r3, r4, r5)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            java.io.FileOutputStream r3 = k.a.a.a.c.f17022a     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L8f
            if (r3 == 0) goto L2c
            java.io.FileOutputStream r3 = k.a.a.a.c.f17022a     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L8f
            r3.close()     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L8f
            goto L2c
        L25:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "setProperties IOException"
            k.a.a.a.j.e.a(r3, r4, r1)     // Catch: java.lang.Throwable -> L8f
        L2c:
            java.io.FileInputStream r3 = k.a.a.a.c.f17023b     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            if (r3 == 0) goto L61
            java.io.FileInputStream r3 = k.a.a.a.c.f17023b     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            r3.close()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            goto L61
        L36:
            r3 = move-exception
            goto L63
        L38:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "IOException"
            k.a.a.a.j.e.a(r3, r4, r1)     // Catch: java.lang.Throwable -> L36
            java.io.FileOutputStream r3 = k.a.a.a.c.f17022a     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L8f
            if (r3 == 0) goto L50
            java.io.FileOutputStream r3 = k.a.a.a.c.f17022a     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L8f
            r3.close()     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L8f
            goto L50
        L49:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "setProperties IOException"
            k.a.a.a.j.e.a(r3, r4, r1)     // Catch: java.lang.Throwable -> L8f
        L50:
            java.io.FileInputStream r3 = k.a.a.a.c.f17023b     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            if (r3 == 0) goto L61
            java.io.FileInputStream r3 = k.a.a.a.c.f17023b     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            r3.close()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            goto L61
        L5a:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "IOException"
            k.a.a.a.j.e.a(r3, r4, r1)     // Catch: java.lang.Throwable -> L8f
        L61:
            monitor-exit(r0)
            return
        L63:
            java.io.FileOutputStream r4 = k.a.a.a.c.f17022a     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8f
            if (r4 == 0) goto L74
            java.io.FileOutputStream r4 = k.a.a.a.c.f17022a     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8f
            r4.close()     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8f
            goto L74
        L6d:
            java.lang.String r4 = "FileUtil"
            java.lang.String r5 = "setProperties IOException"
            k.a.a.a.j.e.a(r4, r5, r1)     // Catch: java.lang.Throwable -> L8f
        L74:
            java.io.FileInputStream r4 = k.a.a.a.c.f17023b     // Catch: java.io.IOException -> L7e java.lang.Throwable -> L8f
            if (r4 == 0) goto L85
            java.io.FileInputStream r4 = k.a.a.a.c.f17023b     // Catch: java.io.IOException -> L7e java.lang.Throwable -> L8f
            r4.close()     // Catch: java.io.IOException -> L7e java.lang.Throwable -> L8f
            goto L85
        L7e:
            java.lang.String r4 = "FileUtil"
            java.lang.String r5 = "IOException"
            k.a.a.a.j.e.a(r4, r5, r1)     // Catch: java.lang.Throwable -> L8f
        L85:
            throw r3     // Catch: java.lang.Throwable -> L8f
        L86:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "at least 1 param is null"
            k.a.a.a.j.e.b(r3, r4, r1)     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r0)
            return
        L8f:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.c.b(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void a(XmlSerializer xmlSerializer, String str, String str2) throws IllegalStateException, IOException, IllegalArgumentException {
        try {
            xmlSerializer.startTag("", str);
            xmlSerializer.text(str2);
            xmlSerializer.endTag("", str);
        } catch (IOException unused) {
            k.a.a.a.j.e.a(FileUtil.TAG, "IOException ", true);
        } catch (IllegalArgumentException unused2) {
            k.a.a.a.j.e.a(FileUtil.TAG, "IllegalArgumentException  ", true);
        } catch (IllegalStateException unused3) {
            k.a.a.a.j.e.a(FileUtil.TAG, "IllegalStateException ", true);
        } catch (Exception unused4) {
            k.a.a.a.j.e.a(FileUtil.TAG, "Exception ", true);
        }
    }
}
