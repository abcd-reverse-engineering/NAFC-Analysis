package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import anet.channel.util.HttpConstant;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.huawei.secure.android.common.ssl.util.d;
import com.huawei.secure.android.common.ssl.util.e;
import com.taobao.accs.common.Constants;
import com.tencent.bugly.BuglyStrategy;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* loaded from: classes.dex */
public class WebViewSSLCheckThread extends Thread {

    /* renamed from: i, reason: collision with root package name */
    private static final String f7608i = WebViewSSLCheckThread.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f7609a;

    /* renamed from: b, reason: collision with root package name */
    private HostnameVerifier f7610b;

    /* renamed from: c, reason: collision with root package name */
    private org.apache.http.conn.ssl.SSLSocketFactory f7611c;

    /* renamed from: d, reason: collision with root package name */
    private X509HostnameVerifier f7612d;

    /* renamed from: e, reason: collision with root package name */
    private SslErrorHandler f7613e;

    /* renamed from: f, reason: collision with root package name */
    private String f7614f;

    /* renamed from: g, reason: collision with root package name */
    private Callback f7615g;

    /* renamed from: h, reason: collision with root package name */
    private Context f7616h;

    public interface Callback {
        void onCancel(Context context, String str);

        void onProceed(Context context, String str);
    }

    static class a implements okhttp3.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callback f7617a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f7618b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7619c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f7620d;

        a(Callback callback, Context context, String str, SslErrorHandler sslErrorHandler) {
            this.f7617a = callback;
            this.f7618b = context;
            this.f7619c = str;
            this.f7620d = sslErrorHandler;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            e.b(WebViewSSLCheckThread.f7608i, "onFailure , IO Exception : " + iOException.getMessage());
            Callback callback = this.f7617a;
            if (callback != null) {
                callback.onCancel(this.f7618b, this.f7619c);
            } else {
                this.f7620d.cancel();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            e.b(WebViewSSLCheckThread.f7608i, "onResponse . proceed");
            Callback callback = this.f7617a;
            if (callback != null) {
                callback.onProceed(this.f7618b, this.f7619c);
            } else {
                this.f7620d.proceed();
            }
        }
    }

    public WebViewSSLCheckThread() {
    }

    private void b() {
        e.c(f7608i, "callbackCancel: ");
        Callback callback = this.f7615g;
        if (callback != null) {
            callback.onCancel(this.f7616h, this.f7614f);
        } else if (this.f7613e != null) {
            e.c(f7608i, "callbackCancel 2: ");
            this.f7613e.cancel();
        }
    }

    private void c() {
        e.c(f7608i, "callbackProceed: ");
        Callback callback = this.f7615g;
        if (callback != null) {
            callback.onProceed(this.f7616h, this.f7614f);
            return;
        }
        SslErrorHandler sslErrorHandler = this.f7613e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context) {
        checkServerCertificateWithOK(sslErrorHandler, str, context, null);
    }

    public X509HostnameVerifier getApacheHostnameVerifier() {
        return this.f7612d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.f7611c;
    }

    public Callback getCallback() {
        return this.f7615g;
    }

    public Context getContext() {
        return this.f7616h;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f7610b;
    }

    public SslErrorHandler getSslErrorHandler() {
        return this.f7613e;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f7609a;
    }

