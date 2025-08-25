package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.b;
import com.tencent.open.b.h;
import com.tencent.open.c.a;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.j;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class d extends com.tencent.open.c implements a.InterfaceC0131a {

    /* renamed from: c, reason: collision with root package name */
    static Toast f9827c;

    /* renamed from: d, reason: collision with root package name */
    private String f9828d;

    /* renamed from: e, reason: collision with root package name */
    private IUiListener f9829e;

    /* renamed from: f, reason: collision with root package name */
    private c f9830f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f9831g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.open.c.a f9832h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.open.c.b f9833i;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<Context> f9834j;

    /* renamed from: k, reason: collision with root package name */
    private int f9835k;

    /* compiled from: ProGuard */
    private class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            d.this.f9833i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            d.this.f9830f.onError(new UiError(i2, str, str2));
            if (d.this.f9834j != null && d.this.f9834j.get() != null) {
                Toast.makeText((Context) d.this.f9834j.get(), "网络连接异常或系统错误", 0).show();
            }
            d.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(j.a().a((Context) d.this.f9834j.get(), "auth://tauth.qq.com/"))) {
                d.this.f9830f.onComplete(m.c(str));
                d.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                d.this.f9830f.onCancel();
                d.this.dismiss();
                return true;
            }
            if (!str.startsWith(Constants.CLOSE_URI)) {
                return false;
            }
            d.this.dismiss();
            return true;
        }
    }

    /* compiled from: ProGuard */
    private class b extends b.C0130b {
        private b() {
        }
    }

    /* compiled from: ProGuard */
    private static class c extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        String f9838a;

        /* renamed from: b, reason: collision with root package name */
        String f9839b;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<Context> f9840c;

        /* renamed from: d, reason: collision with root package name */
        private String f9841d;

        /* renamed from: e, reason: collision with root package name */
        private IUiListener f9842e;

        public c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f9840c = new WeakReference<>(context);
            this.f9841d = str;
            this.f9838a = str2;
            this.f9839b = str3;
            this.f9842e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f9842e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f9842e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h.a().a(this.f9841d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f9838a, false);
            IUiListener iUiListener = this.f9842e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f9842e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f9838a;
            } else {
                str = this.f9838a;
            }
            h hVarA = h.a();
            hVarA.a(this.f9841d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f9842e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f9842e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            try {
                onComplete(m.d(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.d$d, reason: collision with other inner class name */
    private class HandlerC0132d extends Handler {

        /* renamed from: b, reason: collision with root package name */
        private c f9844b;

        public HandlerC0132d(c cVar, Looper looper) {
            super(looper);
            this.f9844b = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException {
            SLog.d("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.f9844b.a((String) message.obj);
                return;
            }
            if (i2 == 2) {
                this.f9844b.onCancel();
                return;
            }
            if (i2 == 3) {
                if (d.this.f9834j == null || d.this.f9834j.get() == null) {
                    return;
                }
                d.c((Context) d.this.f9834j.get(), (String) message.obj);
                return;
            }
            if (i2 == 4 || i2 != 5 || d.this.f9834j == null || d.this.f9834j.get() == null) {
                return;
            }
            d.d((Context) d.this.f9834j.get(), (String) message.obj);
        }
    }

    public d(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f9834j = new WeakReference<>(context);
        this.f9828d = str2;
        this.f9830f = new c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f9831g = new HandlerC0132d(this.f9830f, context.getMainLooper());
        this.f9829e = iUiListener;
        this.f9835k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        SLog.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.f9835k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) throws JSONException {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject jSONObjectD = m.d(str);
            jSONObjectD.getInt("action");
            jSONObjectD.getString("msg");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.c, android.app.Dialog
    protected void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.f9833i.setVerticalScrollBarEnabled(false);
        this.f9833i.setHorizontalScrollBarEnabled(false);
        this.f9833i.setWebViewClient(new a());
        this.f9833i.setWebChromeClient(this.f9818b);
        this.f9833i.clearFormData();
        WebSettings settings = this.f9833i.getSettings();
        if (settings == null) {
            return;
        }
        com.tencent.open.web.a.a(this.f9833i);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.f9834j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f9834j.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f9817a.a(new b(), "sdk_js_if");
        this.f9833i.clearView();
        this.f9833i.loadUrl(this.f9828d);
    }

    private void b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f9832h = new com.tencent.open.c.a(this.f9834j.get());
        this.f9832h.setBackgroundColor(1711276032);
        this.f9832h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f9833i = new com.tencent.open.c.b(this.f9834j.get());
        this.f9833i.setBackgroundColor(0);
        this.f9833i.setBackgroundDrawable(null);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f9833i, 1, new Paint());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f9835k);
        layoutParams.addRule(13, -1);
        this.f9833i.setLayoutParams(layoutParams);
        this.f9832h.addView(this.f9833i);
        this.f9832h.a(this);
        setContentView(this.f9832h);
    }

    @Override // com.tencent.open.c.a.InterfaceC0131a
    public void a(int i2) {
        WeakReference<Context> weakReference = this.f9834j;
        if (weakReference != null && weakReference.get() != null) {
            if (i2 < this.f9835k && 2 == this.f9834j.get().getResources().getConfiguration().orientation) {
                this.f9833i.getLayoutParams().height = i2;
            } else {
                this.f9833i.getLayoutParams().height = this.f9835k;
            }
        }
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.c.a.InterfaceC0131a
    public void a() {
        this.f9833i.getLayoutParams().height = this.f9835k;
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.c
    protected void a(String str) {
        SLog.d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.f9817a.a(this.f9833i, str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) throws JSONException {
        try {
            JSONObject jSONObjectD = m.d(str);
            int i2 = jSONObjectD.getInt("type");
            String string = jSONObjectD.getString("msg");
            if (i2 == 0) {
                if (f9827c == null) {
                    f9827c = Toast.makeText(context, string, 0);
                } else {
                    f9827c.setView(f9827c.getView());
                    f9827c.setText(string);
                    f9827c.setDuration(0);
                }
                f9827c.show();
                return;
            }
            if (i2 == 1) {
                if (f9827c == null) {
                    f9827c = Toast.makeText(context, string, 1);
                } else {
                    f9827c.setView(f9827c.getView());
                    f9827c.setText(string);
                    f9827c.setDuration(1);
                }
                f9827c.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
