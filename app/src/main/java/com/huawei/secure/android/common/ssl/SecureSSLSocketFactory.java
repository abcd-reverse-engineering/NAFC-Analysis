package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
/* loaded from: classes.dex */
public class SecureSSLSocketFactory extends SSLSocketFactory {

    @Deprecated
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();

    @Deprecated
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: i, reason: collision with root package name */
    private static final String f7577i = SecureSSLSocketFactory.class.getSimpleName();

    /* renamed from: j, reason: collision with root package name */
    private static volatile SecureSSLSocketFactory f7578j = null;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f7579a;

    /* renamed from: b, reason: collision with root package name */
    private SSLSocket f7580b;

    /* renamed from: c, reason: collision with root package name */
    private Context f7581c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f7582d;

    /* renamed from: e, reason: collision with root package name */
    private X509TrustManager f7583e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f7584f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f7585g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f7586h;

    @Deprecated
    public SecureSSLSocketFactory(InputStream inputStream, String str) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.f7579a = null;
        this.f7580b = null;
        this.f7579a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f7579a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    @Deprecated
    static void a(X509TrustManager x509TrustManager) {
        e.c(f7577i, "ssf update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            f7578j = new SecureSSLSocketFactory(x509TrustManager);
        } catch (KeyManagementException unused) {
            e.b(f7577i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.b(f7577i, "NoSuchAlgorithmException");
        }
        e.a(f7577i, "update: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Deprecated
    public static SecureSSLSocketFactory getInstance(Context context) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f7578j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f7578j == null) {
                    f7578j = new SecureSSLSocketFactory(context, (SecureRandom) null);
                }
            }
        }
        if (f7578j.f7581c == null && context != null) {
            f7578j.setContext(context);
        }
        e.a(f7577i, "getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f7578j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        e.c(f7577i, "createSocket: host , port");
        Socket socketCreateSocket = this.f7579a.getSocketFactory().createSocket(str, i2);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f7580b = (SSLSocket) socketCreateSocket;
            this.f7582d = (String[]) this.f7580b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f7584f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f7583e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f7581c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f7586h;
    }

    public SSLContext getSslContext() {
        return this.f7579a;
    }

    public SSLSocket getSslSocket() {
        return this.f7580b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f7582d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f7585g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f7583e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f7584f = strArr;
    }

    public void setContext(Context context) {
        this.f7581c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f7586h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f7579a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f7585g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f7583e = x509TrustManager;
    }

    static void a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f7577i, "ssf update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            f7578j = new SecureSSLSocketFactory(x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            e.b(f7577i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.b(f7577i, "NoSuchAlgorithmException");
        }
        e.a(f7577i, "update: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    public SecureSSLSocketFactory(InputStream inputStream, String str, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.f7579a = null;
        this.f7580b = null;
        this.f7579a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f7579a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return createSocket(str, i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        e.c(f7577i, "createSocket s host port autoClose");
        Socket socketCreateSocket = this.f7579a.getSocketFactory().createSocket(socket, str, i2, z);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f7580b = (SSLSocket) socketCreateSocket;
            this.f7582d = (String[]) this.f7580b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public static SecureSSLSocketFactory getInstance(Context context, SecureRandom secureRandom) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f7578j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f7578j == null) {
                    f7578j = new SecureSSLSocketFactory(context, secureRandom);
                }
            }
        }
        if (f7578j.f7581c == null && context != null) {
            f7578j.setContext(context);
        }
        e.a(f7577i, "getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f7578j;
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f7586h)) {
            z = false;
        } else {
            e.c(f7577i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f7586h);
            z = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f7585g) && com.huawei.secure.android.common.ssl.util.a.a(this.f7584f)) {
            z2 = false;
        } else {
            e.c(f7577i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f7585g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f7585g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f7584f);
            }
        }
        if (!z) {
            e.c(f7577i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.c(f7577i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    private SecureSSLSocketFactory(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException {
        this.f7579a = null;
        this.f7580b = null;
        if (context == null) {
            e.b(f7577i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f7583e = SecureX509SingleInstance.getInstance(context);
        this.f7579a.init(null, new X509TrustManager[]{this.f7583e}, secureRandom);
    }

    @Deprecated
    public SecureSSLSocketFactory(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f7579a = null;
        this.f7580b = null;
        this.f7579a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f7579a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureSSLSocketFactory(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f7579a = null;
        this.f7580b = null;
        this.f7579a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f7579a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