    public String getUrl() {
        return this.f7614f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [javax.net.ssl.HostnameVerifier] */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        Exception e2;
        HttpsURLConnection httpsURLConnection;
        super.run();
        if (this.f7611c != null && this.f7612d != null) {
            if (this.f7613e != null) {
                try {
                    if (!TextUtils.isEmpty(this.f7614f)) {
                        try {
                            this.f7611c.setHostnameVerifier(this.f7612d);
                            if (this.f7611c instanceof SecureApacheSSLSocketFactory) {
                                ((SecureApacheSSLSocketFactory) this.f7611c).setContext(this.f7616h);
                            }
                            BasicHttpParams basicHttpParams = new BasicHttpParams();
                            HttpConnectionParams.setConnectionTimeout(basicHttpParams, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                            HttpConnectionParams.setSoTimeout(basicHttpParams, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                            SchemeRegistry schemeRegistry = new SchemeRegistry();
                            schemeRegistry.register(new Scheme(HttpConstant.HTTPS, this.f7611c, Constants.PORT));
                            schemeRegistry.register(new Scheme(HttpConstant.HTTP, PlainSocketFactory.getSocketFactory(), 80));
                            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                            HttpGet httpGet = new HttpGet();
                            httpGet.setURI(new URI(this.f7614f));
                            HttpResponse httpResponseExecute = defaultHttpClient.execute(httpGet);
                            e.c(f7608i, "status code is : " + httpResponseExecute.getStatusLine().getStatusCode());
                            d.a((Reader) null);
                            c();
                            return;
                        } catch (Exception e3) {
                            e.b(f7608i, "run: exception : " + e3.getMessage());
                            b();
                            d.a((Reader) null);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    d.a((Reader) null);
                    throw th;
                }
            }
            e.b(f7608i, "sslErrorHandler or url is null");
            b();
            return;
        }
        if (this.f7609a != null) {
            HttpsURLConnection httpsURLConnection2 = this.f7610b;
            try {
                if (httpsURLConnection2 != 0) {
                    try {
                        URLConnection uRLConnectionOpenConnection = new URL(this.f7614f).openConnection();
                        if (uRLConnectionOpenConnection instanceof HttpsURLConnection) {
                            httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                            try {
                                httpsURLConnection.setSSLSocketFactory(this.f7609a);
                                httpsURLConnection.setHostnameVerifier(this.f7610b);
                                httpsURLConnection.setRequestMethod("GET");
                                httpsURLConnection.setConnectTimeout(10000);
                                httpsURLConnection.setReadTimeout(20000);
                                httpsURLConnection.connect();
                            } catch (Exception e4) {
                                e2 = e4;
                                e.b(f7608i, "exception : " + e2.getMessage());
                                b();
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                        } else {
                            httpsURLConnection = null;
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        c();
                        return;
                    } catch (Exception e5) {
                        e2 = e5;
                        httpsURLConnection = null;
                    } catch (Throwable th2) {
                        th = th2;
                        httpsURLConnection2 = 0;
                        if (httpsURLConnection2 != 0) {
                            httpsURLConnection2.disconnect();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        b();
    }

    public void setApacheHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.f7612d = x509HostnameVerifier;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.f7611c = sSLSocketFactory;
    }

    public void setCallback(Callback callback) {
        this.f7615g = callback;
    }

    public void setContext(Context context) {
        this.f7616h = context;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f7610b = hostnameVerifier;
    }

    public void setSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.f7613e = sslErrorHandler;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f7609a = sSLSocketFactory;
    }

    public void setUrl(String str) {
        this.f7614f = str;
    }

    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, Context context) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyManagementException, KeyStoreException {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setContext(context);
        setSslSocketFactory(new SecureSSLSocketFactoryNew(new c(context)));
        setHostnameVerifier(new StrictHostnameVerifier());
        try {
            setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory(null, new c(context)));
        } catch (UnrecoverableKeyException e2) {
            e.b(f7608i, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e2.getMessage());
        }
        setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context, Callback callback) {
        if (sslErrorHandler == null || TextUtils.isEmpty(str) || context == null) {
            e.b(f7608i, "checkServerCertificateWithOK: handler or url or context is null");
            return;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            SecureSSLSocketFactoryNew secureSSLSocketFactoryNew = new SecureSSLSocketFactoryNew(new c(context));
            secureSSLSocketFactoryNew.setContext(context);
            builder.sslSocketFactory(secureSSLSocketFactoryNew, new c(context));
            builder.hostnameVerifier(new StrictHostnameVerifier());
            builder.build().newCall(new Request.Builder().url(str).build()).enqueue(new a(callback, context, str, sslErrorHandler));
        } catch (Exception e2) {
            e.b(f7608i, "checkServerCertificateWithOK: exception : " + e2.getMessage());
            sslErrorHandler.cancel();
        }
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setSslSocketFactory(sSLSocketFactory);
        setHostnameVerifier(hostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setApacheSSLSocketFactory(sSLSocketFactory);
        setApacheHostnameVerifier(x509HostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, Callback callback, Context context) {
        this.f7613e = sslErrorHandler;
        this.f7614f = str;
        this.f7611c = sSLSocketFactory;
        this.f7612d = x509HostnameVerifier;
        this.f7615g = callback;
        this.f7616h = context;
    }
}
