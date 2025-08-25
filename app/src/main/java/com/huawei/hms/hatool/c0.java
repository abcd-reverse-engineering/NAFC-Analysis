package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes.dex */
public class c0 {
    public static boolean a(Context context) {
        return System.currentTimeMillis() - d.a(context, "Privacy_MY", "flashKeyTime", -1L) > com.heytap.mcssdk.constant.a.f5803g;
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return false;
            }
            v.f("hmsSdk", "not have read phone permission!");
            return true;
        }
        if (context.checkSelfPermission(str) == 0) {
            return false;
        }
        v.f("hmsSdk", "not have read phone permission!");
        return true;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean a(Context context, String str, int i2) {
        String str2 = d.c(context, str) + ".xml";
        File file = new File(context.getFilesDir(), "../shared_prefs/" + str2);
        if (!file.exists()) {
            String str3 = context.getPackageName() + c.c.a.b.a.a.s1 + str2;
            file = new File(context.getFilesDir(), "../../shared_prefs/" + str3);
        }
        long length = file.length();
        if (length <= i2) {
            return false;
        }
        v.c("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i2)));
        return true;
    }

    public static boolean a(String str, long j2, long j3) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j2 - Long.parseLong(str) > j3;
        } catch (NumberFormatException unused) {
            v.f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}
