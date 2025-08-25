package com.tencent.connect.auth;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.hms.api.ConnectionResult;
import com.tencent.connect.auth.b;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.h;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import util.r1;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private String f9542a;

    /* renamed from: b, reason: collision with root package name */
    private b f9543b;

    /* renamed from: c, reason: collision with root package name */
    private IUiListener f9544c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f9545d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f9546e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f9547f;

    /* renamed from: g, reason: collision with root package name */
    private FrameLayout f9548g;

    /* renamed from: h, reason: collision with root package name */
    private ProgressBar f9549h;

    /* renamed from: i, reason: collision with root package name */
    private String f9550i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.open.c.d f9551j;

    /* renamed from: k, reason: collision with root package name */
    private Context f9552k;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.open.web.security.b f9553l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f9554m;
    private int n;
    private String o;
    private String p;
    private long q;
    private long r;
    private HashMap<String, Runnable> s;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.a$a, reason: collision with other inner class name */
    private class C0125a extends WebViewClient {
        private C0125a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            a.this.f9548g.setVisibility(8);
            if (a.this.f9551j != null) {
                a.this.f9551j.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.this.f9545d.removeCallbacks((Runnable) a.this.s.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            a.this.f9548g.setVisibility(0);
            a.this.q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.o)) {
                a.this.f9545d.removeCallbacks((Runnable) a.this.s.remove(a.this.o));
            }
            a.this.o = str;
            a aVar = a.this;
            d dVar = aVar.new d(aVar.o);
            a.this.s.put(str, dVar);
            a.this.f9545d.postDelayed(dVar, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            SLog.i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i2 + " | description: " + str);
            if (!m.b(a.this.f9552k)) {
                a.this.f9543b.onError(new UiError(ConnectionResult.RESOLUTION_REQUIRED, "当前网络不可用，请稍后重试！", str2));
                a.this.dismiss();
                return;
            }
            if (a.this.o.startsWith("https://imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                a.this.f9543b.onError(new UiError(i2, str, str2));
                a.this.dismiss();
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.q;
            if (a.this.n >= 1 || jElapsedRealtime >= a.this.r) {
                a.this.f9551j.loadUrl(a.this.a());
            } else {
                a.m(a.this);
                a.this.f9545d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f9551j.loadUrl(a.this.o);
                    }
                }, 500L);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            SLog.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) throws JSONException {
            List<String> pathSegments;
            SLog.v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject jSONObjectC = m.c(str);
                a aVar = a.this;
                aVar.f9554m = aVar.e();
                if (!a.this.f9554m) {
                    if (jSONObjectC.optString("fail_cb", null) != null) {
                        a.this.a(jSONObjectC.optString("fail_cb"), "");
                    } else if (jSONObjectC.optInt("fall_to_wv") == 1) {
                        a aVar2 = a.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(a.this.f9542a);
                        sb.append(a.this.f9542a.indexOf("?") > -1 ? "&" : "?");
                        aVar2.f9542a = sb.toString();
                        a.this.f9542a = a.this.f9542a + "browser_error=1";
                        a.this.f9551j.loadUrl(a.this.f9542a);
                    } else {
                        String strOptString = jSONObjectC.optString("redir", null);
                        if (strOptString != null) {
                            a.this.f9551j.loadUrl(strOptString);
                        }
                    }
                }
                return true;
            }
            if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.f9543b.onComplete(m.c(str));
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                a.this.f9543b.onCancel();
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.DOWNLOAD_URI) || str.endsWith(r1.f20958d)) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(11))) : Uri.parse(Uri.decode(str)));
                    intent.addFlags(CommonNetImpl.FLAG_AUTH);
                    a.this.f9552k.startActivity(intent);
                } catch (Exception e2) {
                    SLog.e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e2);
                }
                return true;
            }
            if (!str.startsWith("auth://progress")) {
                if (str.startsWith("auth://onLoginSubmit")) {
                    try {
                        List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                        if (!pathSegments2.isEmpty()) {
                            a.this.p = pathSegments2.get(0);
                        }
                    } catch (Exception unused) {
                    }
                    return true;
                }
                if (a.this.f9553l.a(a.this.f9551j, str)) {
                    return true;
                }
                SLog.i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                return false;
            }
            try {
                pathSegments = Uri.parse(str).getPathSegments();
            } catch (Exception unused2) {
            }
            if (pathSegments.isEmpty()) {
                return true;
            }
            int iIntValue = Integer.valueOf(pathSegments.get(0)).intValue();
            if (iIntValue == 0) {
                a.this.f9548g.setVisibility(8);
                a.this.f9551j.setVisibility(0);
            } else if (iIntValue == 1) {
                a.this.f9548g.setVisibility(0);
            }
            return true;
        }
    }

    /* compiled from: ProGuard */
    private class b extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        String f9561a;

        /* renamed from: b, reason: collision with root package name */
        String f9562b;

        /* renamed from: d, reason: collision with root package name */
        private String f9564d;

        /* renamed from: e, reason: collision with root package name */
        private IUiListener f9565e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.f9564d = str;
            this.f9561a = str2;
            this.f9562b = str3;
            this.f9565e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f9565e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f9565e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h.a().a(this.f9564d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f9561a, false);
            IUiListener iUiListener = this.f9565e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f9565e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f9561a;
            } else {
                str = this.f9561a;
            }
            h.a().a(this.f9564d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            a.this.a(str);
            IUiListener iUiListener = this.f9565e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f9565e = null;
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
    private class c extends Handler {

        /* renamed from: b, reason: collision with root package name */
        private b f9567b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.f9567b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException {
            int i2 = message.what;
            if (i2 == 1) {
                this.f9567b.a((String) message.obj);
            } else if (i2 == 2) {
                this.f9567b.onCancel();
            } else {
                if (i2 != 3) {
                    return;
                }
                a.b(a.this.f9552k, (String) message.obj);
            }
        }
    }

    /* compiled from: ProGuard */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        String f9568a;

        public d(String str) {
            this.f9568a = "";
            this.f9568a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SLog.v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f9568a + " | mRetryUrl: " + a.this.o);
            if (this.f9568a.equals(a.this.o)) {
                a.this.f9543b.onError(new UiError(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, "请求页面超时，请稍后重试！", a.this.o));
                a.this.dismiss();
            }
        }
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f9554m = false;
        this.q = 0L;
        this.r = 30000L;
        this.f9552k = context;
        this.f9542a = str2;
        this.f9543b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.f9545d = new c(this.f9543b, context.getMainLooper());
        this.f9544c = iUiListener;
        this.f9550i = str;
        this.f9553l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    static /* synthetic */ int m(a aVar) {
        int i2 = aVar.n;
        aVar.n = i2 + 1;
        return i2;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.s.clear();
        this.f9545d.removeCallbacksAndMessages(null);
        try {
            if ((this.f9552k instanceof Activity) && !((Activity) this.f9552k).isFinishing() && isShowing()) {
                super.dismiss();
                SLog.i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e2);
        }
        com.tencent.open.c.d dVar = this.f9551j;
        if (dVar != null) {
            dVar.destroy();
            this.f9551j = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.f9554m) {
            this.f9543b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.tencent.open.a.a(getWindow());
        b();
        d();
        this.s = new HashMap<>();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        com.tencent.connect.auth.b bVarA = com.tencent.connect.auth.b.a();
        String strC = bVarA.c();
        b.a aVar = new b.a();
        aVar.f9575a = this.f9544c;
        aVar.f9576b = this;
        aVar.f9577c = strC;
        String strA = bVarA.a(aVar);
        String str = this.f9542a;
        String strSubstring = str.substring(0, str.indexOf("?"));
        Bundle bundleB = m.b(this.f9542a);
        bundleB.putString("token_key", strC);
        bundleB.putString("serial", strA);
        bundleB.putString("browser", "1");
        this.f9542a = strSubstring + "?" + HttpUtils.encodeUrl(bundleB);
        return m.a(this.f9552k, this.f9542a);
    }

    private void b() {
        try {
            c();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.f9551j = new com.tencent.open.c.d(this.f9552k);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f9551j.setLayerType(1, null);
            }
            this.f9551j.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.f9552k);
            cVar.setLayoutParams(layoutParams);
            cVar.addView(this.f9551j);
            this.f9546e = new FrameLayout(this.f9552k);
            this.f9546e.addView(cVar);
            this.f9546e.setBackgroundColor(-1);
            this.f9546e.addView(this.f9548g);
            String string = m.b(this.f9542a).getString("style");
            if (string != null && "qr".equals(string)) {
                a(this.f9546e);
            }
            setContentView(this.f9546e);
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.AuthDialog", "onCreateView exception", e2);
            com.tencent.open.a.a(this, this.f9545d);
        }
    }

    private void c() {
        TextView textView;
        this.f9549h = new ProgressBar(this.f9552k);
        this.f9549h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f9547f = new LinearLayout(this.f9552k);
        if (this.f9550i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.f9552k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f9547f.setLayoutParams(layoutParams2);
        this.f9547f.addView(this.f9549h);
        if (textView != null) {
            this.f9547f.addView(textView);
        }
        this.f9548g = new FrameLayout(this.f9552k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.f9548g.setLayoutParams(layoutParams3);
        this.f9548g.setBackgroundColor(Color.parseColor("#B3000000"));
        this.f9548g.addView(this.f9547f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.f9551j.setVerticalScrollBarEnabled(false);
        this.f9551j.setHorizontalScrollBarEnabled(false);
        this.f9551j.setWebViewClient(new C0125a());
        this.f9551j.setWebChromeClient(new WebChromeClient());
        this.f9551j.clearFormData();
        this.f9551j.clearSslPreferences();
        this.f9551j.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.f9551j.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.a.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        WebSettings settings = this.f9551j.getSettings();
        com.tencent.open.web.a.a(this.f9551j);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f9552k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        SLog.v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f9542a);
        String str = this.f9542a;
        this.o = str;
        this.f9551j.loadUrl(str);
        this.f9551j.setVisibility(4);
        this.f9553l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    if (JniInterface.isJniOk) {
                        JniInterface.clearAllPWD();
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.p) && this.p.length() >= 4) {
            String str2 = this.p;
            String strSubstring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(strSubstring);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        String str = this.f9542a;
        String str2 = "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        SLog.i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return str2;
    }

    private void a(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.f9552k);
        int iA = com.tencent.connect.avatar.a.a(this.f9552k, 15.6f);
        int iA2 = com.tencent.connect.avatar.a.a(this.f9552k, 25.2f);
        int iA3 = com.tencent.connect.avatar.a.a(this.f9552k, 10.0f);
        int i2 = iA3 * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA + i2, iA2 + i2);
        layoutParams.leftMargin = iA3;
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(iA3, iA3, iA3, iA3);
        imageView.setImageDrawable(m.a("h5_qr_back.png", this.f9552k));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.connect.auth.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                if (a.this.f9554m || a.this.f9543b == null) {
                    return;
                }
                a.this.f9543b.onCancel();
            }
        });
        viewGroup.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) throws JSONException {
        try {
            JSONObject jSONObjectD = m.d(str);
            int i2 = jSONObjectD.getInt("type");
            Toast.makeText(context.getApplicationContext(), jSONObjectD.getString("msg"), i2).show();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.f9551j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }
}
