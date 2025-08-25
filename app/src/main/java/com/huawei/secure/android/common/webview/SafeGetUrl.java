package com.huawei.secure.android.common.webview;

import android.webkit.WebView;
import com.huawei.secure.android.common.util.b;
import com.huawei.secure.android.common.util.c;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public class SafeGetUrl {

    /* renamed from: c, reason: collision with root package name */
    private static final String f7720c = "SafeGetUrl";

    /* renamed from: d, reason: collision with root package name */
    private static final long f7721d = 200;

    /* renamed from: a, reason: collision with root package name */
    private String f7722a;

    /* renamed from: b, reason: collision with root package name */
    private WebView f7723b;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f7724a;

        a(CountDownLatch countDownLatch) {
            this.f7724a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            SafeGetUrl safeGetUrl = SafeGetUrl.this;
            safeGetUrl.setUrl(safeGetUrl.f7723b.getUrl());
            this.f7724a.countDown();
        }
    }

    public SafeGetUrl() {
    }

    public String getUrlMethod() throws InterruptedException {
        if (this.f7723b == null) {
            return "";
        }
        if (b.a()) {
            return this.f7723b.getUrl();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c.a(new a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            String str = "getUrlMethod: InterruptedException " + e2.getMessage();
        }
        return this.f7722a;
    }

    public WebView getWebView() {
        return this.f7723b;
    }

    public void setUrl(String str) {
        this.f7722a = str;
    }

    public void setWebView(WebView webView) {
        this.f7723b = webView;
    }

    public SafeGetUrl(WebView webView) {
        this.f7723b = webView;
    }
}
