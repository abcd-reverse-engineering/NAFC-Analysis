package a.a.l;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1132a = "anet.CookieManager";

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f1133b = false;

    /* renamed from: c, reason: collision with root package name */
    private static CookieManager f1134c = null;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f1135d = true;

    /* renamed from: e, reason: collision with root package name */
    private static C0002a f1136e;

    /* renamed from: f, reason: collision with root package name */
    private static SharedPreferences f1137f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: a.a.l.a$a, reason: collision with other inner class name */
    static class C0002a {

        /* renamed from: a, reason: collision with root package name */
        String f1138a;

        /* renamed from: b, reason: collision with root package name */
        String f1139b;

        /* renamed from: c, reason: collision with root package name */
        String f1140c;

        /* renamed from: d, reason: collision with root package name */
        String f1141d;

        /* renamed from: e, reason: collision with root package name */
        long f1142e;

        C0002a(String str) {
            this.f1138a = str;
            String string = a.f1137f.getString("networksdk_cookie_monitor", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (!TextUtils.isEmpty(this.f1138a) && this.f1138a.equals(jSONObject.getString("cookieName"))) {
                    this.f1142e = jSONObject.getLong("time");
                    if (System.currentTimeMillis() - this.f1142e < 86400000) {
                        this.f1139b = jSONObject.getString("cookieText");
                        this.f1140c = jSONObject.getString("setCookie");
                        this.f1141d = jSONObject.getString(DispatchConstants.DOMAIN);
                    } else {
                        this.f1142e = 0L;
                        a.f1137f.edit().remove("networksdk_cookie_monitor").apply();
                    }
                }
            } catch (JSONException e2) {
                ALog.e(a.f1132a, "cookie json parse error.", null, e2, new Object[0]);
            }
        }

        void a() throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cookieName", this.f1138a);
                jSONObject.put("cookieText", this.f1139b);
                jSONObject.put("setCookie", this.f1140c);
                this.f1142e = System.currentTimeMillis();
                jSONObject.put("time", this.f1142e);
                jSONObject.put(DispatchConstants.DOMAIN, this.f1141d);
                a.f1137f.edit().putString("networksdk_cookie_monitor", jSONObject.toString()).apply();
            } catch (Exception e2) {
                ALog.e(a.f1132a, "cookie json save error.", null, e2, new Object[0]);
            }
        }
    }

    private static boolean d() {
        if (!f1133b && a.a.o.c.getContext() != null) {
            a(a.a.o.c.getContext());
        }
        return f1133b;
    }

    private static void e() {
        ThreadPoolExecutorFactory.submitCookieMonitor(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f() {
        SharedPreferences sharedPreferences = f1137f;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("networksdk_target_cookie_name", null);
    }

    public static synchronized void b(String str, String str2) {
        if (a.a.k.b.j()) {
            if (d() && f1135d) {
                try {
                    f1134c.setCookie(str, str2);
                    if (Build.VERSION.SDK_INT < 21) {
                        CookieSyncManager.getInstance().sync();
                    } else {
                        f1134c.flush();
                    }
                } catch (Throwable th) {
                    ALog.e(f1132a, "set cookie failed.", null, th, "url", str, "cookies", str2);
                }
            }
        }
    }

    public static void c(String str) {
        SharedPreferences sharedPreferences;
        if (str == null || (sharedPreferences = f1137f) == null) {
            return;
        }
        sharedPreferences.edit().putString("networksdk_target_cookie_name", str).apply();
    }

    public static synchronized void a(Context context) {
        if (a.a.k.b.j()) {
            if (f1133b) {
                return;
            }
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (Build.VERSION.SDK_INT < 21) {
                    CookieSyncManager.createInstance(context);
                }
                f1134c = CookieManager.getInstance();
                f1134c.setAcceptCookie(true);
                if (Build.VERSION.SDK_INT < 21) {
                    f1134c.removeExpiredCookie();
                }
                f1137f = PreferenceManager.getDefaultSharedPreferences(context);
                e();
                ALog.e(f1132a, "CookieManager setup.", null, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Throwable th) {
                f1135d = false;
                ALog.e(f1132a, "Cookie Manager setup failed!!!", null, th, new Object[0]);
            }
            f1133b = true;
        }
    }

    public static synchronized String b(String str) {
        String cookie = null;
        if (!a.a.k.b.j()) {
            return null;
        }
        if (!d() || !f1135d) {
            return null;
        }
        try {
            cookie = f1134c.getCookie(str);
        } catch (Throwable th) {
            ALog.e(f1132a, "get cookie failed. url=" + str, null, th, new Object[0]);
        }
        a(str, cookie);
        return cookie;
    }

    public static void a(String str, Map<String, List<String>> map) {
        if (!a.a.k.b.j() || str == null || map == null) {
            return;
        }
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && (key.equalsIgnoreCase(HttpConstant.SET_COOKIE) || key.equalsIgnoreCase(HttpConstant.SET_COOKIE2))) {
                    for (String str2 : entry.getValue()) {
                        b(str, str2);
                        a(str2);
                    }
                }
            }
        } catch (Exception e2) {
            ALog.e(f1132a, "set cookie failed", null, e2, "url", str, "\nheaders", map);
        }
    }

    private static void a(String str) {
        ThreadPoolExecutorFactory.submitCookieMonitor(new c(str));
    }

    private static void a(String str, String str2) {
        ThreadPoolExecutorFactory.submitCookieMonitor(new d(str, str2));
    }
}
