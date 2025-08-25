package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
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

/* loaded from: classes.dex */
public class SSFCompatiableSystemCA extends SSLSocketFactory {

    /* renamed from: i, reason: collision with root package name */
    private static final String f7547i = SSFCompatiableSystemCA.class.getSimpleName();

    /* renamed from: j, reason: collision with root package name */
    private static volatile SSFCompatiableSystemCA f7548j = null;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f7549a;

    /* renamed from: b, reason: collision with root package name */
    private SSLSocket f7550b;

    /* renamed from: c, reason: collision with root package name */
    private Context f7551c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f7552d;

    /* renamed from: e, reason: collision with root package name */
    private X509TrustManager f7553e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f7554f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f7555g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f7556h;

    private SSFCompatiableSystemCA(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException {
        this.f7549a = null;
        this.f7550b = null;
        if (context == null) {
            e.b(f7547i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f7553e = SSFSecureX509SingleInstance.getInstance(context);
        this.f7549a.init(null, new X509TrustManager[]{this.f7553e}, secureRandom);
    }

    @Deprecated
    static void a(X509TrustManager x509TrustManager) {
        e.c(f7547i, "ssfc update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            f7548j = new SSFCompatiableSystemCA(x509TrustManager);
        } catch (KeyManagementException unused) {
            e.b(f7547i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.b(f7547i, "NoSuchAlgorithmException");
        }
        e.a(f7547i, "SSF system ca update: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Deprecated
    public static SSFCompatiableSystemCA getInstance(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f7548j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (f7548j == null) {
                    f7548j = new SSFCompatiableSystemCA(context, (SecureRandom) null);
                }
            }
        }
        if (f7548j.f7551c == null && context != null) {
            f7548j.setContext(context);
        }
        return f7548j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        e.c(f7547i, "createSocket: host , port");
        Socket socketCreateSocket = this.f7549a.getSocketFactory().createSocket(str, i2);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f7550b = (SSLSocket) socketCreateSocket;
            this.f7552d = (String[]) this.f7550b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f7554f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f7553e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f7551c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f7556h;
    }

    public SSLContext getSslContext() {
        return this.f7549a;
    }

    public SSLSocket getSslSocket() {
        return this.f7550b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f7552d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f7555g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f7553e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f7554f = strArr;
    }

    public void setContext(Context context) {
        this.f7551c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f7556h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f7549a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f7555g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f7553e = x509TrustManager;
    }

    static void a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f7547i, "ssfc update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            f7548j = new SSFCompatiableSystemCA(x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            e.b(f7547i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.b(f7547i, "NoSuchAlgorithmException");
        }
        e.a(f7547i, "SSF system ca update: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return createSocket(str, i2);
    }

    @Deprecated
    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f7549a = null;
        this.f7550b = null;
        this.f7549a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f7549a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    public static SSFCompatiableSystemCA getInstance(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f7548j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (f7548j == null) {
                    f7548j = new SSFCompatiableSystemCA(context, secureRandom);
                }
            }
        }
        if (f7548j.f7551c == null && context != null) {
            f7548j.setContext(context);
        }
        return f7548j;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        e.c(f7547i, "createSocket: s , host , port , autoClose");
        Socket socketCreateSocket = this.f7549a.getSocketFactory().createSocket(socket, str, i2, z);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f7550b = (SSLSocket) socketCreateSocket;
            this.f7552d = (String[]) this.f7550b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f7556h)) {
            z = false;
        } else {
            e.c(f7547i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f7556h);
            z = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f7555g) && com.huawei.secure.android.common.ssl.util.a.a(this.f7554f)) {
            z2 = false;
        } else {
            e.c(f7547i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f7555g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f7555g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f7554f);
            }
        }
        if (!z) {
            e.c(f7547i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.c(f7547i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f7549a = null;
        this.f7550b = null;
        this.f7549a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f7549a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
