package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public abstract class c extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    protected b f9817a;

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"NewApi"})
    protected final WebChromeClient f9818b;

    public c(Context context, int i2) {
        super(context, i2);
        this.f9818b = new WebChromeClient() { // from class: com.tencent.open.c.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage == null) {
                    return false;
                }
                SLog.i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
                if (Build.VERSION.SDK_INT <= 7) {
                    return true;
                }
                c.this.a(consoleMessage == null ? "" : consoleMessage.message());
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i3, String str2) {
                SLog.i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i3 + " of " + str2);
                if (Build.VERSION.SDK_INT == 7) {
                    c.this.a(str);
                }
            }
        };
    }

    protected abstract void a(String str);

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9817a = new b();
    }
}
