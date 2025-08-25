package com.umeng.socialize.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class CommonUtil {
    public static boolean checkAndroidManifest(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), str), 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkIntentFilterData(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT + str + Constants.COLON_SEPARATOR));
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        if (listQueryIntentActivities.size() > 0) {
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String checkKeyHash(Context context) {
        return "";
    }

    public static String checkMD5Sign(Context context) {
        return "";
    }

    public static boolean checkMetaData(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData.get(str) != null) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean checkPath(String str) {
        try {
            return Class.forName(str) != null;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkPermission(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean checkResource(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName()) > 0;
    }

    public static String checkSHA1(Context context) {
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isSilentMode(android.content.Context r4) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.lang.String r4 = "com.umeng.commonsdk.UMConfigure"
            r1 = 0
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.ClassNotFoundException -> Lc
            goto L11
        Lc:
            r4 = move-exception
            r4.printStackTrace()
            r4 = r1
        L11:
            if (r4 == 0) goto L43
            java.lang.String r2 = "isSilentMode"
            java.lang.Class[] r3 = new java.lang.Class[r0]     // Catch: java.lang.NoSuchMethodException -> L22
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r2, r3)     // Catch: java.lang.NoSuchMethodException -> L22
            r2 = 1
            r4.setAccessible(r2)     // Catch: java.lang.NoSuchMethodException -> L20
            goto L27
        L20:
            r2 = move-exception
            goto L24
        L22:
            r2 = move-exception
            r4 = r1
        L24:
            r2.printStackTrace()
        L27:
            if (r4 == 0) goto L43
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.reflect.InvocationTargetException -> L39 java.lang.IllegalAccessException -> L3e
            java.lang.Object r4 = r4.invoke(r1, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L39 java.lang.IllegalAccessException -> L3e
            if (r4 == 0) goto L43
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.reflect.InvocationTargetException -> L39 java.lang.IllegalAccessException -> L3e
            boolean r4 = r4.booleanValue()     // Catch: java.lang.reflect.InvocationTargetException -> L39 java.lang.IllegalAccessException -> L3e
            r0 = r4
            goto L43
        L39:
            r4 = move-exception
            r4.printStackTrace()
            goto L43
        L3e:
            r4 = move-exception
            r4.printStackTrace()
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.utils.CommonUtil.isSilentMode(android.content.Context):boolean");
    }
}
