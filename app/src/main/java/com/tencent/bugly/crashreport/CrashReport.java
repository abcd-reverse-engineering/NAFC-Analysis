package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.af;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.aq;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class CrashReport {

    /* renamed from: a, reason: collision with root package name */
    private static Context f8924a;

    /* compiled from: BUGLY */
    public static class CrashHandleCallback extends BuglyStrategy.a {
    }

    /* compiled from: BUGLY */
    public static class UserStrategy extends BuglyStrategy {

        /* renamed from: c, reason: collision with root package name */
        CrashHandleCallback f8926c;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized int getCallBackType() {
            return this.f8739a;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.f8740b;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCallBackType(int i2) {
            this.f8739a = i2;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCloseErrorCallback(boolean z) {
            this.f8740b = z;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f8926c = crashHandleCallback;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f8926c;
        }
    }

    /* compiled from: BUGLY */
    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);

        void setJavaScriptEnabled(boolean z);
    }

    public static void closeBugly() {
        if (b.f8757a && CrashModule.getInstance().hasInitialized() && f8924a != null) {
            BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
            if (buglyBroadcastReceiver != null) {
                buglyBroadcastReceiver.unregister(f8924a);
            }
            closeCrashReport();
            com.tencent.bugly.crashreport.biz.b.a(f8924a);
            am amVarA = am.a();
            if (amVarA != null) {
                amVarA.b();
            }
        }
    }

    public static void closeCrashReport() {
        if (b.f8757a && CrashModule.getInstance().hasInitialized()) {
            c.a().d();
        }
    }

    public static void closeNativeReport() {
        if (b.f8757a && CrashModule.getInstance().hasInitialized()) {
            c.a().g();
        }
    }

    public static void enableBugly(boolean z) {
        b.f8757a = z;
    }

    public static void enableObtainId(Context context, boolean z) {
        if (b.f8757a && context != null) {
            String str = "Enable identification obtaining? " + z;
            com.tencent.bugly.crashreport.common.info.a.a(context).b(z);
        }
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        return !b.f8757a ? new HashSet() : context == null ? new HashSet() : com.tencent.bugly.crashreport.common.info.a.a(context).E();
    }

    public static String getAppChannel() {
        return (b.f8757a && CrashModule.getInstance().hasInitialized()) ? com.tencent.bugly.crashreport.common.info.a.a(f8924a).s : "unknown";
    }

    public static String getAppID() {
        return (b.f8757a && CrashModule.getInstance().hasInitialized()) ? com.tencent.bugly.crashreport.common.info.a.a(f8924a).f() : "unknown";
    }

    public static String getAppVer() {
        return (b.f8757a && CrashModule.getInstance().hasInitialized()) ? com.tencent.bugly.crashreport.common.info.a.a(f8924a).p : "unknown";
    }

    public static String getBuglyVersion(Context context) {
        if (context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).c();
        }
        an.d("Please call with context.", new Object[0]);
        return "unknown";
    }

    public static Proxy getHttpProxy() {
        return ao.a();
    }

    public static Map<String, String> getSdkExtraData() {
        if (!b.f8757a) {
            return new HashMap();
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f8924a).K;
        }
        return null;
    }

    public static String getUserData(Context context, String str) {
        if (!b.f8757a || context == null) {
            return "unknown";
        }
        if (aq.a(str)) {
            return null;
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).g(str);
    }

    public static int getUserDatasSize(Context context) {
        if (b.f8757a && context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).D();
        }
        return -1;
    }

    public static String getUserId() {
        return (b.f8757a && CrashModule.getInstance().hasInitialized()) ? com.tencent.bugly.crashreport.common.info.a.a(f8924a).g() : "unknown";
    }

    public static int getUserSceneTagId(Context context) {
        if (b.f8757a && context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).H();
        }
        return -1;
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f8924a = context;
        if (com.tencent.bugly.crashreport.common.info.a.a(context) != null && "oversea".equals(com.tencent.bugly.crashreport.common.info.a.a(context).F)) {
            StrategyBean.f8993b = "http://astat.bugly.qcloud.com/rqd/async";
            StrategyBean.f8994c = "http://astat.bugly.qcloud.com/rqd/async";
        }
        b.a(CrashModule.getInstance());
        b.a(context);
    }

    public static boolean isLastSessionCrash() {
        if (b.f8757a && CrashModule.getInstance().hasInitialized()) {
            return c.a().b();
        }
        return false;
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postException(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        if (b.f8757a && CrashModule.getInstance().hasInitialized()) {
            d.a(thread, i2, str, str2, str3, map);
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || aq.a(str) || aq.a(str2)) {
            return;
        }
        String strReplace = str.replace("[a-zA-Z[0-9]]+", "");
        if (strReplace.length() > 100) {
            String.format("putSdkData key length over limit %d, will be cutted.", 50);
            strReplace = strReplace.substring(0, 50);
        }
        if (str2.length() > 500) {
            String.format("putSdkData value length over limit %d, will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).c(strReplace, str2);
        an.b(String.format("[param] putSdkData data: %s - %s", strReplace, str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (b.f8757a && context != null) {
            if (str == null) {
                String str3 = "" + str;
                an.d("putUserData args key should not be null or empty", new Object[0]);
                return;
            }
            if (str2 == null) {
                String str4 = "" + str2;
                an.d("putUserData args value should not be null", new Object[0]);
                return;
            }
            if (!str.matches("[a-zA-Z[0-9]]+")) {
                an.d("putUserData args key should match [a-zA-Z[0-9]]+  {" + str + "}", new Object[0]);
                return;
            }
            if (str2.length() > 200) {
                an.d("user data value length over limit %d, it will be cutted!", 200);
                str2 = str2.substring(0, 200);
            }
            com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
            if (aVarA.E().contains(str)) {
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null) {
                    nativeCrashHandler.putKeyValueToNative(str, str2);
                }
                com.tencent.bugly.crashreport.common.info.a.a(context).b(str, str2);
                an.c("replace KV %s %s", str, str2);
                return;
            }
            if (aVarA.D() >= 10) {
                an.d("user data size is over limit %d, it will be cutted!", 10);
                return;
            }
            if (str.length() > 50) {
                an.d("user data key length over limit %d , will drop this new key %s", 50, str);
                str = str.substring(0, 50);
            }
            NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
            if (nativeCrashHandler2 != null) {
                nativeCrashHandler2.putKeyValueToNative(str, str2);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).b(str, str2);
            an.b("[param] set user data: %s - %s", str, str2);
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!b.f8757a || context == null) {
            return "unknown";
        }
        if (aq.a(str)) {
            return null;
        }
        an.b("[param] remove user data: %s", str);
        return com.tencent.bugly.crashreport.common.info.a.a(context).f(str);
    }

    public static void setAppChannel(Context context, String str) {
        if (!b.f8757a || context == null || str == null) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).s = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppChannel(str);
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!b.f8757a || context == null || str == null) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).f8977d = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppPackage(str);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!b.f8757a || context == null || str == null) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).p = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppVersion(str);
        }
    }

    public static void setAuditEnable(Context context, boolean z) {
        if (b.f8757a && context != null) {
            String str = "Set audit enable: " + z;
            com.tencent.bugly.crashreport.common.info.a.a(context).L = z;
        }
    }

    public static void setBuglyDbName(String str) {
        if (b.f8757a) {
            String str2 = "Set Bugly DB name: " + str;
            af.f9199a = str;
        }
    }

    public static void setContext(Context context) {
        f8924a = context;
    }

    public static void setCrashFilter(String str) {
        if (b.f8757a) {
            String str2 = "Set crash stack filter: " + str;
            c.n = str;
        }
    }

    public static void setCrashRegularFilter(String str) {
        if (b.f8757a) {
            String str2 = "Set crash stack filter: " + str;
            c.o = str;
        }
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (b.f8757a) {
            String str = "Should handle native crash in Java profile after handled in native profile: " + z;
            NativeCrashHandler.setShouldHandleInJava(z);
        }
    }

    public static void setHttpProxy(String str, int i2) {
        ao.a(str, i2);
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (b.f8757a) {
            if (context == null) {
                an.d("Context should not be null.", new Object[0]);
                return;
            }
            if (z) {
                an.c("App is in foreground.", new Object[0]);
            } else {
                an.c("App is in background.", new Object[0]);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).a(z);
        }
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (b.f8757a) {
            if (context == null) {
                an.d("Context should not be null.", new Object[0]);
                return;
            }
            if (z) {
                an.c("This is a development device.", new Object[0]);
            } else {
                an.c("This is not a development device.", new Object[0]);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).G = z;
        }
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!b.f8757a || context == null || aq.a(str) || aq.a(str2)) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).a(str, str2);
    }

    public static void setServerUrl(String str) {
        if (aq.a(str) || !aq.c(str)) {
            return;
        }
        com.tencent.bugly.crashreport.common.strategy.a.a(str);
        StrategyBean.f8993b = str;
        StrategyBean.f8994c = str;
    }

    public static void setSessionIntervalMills(long j2) {
        if (b.f8757a) {
            com.tencent.bugly.crashreport.biz.b.a(j2);
        }
    }

    public static void setUserId(String str) {
        if (b.f8757a && CrashModule.getInstance().hasInitialized()) {
            setUserId(f8924a, str);
        }
    }

    public static void setUserSceneTag(Context context, int i2) {
        if (b.f8757a && context != null) {
            if (i2 <= 0) {
                an.d("setTag args tagId should > 0", new Object[0]);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).a(i2);
            an.b("[param] set user scene tag: %d", Integer.valueOf(i2));
        }
    }

    public static void startCrashReport() {
        if (b.f8757a && CrashModule.getInstance().hasInitialized()) {
            c.a().c();
        }
    }

    public static void testANRCrash() {
        if (b.f8757a && CrashModule.getInstance().hasInitialized()) {
            an.a("start to create a anr crash for test!", new Object[0]);
            c.a().k();
        }
    }

    public static void testJavaCrash() {
        if (b.f8757a && CrashModule.getInstance().hasInitialized()) {
            com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
            if (aVarB != null) {
                aVarB.b(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i2) {
        ao.a(inetAddress, i2);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(final WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            return false;
        }
        return setJavascriptMonitor(new WebViewInterface() { // from class: com.tencent.bugly.crashreport.CrashReport.1
            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str) {
                webView.addJavascriptInterface(h5JavaScriptInterface, str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public CharSequence getContentDescription() {
                return webView.getContentDescription();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public String getUrl() {
                return webView.getUrl();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public void loadUrl(String str) {
                webView.loadUrl(str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public void setJavaScriptEnabled(boolean z3) {
                WebSettings settings = webView.getSettings();
                if (settings.getJavaScriptEnabled()) {
                    return;
                }
                settings.setJavaScriptEnabled(true);
            }
        }, z, z2);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (b.f8757a && CrashModule.getInstance().hasInitialized()) {
            an.a("start to create a native crash for test!", new Object[0]);
            c.a().a(z, z2, z3);
        }
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z) {
        if (b.f8757a && CrashModule.getInstance().hasInitialized()) {
            if (th == null) {
                an.d("throwable is null, just return", new Object[0]);
                return;
            }
            if (thread == null) {
                thread = Thread.currentThread();
            }
            c.a().a(thread, th, false, (String) null, (byte[]) null, z);
        }
    }

    public static void postException(int i2, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i2, str, str2, str3, map);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z) {
        return setJavascriptMonitor(webViewInterface, z, false);
    }

    public static void setUserId(Context context, String str) {
        if (b.f8757a && context != null) {
            if (TextUtils.isEmpty(str)) {
                an.d("userId should not be null", new Object[0]);
                return;
            }
            if (str.length() > 100) {
                String strSubstring = str.substring(0, 100);
                an.d("userId %s length is over limit %d substring to %s", str, 100, strSubstring);
                str = strSubstring;
            }
            if (str.equals(com.tencent.bugly.crashreport.common.info.a.a(context).g())) {
                return;
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).b(str);
            an.b("[user] set userId : %s", str);
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeUserId(str);
            }
            if (CrashModule.getInstance().hasInitialized()) {
                com.tencent.bugly.crashreport.biz.b.a();
            }
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!b.f8757a) {
            return new HashMap();
        }
        if (context == null) {
            an.d("Context should not be null.", new Object[0]);
            return null;
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).K;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z, boolean z2) {
        if (webViewInterface == null) {
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            an.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
        an.a("Set Javascript exception monitor of webview.", new Object[0]);
        if (!b.f8757a) {
            return false;
        }
        an.c("URL of webview is %s", webViewInterface.getUrl());
        if (!z2 && Build.VERSION.SDK_INT < 19) {
            an.e("This interface is only available for Android 4.4 or later.", new Object[0]);
            return false;
        }
        an.a("Enable the javascript needed by webview monitor.", new Object[0]);
        webViewInterface.setJavaScriptEnabled(true);
        H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(webViewInterface);
        if (h5JavaScriptInterface != null) {
            an.a("Add a secure javascript interface to the webview.", new Object[0]);
            webViewInterface.addJavascriptInterface(h5JavaScriptInterface, "exceptionUploader");
        }
        if (z) {
            an.a("Inject bugly.js(v%s) to the webview.", com.tencent.bugly.crashreport.crash.h5.b.b());
            String strA = com.tencent.bugly.crashreport.crash.h5.b.a();
            if (strA == null) {
                an.e("Failed to inject Bugly.js.", com.tencent.bugly.crashreport.crash.h5.b.b());
                return false;
            }
            webViewInterface.loadUrl("javascript:" + strA);
        }
        return true;
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f8924a = context;
        if (com.tencent.bugly.crashreport.common.info.a.a(context) != null && "oversea".equals(com.tencent.bugly.crashreport.common.info.a.a(context).F)) {
            StrategyBean.f8993b = "http://astat.bugly.qcloud.com/rqd/async";
            StrategyBean.f8994c = "http://astat.bugly.qcloud.com/rqd/async";
        }
        b.a(CrashModule.getInstance());
        b.a(context, userStrategy);
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        initCrashReport(context, str, z, null);
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        if (com.tencent.bugly.crashreport.common.info.a.a(context) != null && "oversea".equals(com.tencent.bugly.crashreport.common.info.a.a(context).F)) {
            StrategyBean.f8993b = "http://astat.bugly.qcloud.com/rqd/async";
            StrategyBean.f8994c = "http://astat.bugly.qcloud.com/rqd/async";
        }
        f8924a = context;
        b.a(CrashModule.getInstance());
        b.a(context, str, z, userStrategy);
    }
}
