package com.tencent.open.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import cn.cloudwalk.util.LogUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, com.tencent.a.a.a> f9933a = new ConcurrentHashMap<>();

    public static String a(int i2) {
        if (i2 == 10103) {
            return "shareToQQ";
        }
        if (i2 == 10104) {
            return "shareToQzone";
        }
        if (i2 == 10105) {
            return "addToQQFavorites";
        }
        if (i2 == 10106) {
            return "sendToMyComputer";
        }
        if (i2 == 10107) {
            return "shareToTroopBar";
        }
        if (i2 == 11101) {
            return "action_login";
        }
        if (i2 == 10100) {
            return "action_request";
        }
        if (i2 != 10114) {
            return null;
        }
        return "action_common_channel";
    }

    public static void a() {
        f9933a.clear();
    }

    public static String b(Context context, String str) throws NoSuchAlgorithmException {
        String strA = "";
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(signatureArr[0].toByteArray());
            String strA2 = m.a(messageDigest.digest());
            messageDigest.reset();
            SLog.v("openSDK_LOG.SystemUtils", "-->sign: " + strA2);
            messageDigest.update(m.j(packageName + c.c.a.b.a.a.s1 + strA2 + c.c.a.b.a.a.s1 + str + ""));
            strA = m.a(messageDigest.digest());
            messageDigest.reset();
            StringBuilder sb = new StringBuilder();
            sb.append("-->signEncryped: ");
            sb.append(strA);
            SLog.v("openSDK_LOG.SystemUtils", sb.toString());
            return strA;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e2);
            return strA;
        }
    }

    public static int c(Context context, String str) {
        return a(a(context, "com.tencent.mobileqq"), str);
    }

    public static int d(Context context, String str) {
        return a(a(context, Constants.PACKAGE_TIM), str);
    }

    private static PackageInfo e(Context context, String str) {
        if (context == null || str == null) {
            return null;
        }
        synchronized (k.class) {
            if (!f9933a.containsKey(str)) {
                PackageInfo packageInfoF = f(context, str);
                f9933a.put(str, new com.tencent.a.a.a(str, packageInfoF));
                return packageInfoF;
            }
            com.tencent.a.a.a aVar = f9933a.get(str);
            if (aVar == null) {
                SLog.e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper is null");
                return null;
            }
            PackageInfo packageInfo = aVar.f8737b;
            if (packageInfo == null) {
                SLog.e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper packageInfo is null");
            }
            return packageInfo;
        }
    }

    private static PackageInfo f(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                SLog.e("openSDK_LOG.SystemUtils", "realGetPackageInfo null. packageName= " + str);
            }
            return packageInfo;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.SystemUtils", "realGetPackageInfo exception", e2);
            return null;
        }
    }

    private static boolean g(Context context, String str) {
        return (h.a(context, c(), str) == null && e(context, str) == null) ? false : true;
    }

    public static void a(String str) {
        if (str == null) {
            return;
        }
        f9933a.remove(str);
    }

    public static String a(Context context, String str) {
        String strA = h.a(context, c(), str);
        if (strA != null && !"UNKNOWN".equals(strA)) {
            return strA;
        }
        PackageInfo packageInfoE = e(context, str);
        if (packageInfoE == null) {
            SLog.e("openSDK_LOG.SystemUtils", "getAppVersionName return null. package= " + str);
            return null;
        }
        return packageInfoE.versionName;
    }

    public static boolean c(Context context) {
        if (g(context, "com.tencent.mobileqq")) {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: qq");
            return true;
        }
        if (g(context, Constants.PACKAGE_TIM)) {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: tim");
            return true;
        }
        if (g(context, Constants.PACKAGE_QQ_PAD)) {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: pad");
            return true;
        }
        SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: disable speed");
        return false;
    }

    public static boolean d(Context context) {
        return context != null && context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !b();
    }

    public static int a(String str, String str2) throws NumberFormatException {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int i2 = 0;
        while (i2 < strArrSplit.length && i2 < strArrSplit2.length) {
            try {
                int i3 = Integer.parseInt(strArrSplit[i2]);
                int i4 = Integer.parseInt(strArrSplit2[i2]);
                if (i3 < i4) {
                    return -1;
                }
                if (i3 > i4) {
                    return 1;
                }
                i2++;
            } catch (NumberFormatException unused) {
                return str.compareTo(str2);
            }
        }
        if (strArrSplit.length > i2) {
            return 1;
        }
        return strArrSplit2.length > i2 ? -1 : 0;
    }

    private static String c() {
        String strB = com.tencent.open.b.b.b();
        if (strB == null || strB.isEmpty()) {
            SLog.e("openSDK_LOG.SystemUtils", "getAppId error: " + strB);
        }
        return strB;
    }

    public static boolean a(Context context, String str, String str2) {
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (m.g(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean b(Context context, Intent intent) {
        boolean z = false;
        if (context != null && intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                SLog.i("openSDK_LOG.SystemUtils", "isAgentActivityExist? component null");
                return false;
            }
            String packageName = component.getPackageName();
            String strA = a(context, packageName);
            if (strA != null && !strA.isEmpty()) {
                z = true;
            }
            SLog.i("openSDK_LOG.SystemUtils", "isAgentActivityExist? packageName = " + packageName + ", appVersionName= " + strA);
        }
        return z;
    }

    public static String a(Activity activity, String str) {
        if (activity == null) {
            SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
            return "";
        }
        try {
            byte[] bArrA = e.a(str);
            if (bArrA == null) {
                SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            System.arraycopy(bArrA, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArrA, 8, bArr2, 0, 16);
            return e.a(activity.getPackageName(), e.a(bArr2), bArr);
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e2);
            return "";
        }
    }

    public static int b(String str) {
        if ("shareToQQ".equals(str)) {
            return 10103;
        }
        if ("shareToQzone".equals(str)) {
            return 10104;
        }
        if ("addToQQFavorites".equals(str)) {
            return Constants.REQUEST_QQ_FAVORITES;
        }
        if ("sendToMyComputer".equals(str)) {
            return Constants.REQUEST_SEND_TO_MY_COMPUTER;
        }
        if ("shareToTroopBar".equals(str)) {
            return Constants.REQUEST_SHARE_TO_TROOP_BAR;
        }
        if ("action_login".equals(str)) {
            return 11101;
        }
        if ("action_request".equals(str)) {
            return Constants.REQUEST_API;
        }
        return -1;
    }

    public static boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            boolean z = listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append("isActivityExist false. result=");
                sb.append(listQueryIntentActivities == null ? c.c.a.b.a.a.f3101h : Integer.valueOf(listQueryIntentActivities.size()));
                sb.append(" Intent= ");
                sb.append(intent);
                SLog.e("openSDK_LOG.SystemUtils", sb.toString());
            }
            return z;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isActivityExist params error! [");
        sb2.append(context == null);
        sb2.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append(intent == null);
        sb2.append("]");
        SLog.e("openSDK_LOG.SystemUtils", sb2.toString());
        return false;
    }

    public static boolean b(Context context) {
        boolean zG = g(context, "com.tencent.mobileqq");
        SLog.i("openSDK_LOG.SystemUtils", "isQQInstalled " + zG);
        return zG;
    }

    private static boolean b() {
        try {
            return ((Boolean) Environment.class.getMethod("isExternalStorageLegacy", new Class[0]).invoke(Environment.class, new Object[0])).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static String a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.SystemUtils", "getAppName exception", th);
            try {
                int i2 = applicationInfo.labelRes;
                return i2 <= 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i2);
            } catch (Throwable th2) {
                SLog.e("openSDK_LOG.SystemUtils", "getAppName getLabel exception", th2);
                return "";
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[SYNTHETIC] */
    @android.annotation.SuppressLint({"SdCardPath"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r10, java.lang.String r11, int r12) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "-->extractSecureLib, libName: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "openSDK_LOG.SystemUtils"
            com.tencent.open.log.SLog.i(r1, r0)
            android.content.Context r0 = com.tencent.open.utils.g.a()
            r2 = 0
            if (r0 != 0) goto L23
            java.lang.String r10 = "-->extractSecureLib, global context is null. "
            com.tencent.open.log.SLog.i(r1, r10)
            return r2
        L23:
            java.lang.String r3 = "secure_lib"
            android.content.SharedPreferences r3 = r0.getSharedPreferences(r3, r2)
            java.io.File r4 = new java.io.File
            java.io.File r5 = r0.getFilesDir()
            r4.<init>(r5, r11)
            boolean r5 = r4.exists()
            r6 = 1
            java.lang.String r7 = "version"
            if (r5 != 0) goto L50
            java.io.File r5 = r4.getParentFile()
            if (r5 == 0) goto L73
            boolean r5 = r5.mkdirs()
            if (r5 == 0) goto L73
            r4.createNewFile()     // Catch: java.io.IOException -> L4b
            goto L73
        L4b:
            r4 = move-exception
            r4.printStackTrace()
            goto L73
        L50:
            int r4 = r3.getInt(r7, r2)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "-->extractSecureLib, libVersion: "
            r5.append(r8)
            r5.append(r12)
            java.lang.String r8 = " | oldVersion: "
            r5.append(r8)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            com.tencent.open.log.SLog.i(r1, r5)
            if (r12 != r4) goto L73
            return r6
        L73:
            r4 = 0
            android.content.res.AssetManager r5 = r0.getAssets()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.io.InputStream r10 = r5.open(r10)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.io.FileOutputStream r4 = r0.openFileOutput(r11, r2)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            a(r10, r4)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            android.content.SharedPreferences$Editor r11 = r3.edit()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r11.putInt(r7, r12)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r11.commit()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            if (r10 == 0) goto L94
            r10.close()     // Catch: java.io.IOException -> L93
            goto L94
        L93:
        L94:
            if (r4 == 0) goto L99
            r4.close()     // Catch: java.io.IOException -> L99
        L99:
            return r6
        L9a:
            r11 = move-exception
            goto Lbc
        L9c:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
            goto La6
        La1:
            r11 = move-exception
            r10 = r4
            goto Lbc
        La4:
            r11 = move-exception
            r10 = r4
        La6:
            java.lang.String r12 = "-->extractSecureLib, when copy lib execption."
            com.tencent.open.log.SLog.e(r1, r12, r11)     // Catch: java.lang.Throwable -> Lb8
            if (r4 == 0) goto Lb2
            r4.close()     // Catch: java.io.IOException -> Lb1
            goto Lb2
        Lb1:
        Lb2:
            if (r10 == 0) goto Lb7
            r10.close()     // Catch: java.io.IOException -> Lb7
        Lb7:
            return r2
        Lb8:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
        Lbc:
            if (r10 == 0) goto Lc3
            r10.close()     // Catch: java.io.IOException -> Lc2
            goto Lc3
        Lc2:
        Lc3:
            if (r4 == 0) goto Lc8
            r4.close()     // Catch: java.io.IOException -> Lc8
        Lc8:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.k.a(java.lang.String, java.lang.String, int):boolean");
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j2 = 0;
        while (true) {
            int i2 = inputStream.read(bArr, 0, bArr.length);
            if (i2 != -1) {
                outputStream.write(bArr, 0, i2);
                j2 += i2;
            } else {
                SLog.i("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j2);
                return j2;
            }
        }
    }

    public static String a(Activity activity) throws PackageManager.NameNotFoundException {
        try {
            ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), 128);
            SLog.i("openSDK_LOG.SystemUtils", "apkPath=" + applicationInfo.sourceDir);
            return applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e2) {
            SLog.e("openSDK_LOG.SystemUtils", "NameNotFoundException", e2);
            return null;
        } catch (Exception e3) {
            SLog.e("openSDK_LOG.SystemUtils", LogUtils.LOG_EXCEPTION, e3);
            return null;
        }
    }
}
