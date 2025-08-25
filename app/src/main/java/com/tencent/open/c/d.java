package com.tencent.open.c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.log.SLog;
import com.tencent.open.web.security.SecureJsInterface;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class d extends b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9824a;

    /* renamed from: b, reason: collision with root package name */
    private KeyEvent f9825b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.open.web.security.a f9826c;

    public d(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f9824a);
        if (!f9824a) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode == 66) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode == 67) {
            com.tencent.open.web.security.a.f9952b = true;
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getUnicodeChar() == 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.f9825b = new KeyEvent(0, 17);
        return super.dispatchKeyEvent(this.f9825b);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        SLog.i("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        SLog.v("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + inputConnectionOnCreateInputConnection);
        if (inputConnectionOnCreateInputConnection == null) {
            f9824a = false;
            return inputConnectionOnCreateInputConnection;
        }
        f9824a = true;
        this.f9826c = new com.tencent.open.web.security.a(super.onCreateInputConnection(editorInfo), false);
        return this.f9826c;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f9824a);
        if (!f9824a) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (keyCode == 66) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (keyCode == 67) {
            com.tencent.open.web.security.a.f9952b = true;
            return super.onKeyDown(i2, keyEvent);
        }
        if (keyEvent.getUnicodeChar() == 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
            return super.onKeyDown(i2, keyEvent);
        }
        this.f9825b = new KeyEvent(0, 17);
        return super.onKeyDown(this.f9825b.getKeyCode(), this.f9825b);
    }
}
