package com.tencent.open.web.security;

import android.webkit.WebView;
import com.tencent.open.b;
import com.tencent.open.c.d;
import com.tencent.open.log.SLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class c extends b.a {

    /* renamed from: d, reason: collision with root package name */
    private String f9954d;

    public c(WebView webView, long j2, String str, String str2) {
        super(webView, j2, str);
        this.f9954d = str2;
    }

    private void b(String str) {
        WebView webView = this.f9780a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.f9954d);
            stringBuffer.append("){");
            stringBuffer.append(this.f9954d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String string = stringBuffer.toString();
            SLog.v("openSDK_LOG.SecureJsListener", "-->callback, callback: " + string);
            webView.loadUrl(string);
        }
    }

    @Override // com.tencent.open.b.a
    public void a(Object obj) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    @Override // com.tencent.open.b.a
    public void a() {
        SLog.d("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    @Override // com.tencent.open.b.a
    public void a(String str) throws JSONException {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", !d.f9824a ? -4 : 0);
            jSONObject.put("sn", this.f9781b);
            jSONObject.put("data", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        b(jSONObject.toString());
    }
}
