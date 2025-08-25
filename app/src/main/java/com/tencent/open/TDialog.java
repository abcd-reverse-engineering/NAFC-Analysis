package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.b;
import com.tencent.open.b.h;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.j;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import util.r1;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class TDialog extends c {

    /* renamed from: c, reason: collision with root package name */
    static final FrameLayout.LayoutParams f9733c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d, reason: collision with root package name */
    static Toast f9734d = null;

    /* renamed from: f, reason: collision with root package name */
    private static WeakReference<ProgressDialog> f9735f;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Context> f9736e;

    /* renamed from: g, reason: collision with root package name */
    private String f9737g;

    /* renamed from: h, reason: collision with root package name */
    private OnTimeListener f9738h;

    /* renamed from: i, reason: collision with root package name */
    private IUiListener f9739i;

    /* renamed from: j, reason: collision with root package name */
    private FrameLayout f9740j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.open.c.b f9741k;

    /* renamed from: l, reason: collision with root package name */
    private Handler f9742l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f9743m;
    private QQToken n;

    /* compiled from: ProGuard */
    private class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.f9741k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            TDialog.this.f9738h.onError(new UiError(i2, str, str2));
            if (TDialog.this.f9736e != null && TDialog.this.f9736e.get() != null) {
                Toast.makeText((Context) TDialog.this.f9736e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(j.a().a((Context) TDialog.this.f9736e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f9738h.onComplete(m.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f9738h.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(r1.f20958d)) {
                return str.startsWith("auth://progress");
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(11))) : Uri.parse(Uri.decode(str)));
                intent.addFlags(CommonNetImpl.FLAG_AUTH);
                if (TDialog.this.f9736e != null && TDialog.this.f9736e.get() != null) {
                    ((Context) TDialog.this.f9736e.get()).startActivity(intent);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        }
    }

    /* compiled from: ProGuard */
    private class JsListener extends b.C0130b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            SLog.d("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.f9742l.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel(CommonNetImpl.CANCEL);
        }

        public void onCancelInvite() {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.f9742l.obtainMessage(1, str).sendToTarget();
            SLog.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.f9742l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.f9742l.obtainMessage(3, str).sendToTarget();
        }
    }

    /* compiled from: ProGuard */
    private static class OnTimeListener extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        String f9747a;

        /* renamed from: b, reason: collision with root package name */
        String f9748b;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<Context> f9749c;

        /* renamed from: d, reason: collision with root package name */
        private String f9750d;

        /* renamed from: e, reason: collision with root package name */
        private IUiListener f9751e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f9749c = new WeakReference<>(context);
            this.f9750d = str;
            this.f9747a = str2;
            this.f9748b = str3;
            this.f9751e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f9751e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f9751e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h.a().a(this.f9750d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f9747a, false);
            IUiListener iUiListener = this.f9751e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f9751e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f9747a;
            } else {
                str = this.f9747a;
            }
            h hVarA = h.a();
            hVarA.a(this.f9750d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f9751e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f9751e = null;
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
    private class THandler extends Handler {

        /* renamed from: b, reason: collision with root package name */
        private OnTimeListener f9753b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f9753b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException {
            SLog.d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.f9753b.a((String) message.obj);
                return;
            }
            if (i2 == 2) {
                this.f9753b.onCancel();
                return;
            }
            if (i2 == 3) {
                if (TDialog.this.f9736e == null || TDialog.this.f9736e.get() == null) {
                    return;
                }
                TDialog.c((Context) TDialog.this.f9736e.get(), (String) message.obj);
                return;
            }
            if (i2 == 4 || i2 != 5 || TDialog.this.f9736e == null || TDialog.this.f9736e.get() == null) {
                return;
            }
            TDialog.d((Context) TDialog.this.f9736e.get(), (String) message.obj);
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f9743m = false;
        this.n = null;
        this.f9736e = new WeakReference<>(context);
        this.f9737g = str2;
        this.f9738h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f9742l = new THandler(this.f9738h, context.getMainLooper());
        this.f9739i = iUiListener;
        this.n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f9738h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.c, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a.a(getWindow());
        a();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.TDialog.1
            @Override // java.lang.Runnable
            public void run() {
                View decorView;
                View childAt;
                Window window = TDialog.this.getWindow();
                if (window == null || (decorView = window.getDecorView()) == null || (childAt = ((ViewGroup) decorView).getChildAt(0)) == null) {
                    return;
                }
                childAt.setPadding(0, 0, 0, 0);
            }
        });
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) throws JSONException {
        try {
            JSONObject jSONObjectD = m.d(str);
            int i2 = jSONObjectD.getInt("type");
            String string = jSONObjectD.getString("msg");
            if (i2 == 0) {
                if (f9734d == null) {
                    f9734d = Toast.makeText(context, string, 0);
                } else {
                    f9734d.setView(f9734d.getView());
                    f9734d.setText(string);
                    f9734d.setDuration(0);
                }
                f9734d.show();
                return;
            }
            if (i2 == 1) {
                if (f9734d == null) {
                    f9734d = Toast.makeText(context, string, 1);
                } else {
                    f9734d.setView(f9734d.getView());
                    f9734d.setText(string);
                    f9734d.setDuration(1);
                }
                f9734d.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) throws JSONException {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject jSONObjectD = m.d(str);
            int i2 = jSONObjectD.getInt("action");
            String string = jSONObjectD.getString("msg");
            if (i2 == 1) {
                if (f9735f == null || f9735f.get() == null) {
                    ProgressDialog progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage(string);
                    f9735f = new WeakReference<>(progressDialog);
                    progressDialog.show();
                } else {
                    f9735f.get().setMessage(string);
                    if (!f9735f.get().isShowing()) {
                        f9735f.get().show();
                    }
                }
            } else if (i2 == 0) {
                if (f9735f == null) {
                    return;
                }
                if (f9735f.get() != null && f9735f.get().isShowing()) {
                    f9735f.get().dismiss();
                    f9735f = null;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a() {
        try {
            new TextView(this.f9736e.get()).setText(a.a.u.a.n);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.f9741k = new com.tencent.open.c.b(this.f9736e.get());
            this.f9741k.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            this.f9740j = new com.tencent.open.c.c(this.f9736e.get());
            this.f9740j.setLayoutParams(layoutParams);
            this.f9740j.setBackgroundColor(-1);
            this.f9740j.addView(this.f9741k);
            setContentView(this.f9740j);
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.TDialog", "onCreateView exception", th);
            a.a(this, this.f9742l);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.f9741k.setVerticalScrollBarEnabled(false);
        this.f9741k.setHorizontalScrollBarEnabled(false);
        this.f9741k.setWebViewClient(new FbWebViewClient());
        this.f9741k.setWebChromeClient(this.f9818b);
        this.f9741k.clearFormData();
        WebSettings settings = this.f9741k.getSettings();
        if (settings == null) {
            return;
        }
        com.tencent.open.web.a.a(this.f9741k);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.f9736e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f9736e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f9817a.a(new JsListener(), "sdk_js_if");
        this.f9741k.loadUrl(this.f9737g);
        this.f9741k.setLayoutParams(f9733c);
        this.f9741k.setVisibility(4);
    }

    @Override // com.tencent.open.c
    protected void a(String str) {
        SLog.d("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f9817a.a(this.f9741k, str);
        } catch (Exception unused) {
        }
    }
}
