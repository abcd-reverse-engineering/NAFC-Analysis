package ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import h.q2.t.m0;
import interfaces.OnWebListener;
import java.util.HashMap;
import manager.AccountManager;
import network.account.AccountInfo;
import network.http.RegionConfigHttp;
import ui.Hicore;
import ui.activity.BaseActivity;
import ui.activity.PromosWebDetActivity;
import ui.view.swip.SwipBackLayout;
import util.a1;
import util.n1;
import util.v1;

/* loaded from: classes2.dex */
public class MyWebView extends WebView {
    private Activity mActivity;
    private OnWebListener mOnWebListener;
    private SwipBackLayout mSwipBackLayout;

    public class a {
        public a() {
        }

        @JavascriptInterface
        public String getHCData() {
            return MyWebView.getH5Data();
        }

        @JavascriptInterface
        public void getPageParams(String str) {
            if (MyWebView.this.mActivity == null || !TextUtils.equals("pageFinish=1", str) || MyWebView.this.mActivity == null || MyWebView.this.mOnWebListener == null) {
                return;
            }
            MyWebView.this.mOnWebListener.webJsFinish();
        }

        @JavascriptInterface
        public void getSwpieEvent(String str) {
            if (MyWebView.this.mActivity == null || MyWebView.this.mSwipBackLayout == null || !(MyWebView.this.mActivity instanceof PromosWebDetActivity)) {
                return;
            }
            if (TextUtils.equals(str, "1")) {
                MyWebView.this.mSwipBackLayout.setInterEvent(true);
            } else {
                MyWebView.this.mSwipBackLayout.setInterEvent(false);
            }
        }

        @JavascriptInterface
        public void h5callAPP(String str) {
            if (MyWebView.this.mOnWebListener != null) {
                MyWebView.this.mOnWebListener.webJsParame(str);
            }
        }

        @JavascriptInterface
        public void sendWebMsg(String str) {
            if (MyWebView.this.mActivity == null || MyWebView.this.mOnWebListener == null || TextUtils.isEmpty(str)) {
                return;
            }
            n1.b("sendWebMsg-->" + str);
            MyWebView.this.mOnWebListener.shouldIntercept(util.d2.c.b(str));
        }
    }

    public MyWebView(Context context) {
        super(getFixedContext(context));
        initWebView(this);
    }

    public static void cleanCache() {
        a1.c(Hicore.getApp());
        a1.a(Hicore.getApp());
    }

    public static Context getFixedContext(Context context) {
        return Build.VERSION.SDK_INT >= 17 ? context.createConfigurationContext(new Configuration()) : context;
    }

    public static String getH5Data() {
        HashMap map = new HashMap();
        map.put("deviceid", v1.l());
        String str = "0";
        map.put("os-version", "0");
        map.put("market", Hicore.getApp().getChannel());
        map.put("app-version", v1.o());
        map.put("app-version-code", v1.n() + "");
        if (BaseActivity.haveLiuhai) {
            str = BaseActivity.liuhaiHeight + "";
        }
        map.put("haveLiuhai", str);
        map.put("userid", AccountManager.getAccountId());
        map.put("pcode", RegionConfigHttp.getNodeRegionId());
        map.put("pname", RegionConfigHttp.getNodeRegionName());
        AccountInfo accountInfo = AccountManager.getAccountInfo();
        if (accountInfo != null) {
            if (!TextUtils.isEmpty(accountInfo.getPoliceUserID())) {
                map.put("policeuserid", accountInfo.getPoliceUserID());
            }
            if (!TextUtils.isEmpty(accountInfo.getPoliceUserPCode())) {
                map.put("pcode", accountInfo.getPoliceUserPCode());
            }
        }
        map.put("nodeId", RegionConfigHttp.getNodeRegionId());
        map.put("nodeCode", RegionConfigHttp.getNodeRegionId());
        map.put("nodeName", RegionConfigHttp.getNodeRegionName());
        map.put("nodeProvince", RegionConfigHttp.getNodeProvinceName());
        map.put("phoneNumber", accountInfo.getVisiblePhone());
        map.put("registerRegionName", AccountManager.getRegisterRegionName());
        map.put("registerRegionCode", AccountManager.getRegisterRegionCode());
        return new com.google.gson.e().a(map);
    }

    protected void initWebView(WebView webView) {
        setClickable(true);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new a(), "appjs");
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(true);
        settings.setGeolocationEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(-1);
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(m0.f16408b);
        settings.setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setTextZoom(100);
        settings.setMediaPlaybackRequiresUserGesture(false);
    }

    public void setListener(Activity activity, OnWebListener onWebListener) {
        this.mActivity = activity;
        this.mOnWebListener = onWebListener;
    }

    public void setSwipLayout(Activity activity, SwipBackLayout swipBackLayout) {
        this.mActivity = activity;
        this.mSwipBackLayout = swipBackLayout;
    }

    public MyWebView(Context context, AttributeSet attributeSet) {
        super(getFixedContext(context), attributeSet);
        initWebView(this);
    }

    public MyWebView(Context context, AttributeSet attributeSet, int i2) {
        super(getFixedContext(context), attributeSet, i2);
        initWebView(this);
    }
}
