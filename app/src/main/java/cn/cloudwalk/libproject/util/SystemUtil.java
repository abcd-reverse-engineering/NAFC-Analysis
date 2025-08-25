package cn.cloudwalk.libproject.util;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.util.Locale;

/* loaded from: classes.dex */
public class SystemUtil {
    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getDeviceId();
        }
        return null;
    }

    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static Locale[] getSystemLanguageList() {
        return Locale.getAvailableLocales();
    }

    public static String getSystemModel() {
        return Build.MODEL;
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }
}
