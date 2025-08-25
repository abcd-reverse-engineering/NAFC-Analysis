package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class H5JavaScriptInterface {

    /* renamed from: a, reason: collision with root package name */
    private static HashSet<Integer> f9123a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private String f9124b = null;

    /* renamed from: c, reason: collision with root package name */
    private Thread f9125c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f9126d = null;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f9127e = null;

    private H5JavaScriptInterface() {
    }

    private static String a(Thread thread) {
        if (thread == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i2 = 2; i2 < thread.getStackTrace().length; i2++) {
            StackTraceElement stackTraceElement = thread.getStackTrace()[i2];
            if (!stackTraceElement.toString().contains("crashreport")) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        if (webViewInterface == null || f9123a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f9123a.add(Integer.valueOf(webViewInterface.hashCode()));
        h5JavaScriptInterface.f9125c = Thread.currentThread();
        h5JavaScriptInterface.f9126d = a(h5JavaScriptInterface.f9125c);
        h5JavaScriptInterface.f9127e = a(webViewInterface);
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        an.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            an.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String strB = aq.b(str.getBytes());
        String str2 = this.f9124b;
        if (str2 != null && str2.equals(strB)) {
            an.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f9124b = strB;
        an.d("Handling JS exception ...", new Object[0]);
        a aVarA = a(str);
        if (aVarA == null) {
            an.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(aVarA.a());
        linkedHashMap.putAll(this.f9127e);
        linkedHashMap.put("Java Stack", this.f9126d);
        a(aVarA, this.f9125c, linkedHashMap);
    }

    private static Map<String, String> a(CrashReport.WebViewInterface webViewInterface) {
        HashMap map = new HashMap();
        map.put("[WebView] ContentDescription", "" + ((Object) webViewInterface.getContentDescription()));
        return map;
    }

    private a a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a();
                aVar.f9128a = jSONObject.getString("projectRoot");
                if (aVar.f9128a == null) {
                    return null;
                }
                aVar.f9129b = jSONObject.getString(d.R);
                if (aVar.f9129b == null) {
                    return null;
                }
                aVar.f9130c = jSONObject.getString("url");
                if (aVar.f9130c == null) {
                    return null;
                }
                aVar.f9131d = jSONObject.getString("userAgent");
                if (aVar.f9131d == null) {
                    return null;
                }
                aVar.f9132e = jSONObject.getString(bh.N);
                if (aVar.f9132e == null) {
                    return null;
                }
                aVar.f9133f = jSONObject.getString(CommonNetImpl.NAME);
                if (aVar.f9133f == null || aVar.f9133f.equals(c.c.a.b.a.a.f3101h) || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int iIndexOf = string.indexOf("\n");
                if (iIndexOf < 0) {
                    an.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                aVar.f9135h = string.substring(iIndexOf + 1);
                aVar.f9134g = string.substring(0, iIndexOf);
                int iIndexOf2 = aVar.f9134g.indexOf(Constants.COLON_SEPARATOR);
                if (iIndexOf2 > 0) {
                    aVar.f9134g = aVar.f9134g.substring(iIndexOf2 + 1);
                }
                aVar.f9136i = jSONObject.getString("file");
                if (aVar.f9133f == null) {
                    return null;
                }
                aVar.f9137j = jSONObject.getLong("lineNumber");
                if (aVar.f9137j < 0) {
                    return null;
                }
                aVar.f9138k = jSONObject.getLong("columnNumber");
                if (aVar.f9138k < 0) {
                    return null;
                }
                an.a("H5 crash information is following: ", new Object[0]);
                an.a("[projectRoot]: " + aVar.f9128a, new Object[0]);
                an.a("[context]: " + aVar.f9129b, new Object[0]);
                an.a("[url]: " + aVar.f9130c, new Object[0]);
                an.a("[userAgent]: " + aVar.f9131d, new Object[0]);
                an.a("[language]: " + aVar.f9132e, new Object[0]);
                an.a("[name]: " + aVar.f9133f, new Object[0]);
                an.a("[message]: " + aVar.f9134g, new Object[0]);
                an.a("[stacktrace]: \n" + aVar.f9135h, new Object[0]);
                an.a("[file]: " + aVar.f9136i, new Object[0]);
                an.a("[lineNumber]: " + aVar.f9137j, new Object[0]);
                an.a("[columnNumber]: " + aVar.f9138k, new Object[0]);
                return aVar;
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    private static void a(a aVar, Thread thread, Map<String, String> map) {
        if (aVar != null) {
            InnerApi.postH5CrashAsync(thread, aVar.f9133f, aVar.f9134g, aVar.f9135h, map);
        }
    }
}
