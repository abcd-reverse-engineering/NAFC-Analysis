package com.taobao.accs.antibrush;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.utl.ALog;
import java.util.StringTokenizer;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class b {
    public static final String KEY_SEC = "sec";
    public static final String TAG = "CookieMgr";

    /* renamed from: a, reason: collision with root package name */
    public static CookieManager f8382a = null;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f8383b = false;

    public static synchronized void a(Context context) {
        try {
        } catch (Throwable th) {
            ALog.e(TAG, "setup", th, new Object[0]);
        }
        if (!GlobalConfig.enableCookie) {
            ALog.i(TAG, "disable cookie", new Object[0]);
            return;
        }
        if (f8383b) {
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.createInstance(context);
        }
        f8382a = CookieManager.getInstance();
        f8382a.setAcceptCookie(true);
        if (Build.VERSION.SDK_INT < 21) {
            f8382a.removeExpiredCookie();
        }
        f8383b = true;
    }

    public static String b(String str) {
        String strC = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        do {
            try {
                String strNextToken = stringTokenizer.nextToken();
                int iIndexOf = strNextToken.indexOf(61);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Invalid cookie name-value pair");
                }
                String strTrim = strNextToken.substring(0, iIndexOf).trim();
                String strTrim2 = strNextToken.substring(iIndexOf + 1).trim();
                if (KEY_SEC.equals(strTrim)) {
                    strC = c(strTrim2);
                }
            } catch (Throwable th) {
                ALog.e(TAG, "parse", th, new Object[0]);
            }
        } while (stringTokenizer.hasMoreTokens());
        return strC;
    }

    private static String c(String str) {
        return (str == null || str.length() <= 2 || str.charAt(0) != '\"' || str.charAt(str.length() - 1) != '\"') ? (str == null || str.length() <= 2 || str.charAt(0) != '\'' || str.charAt(str.length() - 1) != '\'') ? str : str.substring(1, str.length() - 1) : str.substring(1, str.length() - 1);
    }

    private static boolean a() {
        Context context;
        if (!f8383b && (context = GlobalClientInfo.f8392a) != null) {
            a(context);
        }
        return f8383b;
    }

    public static synchronized String a(String str) {
        String strB = null;
        if (!a()) {
            ALog.e(TAG, "cookieMgr not setup", new Object[0]);
            return null;
        }
        try {
            strB = b(f8382a.getCookie(str));
        } catch (Throwable th) {
            ALog.e(TAG, "get cookie failed. url=" + str, th, new Object[0]);
        }
        return strB;
    }
}
