package com.just.agentweb;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebView;
import androidx.collection.ArrayMap;
import com.just.agentweb.AgentWeb;

/* loaded from: classes.dex */
public class WebSecurityLogicImpl implements WebSecurityCheckLogic {
    private String TAG = WebSecurityLogicImpl.class.getSimpleName();
    private int webviewType;

    public WebSecurityLogicImpl(int i2) {
        this.webviewType = i2;
    }

    public static WebSecurityLogicImpl getInstance(int i2) {
        return new WebSecurityLogicImpl(i2);
    }

    @Override // com.just.agentweb.WebSecurityCheckLogic
    @TargetApi(11)
    public void dealHoneyComb(WebView webView) {
        int i2 = Build.VERSION.SDK_INT;
        if (11 > i2 || i2 > 17) {
            return;
        }
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
    }

    @Override // com.just.agentweb.WebSecurityCheckLogic
    public void dealJsInterface(ArrayMap<String, Object> arrayMap, AgentWeb.SecurityType securityType) {
        if (securityType != AgentWeb.SecurityType.STRICT_CHECK || this.webviewType == 2 || Build.VERSION.SDK_INT >= 17) {
            return;
        }
        LogUtils.e(this.TAG, "Give up all inject objects");
        arrayMap.clear();
        System.gc();
    }
}
