package com.huawei.secure.android.common.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.util.LogsUtil;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public class UriUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7735a = "UriUtil";

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return !URLUtil.isNetworkUrl(str) ? str : getHostByURI(str);
        }
        LogsUtil.i(f7735a, "whiteListUrl is null");
        return null;
    }

    @TargetApi(9)
    public static String getHostByURI(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.i(f7735a, "url is null");
            return str;
        }
        try {
            if (URLUtil.isNetworkUrl(str)) {
                return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
            }
            LogsUtil.e(f7735a, "url don't starts with http or https");
            return "";
        } catch (MalformedURLException e2) {
            LogsUtil.e(f7735a, "getHostByURI error  MalformedURLException : " + e2.getMessage());
            return "";
        }
    }

    public static boolean isUrlHostAndPathInWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.e(f7735a, "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (isUrlHostAndPathMatchWhitelist(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlHostAndPathMatchWhitelist(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.contains("..") || str.contains("@")) {
            return false;
        }
        if (!str2.equals(str)) {
            if (!str.startsWith(str2 + "?")) {
                if (!str.startsWith(str2 + "#")) {
                    if (!str2.endsWith("/")) {
                        return false;
                    }
                    if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                        return false;
                    }
                    return str.startsWith(str2);
                }
            }
        }
        return true;
    }

    public static boolean isUrlHostInWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.e(f7735a, "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (isUrlHostMatchWhitelist(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlHostMatchWhitelist(String str, String str2) {
        String hostByURI = getHostByURI(str);
        if (TextUtils.isEmpty(hostByURI) || TextUtils.isEmpty(str2)) {
            LogsUtil.e(f7735a, "url or whitelist is null");
            return false;
        }
        String strA = a(str2);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        if (strA.equals(hostByURI)) {
            return true;
        }
        if (hostByURI.endsWith(strA)) {
            try {
                String strSubstring = hostByURI.substring(0, hostByURI.length() - strA.length());
                if (strSubstring.endsWith(".")) {
                    return strSubstring.matches("^[A-Za-z0-9.-]+$");
                }
                return false;
            } catch (IndexOutOfBoundsException e2) {
                LogsUtil.e(f7735a, "IndexOutOfBoundsException" + e2.getMessage());
            } catch (Exception e3) {
                LogsUtil.e(f7735a, "Exception : " + e3.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean isUrlHostSameWhitelist(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return TextUtils.equals(getHostByURI(str), a(str2));
    }

    public static boolean isUrlHostSameWhitelist(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (isUrlHostSameWhitelist(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.e(f7735a, "whitelist is null");
        return false;
    }
}
