package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class AppInfo {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f8968a = "@buglyAllChannel@".split(Constants.ACCEPT_TIME_SEPARATOR_SP);

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f8969b = "@buglyAllChannelPriority@".split(Constants.ACCEPT_TIME_SEPARATOR_SP);

    /* renamed from: c, reason: collision with root package name */
    private static ActivityManager f8970c;

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (an.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0);
        } catch (Throwable th) {
            if (an.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static String c(Context context) {
        CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (packageManager != null && applicationInfo != null && (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) != null) {
                return applicationLabel.toString();
            }
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Map<String, String> d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return null;
            }
            HashMap map = new HashMap();
            Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
            if (obj != null) {
                map.put("BUGLY_DISABLE", obj.toString());
            }
            Object obj2 = applicationInfo.metaData.get("BUGLY_APPID");
            if (obj2 != null) {
                map.put("BUGLY_APPID", obj2.toString());
            }
            Object obj3 = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
            if (obj3 != null) {
                map.put("BUGLY_APP_CHANNEL", obj3.toString());
            }
            Object obj4 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
            if (obj4 != null) {
                map.put("BUGLY_APP_VERSION", obj4.toString());
            }
            Object obj5 = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
            if (obj5 != null) {
                map.put("BUGLY_ENABLE_DEBUG", obj5.toString());
            }
            Object obj6 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
            if (obj6 != null) {
                map.put("com.tencent.rdm.uuid", obj6.toString());
            }
            Object obj7 = applicationInfo.metaData.get("BUGLY_APP_BUILD_NO");
            if (obj7 != null) {
                map.put("BUGLY_APP_BUILD_NO", obj7.toString());
            }
            Object obj8 = applicationInfo.metaData.get("BUGLY_AREA");
            if (obj8 != null) {
                map.put("BUGLY_AREA", obj8.toString());
            }
            return map;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static String e(Context context) throws PackageManager.NameNotFoundException {
        Signature[] signatureArr;
        String strA = a(context);
        if (strA == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(strA, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0) {
                return a(signatureArr[0].toByteArray());
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static boolean f(Context context) {
        if (context == null) {
            return false;
        }
        if (f8970c == null) {
            f8970c = (ActivityManager) context.getSystemService("activity");
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            f8970c.getMemoryInfo(memoryInfo);
            if (!memoryInfo.lowMemory) {
                return false;
            }
            an.c("Memory is low.", new Object[0]);
            return true;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public static String g(Context context) throws IOException {
        if (context == null) {
            return "";
        }
        String strH = h(context);
        return !aq.a(strH) ? strH : i(context);
    }

    private static String h(Context context) throws IOException {
        String property = "";
        InputStream inputStreamOpen = null;
        try {
            try {
                try {
                    String string = aq.a("DENGTA_META", context).getString("key_channelpath", "");
                    if (aq.a(string)) {
                        string = "channel.ini";
                    }
                    an.a("[AppInfo] Beacon channel file path: " + string, new Object[0]);
                    if (!string.equals("")) {
                        inputStreamOpen = context.getAssets().open(string);
                        Properties properties = new Properties();
                        properties.load(inputStreamOpen);
                        property = properties.getProperty("CHANNEL", "");
                        an.a("[AppInfo] Beacon channel read from assert: " + property, new Object[0]);
                        if (!aq.a(property)) {
                            return property;
                        }
                    }
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                } finally {
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (IOException e2) {
                            an.a(e2);
                        }
                    }
                }
            } catch (Exception unused) {
                an.d("[AppInfo] Failed to get get beacon channel", new Object[0]);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            }
        } catch (IOException e3) {
            an.a(e3);
        }
        return property;
    }

    private static String i(Context context) {
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
            return obj != null ? obj.toString() : "";
        } catch (Throwable unused) {
            an.d("[AppInfo] Failed to read beacon channel from manifest.", new Object[0]);
            return "";
        }
    }

    public static boolean a(Context context, String str) {
        if (context != null && str != null && str.trim().length() > 0) {
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    for (String str2 : strArr) {
                        if (str.equals(str2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public static String a(Context context, int i2) {
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/" + i2 + "/cmdline");
            try {
                char[] cArr = new char[512];
                fileReader2.read(cArr);
                int i3 = 0;
                while (i3 < cArr.length && cArr[i3] != 0) {
                    i3++;
                }
                String strSubstring = new String(cArr).substring(0, i3);
                try {
                    fileReader2.close();
                } catch (Throwable unused) {
                }
                return strSubstring;
            } catch (Throwable th) {
                th = th;
                fileReader = fileReader2;
                try {
                    if (!an.a(th)) {
                        th.printStackTrace();
                    }
                    String strValueOf = String.valueOf(i2);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return strValueOf;
                } catch (Throwable th2) {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static List<String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = map.get("BUGLY_DISABLE");
            if (str != null && str.length() != 0) {
                String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    strArrSplit[i2] = strArrSplit[i2].trim();
                }
                return Arrays.asList(strArrSplit);
            }
            return null;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static String a(byte[] bArr) {
        X509Certificate x509Certificate;
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length > 0) {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                if (certificateFactory == null || (x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr))) == null) {
                    return null;
                }
                sb.append("Issuer|");
                Principal issuerDN = x509Certificate.getIssuerDN();
                if (issuerDN != null) {
                    sb.append(issuerDN.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("SerialNumber|");
                BigInteger serialNumber = x509Certificate.getSerialNumber();
                if (issuerDN != null) {
                    sb.append(serialNumber.toString(16));
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("NotBefore|");
                Date notBefore = x509Certificate.getNotBefore();
                if (issuerDN != null) {
                    sb.append(notBefore.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("NotAfter|");
                Date notAfter = x509Certificate.getNotAfter();
                if (issuerDN != null) {
                    sb.append(notAfter.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("SHA1|");
                String strA = aq.a(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
                if (strA != null && strA.length() > 0) {
                    sb.append(strA.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("MD5|");
                String strA2 = aq.a(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
                if (strA2 != null && strA2.length() > 0) {
                    sb.append(strA2.toString());
                } else {
                    sb.append("unknown");
                }
            } catch (CertificateException e2) {
                if (!an.a(e2)) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return sb.length() == 0 ? "unknown" : sb.toString();
    }
}
