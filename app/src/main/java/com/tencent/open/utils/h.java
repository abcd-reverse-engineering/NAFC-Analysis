package com.tencent.open.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.vivo.push.PushClientConstants;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f9920a = false;

    public static String a(Context context, String str, String str2) {
        if (context != null && str2 != null && str != null) {
            if ("com.tencent.mobileqq".equals(str2)) {
                return b(context, str, "com.tencent.mobileqq");
            }
            if (Constants.PACKAGE_TIM.equals(str2)) {
                return b(context, str, Constants.PACKAGE_TIM);
            }
        }
        return null;
    }

    private static String b(Context context, String str, String str2) {
        if (!f9920a) {
            return null;
        }
        try {
            Cursor cursorC = c(context, str, str2);
            if (cursorC == null) {
                SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion null");
                return null;
            }
            if (cursorC.getCount() <= 0) {
                SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion empty");
                return null;
            }
            cursorC.moveToFirst();
            String string = cursorC.getString(0);
            cursorC.close();
            SLog.i("openSDK_LOG.OpenApiProviderUtils", "AppVersion: " + string);
            return a(string) ? string : "UNKNOWN";
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion exception: ", e2);
            return null;
        }
    }

    private static Cursor c(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        try {
            return context.getContentResolver().query(Uri.parse("content://" + str2 + ".openapi.provider/query_app_version?appid" + ContainerUtils.KEY_VALUE_DELIMITER + str + "&" + PushClientConstants.TAG_PKG_NAME + ContainerUtils.KEY_VALUE_DELIMITER + context.getPackageName()), new String[0], null, null, null);
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.OpenApiProviderUtils", "query exception: ", e2);
            return null;
        }
    }

    private static boolean a(String str) throws NumberFormatException {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length < 3) {
            return false;
        }
        for (String str2 : strArrSplit) {
            try {
                Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return true;
    }
}
