package com.heytap.mcssdk.k;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class c {
    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            g.b("getVersionCode--Exception:" + e2.getMessage());
            return 0;
        }
    }

    public static int a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e2) {
            g.b("getVersionCode--Exception:" + e2.getMessage());
            return 0;
        }
    }

    public static int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                g.e("parseInt--NumberFormatException" + e2.getMessage());
            }
        }
        return -1;
    }

    public static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 : iArr) {
            sb.append((char) i2);
        }
        return sb.toString();
    }

    public static boolean a(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e2) {
            g.e("isSupportPush NameNotFoundException:" + e2.getMessage());
            applicationInfo = null;
        }
        return applicationInfo != null && applicationInfo.metaData.getBoolean(str2, false);
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            g.b("getVersionName--Exception:" + e2.getMessage());
            return "0";
        }
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception e2) {
            g.b("getVersionName--Exception:" + e2.getMessage());
            return null;
        }
    }

    public static boolean c(Context context) {
        return com.heytap.mcssdk.a.w().d(context);
    }

    public static boolean c(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            g.e("isExistPackage NameNotFoundException:" + e2.getMessage());
            return false;
        }
    }
}
