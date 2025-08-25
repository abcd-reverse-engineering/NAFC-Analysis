package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import h.f1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class BksUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7641a = "BksUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f7642b = "com.huawei.hwid";

    /* renamed from: c, reason: collision with root package name */
    private static final String f7643c = "com.huawei.hwid";

    /* renamed from: d, reason: collision with root package name */
    private static final String f7644d = "com.huawei.hms";

    /* renamed from: e, reason: collision with root package name */
    private static final String f7645e = "com.huawei.hwid.tv";

    /* renamed from: g, reason: collision with root package name */
    private static final String f7647g = "files/hmsrootcas.bks";

    /* renamed from: h, reason: collision with root package name */
    private static final String f7648h = "4.0.2.300";

    /* renamed from: i, reason: collision with root package name */
    private static final String f7649i = "aegis";

    /* renamed from: j, reason: collision with root package name */
    private static final String f7650j = "hmsrootcas.bks";

    /* renamed from: k, reason: collision with root package name */
    private static final long f7651k = 604800000;

    /* renamed from: l, reason: collision with root package name */
    private static final String f7652l = "last_update_time";

    /* renamed from: m, reason: collision with root package name */
    private static final String f7653m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    private static final String n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    private static final String o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";
    private static final String q = "";
    private static final String r = "bks_hash";

    /* renamed from: f, reason: collision with root package name */
    private static final Uri f7646f = Uri.parse("content://com.huawei.hwid");
    private static final String[] p = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539"};

    private BksUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    private static void a(InputStream inputStream, Context context) throws Throwable {
        ?? fileOutputStream;
        if (inputStream == null || context == null) {
            return;
        }
        String strA = a(context);
        if (!new File(strA).exists()) {
            a(strA);
        }
        File file = new File(strA, "hmsrootcas.bks");
        if (file.exists()) {
            file.delete();
        }
        byte[] bArr = null;
        ?? r6 = 0;
        try {
            try {
                e.c(f7641a, "write output stream ");
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr2 = new byte[2048];
                    while (true) {
                        int i2 = inputStream.read(bArr2, 0, bArr2.length);
                        if (i2 == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr2, 0, i2);
                        }
                    }
                    d.a((OutputStream) fileOutputStream);
                    bArr = bArr2;
                } catch (IOException unused) {
                    r6 = fileOutputStream;
                    e.b(f7641a, " IOException");
                    d.a((OutputStream) r6);
                    bArr = r6;
                } catch (Throwable th) {
                    th = th;
                    d.a((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = bArr;
        }
    }

    private static boolean a(int i2) {
        return i2 >= 40002300;
    }

    private static String b(Context context) {
        return a(context) + File.separator + "hmsrootcas.bks";
    }

    private static boolean c(Context context) {
        return new File(a(context) + File.separator + "hmsrootcas.bks").exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.OutputStream] */
    public static synchronized InputStream getBksFromTss(Context context) {
        ByteArrayInputStream byteArrayInputStream;
        InputStream inputStreamOpenInputStream;
        ?? r2;
        e.c(f7641a, "get bks from tss begin");
        if (context != null) {
            ContextUtil.setContext(context);
        }
        Context contextUtil = ContextUtil.getInstance();
        ByteArrayInputStream byteArrayInputStream2 = null;
        if (contextUtil == null) {
            e.b(f7641a, "context is null");
            return null;
        }
        if (!b(f.a("com.huawei.hwid")) && !b(f.a("com.huawei.hms"))) {
            e.b(f7641a, "hms version code is too low : " + f.a("com.huawei.hwid"));
            return null;
        }
        boolean zC = c(contextUtil, "com.huawei.hwid");
        boolean z = zC;
        if (!zC) {
            boolean zB = b(contextUtil, "com.huawei.hms");
            z = zB;
            if (!zB) {
                e.b(f7641a, "hms sign error");
                return null;
            }
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStreamOpenInputStream = contextUtil.getContentResolver().openInputStream(Uri.withAppendedPath(f7646f, f7647g));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = inputStreamOpenInputStream.read(bArr);
                        if (i2 <= -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                    byteArrayOutputStream.flush();
                    byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    try {
                        String strA = g.a(r, "", contextUtil);
                        String strB = b(byteArrayOutputStream.toByteArray());
                        if (c(contextUtil) && strA.equals(strB)) {
                            e.c(f7641a, "bks not update");
                        } else {
                            e.c(f7641a, "update bks and sp");
                            a(byteArrayInputStream, contextUtil);
                            g.b(r, strB, contextUtil);
                        }
                        d.a(inputStreamOpenInputStream);
                        d.a((OutputStream) byteArrayOutputStream);
                        d.a((InputStream) byteArrayInputStream);
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayInputStream2 = byteArrayInputStream;
                        e.b(f7641a, "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
                        d.a(inputStreamOpenInputStream);
                        d.a((OutputStream) byteArrayOutputStream);
                        d.a((InputStream) byteArrayInputStream2);
                        return getFilesBksIS(contextUtil);
                    } catch (Throwable th) {
                        th = th;
                        r2 = byteArrayOutputStream;
                        d.a(inputStreamOpenInputStream);
                        d.a((OutputStream) r2);
                        d.a((InputStream) byteArrayInputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                inputStreamOpenInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStreamOpenInputStream = null;
                byteArrayInputStream = null;
                r2 = byteArrayOutputStream;
            }
            return getFilesBksIS(contextUtil);
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
            r2 = z;
        }
    }

    public static InputStream getFilesBksIS(Context context) {
        if (!c(context)) {
            return null;
        }
        e.c(f7641a, "getFilesBksIS ");
        try {
            return new FileInputStream(b(context));
        } catch (FileNotFoundException unused) {
            e.b(f7641a, "FileNotFoundExceptio: ");
            return null;
        }
    }

    private static boolean b(String str) throws NumberFormatException {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        e.c(f7641a, "hms version code is : " + str);
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = f7648h.split("\\.");
        int length = strArrSplit.length;
        int length2 = strArrSplit2.length;
        int iMax = Math.max(length, length2);
        int i3 = 0;
        while (i3 < iMax) {
            if (i3 < length) {
                try {
                    i2 = Integer.parseInt(strArrSplit[i3]);
                } catch (Exception e2) {
                    e.b(f7641a, " exception : " + e2.getMessage());
                    return i3 >= length2;
                }
            } else {
                i2 = 0;
            }
            int i4 = i3 < length2 ? Integer.parseInt(strArrSplit2[i3]) : 0;
            if (i2 < i4) {
                return false;
            }
            if (i2 > i4) {
                return true;
            }
            i3++;
        }
        return true;
    }

    private static boolean c(Context context, String str) {
        byte[] bArrA = a(context, str);
        for (String str2 : p) {
            if (str2.equalsIgnoreCase(c(bArrA))) {
                return true;
            }
        }
        return false;
    }

    private static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return a(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            String str = "NoSuchAlgorithmException" + e2.getMessage();
            return "";
        }
    }

    private static boolean b(Context context, String str) {
        return "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539".equalsIgnoreCase(c(a(context, str)));
    }

    private static String b(byte[] bArr) throws NoSuchAlgorithmException {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            e.b(f7641a, "inputstraem exception");
            return "";
        }
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            e.e(f7641a, "The directory  has already exists");
            return 1;
        }
        if (file.mkdirs()) {
            e.a(f7641a, "create directory  success");
            return 0;
        }
        e.b(f7641a, "create directory  failed");
        return -1;
    }

    private static String a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + f7649i;
        }
        return context.getApplicationContext().getFilesDir() + File.separator + f7649i;
    }

    private static byte[] a(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            String str2 = "PackageManager.NameNotFoundException : " + e2.getMessage();
        } catch (Exception e3) {
            String str3 = "get pm exception : " + e3.getMessage();
        }
        return new byte[0];
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & f1.f16099c);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
