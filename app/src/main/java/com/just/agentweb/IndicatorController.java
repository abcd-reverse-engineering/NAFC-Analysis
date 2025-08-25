package com.just.agentweb;

import android.webkit.WebView;

/* loaded from: classes.dex */
public interface IndicatorController {
    void finish();

    BaseIndicatorSpec offerIndicator();

    void progress(WebView webView, int i2);

    void setProgress(int i2);

    void showIndicator();
}
