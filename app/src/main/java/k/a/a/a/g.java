package k.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import h.f1;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* compiled from: SDKUtil.java */
/* loaded from: classes2.dex */
public class g {
    public static boolean a(Context context) {
        if (context != null) {
            return com.hihonor.honorid.f.a.a(context);
        }
        k.a.a.a.j.e.a("SDKUtil", "context is null", true);
        return false;
    }

    public static boolean b(Context context, int i2) {
        if (context != null) {
            return b(context) >= i2;
        }
        k.a.a.a.j.e.b("SDKUtil", "context is null", true);
        return false;
    }

    public static boolean c(Context context, int i2) {
        if (context != null) {
            return b(context) <= i2;
        }
        k.a.a.a.j.e.b("SDKUtil", "context is null", true);
        return false;
    }

    public static boolean a(Context context, int i2) {
        if (context != null) {
            return b(context) < i2;
        }
        k.a.a.a.j.e.b("SDKUtil", "context is null", true);
        return false;
    }

    public static int b(Context context) {
        try {
            int i2 = context.getPackageManager().getPackageInfo(e.a(context).a(), 0).versionCode;
            k.a.a.a.j.e.b("SDKUtil", "versionCode " + i2, true);
            return i2;
        } catch (PackageManager.NameNotFoundException unused) {
            k.a.a.a.j.e.a("SDKUtil", "NameNotFoundException error", true);
            return 0;
        } catch (Exception unused2) {
            k.a.a.a.j.e.a("SDKUtil", "Exception error", true);
            return 0;
        }
    }

    public static boolean c(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        try {
            String strA = e.a(context).a();
            PackageInfo packageInfo = packageManager.getPackageInfo(strA, 0);
            k.a.a.a.j.e.b("SDKUtil", "packageName " + strA, true);
            return packageInfo.versionName.contains("oversea");
        } catch (PackageManager.NameNotFoundException unused) {
            k.a.a.a.j.e.a("SDKUtil", "NameNotFoundException error", true);
            return false;
        } catch (Exception unused2) {
            k.a.a.a.j.e.a("SDKUtil", "Exception error", true);
            return false;
        }
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
            k.a.a.a.j.e.a("HiPkgSignManager", "PackageManager.NameNotFoundException : " + e2.getMessage(), true);
        } catch (Exception e3) {
            k.a.a.a.j.e.a("HiPkgSignManager", "Exception : " + e3.getMessage(), true);
        }
        return new byte[0];
    }

    public static String b(Context context, String str) {
        byte[] bArrA = a(context, str);
        String strB = (bArrA == null || bArrA.length <= 0) ? "" : b(bArrA);
        return strB == null ? "" : strB;
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < length; i2++) {
            if ((bArr[i2] & f1.f16099c) < 16) {
                stringBuffer.append("0" + Integer.toHexString(bArr[i2] & f1.f16099c));
            } else {
                stringBuffer.append(Integer.toHexString(bArr[i2] & f1.f16099c));
            }
        }
        return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
    }

    private static String b(byte[] bArr) {
        try {
            return a(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            String str = "NoSuchAlgorithmException" + e2.getMessage();
            return "";
        }
    }
}
