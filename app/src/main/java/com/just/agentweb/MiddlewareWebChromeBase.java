package com.just.agentweb;

/* loaded from: classes.dex */
public class MiddlewareWebChromeBase extends WebChromeClientDelegate {
    private MiddlewareWebChromeBase mMiddlewareWebChromeBase;

    protected MiddlewareWebChromeBase(android.webkit.WebChromeClient webChromeClient) {
        super(webChromeClient);
    }

    final MiddlewareWebChromeBase enq(MiddlewareWebChromeBase middlewareWebChromeBase) {
        setDelegate(middlewareWebChromeBase);
        this.mMiddlewareWebChromeBase = middlewareWebChromeBase;
        return this.mMiddlewareWebChromeBase;
    }

    final MiddlewareWebChromeBase next() {
        return this.mMiddlewareWebChromeBase;
    }

    @Override // com.just.agentweb.WebChromeClientDelegate
    final void setDelegate(android.webkit.WebChromeClient webChromeClient) {
        super.setDelegate(webChromeClient);
    }

    protected MiddlewareWebChromeBase() {
        super(null);
    }
}
